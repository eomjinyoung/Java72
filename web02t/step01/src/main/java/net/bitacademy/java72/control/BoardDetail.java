package net.bitacademy.java72.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import net.bitacademy.java72.context.MyApplicationContext;
import net.bitacademy.java72.dao.BoardDao;
import net.bitacademy.java72.domain.Board;

public class BoardDetail extends GenericServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(
      ServletRequest request, 
      ServletResponse response) throws ServletException, IOException {
    MyApplicationContext context = 
        MyApplicationContext.getInstance();
    
    BoardDao boardDao = (BoardDao)context.getBean("boardDao");
      
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    int no = Integer.parseInt(request.getParameter("no"));
    
    Board board = boardDao.get(no);
    
    if (board != null) {
      out.printf("번호: %s\n", board.getNo());
      out.printf("제목: %s\n", board.getTitle());
      out.printf("내용: %s\n", board.getContent());
      out.printf("조회수: %s\n", board.getViewCount());
      out.printf("등록일: %s\n", board.getCreateDate());
    } else {
      out.println("해당 번호의 게시물을 찾을 수 없습니다.");
    }
  }

}








