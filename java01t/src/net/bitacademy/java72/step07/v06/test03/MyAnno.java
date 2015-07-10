package net.bitacademy.java72.step07.v06.test03;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnno {
  String value(); // 필수 속성
}








