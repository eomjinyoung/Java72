package study.ex2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/study/ex2/servlet2")
public class Servlet2 extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void service(
      HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {
    
    ServletContext context = request.getServletContext();
    String name = (String)context.getAttribute("name");
    String age = (String)context.getAttribute("age");
    
    int weight = Integer.parseInt(
        request.getParameter("weight"));
    int height = Integer.parseInt(
        request.getParameter("height"));
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html><body>");
    out.printf("<p>이름:%s</p>\n", name);
    out.printf("<p>나이:%s</p>\n", age);
    out.printf("<p>몸무게:%d</p>\n", weight);
    out.printf("<p>키:%d</p>\n", height);
    out.println("</body></html>");
    
  }
}







