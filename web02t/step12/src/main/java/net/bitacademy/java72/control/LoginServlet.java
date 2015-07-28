package net.bitacademy.java72.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import net.bitacademy.java72.dao.MemberDao;
import net.bitacademy.java72.domain.Member;

@WebServlet("/auth/login.do")
public class LoginServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doPost(
      HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {
    ApplicationContext context = 
        (ApplicationContext)this.getServletContext()
           .getAttribute("beanContainer");
    
    MemberDao memberDao = 
        (MemberDao)context.getBean("memberDao");
    
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    
    Member member = null;
    try {
      member = memberDao.exist(email, password);
      if (member == null) {
        response.setHeader("Refresh", 
            "1;url=LoginForm.html");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>로그인 결과</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<p>사용자 아이디 또는 암호가 일치하지 않습니다.</p>");
        out.println("</body>");
        out.println("</html>");
        
      } else {
        response.sendRedirect("../board/list.do");
        return;
      }
    } catch (Exception e) {
      RequestDispatcher rd = 
          request.getRequestDispatcher("/error");

      //ServletRequest에 전달할 객체를 저장한다.
      request.setAttribute("error", e);
      
      rd.forward(request, response);
      return;
    }
  }
}
