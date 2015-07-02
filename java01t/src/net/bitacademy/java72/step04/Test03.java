package net.bitacademy.java72.step04;

import java.util.Date;

public class Test03 {
  class MyThread extends Thread {
    public MyThread(String name) {
      super(name); // 수퍼 클래스 생성자 호출
    }
    
    @Override
    public void run() {
      double d1 = 3.141592;
      double d2 = 234.2345;
      double d3 = d1 / Math.random();
      
      for (int l = 0; l < 10000; l++) {
        new Date();
        d1 = Math.random();
        d3 = d1 * d2;
        d1 = Math.random();
        print(l, this.getName());
      }
    }
  }
  
  public void print(int l, String name) {
    double d1 = 3.141592;
    double d2 = 234.2345;
    new Date();
   
    double d3 = d1 / Math.random();
    d1 = Math.random();
    new Date();
    d3 = d1 * d2;
    System.out.printf("%s: %d\n", name, l);
    d1 = Math.random();
    d3 = d1 * d2;
    
    new Date();
    d3 = d1 * d2;
    d1 = Math.random();
    d3 = d1 * d2;
  }
  
  public void test() {
    new MyThread("t1").start();
    new MyThread("t2").start();
    
    double d1 = 3.141592;
    double d2 = 234.2345;
    double d3 = d1 / Math.random();

    for (int l = 0; l < 10000; l++) {
      new Date();
      d1 = Math.random();
      d3 = d1 * d2;
      d1 = Math.random();
      print(l, "main");
    }
  }
  
  public static void main(String[] args) {
    Test03 app = new Test03();
    app.test();
    
   
  }
}








