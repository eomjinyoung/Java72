package servlet.ex3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/step06/ex3/LogIn")
public class LogIn extends HttpGenericServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void service(
      HttpServletRequest request, 
      HttpServletResponse response)
      throws ServletException, IOException {
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head><title>로그인 처리</title></head>");
    out.println("<body>");
    
    if (request.getMethod().equals("GET")) {
      out.println(
        "<p>이 서비스는 GET 요청을 지원하지 않습니다.</p>");
    } else {
      request.setCharacterEncoding("UTF-8");
      
      String id = request.getParameter("id");
      String pwd = request.getParameter("pwd");
      out.printf("아이디:%s<br>암호:%s<br>\n", id, pwd);
    }
    
    out.println("</body></html>");
  }

}






