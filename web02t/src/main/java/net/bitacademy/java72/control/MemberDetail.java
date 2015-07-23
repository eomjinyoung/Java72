package net.bitacademy.java72.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import net.bitacademy.java72.context.MyApplicationContext;
import net.bitacademy.java72.dao.MemberDao;
import net.bitacademy.java72.domain.Member;

public class MemberDetail extends GenericServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(
      ServletRequest request, 
      ServletResponse response) throws ServletException, IOException {
    MyApplicationContext context = 
        MyApplicationContext.getInstance();

    MemberDao memberDao = 
        (MemberDao)context.getBean("memberDao");
    
    int no = Integer.parseInt(request.getParameter("no"));
    Member member = memberDao.get(no);

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("  <meta charset='UTF-8'>");
    out.println("  <title>회원 상세보기</title>");
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
    out.println("<h1>회원 상세보기</h1>");
    out.println("<form action='update.do' method='get'>");
    out.println("<table>");
    if (member != null) {
      out.printf("<tr><th>번호</th>"
          + "<td>"
          + "<input type='text' readonly"
          + " name='no' value='%d'>"
          + "</td></tr>\n" 
          , member.getNo());
      out.printf("<tr><th>이름</th>"
          + "<td>"
          + "<input type='text' name='name' value='%s'>"
          + "</td></tr>\n"
          , member.getName());
      out.printf("<tr><th>이메일</th>"
          + "<td>"
          + "<input type='text' name='email' value='%s'>"
          + "</td></tr>\n"
          , member.getEmail());
      out.printf("<tr><th>전화</th>"
          + "<td>"
          + "<input type='text' name='tel' value='%s'>"
          + "</td></tr>\n"
          , member.getTel());
      out.printf("<tr><th>가입일</th><td>%s</td></tr>\n"
          , member.getCreateDate());
      out.printf("<tr><th>암호</th>"
          + "<td>"
          + "<input type='text' name='password'>"
          + "</td></tr>\n" 
          , member.getPassword());
    } else {
      out.println("<tr><td>"
          + "해당 번호의 회원을 찾을 수 없습니다."
          + "</td></tr>");
    }
    out.println("<tr>");
    out.println("  <th></th>");
    out.printf("  <td>"
        + "<input type='submit' value='변경'>"
        + "<a href='delete.do?no=%d'>삭제</a>"
        + "</td>"
        , member.getNo());
    out.println("</tr>");
    out.println("</table>");
    out.println("</form>");
    out.println("<p><a href='list.do'>목록</a><p>");
    out.println("</body>");
    out.println("</html>");
  }

}
