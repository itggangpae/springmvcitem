package kakao.itstudy.item.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
//XML 데이터 전체를 감싸는 태그 설정
@XmlRootElement(name="itemlist")
public class ItemReport {
	//객체 1개를 감싸는 태그 설정
	@XmlElement(name="item")
	private List<Item> list;

	public List<Item> getList() {
		return list;
	}

	public void setList(List<Item> list) {
		this.list = list;
	}
	
	
}
