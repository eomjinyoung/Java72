package net.bitacademy.java72.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/error")
public class ErrorServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  protected void service(
      HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("  <meta charset='UTF-8'>");
    out.println("  <title>페이지 오류 발생!</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>페이지 오류 발생2!</h1>");
    out.println("<p>잠시 후에 다시 시도해 주세요.<br>");
    out.println("계속 오류가 보인다면 관리자(내선: 200)");
    out.println("에게 문의해 주세요.</p>");
    
    Exception e = 
        (Exception)request.getAttribute("error");
    if (e != null) {
      out.println("<pre>"); // CRLF를 줄 바꿈으로 인식한다.
      e.printStackTrace(out);
      out.println("</pre>");
    }
    
    
    out.println("</body>");
    out.println("</html>");
  }

}








