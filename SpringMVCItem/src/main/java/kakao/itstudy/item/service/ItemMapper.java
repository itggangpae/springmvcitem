package kakao.itstudy.item.service;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import kakao.itstudy.item.domain.Item;

@Repository
public interface ItemMapper {
	@Select("select * from item")
	public List<Item> listitem();
	
	@Select("select * from item where itemid = #{itemid}")
	public Item getitem(int itemid);
	
	
}
