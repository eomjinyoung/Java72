package step05.ex6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test29 {

  public static void main(String[] args) {
    ApplicationContext iocContainer = 
        new ClassPathXmlApplicationContext(
            "step05/ex6/application-context29.xml");
    
    String[] names = 
        iocContainer.getBeanDefinitionNames();
    for (String beanName : names) {
      System.out.printf("%s: %s\n",
          beanName,
          iocContainer.getBean(beanName));
    }
    
  }

}






