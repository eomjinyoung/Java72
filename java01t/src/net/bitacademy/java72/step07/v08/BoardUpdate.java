package net.bitacademy.java72.step07.v08;

import java.util.Map;
import java.util.Scanner;

import net.bitacademy.java72.step07.v02.Board;
import net.bitacademy.java72.step07.v02.BoardDao;

@CommandProcessor("update")
public class BoardUpdate {
  
  BoardDao boardDao;
  
  @Autowired
  public void setBoardDao(BoardDao boardDao) {
    this.boardDao = boardDao;
  }
  
  @RequestMapping
  public void update(Map<String, Object> paramMap) {
    Scanner scanner = (Scanner)paramMap.get("inputScanner");
    System.out.print("변경할 게시물 번호? ");
    int no = Integer.parseInt(scanner.nextLine());
    
    // 해당 게시물의 데이터를 가져온다.
    Board board = boardDao.get(no);
    
    // 사용자로부터 변경 내용을 입력 받는다.
    System.out.printf("제목(%s)? ", board.getTitle());
    String newTitle = scanner.nextLine();
    if (newTitle.length() > 0) {
      board.setTitle(newTitle);
    }
    
    System.out.printf("내용(%s)? ", board.getContent());
    String newContent = scanner.nextLine();
    if (newContent.length() > 0) {
      board.setContent(newContent);
    }
    
    // 입력 받은 내용으로 게시물을 변경한다.
    int count = boardDao.update(board);
    if (count == 0) {
      System.out.println("변경 실패!");
    } else {
      System.out.println("변경 성공!");
    }

  }

}
