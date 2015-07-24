package net.bitacademy.java72.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApplicationContext {
  ApplicationContext appContext;
  static MyApplicationContext instance;
  
  private MyApplicationContext() {
    appContext = new ClassPathXmlApplicationContext(
        "net/bitacademy/java72/application-context.xml");
  }
  
  public static MyApplicationContext getInstance() {
    if (instance == null) {
      instance = new MyApplicationContext();
    }
    return instance;
  }
  
  public Object getBean(String name) {
    return appContext.getBean(name);
  }
}









