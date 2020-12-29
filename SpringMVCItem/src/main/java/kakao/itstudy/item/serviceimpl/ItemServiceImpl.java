package kakao.itstudy.item.serviceimpl;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kakao.itstudy.item.domain.Item;
import kakao.itstudy.item.service.ItemMapper;
import kakao.itstudy.item.service.ItemService;

//bean을 자동으로 생성해주는 어노테이션
@Service
public class ItemServiceImpl implements ItemService {
	//사용할 DAO 클래스의 인스턴스를 주입받아야 합니다.
	//@Autowired
	//private ItemDAO itemDao;
	
	//@Autowired
	//private ItemMapper itemDao;
	
	@Autowired
	private ItemHibernateDAO itemDao;

	@Transactional
	@Override
	public void listitem(HttpServletRequest request, HttpServletResponse response) {
		//1.파라미터 읽기
		
		//2.필요한 작업을 수행
		
		//3.데이터베이스 메소드 호출
		List<Item> list = itemDao.listitem();
		
		//4.필요한 작업을 수행
		
		//5.결과를 저장
		request.setAttribute("list", list);
		
		
	}

	@Transactional
	@Override
	public void getitem(
			HttpServletRequest request,
			HttpServletResponse response,
			int itemid) {
		//DAO 메소드 호출
		Item item = itemDao.getitem(itemid);
		
		//결과 저장
		request.setAttribute("item", item);
		
	}

	@Transactional
	@Override
	public void itemInsert(
			MultipartHttpServletRequest request,
			HttpServletResponse response) {
		//1.파라미터 읽기
		String itemname = 
				request.getParameter("itemname");
		String price = 
				request.getParameter("price");
		String description = 
				request.getParameter("description");
		MultipartFile file = 
				request.getFile("pictureurl");
		String pictureurl = null;
		//업로드하는 파일이 있다면
		if(file.isEmpty() == false) {
			//프로젝트 내의 img 디렉토리의 절대 경로 만들기
			String filepath = 
				request.getServletContext().
				getRealPath("/img");
			//저장할 파일이름을 생성
			pictureurl = UUID.randomUUID() 
					+ file.getOriginalFilename();
			filepath += "/" + pictureurl;
			
			//파일 업로드
			File f = new File(filepath);
			try {
				file.transferTo(f);
			}catch(Exception e) {}
			
		}
		//데이터베이스에 데이터를 삽입
		Item item = new Item();
		item.setItemid(itemDao.maxItemId() + 1);
		item.setItemname(itemname);
		item.setPrice(Integer.parseInt(price));
		item.setDescription(description);
		item.setPictureurl(pictureurl);
		
		itemDao.itemInsert(item);
		
	}
}
