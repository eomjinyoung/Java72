package net.bitacademy.java72.step07.v04;

import java.util.List;
import java.util.Map;

import net.bitacademy.java72.step07.v02.Board;
import net.bitacademy.java72.step07.v02.BoardDao;

public class BoardList implements Command {
  BoardDao boardDao;

  public void setBoardDao(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  @Override
  public void execute(Map<String, Object> paramMap) {
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
