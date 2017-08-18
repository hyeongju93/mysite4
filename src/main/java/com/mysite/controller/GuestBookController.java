package com.mysite.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysite.service.GuestbookService;
import com.mysite.vo.guestbookVo;


@Controller
@RequestMapping("guestbook")
public class GuestBookController {
	
	@Autowired
	private GuestbookService guestbookService;
	
	@RequestMapping(value="/list-ajax",method=RequestMethod.GET)
	public String listAjax() {
		
		return "guestbook/list-ajax";
	}
	
	@RequestMapping(value="/deleteform",method=RequestMethod.GET)
	public String deleteform(@RequestParam("no") int no,Model model) {
		model.addAttribute("no", no);
		System.out.println(no);
		return "guestbook/deleteform";
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public String delete(@RequestParam("no") int no,Model model) {
		model.addAttribute("no", no);
		System.out.println(no);
		guestbookService.delete(no);
		return "redirect:/guestbook/list";
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(HttpSession session) {
		List<guestbookVo> list=guestbookService.getlist();
		session.setAttribute("list", list);
		return "guestbook/list";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(@ModelAttribute guestbookVo guestbookVo) {
		System.out.println(guestbookVo);
		guestbookService.add(guestbookVo);
		return "redirect:/guestbook/list";
	}
	
}
