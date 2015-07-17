package net.bitacademy.java72.control;

import java.io.PrintStream;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import net.bitacademy.java72.annotation.RequestMapping;
import net.bitacademy.java72.dao.BoardDao;
import net.bitacademy.java72.domain.Board;

@Controller("board/update.do")
public class BoardUpdate {
  
  BoardDao boardDao;
  
  @Autowired
  public void setBoardDao(BoardDao boardDao) {
    this.boardDao = boardDao;
  }
  
  @RequestMapping
  public void update(Map<String, Object> paramMap) {
    PrintStream out = (PrintStream)paramMap.get("out");
    
    Board board = new Board();
    board.setNo(Integer.parseInt(
        (String)paramMap.get("no")));
    board.setTitle((String)paramMap.get("title"));
    board.setContent((String)paramMap.get("content"));
    board.setPassword((String)paramMap.get("password"));
    
    // 입력 받은 내용으로 게시물을 변경한다.
    int count = boardDao.update(board);
    if (count == 0) {
      out.println("변경 실패!");
    } else {
      out.println("변경 성공!");
    }

  }

}
