package net.bitacademy.java72.step04;

public class Test01 {

  public static void main(String[] args) {
    Thread main = Thread.currentThread();
    System.out.println(main.getName());
    
    //main 스레드가 소속된 스레드 그룹 알아내기
    ThreadGroup group = main.getThreadGroup();
    //스레드 그룹의 이름 출력하기
    System.out.println(group.getName());
    
    ThreadGroup systemTG = group.getParent();
    System.out.println(systemTG.getName());
    
    System.out.println("-----------------------------------");
    
    ThreadGroup[] tgList = new ThreadGroup[10];
    int length = systemTG.enumerate(tgList);
    
    for (int i = 0; i < length; i++) {
      System.out.println(tgList[i].getName());
    }
    
    System.out.println("----------------------------");
    
    Thread[] threadList = new Thread[10];
    length = systemTG.enumerate(threadList, false);
    
    for (int i = 0; i < length; i++) {
      System.out.println(threadList[i].getName());
    }
  }

}










