package step04;

import java.text.SimpleDateFormat;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.CustomDateEditor;

// 문자열을 특정 타입의 객체로 변환시켜주는 변환기를
// 등록해주는 등록기
public class MyCustomPropertyEditorRegistrar 
  implements PropertyEditorRegistrar {
  
  CustomDateEditor customDateEditor;
  
  public MyCustomPropertyEditorRegistrar() {
    customDateEditor = new CustomDateEditor(
        new SimpleDateFormat("yyyy-MM-dd"),false);
  }
  
  @Override
  public void registerCustomEditors(
      PropertyEditorRegistry registry) {
    registry.registerCustomEditor(
        java.util.Date.class, 
        customDateEditor);
    
  }

}





