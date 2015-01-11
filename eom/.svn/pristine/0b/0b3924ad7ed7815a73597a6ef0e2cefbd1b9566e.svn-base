package com.eom.web.controls.ajax;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.eom.web.service.ProjectService;
import com.eom.web.vo.AjaxResult;
import com.eom.web.vo.Member;
import com.eom.web.vo.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller("projectControllerAjax")
@RequestMapping("/ajax/project")
@SessionAttributes("member")
public class ProjectController {
	@Autowired
	ProjectService projectService;
	
	@RequestMapping(value="/list", produces="application/json")
	public void list(
			@RequestParam(defaultValue="1") int pageNo,
			ModelMap model)
			throws Exception {
		int pageSize = 3;
		
		model.addAttribute("status", AjaxResult.SUCCESS);
		model.addAttribute("list",  
				projectService.getProjectList(pageNo, pageSize));
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("recordCount", projectService.countProject());
	}
	
	@RequestMapping(value="/mylist", produces="application/json")
	public void mylist(
			@ModelAttribute("member") Member member,
			ModelMap model)
			throws Exception {
		
		model.addAttribute("status", AjaxResult.SUCCESS);
		model.addAttribute("list", 
				projectService.getProjectsOfMember(member.getEmail()));
	}
	
	@RequestMapping(value="/detail", produces="application/json")
	public void detail(
			@RequestParam(defaultValue="0") int no, 
			ModelMap model)
			throws Exception {
		
		model.addAttribute("status", AjaxResult.SUCCESS);
		model.addAttribute("project", projectService.getProject(no));
	}
	
	@RequestMapping(value="/add", 
					method=RequestMethod.POST, 
					produces="application/json")
	public void add(
			String emailList,
			Project project,
			@ModelAttribute("member") Member loginUser,
			ModelMap model) throws Exception {
		
		emailList += "," + loginUser.email;
		String[] memberEmailList = emailList.split(",");
		
		ArrayList<Member> memberList = new ArrayList<Member>();
		Member projectMember = null;
		for (String email : memberEmailList) {
			projectMember = new Member();
			projectMember.setEmail(email);
			
			if (loginUser.getEmail().equals(projectMember.getEmail())) {
				projectMember.setLevel(Member.MANAGER);
			} else {
				projectMember.setLevel(Member.MEMBER);
			}
			memberList.add(projectMember);
		}
		
		project.setMembers(memberList);
		
		projectService.addProject(project);
		
		model.addAttribute("status", AjaxResult.SUCCESS);
	}
	
	@RequestMapping(value="/delete", produces="application/json")
	public void delete(
			@RequestParam(defaultValue="0") int no,
			ModelMap model)
			throws Exception {
		
		int count = projectService.removeProject(no);
		if (count < 1) {
			throw new Exception("해당 프로젝트가 없습니다.");
		}
		
		model.addAttribute("status", AjaxResult.SUCCESS);
	}
	
	@RequestMapping(value="/update", 
			method=RequestMethod.POST,
			produces="application/json")
	public void update(
			Project project,
			String emailList,
			@ModelAttribute("member") Member loginUser,
			ModelMap model)
			throws Exception {
		
		emailList += "," + loginUser.email;
		String[] memberEmailList = emailList.split(",");
		
		ArrayList<Member> memberList = new ArrayList<Member>();
		Member projectMember = null;
		for (String email : memberEmailList) {
			projectMember = new Member();
			projectMember.setEmail(email);
			
			if (loginUser.getEmail().equals(projectMember.getEmail())) {
				projectMember.setLevel(Member.MANAGER);
			} else {
				projectMember.setLevel(Member.MEMBER);
			}
			memberList.add(projectMember);
		}
		
		project.setMembers(memberList);
		
		int count = projectService.changeProject(project);
		if (count < 1) {
			throw new Exception("해당 프로젝트가 없습니다.");
		}
		
		model.addAttribute("status", AjaxResult.SUCCESS);
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(
				java.util.Date.class, 
				new CustomDateEditor(df, true));
	}
	
	@ExceptionHandler(Exception.class)
	public void handleError(Exception ex, ModelMap model) {
		model.addAttribute("error", ex.getMessage());
	}
	
}






