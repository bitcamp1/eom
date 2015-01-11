package com.eom.web.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eom.web.vo.Member;

public class AuthFilter implements Filter {
	FilterConfig config;
	
	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}
	
	@Override
	public void destroy() {}

	@Override
	public void doFilter(
			ServletRequest request, ServletResponse response,
			FilterChain nextFilter) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		String contextPath = req.getContextPath();
		String servletPath = req.getServletPath();
		
		// 로그인 관련 요청은 통과
		if (servletPath.startsWith("/auth") || 
				servletPath.startsWith("/ajax/auth")) {
			nextFilter.doFilter(request, response);
			return;
		}
		
		// 로그인 되어 있는 상태일 때는 통과
		Member member = (Member) req.getSession().getAttribute("member");
		if (member != null && member.getEmail() != null) {
			nextFilter.doFilter(request, response);
			return;
		}
		
		// 로그인 하도록 처리
		if (servletPath.startsWith("/ajax")) { // AJAX 요청인 경우 
			resp.sendRedirect(contextPath + "/ajax/auth/loginStatus.do");
			
		} else { // 일반 요청인 경우
			resp.sendRedirect(contextPath + "/auth/login.do");
		}
	}
}












