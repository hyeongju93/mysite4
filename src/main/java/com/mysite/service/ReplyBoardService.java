package com.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysite.repository.ReplyBoardDao;
import com.mysite.vo.ReplyBoardVo;
import com.mysite.vo.boardVo;

@Service
public class ReplyBoardService {
	
	@Autowired
	private ReplyBoardDao replyboardao;
	
	public List<ReplyBoardVo> getlist() {
		System.out.println("service");
		return replyboardao.getlist();
	}
	
	public ReplyBoardVo getboard(ReplyBoardVo replyboardvo) {
		System.out.println("service");
		return replyboardao.getboard(replyboardvo);
	}

	public int insert(ReplyBoardVo replyboardvo) {
		System.out.println("service");
		return replyboardao.insert(replyboardvo);
	}
	
	public int delete(int numb) {
		System.out.println("service");
		return replyboardao.delete(numb);
	}
	
	public List<ReplyBoardVo> search(String names) {
		System.out.println("service");
		return replyboardao.search(names);
	}
	
	public int count(ReplyBoardVo replyboardvo) {
		System.out.println("service");
		return replyboardao.count(replyboardvo);
	}
	
	public int update(ReplyBoardVo replyboardvo) {
		System.out.println("service");
		return replyboardao.update(replyboardvo);
	}
	
	
}
