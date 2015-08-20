package net.bitacademy.java72.control.json;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import net.bitacademy.java72.domain.Board;
import net.bitacademy.java72.service.BoardService;
import net.bitacademy.java72.util.ResponseFactory;

@Controller("json.BoardController")
@RequestMapping("/json/board")
public class BoardController {
  @Autowired BoardService boardService;
  @Autowired ServletContext servletContext;

  
  @RequestMapping("/delete.do")
  public ResponseEntity<String> delete(int no) {
    int count = boardService.delete(no);

    Map<String,Object> result = 
        new HashMap<String,Object>();
    if (count > 0) {
      result.put("data", "success");
    } else {
      result.put("data", "failure");
    }
    
    return ResponseFactory.createResponse(result);
  }
  
  @RequestMapping("/detail.do")
  public ResponseEntity<String> detail(int no) {
    Map<String,Object> result = 
        new HashMap<String,Object>();
    result.put("data", boardService.get(no));
    
    return ResponseFactory.createResponse(result);
  }

  @RequestMapping("/insert.do")
  public ResponseEntity<String> insert(
      Board board,
      @RequestParam(required=false) MultipartFile file1) throws Exception {
      
      /*
      String filename = MultipartUtils.getFilename(
                            file1.getOriginalFilename());
      File newPath = new File(
          servletContext.getRealPath("/files") 
          + "/" + filename);
      file1.transferTo(newPath);

      board.setAttachFile1(filename);
      */
    
      int count = boardService.insert(board);
      
      Map<String,Object> result = 
          new HashMap<String,Object>();
      if (count > 0) {
        result.put("data", "success");
      } else {
        result.put("data", "failure");
      }
      
      return ResponseFactory.createResponse(result);
  }
  
  @RequestMapping("/list.do")
  public ResponseEntity<String> list(
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
    
    return ResponseFactory.createResponse(result);
  }
  
  @RequestMapping("/update.do")
  public ResponseEntity<String> boardUpdate (
      Board board,
      @RequestParam(required=false) MultipartFile file1) throws Exception {

    /*
    String filename = MultipartUtils.getFilename(
        file1.getOriginalFilename());
    File newPath = new File(
                    servletContext.getRealPath("/files") 
                    + "/" + filename);
    file1.transferTo(newPath);
    
    board.setAttachFile1(filename);
    */
    int count = boardService.update(board);

    Map<String,Object> result = 
        new HashMap<String,Object>();
    if (count > 0) {
      result.put("data", "success");
    } else {
      result.put("data", "failure");
    }
    
    return ResponseFactory.createResponse(result);
  }
}





