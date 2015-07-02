package net.bitacademy.java72.step04;

import java.util.Date;

public class Test03 {
  static class MyThread extends Thread {
    public MyThread(String name) {
      super(name); // 수퍼 클래스 생성자 호출
    }
    
    @Override
    public void run() {
      for (int l = 0; l < 10000; l++) {
        double d1 = 3.141592;
        double d2 = 234.2345;
        double d3 = d1 / Math.random();
        new Date();
        d1 = Math.random();
        d3 = d1 * d2;
        d1 = Math.random();
        System.out.printf("%s: %d\n", this.getName(), l);      
      }
    }
  }
  
  public static void main(String[] args) {
    new MyThread("t1").start();
    new MyThread("t2").start();    
    for (int l = 0; l < 10000; l++) {
      double d1 = 3.141592;
      double d2 = 234.2345;
      double d3 = d1 / Math.random();
      new Date();
      d1 = Math.random();
      d3 = d1 * d2;
      d1 = Math.random();
      System.out.printf("%s: %d\n", "main", l);      
    }
  }
}








