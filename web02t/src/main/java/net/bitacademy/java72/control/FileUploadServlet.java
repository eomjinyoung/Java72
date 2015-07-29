package net.bitacademy.java72.control;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/upload/fileUpload.do")
public class FileUploadServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  class FileInfo {
    String originName;
    String realFilePath;
    
    public FileInfo(
        String originName, String readFilePath) {
      this.originName = originName;
      this.realFilePath = readFilePath;
    }
  }
  
  @Override
  protected void doPost(
      HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {
    
    /* 멀티파트 형식으로 전송된 데이터를 
     * 다음과 같이 getParameter()로 꺼낼 수 없다.
     */
    /*
    String name = request.getParameter("name");
    String photo = request.getParameter("photo");
    */
    
    //1) 각 파트를 자바 객체로 만들어줄 공장을 준비한다.
    DiskFileItemFactory itemFactory = 
        new DiskFileItemFactory();
    
    //2) 요청 프로토콜을 분석할 객체를 준비한다.
    //   => 분석된 데이터를 ItemFactory에 넘긴다.
    //   => ItemFactory는 각 파트 데이터를 객체로 만든다.
    ServletFileUpload upload = 
        new ServletFileUpload(itemFactory);
    
    //3) 멀티파트 데이터를 분석하라!
    // => 리턴 값은 ItemFactory가 만들어준 객체 목록이다.
    HashMap<String,Object> paramMap = 
        new HashMap<String,Object>();
    
    try {
      List<FileItem> items = upload.parseRequest(request);
    
      //4) FileItem을 분석하여 name 값과 photo 값을 꺼낸다.
      for (FileItem item : items) {
        if (item.isFormField()) {
          paramMap.put(
              item.getFieldName(), 
              item.getString("UTF-8")); // request.setCharacterEncoding() 효력 없음.
        } else {
          ServletContext context = request.getServletContext();
          String realPath = context.getRealPath("/files");
          File filePath = new File(
              realPath + "/" + item.getName());
          item.write(filePath);
          
          paramMap.put(
              item.getFieldName(), 
              new FileInfo(
                  item.getName(), 
                  filePath.getAbsolutePath()));
        }
      }
    } catch (Exception e1) {
      e1.printStackTrace();
    }
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html><body>");
    out.printf("<p>이름=%s</p>\n", paramMap.get("name"));
    
    FileInfo fileInfo = (FileInfo)paramMap.get("photo");
    out.printf("<p>사진=%s</p>\n", fileInfo.realFilePath);
    out.printf("<img src='../files/%s'>\n", 
                                    fileInfo.originName);
    out.println("</body></html>");
  }

}






