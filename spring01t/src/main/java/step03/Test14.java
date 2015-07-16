package step03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test14 {

  public static void main(String[] args) {
    ApplicationContext iocContainer = 
        new ClassPathXmlApplicationContext(
            "step03/application-context14.xml");
    
    System.out.println(iocContainer.getBean("c1"));
    System.out.println(iocContainer.getBean("c2"));
  }

}






