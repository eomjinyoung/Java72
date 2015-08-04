package net.bitacademy.java72.control;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import net.bitacademy.java72.annotation.RequestMapping;
import net.bitacademy.java72.dao.BoardDao;
import net.bitacademy.java72.domain.Board;
import net.bitacademy.java72.util.MultipartDataProcessor;

@Controller("/board/insert.do")
public class BoardInsert {
  @Autowired BoardDao boardDao;
  
  @RequestMapping
  public String insert(
      HttpServletRequest request, 
      HttpServletResponse response) throws Exception {
      
      Map<String,String> paramMap = 
          MultipartDataProcessor.toParamMap(
              "/files", request);
    
      Board board = new Board();
      board.setTitle(paramMap.get("title"));
      board.setContent(paramMap.get("content"));
      board.setPassword(paramMap.get("password"));
      board.setAttachFile1(paramMap.get("file1"));
      
      boardDao.insert(board);
      return "redirect:list.do";
  }

}






