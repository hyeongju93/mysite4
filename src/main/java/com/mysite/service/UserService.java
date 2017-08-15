package com.mysite.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysite.repository.UserDao;
import com.mysite.vo.UserVo;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public int join(UserVo userVo) {
		return userDao.insert(userVo);
		
		
	}
	
	
	public UserVo getUser(String email,String passwords) {
		return userDao.getUser(email,passwords);
	}
	
	public UserVo getUser(int no) {
		return userDao.getUser(no);
	}
	
	public int updateUser(UserVo userVo) {
		return userDao.updateUser(userVo);
	}
	
	public int logout(HttpSession session) {
		session.removeAttribute("authUser");
		session.invalidate();
		return 0;
	}
}
