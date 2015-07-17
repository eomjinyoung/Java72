package step04;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map.Entry;

public class TextEx {
  static interface Converter {
    Object fromStringToObject(String value);
  }
  
  static class MyDateConverter implements Converter {
    SimpleDateFormat format = null;
    public MyDateConverter() {
      format = new SimpleDateFormat("yyyy-MM-dd");
    }
    @Override
    public Object fromStringToObject(String value) {
      try {
        return format.parse(value);
      } catch (Exception e) {
        e.printStackTrace();
        return null;
      }
    }
  }
  
  public static void main(String[] args) throws Exception {
    HashMap<String,Converter> converterMap = 
        new HashMap<String,Converter>();
    converterMap.put("java.util.Date", new MyDateConverter());
    
    
    
    String className = "step04.Car";
    
    Class clazz = Class.forName(className);
    Object obj = clazz.newInstance();
    
    HashMap<String,String> methodMap = 
        new HashMap<String,String>();
    
    String m1Name = "model";
    String m1Value = "티코";
    
    String setter =
        "set"
        + m1Name.substring(0, 1).toUpperCase()
        + m1Name.substring(1);
    methodMap.put(setter, m1Value);
    
    String m2Name = "cc";
    String m2Value = "800";
    setter =
        "set"
        + m2Name.substring(0, 1).toUpperCase()
        + m2Name.substring(1);
    methodMap.put(setter, m2Value);
    
    String m3Name = "outDate";
    String m3Value = "2015-07-15";
    setter =
        "set"
        + m3Name.substring(0, 1).toUpperCase()
        + m3Name.substring(1);
    methodMap.put(setter, m3Value);
    
    System.out.println(obj);
    
    Method[] methodList = clazz.getMethods();
    String methodName = null;
    String methodValue = null;
    Class<?> paramType = null;
    for (Method m : methodList) {
      methodName = m.getName();
      Object realValue = null;
      for (Entry<String,String> entry : methodMap.entrySet()) {
        if (methodName.equals(entry.getKey())) {
          methodValue = entry.getValue();
          //String --> 셋터의 파라미터 타입의 값으로 변환
          paramType = m.getParameterTypes()[0];
          if (paramType.isPrimitive()) {
            if (paramType.getName().equals("int")) {
              realValue = Integer.parseInt(methodValue);
            }
          } else if (paramType.getName().equals("java.lang.String")) {
            realValue = methodValue;
          } else {
            Converter conv = converterMap.get(paramType.getName()); 
            if (conv != null) {
              realValue = conv.fromStringToObject(methodValue);
            } else {
              throw new Exception("java.lang.String을 " +
                paramType.getName() + "으로 변경할 수 없다");
            }
          }
          m.invoke(obj, realValue);
        }
      }
      
      
    }
    System.out.println(obj);
    
  }

}








