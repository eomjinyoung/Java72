package step01;

import java.util.Date;

public class Car {
  String  model;
  int     cc;
  Date    outDate;
  
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
