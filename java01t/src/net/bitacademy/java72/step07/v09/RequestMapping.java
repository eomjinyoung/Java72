package net.bitacademy.java72.step07.v09;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// 요청을 처리하는 메서드에 붙이는 애노테이션이다.
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestMapping {
  String value() default "";
}
