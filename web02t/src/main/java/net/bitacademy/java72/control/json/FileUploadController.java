package net.bitacademy.java72.control.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import net.bitacademy.java72.domain.FileItem;

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
      ArrayList<FileItem> files = new ArrayList<FileItem>();
      for (MultipartFile f : file) {
        files.add(
          new FileItem()
            .setName("")
            .setOriginName(f.getOriginalFilename())
            .setSize(f.getSize()));
      }
      
      Map<String,Object> result = 
          new HashMap<String,Object>();
      result.put("data", files);
      
      return result;
  }
  
 
}





