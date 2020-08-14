package com.devfox.crawling.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.devfox.crawling.logic.Members;
import com.devfox.crawling.service.UserService;

@Controller
@RequestMapping("jquery/*")
public class JqueryController {

	@Autowired
	UserService userService;

	
	@RequestMapping("jquery/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("loginUser");
		return "/user/login";
	}
	
	@RequestMapping(value="jquery/login",method = RequestMethod.POST)
	@ResponseBody
	public int login(Members members,HttpSession session) {
		int result = 0; 
		String col = null;
		col = "userId";
		Members userIdCheck = userService.getUserOne(members.getUserId(),col);
		if(userIdCheck == null) {
			result = 2;
		}else {
		
		if(members.getUserId().equals(userIdCheck.getUserId())) {
			//ID OK
			if(members.getPassword().equals(userIdCheck.getPassword())) {
				//PW OK 
				session.setAttribute("loginUser", userIdCheck);

				result = 3;
			}else {
				result = 2;
			}
			
		}else {
			//ID not OK
			result = 2;
		}
		}
		
		return result;
	}
	
	@RequestMapping(value="jquery/signUp",method = RequestMethod.POST)
	@ResponseBody
	public int signUp(Members members) {
		int result = 0; 
		String col = null;
		
		col = "userId";
		Members userIdCheck = userService.getUserOne(members.getUserId(),col);
		if(userIdCheck != null) {
		result = 2; 
		}
		
		col = "nickname";
		Members userNicknameCheck = userService.getUserOne(members.getNickname(),col);
		if(userNicknameCheck != null) { result = 3; }	
		
		if(result < 2) {
		result = userService.userJoin(members);	
		}
		
		
		return result;
	}
	
}