package net.bitacademy.java72;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentSelector {

  public static void main(String[] args) throws Exception {
    String[] students = new String[]{
        /*"진혜란", "강슬기", "최승인", "주형진"*/
        
        "김홍규", "김다혜", "강슬기","김형진", "박재광","김다솔", 
        "배재준", "김경직", "변재민","정채훈", "김슬기","방재경"
        
        /*
        "이재훈","송문혁","최종혁","최승인","박재광","김슬기",
        "김웅찬","김지수","김경직","한영주","김홍규","김형진",
        */
        
/*        "변재민", "김다혜", "강슬기", "주형진",
        "이규호", "송한나", 
        "김다솔", "배재준", 
        "한영주", "진혜란", "이승호", "방재경",
 */       
        /*"변재민", "김다혜", "이재훈", "김홍규", "강슬기", "주형진",
        "정채훈", "송문혁", "김형진", "이규호", "송한나", "김웅찬",
        "김경직", "김다솔", "배재준", "김지수", "최종혁",
        "한영주", "진혜란", "최승인", "이승호", "방재경",
        "박재광", "김슬기"*/
    };
    
    ArrayList<String> list = new ArrayList<String>();
    for (String s : students) {
      list.add(s);
    }
    
    int no = 0;
    Scanner scan = new Scanner(System.in);
    String s = null;
    while (list.size() > 0) {
      no = (int)(Math.random() * list.size());
      System.out.println(list.remove(no));
      s = scan.nextLine();
    }
    
    /*int no = -1;
    for (int i = 0; i < 10; i++) {
      System.out.print(".");
      no = (int)(Math.random() * 24);
      Thread.sleep(500);
    }
    Thread.sleep(2000);
    System.out.println(students[no]);*/
  }

}







