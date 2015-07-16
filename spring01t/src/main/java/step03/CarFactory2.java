package step03;

public class CarFactory2 {
  public Car makeSedan() {
    Sedan car = new Sedan();
    car.setCapacity(5);
    car.setModel("에쿠스");
    car.setCc(3500);
    return car;
  }
  public Car makeTruck() {
    Truck car = new Truck();
    car.setWeight(10000);
    car.setModel("타이탄");
    return car;
  }
}








