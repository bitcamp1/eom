package com.eom.web.controls.ajax;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.eom.web.service.MemberService;
import com.eom.web.vo.AjaxResult;
import com.eom.web.vo.Member;

@Controller("loginControlAjax")
@RequestMapping("/ajax/auth")
@SessionAttributes("member") // ModelMap에 저장된 객체 중에서 "member"는 세션에 저장하라.
public class LoginControl {
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value="/loginFail", produces="application/json")
	public void loginStatus(ModelMap model)
		throws Exception {
		
		model.addAttribute("status", AjaxResult.FAIL);
	}
	
	@RequestMapping(value="/login", 
			method=RequestMethod.POST,
			produces="application/json")
	public void login(
			String email, String password, String saveEmail,
			HttpSession session,
			ModelMap model)
			throws Exception {
		
		
		Member member = memberService.existsMember(email, password);
		if (member != null) {
			model.addAttribute("status", AjaxResult.SUCCESS);
			model.addAttribute("member", member);
			/*
			Cookie cookie = null;
			if(saveEmail != null) {
				cookie = new Cookie("email", email);
				cookie.setMaxAge(60 * 60 * 24 * 30); 
				response.addCookie(cookie);
			} 
			*/
		} else {
			model.addAttribute("status", AjaxResult.FAIL);
			model.addAttribute("member", new Member());
			session.invalidate();
			/*
			Cookie cookie = new Cookie("email", "guest");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
			*/
		}
	}
	
	@ExceptionHandler(Exception.class)
	public void handleError(Exception ex, ModelMap model) {
		model.addAttribute("error", ex.getMessage());
	}
}






