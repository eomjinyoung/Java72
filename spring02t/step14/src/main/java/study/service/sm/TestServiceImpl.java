package study.service.sm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.dao.Test01Dao;
import study.dao.Test02Dao;
import study.service.TestService;
import study.vo.Test01;
import study.vo.Test02;

@Service
public class TestServiceImpl implements TestService {
  @Autowired Test01Dao test1Dao;
  @Autowired Test02Dao test2Dao;
  
  public void addTest(Test01 test01, Test02 test02) 
      throws Exception {
      test1Dao.insert(test01); 
      test2Dao.insert(test02); 
  }
}







