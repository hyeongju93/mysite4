package com.mysite.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@ResponseBody			//데이터만 받거나 보내는거
	@RequestMapping(value="list",method=RequestMethod.POST)
	public List<guestbookVo> list() {
		System.out.println("ajax-list");
		List<guestbookVo> list=guestbookService.getlist();
		return list;
	}
	
	@ResponseBody		//바디에 데이터로 보낼거라는 뜻
	@RequestMapping(value="add",method=RequestMethod.POST)
	public guestbookVo add(@RequestBody guestbookVo guestbookvo) {	//requestbody는 받을때
		System.out.println("add에 들어옴");
		System.out.println(guestbookvo);
		guestbookvo=guestbookService.writeVo(guestbookvo);
		return guestbookvo;
	}
	

}
