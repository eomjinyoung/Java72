package net.bitacademy.java72.step07.v09.member;

import java.util.Map;
import java.util.Scanner;

import net.bitacademy.java72.step07.v09.Autowired;
import net.bitacademy.java72.step07.v09.Controller;
import net.bitacademy.java72.step07.v09.RequestMapping;

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
