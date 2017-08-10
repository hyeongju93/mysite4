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

}
