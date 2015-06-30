package net.bitacademy.java72.step02;

import java.util.ArrayList;
import java.util.Date;

public class Test02 {
  static class Member {
    String name;
    String id;
    String password;
    String email;
    String tel;
    Date regDate;
    
    public Member(String name, String id, String password, String email,
        String tel, Date regDate) {
      this.name = name;
      this.id = id;
      this.password = password;
      this.email = email;
      this.tel = tel;
      this.regDate = regDate;
    }
    
  }
  public static void main(String[] args) {
    int a = 20;
    Member m1 = new Member(
        "홍길동", "hong", "1111", "hong@test.com", "111-1111", null);
    Member m2 = new Member(
        "임꺽정", "leem", "1111", "leem@test.com", "111-1112", null);
    Member m3 = new Member(
        "유관순", "yoo", "1111", "yoo@test.com", "111-1113", null);

    //m1 = m2;
    System.out.println(m1.hashCode());
    System.out.println(m2.hashCode());
    System.out.println(m3.hashCode());
    
    // ArrayList를 이용하여 객체 보관하기
    ArrayList<Member> list = new ArrayList<Member>();
    list.add(m1); // 인스턴스 주소를 보관한다.
    list.add(m2);
    list.add(m3);
    
    System.out.println(list.get(0));
    System.out.println(list.get(1));
    System.out.println(list.get(2));
    //System.out.println(list.get(3));
    
  }

}




















