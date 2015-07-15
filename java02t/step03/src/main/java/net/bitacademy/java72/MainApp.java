package net.bitacademy.java72;

import static org.reflections.ReflectionUtils.getMethods;
import static org.reflections.ReflectionUtils.withAnnotation;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import net.bitacademy.java72.annotation.RequestMapping;
import net.bitacademy.java72.context.ApplicationContext;

public class MainApp {
  static Scanner scanner;
  static ApplicationContext appContext;
  
  @SuppressWarnings("unchecked")
  public static void main(String[] args) {
    scanner = new Scanner(System.in);
    appContext = new ApplicationContext(
        "net.bitacademy.java72");
    
    prepareMybatis();
    
    String command = null;
    Object commandWorker = null;
    
    do {
      try {
        System.out.print("명령> ");
        command = scanner.nextLine().toLowerCase();
        
        HashMap<String,Object> paramMap = 
            new HashMap<String,Object>();
        paramMap.put("inputScanner", scanner);
      
        commandWorker = appContext.getBean(command);
        Set<Method> methods = null;
        Method temp = null;
        if (commandWorker != null) {
          //@RequestMapping이 붙어있는 메서드를 찾아서 호출한다.
          methods = getMethods(
              commandWorker.getClass(), 
              withAnnotation(RequestMapping.class));
          temp = (Method)methods.toArray()[0];
          temp.invoke(commandWorker, paramMap);
        } else {
          System.out.println("해당 명령을 지원하지 않습니다!");
        }
      } catch (Exception e) {
        System.out.println("명령어 실행 중 오류 발생!");
      }
      
    } while (!command.toLowerCase().equals("quit"));
    
    scanner.close();
  }

  

  private static void prepareMybatis() {
    try {
      String resource = "net/bitacademy/java72/dao/mybatis-config.xml";
      InputStream inputStream = Resources.getResourceAsStream(resource);
      SqlSessionFactory sqlSessionFactory = 
          new SqlSessionFactoryBuilder().build(inputStream);
      
      appContext.addBean("sqlSessionFactory", 
          sqlSessionFactory);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}









