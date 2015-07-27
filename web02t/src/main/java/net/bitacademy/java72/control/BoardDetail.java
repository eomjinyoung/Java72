package net.bitacademy.java72.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.java72.context.MyApplicationContext;
import net.bitacademy.java72.dao.BoardDao;
import net.bitacademy.java72.domain.Board;

public class BoardDetail extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(
      HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {
    MyApplicationContext context = 
        MyApplicationContext.getInstance();
    
    BoardDao boardDao = (BoardDao)context.getBean("boardDao");
      
    int no = Integer.parseInt(request.getParameter("no"));
    Board board = null;
    try {
      board = boardDao.get(no);
    } catch (Exception e) {
      response.setContentType("text/html;charset=UTF-8");
      PrintWriter out = response.getWriter();
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("  <meta charset='UTF-8'>");
      out.println("  <title>페이지 오류 발생!</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>페이지 오류 발생!</h1>");
      out.println("<p>잠시 후에 다시 시도해 주세요.<br>");
      out.println("계속 오류가 보인다면 관리자(내선: 200)");
      out.println("에게 문의해 주세요.</p>");
      out.println("</body>");
      out.println("</html>");
      return;
    }
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("  <meta charset='UTF-8'>");
    out.println("  <title>게시물 상세보기</title>");
    out.println("  <style>");
    out.println("    table {");
    out.println("      border-collapse: separate;");
    out.println("    }");
    out.println("    th {");
    out.println("      background-color: lightgray;");
    out.println("      padding: 5px;");
    out.println("    }");
    out.println("  </style>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>게시물 상세보기</h1>");
    out.println("<form action='update.do' method='post'>");
    out.println("<table>");
    if (board != null) {
      out.printf("<tr><th>번호</th>"
          + "<td>"
          + "<input type='text' readonly"
          + " name='no' value='%d'>"
          + "</td></tr>\n" 
          , board.getNo());
      out.printf("<tr><th>제목</th>"
          + "<td>"
          + "<input type='text' name='title' value='%s'>"
          + "</td></tr>\n"
          , board.getTitle());
      out.printf("<tr><th>내용</th>"
          + "<td><textarea name='content'"
          + " rows='5' cols='50'>%s</textarea>"
          + "</td></tr>\n"
          , board.getContent());
      out.printf("<tr><th>암호</th>"
          + "<td>"
          + "<input type='password' name='password'>"
          + "</td></tr>\n");
      out.printf("<tr><th>조회수</th><td>%d</td></tr>\n"
          , board.getViewCount());
      out.printf("<tr><th>등록일</th><td>%s</td></tr>\n"
          , board.getCreateDate());
    } else {
      out.println("<tr><td>"
          + "해당 번호의 게시물을 찾을 수 없습니다."
          + "</td></tr>");
    }
    out.println("<tr>");
    out.println("  <th></th>");
    out.printf("  <td>"
        + "<input type='submit' value='변경'>"
        + "<a href='delete.do?no=%d'>삭제</a>"
        + "</td>"
        , board.getNo());
    out.println("</tr>");
    out.println("</table>");
    out.println("</form>");
    out.println("<p><a href='list.do'>목록</a><p>");
    out.println("</body>");
    out.println("</html>");
  }

}








