package step04;

import java.beans.PropertyEditorSupport;

public class MyCustomEngineEditor
  extends PropertyEditorSupport {
  
  @Override
  public void setAsText(String text) throws IllegalArgumentException {
    String[] values = text.split(",");
    Engine engine = new Engine();
    engine.setMaker(values[0]);
    engine.setHp(Integer.parseInt(values[1]));
    engine.setValves(Integer.parseInt(values[2]));
    
    setValue(engine);
  }

}








