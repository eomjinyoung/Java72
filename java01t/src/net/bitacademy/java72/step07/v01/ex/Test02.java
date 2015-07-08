package net.bitacademy.java72.step07.v01.ex;

public class Test02 {

  public static void main(String[] args) {
    KimbapFactory factory = 
        new KimbapFactoryBuilder().build("여기설계도가있는 경로를 알려줄께");
    Kimbap kb = factory.makeSimple();
    
    

  }

}
