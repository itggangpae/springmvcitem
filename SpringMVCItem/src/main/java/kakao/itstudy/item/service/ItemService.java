package kakao.itstudy.item.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ItemService {
	//Item 테이블의 전체 데이터를 가져오는 메소드
	public void listitem(
			HttpServletRequest request, 
			HttpServletResponse response);
}
