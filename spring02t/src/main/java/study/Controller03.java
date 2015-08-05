package study;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controller03 {
  
  @RequestMapping("/study/controller03.do")
  public String service() {
    return "/study/Controller01.jsp";
  }
}
