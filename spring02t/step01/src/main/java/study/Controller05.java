package study;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/study")
public class Controller05 {
  
  @RequestMapping("/controller0501.do")
  public String service1() {
    return "/study/Controller01.jsp";
  }
  
  @RequestMapping("/controller0502.do")
  public String service2() {
    return "/study/Controller01.jsp";
  }
  
  @RequestMapping("/controller0503.do")
  public String service3() {
    return "/study/Controller01.jsp";
  }
}
