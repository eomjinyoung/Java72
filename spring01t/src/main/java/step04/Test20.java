package step04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import step03.Car;

public class Test20 {

  public static void main(String[] args) {
    ApplicationContext iocContainer = 
        new ClassPathXmlApplicationContext(
            "step04/application-context20.xml");
    
    System.out.println(iocContainer.getBean("c1"));
    
  }

}






