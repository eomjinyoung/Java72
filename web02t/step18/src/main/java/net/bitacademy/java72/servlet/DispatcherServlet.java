package net.bitacademy.java72.servlet;

import static org.reflections.ReflectionUtils.getMethods;
import static org.reflections.ReflectionUtils.withAnnotation;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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
    ServletContext servletContext = 
                    this.getServletContext();
    ApplicationContext appContext = 
      (ApplicationContext)servletContext.getAttribute(
                                          "beanContainer");
    /*
    ApplicationContext appContext = 
        (ApplicationContext)this.getServletContext()
                          .getAttribute("beanContainer");
    */ 
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
      
      @SuppressWarnings("unchecked")
      Set<Method> methods = getMethods(
          pageController.getClass(), 
          withAnnotation(RequestMapping.class));
      
      requestHandler = (Method)methods.toArray()[0];
      
      // 메서드의 파라미터를 분석하여
      // 메서드를 호출할 때 전달할 파라미터 값을 준비한다.
      Map<String,Object> extraObjMap = 
          new HashMap<String,Object>();
      extraObjMap.put("HttpServletRequest", request);
      extraObjMap.put("HttpServletResponse", response);
      extraObjMap.put("HttpSession", request.getSession());
      extraObjMap.put("ServletContext", this.getServletContext());
      
      Object[] paramValues = 
          prepareMethodParameterValues(
              requestHandler, extraObjMap);
      
      String viewUrl = (String)requestHandler.invoke( 
          pageController, /* 인스턴스 */
          paramValues);
      
      if (viewUrl.startsWith("redirect:")) {
        response.sendRedirect(viewUrl.substring(9));
      } else {
        RequestDispatcher rd = 
            request.getRequestDispatcher(viewUrl);
        
        response.setContentType("text/html;charset=UTF-8");
        rd.include(request, response);
      }
    } catch (Exception e) {  
      RequestDispatcher rd = 
          request.getRequestDispatcher("/Error.jsp");
      request.setAttribute("error", e);
      rd.forward(request, response);
      return;
    } 
  }

  private Object[] prepareMethodParameterValues(
      Method m, Map<String,Object> extraObjMap) {
    //0. 파라미터 값을 담을 보관소 준비
    ArrayList<Object> paramValues = new ArrayList<Object>();
    
    //1. 호출할 메서드의 파라미터 정보를 추출한다.
    Parameter[] params = m.getParameters();
    
    String paramName = null;
    Class<?> paramType = null;
    Object paramValue = null;
    
    for (Parameter p : params) {
      paramName = p.getName();
      paramType = p.getType();
      
      //2. 파라미터에 해당하는 데이터를 준비한다.
      if (paramType.isPrimitive()) {
        paramValue = getPrimitiveParameterValue(
            paramType, 
            paramName, 
            (HttpServletRequest)extraObjMap.get(
                "HttpServletRequest"));
      } else if (extraObjMap.containsKey(
                          paramType.getSimpleName())) {
        paramValue = extraObjMap.get(
                            paramType.getSimpleName());
      } else {
        paramValue = null;
      }
      
      paramValues.add(paramValue);
    }
    
    //3. 준비한 파라미터 값을 배열로 만들어 리턴한다.
    return paramValues.toArray();
  }

  private Object getPrimitiveParameterValue(
    Class<?> paramType, 
    String paramName,
    HttpServletRequest request) {
  
    String value = request.getParameter(paramName);
    switch (paramType.getName()) {
    case "int":
      return Integer.parseInt(value);
    case "long":
      return Long.parseLong(value);
    case "short":
      return Short.parseShort(value);
    case "byte":
      return Byte.parseByte(value);
    case "float":
      return Float.parseFloat(value); 
    case "double":
      return Double.parseDouble(value);
    case "boolean":
      return Boolean.parseBoolean(value);
    default: //"char"
      return value.charAt(0);
    }
  }
}








