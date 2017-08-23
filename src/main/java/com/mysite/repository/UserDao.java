package com.mysite.repository;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysite.vo.UserVo;

@Repository
public class UserDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public int insert(UserVo userVo) {
		return sqlSession.insert("user.insert",userVo);
	}
	
	public UserVo getUser(String email, String passwords) {
		Map<String, Object> userMap=new HashMap<String,Object>();
		userMap.put("email", email);
		userMap.put("passwords", passwords);
		UserVo userVo=sqlSession.selectOne("user.selectUserByEmailPw",userMap);
		return userVo;
	}
	
	public UserVo getUser(int no) {
		UserVo userVo=sqlSession.selectOne("user.selectUserByNo",no);
		return userVo;
	}
	
	public int updateUser(UserVo userVo) {
		return sqlSession.update("user.update",userVo);
	}
	
	public UserVo check(String email) {
		System.out.println("다오들어옴");
		UserVo vo=sqlSession.selectOne("user.check",email);
		System.out.println(vo);
		return vo;
	}
	
}
