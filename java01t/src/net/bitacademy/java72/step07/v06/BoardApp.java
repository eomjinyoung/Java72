package net.bitacademy.java72.step07.v06;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import net.bitacademy.java72.step07.v02.BoardDao;
import net.bitacademy.java72.step07.v04.Command;

public class BoardApp {
  static Scanner scanner;
  static BoardDao boardDao;
  
  public static void main(String[] args) {
    scanner = new Scanner(System.in);
    String command = null;
    
    HashMap<String,Command> commandMap = 
        new HashMap<String,Command>();
    
    try {
      // mybatis 설정 파일이 있는 경로를 지정한다.
      String resource = "net/bitacademy/java72/step07/v02/mybatis-config.xml";
      // 위에서 가리키는 경로에서 mybatis 설정 파일을 읽을 도구를 준비한다.
      InputStream inputStream = Resources.getResourceAsStream(resource);
      // mybatis 설정 파일에 맞추어 SqlSessionFactory를 준비한다.
      SqlSessionFactory sqlSessionFactory = 
          new SqlSessionFactoryBuilder().build(inputStream);
    
      boardDao = new BoardDao();
      boardDao.setSqlSessionFactory(sqlSessionFactory); // 의존 객체 주입

      // 1) application-context.properties 파일을 읽어들인다.
      Properties props = new Properties();
      props.load(Resources.getResourceAsStream(
          "net/bitacademy/java72/step07"
          + "/v06/application-context.properties"));
      
      // 2) 각 프로퍼티(key=value)의 값을 꺼내 클래스를 로딩한다.
      Class<?> clazz = null;
      Object obj = null;
      Method method = null;
      
      for (Entry<Object, Object> entry : props.entrySet()) {
        clazz = Class.forName((String)entry.getValue());
        // 3) 로딩한 클래스를 가지고 인스턴스를 생성한다.
        obj = clazz.newInstance();
        // 4) 클래스에 setBoardDao()가 있는 경우 
        //    BoardDao 의존 객체를 주입한다.
        try {
          method = clazz.getMethod(
            "setBoardDao", BoardDao.class);
          method.invoke(obj, boardDao);
        } catch (Exception e) {}
        
        // 5) 인스턴스를 key로 commandMap에 보관한다.
        commandMap.put(
            (String)entry.getKey(), (Command)obj);
      }
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    
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

  

  


}









