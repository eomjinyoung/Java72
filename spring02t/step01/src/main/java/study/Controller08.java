package study;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/study")
public class Controller08 {
  // 기존의 HttpServletRequest와 HttpServletResponse,
  // ServletRequest, ServletResponse를 파라미터로 
  // 받을 수 있다.
  @RequestMapping("/controller0801.do")
  public String service1(
      HttpServletRequest request,
      HttpServletResponse response) {
    System.out.println(request.getParameter("name"));
    return "/study/Controller01.jsp";
  }
  
  // 메서드 파라미터와 일치하는 요청 파라미터 값이 있다면,
  // 호출할 때 넘겨준다.
  @RequestMapping("/controller0802.do")
  public String service2(String name, String age) {
    System.out.printf("%s,%s\n", name, age);
    return "/study/Controller01.jsp";
  }
  
  // 메서드의 파라미터 타입이 원시 타입일 경우
  // 자동으로 형변환시켜 넘겨준다.
  @RequestMapping("/controller0803.do")
  public String service3(String name, int age) {
    System.out.printf("%s,%d\n", name, age);
    return "/study/Controller01.jsp";
  }
  
  // 메서드의 파라미터를 선언할 때
  // 어떤 요청 파라미터 값을 대입할 지 
  // 애노테이션을 이용하여 명시적으로 지정할 수 있다.
  // => 요청 파라미터 이름과 메서드 파라미터 이름이 다를 경우,
  // => 기본은 필수 입력이다.
  @RequestMapping("/controller0804.do")
  public String service4(
      @RequestParam("name") String n,
      @RequestParam("age") int a) {
    System.out.printf("%s,%d\n", n, a);
    return "/study/Controller01.jsp";
  }
  
  // 애노테이션을 붙이더라도 선택 입력으로 만들고 싶으면,
  @RequestMapping("/controller0805.do")
  public String service5(
      @RequestParam(value="name", required=false) String n,
      @RequestParam(value="age", required=false, defaultValue="18") int a) {
    System.out.printf("%s,%d\n", n, a);
    return "/study/Controller01.jsp";
  }
  
  //메서드의 파라미터 이름과 요청 파라미터 이름이 같다면,
  @RequestMapping("/controller0806.do")
  public String service6(
      @RequestParam(required=false) String name,
      @RequestParam(required=false, defaultValue="18") int age) {
    System.out.printf("%s,%d\n", name, age);
    return "/study/Controller01.jsp";
  }
  
  // 요청 파라미터 값을 Value Object 객체에 담을 수 있다.
  @RequestMapping("/controller0807.do")
  public String service7(Member m) {
    System.out.printf("%s,%d\n", m.name, m.age);
    return "/study/Controller01.jsp";
  }
}















