package study.dao;

import javax.servlet.ServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import study.vo.Test02;

@Repository
public class Test02Dao {
  @Autowired SqlSessionFactory sqlSessionFactory;
  
  public void insert(Test02 test02, ServletRequest request) {
    SqlSession sqlSession = 
        sqlSessionFactory.openSession(false);
    request.setAttribute("Test02Dao.sqlSession", sqlSession);
    sqlSession.insert(
          "study.dao.Test02Dao.insert", test02);
  }
  
  public void commit(ServletRequest request) {
    SqlSession sqlSession = 
        (SqlSession)request.getAttribute("Test02Dao.sqlSession");
    sqlSession.commit();
    sqlSession.close();
  }
  
  public void rollback(ServletRequest request) {
    SqlSession sqlSession = 
        (SqlSession)request.getAttribute("Test02Dao.sqlSession");
    sqlSession.rollback();
    sqlSession.close();
  }
}
