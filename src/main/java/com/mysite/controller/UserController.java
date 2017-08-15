package com.mysite.controller;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysite.service.UserService;
import com.mysite.vo.UserVo;

@Controller
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/joinform",method=RequestMethod.GET)
	public String joinform() {
		return "user/joinform";
	}
	
	@RequestMapping(value="/join",method=RequestMethod.POST)
	public String join(@ModelAttribute UserVo userVo) {
		userService.join(userVo);
		return "user/joinsuccess";
	}
	
	@RequestMapping(value="/loginform",method=RequestMethod.GET)
	public String loginform() {
		return "user/loginform";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@RequestParam("email") String email, 
						@RequestParam("passwords") String passwords,
						HttpSession session) {
		
		UserVo authUser=userService.getUser(email,passwords);
		
		if(authUser != null) {
			session.setAttribute("authUser", authUser);
			return "redirect:/main";
		} else {
		System.out.println(authUser);
		return "redirect:/user/loginform?result=fail";
		}
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpSession session) {
		userService.logout(session);
		return "redirect:/main";
	}
	
	@RequestMapping(value="/modifyform",method=RequestMethod.GET)
	public String modifyform(HttpSession session,Model model) {
		UserVo authUser=(UserVo)session.getAttribute("authUser");
		int no=authUser.getNo();
		
		UserVo userVo=userService.getUser(no);
		model.addAttribute("userVo", userVo);
		return "user/modifyform";
	}
	
	@RequestMapping(value="/modify",method=RequestMethod.POST)
	public String modify(@ModelAttribute UserVo userVo,HttpSession session) {
		UserVo authUser=(UserVo)session.getAttribute("authUser");
		int no=authUser.getNo();
		userVo.setNo(no);
		
		System.out.println(userVo);
		userService.updateUser(userVo);
		
		authUser.setNames(userVo.getNames());
		return "redirect:/main";
	}
	
}
