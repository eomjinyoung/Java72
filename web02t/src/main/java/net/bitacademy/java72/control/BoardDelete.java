package net.bitacademy.java72.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import net.bitacademy.java72.annotation.RequestMapping;
import net.bitacademy.java72.dao.BoardDao;

@Controller("/board/delete.do")
public class BoardDelete {
  @Autowired
  BoardDao boardDao;

  @RequestMapping
  public String delete(int no) {
    boardDao.delete(no);
    return "redirect:list.do";
  }

}





