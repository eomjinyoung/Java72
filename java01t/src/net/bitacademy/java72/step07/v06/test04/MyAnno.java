package net.bitacademy.java72.step07.v06.test04;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnno {
  String name(); // 필수 속성
}








