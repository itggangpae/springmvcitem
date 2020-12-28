package kakao.itstudy.item.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

public class DownloadView extends AbstractView {

	//생성자
	public DownloadView() {
		setContentType(
			"application/download; charset=utf-8");
		
	}
	
	@Override
	//뷰를 그리는 메소드
	//model은 Controller에서 리턴한 데이터입니다.
	protected void renderMergedOutputModel(
			Map<String, Object> model,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//Controller에서 저장한 데이터 가져오기
		String filepath = 
				(String)model.get("filepath");
		//파일 객체로 생성
		File file = new File(filepath);
		
		//다운로드 뷰의 컨텐트 타입과 길이를 설정
		response.setContentType(getContentType());
		response.setContentLength(
				(int)file.length());
		
		//브라우저 종류에 따라 파일이름을 다르게 설정
		//ie 와 다른 브라우저는 인코딩 설정이 다름
		
		String userAgent = 
				request.getHeader("User-Agent");
		boolean ie = userAgent.indexOf("rv") > -1;
		
		String fileName = null;
		if(ie) {
			fileName = URLEncoder.encode(
					file.getName(),"utf-8");
			
		}else {
			fileName = new String(
				file.getName().getBytes("utf-8"), 
				"iso-8859-1");
		}
		
		//헤더 설정
		response.setHeader(
			"Content-Disposition",
			"attachment;filename=\"" 
			+ fileName + "\";");
		response.setHeader(
			"Content-Transfer-Encoding", 
			"binary");
		
		//파일을 다운로드 하는 코드
		OutputStream out = 
				response.getOutputStream();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			//fis의 내용을 읽어서 out에 기록 - Spring의 클래스
			FileCopyUtils.copy(fis, out);
		}
		finally{
			if(fis != null) {
				try {
					fis.close();
				}catch(Exception e) {}
			}
		}
		out.flush();

	}

}


