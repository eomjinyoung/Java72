package net.bitacademy.java72.step08.ex1;

public class Thread1 extends Thread {
  MyObject obj;
  
  public Thread1(MyObject obj) {
    this.obj = obj;
  }
  
  @Override
  public void run() {
    for (int i = 0; i < 100; i++) {
      obj.setValue(i);
    }
    
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {}
    
    System.out.println("Thread1:" + obj.getValue());
  }
}




