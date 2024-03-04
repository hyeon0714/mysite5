package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.BoardService;
import com.javaex.vo.BoardVo;

@Controller
@RequestMapping(value = "board")
public class BoardController {
	
	@Autowired
	private BoardService bs;
	
	//리스트폼
	@RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		
		List<BoardVo> bList = bs.exeList();
		
		model.addAttribute("bList", bList);
		
		return "board/list";
	}
	
	//수정폼
	@RequestMapping(value = "/modifyform", method = {RequestMethod.GET, RequestMethod.POST})
	public String modifyForm(@RequestParam(value = "no")int no, Model model) {
		
		BoardVo bv = bs.exeRead(no);
		
		model.addAttribute("bv", bv);
		
		return "board/modifyForm";
	}
	
	//수정
	@RequestMapping(value = "/modify", method = {RequestMethod.GET, RequestMethod.POST})
	public String modify(@ModelAttribute BoardVo bv) {
		
		bs.exeModify(bv);
		
		return "redirect:/board/list";
	}
	
	//읽기폼
	@RequestMapping(value = "/read", method = {RequestMethod.GET, RequestMethod.POST})
	public String read(@RequestParam(value = "no")int no, Model model) {
		
		bs.exehit(no);
		
		BoardVo bv = bs.exeRead(no);
		
		model.addAttribute("bv", bv);
		
		return "board/read";
	}
	
	//쓰기폼
	@RequestMapping(value = "/writeform", method = {RequestMethod.GET, RequestMethod.POST})
	public String writeForm() {
		
		return "board/writeForm";
	}
	
	//쓰기 등록
	@RequestMapping(value = "/write", method = {RequestMethod.GET, RequestMethod.POST})
	public String write(@ModelAttribute BoardVo bv) {
		
		bs.exeWrite(bv);
		
		return "redirect:/board/list";
	}
	
	//삭제
	@RequestMapping(value = "/delete", method = {RequestMethod.GET, RequestMethod.POST})
	public String delete(@RequestParam(value = "no")int no) {
		
		bs.exeDelete(no);
		
		return "redirect:/board/list";
	}
	
	
}
