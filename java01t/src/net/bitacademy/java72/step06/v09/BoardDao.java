package net.bitacademy.java72.step06.v09;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BoardDao {
  DBConnectionPool dbPool;
  
  public BoardDao(DBConnectionPool dbPool) {
    this.dbPool = dbPool;
  }
  
  public List<Board> list() {
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
      
      ArrayList<Board> boards = new ArrayList<Board>();
      Board board = null;
      
      while (rs.next()) {
        board = new Board();
        board.setNo(rs.getInt("bno"));
        board.setTitle(rs.getString("title"));
        board.setCreateDate(rs.getDate("cre_dt"));
        board.setViewCount(rs.getInt("views"));
        boards.add(board);
      }
      return boards;

    } catch (Exception e) {
      e.printStackTrace();
      return null;
      
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

  public int update(Board board) {
    Connection con = null;
    PreparedStatement stmt = null;
    
    try {
      con = dbPool.getConnection();
      stmt = con.prepareStatement(
          "UPDATE board10 SET title=?,content=? WHERE bno=?");
      stmt.setString(1, board.getTitle());
      stmt.setString(2, board.getContent());
      stmt.setInt(3, board.getNo());
      return stmt.executeUpdate();
      
    } catch (Exception e) {
      e.printStackTrace();
      return 0;
    } finally {
      try {stmt.close();} catch (Exception e) {}
      dbPool.returnConnection(con);
    }
  }

  public int insert(Board board) {
    Connection con = null;
    PreparedStatement stmt = null;
    
    try {
      con = dbPool.getConnection();
      stmt = con.prepareStatement( 
          "INSERT INTO board10(title,content,pwd,cre_dt)"
          + " values(?, ?, ?, now())");
      stmt.setString(1, board.getTitle());
      stmt.setString(2, board.getContent());
      stmt.setString(3, board.getPassword());
      return stmt.executeUpdate();
      
    } catch (Exception e) {
      e.printStackTrace();
      return 0;
    } finally {
      try {stmt.close();} catch (Exception e) {}
      dbPool.returnConnection(con);
    }
  }

  public Board get(int no) {
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    try {
      con = dbPool.getConnection();
      stmt = con.createStatement();
      rs = stmt.executeQuery(
          "SELECT bno,title,content"
          + " FROM board10"
          + " WHERE bno=" + no);
      
      Board board = null;
      if (rs.next()) {
        board = new Board();
        board.setNo(rs.getInt("bno"));
        board.setTitle(rs.getString("title"));
        board.setContent(rs.getString("content"));
      }
      return board;

    } catch (Exception e) {
      e.printStackTrace();
      return null;
      
    } finally {
      try {rs.close();} catch (Exception e) {}
      try {stmt.close();} catch (Exception e) {}
      dbPool.returnConnection(con);
    }
  }
  
}











