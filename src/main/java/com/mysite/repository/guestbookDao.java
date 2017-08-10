package com.mysite.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.mysite.vo.guestbookVo;


@Repository
public class guestbookDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<guestbookVo> getlist() {
		List<guestbookVo> list=sqlSession.selectList("guestbook.getlist");
		System.out.println(list);
		return list;
	}
	
	public int insert(guestbookVo guestbookvo) {
		System.out.println("dao");
		return sqlSession.insert("guestbook.insert",guestbookvo);
	}
	
	public int delete(int no) {
		System.out.println("dao");
		return sqlSession.delete("guestbook.delete", no);
	}

}
