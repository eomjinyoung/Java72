package study;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;

@Controller
@RequestMapping("/study")
public class Controller07 {

  @RequestMapping("/controller0701.do")
  public String service1() {
    return "/study/Controller07.jsp";
  }

  @RequestMapping("/controller0702.do")
  public ModelAndView service2() {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("/study/Controller07.jsp");
    mv.addObject("message", "오호라.. 값 전달");

    ArrayList<String> names = new ArrayList<String>();
    names.add("홍길동");
    names.add("임꺽정");

    mv.addObject("names", names);

    return mv;
  }

  // 리턴 값: View URL
  // 파라미터 값: JSP에 전달할 값 
  @RequestMapping("/controller0703.do")
  public ModelAndView service3(Map<String,Object> model) {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("/study/Controller07.jsp");

    model.put("message", "오호라.. 값 전달");

    ArrayList<String> names = new ArrayList<String>();
    names.add("홍길동");
    names.add("임꺽정");

    model.put("names", names);

    return mv;
  }

  //리턴 값: View URL
  // 파라미터 값: JSP에 전달할 값 
  @RequestMapping("/controller0704.do")
  public String service4(Map<String,Object> model) {
    model.put("message", "오호라.. 값 전달");

    ArrayList<String> names = new ArrayList<String>();
    names.add("홍길동");
    names.add("임꺽정");

    model.put("names", names);

    return "/study/Controller07.jsp";
  }

  //리턴 값: View URL
  // 파라미터 값: JSP에 전달할 값 
  @RequestMapping("/controller0705.do")
  public String service5(Model model) {
    model.addAttribute("message", "오호라.. 값 전달");

    ArrayList<String> names = new ArrayList<String>();
    names.add("홍길동");
    names.add("임꺽정");

    model.addAttribute("names", names);

    return "/study/Controller07.jsp";
  }
  
  @RequestMapping("/controller0706.do")
  public View service6(Model model) {
    model.addAttribute("message", "오호라.. 값 전달");

    ArrayList<String> names = new ArrayList<String>();
    names.add("홍길동");
    names.add("임꺽정");

    model.addAttribute("names", names);

    return new InternalResourceView(
                    "/study/Controller07.jsp");
  }
  
  //JSP 경유하지 않고 클라이언트로 출력하기 
  //=> T.T 한글 깨짐.
  @RequestMapping("/controller0707.do")
  @ResponseBody
  public String service7(HttpServletResponse response) {
    // 다음이 안통한다.
    response.setContentType("text/html;charset=UTF-8");
    return "<html><body>"
        + "<h1>오호라...</h1>"
        + "<p>직접 출력할 수 있네!</p>"
        + "</body></html>";
  }
  
  @RequestMapping("/controller0708.do")
  public ResponseEntity<String> service8(HttpServletResponse response) {
    // 다음 안 통한다. => 응답 헤더에 직접 추가하라!
    //response.setContentType("text/html;charset=UTF-8");
    
    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-type", 
                "text/html;charset=UTF-8");
    
    String body = "<html><body>"
        + "<h1>오호라...</h1>"
        + "<p>직접 출력할 수 있네!</p>"
        + "</body></html>";
    
    return new ResponseEntity<String>(
        body, headers, HttpStatus.OK);
  }
}





