package net.bitacademy.java72.step05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/* PreparedStatement를 사용하여 DBMS에 데이터 변경하기 
 */
public class Test13 {

  public static void main(String[] args) throws Exception {
    Connection con = null;
    PreparedStatement stmt = null;
    
    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/java72db",
          "java72", 
          "java72");

      stmt = con.prepareStatement(
              "UPDATE board10 SET title=? WHERE bno=?");
      
      stmt.setString(1, "하하하하");
      stmt.setInt(2, 13);
      
      int count = stmt.executeUpdate();
      
      System.out.printf("변경 완료!: %d\n", count);
      
    } catch (SQLException e) {
      e.printStackTrace();

    } finally {
      // 자원 해제 
      try {stmt.close();} catch (Exception e) {}
      try {con.close();} catch (Exception e) {}
    }
  }

}

/* Statement vs PreparedStatement
항목               Statement                 PreparedStatement
----------------------------------------------------------------------
[소스코드 가독성]     + 연산자를 사용하여           in-parameter로 처리하기 때문에
                  SQL문을 연결해서 만든다.       소스 코드가 간결하다.
                  코드가 복잡하다.          
----------------------------------------------------------------------                  
[바이너리 데이터      SQL문과 데이터를             in-parameter로 처리하기 때문에   
 입력]             문자열로 표현하기 때문에        바이너리 데이터의 입력이 가능하다.
                  파일과 같은 이진 데이터를
                  저장할 수 없다.
----------------------------------------------------------------------
[실행 속도]         executeXXX()를 호출할 때마다  executeXXX()를 호출하기 전에  
                  SQL문을 DBMS가 이해하는       SQL문을 미리 준비한다.
                  형식으로 변환한 후 서버에 보낸다. 미리 DBMS에 전달하기 좋게 
                  따라서 같은 SQL문을           변환한다. 그런 후 데이터를 첨부하여
                  반복문을 사용하여 반복할 때는    보낸다.
                  실행 속도가 느리다.            반복문과 같이 연속해서 동일한 
                                            SQL문을 실행할 때는 변환 작업이 
                                            없기 때문에 속도가 빠르다.
 */














