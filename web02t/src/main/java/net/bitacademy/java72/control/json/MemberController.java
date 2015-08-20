package net.bitacademy.java72.control.json;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import net.bitacademy.java72.domain.Member;
import net.bitacademy.java72.service.MemberService;
import net.bitacademy.java72.util.ResponseFactory;

@Controller("json.MemberController")
@RequestMapping("/json/member")
public class MemberController {
  @Autowired MemberService memberService;
  @Autowired ServletContext sc;
  
  @RequestMapping("/delete")
  public ResponseEntity<String> delete(int no) {
    int count = memberService.delete(no);
    
    Map<String,Object> result = 
        new HashMap<String,Object>();
    if (count > 0) {
      result.put("data", "success");
    } else {
      result.put("data", "failure");
    }
    
    return ResponseFactory.createResponse(result);
  }
  
  @RequestMapping("/detail")
  public ResponseEntity<String> detail(int no) {
    Map<String,Object> result = 
        new HashMap<String,Object>();
    result.put("data", memberService.get(no));
    
    return ResponseFactory.createResponse(result);
  }

  @RequestMapping("/insert")
  public ResponseEntity<String> insert(
      Member member,
      @RequestParam(required=false) MultipartFile file1) throws Exception {
    
    /*
    String filename = MultipartUtils.getFilename(
        file1.getOriginalFilename());
    File newPath = new File(sc.getRealPath("/files") 
                        + "/" + filename);
    file1.transferTo(newPath);
    
    member.setPhoto(filename);
    */
    
    int count = memberService.insert(member);
    
    Map<String,Object> result = 
        new HashMap<String,Object>();
    if (count > 0) {
      result.put("data", "success");
    } else {
      result.put("data", "failure");
    }
    
    return ResponseFactory.createResponse(result);
  }
  
  @RequestMapping("/list")
  public ResponseEntity<String> list(
      @RequestParam(required=false, defaultValue="1") 
      int pageNo,
      @RequestParam(required=false, defaultValue="3")
      int pageSize) {
    
    Map<String,Object> result = 
        new HashMap<String,Object>();
    
    result.put("pageNo", pageNo);

    int totalCount = memberService.countAll();
    int lastPageNo = totalCount / pageSize;
    if ((totalCount % pageSize)  > 0) {
      lastPageNo++;
    }
    
    if (pageNo < lastPageNo) { // 다음 페이지가 있다면
      result.put("isNextPage", true);
    } else {
      result.put("isNextPage", false);
    }
    
    result.put("pageSize", pageSize);
    result.put("data", 
        memberService.list(pageNo, pageSize));
    
    return ResponseFactory.createResponse(result);
  }
  
  @RequestMapping("/update")
  public ResponseEntity<String> update(
      Member member,
      @RequestParam(required=false) MultipartFile file1) throws Exception {
    /*
    String filename = MultipartUtils.getFilename(
        file1.getOriginalFilename());
    File newPath = new File(sc.getRealPath("/files") 
                        + "/" + filename);
    file1.transferTo(newPath);
    
    member.setPhoto(filename);
    */
    
    int count = memberService.update(member);
    
    Map<String,Object> result = 
        new HashMap<String,Object>();
    if (count > 0) {
      result.put("data", "success");
    } else {
      result.put("data", "failure");
    }
    return ResponseFactory.createResponse(result);
  }
  
  @RequestMapping("/existEmail")
  public ResponseEntity<String> existEmail(String email) {
    Map<String,Object> result = 
        new HashMap<String,Object>();
    if (memberService.existEmail(email)) {
      result.put("data", "yes");
    } else {
      result.put("data", "no");
    }
    return ResponseFactory.createResponse(result);
  }
}






