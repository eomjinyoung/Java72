package study.ex1;

public class BitOpTest {

  public static void main(String[] args) {
    /* 목표: 권한 정보를 하나의 값으로 표현하기
     * List, View, Create, Update, Delete
     */
    
    //1. 각각의 권한 정보를 하나의 비트로 표현한다.
    final int LIST = 0x01;
    final int VIEW = 0x02;
    final int CREATE = 0x04;
    final int UPDATE = 0x08;
    final int DELETE = 0x10;
    
    int value = LIST | CREATE | DELETE;
    System.out.printf("0x%x\n", value);
    
    if ((value & LIST) == LIST) {
      System.out.println("LIST");
    }
    
    if ((value & CREATE) == CREATE) {
      System.out.println("CREATE");
    }
    
    if ((value & DELETE) == DELETE) {
      System.out.println("DELETE");
    }

  }

}







