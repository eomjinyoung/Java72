package net.bitacademy.java72.server;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class BoardSkel extends Thread {
  Socket socket;
  
  public BoardSkel(Socket socket) {
    this.socket = socket;
  }
  @Override
  public void run() {
    Scanner in = null;
    PrintStream out = null;
    try {
      in = new Scanner(socket.getInputStream());
      out = new PrintStream(socket.getOutputStream());
      
      String command = null;
      try {
        command = in.nextLine();
        out.println("엄진영==>" + command);
        out.println();
      } catch (Exception e) {}
      
    } catch (Exception e) {
      e.printStackTrace();
      
    } finally {
      in.close();
      out.close();
      try {socket.close();} catch (Exception e) {}
    }
  }

}
