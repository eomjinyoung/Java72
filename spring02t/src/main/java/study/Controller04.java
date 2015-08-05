package study;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/study")
public class Controller04 {
  
  @RequestMapping("/controller04.do")
  public String service() {
    return "/study/Controller01.jsp";
  }
}
