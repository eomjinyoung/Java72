package net.bitacademy.java72.step07.v07;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.reflections.ReflectionUtils;
import org.reflections.Reflections;

import net.bitacademy.java72.step07.v02.BoardDao;

public class BoardApp {
  static Scanner scanner;
  static BoardDao boardDao;
  static HashMap<String,Object> commandMap;
  
  public static void main(String[] args) {
    scanner = new Scanner(System.in);
    commandMap = new HashMap<String,Object>();
    
    prepareMybatis();
    prepareCommandFromAnnotation();
    
    String command = null;
    Object commandWorker = null;
    
    do {
      System.out.print("명령> ");
      command = scanner.nextLine().toLowerCase();
      
      HashMap<String,Object> paramMap = 
          new HashMap<String,Object>();
      paramMap.put("inputScanner", scanner);
      
      commandWorker = commandMap.get(command);
      Set<Method> methods = null;
      Method temp = null;
      if (commandWorker != null) {
        //@RequestMapping이 붙어있는 메서드를 찾아서 호출한다.
        methods = ReflectionUtils.getMethods(
            commandWorker.getClass(), 
            ReflectionUtils.withAnnotation(RequestMapping.class));
        temp = (Method)methods.toArray()[0];
        try {
          temp.invoke(commandWorker, paramMap);
        } catch (Exception e) {
          System.out.println("명령어 실행 중 오류 발생!");
        }
      } else {
        System.out.println("해당 명령을 지원하지 않습니다!");
      }
      
    } while (!command.toLowerCase().equals("quit"));
    
    scanner.close();
  }

  private static void prepareMybatis() {
    try {
      String resource = "net/bitacademy/java72/step07/v02/mybatis-config.xml";
      InputStream inputStream = Resources.getResourceAsStream(resource);
      SqlSessionFactory sqlSessionFactory = 
          new SqlSessionFactoryBuilder().build(inputStream);
    
      boardDao = new BoardDao();
      boardDao.setSqlSessionFactory(sqlSessionFactory); // 의존 객체 주입
    
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  private static void prepareCommandFromAnnotation() {
    try {
      Reflections reflections = new Reflections(
          "net.bitacademy.java72.step07.v07");
      
      Set<Class<?>> commands = 
          reflections.getTypesAnnotatedWith(
              CommandProcessor.class);
      
      Object obj = null;
      CommandProcessor anno = null;
      for (Class<?> clazz : commands) {
        obj = createInstance(clazz);
        anno = clazz.getAnnotation(
            CommandProcessor.class);
        commandMap.put(anno.value(), obj);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static Object createInstance(Class<?> clazz) 
      throws Exception {
    Object obj = clazz.newInstance();
    
    Method method = null;
    try {
      method = clazz.getMethod(
        "setBoardDao", BoardDao.class);
      method.invoke(obj, boardDao);
    } catch (Exception e) {}
    
    return obj;
  }
  


}









