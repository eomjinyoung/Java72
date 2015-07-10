package net.bitacademy.java72.step07.v06.test06;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnno {
  String value(); // 필수 속성
  String name() default "오호라"; // 선택 속성
}








