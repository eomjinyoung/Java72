package net.bitacademy.java72.step07.v01;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BoardDao {
  SqlSessionFactory sqlSessionFactory;
  
  public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  public List<Board> list() {
    SqlSession sqlSession = null;
    try {
      
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
    SqlSession sqlSession = null;
    try {
      String resource = "net/bitacademy/java72/step07/v01/mybatis-config.xml";
      InputStream inputStream = Resources.getResourceAsStream(resource);
      SqlSessionFactory sqlSessionFactory = 
          new SqlSessionFactoryBuilder().build(inputStream);
      sqlSession = sqlSessionFactory.openSession();
      return sqlSession.update(
          "net.bitacademy.java72.step07.v01.BoardDao.update",
          board);
      
    } catch (Exception e) {
      e.printStackTrace();
      return 0;
      
    } finally {
      sqlSession.close();
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
    SqlSession sqlSession = null;
    try {
      String resource = "net/bitacademy/java72/step07/v01/mybatis-config.xml";
      InputStream inputStream = Resources.getResourceAsStream(resource);
      SqlSessionFactory sqlSessionFactory = 
          new SqlSessionFactoryBuilder().build(inputStream);
      sqlSession = sqlSessionFactory.openSession();
      return sqlSession.selectOne(
          "net.bitacademy.java72.step07.v01.BoardDao.get",
          no);
      
    } catch (Exception e) {
      e.printStackTrace();
      return null;
      
    } finally {
      sqlSession.close();
    }
  }
  
}











