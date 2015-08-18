package net.bitacademy.java72.dao;

import java.util.List;
import java.util.Map;

import net.bitacademy.java72.domain.Member;

public interface MemberDao {
  List<Member> list(Map<String,Object> paramMap);
  int delete(int no);
  int update(Member member);
  int insert(Member member);
  Member get(int no);
  Member exist(Map<String,String> map);
  int countAll();
  int countEmail(String email);
}











