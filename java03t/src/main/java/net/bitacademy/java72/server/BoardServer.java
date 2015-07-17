package net.bitacademy.java72.server;

import java.net.ServerSocket;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BoardServer {
  ApplicationContext appContext;
  int port;
  
  public BoardServer(int port) {
    this.port = port;
    appContext = new ClassPathXmlApplicationContext(
        "net/bitacademy/java72/application-context.xml");
  }
  
  public void service() {
    ServerSocket serverSocket = null;
    
    try {
      serverSocket = new ServerSocket(port, 3);
      System.out.println("서버 실행 중...");
      
      while (true) {
        new BoardSkel( 
              serverSocket.accept(),
              appContext).start();
      }
    } catch (Exception e) {
      
    } finally {
      
      try {serverSocket.close();} catch (Exception e) {}
    }
  }
  
  public static void main(String[] args) {
    if (args.length < 1) {
      System.out.println("포트 번호를 지정하세요!");
      return;
    }
    
    BoardServer server = new BoardServer(
        Integer.parseInt(args[0]));
    server.service();
    
  }
}










