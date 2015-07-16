package step05.ex4;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Car {
  String  model;
  int     cc;
  Date    outDate;
  
  @Autowired(required=false) 
  @Qualifier("e2") 
  Engine  engine;
  
  
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
  
  
  
}
