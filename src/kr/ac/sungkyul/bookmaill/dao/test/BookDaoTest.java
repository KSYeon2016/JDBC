package kr.ac.sungkyul.bookmaill.dao.test;

import java.util.List;

import kr.ac.sungkyul.bookmaill.dao.BookDao;
import kr.ac.sungkyul.bookmall.vo.BookVo;

public class BookDaoTest {

	public static void main(String[] args) {
		//testBookDaoInsert();
		//testBookDaoDelete();
		//testBookDaoUpdate();
		testBookDaoGetList();
		testBookDaoDeleteAll();
		testBookDaoGetList();
	}
	
	public static void testBookDaoDeleteAll(){
		BookDao dao = new BookDao();
		dao.delete();
		System.out.println("전체삭제");
	}
	
	public static void testBookDaoUpdate(){
		BookDao dao = new BookDao();
		
		BookVo vo = new BookVo();
		vo.setNo(2L);
		vo.setTitle("현의노래");
		vo.setRate(3);
		vo.setAuthorNo(2L);
		
		int count = dao.update(vo);
		System.out.println("변경된 row 수 : " + count);
	}
	
	public static void testBookDaoDelete(){
		BookDao dao = new BookDao();
		int count = dao.delete(1L);
		System.out.println("삭제된 row 수 : " + count);
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
		vo.setTitle("칼의노래");
		vo.setRate(4);
		vo.setAuthorNo(2L);
		
		BookDao dao = new BookDao();
		dao.insert(vo);
	}
}
