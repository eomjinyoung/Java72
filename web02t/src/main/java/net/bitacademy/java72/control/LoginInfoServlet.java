package net.bitacademy.java72.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.bitacademy.java72.domain.Member;

@WebServlet("/loginInfo")
public class LoginInfoServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  protected void service(
      HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {
    
    HttpSession session = request.getSession();
    Member member = (Member)session.getAttribute("member");
    
    String contextRootPath = request.getContextPath();
    
    PrintWriter out = response.getWriter();
    out.println("<div id='loginInfo'>");
    if (member == null) {
      out.println("<a href='"
          + contextRootPath
          + "/auth/login.do'>로그인</a>");
    } else {
      out.printf("  <span id='loginName'>%s</span>\n",
          member.getName());
      out.println("  <a href='"
          + contextRootPath
          + "/auth/logout.do'>로그아웃</a>");
    }
    out.println("</div>");
  }

}








