package net.bitacademy.java72.step05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/* JDBC 오류가 발생하더라도 자원을 제대로 해제하기
 */
public class Test06 {

  public static void main(String[] args) throws Exception {
    Connection con = null;
    Statement stmt = null;
    
    try {
      // java.sql.Driver 구현체를 로딩한다.
      Class.forName("com.mysql.jdbc.Driver");

      // 드라이버 관리자에게 DBMS의 연결을 요청한다.
      con = DriverManager.getConnection(
          /* JDBC URL: DBMS 연결 정보. JDBC 드라이버마다 약간 씩 다르다. */
          "jdbc:mysql://localhost:3306/java72db",    
          "java72", /* 접속할 때 사용자 ID */
          "java72"); /* 사용자 암호 */

      System.out.println("연결 성공입니다.");

      // DBMS에 질의하는 것을 도와줄 객체를 얻는다.
      stmt = con.createStatement();

      System.out.println("질의를 도와줄 객체 얻기 성공!");

    } catch (SQLException e) {
      e.printStackTrace();

    } finally {
      // 자원 해제 
      try {stmt.close();} catch (Exception e) {}
      try {con.close();} catch (Exception e) {}
    }
  }

}
















