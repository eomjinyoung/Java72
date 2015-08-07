package study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import study.dao.TestDao;
import study.vo.Test01;
import study.vo.Test02;

@Controller
public class TestController {
  @Autowired TestDao testDao;
  
  @RequestMapping("/study/insert.do")
  public String insert(String title1, String title2) {
    Test01 t1 = new Test01();
    t1.setTitle(title1);
    
    Test02 t2 = new Test02();
    t2.setTitle(title2);
    
    testDao.insert(t1, t2);
    return "/study/Insert.jsp";
  }
}






