package step03;

public class CarFactory {
  public static Car makeCar(String model) {
    if (model.equals("승용차")) {
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
}








