package step05.ex4;

public class Engine {
  String  maker;
  int     hp;
  int     valves;
  
  @Override
  public String toString() {
    return "Engine [maker=" + maker + ", hp=" + hp + ", valves=" + valves + "]";
  }
  
  public String getMaker() {
    return maker;
  }
  public void setMaker(String maker) {
    this.maker = maker;
  }
  public int getHp() {
    return hp;
  }
  public void setHp(int hp) {
    this.hp = hp;
  }
  public int getValves() {
    return valves;
  }
  public void setValves(int valves) {
    this.valves = valves;
  }
  
  
}
