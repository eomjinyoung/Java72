package net.bitacademy.java72.step07.v06.test07;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnno {
  String value() default "ok"; // 선택 속성
  String name() default "오호라"; // 선택 속성
}








