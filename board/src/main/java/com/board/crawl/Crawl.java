package com.board.crawl;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawl {
	public static void main(String[] args) throws IOException {
		
		String keyword = "원펀맨";
		Document doc = null; 
		
		Connection.Response response = Jsoup.connect("https://marumaru.pics/bbs/search.php?url=https%3A%2F%2Fmarumaru.pics%2Fbbs%2Fsearch.php&stx=" + keyword)
                .method(Connection.Method.GET)
                .execute();
		Document marumaruDocument = response.parse();
//		Elements element = doc.select("div.search-media"); 
		Element title = marumaruDocument.select("div[name=search-media]").first();
		String titleValue = title.attr("value");

		System.out.println(titleValue); // Google 검색
		
		
	}
	

}
