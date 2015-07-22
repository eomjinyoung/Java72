package util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class MyWebBrowser {

  public static void main(String[] args) throws Exception {
    String host = "www.naver.com";
    
    Socket socket = new Socket(host, 80);
    PrintStream out = 
        new PrintStream(socket.getOutputStream());
    BufferedReader in = 
        new BufferedReader(
            new InputStreamReader(
                socket.getInputStream()));
    
    out.println("GET / HTTP/1.1");
    out.println("Host: www.naver.com");
    out.println();
    
    String line = null;
    while (!(line = in.readLine()).equals("")) {
      System.out.println(line);
    }
    System.out.println();
    
    char[] buf = new char[1024];
    int len = 0;
    while ((len = in.read(buf)) > 0) {
      System.out.println(String.valueOf(buf, 0, len));
    }
    
    in.close();
    out.close();
    socket.close();
    

  }

}








