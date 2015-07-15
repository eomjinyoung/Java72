package step01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test05 {

  public static void main(String[] args) {
    ApplicationContext iocContainer = 
        new ClassPathXmlApplicationContext(
            "step01/application-context05.xml");
    
    Car c14 = (Car)iocContainer.getBean("c14");
    System.out.println(c14);
    
  }

}






