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
	
	/*public int sendup(ReplyBoardVo replyboardvo) {
		if(replyboardvo.getOrderno() >= 2) {
			System.out.println("orderno가 2이상");
			return 0;
		}
		System.out.println(replyboardvo.getOrderno());
		System.out.println("order가 1임");
		return replyboardao.sendup(replyboardvo);
	}*/
	
	public ReplyBoardVo inforeply(ReplyBoardVo replyboardvo) {
		System.out.println("service");
		return replyboardao.inforeply(replyboardvo);
	}
	
	public int reply(ReplyBoardVo replyboardvo) {
		System.out.println("service");
		return replyboardao.reply(replyboardvo);
	}
	
	public int replyupdate(ReplyBoardVo replyboardvo) {
		System.out.println("service");
		return replyboardao.replyupdate(replyboardvo);
	}
	
	public int reply2(ReplyBoardVo replyboardvo) {
		System.out.println("service");
		return replyboardao.reply2(replyboardvo);
	}
	
	public int replyupdate2(ReplyBoardVo replyboardvo) {
		System.out.println("service");
		return replyboardao.replyupdate2(replyboardvo);
	}
	
}
