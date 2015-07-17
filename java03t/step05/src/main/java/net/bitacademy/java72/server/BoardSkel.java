package net.bitacademy.java72.server;

import static org.reflections.ReflectionUtils.getMethods;
import static org.reflections.ReflectionUtils.withAnnotation;

import java.io.PrintStream;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import org.springframework.context.ApplicationContext;

import net.bitacademy.java72.annotation.RequestMapping;

public class BoardSkel extends Thread {
  ApplicationContext appContext;
  Socket socket;
  Scanner in = null;
  PrintStream out = null;
  
  public BoardSkel(Socket socket, 
      ApplicationContext appContext) {
    this.socket = socket;
    this.appContext = appContext;
    System.out.println("클라이언트 접속함.");
  }
  
  @Override
  public void run() {
    try {
      in = new Scanner(socket.getInputStream());
      out = new PrintStream(socket.getOutputStream());
      
      String command = null;
      try {
        command = in.nextLine(); // 예) board/list.do
        process(command);
      } catch (Exception e) {}
      System.out.println("클라이언트 요청처리 완료.");
    } catch (Exception e) {
      e.printStackTrace();
      
    } finally {
      in.close();
      out.close();
      try {socket.close();} catch (Exception e) {}
    }
  }

  private void process(String command) {
    HashMap<String,Object> paramMap = 
        new HashMap<String,Object>();
    paramMap.put("out", out);
    
    // 예)board/insert.do?title=aa&content=aa&password=11
    // items[0] -> board/insert.do
    // items[1] -> title=aa&content=aa&password=11
    String[] items = command.split("\\?");
    if (items.length > 1) { // ? 다음에 값이 있다면!
      String[] entryList = items[1].split("&");
      String[] kv = null;
      
      for (String entry : entryList) {
        kv = entry.split("=");
        paramMap.put(kv[0], kv[1]);
      }
    }
    
    try {
      Object commandWorker = appContext.getBean(items[0]);
      Set<Method> methods = null;
      Method temp = null;
      methods = getMethods(
          commandWorker.getClass(), 
          withAnnotation(RequestMapping.class));
      temp = (Method)methods.toArray()[0];
      temp.invoke(commandWorker, paramMap);
    } catch (Exception e) {  
      out.println("해당 명령을 지원하지 않습니다!");
    } finally {
      out.println(); // 클라이언트에게 응답의 끝을 알린다.
    }
  }

}









