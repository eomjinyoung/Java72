package net.bitacademy.java72.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter {
  FilterConfig filterConfig;
  
  @Override
  public void init(FilterConfig filterConfig) 
      throws ServletException {
    // 필터 객체를 생성한 후에 바로 호출된다.
    // 필터가 작업하는데 필요한 자원을 
    // 준비하는 코드를 작성하라!
    this.filterConfig = filterConfig;
  }

  @Override
  public void doFilter(
      ServletRequest request, 
      ServletResponse response, 
      FilterChain chain)
      throws IOException, ServletException {
    // 서블릿 또는 다음 필터 호출 전 해야할 일
    request.setCharacterEncoding(
        filterConfig.getInitParameter("encoding"));
    
    // 서블릿 또는 다음 필터 호출
    // FilterChain 객체에게 다음 필터를 
    // 호출해 달라고 요청한다.
    // 만약 필터가 없다면, FilterChain은 서블릿을 실행한다.
    chain.doFilter(request, response);
    
    // 서블릿 또는 다음 필터 호출이 끝난 후에 해야할 일
    
  }

  @Override
  public void destroy() {
    // init() 메서드에서 준비한 자원을 해제시키는
    // 코드를 작성하라!
    
  }

}






