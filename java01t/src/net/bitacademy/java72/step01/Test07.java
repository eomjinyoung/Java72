package net.bitacademy.java72.step01;

public class Test07 {

  //클래스가 로딩될 때 실행된다.
  static {
    System.out.println("static...");
  }
  
  //인스턴스 블록 -> 인스턴스를 생성할 때 마다 호출된다.
  {
    System.out.println("{}....1");
  }
  
  public Test07() {
    System.out.println("생성자");
  }
  
  {
    System.out.println("{}....2");
  }  
  
  static interface Hi {
    void hello();
  }
  
  public static void main(String[] args) {
    System.out.println("main() 시작");
    Test07 p;
    System.out.println("p 이후...");
    
    p = new Test07();
    
    System.out.println("인스턴스 생성 후...");
    
    
    Hi obj = new Hi () {
      String name;
      {
        name = "홍길동2";
      }
      public void hello() {
        System.out.println(name + "님 안녕하세요!");
      }
    };
    
    obj.hello();
    
    
  }
  
  {
    System.out.println("{}....3");
  }

}










