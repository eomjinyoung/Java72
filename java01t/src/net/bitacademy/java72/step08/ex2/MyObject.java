package net.bitacademy.java72.step08.ex2;

public class MyObject {
  // ThreadLocal은 각각의 스레드가 관리하는 값 보관소이다.
  // => 한 개의 값만 저장 가능
  // => 여러 개 저장하고 싶으면 ThreadLocal을 여러 개 선언하라.
  // => localValueBox가 가리키는 것은 현재 스레드의 변수이다.
  ThreadLocal<Integer> localValueBox = 
      new ThreadLocal<Integer>();

  public int getValue() {
    return localValueBox.get();
  }

  public void setValue(int value) {
    localValueBox.set(value);
  }
}
