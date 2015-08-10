package study.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import study.vo.Test01;

@Repository
public class Test01Dao {
  @Autowired SqlSessionFactory sqlSessionFactory;
  
  ThreadLocal<SqlSession> sqlSessionBox = 
      new ThreadLocal<SqlSession>();
  
  public void insert(Test01 test01) {
    SqlSession sqlSession = 
        sqlSessionFactory.openSession(false);
    
    sqlSessionBox.set(sqlSession);
    
    sqlSession.insert(
          "study.dao.Test01Dao.insert", test01);
  }
  
  public void commit() {
    SqlSession sqlSession = sqlSessionBox.get();
    sqlSession.commit();
    sqlSession.close();
  }
  
  public void rollback() {
    SqlSession sqlSession = sqlSessionBox.get();
    sqlSession.rollback();
    sqlSession.close();
  }
}








