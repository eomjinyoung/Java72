package net.bitacademy.java72.servlet;

import static org.reflections.ReflectionUtils.getMethods;
import static org.reflections.ReflectionUtils.withAnnotation;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import net.bitacademy.java72.annotation.RequestMapping;

@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void service(
      HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {
    
    // 스프링 빈 컨테이너 얻기
    ApplicationContext appContext = 
        (ApplicationContext)this.getServletContext()
                          .getAttribute("beanContainer");
    
    /* 서블릿 경로 알아내기
     * http://localhost:9999/web02/board/list.do
     * http: --> 프로토콜, 스키마 
     * //localhost --> 서버 주소(IP, 도메인 이름)
     * :9999 --> 포트 번호. 생략하면 80번이다.
     * /web02 --> 웹 애플리케이션 이름. 컨텍스트 루트.
     * /board/list.do --> 서블릿 경로
     */
    String servletPath = request.getServletPath();
    
    try {
      // 페이지 컨트롤러 찾기
      Object pageController = 
          appContext.getBean(servletPath);
      
      // @RequestMapping 붙은 메서드 알아내기
      Method requestHandler = null;
      Set<Method> methods = getMethods(
          pageController.getClass(), 
          withAnnotation(RequestMapping.class));
      
      requestHandler = (Method)methods.toArray()[0];
      
      String viewUrl = (String)requestHandler.invoke(
          pageController, /* 인스턴스 */
          request, 
          response);
      
      RequestDispatcher rd = 
          request.getRequestDispatcher(viewUrl);
      
      response.setContentType("text/html;charset=UTF-8");
      rd.include(request, response);
      
    } catch (Exception e) {  
      RequestDispatcher rd = 
          request.getRequestDispatcher("/Error.jsp");
      request.setAttribute("error", e);
      rd.forward(request, response);
      return;
    } 
  }
}








