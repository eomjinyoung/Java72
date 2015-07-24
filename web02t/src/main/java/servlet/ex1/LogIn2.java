package servlet.ex1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/step05/ex1/LogIn2")
public class LogIn2 extends GenericServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    // GET 요청이나 POST 요청이나
    // 값을 꺼내는 방법은 같다.
    String id = req.getParameter("id");
    String pwd = req.getParameter("pwd");
    
    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();
    out.println("<html>");
    out.println("<head><title>POST요청처리</title></head>");
    out.println("<body>");
    out.printf("아이디:%s<br>암호:%s<br>\n", id, pwd);
    out.println("</body></html>");
  }

}






