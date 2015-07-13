package net.bitacademy.java72.step07.v09;

import java.util.List;
import java.util.Map;

import net.bitacademy.java72.step07.v02.Board;
import net.bitacademy.java72.step07.v02.BoardDao;

@Controller("list")
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
