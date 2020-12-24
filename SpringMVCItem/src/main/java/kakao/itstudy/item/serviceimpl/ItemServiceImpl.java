package kakao.itstudy.item.serviceimpl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kakao.itstudy.item.domain.Item;
import kakao.itstudy.item.service.ItemMapper;
import kakao.itstudy.item.service.ItemService;

//bean을 자동으로 생성해주는 어노테이션
@Service
public class ItemServiceImpl implements ItemService {
	//사용할 DAO 클래스의 인스턴스를 주입받아야 합니다.
	//@Autowired
	//private ItemDAO itemDao;
	
	@Autowired
	private ItemMapper itemDao;

	@Override
	public void listitem(HttpServletRequest request, HttpServletResponse response) {
		//1.파라미터 읽기
		
		//2.필요한 작업을 수행
		
		//3.데이터베이스 메소드 호출
		List<Item> list = itemDao.listitem();
		
		//4.필요한 작업을 수행
		
		//5.결과를 저장
		request.setAttribute("list", list);
		
		
	}

	@Override
	public void getitem(
			HttpServletRequest request,
			HttpServletResponse response,
			int itemid) {
		//DAO 메소드 호출
		Item item = itemDao.getitem(itemid);
		
		//결과 저장
		request.setAttribute("item", item);
		
	}

}
