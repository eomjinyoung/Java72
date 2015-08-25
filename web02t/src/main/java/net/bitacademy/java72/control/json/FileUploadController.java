package net.bitacademy.java72.control.json;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller("json.FileUploadController")
@RequestMapping("/json/file")
public class FileUploadController {
 
  @RequestMapping("/upload")
  public Object insert(
      @RequestParam(required=false) MultipartFile[] file) throws Exception {
      
      /*
      String filename = MultipartUtils.getFilename(
                            file1.getOriginalFilename());
      File newPath = new File(
          servletContext.getRealPath("/files") 
          + "/" + filename);
      file1.transferTo(newPath);

      board.setAttachFile1(filename);
      */
    
      for (MultipartFile f : file) {
        System.out.printf("%s,%d\n",
            f.getOriginalFilename(),
            f.getSize());
      }
      
      Map<String,Object> result = 
          new HashMap<String,Object>();
      result.put("data", "success");
      
      return result;
  }
  
 
}





