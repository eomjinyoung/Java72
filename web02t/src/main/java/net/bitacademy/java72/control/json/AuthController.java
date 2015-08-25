package net.bitacademy.java72.control.json;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import net.bitacademy.java72.domain.Member;
import net.bitacademy.java72.service.MemberService;

@Controller("json.AuthController")
@RequestMapping("/json/auth")
public class AuthController {
  @Autowired MemberService memberService;
  
  @RequestMapping(value="/login")
  public Object login(
      String email, 
      String password,
      String saveEmail,
      HttpServletResponse response,
      HttpSession session) throws Exception {

    Map<String,Object> result = 
        new HashMap<String,Object>();
    
    if (saveEmail != null) {
      Cookie cookie = new Cookie("email", email);
      cookie.setMaxAge(60 * 60 * 24);
      response.addCookie(cookie);
    } else { 
      // 기억하기를 체크하지 않았다면, 쿠키를 무효화 시킨다.
      Cookie cookie = new Cookie("email", "");
      cookie.setMaxAge(0);
      response.addCookie(cookie);
    }

    Member member = memberService.getUser(email, password);

    if (member == null) {
      session.invalidate();
      result.put("data", "no");
      
    } else {
      session.setAttribute("member", member);
      result.put("data", "yes");
      
      String refererUrl = 
          (String)session.getAttribute("refererUrl");
      
      if (refererUrl != null) {
        result.put("refererUrl", refererUrl);
      }
    }
     
    return result;
  }
  
  @RequestMapping("/logout")
  public Object logout(HttpSession session) {
    session.invalidate(); 
    Map<String,Object> result = 
        new HashMap<String,Object>();
    result.put("data", "yes");
    
    return result;
  }
  
  @RequestMapping("/loginInfo")
  public Object loginInfo(
      HttpSession session) {
    
    Map<String,Object> result = 
        new HashMap<String,Object>();

    Member member = 
        (Member)session.getAttribute("member");
    
    if (member == null) {
      result.put("state", "no");
    } else {
      result.put("state", "yes");
      result.put("data", member);
    }
    
    return result;
  }
  
  @RequestMapping("/setRefererUrl")
  public Object setRefererUrl(
      String refererUrl,
      HttpSession session) {
    Map<String,Object> result = 
        new HashMap<String,Object>();
    session.setAttribute("refererUrl", refererUrl);
    result.put("data", "yes");
    return result;
  }
}






