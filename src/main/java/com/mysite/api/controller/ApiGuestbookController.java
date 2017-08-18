package com.mysite.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysite.service.GuestbookService;
import com.mysite.vo.guestbookVo;

@Controller
@RequestMapping(value="api/gb")
public class ApiGuestbookController {

	@Autowired
	private GuestbookService guestbookService;
	
	@ResponseBody
	@RequestMapping(value="list",method=RequestMethod.POST)
	public List<guestbookVo> list() {
		System.out.println("ajax-list");
		List<guestbookVo> list=guestbookService.getlist();
		return list;
	}
	

}
