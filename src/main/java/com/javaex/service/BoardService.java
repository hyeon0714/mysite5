package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BoardDao;
import com.javaex.vo.BoardVo;

@Service
public class BoardService {
	
	@Autowired
	private BoardDao bd;
	
	//리스트
	public List<BoardVo> exeList() {
		
		List<BoardVo> bList = bd.list();
		
		return bList;
	}
	
	//수정
	public void exeModify(BoardVo bv) {
		
		bd.modify(bv);
	}
	
	//조회수 올리기
	public void exehit(int no) {
		
		//조회수 가져오기
		BoardVo bv = bd.hit(no);
		
		//조회수 1회 올리기
		int a = bv.getHit() + 1 ;
		
		bv.setNo(no);
		bv.setHit(a);
		
		bd.upHit(bv);
	}
	
	//읽기/수정 내용
	public BoardVo exeRead(int no) {
		
		BoardVo boardVo = bd.read(no);
		
		return boardVo;
	}
	
	//쓰기 등록
	public void exeWrite(BoardVo bv) {
		
		bd.write(bv);
	}
	
	//삭제
	public void exeDelete(int no) {
		
		bd.delete(no);
	}
}
