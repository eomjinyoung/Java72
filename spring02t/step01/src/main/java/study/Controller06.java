package study;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/study")
public class Controller06 {
  
  @RequestMapping(
      path="/controller06.do",
      method=RequestMethod.GET)
  public String get() {
    return "/study/Controller06get.jsp";
  }
  
  @RequestMapping(
      path="/controller06.do",
      method=RequestMethod.POST)
  public String post() {
    return "/study/Controller06post.jsp";
  }
}
