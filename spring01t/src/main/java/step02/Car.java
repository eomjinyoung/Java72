package step02;

import java.util.Date;

public class Car {
  String  model;
  int     cc;
  Date    outDate;
  Engine  engine;
  
  public Car() {
    System.out.println("Car()");
  }
  public Car(int cc) {
    System.out.println("Car(int)");
    this.cc = cc;
  }
  public Car(String model) {
    System.out.println("Car(String)");
    this.model = model;
  }
  public Car(String model, int cc) {
    System.out.println("Car(String,int)");
    this.model = model;
    this.cc = cc;
  }
  public Car(int cc, String model) {
    System.out.println("Car(int,String)");
    this.model = model;
    this.cc = cc;
  }
  
  @Override
  public String toString() {
    return "Car [model=" + model + ", cc=" + cc + ", outDate=" + outDate + ", engine=" + engine + "]";
  }
  
  public String getModel() {
    return model;
  }
  public void setModel(String model) {
    this.model = model;
  }
  public int getCc() {
    return cc;
  }
  public void setCc(int cc) {
    this.cc = cc;
  }
  public Date getOutDate() {
    return outDate;
  }
  public void setOutDate(Date outDate) {
    this.outDate = outDate;
  }
  public Engine getEngine() {
    return engine;
  }
  public void setEngine(Engine engine) {
    this.engine = engine;
  }
  
  
}
