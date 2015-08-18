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
  public String list(Model model) {
    model.addAttribute("boards", boardService.list());
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





