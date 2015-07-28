package study.ex1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/study/ex1/test02")
public class CookieTest02 extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void service(
      HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {
    
    //요청 헤더에 들어 있는 쿠키 정보 꺼내기
    Cookie[] cookieList = request.getCookies();
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html><body>");
    out.println("<h1>CookieTest02</h1>");
    
    if (cookieList != null) {
      for (Cookie cookie : cookieList) {
        out.printf("<p>%s=%s</p>\n", 
            cookie.getName(), cookie.getValue());
      }
    }
    
    out.println("</body></html>");
  }
}






