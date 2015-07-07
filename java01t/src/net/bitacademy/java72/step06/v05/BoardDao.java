package net.bitacademy.java72.step06.v05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BoardDao {
  public static void list() {
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
  
  public static void delete(String no) {
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
          "DELETE FROM board10 WHERE bno=" + no);
      System.out.printf("삭제 완료!: %d\n", count);
      
    } catch (Exception e) {
      e.printStackTrace();

    } finally {
      try {stmt.close();} catch (Exception e) {}
      try {con.close();} catch (Exception e) {}
    }
  }

  public static void update(String no) {
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

  public static void insert() {
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
  
}
