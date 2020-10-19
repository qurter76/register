package com.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.board.dao.BoardDAO;
import com.board.domain.BoardVO;
import com.board.domain.CrawlVO;

@Service
public class BoardServiceImpl implements BoardService {

 @Inject
 private BoardDAO dao;

 //등록된 사이트
@Override
public List list() throws Exception {
	// TODO Auto-generated method stub
	return dao.list();
}

//사이트 등록하기
@Override
public void write(BoardVO vo) throws Exception {
	// TODO Auto-generated method stub
	dao.write(vo);
	
}

//크롤링 정보 출력
@Override
public List datalist() throws Exception {
	// TODO Auto-generated method stub
	return dao.datalist();
}

//사이트 등록정보 조회
@Override
public BoardVO view(String USERID) throws Exception {
	// TODO Auto-generated method stub
	return dao.view(USERID);
}

//사이트 등록정보 수정
@Override
public void modify(BoardVO vo) throws Exception {
	// TODO Auto-generated method stub
	dao.modify(vo);
}
 


}