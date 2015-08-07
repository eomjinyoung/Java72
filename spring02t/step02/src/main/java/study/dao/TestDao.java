package study.dao;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;

import study.vo.Test01;
import study.vo.Test02;

@Repository
public class TestDao {
  SqlSessionFactory sqlSessionFactory;
  
  public TestDao() {
    try {
      String resource = "study/dao/mybatis-config.xml";
      InputStream inputStream = Resources.getResourceAsStream(resource);
      sqlSessionFactory = 
          new SqlSessionFactoryBuilder().build(inputStream);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
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
