package step03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test16 {

  public static void main(String[] args) {
    ApplicationContext iocContainer = 
        new ClassPathXmlApplicationContext(
            "step03/application-context16.xml");
    // 기본이 singleton이다.
    // 객체를 오직 한 개만 생성하여 리턴한다.
    Car r1 = (Car)iocContainer.getBean("c1");
    Car r2 = (Car)iocContainer.getBean("c1");
    Car r3 = (Car)iocContainer.getBean("c1");
    System.out.printf("%b,%b,%b\n", 
        r1 == r2, r1 == r3, r2 == r3);
    
    Car ra1 = (Car)iocContainer.getBean("c2");
    Car ra2 = (Car)iocContainer.getBean("c2");
    Car ra3 = (Car)iocContainer.getBean("c2");
    System.out.printf("%b,%b,%b\n", 
        ra1 == ra2, ra1 == ra3, ra2 == ra3);
   
    // prototype은 getBean()을 호출할 때 마다 
    // 객체를 생성하여 리턴한다.
    // => 메모리 낭비가 심하다. 
    Car rb1 = (Car)iocContainer.getBean("c3");
    Car rb2 = (Car)iocContainer.getBean("c3");
    Car rb3 = (Car)iocContainer.getBean("c3");
    System.out.printf("%b,%b,%b\n", 
        rb1 == rb2, rb1 == rb3, rb2 == rb3);
  }

}






