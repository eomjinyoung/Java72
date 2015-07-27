package net.bitacademy.java72.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/header")
public class HeaderServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  protected void service(
      HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {
    
    PrintWriter out = response.getWriter();
    out.println("<style type=\"text/css\">");
    out.println("#pageFooter {");
    out.println("  font-size: 70%;");
    out.println("  background-color: yellow;  ");
    out.println("    padding: 5px;");
    out.println("}");
    out.println("</style>");
  }

}








