package net.bitacademy.java72.control;

import java.util.List;
import java.util.Map;

import net.bitacademy.java72.step07.v09.Autowired;
import net.bitacademy.java72.step07.v09.Controller;
import net.bitacademy.java72.step07.v09.RequestMapping;

@Controller("member/list.do")
public class MemberList {
  MemberDao memberDao;
  
  @Autowired
  public void setMemberDao(MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  @RequestMapping
  public void list(Map<String, Object> paramMap) {
    List<Member> members = memberDao.list();
    for (Member member : members) {
      System.out.printf("%d, %s, %s, %s, %s\n", 
          member.getNo(),
          member.getName(),
          member.getEmail(),
          member.getTel(),
          member.getCreateDate());
    }
  }

}