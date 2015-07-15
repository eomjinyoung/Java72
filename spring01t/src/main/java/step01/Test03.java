package step01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test03 {

  public static void main(String[] args) {
    ApplicationContext iocContainer = 
        new ClassPathXmlApplicationContext(
            "step01/application-context03.xml");
    
    Car c1 = (Car)iocContainer.getBean("c1");
    System.out.println(c1);
    
    Car c2 = (Car)iocContainer.getBean("c2");
    Car c3 = (Car)iocContainer.getBean("c3");
    Car c4 = (Car)iocContainer.getBean("c4");
    System.out.println(c2);
    if (c2 == c3) {
      System.out.println("c2 == c3");
    }
    if (c3 == c4) {
      System.out.println("c3 == c4");
    }
    
    Car x = (Car)iocContainer.getBean("okok^^");
    System.out.println(x);
    
    Car x2 = (Car)iocContainer.getBean("nono^^");
    System.out.println(x2);
    
    /*
    Car k1 = (Car)iocContainer.getBean("k1");
    Car k2 = (Car)iocContainer.getBean("k2");
    Car k3 = (Car)iocContainer.getBean("k3");
    */
    
    Car kx = (Car)iocContainer.getBean("k1 k2 k3");
  }

}






