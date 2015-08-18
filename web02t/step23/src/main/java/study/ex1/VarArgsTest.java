package study.ex1;

import java.util.ArrayList;

public class VarArgsTest {

  public static void main(String[] args) {
    int result = plus(10, 20);
    System.out.println(result);
    
    System.out.println(plus2());
    
    System.out.println(plus2(10));
    
    System.out.println(plus2(10,20));
    
    System.out.println(plus2(10,20,30));
    
    System.out.println(plus2(10,20,30,40));
    
    score("홍길동", 100, 90);
    score("임꺽정", 100, 90, 80, 90, 70, 70);
    
    // 가변 파라미터 값을 전달할 때
    // 배열에 담아서 전달할 수 있다.
    score("유관순", new int[]{100,100,100,90});
    
  }
  
  // 파라미터의 개수가 정해진 경우
  public static int plus(int a, int b) {
    return a + b;
  }
  
  // 파라미터의 개수가 변하는 경우
  public static int plus2(int... args) {
    int sum = 0;
    for (int v : args) {
      sum += v;
    }
    return sum;
  }
  
  // 가변 파라미터 앞에 다른 변수를 선언할 수 있다.
  // 단, 가변 파라미터 뒤에 다른 변수를 선언할 수 없다.
  // 가변 파라미터는 반드시 메서드의 파라미터 선언에서
  // 맨 뒤에 있어야 한다.
  public static void score(String name, int... scores) {
    int sum = 0;
    for (int v : scores) {
      sum += v;
    }
    
    System.out.printf("%s: 총점(%d), 평균(%d)\n"
        , name, sum, (sum / scores.length));
  }
}







