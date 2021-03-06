package net.bitacademy.java72.control;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import net.bitacademy.java72.dao.BoardDao;
import net.bitacademy.java72.domain.Board;
import net.bitacademy.java72.util.MultipartUtils;

@Controller
@RequestMapping("/board")
public class BoardController {
  @Autowired BoardDao boardDao;
  @Autowired ServletContext servletContext;

  
  @RequestMapping("/delete.do")
  public String delete(int no) {
    boardDao.delete(no);
    return "redirect:list.do";
  }
  
  @RequestMapping("/detail.do")
  public String detail(int no, Model model) {
    model.addAttribute("board", boardDao.get(no));
    return "/board/BoardDetail.jsp";
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
      boardDao.insert(board);
      
      return "redirect:list.do";
  }
  
  @RequestMapping("/list.do")
  public String list(Model model) {
    model.addAttribute("boards", boardDao.list());
    return "/board/BoardList.jsp";
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
    boardDao.update(board);

    return "redirect:list.do";
  }
}





