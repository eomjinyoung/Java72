package step01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test02 {

  public static void main(String[] args) {
    ApplicationContext iocContainer = 
        new ClassPathXmlApplicationContext(
            "step01/application-context02.xml");
    
    Car c1 = (Car)iocContainer.getBean("c1");
    Car c2 = (Car)iocContainer.getBean("c2");
    Car c3 = (Car)iocContainer.getBean("c3");
    
    System.out.println(c1);
    System.out.println(c2);
    System.out.println(c3);
    
    Car c4 = (Car)iocContainer.getBean("c4");
  }

}






