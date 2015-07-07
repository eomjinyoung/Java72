package net.bitacademy.java72.step06.v01;

import java.util.Scanner;

public class BoardApp {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String command = null;
    
    do {
      System.out.print("명령> ");
      command = scanner.nextLine();
      
    } while (!command.toLowerCase().equals("quit"));
    
    scanner.close();
  }

}









