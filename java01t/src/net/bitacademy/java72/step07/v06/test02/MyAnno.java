package net.bitacademy.java72.step07.v06.test02;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// 언제까지 이 주석이 살아 남아야 하는 지 지정한다.
// CLASS => 클래스 파일에 포함. 실행 시 로딩되지 않는다.
// SOURCE => 컴파일할 때 버린다.
// RUNTIME => 실행 시에 클래스 정보와 함께 로딩된다.
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnno {
  //정의하는 방법
  //타입 속성명() default 기본 값;
  String value();
}








