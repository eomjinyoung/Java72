package study.service.sm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import study.dao.Test01Dao;
import study.dao.Test02Dao;
import study.service.TestService;
import study.vo.Test01;
import study.vo.Test02;

@Service
public class TestServiceImpl implements TestService {
  @Autowired Test01Dao test1Dao;
  @Autowired Test02Dao test2Dao;
  
  @Transactional(
      propagation=Propagation.REQUIRED,
      rollbackFor=Exception.class)
  public void addTest(Test01 test01, Test02 test02) 
      throws Exception {
      test1Dao.insert(test01); 
      test2Dao.insert(test02); 
  }
  
  @Transactional(
      propagation=Propagation.REQUIRED,
      rollbackFor=Exception.class)
  public void m1(Test01 test01) throws Exception {
    test1Dao.insert(test01);
  }
  
  @Transactional(
      propagation=Propagation.REQUIRED,
      rollbackFor=Exception.class)
  public void m2(Test02 test02) throws Exception {
    test2Dao.insert(test02);
  }
}







