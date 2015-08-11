package study.ex1;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

public class MethodAnalizer {

  public static void main(String[] args) throws Exception {
    Class<?> clazz = Class.forName("study.ex1.MyClass");
    //Class<?> clazz2 = MyClass.class;

    Method[] methods = clazz.getMethods();
    
    for (Method m : methods) {
      System.out.println(m.getName());
      analizeParameter(m);
    }
    
    System.out.println("------------------------");
    Field[] fields = clazz.getDeclaredFields();
    int modifiers = 0;
    for (Field f : fields) {
      System.out.printf("%s:%s\n"
          , f.getName()
          , f.getType().getName());
      
      modifiers = f.getModifiers();
      if ((modifiers & Modifier.PUBLIC) == Modifier.PUBLIC) {
        System.out.println("public이다");
      }
      
      if ((modifiers & Modifier.STATIC) == Modifier.STATIC) {
        System.out.println("static이다");
      }
      
      if ((modifiers & Modifier.FINAL) == Modifier.FINAL) {
        System.out.println("final이다");
      }
    }
  }

  private static void analizeParameter(Method m) {
    Parameter[] params = m.getParameters();
    
    for (Parameter p : params) {
      System.out.printf("==>%s:%s\n"
          , p.getName()
          , p.getType().getName());
    }
    
  }

}






