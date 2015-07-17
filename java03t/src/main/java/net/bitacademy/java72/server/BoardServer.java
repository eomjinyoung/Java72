package net.bitacademy.java72.server;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class BoardServer {
  int port;
  
  public BoardServer(int port) {
    this.port = port;
  }
  
  public void service() {
    ServerSocket serverSocket = null;
    
    
    try {
      // 1. 클라이언트의 연결을 기다린다.
      serverSocket = new ServerSocket(port, 3);
      System.out.println("서버 실행 중...");
      
      while (true) {
        // 2. 클라이언트의 연결 요청을 승인한다.
        // => 승인되면, 클라이언트와 통신할 도구를 리턴한다.
        socket = serverSocket.accept();
        System.out.println("클라이언트가 연결되었음.");
        
        
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










