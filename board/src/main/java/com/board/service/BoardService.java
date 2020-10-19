package com.board.service;

import java.util.List;

import com.board.domain.*;

public interface BoardService {
	
	//등록된 사이트
	public List<BoardVO> list() throws Exception;
	
	//사이트 등록
	public void write(BoardVO vo) throws Exception;
	
	//크롤링 정보
	public List<CrawlVO> datalist() throws Exception;

	// 사이트 등록정보 조회
	public BoardVO view(String USERID) throws Exception;
	
	// 사이트 등록정보 수정
	public void modify(BoardVO vo) throws Exception;
}
