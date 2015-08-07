package study.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import study.vo.Test01;
import study.vo.Test02;

@Repository
public class TestDao {
  @Autowired SqlSessionFactory sqlSessionFactory;
  
  public void insert(Test01 test01, Test02 test02) {
    SqlSession sqlSession = 
        sqlSessionFactory.openSession(true);
    try {
      sqlSession.insert(
          "study.dao.TestDao.insert1", test01);
      sqlSession.insert(
          "study.dao.TestDao.insert2", test02);
      
    } catch (Exception e) {
      e.printStackTrace();
      
    } finally {
      sqlSession.close();
    }
  }
}
