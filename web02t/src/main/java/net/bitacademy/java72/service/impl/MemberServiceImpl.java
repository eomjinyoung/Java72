package net.bitacademy.java72.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.bitacademy.java72.dao.MemberDao;
import net.bitacademy.java72.domain.Member;
import net.bitacademy.java72.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {
  @Autowired MemberDao memberDao;
  
  @Override
  public List<Member> list(int pageNo, int pageSize) {
    int startIndex = (pageNo - 1) * pageSize;
    if (startIndex < 0) {
      startIndex = 0;
    }
    
    Map<String,Object> paramMap = 
        new HashMap<String,Object>();
    paramMap.put("startIndex", startIndex);
    paramMap.put("pageSize", pageSize);
    
    return memberDao.list(paramMap);
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

  @Override
  public int countAll() {
    return memberDao.countAll();
  }

  @Override
  public boolean existEmail(String email) {
    if (memberDao.countEmail(email) > 0) {
      return true;
    } else {
      return false;
    }
  }

}






