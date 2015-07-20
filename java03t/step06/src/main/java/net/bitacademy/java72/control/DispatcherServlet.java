package net.bitacademy.java72.control;

import static org.reflections.ReflectionUtils.getMethods;
import static org.reflections.ReflectionUtils.withAnnotation;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Set;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.bitacademy.java72.annotation.RequestMapping;

// 톰캣 서버에게 URL이 *.do로 끝나는 요청을 들어 왔을 때
// 이 클래스의 service() 메서드를 호출하라고 알린다.
@WebServlet("*.do")
public class DispatcherServlet implements Servlet {
  ApplicationContext appContext;
  
  // 톰캣 서버를 실행할 때 자동으로 호출되는 메서드
  @Override
  public void init(ServletConfig config) throws ServletException {
    // 스프링 프레임워크 준비
    appContext = new ClassPathXmlApplicationContext(
        "net/bitacademy/java72/application-context.xml");
  }

  @Override
  public ServletConfig getServletConfig() {
    return null;
  }

  // 웹 브라우저가 요청할 때마다 
  // 톰캣 서버가 호출한다.
  @Override
  public void service(
      ServletRequest req, 
      ServletResponse res) throws ServletException, IOException {
    // 준비: 톰캣 서버가 준 도구를 원래 객체로 형변환시킨다.
    HttpServletRequest request = 
        (HttpServletRequest)req;
    HttpServletResponse response = 
        (HttpServletResponse)res;
    
    // 명령어 알아내기
    // URL: http://localhost:8080/web01/board/list.do
    // => /board/list.do
    String servletPath = request.getServletPath();
    System.out.println("=========>" + servletPath);
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    HashMap<String,Object> paramMap = 
        new HashMap<String,Object>();
    paramMap.put("out", out);
    
    Enumeration<String> paramNameList = 
        req.getParameterNames();
    
    String name = null;
    while (paramNameList.hasMoreElements()) {
      name = paramNameList.nextElement();
      paramMap.put(name, req.getParameter(name));
    }
    
    try {
      Object commandWorker = 
          appContext.getBean(servletPath.substring(1));
      Set<Method> methods = null;
      Method temp = null;
      methods = getMethods(
          commandWorker.getClass(), 
          withAnnotation(RequestMapping.class));
      temp = (Method)methods.toArray()[0];
      temp.invoke(commandWorker, paramMap);
      
    } catch (Exception e) {  
      e.printStackTrace();
      out.println("해당 명령을 지원하지 않습니다!");
    } 
  }

  @Override
  public String getServletInfo() {
    return null;
  }

  @Override
  public void destroy() {
  }

}
