package com.devfox.crawling.service;

import com.devfox.crawling.logic.Members;

public interface UserService {

	Members getUserOne(String common, String col);

	int userJoin(Members members);

}