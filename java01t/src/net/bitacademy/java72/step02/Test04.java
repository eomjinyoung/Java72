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

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((email == null) ? 0 : email.hashCode());
      result = prime * result + ((id == null) ? 0 : id.hashCode());
      result = prime * result + ((name == null) ? 0 : name.hashCode());
      result = prime * result + ((password == null) ? 0 : password.hashCode());
      result = prime * result + ((regDate == null) ? 0 : regDate.hashCode());
      result = prime * result + ((tel == null) ? 0 : tel.hashCode());
      return result;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      Member other = (Member) obj;
      if (email == null) {
        if (other.email != null)
          return false;
      } else if (!email.equals(other.email))
        return false;
      if (id == null) {
        if (other.id != null)
          return false;
      } else if (!id.equals(other.id))
        return false;
      if (name == null) {
        if (other.name != null)
          return false;
      } else if (!name.equals(other.name))
        return false;
      if (password == null) {
        if (other.password != null)
          return false;
      } else if (!password.equals(other.password))
        return false;
      if (regDate == null) {
        if (other.regDate != null)
          return false;
      } else if (!regDate.equals(other.regDate))
        return false;
      if (tel == null) {
        if (other.tel != null)
          return false;
      } else if (!tel.equals(other.tel))
        return false;
      return true;
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
    
    // Object.equals() => 인스턴스가 다르면 false를 리턴한다.
    // => 재정의 해야만 같은 데이터를 갖는 경우 true를 리턴할 수 있다.
    if (m1.equals(m2)) {
      System.out.println("m1.equals(m2)");
    }
    
    String s1 = new String("Hello");
    String s2 = new String("Hello");
    if (s1 != s2) {
      System.out.println("s1 != s2");
    }
    
    if (s1.equals(s2)) {
      System.out.println("s1.equals(s2)");
    }
    
    StringBuffer sb1 = new StringBuffer("Hello");
    StringBuffer sb2 = new StringBuffer("Hello");
    if (sb1 != sb2) {
      System.out.println("sb1 != sb2");
    }
    
    if (sb1.equals(sb2)) {
      System.out.println("sb1.equals(sb2)");
    }
    
    Integer i1 = new Integer(10);
    Integer i2 = new Integer(10);
    if (i1 != i2) {
      System.out.println("i1 != i2");
    }
    
    if (i1.equals(i2)) {
      System.out.println("i1.equals(i2)");
    } 
  }

}




















