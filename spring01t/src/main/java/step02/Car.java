package step02;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Car {
  String  model;
  int     cc;
  Date    outDate;
  Engine  engine;
  Tire[]  tires;
  List<String>  cds;
  Set<String> cds2;
  Map<String,String> optionMap;
  
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
    return "Car [model=" + model + ", cc=" + cc + ", outDate=" + outDate + ", engine=" + engine + ", tires="
        + Arrays.toString(tires) + ", cds=" + cds + ", cds2=" + cds2 + ", optionMap=" + optionMap + "]";
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
  public Tire[] getTires() {
    return tires;
  }
  public void setTires(Tire[] tires) {
    this.tires = tires;
  }
  public List<String> getCds() {
    return cds;
  }
  public void setCds(List<String> cds) {
    this.cds = cds;
  }
  public Set<String> getCds2() {
    return cds2;
  }
  public void setCds2(Set<String> cds2) {
    this.cds2 = cds2;
  }
  public Map<String, String> getOptionMap() {
    return optionMap;
  }
  public void setOptionMap(Map<String, String> optionMap) {
    this.optionMap = optionMap;
  }
  
  
}
