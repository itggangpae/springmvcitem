package kakao.itstudy.item;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import kakao.itstudy.item.domain.Member;
import kakao.itstudy.item.service.ItemService;
import kakao.itstudy.item.util.MemberValidator;

@Controller
public class HomeController {
	@Autowired
	private ItemService itemService;
	
	//HomeController가 처리하는 모든 뷰에 
	//logintypes 라는 이름으로 리턴하는 데이터가 전달
	@ModelAttribute("logintypes")
	public List<String> loginTypes(){
		List<String> list = 
			new ArrayList<String>();
		list.add("일반회원");
		list.add("기업회원");
		list.add("비회원");
		return list;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(
			HttpServletRequest request,
			HttpServletResponse response) {
		itemService.listitem(request, response);
		return "home";
	}
	
	@RequestMapping(value = "login", 
			method = RequestMethod.GET)
	//폼으로 이동할 때 유효성 검사 기능을 수행하기 위해서 
	//Command 객체의 이름을 member로 설정
	public String login(
			@ModelAttribute("member") Member member) {
		return "login";
	}
	
	@RequestMapping(value = "login", 
			method = RequestMethod.POST)
	//폼에서 로그인 처리를 요청할 때 유효성 검사 기능을 수행
	public String login(
			@Valid @ModelAttribute("member") Member member,
			Errors errors) {
		//유효성 검사에서 에러가 발생한 경우
		if(errors.hasErrors()) {
			return "login";
		}else {
			return "redirect:/";
		}
	}
}
