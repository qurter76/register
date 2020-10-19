package com.board.crawl;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Iterator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class Crawling {

	public static void main(String[] args) {

		
		String keyword = "원펀맨"; 
		String url = "https://marumaru.pics/bbs/search.php?url=https%3A%2F%2Fmarumaru.pics%2Fbbs%2Fsearch.php&stx=" + keyword ; //크롤링할 url지정
		String url2 = "http://www.cgv.co.kr/movies/";
		Document doc = null;        //Document에는 페이지의 전체 소스가 저장된다

		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//select를 이용하여 원하는 태그를 선택한다. select는 원하는 값을 가져오기 위한 중요한 기능이다. div.sect-movie-chart
		Elements element = doc.select("div.search-media");    
		Elements element2 = doc.select("div.sect-movie-chart"); 
		Elements articles = doc.select("div.basic-post-list");
		
		
		for(Element article : articles) {

			  // a태그 href의 절대주소를 얻어낸다.
			  
			  Elements articleTd = article.select("td");
			  Elements articleA = article.select("a");
			  String href = articleTd.attr("abs:href"); 
//			  String rank = articleTd.get(0).ownText(); // 첫번째 td에서등수 가져온다.
			                              
			  String title = articleA.get(0).ownText(); // 두 번째  td에서 제목을 얻어낸다.

//			  String date = articleTd.get(2).ownText();

//			  System.out.println(href); 
//			  System.out.println(rank); 
//			  System.out.println(title); 
//			  System.out.println(date);
			}

		System.out.println("=======================================================================================================================");

		//Iterator을 사용하여 하나씩 값 가져오기
		Iterator<Element> ie1 = element.select("td").iterator();
//		Iterator<Element> ie2 = element.select("strong.title").iterator();
		        
//		while (ie1.hasNext()) {
//			System.out.println(ie1.next().text()+"\t"+ie2.next().text());
//		}
		
		while (ie1.hasNext()) {
		System.out.println(ie1.next().text()+"\t");
		}
		System.out.println(element.text());
		
		System.out.println("=======================================================================================================================");
	}
}