package study.ex1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/study/ex1/test01")
public class CookieTest01 extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void service(
      HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {
    
    //1) 쿠키 생성
    Cookie cookie1 = new Cookie("name", "hong");
    Cookie cookie2 = new Cookie("age", "20");
    //2) 응답 헤더에 추가
    response.addCookie(cookie1);
    response.addCookie(cookie2);
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html><body>");
    out.println("<h1>CookieTest01</h1>");
    out.println("</body></html>");
  }
}






