package net.bitacademy.java72.control;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import net.bitacademy.java72.dao.MemberDao;
import net.bitacademy.java72.domain.Member;
import net.bitacademy.java72.util.MultipartDataProcessor;

@Controller("/member/update.do")
public class MemberUpdate {
  @Autowired MemberDao memberDao;
  
  @RequestMapping
  public String update(
      HttpServletRequest request) throws Exception {
  
    Map<String,String> paramMap = 
        MultipartDataProcessor.toParamMap(
            "/files", request);
    
    Member member = new Member();
    member.setNo(Integer.parseInt(
        paramMap.get("no")));
    member.setName(paramMap.get("name"));
    member.setEmail(paramMap.get("email"));
    member.setTel(paramMap.get("tel"));
    member.setPassword(paramMap.get("password"));
    member.setPhoto(paramMap.get("photo"));
    
    memberDao.update(member);
    return "redirect:list.do";
  }

}
