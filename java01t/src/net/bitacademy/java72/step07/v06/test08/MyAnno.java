package net.bitacademy.java72.step07.v06.test08;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// 배열 속성 
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnno {
  String[] value(); 
}








