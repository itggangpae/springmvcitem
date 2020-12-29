package kakao.itstudy.item.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class Member {
	@NotNull
	@Pattern(regexp ="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.(?:[a-zA-Z]{2,6})$", 
	message="Invalid E-Mail")
	private String email;
	
	@NotNull
	@Size(min=5, message="비밀번호가 너무 짧습니다.")
	private String password;
	private String logintype;
}
