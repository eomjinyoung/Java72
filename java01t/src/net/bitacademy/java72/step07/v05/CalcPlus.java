package net.bitacademy.java72.step07.v05;

import java.util.Map;
import java.util.Scanner;

import net.bitacademy.java72.step07.v04.Command;

public class CalcPlus implements Command {

  @Override
  public void execute(Map<String, Object> paramMap) {
    Scanner scanner = 
        (Scanner)paramMap.get("inputScanner");
    System.out.print("a 값? ");
    int a = Integer.parseInt(scanner.nextLine());
    
    System.out.print("b 값? ");
    int b = Integer.parseInt(scanner.nextLine());
    
    System.out.printf("%d + %d = %d\n",
        a, b, (a + b));
    
  }
  

}







