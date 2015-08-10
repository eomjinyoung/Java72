package study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import study.vo.Test01;
import study.vo.Test02;

@Service
public class TxTestService {
  @Autowired TestService testService;
  
  @Transactional(
      propagation=Propagation.REQUIRED,
      rollbackFor=Exception.class)
  public void test(Test01 test01, Test02 test02) throws Exception {
    testService.m1(test01);
    testService.m2(test02);
  }
}








