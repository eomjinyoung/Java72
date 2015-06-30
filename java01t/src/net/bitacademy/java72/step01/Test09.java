package net.bitacademy.java72.step01;

public class Test09 {
  class Member {
    String name; // 인스턴스 변수
    int age; // 인스턴스 변수
    
    // 프로퍼티 = 셋터 메서드 
    // 프로퍼티 명 = 셋터 메서드 - (set 또는 get) + (첫 알파벳을 소문자로) 
    public void setName(String n) { // 프로퍼티명 : name
      name = n;
    }
    
    public String getName() { // 프로퍼티명: name
      return name;
    }
    
    public void setAgeee(int a) { // 프로퍼티명: ageee
      age = a;
    }
    
    public int getAgeOk() { // 프로퍼티명: ageOk
      return age;
    }
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
