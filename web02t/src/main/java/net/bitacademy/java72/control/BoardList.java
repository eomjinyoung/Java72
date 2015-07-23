package net.bitacademy.java72.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import net.bitacademy.java72.context.MyApplicationContext;
import net.bitacademy.java72.dao.BoardDao;
import net.bitacademy.java72.domain.Board;

public class BoardList extends GenericServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(
      ServletRequest request, 
      ServletResponse response) throws ServletException, IOException {
    MyApplicationContext context = 
        MyApplicationContext.getInstance();
    
    BoardDao boardDao = (BoardDao)context.getBean("boardDao");
    
    List<Board> boards = boardDao.list();
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("  <meta charset='UTF-8'>");
    out.println("  <title>게시물 목록</title>");
    out.println("  <style>");
    out.println("    table {");
    out.println("      border-collapse: collapse;");
    out.println("    }");
    out.println("    th, td {");
    out.println("      border: 1px solid black;");
    out.println("      padding: 5px;");
    out.println("    }");
    out.println("  </style>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>게시물 목록</h1>");
    out.println("<p><a href='form.html'>새 글</a></p>");
    out.println("<table>");
    out.println("  <tr>");
    out.println("    <th>번호</th> ");
    out.println("    <th>제목</th> ");
    out.println("    <th>등록일</th>");
    out.println("    <th>조회수</th>");
    out.println("  </tr>");
    for (Board board : boards) {
      out.printf("<tr>"
          + "<td>%d</td>"
          + "<td><a href='detail.do?no=%d'>%s</a></td>"
          + "<td>%s</td>"
          + "<td>%d</td>"
          + "</tr>\n" 
        , board.getNo()
        , board.getNo()
        , board.getTitle()
        , board.getCreateDate()
        , board.getViewCount());
    }
    out.println("</table>");
    out.println("</body>");
    out.println("</html>");
  }
}



