package com.board.dao;

import java.util.List;

import com.board.domain.BoardVO;
import com.board.domain.CrawlVO;

public interface BoardDAO {
 
 public List list() throws Exception; 
 
//사이트 등록
public void write(BoardVO vo) throws Exception;

//크롤링 정보 등록
public List datalist() throws Exception;

//등록 사이트 정보 조회
public BoardVO view(String USERID) throws Exception;

//사이트 등록 수정
public void modify(BoardVO vo) throws Exception;

}