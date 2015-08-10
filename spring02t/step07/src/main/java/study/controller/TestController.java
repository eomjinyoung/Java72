package study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.bind.annotation.RequestMapping;

import study.dao.Test01Dao;
import study.dao.Test02Dao;
import study.vo.Test01;
import study.vo.Test02;

@Controller
public class TestController {
  @Autowired PlatformTransactionManager txManager;
  
  @Autowired Test01Dao test1Dao;
  @Autowired Test02Dao test2Dao;
  
  @RequestMapping("/study/insert.do")
  public String insert(String title1, String title2) {
    // 1) 트랜잭션 정책을 정의
    TransactionDefinition def = 
        new DefaultTransactionDefinition();
    // 2) 트랜잭션 정책에 따라 수행되는 작업을 기록할 장부 준비
    TransactionStatus status = 
        txManager.getTransaction(def);
    
    try {
      Test01 t1 = new Test01();
      t1.setTitle(title1);
      test1Dao.insert(t1); // 트랜잭션 장부에 자동으로 기록됨.
      
      Test02 t2 = new Test02();
      t2.setTitle(title2);
      test2Dao.insert(t2); // 트랜잭센 장부에 자동으로 기록됨.
      
      // 트랜잭션 관리자야,
      // 장부에 기록된 대로 임시 DB에 보관된 작업 결과를
      // 실제 DB에 반영하라!
      txManager.commit(status);
      
    } catch (Exception e) {
      // 트랜잭션 관리자야,
      // 지금까지 장부에 기록한 모든 작업 결과를 취소하라!
      txManager.rollback(status);
    }
    
    return "/study/Insert.jsp";
  }
}






