package net.bitacademy.java72.step07.v04;

import java.util.Map;
import java.util.Scanner;

public class Hello implements Command {

  @Override
  public void execute(Map<String, Object> paramMap) {
    Scanner scanner = 
        (Scanner)paramMap.get("inputScanner");
    System.out.print("이름은? ");
    String name = scanner.nextLine();
    System.out.printf("%s님 환영합니다!\n", name);
  }

}
