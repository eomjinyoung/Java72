package net.bitacademy.java72.control;

import java.io.PrintStream;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import net.bitacademy.java72.annotation.RequestMapping;
import net.bitacademy.java72.dao.BoardDao;
import net.bitacademy.java72.domain.Board;

@Controller("board/detail.do")
public class BoardDetail {
  BoardDao boardDao;
  
  @Autowired
  public void setBoardDao(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  @RequestMapping
  public void detail(Map<String, Object> paramMap) {
    PrintStream out = (PrintStream)paramMap.get("out");
    int no = Integer.parseInt((String)paramMap.get("no"));
    
    Board board = boardDao.get(no);
    
    if (board != null) {
      out.printf("번호: %s\n", board.getNo());
      out.printf("제목: %s\n", board.getTitle());
      out.printf("내용: %s\n", board.getContent());
      out.printf("조회수: %s\n", board.getViewCount());
      out.printf("등록일: %s\n", board.getCreateDate());
    } else {
      out.println("해당 번호의 게시물을 찾을 수 없습니다.");
    }
  }

}








