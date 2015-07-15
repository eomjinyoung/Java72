package net.bitacademy.java72.control;

import java.util.Map;

import net.bitacademy.java72.annotation.Controller;
import net.bitacademy.java72.annotation.RequestMapping;

@Controller("quit")
public class Quit {

  @RequestMapping
  public void quit(Map<String, Object> paramMap) {
    System.out.println("안녕히 가세요!");
    
  }

}
