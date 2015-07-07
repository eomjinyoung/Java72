package net.bitacademy.java72.step06.v08;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

public class DBConnectionPool {
  String url;
  String id;
  String password;
  ArrayList<Connection> list = new ArrayList<Connection>();
  
  public DBConnectionPool(String driverClass, String url, 
      String id, String password) {
    try {
      Class.forName(driverClass);
    } catch (Exception e) {
      e.printStackTrace();
    }
    this.url = url;
    this.id = id;
    this.password = password;
  }
  
  public Connection getConnection() throws Exception {
    Connection con = null;
    
    if (list.size() == 0) { // 없으면 새로 만들고,
      con = DriverManager.getConnection(url, id, password);
      
    } else { // 있으면, 맨 앞에 있는 커넥션 객체를 꺼낸다.
      con = list.remove(0);
    }
    
    return con;
  }
  
  public void returnConnection(Connection con) {
    try {
      if (!con.isClosed() && con.isValid(2000)) {
        list.add(con);
      }
    } catch (Exception e) {
      // 리턴한 커넥션 객체에 문제가 있더라도 무시한다.
      // 반납한 쪽에 보고해봐야 의미없다.
    }
  }
  
  public void closeAll() {
    for (Connection con : list) {
      try {con.close();} catch (Exception e) {}
    }
  }
}






















