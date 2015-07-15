package net.bitacademy.java72.control;

import java.util.Map;
import java.util.Scanner;

import net.bitacademy.java72.annotation.Autowired;
import net.bitacademy.java72.annotation.Controller;
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
    Scanner scanner = (Scanner)paramMap.get("inputScanner");
    System.out.print("삭제할 회원 번호? ");
    int no = Integer.parseInt(scanner.nextLine());
    
    memberDao.delete(no);
    
  }

}
