package net.bitacademy.java72.control;

import java.io.PrintWriter;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import net.bitacademy.java72.annotation.RequestMapping;
import net.bitacademy.java72.dao.MemberDao;

@Controller("member/delete.do")
public class MemberDelete {
  MemberDao memberDao;
  
  @Autowired
  public void setMemberDao(MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  @RequestMapping
  public void delete(Map<String, Object> paramMap) {
    PrintWriter out = (PrintWriter)paramMap.get("out");
    int no = Integer.parseInt((String)paramMap.get("no"));
    
    int count = memberDao.delete(no);
    
    if (count == 0) {
      out.println("삭제 실패!");
    } else {
      out.println("삭제 성공!");
    }
  }

}
