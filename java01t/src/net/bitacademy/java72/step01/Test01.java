package net.bitacademy.java72.step01;

// 학습 목표
/*
  - 클래스 사용
  - 패키지 이름 지정
  - import 사용
  - 클래스에 묶여 있는 메서드 사용
    - 데이터가 필요없는 메서드(클래스 메서드, 스태틱 메서드)
    - 데이터가 필요한 메서드(인스턴스 메서드) 
 */
import java.util.Base64;
import java.util.Base64.Encoder;

//import java.lang.System;
//import java.lang.Math;

//import java.lang.*;

public class Test01 {
  public static void main(String[] args) {
    // 1970/1/1 부터 지금까지 경과된 시간을 밀리초로 알려준다.
    long time = System.currentTimeMillis(); 
    double r = Math.random(); // 0 <= x < 1
    int i = Math.abs(-10);
    Encoder encoder = Base64.getEncoder(); // 데이터를 base64 형식으로 변환시켜는 도구를 만들어준다.
    byte[] result = encoder.encode(new byte[]{1,2,3,4,5});
    
    System.out.println(time);
    System.out.format("%d, %f, %d\n", time, r, i);
  }
}













