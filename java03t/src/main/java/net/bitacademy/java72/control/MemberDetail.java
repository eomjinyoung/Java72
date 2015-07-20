package net.bitacademy.java72.control;

import java.io.PrintStream;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import net.bitacademy.java72.annotation.RequestMapping;
import net.bitacademy.java72.dao.MemberDao;
import net.bitacademy.java72.domain.Member;

@Controller("member/detail.do")
public class MemberDetail {
  MemberDao memberDao;
  
  @Autowired
  public void setMemberDao(MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  @RequestMapping
  public void delete(Map<String, Object> paramMap) {
    PrintStream out = (PrintStream)paramMap.get("out");
    int no = Integer.parseInt((String)paramMap.get("no"));
    
    Member member = memberDao.get(no);
    
    if (member != null) {
      out.printf("번호: %s\n", member.getNo());
      out.printf("이름: %s\n", member.getName());
      out.printf("이메일: %s\n", member.getEmail());
      out.printf("전화: %s\n", member.getTel());
      out.printf("등록일: %s\n", member.getCreateDate());
    } else {
      out.println("해당 번호의 회원을 찾을 수 없습니다.");
    }
    
  }

}
