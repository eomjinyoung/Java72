package net.bitacademy.java72.step05;

/* java.sql.Driver 구현체 로딩 
 * - java.sql.Connection 객체를 얻기 위함.
 */
public class Test01 {

  public static void main(String[] args) throws Exception {
    // 방법1. Class.forName("구현체이름")
    // - 각 JDBC 드라이버의 문서를 참조하여 java.sql.Driver 인터페이스를 구현한
    //   클래스의 이름이 무엇인지 알아낸다.
    Class.forName("com.mysql.jdbc.Driver");
    
    // 방법2. DriverManager.registerDriver(구현체의 인스턴스)

  }

}








