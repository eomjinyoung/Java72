package step05.ex4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import step03.Car;

public class Test27 {

  public static void main(String[] args) {
    ApplicationContext iocContainer = 
        new ClassPathXmlApplicationContext(
            "step05/ex4/application-context27.xml");
    
    //System.out.println(iocContainer.getBean("c1"));
    System.out.printf("총 빈의 개수 = %d\n",
        iocContainer.getBeanDefinitionCount());
    
    String[] beanNames = 
        iocContainer.getBeanDefinitionNames();
    for (String name : beanNames) {
      System.out.println(
          iocContainer.getBean(name).getClass().getName());
    }
  }

}






