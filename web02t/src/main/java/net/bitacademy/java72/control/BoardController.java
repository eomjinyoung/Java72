package net.bitacademy.java72.control;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import net.bitacademy.java72.domain.Board;
import net.bitacademy.java72.service.BoardService;
import net.bitacademy.java72.util.MultipartUtils;

@Controller
@RequestMapping("/board")
public class BoardController {
  @Autowired BoardService boardService;
  @Autowired ServletContext servletContext;

  
  @RequestMapping("/delete.do")
  public String delete(int no) {
    boardService.delete(no);
    return "redirect:list.do";
  }
  
  @RequestMapping("/detail.do")
  public String detail(int no, Model model) {
    model.addAttribute("board", boardService.get(no));
    return "board/BoardDetail";
  }

  @RequestMapping("/insert.do")
  public String insert(
      Board board,
      @RequestParam MultipartFile file1) throws Exception {
      
      String filename = MultipartUtils.getFilename(
                            file1.getOriginalFilename());
      File newPath = new File(
          servletContext.getRealPath("/files") 
          + "/" + filename);
      file1.transferTo(newPath);

      board.setAttachFile1(filename);
      boardService.insert(board);
      
      return "redirect:list.do";
  }
  
  @RequestMapping("/list.do")
  public String list(
      @RequestParam(required=false, defaultValue="1") 
      int pageNo,
      @RequestParam(required=false, defaultValue="3")
      int pageSize,
      Model model) {
    
    if (pageNo > 1) { // 이전 페이가 있다면
      model.addAttribute("prevPageNo", pageNo - 1);
    }

    int totalCount = boardService.countAll();
    int lastPageNo = totalCount / pageSize;
    if ((totalCount % pageSize)  > 0) {
      lastPageNo++;
    }
    
    if (pageNo < lastPageNo) { // 다음 페이지가 있다면
      model.addAttribute("nextPageNo", pageNo + 1);
    }
    
    model.addAttribute("pageSize", pageSize);
    
    model.addAttribute("boards", 
        boardService.list(pageNo, pageSize));
    return "board/BoardList";
  }
  
  @RequestMapping("/update.do")
  public String boardUpdate (
      Board board,
      @RequestParam MultipartFile file1) throws Exception {

    String filename = MultipartUtils.getFilename(
        file1.getOriginalFilename());
    File newPath = new File(
                    servletContext.getRealPath("/files") 
                    + "/" + filename);
    file1.transferTo(newPath);
    
    board.setAttachFile1(filename);
    boardService.update(board);

    return "redirect:list.do";
  }
}





