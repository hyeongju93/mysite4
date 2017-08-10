package com.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysite.repository.BoardDao;
import com.mysite.vo.boardVo;

@Service
public class BoardService {
	
	@Autowired
	private BoardDao boardao;
	
	
	public List<boardVo> getlist() {
		System.out.println("service");
		return boardao.getlist();
	}
	
	public boardVo getboard(boardVo boardvo) {
		System.out.println("service");
		return boardao.getboard(boardvo);
	}
	
	public int insert(boardVo boardvo) {
		System.out.println("service");
		return boardao.insert(boardvo);
	}
	
	public int update(boardVo boardvo) {
		System.out.println("service");
		return boardao.update(boardvo);
	}
	
	public int count(boardVo boardvo) {
		System.out.println("service");
		return boardao.count(boardvo);
	}
	
	public int delete(int num) {
		System.out.println("service");
		return boardao.delete(num);
	}
	
	public List<boardVo> search(String names) {
		System.out.println("service");
		return boardao.search(names);
	}

}
