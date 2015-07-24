package util;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.util.Base64;
import java.util.Base64.Encoder;

public class Base64Generator {

  public static void main(String[] args) throws Exception {
    
    BufferedInputStream in = 
        new BufferedInputStream(
            new FileInputStream(
                "src/main/webapp/html/pic01.jpg"));
    
    ByteArrayOutputStream out =
        new ByteArrayOutputStream();
    
    int b = 0;
    while ( (b = in.read()) != -1) {
      out.write(b);
    }
    
    Encoder encoder = Base64.getEncoder();
    String result = 
        encoder.encodeToString(out.toByteArray());
    System.out.println(result);
    
    out.close();
    in.close();
    
  }

}







