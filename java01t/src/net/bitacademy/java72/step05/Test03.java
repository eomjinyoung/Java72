package net.bitacademy.java72.step05;

/* java.sql.Driver 구현체 로딩 
 * - java.sql.Connection 객체를 얻기 위함.
 */
public class Test03 {

  public static void main(String[] args) throws Exception {
    // 외부에서 Driver 구현체의 이름을 받기
    Class.forName(args[0]);

  }

}








