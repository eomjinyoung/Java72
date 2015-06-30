package net.bitacademy.java72.step02;

import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;

public class Test06 {
  static class Key {
    String id;
    public Key(String id) {
      this.id = id;
    }
    
    // 인스턴스 변수의 값이 같으면 같은 해시코드를 리턴한다.
    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((id == null) ? 0 : id.hashCode());
      return result;
    }
    
    // 인스턴스 변수의 값이 같으면 true를 리턴한다.
    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      Key other = (Key) obj;
      if (id == null) {
        if (other.id != null)
          return false;
      } else if (!id.equals(other.id))
        return false;
      return true;
    }
    
    
  }
  
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
    Key k1 = new Key("hong");
    Key k2 = new Key("leem");
    Key k3 = new Key("yoo");
    
    Member m1 = new Member(
        "홍길동", "hong", "1111", "hong@test.com", "111-1111", null);
    Member m2 = new Member(
        "임꺽정", "leem", "1111", "leem@test.com", "111-1112", null);
    Member m3 = new Member(
        "유관순", "yoo", "1111", "yoo@test.com", "111-1113", null);

    HashMap<Key,Member> map = new HashMap<Key,Member>();
    map.put(k1, m1);
    map.put(k2, m2);
    map.put(k3, m3);

    // 값을 찾는 절차
    // 1) 키의 해시코드 값으로 보관소에서 찾는다.
    // 2) 보관소에 들어있는 키 객체와 파라미터로 넘긴 키 객체가 같은지 
    //    equals()를 호출하여 비교한다.
    // 
    System.out.println(map.get(k1));
    
    Key k4 = new Key("hong");
    System.out.println(map.get(k4));
    
  }

}




















