package net.bitacademy.java72.control;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.bitacademy.java72.domain.Member;
import net.bitacademy.java72.service.MemberService;

@Controller
@RequestMapping("/auth")
public class AuthController {
  @Autowired MemberService memberService;
  
  @RequestMapping(value="/login.do", 
      method=RequestMethod.GET)
  public String form(
      @CookieValue(required=false) String email,
      HttpServletRequest request, 
      HttpSession session,
      Model model) throws Exception {

    String refererUrl = request.getHeader("Referer");
    if (refererUrl != null) {
      session.setAttribute("refererUrl", refererUrl);
    }

    if (email != null) {
      model.addAttribute("email", email);
    }
    
    return "auth/LoginForm";
  }
  
  @RequestMapping(value="/login.do", 
      method=RequestMethod.POST)
  public String login(
      String email, 
      String password,
      String saveEmail,
      HttpServletResponse response,
      HttpSession session) throws Exception {

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
      return "auth/LoginFail";
    } else {
      session.setAttribute("member", member);

      String refererUrl = 
          (String)session.getAttribute("refererUrl");
      if (refererUrl == null) {
        return "redirect:../board/list.do";
      } else {
        return "redirect:" + refererUrl;
      }
    }
  }
  
  @RequestMapping("/logout.do")
  public String logout(HttpSession session) {
    session.invalidate(); 
    return "redirect:login.do";
  }
}






