package net.bitacademy.java72.step01;

//학습 목표
/*
  - 클래스 만들기
    - 데이터를 필요로 하는 "인스턴스 메서드" 정의 => Calc.java   
  
 */
public class Test06 {
  // top level inner class
  public static class Calc {
    int result;
    
    public void plus(int a /*, Calc this */) {
      this.result += a;
    }
    
    public void minus(int a /*, Calc this */) {
      this.result -= a;
    }
    
    public void multiple(int a /*, Calc this */) {
      this.result *= a;
    }
    
    public void divide(int a /*, Calc this */) {
      this.result /= a;
    }
  }
  
  public static void main(String[] args) {
    Calc c1 = new Calc();
    Calc c2 = new Calc();
    
    // 10 + 2 * 7 - 5 / 2
    // 2 * 7 - 3 + 11
    c1.plus(10);
    c2.plus(2); 
    
    c1.plus(2);
    c2.multiple(7);
    
    c1.multiple(7);
    c2.minus(3);
    
    c1.minus(5);
    c2.plus(11);
    
    c1.divide(2);
    
    System.out.format("10 + 2 * 7 - 5 / 2 = %d\n", c1.result);
    System.out.format("2 * 7 - 3 + 11 = %d\n", c2.result);
    
    
  }

}






