package net.bitacademy.java72.step03.ex;

import java.lang.reflect.Method;


public class Quiz01 {

  public static void main(String[] args) throws Exception {
    
    //문1. Class 클래스를 사용하여 현재 시각을 1970/1/1 이후부터 지나온 초를 출력하라.
    //System.currentTimeMillis()
    ///System 클래스 정보를 다룰 도구를 얻는다.
    Class c = Class.forName("java.lang.System");
    //currentTimeMillis()를 다룰 도구를 얻는다.
    Method m = c.getMethod("currentTimeMillis");
    //메서드를 호출한다.
    long l = (long)m.invoke(null);
    //밀리초를 초로 바꿔서 출력한다.
    System.out.println(l/1000);
    
    
    //문2. Class 클래스를 사용하여 -5의 절대 값을 알아내라.
    // Math.abs(-5);
    // Math를 다룰 도구를 얻는다.
    c = Class.forName("java.lang.Math");
    // abs를 다룰 도구를 얻는다.
    m = c.getMethod("abs",int.class);
    // 메소드를 호출한다.
    int b = (int)m.invoke(null, -5);
    // 값을 출력한다.
    System.out.println(b);

  }

}



















