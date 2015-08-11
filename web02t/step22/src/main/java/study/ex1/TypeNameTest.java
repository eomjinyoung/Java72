package study.ex1;

public class TypeNameTest {

  public static void main(String[] args) {
    Class clazz = String.class;
    System.out.println(clazz.getName());
    System.out.println(clazz.getSimpleName());
    System.out.println(clazz.getCanonicalName());
    System.out.println(clazz.getTypeName());

  }

}
