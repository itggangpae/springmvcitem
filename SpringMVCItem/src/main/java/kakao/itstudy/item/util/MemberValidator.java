package kakao.itstudy.item.util;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import kakao.itstudy.item.domain.Member;

public class MemberValidator implements Validator {

	@Override
	//어떤 클래스로 유효성 검사를 수행할 지 설정하는 메소드
	public boolean supports(Class<?> clazz) {
		return Member.class.isAssignableFrom(clazz);
	}

	@Override
	//유효성 검사에 사용되는 메소드
	public void validate(Object target, Errors errors) {
		Member member = (Member)target;
		
		if(member.getEmail() == null || 
				member.getEmail().trim().isEmpty()) {
			errors.rejectValue("email", "required");
		}
		if(member.getPassword() == null || 
				member.getPassword().trim().isEmpty()) {
			errors.rejectValue("password", "required");
		}
	}
}
