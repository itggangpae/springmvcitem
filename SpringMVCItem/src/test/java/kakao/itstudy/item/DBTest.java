package kakao.itstudy.item;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
	locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})

public class DBTest {
	@Autowired
	private DataSource dataSource;
	
	@Test
	public void dsTest() {
		try {
			Connection con = 
					dataSource.getConnection();
			System.out.printf("연결:%s\n", con);
		}catch(Exception e) {}
	}
	
	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void mybatisTest() {
		System.out.printf("MyBatis:%s\n", sqlSession);
	}
	
	
}
