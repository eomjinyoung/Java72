package net.bitacademy.java72.step07.v01.ex;

public class KimbapFactory {
  KimbapFactory() {}
  
  public Kimbap makeSimple() {
    Kimbap kb = new Kimbap();
    Danmugi a = new Danmugi();
    a.물짜낸다();
    Dalgal b = new Dalgal();
    b.후라이해라();
    Woowang c = new Woowang();
    c.살짝익힌다();
    Rice f = new Rice();
    f.익혀라();
        
    kb.a = a;
    kb.c = c;
    kb.b = b;
    kb.f = f;
    
    return kb;
  }
}
