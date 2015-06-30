package net.bitacademy.java72.step02;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

public class Test04 {
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

    @Override
    public String toString() {
      return "Member [name=" + name + ", id=" + id + ", password=" + password
          + ", email=" + email + ", tel=" + tel + ", regDate=" + regDate + "]";
    }
    
  }
  public static void main(String[] args) {
    int a = 20;
    Member m1 = new Member(
        "홍길동", "hong", "1111", "hong@test.com", "111-1111", null);
    Member m2 = new Member(
        "홍길동", "hong", "1111", "hong@test.com", "111-1111", null);
  
    if (m1 != m2) {
      System.out.println("m1 != m2");
    }
    
    if (!m1.equals(m2)) {
      System.out.println("!m1.equals(m2)");
    }
    
    String s1 = new String("Hello");
    String s2 = new String("Hello");
    if (s1 != s2) {
      System.out.println("s1 != s2");
    }
    
    if (s1.equals(s2)) {
      System.out.println("s1.equals(s2)");
    }

  }

}




















