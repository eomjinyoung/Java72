package servlet.ex1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/step05/ex1/LogIn3")
public class LogIn3 extends GenericServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    // getParameter()를 호출하기 전에 
    // 입력 데이터의 문자표를 알려줘라.
    req.setCharacterEncoding("UTF-8");
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






