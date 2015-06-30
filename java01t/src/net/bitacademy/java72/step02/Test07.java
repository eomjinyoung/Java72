package net.bitacademy.java72.step02;

public class Test07 {

  public static void main(String[] args) {
    int i = 17;
    Integer obj1 = new Integer(17);

    // auto-boxing
    // - 객체를 원시 타입 값으로 자동으로 변환(unboxing): 객체 -> 원시타입
    // - 원시 타입의 값을 객체로 자동으로 변환(boxing): 원시타입 -> 객체
    int i2 = obj1;    // int i2 = obj1.intValue() <-- unboxing
    Integer obj2 = i; // Integer obj2 = new Integer(i) <-- boxing
    
    System.out.println(i2);
    System.out.println(obj2);
    
    /* wrapper class
     * byte       - Byte
     * short      - Short
     * int        - Integer
     * long       - Long
     * float      - Float
     * double     - Double
     * boolean    - Boolean
     * char       - Character
     */

  }

}
