package com.mysite.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysite.vo.boardVo;

@Repository
public class BoardDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<boardVo> getlist() {
		System.out.println("dao");
		List<boardVo> list=sqlSession.selectList("board.getlist");
		System.out.println(list);
		return list;
	}
	
	public boardVo getboard(boardVo boardvo) {
		System.out.println("dao");
		return sqlSession.selectOne("board.getboard", boardvo);
	}
	
	public int insert(boardVo boardvo) {
		System.out.println("dao");
		String content=boardvo.getContent();
		System.out.println(content);
		content=content.replace("\r\n", "<br>");
		System.out.println(content);
		boardvo.setContent(content);
		return sqlSession.insert("board.insert", boardvo);
	}
	
	public int update(boardVo boardvo) {
		System.out.println("dao");
		String content=boardvo.getContent();
		System.out.println(content);
		content=content.replace("\r\n", "<br>");
		System.out.println(content);
		boardvo.setContent(content);
		return sqlSession.update("board.update", boardvo);
	}
	
	public int count(boardVo boardvo) {
		System.out.println("dao");
		System.out.println(boardvo.getHit());
		int hit=boardvo.getHit()+1;
		boardvo.setHit(hit);
		System.out.println(hit);
		return sqlSession.update("board.count", boardvo);
	}
	
	public int delete(int num) {
		System.out.println("dao");
		return sqlSession.delete("board.delete", num);
	}
	
	public List<boardVo> search(String names) {
		System.out.println("dao");
		System.out.println(names);
		names='%'+names+'%';
		List<boardVo> list=sqlSession.selectList("board.search", names);
		System.out.println(list);
		return list;
	}

}
