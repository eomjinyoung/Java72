package net.bitacademy.java72.control;

import java.io.PrintStream;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import net.bitacademy.java72.annotation.RequestMapping;
import net.bitacademy.java72.dao.MemberDao;
import net.bitacademy.java72.domain.Member;

@Controller("member/list.do")
public class MemberList {
  MemberDao memberDao;
  
  @Autowired
  public void setMemberDao(MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  @RequestMapping
  public void list(Map<String, Object> paramMap) {
    PrintStream out = (PrintStream)paramMap.get("out");
    List<Member> members = memberDao.list();
    for (Member member : members) {
      out.printf("%d, %s, %s, %s, %s\n", 
          member.getNo(),
          member.getName(),
          member.getEmail(),
          member.getTel(),
          member.getCreateDate());
    }
  }

}