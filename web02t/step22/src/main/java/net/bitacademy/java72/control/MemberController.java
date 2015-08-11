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
  
  @RequestMapping("/delete.do")
  public String delete(int no) {
    memberService.delete(no);
    return "redirect:list.do";
  }
  
  @RequestMapping("/detail.do")
  public String detail(int no, Model model) {
    model.addAttribute("member", memberService.get(no));
    return "member/MemberDetail";
  }

  @RequestMapping("/insert.do")
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
  
  @RequestMapping("/list.do")
  public String list(Model model) {
    model.addAttribute("members", memberService.list());
    return "member/MemberList";
  }
  
  @RequestMapping("/update.do")
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
}






