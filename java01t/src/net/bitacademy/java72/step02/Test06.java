package net.bitacademy.java72.step02;

import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;

public class Test06 {
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

    HashMap<String,Member> map = new HashMap<String,Member>();
    map.put("hong", m1);
    map.put("leem", m2);
    map.put("yoo", m3);
    map.put("hong", m3);
    
    // 값만 꺼내기
    for (Member m : map.values()) {
      System.out.println(m);
    }
    System.out.println("-------------------------------------");
    
    // 키만 꺼내기
    for (String key : map.keySet()) {
      System.out.println(key);
    }
    System.out.println("-------------------------------------");
    
    // 키와 값을 함께 꺼내기
    for ( Entry<String,Member> entry: map.entrySet()) {
      System.out.printf("%s: %s\n", entry.getKey(), entry.getValue());
    }
    System.out.println("-------------------------------------");
    
    // 키를 사용하여 특정 데이터를 꺼내기
    System.out.println(map.get("hong"));
    
    
  }

}




















