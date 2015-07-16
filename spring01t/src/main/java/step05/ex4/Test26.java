package step05.ex4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import step03.Car;

public class Test26 {

  public static void main(String[] args) {
    ApplicationContext iocContainer = 
        new ClassPathXmlApplicationContext(
            "step05/ex4/application-context26.xml");
    
    System.out.println(iocContainer.getBean("c1"));
    
  }

}






