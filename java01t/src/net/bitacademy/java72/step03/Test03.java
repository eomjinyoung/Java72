package net.bitacademy.java72.step03;

import java.lang.reflect.Method;

public class Test03 {

  public static void main(String[] args) throws Exception {
    Member member1 = new Member()
                      .setName("홍길동")
                      .setId("hong")
                      .setPassword("1111")
                      .setEmail("hong@test.com")
                      .setTel("111-1111");
    Member member2 = new Member()
                      .setName("임꺽정")
                      .setId("leem")
                      .setPassword("1111")
                      .setEmail("leem@test.com")
                      .setTel("111-1112");

    Class c = Class.forName("net.bitacademy.java72.step03.Member");
    
    // 1) public 메서드 목록 조회 
    Method[] methods = c.getMethods();
    for (Method m : methods) {
      System.out.println(m.getName());
    }
    System.out.println("---------------------------------------");
    
    // 2) 파라미터가 없는 특정 이름을 갖는 메서드를 다룰 수 있는 도구 꺼내기
    Method m = c.getMethod("getName");
    
    // - 메서드 호출하기 
    System.out.println(m.invoke(member1));
    System.out.println(m.invoke(member2));
    
    // 3) 파라미터가 있는 메서드 호출하기 : setName(String)
    m = c.getMethod("setName", String.class);
    m.invoke(member1, "오호라");
    System.out.println(member1);
    
  }

}




















