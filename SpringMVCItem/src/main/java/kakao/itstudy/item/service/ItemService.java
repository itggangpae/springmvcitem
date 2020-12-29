package kakao.itstudy.item.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface ItemService {
	//Item 테이블의 전체 데이터를 가져오는 메소드
	public void listitem(
			HttpServletRequest request, 
			HttpServletResponse response);
	
	//Item 테이블에서 1개의 데이터를 가져오는 메소드
	public void getitem(
			HttpServletRequest request, 
			HttpServletResponse response,
			int itemid);
	
	//Item 테이블에서 1개의 데이터를 삽입하는  메소드
	public void itemInsert(
				MultipartHttpServletRequest request, 
				HttpServletResponse response);
}
