package net.bitacademy.java72.step06.v06.ex;

public class Test01 {

  static {
    System.out.println("Test01...");
  }
  
  public static void main(String[] args) {
    MyClass obj = null;
    
    MyClass.a = 10;
    MyClass.m();
    obj = new MyClass();

  }

}
