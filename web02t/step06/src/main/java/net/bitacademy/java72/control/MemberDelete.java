package net.bitacademy.java72.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.java72.context.MyApplicationContext;
import net.bitacademy.java72.dao.MemberDao;

public class MemberDelete extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(
      HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {
    MyApplicationContext context = 
        MyApplicationContext.getInstance();

    MemberDao memberDao = 
        (MemberDao)context.getBean("memberDao");
    
    int no = Integer.parseInt(request.getParameter("no"));
    memberDao.delete(no);
    
    response.sendRedirect("list.do");
  }

}
