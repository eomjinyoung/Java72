package study.dao;

import java.io.InputStream;

import javax.servlet.ServletRequest;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;

import study.vo.Test01;

@Repository
public class Test01Dao {
  SqlSessionFactory sqlSessionFactory;
  
  public Test01Dao() {
    try {
      String resource = "study/dao/mybatis-config.xml";
      InputStream inputStream = Resources.getResourceAsStream(resource);
      sqlSessionFactory = 
          new SqlSessionFactoryBuilder().build(inputStream);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  public void insert(Test01 test01, ServletRequest request) {
    SqlSession sqlSession = 
        sqlSessionFactory.openSession(false);
    request.setAttribute("Test01Dao.sqlSession", sqlSession);
    
    sqlSession.insert(
          "study.dao.Test01Dao.insert", test01);
  }
  
  public void commit(ServletRequest request) {
    SqlSession sqlSession = 
        (SqlSession)request.getAttribute("Test01Dao.sqlSession");
    sqlSession.commit();
    sqlSession.close();
  }
  
  public void rollback(ServletRequest request) {
    SqlSession sqlSession = 
        (SqlSession)request.getAttribute("Test01Dao.sqlSession");
    sqlSession.rollback();
    sqlSession.close();
  }
}








