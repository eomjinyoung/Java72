package net.bitacademy.java72.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("/auth/logout.do")
public class Logout {
  
  @RequestMapping
  public String logout(
      HttpServletRequest request, 
      HttpServletResponse response) {
    
    HttpSession session = request.getSession();
    session.invalidate(); 
    
    return "redirect:login.do";
  }

}








