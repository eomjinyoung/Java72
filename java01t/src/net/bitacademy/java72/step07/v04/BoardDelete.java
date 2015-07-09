package net.bitacademy.java72.step07.v04;

import java.util.Map;
import java.util.Scanner;

import net.bitacademy.java72.step07.v02.BoardDao;

public class BoardDelete implements Command {
  BoardDao boardDao;
  

  public void setBoardDao(BoardDao boardDao) {
    this.boardDao = boardDao;
  }


  @Override
  public void execute(Map<String, Object> paramMap) {
    Scanner scanner = (Scanner)paramMap.get("inputScanner");
    System.out.print("삭제할 게시물 번호? ");
    int no = Integer.parseInt(scanner.nextLine());
    
    boardDao.delete(no);
    
  }

}
