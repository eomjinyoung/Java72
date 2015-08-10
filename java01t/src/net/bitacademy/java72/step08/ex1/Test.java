package net.bitacademy.java72.step08.ex1;

public class Test {

  public static void main(String[] args) throws Exception {
    MyObject obj = new MyObject();
    Thread1 t1 = new Thread1(obj);
    Thread2 t2 = new Thread2(obj);
    
    t1.start();
    t2.start();

  }

}
