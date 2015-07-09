package net.bitacademy.java72.step07.v06;

import java.util.Map;
import java.util.Scanner;

import net.bitacademy.java72.step07.v04.Command;

//@Command("stress")
public class Stress implements Command {

  @Override
  public void execute(Map<String, Object> paramMap) {
    Scanner scanner = 
        (Scanner)paramMap.get("inputScanner");
    System.out.println("안녕!");
    String response = null;
    
    do {
      System.out.print("^^> ");
      response = scanner.nextLine();
      if (response.contains("안녕")) {
        System.out.println("정말 반가워~");
      } else if (response.contains("나이")) {
        System.out.println("그런건 묻는 게 아니야!");
      } else if (response.contains("사랑")) {
        System.out.println("아~ 이놈의 인기는..-.-");
      } else if (response.contains("quit")) {
        System.out.println("다음에 또 봐!");
      } else {
        System.out.println("아는 얘기 좀 해봐. 모르겠어!");
      }
    } while (!response.equals("quit"));
  }

}







