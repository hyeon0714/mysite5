package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Service
public class UserService {
	
	@Autowired
	private UserDao ud;
	
	//회원가입
	public void exeJoin(UserVo uv) {
		
		ud.insert(uv);
	}
	
	//로그인
	public UserVo exeLogin(UserVo uv) {
		
		UserVo userVo = ud.selectOne(uv);
		
		return userVo;
	}
	
	//수정
	public void exeModify(UserVo uv) {
		
		ud.update(uv);
		
	}

}
