package net.bitacademy.java72.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import net.bitacademy.java72.annotation.RequestMapping;
import net.bitacademy.java72.dao.MemberDao;
import net.bitacademy.java72.domain.Member;

@Controller("/member/detail.do")
public class MemberDetail {
  @Autowired MemberDao memberDao;
  
  @RequestMapping
  public String detail(
      HttpServletRequest request, 
      HttpServletResponse response) {
    int no = Integer.parseInt(request.getParameter("no"));
    Member member = memberDao.get(no);
    request.setAttribute("member", member);
    return "/member/MemberDetail.jsp";
  }

}
