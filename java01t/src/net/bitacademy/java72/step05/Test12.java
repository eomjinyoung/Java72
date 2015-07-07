package net.bitacademy.java72.step05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/* PreparedStatement를 이용하여 DBMS에 데이터 입력하기 
 */
public class Test12 {

  public static void main(String[] args) throws Exception {
    Connection con = null;
    PreparedStatement stmt = null;
    
    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/java72db",
          "java72", 
          "java72");
      
      // 미리 SQL문을 준비한다.
      // 데이터가 들어갈 자리에 물음표(?)를 놓는다. <== in-parameter
      // 문자열이든 숫자든 그냥 물음표로 표시한다.
      stmt = con.prepareStatement(
          "INSERT INTO board10(title,content,pwd,cre_dt)"
          + " values(?,?,?,now())");
      
      // SQL문에 들어갈 값을 설정한다.
      // 파라미터 인덱스는 1부터 시작한다.
      stmt.setString(1, "제목이다.");
      stmt.setString(2, "내용이다.");
      stmt.setString(3, "1111");
      
      // SQL문을 실행할 때는 그냥 executeUpdate()를 호출한다.
      int count = stmt.executeUpdate();
      
      System.out.printf("입력 완료!: %d\n", count);
      
    } catch (SQLException e) {
      e.printStackTrace();

    } finally {
      try {stmt.close();} catch (Exception e) {}
      try {con.close();} catch (Exception e) {}
    }
  }

}
















