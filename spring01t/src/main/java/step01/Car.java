package step01;

import java.util.Date;

public class Car {
  String  model;
  int     cc;
  Date    outDate;
  
  public Car() {
    System.out.println("Car()");
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
    return "Car [model=" + model + ", cc=" + cc + ", outDate=" + outDate + "]";
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
  
  
}
