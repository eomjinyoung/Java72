package net.bitacademy.java72.control;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import net.bitacademy.java72.annotation.RequestMapping;
import net.bitacademy.java72.dao.BoardDao;
import net.bitacademy.java72.domain.Board;

@Controller("/board/detail.do")
public class BoardDetail {
  @Autowired
  BoardDao boardDao;

  @RequestMapping
  public String detail(
      int no,
      HttpServletRequest request)  {

      Board board = boardDao.get(no);
      request.setAttribute("board", board);
    
      return "/board/BoardDetail.jsp";
    }
  }


