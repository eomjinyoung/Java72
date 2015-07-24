package servlet.ex2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

@WebServlet("/step06/ex2/LogIn")
public class LogIn extends GenericServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    HttpServletRequest request = 
        (HttpServletRequest) req;
    
    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();
    out.println("<html>");
    out.println("<head><title>로그인 처리</title></head>");
    out.println("<body>");
    
    if (request.getMethod().equals("GET")) {
      out.println(
        "<p>이 서비스는 GET 요청을 지원하지 않습니다.</p>");
    } else {
      req.setCharacterEncoding("UTF-8");
      
      String id = req.getParameter("id");
      String pwd = req.getParameter("pwd");
      out.printf("아이디:%s<br>암호:%s<br>\n", id, pwd);
    }
    
    out.println("</body></html>");
  }

}






