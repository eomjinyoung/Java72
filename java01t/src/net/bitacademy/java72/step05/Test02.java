package net.bitacademy.java72.step05;

import java.sql.DriverManager;

/* java.sql.Driver 구현체 로딩 
 * - java.sql.Connection 객체를 얻기 위함.
 */
public class Test02 {

  public static void main(String[] args) throws Exception {
    // 방법1. Class.forName("구현체이름")
    // - 각 JDBC 드라이버의 문서를 참조하여 java.sql.Driver 인터페이스를 구현한
    //   클래스의 이름이 무엇인지 알아낸다.
    //Class.forName("com.mysql.jdbc.Driver");
    
    // 방법2. DriverManager.registerDriver(구현체의 인스턴스)
    // - 단점: 특정 JDBC Driver에 종속된다.
    //        클래스 이름을 바꾸면, 소스 코드를 변경해야 한다.
    DriverManager.registerDriver(new com.mysql.jdbc.Driver());
  }

}








