package net.bitacademy.java72.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import net.bitacademy.java72.dao.BoardDao;
import net.bitacademy.java72.domain.Board;

public class BoardList extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(
      HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {
    ApplicationContext context = 
        (ApplicationContext)this.getServletContext()
           .getAttribute("beanContainer");
    
    BoardDao boardDao = 
        (BoardDao)context.getBean("boardDao");
    
    List<Board> boards = null;
    try {
      boards = boardDao.list();
    } catch (Exception e) {
      RequestDispatcher rd = 
          request.getRequestDispatcher("/error");
      
      //ServletRequest에 전달할 객체를 저장한다.
      request.setAttribute("error", e);
      
      rd.forward(request, response);
      return;
    }
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("  <meta charset='UTF-8'>");
    out.println("  <title>게시물 목록</title>");

    RequestDispatcher rd = 
        request.getRequestDispatcher("/header");
    rd.include(request, response);
    
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
    
    rd = request.getRequestDispatcher("/loginInfo");
    rd.include(request, response);
    
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
    
    rd = request.getRequestDispatcher("/footer");
    rd.include(request, response);
    
    out.println("</body>");
    out.println("</html>");
  }
}



