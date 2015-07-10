package net.bitacademy.java72.step07.v06.test06;

public class Test01 {
  public static void main(String[] args) {
    Class<?> clazz = MyObject.class;
    MyAnno anno = clazz.getAnnotation(MyAnno.class);
    System.out.println(anno.name());
    System.out.println(anno.value());
  }
}













