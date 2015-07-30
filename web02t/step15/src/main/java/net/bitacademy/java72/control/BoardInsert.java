package net.bitacademy.java72.control;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import net.bitacademy.java72.dao.BoardDao;
import net.bitacademy.java72.domain.Board;
import net.bitacademy.java72.util.MultipartDataProcessor;

public class BoardInsert extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doPost(
      HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {
    
    ApplicationContext context = 
        (ApplicationContext)this.getServletContext()
           .getAttribute("beanContainer");
    
    BoardDao boardDao = (BoardDao)context.getBean("boardDao");
      
    try {
      Map<String,String> paramMap = 
          MultipartDataProcessor.toParamMap(
              "/files", request);
    
      Board board = new Board();
      board.setTitle(paramMap.get("title"));
      board.setContent(paramMap.get("content"));
      board.setPassword(paramMap.get("password"));
      board.setAttachFile1(paramMap.get("file1"));
      
      boardDao.insert(board);
    } catch (Exception e) {
      RequestDispatcher rd = 
          request.getRequestDispatcher("/error");
      request.setAttribute("error", e);
      rd.forward(request, response);
      return;
    }
    response.sendRedirect("list.do");
  }

}






