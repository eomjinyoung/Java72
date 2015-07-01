package net.bitacademy.java72;

public class StudentSelector {

  public static void main(String[] args) throws Exception {
    String[] students = new String[]{
        "변재민", "김다혜", "이재훈", "김홍규", "강슬기", "주형진",
        "정채훈", "송문혁", "김형진", "이규호", "송한나", "김웅찬",
        "김경직", "김다솔", "배재준", "김지수", "최종혁",
        "한영주", "진혜란", "최승인", "이승호", "방재경",
        "박재광", "김슬기"
    };
    
    int no = 0;
    
    for (int i = 0; i < 10; i++) {
      System.out.print(".");
      no = (int)(Math.random() * 24);
      Thread.sleep(500);
    }
    Thread.sleep(2000);
    System.out.println(students[no]);
    
  }

}







