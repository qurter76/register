package com.board.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.board.dao.BoardDAO;
import com.board.domain.BoardVO;
import com.board.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	 @Inject
	 private BoardService service;
	
	 // added site
	 @RequestMapping(value = "/list", method = RequestMethod.GET)
	 public void getList(Model model, HttpSession session) throws Exception {
	  
	  List list = null;
	  list = service.list();
	  model.addAttribute("list", list);
	 }
	 
	//site add 
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public void getWirte() throws Exception {
	 
	}
	
	// 사이트 등록
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String posttWirte(BoardVO vo) throws Exception {
	  service.write(vo);
	  
	  return "redirect:/board/list";
	}
	
	//크롤링 정보 표시 
	 // added site
//	 @RequestMapping(value = "/list", method = RequestMethod.GET)
//	 public void crawling(Model model) throws Exception {
//	  
//	  List list = null;
//	  list = service.list();
//	  model.addAttribute("list", list);
//	 }
	
	// 사이트 등록정보 조회
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public void getView(@RequestParam("USERID") String USERID, Model model) throws Exception {
		
		BoardVO vo = service.view(USERID);
		
		model.addAttribute("view", vo);
				
	}
	
	// 등록 사이트 수정
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void getModify(@RequestParam("USERID") String USERID, Model model) throws Exception {
		
		BoardVO vo = service.view(USERID);
		
		model.addAttribute("view", vo);
			
	}
	
	// 등록 사이트 수정
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String postModify(BoardVO vo) throws Exception {

	 service.modify(vo);
	   
	 return "redirect:/board/view?USERID=" + vo.getUSERID();
	}
	
	
	
}