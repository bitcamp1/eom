package com.eom.web.controls.ajax;

import com.eom.web.service.MemberService;
import com.eom.web.service.ProjectService;
import com.eom.web.vo.AjaxResult;
import com.eom.web.vo.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("memberControllerAjax")
@RequestMapping("/ajax/member")
public class MemberController {
	@Autowired
	MemberService memberService;
	
	@Autowired
	ProjectService projectService;
	
	@RequestMapping(value="/list", produces="application/json")
	public void list(
			@RequestParam(defaultValue="1") int pageNo, 
			ModelMap model) throws Exception {
		int pageSize = 3;
		
		model.addAttribute("status", AjaxResult.SUCCESS);
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("recordCount", memberService.countMember());
		model.addAttribute("list", 
				memberService.getMemberList(pageNo, pageSize));
	}
	
	@RequestMapping(value="/detail", produces="application/json")
	public void detail(
			String email, 
			ModelMap model) throws Exception {
		
		model.addAttribute("status", AjaxResult.SUCCESS);
		model.addAttribute("member", memberService.getMember(email));
		model.addAttribute("projects", projectService.getProjectsOfMember(email));
	}
	
	@RequestMapping(value="/add", produces="application/json")
	public void add(
			Member member,
			ModelMap model) throws Exception {
		
		int count = memberService.registerMember(member);
		if (count < 1) {
			throw new Exception("등록 실패입니다.");
		}
		
		model.addAttribute("status", AjaxResult.SUCCESS);
	}
	
	@RequestMapping(value="/update", produces="application/json")
	public void update(
			Member member,
			ModelMap model) throws Exception {
		int count = memberService.changeMember(member);
		if (count < 1) {
			throw new Exception("해당 멤버가 없습니다.");
		}
		
		model.addAttribute("status", AjaxResult.SUCCESS);
	}
	
	@RequestMapping(value="/delete", produces="application/json")
	public void delete(
			String email,
			ModelMap model) throws Exception  {	
		
		int count = memberService.removeMember(email);
		if (count < 1) {
			throw new Exception("해당 멤버가 없습니다.");
		}
		
		model.addAttribute("status", AjaxResult.SUCCESS);
	}
	
}
