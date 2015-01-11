package com.eom.web.service;

import java.util.Collection;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eom.web.dao.MemberDao;
import com.eom.web.dao.ProjectDao;
import com.eom.web.vo.Member;
import com.eom.web.vo.Project;

@Service
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	ProjectDao projectDao;
	
	@Autowired
	MemberDao memberDao;
	
	@Transactional(rollbackFor=Exception.class)
	@Override
	public int addProject(Project project) throws Exception {
		projectDao.insert(project);
		
		HashMap<String,String> memberInfo = new HashMap<String,String>();
		for(Member member : project.getMembers()) {
			memberInfo.put("no", Integer.toString(project.getNo()));
			memberInfo.put("email", member.getEmail());
			memberInfo.put("role", Integer.toString(member.getLevel()));
			projectDao.addMember(memberInfo);
		}
		return project.getNo();
	}

	@Override
	public Collection<Project> getProjectList(int pageNo, int pageSize)
			throws Exception {
		System.out.println("getProjectList");
		HashMap<String,Integer> paramMap = new HashMap<String,Integer>();
		paramMap.put("pageStartIndex", (pageNo-1) * pageSize);
		paramMap.put("pageSize", pageSize);
		
		return projectDao.list(paramMap);
	}

	@Override
	public Project getProject(int projectNo) throws Exception {
		Project project = projectDao.getDetail(projectNo);
		
		Collection<Member> members = memberDao.getMembers(projectNo);
		project.setMembers(members);
		
		return project;
	}

	@Transactional(rollbackFor=Exception.class)
	@Override
	public int changeProject(Project project) throws Exception {
		projectDao.deleteAllMember(project.getNo());
		
		HashMap<String,String> memberInfo = new HashMap<String,String>();
		for(Member member : project.getMembers()) {
			memberInfo.put("no", Integer.toString(project.getNo()));
			memberInfo.put("email", member.getEmail());
			memberInfo.put("role", Integer.toString(member.getLevel()));
			projectDao.addMember(memberInfo);
		}
		
		return projectDao.update(project);
	}

	@Transactional(rollbackFor=Exception.class)
	@Override
	public int removeProject(int projectNo) throws Exception {
		projectDao.deleteAllMember(projectNo);
		return projectDao.delete(projectNo);
	}

	@Override
	public int countProject() throws Exception {
		return projectDao.size();
	}

	@Override
	public Collection<Project> getProjectsOfMember(String email)
			throws Exception {
		return projectDao.getProjects(email);
	}

}









