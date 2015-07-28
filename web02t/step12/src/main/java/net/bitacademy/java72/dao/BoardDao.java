package net.bitacademy.java72.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
    // 예외를 처리하기 위해 try를 사용하는 것이 아니다.
    // finally 에서 자원을 해제하기 위함이다.
    try { 
      sqlSession = sqlSessionFactory.openSession();
      return sqlSession.selectList(
          "net.bitacademy.java72.dao.BoardDao.list");
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
      
    } finally {
      sqlSession.close();
    }
  }
  
}











