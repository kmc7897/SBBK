package com.kmc7897.sbbk.service;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class BooksSearchAPIService {

	private static final Logger logger = LoggerFactory.getLogger(BooksSearchAPIService.class);

	private static final String KAKAO_API_BOOK_URL = "https://dapi.kakao.com/v3/search/book";
	private static final String KAKAO_API_REST_API_KEY = "bb617767c825adbaf456d870ef2736e2";

	private static final String NAVER_API_BOOK_URL = "https://openapi.naver.com/v1/search/book.json"; // oXNWlIFy3H  Secret
	private static final String NAVER_CLIENT_ID = "qq2lfivsTWJi9WRO3FS_";
	private static final String NAVER_CLIENT_SECRET = "oXNWlIFy3H";
	
	
	
	
	public ResponseEntity<String> SearchBooks(String keyword , String target, int page) throws UnsupportedEncodingException{
		ResponseEntity<String> result = null;

		try {
			//KAKAO Rest API
			RestTemplate restTemplate = new RestTemplate(); 
			HttpHeaders headers = new HttpHeaders();
			
			String searchURL = KAKAO_API_BOOK_URL + "?size=10&target=" + target + "&page=" + page +"&query=" + URLEncoder.encode(keyword,"UTF-8");
			headers.setContentType(MediaType.APPLICATION_JSON);//JSON 변환 
			headers.set("Authorization","KakaoAK "+KAKAO_API_REST_API_KEY);

			HttpEntity entity = new HttpEntity("parameters", headers); 
			URI url=URI.create(searchURL); 
			
			result = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
			
		}catch(Exception e){
			//NAVER Rest API
			RestTemplate restTemplate = new RestTemplate(); 
			HttpHeaders headers = new HttpHeaders();
			String searchURL = null;
			int start = page*10;
			
			
			if(target.equals("title")){
				searchURL = NAVER_API_BOOK_URL + "?display=10&start="+ start + "&query=" + URLEncoder.encode(keyword,"UTF-8");;
			}else if(target.equals("isbn")){
				searchURL = NAVER_API_BOOK_URL + "?display=10&start="+ start + "d_isbn=" + URLEncoder.encode(keyword,"UTF-8");;
			}else if(target.equals("person")){
				searchURL = NAVER_API_BOOK_URL + "?display=10&start="+ start + "d_auth=" + URLEncoder.encode(keyword,"UTF-8");;
			}else if(target.equals("publisher")){
				searchURL = NAVER_API_BOOK_URL + "?display=10&start="+ start + "d_publ=" + URLEncoder.encode(keyword,"UTF-8");;
			}
			
			headers.set("X-Naver-Client-Id",NAVER_CLIENT_ID);
			headers.set("X-Naver-Client-Secret",NAVER_CLIENT_SECRET);

			HttpEntity entity = new HttpEntity("parameters", headers); 
			URI url=URI.create(searchURL); 
			
			result = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
			
		}
		
		return result;
		
	}
	
	
	
	
	
	
	
	
	
	
	
 
}
