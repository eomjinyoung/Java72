package net.bitacademy.java72.step03.ex;

import java.lang.reflect.Method;
import java.util.HashMap;

import net.bitacademy.java72.step03.Member;

public class Quiz02 {

  public static void main(String[] args) throws Exception {
    // 1. Class 도구를 이용하여 Member 인스턴스를 만들어라.
    //Class 도구를 얻자
    Class c = Class.forName("net.bitacademy.java72.step03.Member");
    //Member 인스턴스틑 만들자.
    Member m = (Member)c.newInstance();
    
    
    // 2. Class 도구를 이용하여 Member 클래스로부터 셋터 메서드만 추출하여
    //    맵 객체에 저장하라. 저장할 때 키 값은 메서드 이름을 사용하라.
    HashMap<String,Method> methodMap = new HashMap<String,Method>();
    //멤버클래스의 모든 메서드목록을 가져와요 
    Method[] methodlist = c.getMethods();
    //반복문을 하면서 set을 찾아보자
    for (Method method : methodlist) {
    //메서드 이름을 알아내자->메서드 이름이 set으로 시작하는지 검사하기 
      if (method.getName().startsWith("set")) {
    //메서드 이름으로 맵에 저장합니다.
        methodMap.put(method.getName(), method);
      }
    }
    
    for (Method method : methodMap.values()) {
      System.out.println(method.getName());
    }
    
    // 3. 맵 개체에서 메서드를 하나씩 꺼내서 값을 할당하라.
    //
    String name = "윤봉길";
    String email = "yoon@test.com";
    String id = "yoon";
    String password = "1111";
    //setName으로 저장된 메소드를 꺼내온다.
    Method method = methodMap.get("setName");
    //메소드를 호출한다.
    method.invoke(m, name);
    
  //setName으로 저장된 메소드를 꺼내온다.
    method = methodMap.get("setEmail");
    //메소드를 호출한다.
    method.invoke(m, email);
    
  //setName으로 저장된 메소드를 꺼내온다.
    method = methodMap.get("setId");
    //메소드를 호출한다.
    method.invoke(m, id);
    
  //setName으로 저장된 메소드를 꺼내온다.
    method = methodMap.get("setPassword");
    //메소드를 호출한다.
    method.invoke(m, password);
    
    
    // 4. Member 객체를 출력하라!
    System.out.println(m);
    

  }

}







