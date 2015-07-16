package step03;

import org.springframework.beans.factory.FactoryBean;

public class CarFactoryBean implements FactoryBean<Car> {
  String type;
  
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Override
  public Car getObject() throws Exception {
    if (type.equals("승용차")) {
      Sedan car = new Sedan();
      car.setCapacity(5);
      car.setModel("에쿠스");
      car.setCc(3500);
      return car;
    } else {
      Truck car = new Truck();
      car.setWeight(10000);
      car.setModel("타이탄");
      return car;
    }
  }

  @Override
  public Class<?> getObjectType() {
    return Car.class;
  }

  @Override
  public boolean isSingleton() {
    return true;
  }

}







