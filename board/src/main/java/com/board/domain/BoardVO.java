package com.board.domain;

public class BoardVO {

	/*
	create table tbl_site_add(
			USERID varchar(100),
		    url varchar(2000),
		    sitename varchar(100),
		    keyword varchar(100),
		    foreign key (USERID) references tbl_member(USERID)
		    );
	*/
	private String USERID;
	private String url;
	private String sitename;
	private String keyword;
	
	public String getUSERID() {
		return USERID;
	}
	public void setUSERID(String uSERID) {
		USERID = uSERID;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getSitename() {
		return sitename;
	}
	public void setSitename(String sitename) {
		this.sitename = sitename;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}
