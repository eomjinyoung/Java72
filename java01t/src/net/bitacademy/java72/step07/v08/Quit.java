package net.bitacademy.java72.step07.v08;

import java.util.Map;

@CommandProcessor("quit")
public class Quit {

  @RequestMapping
  public void quit(Map<String, Object> paramMap) {
    System.out.println("안녕히 가세요!");
    
  }

}
