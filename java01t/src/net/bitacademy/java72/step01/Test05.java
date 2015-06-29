package net.bitacademy.java72.step01;

//학습 목표
/*
  - 클래스 만들기
    - 인스턴스 변수 활용
    - 데이터를 개별적으로 관리하고 싶다면 인스턴스 변수로 만들어라.
      => 인스턴스마다 별개로 데이터를 관리한다.
 */
public class Test05 {
  // top level inner class
  public static class Calc {
    int result;
    
    public static void plus(int a, Calc c) {
      c.result += a;
    }
    
    public static void minus(int a, Calc c) {
      c.result -= a;
    }
    
    public static void multiple(int a, Calc c) {
      c.result *= a;
    }
    
    public static void divide(int a, Calc c) {
      c.result /= a;
    }
  }
  
  public static void main(String[] args) {
    Calc c1 = new Calc();
    Calc c2 = new Calc();
    
    // 10 + 2 * 7 - 5 / 2
    // 2 * 7 - 3 + 11
    Calc.plus(10, c1);
    Calc.plus(2, c2); 
    
    Calc.plus(2, c1);
    Calc.multiple(7, c2);
    
    Calc.multiple(7, c1);
    Calc.minus(3, c2);
    
    Calc.minus(5, c1);
    Calc.plus(11, c2);
    
    Calc.divide(2, c1);
    
    System.out.format("10 + 2 * 7 - 5 / 2 = %d\n", c1.result);
    System.out.format("2 * 7 - 3 + 11 = %d\n", c2.result);
    
    
  }

}






