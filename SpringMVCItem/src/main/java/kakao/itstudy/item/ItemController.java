package kakao.itstudy.item;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kakao.itstudy.item.service.ItemService;

//bean을 자동 생성해주는 어노테이션
@Controller
public class ItemController {
	//필요한 Service 인스턴스를 주입받아야 합니다.
	@Autowired
	private ItemService itemService;

	//detail 요청이 GET 방식으로 오면 호출
	/*
	@RequestMapping(
		value="detail", method=RequestMethod.GET)
	public String detail(
			HttpServletRequest request,
			HttpServletResponse response) {
		itemService.getitem(request, response);
		//결과는 detail
		return "detail";
	}
	 */

	@RequestMapping(
			value="detail/{itemid}",
			method=RequestMethod.GET)
	public String detail(
			HttpServletRequest request,
			HttpServletResponse response,
			@PathVariable int itemid) {
		itemService.getitem(
			request, response, itemid);
		//결과는 detail
		return "detail";
	}

}
