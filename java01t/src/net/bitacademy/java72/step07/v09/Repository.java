package net.bitacademy.java72.step07.v09;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Repository {
  String value() default "";
}
