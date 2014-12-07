package com.eom.web.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eom.web.dao.MemberDao;
import com.eom.web.dao.ProjectDao;
import com.eom.web.vo.Member;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberDao memberDao;
	
	@Autowired
	ProjectDao projectDao;
	
	@Override
	public int registerMember(Member member) throws Exception {
		return memberDao.addMember(member);
	}

	@Override
	public Collection<Member> getMemberList(int pageNo, int pageSize) throws Exception {
		HashMap<String,Integer> paramMap = new HashMap<String,Integer>();
		paramMap.put("pageStartIndex", (pageNo-1) * pageSize);
		paramMap.put("pageSize", pageSize);
		
		return memberDao.getMemberList(paramMap);
	}

	@Override
	public Member getMember(String email) throws Exception {
		return memberDao.getMember(email);
	}
	
	@Override
	public Map<String,Object> getMemberWithProject(String email) throws Exception {
		HashMap<String,Object> result = new HashMap<String,Object>();
		result.put("member", memberDao.getMember(email));
		result.put("projects", projectDao.getProjects(email));
		
		return result;
	}

	@Override
	public int changeMember(Member member) throws Exception {
		return memberDao.updateMember(member);
	}

	@Transactional(rollbackFor=Exception.class)
	@Override
	public int removeMember(String email) throws Exception {
		projectDao.leaveProject(email);
		return memberDao.deleteMember(email);
	}

	@Override
	public int countMember() throws Exception {
		return memberDao.size();
	}

	@Override
	public Member existsMember(String email, String password) throws Exception {
		HashMap<String,String> paramMap = new HashMap<String,String>();
		paramMap.put("email", email);
		paramMap.put("password", password);
		
		return memberDao.existsMember(paramMap);
	}
}











