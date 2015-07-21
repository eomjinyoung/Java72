package net.bitacademy.java72.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import net.bitacademy.java72.context.MyApplicationContext;
import net.bitacademy.java72.dao.BoardDao;

public class BoardDelete extends GenericServlet {
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
    
    int count = boardDao.delete(no);
    
    if (count == 0) {
      out.println("삭제 실패!");
    } else {
      out.println("삭제 성공!");
    }
  }

  

}
