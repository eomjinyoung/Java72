package servlet.ex3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/step04/ex3/servleta")
public class ServletA extends GenericServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(
      ServletRequest request, 
      ServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    // 응답 헤더에 Refresh 정보를 추가한다.
    //1) HTTP 프로토콜을 조작하고 싶다.
    //   => ServletResponse에는 그런 메서드가 없다.
    //   => 원래 타입으로 캐스팅하여 사용할 것이다.
    HttpServletResponse response2 = 
        (HttpServletResponse) response;
    response2.setHeader("Refresh", "1;url=servletb");
    
    out.println("<html>");
    out.println("<head>");
    out.println("  <meta charset='UTF-8'>");
    out.println("  <title>페이지 A</title>");  
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>페이지 A</h1>");
    out.println("</body>");
    out.println("</html>");
  }

}





