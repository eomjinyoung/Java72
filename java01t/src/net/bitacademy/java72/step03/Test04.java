package net.bitacademy.java72.step03;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Test04 {

  public static void main(String[] args) throws Exception {
    Class c = Class.forName("net.bitacademy.java72.step03.Member");

    Method[] methods = c.getMethods();
    Parameter[] parameters = null;
    
    for (Method m : methods) {
      System.out.println(m.getName());
      
      // 메서드의 파라미터 정보를 출력하기
      // 1) 파라미터 목록 가져오기
      parameters = m.getParameters();
      for (Parameter p : parameters) {
        System.out.printf("---> %s:%s\n", 
            p.getName(), p.getType().getName());
      }
    }
  }

}




















