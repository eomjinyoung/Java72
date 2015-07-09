package net.bitacademy.java72.step07.v06.test02;

import java.lang.annotation.Annotation;

public class Test01 {
  public static void main(String[] args) {
    Class<?> clazz = MyObject.class;
    Annotation[] annoList = clazz.getAnnotations();
    for (Annotation anno : annoList) {
      System.out.println(anno);
    }
    System.out.println("끝!");
  }
}

/* 분명히 MyObject에 MyAnno라는 애노테이션이 
 * 있음에도 불구하고, 어떤 애노테이션 이름도 출력하지 않는다.
 * 그 이유는?
 * 
 * - "MyObject.class" 파일에는 애노테이션 정보가 있는데, 
 *   JVM이 MyObject 클래스를 로딩할 때
 *   애노테이션 정보를 빼로 로딩한다. 엥?
 * - MyAnno는 주석을 유지하는 기본 정책이 CLASS이다.
 *   즉, 클래스 파일에 포함하되, 실행할 때 로딩하지 않는다.
 *   
 * 애노테이션 유지 정책(RetentionPolicy)
 * 1) CLASS (기본)
 *    => 클래스 파일에 포함.
 *    => 클래스 로딩할 때 제거.
 * 2) RUNTIME
 *    => 클래스 파일에 포함.
 *    => 클래스 로딩할 때 함께 로딩됨.
 * 3) SOURCE
 *    => 컴파일할 때 제거된다.
 *     
 * 
 */













