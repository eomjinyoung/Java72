package net.bitacademy.java72.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import net.bitacademy.java72.dao.MemberDao;
import net.bitacademy.java72.domain.Member;

public class MemberUpdate extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doPost(
      HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {
  
    // 필터로 대체한다.
    //request.setCharacterEncoding("UTF-8");
    
    ApplicationContext context = 
        (ApplicationContext)this.getServletContext()
           .getAttribute("beanContainer");

    MemberDao memberDao = 
        (MemberDao)context.getBean("memberDao");
    
    Member member = new Member();
    member.setNo(Integer.parseInt(
        request.getParameter("no")));
    member.setName(request.getParameter("name"));
    member.setEmail(request.getParameter("email"));
    member.setTel(request.getParameter("tel"));
    member.setPassword(request.getParameter("password"));
    
    try {
      memberDao.update(member);
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
