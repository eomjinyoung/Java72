package net.bitacademy.java72.control;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import net.bitacademy.java72.domain.Member;
import net.bitacademy.java72.service.MemberService;
import net.bitacademy.java72.util.MultipartUtils;

@Controller
@RequestMapping("/member")
public class MemberController {
  @Autowired MemberService memberService;
  @Autowired ServletContext sc;
  
  @RequestMapping("/delete")
  public String delete(int no) {
    memberService.delete(no);
    return "redirect:list.do";
  }
  
  @RequestMapping("/detail")
  public String detail(int no, Model model) {
    model.addAttribute("member", memberService.get(no));
    return "member/MemberDetail";
  }

  @RequestMapping("/insert")
  public String insert(
      Member member,
      @RequestParam MultipartFile file1) throws Exception {

    String filename = MultipartUtils.getFilename(
        file1.getOriginalFilename());
    File newPath = new File(sc.getRealPath("/files") 
                        + "/" + filename);
    file1.transferTo(newPath);
    
    member.setPhoto(filename);
    memberService.insert(member);
    return "redirect:list.do";
  }
  
  @RequestMapping("/list")
  public String list(
      @RequestParam(required=false, defaultValue="1") 
      int pageNo,
      @RequestParam(required=false, defaultValue="3")
      int pageSize,
      Model model) {
    if (pageNo > 1) { // 이전 페이가 있다면
      model.addAttribute("prevPageNo", pageNo - 1);
    }

    int totalCount = memberService.countAll();
    int lastPageNo = totalCount / pageSize;
    if ((totalCount % pageSize)  > 0) {
      lastPageNo++;
    }
    
    if (pageNo < lastPageNo) { // 다음 페이지가 있다면
      model.addAttribute("nextPageNo", pageNo + 1);
    }
    
    model.addAttribute("pageSize", pageSize);
    
    model.addAttribute("members", 
        memberService.list(pageNo, pageSize));
    return "member/MemberList";
  }
  
  @RequestMapping("/update")
  public String update(
      Member member,
      @RequestParam MultipartFile file1) throws Exception {
  
    String filename = MultipartUtils.getFilename(
        file1.getOriginalFilename());
    File newPath = new File(sc.getRealPath("/files") 
                        + "/" + filename);
    file1.transferTo(newPath);
    
    member.setPhoto(filename);
    
    memberService.update(member);
    return "redirect:list.do";
  }
  
  @RequestMapping("/existEmail")
  public String existEmail(String email, Model model) {
     if (memberService.existEmail(email)) {
       model.addAttribute("result", "yes");
     } else {
       model.addAttribute("result", "no");
     }
     return "member/existEmail";
  }
}






