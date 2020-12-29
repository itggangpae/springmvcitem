package kakao.itstudy.item;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kakao.itstudy.item.domain.Item;
import kakao.itstudy.item.domain.ItemReport;
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
	
	@RequestMapping(
			value="download", 
			method=RequestMethod.GET)
	public String download(
		HttpServletRequest request,
		Model model) {
		//파라미터 읽어오기
		String filename = 
				request.getParameter("filename");
		//파일의 절대 경로 만들기
		//프로젝트 내에 존재하는 파일의 절대 경로를 만들기
		String filepath = 
				request.getServletContext()
					.getRealPath("/img") + "/" +
						filename;
		//절대 경로를 저장
		model.addAttribute("filepath", filepath);
		//출력할 뷰 이름을 리턴
		return "download";
	}
	
	@RequestMapping(value="item.xls",
			method=RequestMethod.GET)
	public String excel(
			Model model,
			HttpServletRequest request,
			HttpServletResponse response) {
		//서비스 메소드 호출
		itemService.listitem(request, response);
		//request 에 저장된 데이터를 확인
		//list 라는 속성에 List<Item> 타입으로 존재
		return "excel";
	}
	
	@RequestMapping(value="item.pdf",
			method=RequestMethod.GET)
	public String pdf(
			Model model,
			HttpServletRequest request,
			HttpServletResponse response) {
		//서비스 메소드 호출
		itemService.listitem(request, response);
		//request 에 저장된 데이터를 확인
		//list 라는 속성에 List<Item> 타입으로 존재
		return "pdf";
	}
	
	@RequestMapping(value="view.json",
			method=RequestMethod.GET)
	public String json(
			Model model,
			HttpServletRequest request,
			HttpServletResponse response) {
		//서비스 메소드 호출
		itemService.listitem(request, response);
		
		//request에 저장된 데이터를 읽어서 
		//model에 저장
		List<Item> list = 
				(List<Item>)
					request.getAttribute("list");
		
		model.addAttribute("list", list);
		
		//request 에 저장된 데이터를 확인
		//list 라는 속성에 List<Item> 타입으로 존재
		return "json";
	}
	
	@RequestMapping(value="item.xml",
			method=RequestMethod.GET)
	public String xml(
			Model model,
			HttpServletRequest request,
			HttpServletResponse response) {
		//서비스 메소드 호출
		itemService.listitem(request, response);
		
		//request에 저장된 데이터를 읽어서 
		//model에 저장
		List<Item> list = 
				(List<Item>)
					request.getAttribute("list");
		ItemReport itemReport = 
				new ItemReport();
			itemReport.setList(list);
		model.addAttribute("list", itemReport);
		
		//request 에 저장된 데이터를 확인
		//list 라는 속성에 List<Item> 타입으로 존재
		return "itemReport";
	}



}
