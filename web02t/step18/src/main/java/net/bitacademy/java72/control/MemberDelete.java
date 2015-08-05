package net.bitacademy.java72.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import net.bitacademy.java72.annotation.RequestMapping;
import net.bitacademy.java72.dao.MemberDao;

@Controller("/member/delete.do")
public class MemberDelete {
  @Autowired MemberDao memberDao;
  
  @RequestMapping
  public String delete(int no) {
    memberDao.delete(no);
    return "redirect:list.do";
  }

}






