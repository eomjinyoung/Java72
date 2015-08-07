package study;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/study/controller02.do")
public class Controller02 {
  
  @RequestMapping
  public String service() {
    return "/study/Controller01.jsp";
  }
}
