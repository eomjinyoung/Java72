package net.bitacademy.java72.control;

import java.util.Map;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import net.bitacademy.java72.annotation.RequestMapping;
import net.bitacademy.java72.dao.MemberDao;
import net.bitacademy.java72.domain.Member;

@Controller("member/insert.do")
public class MemberInsert {

  MemberDao memberDao;
  
  @Autowired
  public void setMemberDao(MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  @RequestMapping
  public void insert(Map<String, Object> paramMap) {
    Scanner scanner = (Scanner)paramMap.get("inputScanner");
    
    Member member = new Member();

    System.out.print("이름? ");
    member.setName(scanner.nextLine());

    System.out.print("이메일? ");
    member.setEmail(scanner.nextLine());

    System.out.print("전화? ");
    member.setTel(scanner.nextLine());
    
    System.out.print("암호? ");
    member.setPassword(scanner.nextLine());

    int count = memberDao.insert(member);
    if (count == 0) {
      System.out.println("입력 실패!");
    } else {
      System.out.println("입력 성공!");
    }
  }

}
