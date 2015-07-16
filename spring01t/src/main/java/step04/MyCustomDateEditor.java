package step04;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class MyCustomDateEditor 
    extends PropertyEditorSupport {
  SimpleDateFormat dateFormat;
  
  public MyCustomDateEditor() {
    dateFormat = new SimpleDateFormat("yyyy-MM-dd");
  }
  
  @Override
  public void setAsText(String text) throws IllegalArgumentException {
    try {
      setValue(dateFormat.parse(text));
    } catch (ParseException e) {
      e.printStackTrace();
    }
  }

}






