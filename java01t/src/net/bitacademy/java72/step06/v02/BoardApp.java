package net.bitacademy.java72.step06.v02;

import java.util.Scanner;

public class BoardApp {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String command = null;
    
    do {
      System.out.print("명령> ");
      command = scanner.nextLine().toLowerCase();
      if (command.equals("list")) {
        System.out.println("게시물 목록");
      
      } else if (command.equals("insert")) {
        System.out.println("입력 성공!");
      
      } else if (command.equals("update")) {
        System.out.println("변경 성공!");
      
      } else if (command.equals("delete")) {
        System.out.println("삭제 성공!");
      
      } else if (command.equals("quit")) {
        System.out.println("안녕히 가세요!");
      
      } else {
        System.out.println("해당 명령을 지원하지 않습니다!");
      }
      
      
    } while (!command.toLowerCase().equals("quit"));
    
    scanner.close();
  }

}









