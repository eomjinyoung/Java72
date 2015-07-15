package step01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test04 {

  public static void main(String[] args) {
    ApplicationContext iocContainer = 
        new ClassPathXmlApplicationContext(
            "step01/application-context04.xml");
    
    Car c1 = (Car)iocContainer.getBean("step01.Car");
    Car c2 = (Car)iocContainer.getBean("step01.Car#0");
    System.out.println(c1);
    if (c1 == c2) System.out.println("c1 == c2");
    
    Car c3 = (Car)iocContainer.getBean("step01.Car#1");
    Car c4 = (Car)iocContainer.getBean("step01.Car#2");
    if (c1 == c3) System.out.println("c1 == c3");
    if (c3 == c4) System.out.println("c3 == c4");
    if (c1 == c4) System.out.println("c1 == c4");
    
  }

}






