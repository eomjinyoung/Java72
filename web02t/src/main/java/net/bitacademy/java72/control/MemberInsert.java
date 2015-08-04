package net.bitacademy.java72.control;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import net.bitacademy.java72.annotation.RequestMapping;
import net.bitacademy.java72.dao.MemberDao;
import net.bitacademy.java72.domain.Member;
import net.bitacademy.java72.util.MultipartDataProcessor;

@Controller("/member/insert.do")
public class MemberInsert {
  @Autowired MemberDao memberDao;
  
  @RequestMapping
  public String insert(
      HttpServletRequest request, 
      HttpServletResponse response) throws Exception {

    Map<String,String> paramMap = 
        MultipartDataProcessor.toParamMap(
            "/files", request);
    
    Member member = new Member();
    member.setName(paramMap.get("name"));
    member.setEmail(paramMap.get("email"));
    member.setTel(paramMap.get("tel"));
    member.setPassword(paramMap.get("password"));
    member.setPhoto(paramMap.get("photo"));

    memberDao.insert(member);
    return "redirect:list.do";
  }

}
