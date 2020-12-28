package kakao.itstudy.item.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;

import kakao.itstudy.item.domain.Item;

public class PdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//데이터 가져오기
		List<Item> list = 
			(List<Item>)
				request.getAttribute("list");
		//테이블을 생성
		//3칸 데이터 개수 + 1 행의 테이블 생성 
		Table table = new Table(3, list.size()+1);
		table.setPadding(5);
		
		//폰트 설정
		BaseFont bfKorean = 
			BaseFont.createFont(
				request.getServletContext().getRealPath("/") 
				+ "/malgun.ttf", BaseFont.IDENTITY_H,
				BaseFont.EMBEDDED);
		Font font = new Font(bfKorean);
		
		//제목 셀 설정
		Cell cell = new Cell(new Paragraph("이름", font));
		cell.setHeader(true);
		table.addCell(cell);
		
		cell = new Cell(new Paragraph("설명", font));
		cell.setHeader(true);
		table.addCell(cell);
		
		cell = new Cell(new Paragraph("가격", font));
		cell.setHeader(true);
		table.addCell(cell);
		
		table.endHeaders();
		
		//데이터 출력
		for(Item item : list) {
			cell = new Cell(
				new Paragraph(item.getItemname(), font));
			table.addCell(cell);
			
			cell = new Cell(
				new Paragraph(item.getDescription(), font));
			table.addCell(cell);
			
			cell = new Cell(
				new Paragraph(item.getPrice()+"원", font));
			table.addCell(cell);
			
		}
		
		//테이블을 문서에 포함
		document.add(table);

	}

}
