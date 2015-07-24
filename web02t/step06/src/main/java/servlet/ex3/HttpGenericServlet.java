package servlet.ex3;

import java.io.IOException;

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
    
  } 

}






