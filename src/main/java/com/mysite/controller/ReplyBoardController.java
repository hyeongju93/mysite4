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

import com.mysite.service.ReplyBoardService;
import com.mysite.vo.ReplyBoardVo;
import com.mysite.vo.UserVo;






@Controller
@RequestMapping("replyboard")
public class ReplyBoardController {
	
	@Autowired
	private ReplyBoardService replyboardservice;

	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(Model model) {
		List<ReplyBoardVo> list=replyboardservice.getlist();
		System.out.println(list);
		model.addAttribute("list", list);
		return "replyboard/list";
	}
	
	@RequestMapping(value="/replyform",method=RequestMethod.GET)
	public String replyform(@ModelAttribute ReplyBoardVo reply,Model model,HttpSession session) {
		System.out.println(reply);
		ReplyBoardVo vo=replyboardservice.inforeply(reply);
		System.out.println(vo); 
		UserVo uservo=(UserVo)session.getAttribute("authUser");
		vo.setUser_num(uservo.getNo());
		model.addAttribute("vo",vo);
		return "replyboard/replyform";
	}
	
	@RequestMapping(value="/reply",method=RequestMethod.POST)
	public String reply(@ModelAttribute ReplyBoardVo replyboardvo) {
		System.out.println("reply도착");
		System.out.println(replyboardvo);
		if(replyboardvo.getOrderno()==1) {
		//	replyboardservice.replyupdate(replyboardvo);
			replyboardservice.reply(replyboardvo);
		} else {
			replyboardservice.replyupdate2(replyboardvo);
			replyboardservice.reply2(replyboardvo);
			
		}
		
		
		return "redirect:/replyboard/list";
	}
	
	@RequestMapping(value="/modifyform",method=RequestMethod.GET)
	public String modifyform() {
		System.out.println();
		/*여기서 content를 받아서 <br>을 replace 처리해서 \r\n으로 바꿔준다.*/
		return "replyboard/modifyform";
	}
	
	@RequestMapping(value="/modify",method=RequestMethod.POST)
	public String modify(@ModelAttribute ReplyBoardVo replyboardvo) {
		System.out.println(replyboardvo);
		replyboardservice.update(replyboardvo);
		System.out.println(replyboardvo.getNumb());
		String url="redirect:/replyboard/read?numb="+replyboardvo.getNumb();
		return url;
	}
	
	@RequestMapping(value="/writeform",method=RequestMethod.GET)
	public String writeform() {
	
		return "replyboard/writeform";
	}
	
	@RequestMapping(value="/read",method=RequestMethod.GET)
	public String read(ReplyBoardVo replyboardvo,Model model) {
		ReplyBoardVo vo=replyboardservice.getboard(replyboardvo);
		replyboardservice.count(replyboardvo);
		System.out.println(replyboardvo);
		System.out.println(vo);
		model.addAttribute("vo", vo);
		
		return "replyboard/read";
	}
	
	@RequestMapping(value="/write",method=RequestMethod.POST)
	public String write(@ModelAttribute ReplyBoardVo replyboardvo) {
		System.out.println(replyboardvo);
		replyboardservice.insert(replyboardvo);
		return "redirect:/replyboard/list";
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String delete(@RequestParam("numb") int numb ) {
		replyboardservice.delete(numb);
		return "redirect:/replyboard/list";
	}
	
	@RequestMapping(value="/search",method=RequestMethod.POST)
	public String search(@RequestParam("kwd") String names,Model model ) {
		System.out.println(names);
		List<ReplyBoardVo> list=replyboardservice.search(names);
		System.out.println(list);
		model.addAttribute("list", list);
		
		return "/replyboard/list";
	}
	
	
}
