package com.eom.web.dao;

import java.util.Collection;
import java.util.HashMap;

import com.eom.web.vo.Member;

public interface MemberDao {
	int addMember(Member member);
	Member getMember(String email);
	int updateMember(Member member);
	int deleteMember(String email);
	Collection<Member> getMemberList(HashMap<String,Integer> paramMap);
	Member existsMember(HashMap<String,String> paramMap);
	int size();
	Collection<Member> getMembers(int projectNo);
}





