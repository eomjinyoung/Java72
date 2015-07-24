package servlet.ex4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/step04/ex4/servleta")
public class ServletA extends GenericServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(
      ServletRequest request, 
      ServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    /* 출력은 PrintWriter 내부 버퍼(8KB)에 보관된다.
     * service() 호출이 끝나거나, 
     * 버퍼가 꽉 찼을 때 자동 방출된다.
     */
    out.println("<html>");
    out.println("<head>");
    out.println("  <meta charset='UTF-8'>");
    out.println("  <title>페이지 A</title>");  
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>페이지 A</h1>");
    out.println("</body>");
    out.println("</html>");
    
    
    HttpServletResponse response2 = 
        (HttpServletResponse)response;
    /* 출력 버퍼에 보관된 내용을 버린다.
     * 응답 헤더에 리다이렉트할 주소를 추가한다.
     * 예) Location: http://localhost:9999/web02t/step04/ex4/servletb
     * 그리고 status line의 상태 코드도 
     * 200이 아니라 302가 된다.
     */
    response2.sendRedirect("servletb");
  }

}

/* Redirect의 응답 프로토콜 예)
HTTP/1.1 302 Found
Server: Apache-Coyote/1.1
Location: http://localhost:9999/web02t/step04/ex4/servletb
Content-Type: text/html;charset=UTF-8
Content-Length: 0
Date: Fri, 24 Jul 2015 01:18:05 GMT
 
 */














