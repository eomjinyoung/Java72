package net.bitacademy.java72.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContextLoaderListener 
  implements ServletContextListener {

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    // 웹 애플리케이션이 시작된 후 호출됨.
    // => 웹 애플리케이션이 실행되는 동안 사용할
    //    공통 자원(객체, 파일 등)을 준비한다.
    // 여기서 할 일 => 빈 컨테이너를 준비한다.
    ApplicationContext appContext = 
        new ClassPathXmlApplicationContext(
            sce.getServletContext().getInitParameter(
                "contextConfigLocation"));
    
    // 스프링 빈 컨테이너를 ServletContext 보관소에 저장한다.
    // => 다른 서블릿들이 꺼내서 사용할 수 있도록 저장한다.
    sce.getServletContext().setAttribute(
        "beanContainer", appContext);
    
    System.out.println("contextInitialized()");
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    // 웹 애플리케이션이 종료되기 직전에 호출됨
    // => 준비한 자원을 해제. 
    System.out.println("contextDestroyed()");
  }

}




