package net.bitacademy.java72.client;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class BoardClient {
  String  host;
  int     port;
  
  public BoardClient(String host, int port) {
    this.host = host;
    this.port = port;
  }
  
  public void service() {
    Scanner in = null;
    PrintStream out = null;
    Scanner prompt = null;
    Socket socket = null;
    
    try {
      // 서버에 연결한다.
      socket = new Socket(host, port);
      
      // 입출력 도구를 준비한다.
      in = new Scanner(
          socket.getInputStream());
      out = new PrintStream(
          socket.getOutputStream());
      
      // 사용자 입력을 받을 도구 준비
      prompt = new Scanner(System.in);
      
      String command = null;
      String response = null;
      do {
        //1. 사용자로부터 명령어를 입력 받는다.
        System.out.print("명령> ");
        command = prompt.nextLine();
        
        //2. 서버에 명령어를 보낸다.
        out.println(command);
        
        //3. 서버로부터 응답을 읽는다.
        while (!(response = in.nextLine()).equals("")) {
          System.out.println(response);
        }
      } while (!command.equals("quit"));
      
    } catch (Exception e) {
      e.printStackTrace();
      
    } finally {
      in.close();
      out.close();
      try {prompt.close();} catch (Exception e) {}
      try {socket.close();} catch (Exception e) {}
    }
  }
  
  public static void main(String[] args) {
    if (args.length < 2) {
      System.out.println(
          "서버 주소와 포트 번호를 지정하세요!");
      return;
    }
    BoardClient client = new BoardClient(
        args[0], Integer.parseInt(args[1]));
    client.service();
  }
}






