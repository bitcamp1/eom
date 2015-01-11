package com.eom.web.controls;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.eom.web.dao.ProjectDao;
import com.eom.web.service.ProjectService;
import com.eom.web.vo.AjaxResult;
import com.eom.web.vo.Member;
import com.eom.web.vo.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/project")
@SessionAttributes({"newProject", "members", "member"})
public class ProjectController {
	@Autowired
	ProjectDao projectDao;
	
	@Autowired
	ProjectService projectService;
	
	@RequestMapping("/list")
	public String list(
			@RequestParam(defaultValue="1") int pageNo, 
			ModelMap model)
			throws Exception {
		int pageSize = 3;
		
		model.addAttribute("list", 
				projectService.getProjectList(pageNo, pageSize));
		model.addAttribute("pageNo", pageNo);
		
		int recordCount = projectDao.size();
		int pageCount = recordCount / pageSize;
		if ((recordCount % pageSize) > 0)
			pageCount++;
		
		model.addAttribute("pageCount", pageCount);
		
		return "project/list";
	}
	
	@RequestMapping(value="/mylist", produces="application/json")
	public AjaxResult mylist(
			@ModelAttribute("member") Member member)
			throws Exception {
		
		return new AjaxResult()
					.setStatus(AjaxResult.SUCCESS)
					.setData(projectService.getProjectsOfMember(member.getEmail()));
	}
	
	@RequestMapping("/detail")
	public String detail(
			@RequestParam(defaultValue="0") int no, 
			ModelMap model)
			throws Exception {
		
		Project project = projectService.getProject(no);
		model.addAttribute("project", project);
		
		return "project/detail";
	}
	
	@RequestMapping(value="/addStep1", method=RequestMethod.GET)
	public String addStep1Form() {
		return "project/FormStep1";
	}
	
	@RequestMapping(value="/addStep1", method=RequestMethod.POST)
	public String addStep1(
			Project project,
			ModelMap model) {
		model.addAttribute("newProject", project);
		return "redirect:addStep2.do";
	}
	
	@RequestMapping(value="/addStep2", method=RequestMethod.GET)
	public String addStep2Form() {
		return "project/FormStep2";
	}
	
	@RequestMapping(value="/addStep2", method=RequestMethod.POST)
	public String addStep2(String members, /*HttpSession session,*/ ModelMap model) {
		model.addAttribute("members", members);
		//session.setAttribute("members", members);
		return "redirect:addStep3.do";
	}
	
	@RequestMapping(value="/addStep3", method=RequestMethod.GET)
	public String addStep3Form() {
		return "project/FormStep3";
	}
	
	@RequestMapping(value="/addStep3", method=RequestMethod.POST)
	public String addStep3(
			/*HttpSession session,*/
			@ModelAttribute("newProject") Project newProject,
			@ModelAttribute("member") Member loginUser,
			@ModelAttribute("members") String members,
			ModelMap model,
			SessionStatus status ) throws Exception {
		
		/*
		Project newProject = (Project)session.getAttribute("newProject");
		String members = (String)session.getAttribute("members");
		Member member = (Member)session.getAttribute("member");
		*/
		
		members += "," + loginUser.email;
		String[] memberEmailList = members.split(",");
		
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
		
		newProject.setMembers(memberList);
		
		projectService.addProject(newProject);
		
		model.addAttribute("newProject", new Project());
		model.addAttribute("members", "");
		
		//status.setComplete();
		
		return "redirect:list.do";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam(defaultValue="0") int no)
			throws Exception {
		projectDao.deleteAllMember(no);
		
		int count = projectDao.delete(no);
		if (count < 1) {
			throw new Exception("해당 프로젝트가 없습니다.");
		}
		
		return "redirect:list.do";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String updateForm(@RequestParam(defaultValue="0") int no,
			ModelMap model) {
		Project project = projectDao.getDetail(no);
		model.addAttribute("project", project);
		
		return "project/updateForm";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updateForm(Project project)
			throws Exception {
		int count = projectDao.update(project);
		if (count < 1) {
			throw new Exception("해당 프로젝트가 없습니다.");
		}
		
		return "redirect:list.do";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(
				java.util.Date.class, 
				new CustomDateEditor(df, true));
	}
}
