package com.eom.web.controls.ajax;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import com.eom.web.vo.AjaxResult;
import com.eom.web.vo.Member;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.google.gson.Gson;

@Controller("userInfoAjax")
@RequestMapping("/ajax/user/userInfo")
@SessionAttributes("member")
public class UserInfo {
	
	@RequestMapping(method=RequestMethod.GET, produces="application/json")
	public void execute3(
			@ModelAttribute("member") Member member,
			/*HttpServletResponse response,*/
			ModelMap model) 
			throws Exception {
		
		if (member != null) {
			model.addAttribute("status", AjaxResult.SUCCESS);
			model.addAttribute("member", member);
		} else {
			model.addAttribute("status", AjaxResult.FAIL);
			model.addAttribute("error", "로그인 되지 않았습니다.");
		}
		
		//response.setHeader("Access-Control-Allow-Origin", "*");
	}
	
	//@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<String> execute2(
			@ModelAttribute("member") Member member) 
			throws Exception {
		
		HttpHeaders respHeaders = new HttpHeaders();
		respHeaders.set("Content-Type", "text/plain;charset=UTF-8");
		
		return new ResponseEntity<String>(
					new Gson().toJson(member),
					respHeaders,
					HttpStatus.OK);
	}
	
	//@RequestMapping(method=RequestMethod.GET)
	//@ResponseBody
	public String execute(
			@ModelAttribute("member") Member member) 
			throws Exception {
		
		/* 3) 응답 내용 리턴
		 * - 한글을 보낼 때는 URL 인코딩으로 변환하여 보낸다.
		 * - 자바스크립트 쪽에서 decodeURIComponent()를 사용하여 
		 * - 원래 값으로 디코딩 해야 한다.
		 */
		return URLEncoder.encode(
				new Gson().toJson(member), "UTF-8");
		
		/* 2) 응답 내용 리턴
		 * - @ResponseBody 설정해야 한다.
		 * - 한글 깨진다.
		 */
		//return new Gson().toJson(member);
		
		/* 1) 뷰의 이름 리턴 */
		//return "auth/userInfo";
	}
/*	
	@ExceptionHandler(Exception.class)
	public AjaxResult handleException(Exception ex) {
		return new AjaxResult()
					.setStatus(AjaxResult.FAIL)
					.setData(ex.getMessage());
	}
*/
}









