package kakao.itstudy.item.serviceimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.type.IntegerType;
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
	
	//가장 큰 itemid를 가져오는 메소드
	public int maxItemId() {
		//데이터의 열이 1개인 경우는 addScala를 이용해서
		//열의 자료형을 설정 
		int itemid = (Integer)
				sessionFactory.getCurrentSession()
				.createSQLQuery(
				"select max(itemid) as maxid from item" )
				.addScalar("maxid", new IntegerType())
				.uniqueResult();
		return itemid;
	}
	
	//데이터 삽입
	public void itemInsert(Item item) {
		sessionFactory.getCurrentSession().save(item);
	}
}







