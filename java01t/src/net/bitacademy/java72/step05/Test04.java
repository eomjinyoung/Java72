package net.bitacademy.java72.step05;

import java.sql.Connection;
import java.sql.DriverManager;

/* DBMS에 연결하기 
 * - DriverManager를 통해서 DBMS에 연결한다.
 * - 절차
 * 1) DriverManager에게 DBMS 연결을 요청한다.
 * 2) DriverManager는 Driver 구현체에게 실행을 위임한다.
 * 3) Driver 구현체(com.mysql.jdbc.Driver)는 DBMS와 연결한 후 
 *    연결 정보를 관리하는 객체(java.sql.Connection 구현체)를 리턴한다.
 */
public class Test04 {

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
    
    con.close();
  }

}








