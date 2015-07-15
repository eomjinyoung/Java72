package net.bitacademy.java72.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import net.bitacademy.java72.annotation.Autowired;
import net.bitacademy.java72.annotation.Repository;
import net.bitacademy.java72.domain.Board;

@Repository
public class BoardDao {
  SqlSessionFactory sqlSessionFactory;
  
  @Autowired
  public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  public List<Board> list() {
    SqlSession sqlSession = null;
    try {
      sqlSession = sqlSessionFactory.openSession();
      return sqlSession.selectList(
          "net.bitacademy.java72.dao.BoardDao.list");
      
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
          "net.bitacademy.java72.dao.BoardDao.delete",
          no);
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
          "net.bitacademy.java72.dao.BoardDao.update",
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
          "net.bitacademy.java72.dao.BoardDao.insert",
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
          "net.bitacademy.java72.dao.BoardDao.get",
          no);
      
    } catch (Exception e) {
      e.printStackTrace();
      return null;
      
    } finally {
      sqlSession.close();
    }
  }
  
}











