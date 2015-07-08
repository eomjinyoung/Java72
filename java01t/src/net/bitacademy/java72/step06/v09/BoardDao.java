package net.bitacademy.java72.step06.v09;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class BoardDao {
  DBConnectionPool dbPool;
  
  public BoardDao(DBConnectionPool dbPool) {
    this.dbPool = dbPool;
  }
  
  public void list() {
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    try {
      con = dbPool.getConnection();
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
      try {rs.close();} catch (Exception e) {}
      try {stmt.close();} catch (Exception e) {}
      dbPool.returnConnection(con);
    }
  }
  
  public void delete(String no) {
    Connection con = null;
    Statement stmt = null;
    
    try {
      con = dbPool.getConnection();
      stmt = con.createStatement();
      int count = stmt.executeUpdate(
          "DELETE FROM board10 WHERE bno=" + no);
      System.out.printf("삭제 완료!: %d\n", count);
      
    } catch (Exception e) {
      e.printStackTrace();

    } finally {
      try {stmt.close();} catch (Exception e) {}
      dbPool.returnConnection(con);
    }
  }

  public void update(String no) {
    Connection con = null;
    Statement stmt = null;
    
    try {
      con = dbPool.getConnection();
      stmt = con.createStatement();
      int count = stmt.executeUpdate(
          "UPDATE board10 SET title='변경변경' WHERE bno=" + no);
      System.out.printf("변경 완료!: %d\n", count);
      
    } catch (Exception e) {
      e.printStackTrace();

    } finally {
      try {stmt.close();} catch (Exception e) {}
      dbPool.returnConnection(con);
    }
  }

  public void insert() {
    Connection con = null;
    Statement stmt = null;
    
    try {
      con = dbPool.getConnection();
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
      dbPool.returnConnection(con);
    }
  }
  
}
