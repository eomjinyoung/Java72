package net.bitacademy.java72.step05.ex;

public class Test01 {
  static class Car {}
  static class Tico extends Car {}
  static class UltraTico extends Tico {}
  static class Sonata extends Car {}
  
  public static void main(String[] args) {
    Car c1 = new Car();
    Car c2 = new Tico();
    Car c3 = new Sonata();
    
    drive(new Car());
    drive(new Tico());
    drive(new Sonata());
    
    drive2(new Tico());
    drive2(new UltraTico());
    //drive2(new Sonata());
    //drive2(new Car());
  }
  
  public static void drive(Car c) {}
  
  public static void drive2(Tico c) {}

}








