package net.bitacademy.java72.step01;

public class Test03 {
  // top level inner class
  public static class Calc {
    public static int plus(int a, int b) {
      return a + b;
    }
    
    public static int minus(int a, int b) {
      return a - b;
    }
    
    public static int multiple(int a, int b) {
      return a * b;
    }
    
    public static int divide(int a, int b) {
      return a / b;
    }
  }
  
  public static void main(String[] args) {
    // 10 + 2 * 7 - 5 / 2
    int result = Calc.plus(10, 2);
    result = Calc.multiple(result, 7);
    result = Calc.minus(result, 5);
    result = Calc.divide(result, 2);
    
    System.out.format("10 + 2 * 7 - 5 / 2 = %d\n", result);
    
    
  }

}
