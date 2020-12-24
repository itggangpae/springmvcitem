package kakao.itstudy.item.serviceimpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kakao.itstudy.item.domain.Item;

//bean을 자동 생성해주는 어노테이션
@Repository
public class ItemDAO {
	//데이터베이스 연동 프레임워크 주입
	//MyBatis(Mapper.xml): SqlSession
	//MyBatis(MapperInterface): 인터페이스 주입
	//Hibernate: SessionFactory
	@Autowired
	private SqlSession sqlSession;
	
	//테이블의 전체 데이터를 가져오는 메소드
	public List<Item> listitem(){
		return sqlSession.selectList(
				"item.listitem");
	}
	
	//itemid를 가지고 하나의 데이터를 가져오는 메소드
	public Item getitem(int itemid) {
		return sqlSession.selectOne(
			"item.getitem", itemid);
	}
}
