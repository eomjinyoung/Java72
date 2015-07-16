package step05.ex1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import step03.Car;

public class Test21 {

  public static void main(String[] args) {
    ApplicationContext iocContainer = 
        new ClassPathXmlApplicationContext(
            "step05/ex1/application-context21.xml");
    
    System.out.println(iocContainer.getBean("c1"));
    
  }

}






