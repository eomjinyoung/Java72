package net.bitacademy.java72.step05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/* DBMS에 질의할 도구 얻기  
 * - Connection 객체를 통해서 DBMS에 SQL문을 전달할 객체를 얻는다.
 */
public class Test05 {

  public static void main(String[] args) throws Exception {
    // java.sql.Driver 구현체를 로딩한다.
    Class.forName("com.mysql.jdbc.Driver");
    
    // 드라이버 관리자에게 DBMS의 연결을 요청한다.
    Connection con = DriverManager.getConnection(
        /* JDBC URL: DBMS 연결 정보. JDBC 드라이버마다 약간 씩 다르다. */
        "jdbc:mysql://localhost:3306/java72db",    
        "java72", /* 접속할 때 사용자 ID */
        "java72"); /* 사용자 암호 */

    System.out.println("연결 성공입니다.");
    
    // DBMS에 질의하는 것을 도와줄 객체를 얻는다.
    Statement stmt = con.createStatement();
    
    System.out.println("질의를 도와줄 객체 얻기 성공!");
    
    // 자원을 해제할 때는 역순으로 수행한다.
    stmt.close();
    con.close();
  }

}








