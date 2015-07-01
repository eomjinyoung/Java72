package net.bitacademy.java72.step04;

public class Test02 {

  public static void main(String[] args) {
    Member m = createMember();
    int a = 10;
    m1(a, m);
    System.out.println(a);
    System.out.println(m);
  }
  
  public static void m1(int a, Member m) {
    a += 10;
    m.setId("hong");
    m2(a, m);
  }
  
  public static void m2(int a, Member m) {
    a += 10;
    m.setPassword("1111");
  }
  
  public static Member createMember() {
    Member m = new Member().setName("홍길동").setEmail("hong@test.com");
    Member m2 = m;
    m2.setTel("111-1111");
    return m2;
  }

}













