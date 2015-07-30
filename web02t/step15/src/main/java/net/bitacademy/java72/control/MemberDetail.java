package net.bitacademy.java72.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import net.bitacademy.java72.dao.MemberDao;
import net.bitacademy.java72.domain.Member;

public class MemberDetail extends HttpServlet {
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
    
    int no = Integer.parseInt(request.getParameter("no"));
    Member member = null;
    try {
      member = memberDao.get(no);
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
    out.println("  <title>회원 상세보기</title>");

    RequestDispatcher rd = 
        request.getRequestDispatcher("/header");
    rd.include(request, response);
    
    out.println("  <style>");
    out.println("    .photo {");
    out.println("      height: 150px;");
    out.println("    }");
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
    
    rd = request.getRequestDispatcher("/loginInfo");
    rd.include(request, response);
    
    out.println("<h1>회원 상세보기</h1>");
    out.println("<form action='update.do' "
        + " method='post' enctype='multipart/form-data'>");
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
          + "<input type='password' name='password'>"
          + "</td></tr>\n" 
          , member.getPassword());
      out.printf("<tr><th>사진</th>"
          + "<td>"
          + "<img class='photo' src='../files/%s'>"
          + "<input type='file' name='photo'>"
          + "</td></tr>\n" 
          , member.getPhoto());
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

    rd = request.getRequestDispatcher("/footer");
    rd.include(request, response);
    
    out.println("</body>");
    out.println("</html>");
  }

}
