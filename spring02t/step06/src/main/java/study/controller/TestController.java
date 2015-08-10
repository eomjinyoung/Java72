package study.controller;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import study.dao.Test01Dao;
import study.dao.Test02Dao;
import study.vo.Test01;
import study.vo.Test02;

@Controller
public class TestController {
  @Autowired Test01Dao test1Dao;
  @Autowired Test02Dao test2Dao;
  
  @RequestMapping("/study/insert.do")
  public String insert(
      String title1
      , String title2
      , ServletRequest request) {
    try {
      Test01 t1 = new Test01();
      t1.setTitle(title1);
      test1Dao.insert(t1);
      
      Test02 t2 = new Test02();
      t2.setTitle(title2);
      test2Dao.insert(t2);
      
      test1Dao.commit();
      test2Dao.commit();
      
    } catch (Exception e) {
      test1Dao.rollback();
      test2Dao.rollback();
    }
    
    return "/study/Insert.jsp";
  }
}






