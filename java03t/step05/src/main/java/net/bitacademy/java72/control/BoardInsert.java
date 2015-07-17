package net.bitacademy.java72.control;

import java.io.PrintStream;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import net.bitacademy.java72.annotation.RequestMapping;
import net.bitacademy.java72.dao.BoardDao;
import net.bitacademy.java72.domain.Board;

@Controller("board/insert.do")
public class BoardInsert {

  BoardDao boardDao;
  
  @Autowired
  public void setBoardDao(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  @RequestMapping
  public void insert(Map<String, Object> paramMap) {
    PrintStream out = (PrintStream)paramMap.get("out");
    
    Board board = new Board();
    board.setTitle((String)paramMap.get("title"));
    board.setContent((String)paramMap.get("content"));
    board.setPassword((String)paramMap.get("password"));

    int count = boardDao.insert(board);
    if (count == 0) {
      out.println("입력 실패!");
    } else {
      out.println("입력 성공!");
    }
  }

}
