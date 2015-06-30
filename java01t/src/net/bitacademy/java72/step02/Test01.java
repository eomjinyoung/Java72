package net.bitacademy.java72.step02;

/*
 * Object.toString(): 클래스명@정수식별자(해시코드)
 * 해시코드 - 인스턴스를 식별하는 값. 인스턴스의 디지털 지문.
 * 
 */
public class Test01 {

  static class MyObject {
    String name;
    int age;
    
    // 오버라이딩: 수퍼 클래스의 메서드를 서브 클래스의 용도에 맞게 재정의하는 것.
    @Override
    public String toString() {
      return "MyObject [name=" + name + ", age=" + age + "]";
    }
    
  }
  
  public static void main(String[] args) {
    MyObject obj1 = new MyObject();
    obj1.name = "홍길동";
    obj1.age = 30;
    
    MyObject obj2 = new MyObject();
    obj2.name = "임꺽정";
    obj2.age = 40;
    
    System.out.println(obj1);
    System.out.println(obj2.toString());
    System.out.printf("%x\n", obj1.hashCode());
    System.out.printf("%x\n", obj2.hashCode());
  }

}











