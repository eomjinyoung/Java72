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
    Socket socket = null;
    Scanner in = null;
    PrintStream out = null;
    
    try {
      // 1. 클라이언트의 연결을 기다린다.
      serverSocket = new ServerSocket(port, 3);
      System.out.println("서버 실행 중...");
      
      while (true) {
        // 2. 클라이언트의 연결 요청을 승인한다.
        // => 승인되면, 클라이언트와 통신할 도구를 리턴한다.
        socket = serverSocket.accept();
        System.out.println("클라이언트가 연결되었음.");
        
        // 3. 클라이언트와 입출력을 수행할 도구를 준비한다.
        in = new Scanner(socket.getInputStream());
        out = new PrintStream(socket.getOutputStream());
        
        // 4. 클라이언트가 보낸 명령을 받아서 
        //    처리한 후 응답 결과를 보낸다.
        String command = null;
        do {
          try {
            command = in.nextLine();
            out.println("엄진영==>" + command);
            out.println();
          } catch (Exception e) {
            break;
          }
        } while (!command.equals("quit"));
      }
    } catch (Exception e) {
      
    } finally {
      in.close();
      out.close();
      try {socket.close();} catch (Exception e) {}
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










