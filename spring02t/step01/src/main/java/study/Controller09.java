package study;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/study")
public class Controller09 {
  // ServletContext 객체는 파라미터로 주입 받을 수 없다. 
  // 의존 객체로 주입 받아야 한다.
  @Autowired ServletContext servletContext;
  
  
  // 멀티파트 데이터 처리
  // 일반적인 폼 데이터인 경우는 기존의 방식대로 한다.
  // 파일 데이터인 경우 MultipartFile 타입으로 받는다.
  // 단 @RequestParam 을 명식적으로 선언해야 한다.
  @RequestMapping("/controller0901.do")
  public String service(
      String name,
      @RequestParam MultipartFile photo,
      Model model) throws Exception {
    
    System.out.println(name);
    System.out.println(photo.getOriginalFilename());
    
    // 임시 폴더에 저장되어 있는 업로드 파일을
    // 우리가 원하는 폴더로 옮긴다.
    String filename = getFilename(
                    photo.getOriginalFilename());
    File newPath = new File(
        servletContext.getRealPath("/files") 
        + "/" + filename);
    
    photo.transferTo(newPath);
    
    model.addAttribute("filename", filename);
    
    return "/study/Controller09.jsp";
  }
  
  private static int count = 0;
  private static String getFilename(String originName) {
    if (count > 1000) count = 0;
    int dotLoc = originName.lastIndexOf(".");
    return System.currentTimeMillis()
        + "_" + (++count) + originName.substring(dotLoc);
  }
}






