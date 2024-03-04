package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BoardVo;

@Repository
public class BoardDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	//리스트
	public List<BoardVo> list() {
		
		List<BoardVo> bList = sqlSession.selectList("board.list");
		
		return bList;
	}
	
	//수정
	public void modify(BoardVo bv) {
		System.out.println(bv.toString());
		sqlSession.update("board.modify", bv);
	}
	
	//조회수 1개 가져오기
	public BoardVo hit(int no) {
		
		BoardVo bv = sqlSession.selectOne("board.hit", no);
		
		return bv;
	}
	
	//조회수 1회 올리기
	public void upHit(BoardVo bv) {
		
		sqlSession.update("board.upHit", bv);
	}
	
	//읽기
	public BoardVo read(int no) {
		
		BoardVo bv = sqlSession.selectOne("board.read", no);
		
		return bv;
	}
	
	//쓰기 등록
	public void write(BoardVo bv) {
		
		sqlSession.insert("board.write", bv);
	}
	
	//삭제
	public void delete(int no) {
		
		sqlSession.update("board.delete", no);
	}
}
