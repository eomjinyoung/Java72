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
      prompt = new Scanner(System.in);
      
      String command = null;
      String response = null;
      do {
        System.out.print("명령> ");
        command = prompt.nextLine();
        
        socket = new Socket(host, port);
        in = new Scanner(socket.getInputStream());
        out = new PrintStream(socket.getOutputStream());
        
        out.println(command);
        
        while (!(response = in.nextLine()).equals("")) {
          System.out.println(response);
        }
        
        in.close();
        out.close();
        try {socket.close();} catch (Exception e) {}
        
      } while (!command.equals("quit"));
      
    } catch (Exception e) {
      e.printStackTrace();
      
    } finally {
      try {prompt.close();} catch (Exception e) {}
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






