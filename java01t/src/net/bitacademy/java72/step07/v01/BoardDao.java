package net.bitacademy.java72.step07.v01;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BoardDao {
  DBConnectionPool dbPool;
  
  public BoardDao(DBConnectionPool dbPool) {
    this.dbPool = dbPool;
  }
  
  public List<Board> list() {
    SqlSession sqlSession = null;
    try {
      // mybatis 설정 파일이 있는 경로를 지정한다.
      String resource = "net/bitacademy/java72/step07/v01/mybatis-config.xml";
      
      // 위에서 가리키는 경로에서 mybatis 설정 파일을 읽을 도구를 준비한다.
      InputStream inputStream = Resources.getResourceAsStream(resource);
      
      // mybatis 설정 파일에 맞추어 SqlSessionFactory를 준비한다.
      SqlSessionFactory sqlSessionFactory = 
          new SqlSessionFactoryBuilder().build(inputStream);
      
      // SqlSessionFactory 클래스로부터 실제 SQL 작업을 수행할 SqlSession을 얻는다.
      sqlSession = sqlSessionFactory.openSession();

      // SqlSession을 사용하여 SQL 맵퍼 파일에 있는 SQL문을 실행한다.
      return sqlSession.selectList(
          "net.bitacademy.java72.step07.v01.BoardDao.list");
      
    } catch (Exception e) {
      e.printStackTrace();
      return null;
      
    } finally {
      sqlSession.close();
    }
  }
  
  public int delete(int no) {
    SqlSession sqlSession = null;
    try {
      String resource = "net/bitacademy/java72/step07/v01/mybatis-config.xml";
      InputStream inputStream = Resources.getResourceAsStream(resource);
      SqlSessionFactory sqlSessionFactory = 
          new SqlSessionFactoryBuilder().build(inputStream);
      sqlSession = sqlSessionFactory.openSession();
      return sqlSession.delete(
          "net.bitacademy.java72.step07.v01.BoardDao.delete",
          no);
      
    } catch (Exception e) {
      e.printStackTrace();
      return 0;
      
    } finally {
      sqlSession.close();
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
    SqlSession sqlSession = null;
    try {
      String resource = "net/bitacademy/java72/step07/v01/mybatis-config.xml";
      InputStream inputStream = Resources.getResourceAsStream(resource);
      SqlSessionFactory sqlSessionFactory = 
          new SqlSessionFactoryBuilder().build(inputStream);
      sqlSession = sqlSessionFactory.openSession();
      return sqlSession.insert(
          "net.bitacademy.java72.step07.v01.BoardDao.insert",
          board);
      
    } catch (Exception e) {
      e.printStackTrace();
      return 0;
      
    } finally {
      sqlSession.close();
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











