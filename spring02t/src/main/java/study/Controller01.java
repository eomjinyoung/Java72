package study;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("/study/controller01.do")
public class Controller01 {
  
  @RequestMapping
  public String service() {
    return "/study/Controller01.jsp";
  }
}
