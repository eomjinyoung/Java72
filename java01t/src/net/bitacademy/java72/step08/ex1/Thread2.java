package net.bitacademy.java72.step08.ex1;

public class Thread2 extends Thread {
  MyObject obj;
  
  public Thread2(MyObject obj) {
    this.obj = obj;
  }
  
  @Override
  public void run() {
    for (int i = 10000; i < 20000; i++) {
      obj.setValue(i);
    }
    
    System.out.println("Thread2:" + obj.getValue());
  }
}




