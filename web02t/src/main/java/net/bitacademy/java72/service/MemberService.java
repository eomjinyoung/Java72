package net.bitacademy.java72.service;

import java.util.List;

import net.bitacademy.java72.domain.Member;

public interface MemberService {
  List<Member> list();
  int delete(int no);
  int update(Member member);
  int insert(Member member);
  Member get(int no);
  Member getUser(String email, String password);
}







