package study;

public class A {
  public static void main(String[] args) {
    B.m();
    
    try {
      B.m2();
    } catch (Exception e) {
      System.out.println("잠시 시스템이 바쁩니다.\n"
          + "잠시 후 다시 시도해 주세요.");
    }
    
    try {
      B.m3();
    } catch (RuntimeException e) {
      System.out.println("이놈 잡았다!");
    }
  }
}






