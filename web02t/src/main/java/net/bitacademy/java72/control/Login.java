package net.bitacademy.java72.control;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import net.bitacademy.java72.annotation.RequestMapping;
import net.bitacademy.java72.dao.MemberDao;
import net.bitacademy.java72.domain.Member;

@Controller("/auth/login.do")
public class Login {
  @Autowired MemberDao memberDao;
  
  @RequestMapping
  public String login(
      HttpServletRequest request, 
      HttpServletResponse response) throws Exception {
    
    if (request.getMethod().equals("GET")) {
      String refererUrl = request.getHeader("Referer");
      if (refererUrl != null) {
        HttpSession session = request.getSession();
        session.setAttribute("refererUrl", refererUrl);
      }
    
      Cookie[] cookieList = request.getCookies();
      if (cookieList != null) {
        for (Cookie cookie : cookieList) {
          if (cookie.getName().equals("email")) {
            request.setAttribute("email", cookie.getValue());
            break;
          }
        }
      }
      
      return "/auth/LoginForm.jsp";
      
    } else { // POST 요청 처리
      String email = request.getParameter("email");
      String password = request.getParameter("password");
    
      if (request.getParameter("saveEmail") != null) {
        Cookie cookie = new Cookie("email", email);
        cookie.setMaxAge(60 * 60 * 24);
        response.addCookie(cookie);
      } else { 
        // 기억하기를 체크하지 않았다면, 쿠키를 무효화 시킨다.
        Cookie cookie = new Cookie("email", "");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
      }
    
      Member member = memberDao.exist(email, password);
      
      HttpSession session = request.getSession();
          
      if (member == null) {
        session.invalidate();
        return "/auth/LoginFail.jsp";
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
  }
}
