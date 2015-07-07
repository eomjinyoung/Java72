package net.bitacademy.java72.step06.v06;

import java.util.Scanner;

public class BoardApp {
  static Scanner scanner;
  
  public static void main(String[] args) {
    scanner = new Scanner(System.in);
    String command = null;
    
    do {
      System.out.print("명령> ");
      command = scanner.nextLine().toLowerCase();
      
      if (command.equals("list")) {
        BoardDao.list();
        
      } else if (command.equals("insert")) {
        BoardDao.insert();
      
      } else if (command.equals("update")) {
        System.out.print("변경할 게시물 번호? ");
        String no = scanner.nextLine();
        
        BoardDao.update(no);
      
      } else if (command.equals("delete")) {
        System.out.print("삭제할 게시물 번호? ");
        String no = scanner.nextLine();
        
        BoardDao.delete(no);
        
      } else if (command.equals("quit")) {
        System.out.println("안녕히 가세요!");
      
      } else {
        System.out.println("해당 명령을 지원하지 않습니다!");
      }
      
      
    } while (!command.toLowerCase().equals("quit"));
    
    BoardDao.destroy();
    
    scanner.close();
  }
}









