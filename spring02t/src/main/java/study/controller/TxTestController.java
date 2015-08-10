package study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import study.service.TxTestService;
import study.vo.Test01;
import study.vo.Test02;

@Controller
public class TxTestController {
  @Autowired TxTestService txTestService;
  
  @RequestMapping("/study/txtest.do")
  public String txTest(String title1, String title2) {
    
    try {
      Test01 test01 = new Test01();
      test01.setTitle(title1);
      
      Test02 test02 = new Test02();
      test02.setTitle(title2);
      
      txTestService.test(test01, test02);
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    return "/study/Insert.jsp";
  }
}






