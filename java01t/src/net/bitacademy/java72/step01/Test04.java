package net.bitacademy.java72.step01;

//학습 목표
/*
  - 클래스 만들기
    - 클래스 변수(스태틱 변수) 활용
 */
public class Test04 {
  // top level inner class
  public static class Calc {
    static int result;
    
    public static void plus(int a) {
      result += a;
    }
    
    public static void minus(int a) {
      result -= a;
    }
    
    public static void multiple(int a) {
      result *= a;
    }
    
    public static void divide(int a) {
      result /= a;
    }
  }
  
  public static void main(String[] args) {
    // 10 + 2 * 7 - 5 / 2
    // 2 * 7 - 3 + 11
    Calc.plus(10);
    //Calc.plus(2); // 클래스 변수는 동시에 작업할 수 없다.
    
    Calc.plus(2);
    //Calc.multiple(7);
    
    Calc.multiple(7);
    //Calc.minus(3);
    
    Calc.minus(5);
    //Calc.plus(11);
    
    Calc.divide(2);
    
    System.out.format("10 + 2 * 7 - 5 / 2 = %d\n", Calc.result);
    
    
  }

}






