package net.bitacademy.java72.step07.v09;

import java.util.Map;
import java.util.Scanner;

@Controller("delete")
public class BoardDelete {
  BoardDao boardDao;
  
  @Autowired
  public void setBoardDao(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  @RequestMapping
  public void delete(Map<String, Object> paramMap) {
    Scanner scanner = (Scanner)paramMap.get("inputScanner");
    System.out.print("삭제할 게시물 번호? ");
    int no = Integer.parseInt(scanner.nextLine());
    
    boardDao.delete(no);
    
  }

}
