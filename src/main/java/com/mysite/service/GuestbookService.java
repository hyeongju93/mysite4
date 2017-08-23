package com.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysite.repository.guestbookDao;
import com.mysite.vo.guestbookVo;

@Service
public class GuestbookService {
	@Autowired
	private guestbookDao guestbookdao;
	
	public List<guestbookVo> getlist() {
		return guestbookdao.getlist();
	}
	
	public int add(guestbookVo guestbookvo) {
		System.out.println("서비스");
		return guestbookdao.insert(guestbookvo);
	}
	
	public int delete(int no) {
		System.out.println("서비스");
		return guestbookdao.delete(no);
	}
	//아래 예제 굉장히 중요한 예제 꼭 기얼할것!!
	public guestbookVo writeVo(guestbookVo guestbookvo) {
		System.out.println("전: "+guestbookvo.getNo());
		int no=guestbookdao.insertNo(guestbookvo);
		System.out.println("후: "+guestbookvo.getNo());
		System.out.println("no: "+no);
		guestbookVo guestbookvo2=guestbookdao.selectByNo(no);
		return guestbookvo2;
	}
	
	

}
