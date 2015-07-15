package step01;

import java.sql.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {

  public static void main(String[] args) {
    // 스프링 사용 전
    Car c = new Car();
    c.setModel("티코");
    c.setCc(900);
    c.setOutDate(Date.valueOf("2015-07-15"));
    
    System.out.println(c);
    
    // 스프링 사용 후
    ApplicationContext iocContainer = 
        //new FileSystemXmlApplicationContext(
        //    "c:\bit\workspace\spring01\src\step01\application-context01.xml");
        new ClassPathXmlApplicationContext(
            "step01/application-context01.xml");
    Car c1 = (Car)iocContainer.getBean("c1");
  }

}






