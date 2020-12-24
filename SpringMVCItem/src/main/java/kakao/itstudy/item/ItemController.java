package kakao.itstudy.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import kakao.itstudy.item.service.ItemService;

//bean을 자동 생성해주는 어노테이션
@Controller
public class ItemController {
	//필요한 Service 인스턴스를 주입받아야 합니다.
	@Autowired
	private ItemService itemService;
}
