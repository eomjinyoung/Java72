package net.bitacademy.java72.step01;

import java.util.Calendar;
import java.util.Date;

//학습 목표
/*
 - 데이터 준비 = 인스턴스 준비 
    - new 명령어 사용
    - 메서드를 호출 => 데이터 준비 과정이 복잡한 경우, 복잡함을 감추기 위해서.
 */
public class Test02 {

  public static void main(String[] args) {
    Date today = new Date(); // 현재 날짜 및 시각 데이터를 준비한다.
    System.out.println(today);
    
    Calendar cal = Calendar.getInstance();
    int date = cal.get(Calendar.DATE);
    System.out.println(date);
  }

}














