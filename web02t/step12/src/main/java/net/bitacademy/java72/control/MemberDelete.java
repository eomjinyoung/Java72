package net.bitacademy.java72.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import net.bitacademy.java72.dao.MemberDao;

public class MemberDelete extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(
      HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {
    ApplicationContext context = 
        (ApplicationContext)this.getServletContext()
           .getAttribute("beanContainer");
    
    MemberDao memberDao = 
        (MemberDao)context.getBean("memberDao");
    
    int no = Integer.parseInt(request.getParameter("no"));
    
    try {
      memberDao.delete(no);
    } catch (Exception e) {
      RequestDispatcher rd = 
          request.getRequestDispatcher("/error");

      //ServletRequest에 전달할 객체를 저장한다.
      request.setAttribute("error", e);
      
      rd.forward(request, response);
      return;
    }
    response.sendRedirect("list.do");
  }

}
