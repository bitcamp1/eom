package com.eom.web.controls;

import com.eom.web.service.MemberService;
import com.eom.web.service.ProjectService;
import com.eom.web.vo.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	MemberService memberService;
	
	@Autowired
	ProjectService projectService;
	
	@RequestMapping("/list")
	public String list(
			@RequestParam(defaultValue="1") int pageNo, ModelMap model) throws Exception {
		int pageSize = 3;
		
		model.addAttribute("list", 
				memberService.getMemberList(pageNo, pageSize));
		model.addAttribute("pageNo", pageNo);
		
		int recordCount = memberService.countMember();
		int pageCount = recordCount / pageSize;
		if ((recordCount % pageSize) > 0)
			pageCount++;
		
		model.addAttribute("pageCount", pageCount);
		
		return "member/list";
	}
	
	@RequestMapping("/detail")
	public String detail(String email, ModelMap model)
					throws Exception {
		/*
		Map<String,Object> result = memberService.getMemberWithProject(email);
		model.addAttribute("member", result.get("member"));
		model.addAttribute("projects", result.get("projects"));
		*/
		model.addAttribute("member", memberService.getMember(email));
		model.addAttribute("projects", projectService.getProjectsOfMember(email));
		
		return "member/detail";
	}
	
	@RequestMapping("/newForm")
	public String newForm() {
		return "member/newForm";
	}
	
	@RequestMapping("/add")
	public String add(Member member)
			throws Exception {
		memberService.registerMember(member);
		
		return "redirect:list.do";
	}
	
	@RequestMapping("/updateForm")
	public String updateForm(String email, ModelMap model) throws Exception {
		Member member = memberService.getMember(email);
		model.addAttribute("member", member);
		return "member/updateForm";
	}
	
	@RequestMapping("/update")
	public String update(Member member) throws Exception {
		memberService.changeMember(member);
		return "redirect:list.do";
	}
	
	@RequestMapping("/delete")
	public String delete(String email)
					throws Exception  {	
		memberService.removeMember(email);

		return "redirect:list.do";
	}
	
}
