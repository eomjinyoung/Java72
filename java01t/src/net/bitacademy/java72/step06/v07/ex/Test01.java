package net.bitacademy.java72.step06.v07.ex;

import net.bitacademy.java72.step06.v07.BoardDao;

public class Test01 {

  public static void main(String[] args) {
    BoardDao boardDao = new BoardDao(
        "com.mysql.jdbc.Driver",
        "jdbc:mysql://localhost:3306/java72db",    
        "java72", 
        "java72");
    BoardDao boardDao2 = new BoardDao(
        "com.mysql.jdbc.Driver",
        "jdbc:mysql://192.168.1.45:3306/java72db",    
        "java72", 
        "java72");
    
    boardDao.list();
    System.out.println("-------------------------------");
    boardDao2.list();
  }

}
