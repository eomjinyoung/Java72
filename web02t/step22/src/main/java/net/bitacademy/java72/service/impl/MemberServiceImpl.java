package net.bitacademy.java72.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.bitacademy.java72.dao.MemberDao;
import net.bitacademy.java72.domain.Member;
import net.bitacademy.java72.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {
  @Autowired MemberDao memberDao;
  
  @Override
  public List<Member> list() {
    return memberDao.list();
  }

  @Override
  public int delete(int no) {
    return memberDao.delete(no);
  }

  @Override
  public int update(Member member) {
    return memberDao.update(member);
  }

  @Override
  public int insert(Member member) {
    return memberDao.insert(member);
  }

  @Override
  public Member get(int no) {
    return memberDao.get(no);
  }

  @Override
  public Member getUser(String email, String password) {
    HashMap<String,String> map = 
        new HashMap<String,String>();
    map.put("email", email);
    map.put("password", password);
    
    return memberDao.exist(map);
  }

}






