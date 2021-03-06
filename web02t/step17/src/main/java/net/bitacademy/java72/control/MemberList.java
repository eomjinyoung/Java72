package net.bitacademy.java72.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import net.bitacademy.java72.annotation.RequestMapping;
import net.bitacademy.java72.dao.MemberDao;
import net.bitacademy.java72.domain.Member;

@Controller("/member/list.do")
public class MemberList {
  @Autowired MemberDao memberDao;
  
  @RequestMapping
  public String list(
      HttpServletRequest request, 
      HttpServletResponse response) {
    
    List<Member> members = memberDao.list();
    request.setAttribute("members", members);
    
    return "/member/MemberList.jsp";
  }

}