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

public class BoardDelete extends GenericServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(
      ServletRequest request, 
      ServletResponse response) throws ServletException, IOException {
    MyApplicationContext context = 
        MyApplicationContext.getInstance();
    
    BoardDao boardDao = (BoardDao)context.getBean("boardDao");
      
    int no = Integer.parseInt(request.getParameter("no"));
    int count = boardDao.delete(no);
    
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
    out.println("  <title>삭제 결과</title>");  
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>삭제 결과</h1>");
    
    if (count == 0) {
      out.println("<p>삭제 실패!</p>");
    } else {
      out.println("<p>삭제 성공!</p>");
    }
    
    out.println("</body>");
    out.println("</html>");
    
    HttpServletResponse response2 = 
        (HttpServletResponse) response;
    response2.sendRedirect("list.do");
  }

  

}
