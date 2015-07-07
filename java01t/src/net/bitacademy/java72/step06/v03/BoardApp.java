package net.bitacademy.java72.step06.v03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BoardApp {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String command = null;
    
    do {
      System.out.print("명령> ");
      command = scanner.nextLine().toLowerCase();
      
      if (command.equals("list")) {
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
      
      } else if (command.equals("insert")) {
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









