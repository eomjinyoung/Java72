package net.bitacademy.java72.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/footer")
public class FooterServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  protected void service(
      HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {
    
    // 메인 서블릿에서 콘텐츠 타입을 설정하기 때문에
    // 인클루드 되는 서블릿은 콘텐츠 타입을 설정할 필요가 없다.
    //response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.println("<div id='pageFooter'>");
    out.println("<p>이 사이트의 모든 권리는 비트캠프의 ");
    out.println("    Java72기에 있습니다.</p>");
    out.println("<address>서울시 서초구 서초동 비트캠프</address>");
    out.println("</div>");
  }

}








