package kakao.itstudy.item;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kakao.itstudy.item.domain.Item;
import kakao.itstudy.item.service.ItemService;


//일반 Text 나 JSON을 출력하기 위한 Controller를 생성하기
//위한 Annotation
@RestController
public class JSONController {
	@Autowired
	private ItemService itemService;
	
	
	@RequestMapping(value="controller.json",
		method=RequestMethod.GET)
	public Map<String, Object> controller(
			HttpServletRequest request, 
			HttpServletResponse response){
		Map<String, Object> map = 
			new HashMap<String, Object>();
		
		//서비스 메소드 호출
		itemService.listitem(request, response);
		
		//데이터 가져오기
		List<Item> list = 
			(List<Item>) request.getAttribute("list");
		//데이터 개수
		map.put("count", list.size());
		//데이터 목록
		map.put("list", list);
		return map;
	}
	
	
}
