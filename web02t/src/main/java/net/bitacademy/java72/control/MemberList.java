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

import net.bitacademy.java72.dao.MemberDao;
import net.bitacademy.java72.domain.Member;

public class MemberList extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(
      HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {
    ApplicationContext context = 
        (ApplicationContext)this.getServletContext()
           .getAttribute("beanContainer");
    
    MemberDao memberDao = 
        (MemberDao)context.getBean("memberDao");
    List<Member> members = null;
    
    try {
      members = memberDao.list();
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
    out.println("  <title>회원 목록</title>");

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

    rd = request.getRequestDispatcher("/footer");
    rd.include(request, response);
    
    out.println("</body>");
    out.println("</html>");
  }

}