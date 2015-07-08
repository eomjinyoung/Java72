package net.bitacademy.java72.step07.v02;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BoardApp {
  static Scanner scanner;
  
  public static void main(String[] args) {
    scanner = new Scanner(System.in);
    String command = null;
    BoardDao boardDao = null;
    
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
    
    
    do {
      System.out.print("명령> ");
      command = scanner.nextLine().toLowerCase();
      
      if (command.equals("list")) {
        List<Board> boards = boardDao.list();
        for (Board board : boards) {
          System.out.printf("%d, %s, %s, %d\n", 
              board.getNo(),
              board.getTitle(),
              board.getCreateDate(),
              board.getViewCount());
        }
        
      } else if (command.equals("insert")) {
        Board board = new Board();
        
        System.out.print("제목? ");
        board.setTitle(scanner.nextLine());
        
        System.out.print("내용? ");
        board.setContent(scanner.nextLine());
        
        System.out.print("암호? ");
        board.setPassword(scanner.nextLine());
        
        int count = boardDao.insert(board);
        if (count == 0) {
          System.out.println("입력 실패!");
        } else {
          System.out.println("입력 성공!");
        }
      
      } else if (command.equals("update")) {
        System.out.print("변경할 게시물 번호? ");
        int no = Integer.parseInt(scanner.nextLine());
        
        // 해당 게시물의 데이터를 가져온다.
        Board board = boardDao.get(no);
        
        // 사용자로부터 변경 내용을 입력 받는다.
        System.out.printf("제목(%s)? ", board.getTitle());
        String newTitle = scanner.nextLine();
        if (newTitle.length() > 0) {
          board.setTitle(newTitle);
        }
        
        System.out.printf("내용(%s)? ", board.getContent());
        String newContent = scanner.nextLine();
        if (newContent.length() > 0) {
          board.setContent(newContent);
        }
        
        // 입력 받은 내용으로 게시물을 변경한다.
        int count = boardDao.update(board);
        if (count == 0) {
          System.out.println("변경 실패!");
        } else {
          System.out.println("변경 성공!");
        }
        
      } else if (command.equals("delete")) {
        System.out.print("삭제할 게시물 번호? ");
        int no = Integer.parseInt(scanner.nextLine());
        
        boardDao.delete(no);
        
      } else if (command.equals("quit")) {
        System.out.println("안녕히 가세요!");
      
      } else {
        System.out.println("해당 명령을 지원하지 않습니다!");
      }
      
      
    } while (!command.toLowerCase().equals("quit"));
    
    scanner.close();
  }
}









