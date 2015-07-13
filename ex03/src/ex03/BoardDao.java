 package ex03;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

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
          "net.bitacademy.java72.step07.v02.BoardDao.list");
      
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
      sqlSession = sqlSessionFactory.openSession();
      int count = sqlSession.delete(
          "net.bitacademy.java72.step07.v02.BoardDao.delete",
          no);
      /* DML(Data Manipulation Language; insert, update, delete)
       * 명령의 결과를 실제 테이블에 반영하라고 지시한다.
       */
      sqlSession.commit();
      return count;
      
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
      sqlSession = sqlSessionFactory.openSession();
      int count = sqlSession.update(
          "net.bitacademy.java72.step07.v02.BoardDao.update",
          board);
      sqlSession.commit();
      return count;
      
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
      sqlSession = sqlSessionFactory.openSession();
      int count = sqlSession.insert(
          "net.bitacademy.java72.step07.v02.BoardDao.insert",
          board);
      sqlSession.commit();
      return count;
      
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
      sqlSession = sqlSessionFactory.openSession();
      return sqlSession.selectOne(
          "net.bitacademy.java72.step07.v02.BoardDao.get",
          no);
      
    } catch (Exception e) {
      e.printStackTrace();
      return null;
      
    } finally {
      sqlSession.close();
    }
  }
  
}











