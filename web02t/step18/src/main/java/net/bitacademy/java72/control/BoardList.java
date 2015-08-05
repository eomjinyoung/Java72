package net.bitacademy.java72.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import net.bitacademy.java72.annotation.RequestMapping;
import net.bitacademy.java72.dao.BoardDao;
import net.bitacademy.java72.domain.Board;

@Controller("/board/list.do")
public class BoardList {
  @Autowired BoardDao boardDao;
  
  @RequestMapping
  public String list(HttpServletRequest request) {
    
    List<Board> boards = null;
    boards = boardDao.list();
    request.setAttribute("boards", boards);
    return "/board/BoardList.jsp";
  }
}



