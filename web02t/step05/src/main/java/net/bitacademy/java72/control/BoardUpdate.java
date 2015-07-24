package net.bitacademy.java72.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.java72.context.MyApplicationContext;
import net.bitacademy.java72.dao.BoardDao;
import net.bitacademy.java72.domain.Board;

public class BoardUpdate extends GenericServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(
      ServletRequest request, 
      ServletResponse response) throws ServletException, IOException {
    
    request.setCharacterEncoding("UTF-8");
    
    MyApplicationContext context = 
        MyApplicationContext.getInstance();
    
    BoardDao boardDao = (BoardDao)context.getBean("boardDao");
      
    Board board = new Board();
    board.setNo(Integer.parseInt(request.getParameter("no")));
    board.setTitle(request.getParameter("title"));
    board.setContent(request.getParameter("content"));
    board.setPassword(request.getParameter("password"));
    
    // 입력 받은 내용으로 게시물을 변경한다.
    int count = boardDao.update(board);
    
    /*HttpServletResponse response2 = 
        (HttpServletResponse) response;
    response2.setHeader("Refresh", "1;url=list.do");*/
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head>");
    out.println("  <meta charset='UTF-8'>");
    /*out.println("  <meta http-equiv='Refresh'"
        + " content='1;url=list.do'>");*/
    out.println("  <title>변경 결과</title>");  
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>변경 결과</h1>");
    
    if (count == 0) {
      out.println("<p>변경 실패!</p>");
    } else {
      out.println("<p>변경 성공!</p>");
    }
    
    out.println("</body>");
    out.println("</html>");

    HttpServletResponse response2 = 
        (HttpServletResponse) response;
    response2.sendRedirect("list.do");
  }

}
