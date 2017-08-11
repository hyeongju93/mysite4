package com.mysite.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysite.vo.ReplyBoardVo;
import com.mysite.vo.boardVo;


@Repository
public class ReplyBoardDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	
	public List<ReplyBoardVo> getlist() {
		System.out.println("dao");
		List<ReplyBoardVo> list=sqlSession.selectList("replyboard.getlist");
		System.out.println(list);
		return list;
	}
	
	public ReplyBoardVo getboard(ReplyBoardVo replyboardvo) {
		System.out.println("dao");
		return sqlSession.selectOne("replyboard.getboard", replyboardvo);
	}
	
	public int insert(ReplyBoardVo replyboardvo) {
		System.out.println("dao");
		String content=replyboardvo.getContent();
		System.out.println(content);
		content=content.replace("\r\n", "<br>");
		System.out.println(content);
		replyboardvo.setContent(content);
		return sqlSession.insert("replyboard.insert", replyboardvo);
	}

	public int delete(int numb) {
		System.out.println("dao");
		return sqlSession.delete("replyboard.delete", numb);
	}
	
	public List<ReplyBoardVo> search(String names) {
		System.out.println("dao");
		System.out.println(names);
		names='%'+names+'%';
		List<ReplyBoardVo> list=sqlSession.selectList("replyboard.search", names);
		System.out.println(list);
		return list;
	}
	
	public int count(ReplyBoardVo replyboardvo) {
		System.out.println("dao");
		return sqlSession.update("replyboard.count", replyboardvo);
	}
	
	public int update(ReplyBoardVo replyboardvo) {
		System.out.println("dao");
		String content=replyboardvo.getContent();
		System.out.println(content);
		content=content.replace("\r\n", "<br>");
		System.out.println(content);
		replyboardvo.setContent(content);
		return sqlSession.update("replyboard.update", replyboardvo);
	}
	
}
