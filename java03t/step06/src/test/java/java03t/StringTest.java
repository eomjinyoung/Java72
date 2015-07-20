package java03t;

public class StringTest {

  public static void main(String[] args) {
    String s = "board/insert.do?title=aa&content=aa&password=11";
    String[] items = s.split("\\?");
    System.out.println(items[0]);
    System.out.println(items[1]);
    System.out.println("------------------");
    
    String[] entryList = items[1].split("&");
    String[] kv = null;
    for (String entry : entryList) {
      kv = entry.split("=");
      System.out.printf("%s:%s\n", kv[0], kv[1]);
      
    }
  }

}
