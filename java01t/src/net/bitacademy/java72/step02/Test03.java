package net.bitacademy.java72.step02;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

public class Test03 {
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
        "임꺽정", "leem", "1111", "leem@test.com", "111-1112", null);
    Member m3 = new Member(
        "유관순", "yoo", "1111", "yoo@test.com", "111-1113", null);
    Member m4 = new Member(
        "유관순", "yoo", "1111", "yoo@test.com", "111-1113", null);

    // HashSet - 중복을 허용하지 않는다.
    HashSet<Member> set = new HashSet<Member>();
    // add() 실행 절차
    // 1) 파라미터로 넘어온 객체의 해시코드 값이 기존 리스트에 있는가?
    // 2) 기존에 있는 객체와 파라미터 객체를 equals()로 비교한다.
    // 3) 다르다고 결론이 난다면 해당 객체를 저장한다.
    set.add(m1); 
    set.add(m2);
    set.add(m3);
    set.add(m4);
    set.add(m1);
    set.add(m2);
    set.add(m3);
    set.add(m4);
    
    for (Member m : set) {
      System.out.println(m);
    }
    
    
  }

}




















