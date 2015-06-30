package net.bitacademy.java72.step01;

public class Test08 {
  static int plus(int a, int b) {
    return a + b;
  }
  
  static float plus(float a, float b) {
    return a + b;
  }
  
  public static void main(String[] args) {
    int r = plus(10, 20);
    float f = plus(10.2f, 20.3F);
    
    System.out.printf("%d\n", r);
    System.out.printf("%f\n", f);
  }
}
