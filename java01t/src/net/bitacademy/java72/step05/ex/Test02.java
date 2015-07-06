package net.bitacademy.java72.step05.ex;


public class Test02 {
  static interface Car {}
  static interface Computer {}
  static class Tico implements Car {}
  static class Sonata implements Car, Computer {}
  
  public static void main(String[] args) {
    //drive(new Car());
    drive(new Tico());
    drive(new Sonata());
    
    //booting(new Tico());
    booting(new Sonata());
  }
  
  public static void drive(Car c) {}
  public static void booting(Computer c) {}
}










