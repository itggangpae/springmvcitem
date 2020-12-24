package kakao.itstudy.item.serviceimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import kakao.itstudy.item.domain.Item;

@Repository
public class ItemHibernateDAO {
	//Hibernate 사용을 위한 의존성 주입
	@Autowired
	private SessionFactory sessionFactory;
	
	//전체 데이터를 가져오는 메소드
	public List<Item> listitem(){
		return sessionFactory.getCurrentSession()
				.createCriteria(Item.class).list();
		
	}
	
	//itemid를 가지고 하나의 데이터를 가져오는 메소드
	public Item getitem(int itemid) {
		return sessionFactory.getCurrentSession()
				.get(Item.class, itemid);
	}
}







