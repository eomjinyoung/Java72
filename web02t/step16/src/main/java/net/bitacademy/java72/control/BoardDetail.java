package net.bitacademy.java72.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import net.bitacademy.java72.dao.BoardDao;
import net.bitacademy.java72.domain.Board;

public class BoardDetail extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(
      HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {
    ApplicationContext context = 
        (ApplicationContext)this.getServletContext()
           .getAttribute("beanContainer");
    
    BoardDao boardDao = (BoardDao)context.getBean("boardDao");
    
    try {
      int no = Integer.parseInt(request.getParameter("no"));
      Board board = boardDao.get(no);
      request.setAttribute("board", board);
      
      RequestDispatcher rd = 
          request.getRequestDispatcher(
              "/board/BoardDetail.jsp");
      response.setContentType("text/html;charset=UTF-8");
      rd.include(request, response);
    } catch (Exception e) {
      RequestDispatcher rd = 
          request.getRequestDispatcher("/error");
      request.setAttribute("error", e);
      rd.forward(request, response);
      return;
    }
  }

}








