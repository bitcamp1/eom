package com.eom.web.dao;

import java.util.Collection;
import java.util.HashMap;

import com.eom.web.vo.Project;

public interface ProjectDao {
	int insert(Project project);
	Project getDetail(int no);
	int update(Project project);
	int delete(int no);
	Collection<Project> list(HashMap<String,Integer> paramMap);
	int addMember(HashMap<String,String> paramMap);
	int deleteAllMember(int projectNo);
	int leaveProject(String email);
	int size();
	Collection<Project> getProjects(String email);
}





