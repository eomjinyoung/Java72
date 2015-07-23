package servlet.ex2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/step04/ex2/servleta")
public class ServletA extends GenericServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(
      ServletRequest request, 
      ServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.println("<html>");
    out.println("<head>");
    out.println("  <meta charset='UTF-8'>");
    // 다른 페이지로 요청하도록 폭탄을 심는다.
    // "웹 브라우저야, HTML을 출력하고 3초 후에 
    // 같은 경로의 servletb를 요청해라."
    out.println("  <meta http-equiv='Refresh'"
        + " content='3;url=servletb'>");
    out.println("  <title>페이지 A</title>");  
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>페이지 A</h1>");
    out.println("</body>");
    out.println("</html>");
  }

}





