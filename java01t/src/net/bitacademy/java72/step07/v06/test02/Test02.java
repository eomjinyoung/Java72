package net.bitacademy.java72.step07.v06.test02;

import java.lang.annotation.Annotation;

public class Test02 {
  public static void main(String[] args) {
    Class<?> clazz = MyObject.class;
    MyAnno anno = clazz.getAnnotation(MyAnno.class);
    System.out.println(anno.value());
  }
}













