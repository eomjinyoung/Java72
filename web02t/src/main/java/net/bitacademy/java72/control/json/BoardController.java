package net.bitacademy.java72.control.json;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.bitacademy.java72.domain.Board;
import net.bitacademy.java72.service.BoardService;

@Controller("json.BoardController")
@RequestMapping("/json/board")
public class BoardController {
  @Autowired BoardService boardService;
  @Autowired ServletContext servletContext;

  
  @RequestMapping("/delete")
  public Object delete(int no) {
    int count = boardService.delete(no);

    Map<String,Object> result = 
        new HashMap<String,Object>();
    if (count > 0) {
      result.put("data", "success");
    } else {
      result.put("data", "failure");
    }
    
    return result;
  }
  
  @RequestMapping("/detail")
  public Object detail(int no) {
    Map<String,Object> result = 
        new HashMap<String,Object>();
    result.put("data", boardService.get(no));
    
    return result;
  }

  @RequestMapping("/insert")
  public Object insert(Board board) throws Exception {
      int count = boardService.insert(board);
      
      Map<String,Object> result = 
          new HashMap<String,Object>();
      if (count > 0) {
        result.put("data", "success");
      } else {
        result.put("data", "failure");
      }
      
      return result;
  }
  
  @RequestMapping("/list")
  public Object list(
      @RequestParam(required=false, defaultValue="1") 
      int pageNo,
      @RequestParam(required=false, defaultValue="3")
      int pageSize) {
    
    Map<String,Object> result = 
        new HashMap<String,Object>();
    
    result.put("pageNo", pageNo);
    
    int totalCount = boardService.countAll();
    int lastPageNo = totalCount / pageSize;
    if ((totalCount % pageSize)  > 0) {
      lastPageNo++;
    }
    
    if (pageNo < lastPageNo) { // 다음 페이지가 있다면
      result.put("isNextPage", true);
    } else {
      result.put("isNextPage", false);
    }
    
    result.put("pageSize", pageSize);
    
    result.put("data", 
        boardService.list(pageNo, pageSize));
    
    return result;
  }
  
  @RequestMapping("/update")
  public Object boardUpdate (Board board) throws Exception {

    int count = boardService.update(board);

    Map<String,Object> result = 
        new HashMap<String,Object>();
    if (count > 0) {
      result.put("data", "success");
    } else {
      result.put("data", "failure");
    }
    
    return result;
  }
}





