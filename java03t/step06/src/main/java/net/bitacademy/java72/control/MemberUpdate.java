package net.bitacademy.java72.control;

import java.io.PrintWriter;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import net.bitacademy.java72.annotation.RequestMapping;
import net.bitacademy.java72.dao.MemberDao;
import net.bitacademy.java72.domain.Member;

@Controller("member/update.do")
public class MemberUpdate {
  
  MemberDao memberDao;
  
  @Autowired
  public void setMemberDao(MemberDao memberDao) {
    this.memberDao = memberDao;
  }
  
  @RequestMapping
  public void update(Map<String, Object> paramMap) {
    PrintWriter out = (PrintWriter)paramMap.get("out");
    
    Member member = new Member();
    member.setNo(Integer.parseInt(
        (String)paramMap.get("no")));
    member.setName((String)paramMap.get("name"));
    member.setEmail((String)paramMap.get("email"));
    member.setTel((String)paramMap.get("tel"));
    member.setPassword((String)paramMap.get("password"));
    
    int count = memberDao.update(member);
    if (count == 0) {
      out.println("변경 실패!");
    } else {
      out.println("변경 성공!");
    }

  }

}
