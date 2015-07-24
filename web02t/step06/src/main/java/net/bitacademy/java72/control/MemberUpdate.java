package net.bitacademy.java72.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.java72.context.MyApplicationContext;
import net.bitacademy.java72.dao.MemberDao;
import net.bitacademy.java72.domain.Member;

public class MemberUpdate extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doPost(
      HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {
  
    request.setCharacterEncoding("UTF-8");
    
    MyApplicationContext context = 
        MyApplicationContext.getInstance();

    MemberDao memberDao = 
        (MemberDao)context.getBean("memberDao");
    
    Member member = new Member();
    member.setNo(Integer.parseInt(
        request.getParameter("no")));
    member.setName(request.getParameter("name"));
    member.setEmail(request.getParameter("email"));
    member.setTel(request.getParameter("tel"));
    member.setPassword(request.getParameter("password"));
    
    memberDao.update(member);
    
    response.sendRedirect("list.do");
  }

}
