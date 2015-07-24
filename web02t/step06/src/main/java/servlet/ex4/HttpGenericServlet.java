package servlet.ex4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class HttpGenericServlet 
  extends GenericServlet {
  
  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    service((HttpServletRequest) req,
        (HttpServletResponse) res);
  }
  
  // 개발자를 위해 추가한 메서드
  // => service() 파라미터 값을 미리 HttpXxxx 타입으로
  //    형변환하였다.
  protected void service(
      HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {
    if (request.getMethod().equals("GET")) {
      doGet(request, response);
    } else if  (request.getMethod().equals("POST")) {
      doPost(request, response);
    }
  } 
  
  protected void doGet(
      HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head><title>오류!</title></head>");
    out.println("<body>");
    out.println(
        "<p>이 서비스는 GET 요청을 지원하지 않습니다.</p>");
    out.println("</body></html>");
  }
  
  protected void doPost(
      HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head><title>오류!</title></head>");
    out.println("<body>");
    out.println(
        "<p>이 서비스는 POST 요청을 지원하지 않습니다.</p>");
    out.println("</body></html>");
  }

}






