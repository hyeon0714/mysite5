package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	//회원가입(추가)
	public void insert(UserVo uv) {
		
		sqlSession.insert("user.insert", uv);
	}
	
	//로그인
	public UserVo selectOne(UserVo uv) {

		UserVo userVo = sqlSession.selectOne("user.selectOne", uv);
		
		return userVo;
	}
	
	//수정
	public void update(UserVo uv) {
		
		sqlSession.update("user.update", uv);
	}
	
}
