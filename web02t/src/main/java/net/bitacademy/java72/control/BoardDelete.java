package net.bitacademy.java72.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import net.bitacademy.java72.annotation.RequestMapping;
import net.bitacademy.java72.dao.BoardDao;

@Controller("/board/delete.do")
public class BoardDelete {
  @Autowired
  BoardDao boardDao;

  @RequestMapping
  public String delete(
      HttpServletRequest request, 
      HttpServletResponse response) {

    int no = Integer.parseInt(request.getParameter("no"));

    boardDao.delete(no);
    return "redirect:list.do";
  }

}





