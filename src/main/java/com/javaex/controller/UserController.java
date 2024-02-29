package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping(value = "user")
public class UserController {
	
	@Autowired
	private UserService us;
	
	//회원가입폼
	@RequestMapping(value = "/joinform", method = {RequestMethod.GET, RequestMethod.POST})
	public String joinForm() {
		
		return "user/joinForm";
	}
	
	//회원가입
	@RequestMapping(value = "/joinok", method = {RequestMethod.GET, RequestMethod.POST})
	public String joinOk(@ModelAttribute UserVo uv) {
		
		System.out.println(uv.toString());
		
		us.exeJoin(uv);
		
		return "user/joinOk";
	}
	
	//로그인폼
	@RequestMapping(value = "/loginform", method = {RequestMethod.GET,RequestMethod.POST})
	public String loginForm() {
		System.out.println("loginform");
		
		return "user/loginForm";
	}
	
	//로그인
	@RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
	public String login(@ModelAttribute UserVo uv, HttpSession session) {
		
		UserVo userVo = us.exeLogin(uv);
		System.out.println(userVo);
		
		session.setAttribute("userVo", userVo);
		
		return   "redirect:/main";
	}
	
	//수정폼
	@RequestMapping(value = "/modifyform", method = {RequestMethod.GET, RequestMethod.POST})
	public String modifyForm() {
		
		return "user/modifyForm";
	}
	
	//수정
	@RequestMapping(value = "/modify", method = {RequestMethod.GET, RequestMethod.POST})
	public String modify(@ModelAttribute UserVo uv) {
		System.out.println(uv.toString());
		
		us.exeModify(uv);
		
		return "redirect:/main";
	}
}
