package net.bitacademy.java72.step06.v04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
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
        list();
        
      } else if (command.equals("insert")) {
        insert();
      
      } else if (command.equals("update")) {
        update();
      
      } else if (command.equals("delete")) {
        delete();
        
      } else if (command.equals("quit")) {
        System.out.println("안녕히 가세요!");
      
      } else {
        System.out.println("해당 명령을 지원하지 않습니다!");
      }
      
      
    } while (!command.toLowerCase().equals("quit"));
    
    scanner.close();
  }

  private static void delete() {
    Connection con = null;
    Statement stmt = null;
    
    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/java72db",
          "java72",
          "java72"); 
      stmt = con.createStatement();
      
      System.out.print("삭제할 게시물 번호? ");
      String no = scanner.nextLine();
      
      int count = stmt.executeUpdate(
          "DELETE FROM board10 WHERE bno=" + no);
      System.out.printf("삭제 완료!: %d\n", count);
      
    } catch (Exception e) {
      e.printStackTrace();

    } finally {
      try {stmt.close();} catch (Exception e) {}
      try {con.close();} catch (Exception e) {}
    }
  }

  private static void update() {
    System.out.print("변경할 게시물 번호? ");
    String no = scanner.nextLine();
    
    Connection con = null;
    Statement stmt = null;
    
    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/java72db",
          "java72", 
          "java72"); 
      stmt = con.createStatement();
      int count = stmt.executeUpdate(
          "UPDATE board10 SET title='변경변경' WHERE bno=" + no);
      System.out.printf("변경 완료!: %d\n", count);
      
    } catch (Exception e) {
      e.printStackTrace();

    } finally {
      try {stmt.close();} catch (Exception e) {}
      try {con.close();} catch (Exception e) {}
    }
  }

  private static void insert() {
    Connection con = null;
    Statement stmt = null;
    
    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/java72db",
          "java72", 
          "java72"); 
      stmt = con.createStatement();
      String title = "제목이래....";
      String content = "내용이래...";
      String password = "1111";
      
      int count = stmt.executeUpdate(
          "INSERT INTO board10(title,content,pwd,cre_dt)"
          + " values('" + title + "','" 
          + content + "','" 
          + password + "',now())");
      System.out.printf("입력 완료!: %d\n", count);
      
    } catch (Exception e) {
      e.printStackTrace();

    } finally {
      try {stmt.close();} catch (Exception e) {}
      try {con.close();} catch (Exception e) {}
    }
  }
  
  private static void list() {
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    try {
      Class.forName("com.mysql.jdbc.Driver");

      con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/java72db",    
          "java72", 
          "java72");
      stmt = con.createStatement();
      rs = stmt.executeQuery(
          "SELECT bno,title,cre_dt,views"
          + " FROM board10"
          + " ORDER BY bno desc");
      while (rs.next()) {
        System.out.printf("%d, %s, %s, %d\n",
            rs.getInt("bno"), rs.getString("title"),
            rs.getDate("cre_dt"), rs.getInt("views"));
      }

    } catch (Exception e) {
      e.printStackTrace();

    } finally {
      // 자원 해제 
      try {rs.close();} catch (Exception e) {}
      try {stmt.close();} catch (Exception e) {}
      try {con.close();} catch (Exception e) {}
    }
  }

}









