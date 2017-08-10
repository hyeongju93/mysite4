package com.mysite.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysite.service.BoardService;

import com.mysite.vo.boardVo;

@Controller
@RequestMapping("board")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(Model model) {
		List<boardVo> list=boardService.getlist();
		System.out.println(list);
		model.addAttribute("list", list);
		return "board/list";
	}
	
	@RequestMapping(value="/read",method=RequestMethod.GET)
	public String read(boardVo boardvo,Model model) {
		boardVo vo=boardService.getboard(boardvo);
		boardService.count(boardvo);
		System.out.println(boardvo);
		System.out.println(vo);
		model.addAttribute("vo", vo);
		
		return "board/read";
	}
	
	@RequestMapping(value="/writeform",method=RequestMethod.GET)
	public String writeform() {
		return "board/writeform";
	}
	
	@RequestMapping(value="/write",method=RequestMethod.POST)
	public String write(@ModelAttribute boardVo boardvo) {
		System.out.println(boardvo);
		boardService.insert(boardvo);
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="/modifyform",method=RequestMethod.GET)
	public String modifyform() {
		/*여기서 content를 받아서 <br>을 replace 처리해서 \r\n으로 바꿔준다.*/
		return "board/modifyform";
	}
	
	@RequestMapping(value="/modify",method=RequestMethod.POST)
	public String modify(@ModelAttribute boardVo boardvo) {
		System.out.println(boardvo);
		boardService.update(boardvo);
		System.out.println(boardvo.getNum());
		String url="redirect:/board/read?num="+boardvo.getNum();
		return url;
	}
	
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String delete(@RequestParam("num") int num ) {
		boardService.delete(num);
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="/search",method=RequestMethod.POST)
	public String search(@RequestParam("kwd") String names,Model model ) {
		System.out.println(names);
		List<boardVo> list=boardService.search(names);
		System.out.println(list);
		model.addAttribute("list", list);
		
		
		return "/board/list";
	}
	
	
}
