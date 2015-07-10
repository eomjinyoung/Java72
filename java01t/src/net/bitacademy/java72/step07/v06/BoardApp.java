package net.bitacademy.java72.step07.v06;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.reflections.Reflections;

import net.bitacademy.java72.step07.v02.BoardDao;
import net.bitacademy.java72.step07.v04.Command;

public class BoardApp {
  static Scanner scanner;
  static BoardDao boardDao;
  static HashMap<String,Command> commandMap;
  
  public static void main(String[] args) {
    scanner = new Scanner(System.in);
    commandMap = new HashMap<String,Command>();
    
    prepareMybatis();
    
    prepareCommandFromProperties();
    
    prepareCommandFromAnnotation();
    
    String command = null;

    do {
      System.out.print("명령> ");
      command = scanner.nextLine().toLowerCase();
      
      HashMap<String,Object> paramMap = 
          new HashMap<String,Object>();
      paramMap.put("inputScanner", scanner);
      
      Command commandWorker = commandMap.get(command);
      
      if (commandWorker != null) {
        commandWorker.execute(paramMap);
        
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
  
  private static void prepareCommandFromProperties() {
    try {
      Properties props = new Properties();
      props.load(Resources.getResourceAsStream(
          "net/bitacademy/java72/step07"
          + "/v06/application-context.properties"));
      
      Class<?> clazz = null;
      Object obj = null;
      
      for (Entry<Object, Object> entry : props.entrySet()) {
        clazz = Class.forName((String)entry.getValue());
        obj = createInstance(clazz);
        commandMap.put(
            (String)entry.getKey(), (Command)obj);
      }
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  private static void prepareCommandFromAnnotation() {
    try {
      Reflections reflections = new Reflections(
          "net.bitacademy.java72.step07.v06");
      
      Set<Class<?>> commands = 
          reflections.getTypesAnnotatedWith(
              CommandProcessor.class);
      
      Object obj = null;
      CommandProcessor anno = null;
      for (Class<?> clazz : commands) {
        obj = createInstance(clazz);
        anno = clazz.getAnnotation(
            CommandProcessor.class);
        commandMap.put(anno.value(), (Command)obj);
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









