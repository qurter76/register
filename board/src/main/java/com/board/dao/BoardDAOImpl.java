package com.board.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.board.domain.BoardVO;
import com.board.domain.CrawlVO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	private SqlSession sql;
 
	private static String namespace = "com.board.mappers.board";

	// added site
	@Override
	public List list() throws Exception { 
  
		return sql.selectList(namespace + ".list");
 }
	//사이트 등록하기
	@Override
	public void write(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		sql.insert(namespace + ".write", vo);
	}
	
	//크롤링 정보 출력
	@Override
	public List datalist() throws Exception {
		// TODO Auto-generated method stub
		return sql.selectList(namespace + ".datalist");
	}
	
	//사이트 등록정보 조회
	@Override
	public BoardVO view(String USERID) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectOne(namespace + ".view", USERID);
	}
	
	//사이트 등록 수정
	@Override
	public void modify(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		sql.update(namespace + ".modify", vo);
	}

	



}