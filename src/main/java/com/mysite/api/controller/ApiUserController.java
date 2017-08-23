package com.mysite.api.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysite.service.UserService;
import com.mysite.vo.UserVo;

@Controller
@RequestMapping(value="api/user")
public class ApiUserController {
	
	@Autowired
	private UserService userService;
	
	@ResponseBody
	@RequestMapping(value="check",method=RequestMethod.POST)
	public int check(@RequestParam("email") String email) {
		System.out.println("들어옴");
		System.out.println(email);
		UserVo userVo=userService.check(email);
		System.out.println(userVo);
		int result;
		if(userVo==null) {
			result=0;
		} else {
			result=1;
		}
		System.out.println(result);
		return result;
	}
	
}
