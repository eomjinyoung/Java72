package net.bitacademy.java72.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.bitacademy.java72.domain.Member;

@Repository
public class MemberDao {
  SqlSessionFactory sqlSessionFactory;
  
  @Autowired
  public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  public List<Member> list() {
    SqlSession sqlSession = null;
    try {
      sqlSession = sqlSessionFactory.openSession();
      return sqlSession.selectList(
          "net.bitacademy.java72.dao.MemberDao.list");
      
    } finally {
      sqlSession.close();
    }
  }
  
  public int delete(int no) {
    SqlSession sqlSession = null;
    try {
      sqlSession = sqlSessionFactory.openSession();
      int count = sqlSession.delete(
          "net.bitacademy.java72.dao.MemberDao.delete",
          no);
      sqlSession.commit();
      return count;
      
    } finally {
      sqlSession.close();
    }
  }

  public int update(Member member) {
    SqlSession sqlSession = null;
    try {
      sqlSession = sqlSessionFactory.openSession();
      int count = sqlSession.update(
          "net.bitacademy.java72.dao.MemberDao.update",
          member);
      sqlSession.commit();
      return count;
      
    } finally {
      sqlSession.close();
    }
  }

  public int insert(Member member) {
    SqlSession sqlSession = null;
    try {
      sqlSession = sqlSessionFactory.openSession();
      int count = sqlSession.insert(
          "net.bitacademy.java72.dao.MemberDao.insert",
          member);
      sqlSession.commit();
      return count;
      
    } finally {
      sqlSession.close();
    }
  }

  public Member get(int no) {
    SqlSession sqlSession = null;
    try {
      sqlSession = sqlSessionFactory.openSession();
      return sqlSession.selectOne(
          "net.bitacademy.java72.dao.MemberDao.get",
          no);
      
    } finally {
      sqlSession.close();
    }
  }

  public Member exist(String email, String password) {
    SqlSession sqlSession = null;
    try {
      sqlSession = sqlSessionFactory.openSession();
      
      HashMap<String,String> map = 
          new HashMap<String,String>();
      map.put("email", email);
      map.put("password", password);
      
      return sqlSession.selectOne(
          "net.bitacademy.java72.dao.MemberDao.exist",
          map);
      
    } finally {
      sqlSession.close();
    }
  }
  
}











