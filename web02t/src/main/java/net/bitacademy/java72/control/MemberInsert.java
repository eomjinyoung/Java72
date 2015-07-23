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

public class MemberInsert extends GenericServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(
      ServletRequest request, 
      ServletResponse response) throws ServletException, IOException {
    MyApplicationContext context = 
        MyApplicationContext.getInstance();

    MemberDao memberDao = 
        (MemberDao)context.getBean("memberDao");
    
    Member member = new Member();
    member.setName(request.getParameter("name"));
    member.setEmail(request.getParameter("email"));
    member.setTel(request.getParameter("tel"));
    member.setPassword(request.getParameter("password"));

    int count = memberDao.insert(member);
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head>");
    out.println("  <meta charset='UTF-8'>");
    out.println("  <meta http-equiv='Refresh'"
        + " content='1;url=list.do'>");
    out.println("  <title>입력 결과</title>");  
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>입력 결과</h1>");
    
    if (count == 0) {
      out.println("<p>입력 실패!</p>");
    } else {
      out.println("<p>입력 성공!</p>");
    }
    
    out.println("</body>");
    out.println("</html>");
  }

}
