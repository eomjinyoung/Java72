package study.ex2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/study/ex2/servlet1")
public class Servlet1 extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void service(
      HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {
    
    String name = request.getParameter("name");
    String age = request.getParameter("age");
    
    ServletContext context = request.getServletContext();
    context.setAttribute("name", name);
    context.setAttribute("age", age);
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html><body>");
    out.printf("<p>이름:%s</p>\n", name);
    out.printf("<p>나이:%s</p>\n", age);
    out.println("</body></html>");
    
  }
}







