package net.bitacademy.java72.step07.v04;

import java.util.Map;

public class Quit implements Command {

  @Override
  public void execute(Map<String, Object> paramMap) {
    System.out.println("안녕히 가세요!");
    
  }

}
