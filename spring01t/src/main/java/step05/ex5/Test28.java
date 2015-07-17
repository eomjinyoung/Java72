package step05.ex5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test28 {

  public static void main(String[] args) {
    ApplicationContext iocContainer = 
        new ClassPathXmlApplicationContext(
            "step05/ex5/application-context28.xml");
    
    System.out.println(iocContainer.getBean("c1"));
    
  }

}






