package net.bitacademy.java72.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.java72.context.MyApplicationContext;
import net.bitacademy.java72.dao.MemberDao;
import net.bitacademy.java72.domain.Member;

public class MemberList extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(
      HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {
    MyApplicationContext context = 
        MyApplicationContext.getInstance();

    MemberDao memberDao = 
        (MemberDao)context.getBean("memberDao");
    List<Member> members = null;
    
    try {
      members = memberDao.list();
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
    out.println("  <title>회원 목록</title>");
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
    out.println("<h1>회원 목록</h1>");
    out.println("<p><a href='form.html'>새 회원</a></p>");
    out.println("<table>");
    out.println("  <tr>");
    out.println("    <th>번호</th> ");
    out.println("    <th>이름</th> ");
    out.println("    <th>이메일</th>");
    out.println("    <th>전화</th>");
    out.println("    <th>가입일</th>");
    out.println("  </tr>");
    for (Member member : members) {
      out.printf("<tr>"
          + "<td>%d</td>"
          + "<td><a href='detail.do?no=%d'>%s</a></td>"
          + "<td>%s</td>"
          + "<td>%s</td>"
          + "<td>%s</td>"
          + "</tr>\n" 
        , member.getNo()
        , member.getNo()
        , member.getName()
        , member.getEmail()
        , member.getTel()
        , member.getCreateDate());
    }
    out.println("</table>");
    out.println("</body>");
    out.println("</html>");
  }

}