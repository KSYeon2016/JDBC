package kr.ac.sungkyul.bookmaill.dao.test;

import java.util.List;

import kr.ac.sungkyul.bookmaill.dao.BookDao;
import kr.ac.sungkyul.bookmall.vo.BookVo;

public class BookDaoTest {

	public static void main(String[] args) {
		//testBookDaoInsert();
		testBookDaoGetList();
	}
	
	public static void testBookDaoGetList(){
		BookDao dao = new BookDao();
		List<BookVo> list = dao.getList();
		
		for(BookVo vo : list){
			System.out.println(vo);
		}
	}
	
	public static void testBookDaoInsert(){
		BookVo vo = new BookVo();
		vo.setTitle("토지");
		vo.setRate(4);
		vo.setAuthorNo(1L);
		
		BookDao dao = new BookDao();
		dao.insert(vo);
	}
}
