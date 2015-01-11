package com.eom.web.controls;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.eom.web.dao.MemberDao;
import com.eom.web.vo.Member;

@Controller
@SessionAttributes("member") // ModelMap에 저장된 객체 중에서 "member"는 세션에 저장하라.
public class LoginControl {
	@Autowired
	MemberDao memberDao;
	
	@RequestMapping(value="/auth/login", method=RequestMethod.GET)
	public String loginForm(
			@CookieValue(defaultValue="") String email, ModelMap model)
			throws ServletException, IOException {
		System.out.println("loginForm()...");
		
		if(email != null) {
			model.addAttribute("email", email);
			model.addAttribute("checked", "checked");
		}
		return "auth/loginForm";
	}
	
	@RequestMapping(value="/auth/login", method=RequestMethod.POST)
	public String login(
			/*@RequestParam("email")*/String email, 
			/*@RequestParam("password")*/String password, 
			/*@RequestParam("saveEmail")*/String saveEmail,
			HttpSession session,
			HttpServletResponse response,
			ModelMap model)
			throws ServletException, IOException {
		HashMap<String,String> paramMap = new HashMap<String,String>();
		paramMap.put("email", email);
		paramMap.put("password", password);
		
		Member member = memberDao.existsMember(paramMap);
		if (member != null) {
			model.addAttribute("member", member);
			
			Cookie cookie = null;
			if(saveEmail != null) {
				cookie = new Cookie("email", email);
				cookie.setMaxAge(60 * 60 * 24 * 30); 
				response.addCookie(cookie);
			} 
				
		} else {
			model.addAttribute("member", new Member());
			Cookie cookie = new Cookie("email", "guest");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
			session.invalidate();
		}
		
		return "auth/loginResult";
	}
}






