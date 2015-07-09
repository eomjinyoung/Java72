package net.bitacademy.java72.step07.v04;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import net.bitacademy.java72.step07.v02.Board;
import net.bitacademy.java72.step07.v02.BoardDao;

public class BoardApp {
  static Scanner scanner;
  static BoardDao boardDao;
  
  public static void main(String[] args) {
    scanner = new Scanner(System.in);
    String command = null;
    
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

    } catch (Exception e) {
      e.printStackTrace();
    }
    
    HashMap<String,Command> commandMap = 
        new HashMap<String,Command>();
        
    BoardList boardList = new BoardList();
    boardList.setBoardDao(boardDao);
    commandMap.put("list", boardList);
    
    Quit quit = new Quit();
    commandMap.put("quit", quit);
    
    BoardDelete delete = new BoardDelete();
    delete.setBoardDao(boardDao);
    commandMap.put("delete", delete);
    
    BoardUpdate update = new BoardUpdate();
    update.setBoardDao(boardDao);
    commandMap.put("update", update);
    
    BoardInsert insert = new BoardInsert();
    insert.setBoardDao(boardDao);
    commandMap.put("insert", insert);
    
    Hello hello = new Hello();
    commandMap.put("hello", hello);
    
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









