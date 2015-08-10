package study.service.sm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import study.dao.Test01Dao;
import study.dao.Test02Dao;
import study.service.TestService;
import study.vo.Test01;
import study.vo.Test02;

@Service
public class TestServiceImpl implements TestService {
  @Autowired PlatformTransactionManager txManager;
  
  @Autowired Test01Dao test1Dao;
  @Autowired Test02Dao test2Dao;
  
  public void addTest(Test01 test01, Test02 test02) 
      throws Exception {
    TransactionDefinition def = 
        new DefaultTransactionDefinition();

    TransactionStatus status = 
        txManager.getTransaction(def);
    
    try {
      test1Dao.insert(test01); 
      test2Dao.insert(test02); 
      txManager.commit(status);
      
    } catch (Exception e) {
      txManager.rollback(status);
      throw e;
    }
  }
}
