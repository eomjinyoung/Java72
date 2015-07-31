package net.bitacademy.java72.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;

import net.bitacademy.java72.dao.MemberDao;
import net.bitacademy.java72.domain.Member;

@WebServlet("/auth/login.do")
public class LoginServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(
      HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {
    
    // 다른 페이지에서 로그인 링크를 눌러서 들어왔다면,
    // 해당 페이지의 URL을 세션에 보관해 둔다.
    String refererUrl = request.getHeader("Referer");
    if (refererUrl != null) {
      HttpSession session = request.getSession();
      session.setAttribute("refererUrl", refererUrl);
    }
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>로그인 폼</title>");
    out.println("<style type='text/css'>");
    out.println("#main {");
    out.println("  background-color: yellow;");
    out.println("  width: 260px;");
    out.println("  padding: 0px 20px 10px 20px; ");
    out.println("  margin: 0px auto;");
    out.println("}");
    out.println("</style>");
    out.println("</head>");
    out.println("<body>");
    out.println("<div id='main'>");
    out.println("<h1>로그인</h1>");
    out.println("<form action='login.do' method='post'>");
    out.println("<table>");
    out.println("<tr>");
    out.println("  <th>이메일</th>");
    
    // 쿠키에서 이메일 값을 꺼낸다.
    String email = "";
    Cookie[] cookieList = request.getCookies();
    if (cookieList != null) {
      for (Cookie cookie : cookieList) {
        if (cookie.getName().equals("email")) {
          email = cookie.getValue();
          break;
        }
      }
    }
    
    out.printf("  <td><input type='text' name='email' value='%s'></td>\n", email);
    out.println("</tr>");
    out.println("<tr>");
    out.println("  <th>암호</th>");
    out.println("  <td><input type='password' name='password'></td>");
    out.println("</tr>");
    out.println("<tr>");
    out.println("  <th></th>");
    out.println("  <td><input type='checkbox' name='saveEmail'>");
    out.println("    이메일 기억하기");
    out.println("  </td>");
    out.println("</tr>");
    out.println("<tr>");
    out.println("  <th></th>");
    out.println("  <td><button type='submit'>로그인</button></td>");
    out.println("</tr>");
    out.println("</table>");
    out.println("</form>");
    out.println("</div>");
    out.println("</body>");
    out.println("</html>");
  }
  
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
    
    // 이메일 기억하기를 체크했을 때 
    // 이메일 정보를 쿠키로 보낸다.
    // 체크박스의 값은 체크를 할 때만 넘어 온다.
    if (request.getParameter("saveEmail") != null) {
      Cookie cookie = new Cookie("email", email);
      cookie.setMaxAge(60 * 60 * 24);
      response.addCookie(cookie);
    } else { 
      // 기억하기를 체크하지 않았다면, 쿠키를 무효화 시킨다.
      Cookie cookie = new Cookie("email", "");
      cookie.setMaxAge(0);
      response.addCookie(cookie);
    }
    
    Member member = null;
    try {
      member = memberDao.exist(email, password);
      
      HttpSession session = request.getSession();
          
      if (member == null) {
        //로그인 실패할 때, 세션 객체를 무효화시킨다.
        session.invalidate();
        
        response.setHeader("Refresh", 
            "1;url=login.do");
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
        session.setAttribute("member", member);
        
        String refererUrl = 
            (String)session.getAttribute("refererUrl");
        if (refererUrl == null) {
          response.sendRedirect("../board/list.do");
        } else {
          response.sendRedirect(refererUrl);
        }
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
