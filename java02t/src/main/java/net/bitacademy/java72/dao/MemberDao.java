package net.bitacademy.java72.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import net.bitacademy.java72.step07.v09.Autowired;
import net.bitacademy.java72.step07.v09.member.Member;
import net.bitacademy.java72.step07.v09.Repository;

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
      // SqlSessionFactory 클래스로부터 실제 SQL 작업을 수행할 SqlSession을 얻는다.
      sqlSession = sqlSessionFactory.openSession();

      // SqlSession을 사용하여 SQL 맵퍼 파일에 있는 SQL문을 실행한다.
      return sqlSession.selectList(
          "net.bitacademy.java72.step07.v09.member.MemberDao.list");
      
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
          "net.bitacademy.java72.step07.v09.member.MemberDao.delete",
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

  public int update(Member member) {
    SqlSession sqlSession = null;
    try {
      sqlSession = sqlSessionFactory.openSession();
      int count = sqlSession.update(
          "net.bitacademy.java72.step07.v09.member.MemberDao.update",
          member);
      sqlSession.commit();
      return count;
      
    } catch (Exception e) {
      e.printStackTrace();
      return 0;
      
    } finally {
      sqlSession.close();
    }
  }

  public int insert(Member member) {
    SqlSession sqlSession = null;
    try {
      sqlSession = sqlSessionFactory.openSession();
      int count = sqlSession.insert(
          "net.bitacademy.java72.step07.v09.member.MemberDao.insert",
          member);
      sqlSession.commit();
      return count;
      
    } catch (Exception e) {
      e.printStackTrace();
      return 0;
      
    } finally {
      sqlSession.close();
    }
  }

  public Member get(int no) {
    SqlSession sqlSession = null;
    try {
      sqlSession = sqlSessionFactory.openSession();
      return sqlSession.selectOne(
          "net.bitacademy.java72.step07.v09.member.MemberDao.get",
          no);
      
    } catch (Exception e) {
      e.printStackTrace();
      return null;
      
    } finally {
      sqlSession.close();
    }
  }
  
}











