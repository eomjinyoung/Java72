package net.bitacademy.java72.server;

import java.io.PrintStream;
import java.util.Scanner;

public class BoardSkel extends Thread {
  @Override
  public void run() {
    try {
      in = new Scanner(socket.getInputStream());
      out = new PrintStream(socket.getOutputStream());
      
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
      
    } catch (Exception e) {
      e.printStackTrace();
      
    } finally {
      in.close();
      out.close();
      try {socket.close();} catch (Exception e) {}
    }
  }

}
