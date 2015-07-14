package net.bitacademy.java72.control;

import java.util.List;
import java.util.Map;

import net.bitacademy.java72.annotation.Autowired;
import net.bitacademy.java72.annotation.Controller;
import net.bitacademy.java72.annotation.RequestMapping;
import net.bitacademy.java72.dao.BoardDao;
import net.bitacademy.java72.domain.Board;

@Controller("board/list.do")
public class BoardList {
  BoardDao boardDao;
  
  @Autowired
  public void setBoardDao(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  // 명령어가 들어 왔을 때 호출될 메서드를 지정한다.
  @RequestMapping
  public void list(Map<String, Object> paramMap) {
    List<Board> boards = boardDao.list();
    for (Board board : boards) {
      System.out.printf("%d, %s, %s, %d\n", 
          board.getNo(),
          board.getTitle(),
          board.getCreateDate(),
          board.getViewCount());
    }
  }

}
