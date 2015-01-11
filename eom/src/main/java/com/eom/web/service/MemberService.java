package com.eom.web.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.eom.web.vo.Member;

/* 
 * 목표: Service 역할
 * - 비즈니스 로직 담당
 * - 트랜잭션 처리 담당
 * - 인터페이스를 통해 Service 컴포넌트를 사용 -> 유지보수 유연성 확보
 * - 비즈니스 로직을 담당하므로 메서드 명은 비즈니스 용어에 가깝게 정의해야 한다.
 */
public interface MemberService {
	int registerMember(Member member) throws Exception;
	Collection<Member> getMemberList(int pageNo, int pageSize) throws Exception;
	Member getMember(String email) throws Exception;
	Map<String,Object> getMemberWithProject(String email) throws Exception;
	int changeMember(Member member) throws Exception;
	int removeMember(String email) throws Exception;
	int countMember() throws Exception;
	Member existsMember(String email, String password) throws Exception;
}













