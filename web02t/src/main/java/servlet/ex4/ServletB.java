package servlet.ex4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/step04/ex4/servletb")
public class ServletB extends GenericServlet {
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
    out.println("  <title>페이지 B</title>");  
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>페이지 BBBBBBBBBBB</h1>");
    out.println("</body>");
    out.println("</html>");
  }

}





