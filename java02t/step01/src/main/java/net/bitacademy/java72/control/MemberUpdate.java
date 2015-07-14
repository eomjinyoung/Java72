package net.bitacademy.java72.control;

import java.util.Map;
import java.util.Scanner;

import net.bitacademy.java72.annotation.Autowired;
import net.bitacademy.java72.annotation.Controller;
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
    Scanner scanner = (Scanner)paramMap.get("inputScanner");
    System.out.print("변경할 회원 번호? ");
    int no = Integer.parseInt(scanner.nextLine());
    
    Member member = memberDao.get(no);
    
    System.out.printf("이름(%s)? ", member.getName());
    String newName = scanner.nextLine();
    if (newName.length() > 0) {
      member.setName(newName);
    }
    
    System.out.printf("이메일(%s)? ", member.getEmail());
    String newEmail = scanner.nextLine();
    if (newEmail.length() > 0) {
      member.setEmail(newEmail);
    }
    
    System.out.printf("전화(%s)? ", member.getTel());
    String newTel = scanner.nextLine();
    if (newTel.length() > 0) {
      member.setTel(newTel);
    }
    
    System.out.printf("암호(*****)? ", member.getPassword());
    String newPassword = scanner.nextLine();
    if (newPassword.length() > 0) {
      member.setPassword(newPassword);
    }
    
    int count = memberDao.update(member);
    if (count == 0) {
      System.out.println("변경 실패!");
    } else {
      System.out.println("변경 성공!");
    }

  }

}
