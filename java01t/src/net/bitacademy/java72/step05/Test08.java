package net.bitacademy.java72.step05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/* DBMS에서 가져온 결과를 출력하기
 */
public class Test08 {

  public static void main(String[] args) throws Exception {
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    
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
      
      // DBMS에 SQL를 전달하기
      // executeQuery(): SELECT
      // executeUpdate(): INSERT, UPDATE, DELETE, CREATE, DROP, ALTER
      // execute(): 모두
      // 
      // executeQuery()의 리턴 값 => ResultSet
      // ResultSet : 서버에서 레코드를 가져오는 도구
      //             주의! 서버에서 결과를 모두 가져온 것이 아님.
      //             next()를 호출해야만 가져온다.
      rs = stmt.executeQuery(
          "SELECT bno,title,cre_dt,views"
          + " FROM board10"
          + " ORDER BY bno desc");
      System.out.println("결과를 가져올 도구 준비 완료!");
      
      // DBMS 서버에서 한 개의 레코드를 가져오기
      while (rs.next()) {
        // 레코드에서 컬럼 값을 꺼내 출력하기 
        System.out.printf("%d, %s, %s, %d\n",
            rs.getInt("bno"), rs.getString("title"),
            rs.getDate("cre_dt"), rs.getInt("views"));
      }

    } catch (SQLException e) {
      e.printStackTrace();

    } finally {
      // 자원 해제 
      try {rs.close();} catch (Exception e) {}
      try {stmt.close();} catch (Exception e) {}
      try {con.close();} catch (Exception e) {}
    }
  }

}
















