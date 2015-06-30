package net.bitacademy.java72.step03;

public class Test01 {
  
  public static void main(String[] args) {
    Member m1 = new Member();
    m1.setName("홍길동");
    m1.setId("hong");
    m1.setPassword("1111");
    m1.setEmail("hong@test.com");
    m1.setTel("111-1111");

    // chaining call
    Member m2 = new Member()
                    .setName("홍길동")
                    .setId("hong")
                    .setPassword("1111")
                    .setEmail("hong@test.com")
                    .setTel("111-1111");
    
  }
}
