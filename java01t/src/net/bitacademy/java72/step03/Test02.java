package net.bitacademy.java72.step03;

import java.lang.reflect.Method;

public class Test02 {

  public static void main(String[] args) throws Exception {
    // 객체 생성하는 방법
    // 1) new 명령 
    Member m1 = new Member();
    
    // 2) factory 메서드
    Member m2 = MemberFactory.getInstance("임꺽정", "leem", "1111");
    
    // 3) Class를 이용한 방법
    // - 클래스를 로딩한다. => 리턴 값은 클래스를 다루는 클래스
    Class c = Class.forName("net.bitacademy.java72.step03.Member");
    
    //public 메서드 목록 조회 
    Method[] methods = c.getMethods();
    for (Method m : methods) {
      System.out.println(m.getName());
    }
    
    // 인스턴스 생성 하기 
    Member m3 = (Member)c.newInstance();
    m3.setName("오호라");
    System.out.println(m3);

  }

}







