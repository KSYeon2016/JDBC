package kr.ac.sungkyul.bookmaill.dao.test;

import java.util.List;

import kr.ac.sungkyul.bookmaill.dao.BookDao;
import kr.ac.sungkyul.bookmall.vo.BookVo;

public class BookDaoTest {

	public static void main(String[] args) {
		//testBookDaoInsert();
		//testBookDaoDelete();
		//testBookDaoUpdate();
		//testBookDaoDeleteAll();
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
		vo.setTitle("브레이킹던");
		vo.setCost(20000);
		vo.setAuthorNo(1L);
		vo.setCategoryNo(1L);
		
		int count = dao.update(vo);
		System.out.println("변경된 row 수 : " + count);
	}
	
	public static void testBookDaoDelete(){
		BookDao dao = new BookDao();
		int count = dao.delete(1L);
		System.out.println("삭제된 row 수 : " + count);
	}
	
	public static void testBookDaoInsert(){
		BookVo vo = new BookVo();
		vo.setTitle("트와일라잇");
		vo.setCost(25000);
		vo.setAuthorNo(1L);
		vo.setCategoryNo(1L);
		
		BookDao dao = new BookDao();
		dao.insert(vo);
		
		vo = new BookVo();
		vo.setTitle("뉴문");
		vo.setCost(20000);
		vo.setAuthorNo(1L);
		vo.setCategoryNo(1L);
		dao.insert(vo);
		
		vo = new BookVo();
		vo.setTitle("이클립스");
		vo.setCost(20000);
		vo.setAuthorNo(1L);
		vo.setCategoryNo(1L);
		dao.insert(vo);
		
		vo = new BookVo();
		vo.setTitle("브레이킹던");
		vo.setCost(20000);
		vo.setAuthorNo(1L);
		vo.setCategoryNo(1L);
		dao.insert(vo);
		
		vo = new BookVo();
		vo.setTitle("아리랑");
		vo.setCost(15000);
		vo.setAuthorNo(2L);
		vo.setCategoryNo(1L);
		dao.insert(vo);
		
		vo = new BookVo();
		vo.setTitle("젊은그들");
		vo.setCost(15000);
		vo.setAuthorNo(3L);
		vo.setCategoryNo(1L);
		dao.insert(vo);
		
		vo = new BookVo();
		vo.setTitle("아프니까 청춘이다");
		vo.setCost(15000);
		vo.setAuthorNo(4L);
		vo.setCategoryNo(2L);
		dao.insert(vo);
		
//		vo = new BookVo();
//		vo.setTitle("귀천");
//		vo.setRate(1);
//		vo.setStatus(0);
//		vo.setAuthorNo(5L);
//		dao.insert(vo);
//		
//		vo = new BookVo();
//		vo.setTitle("태백산맥");
//		vo.setRate(1);
//		vo.setStatus(0);
//		vo.setAuthorNo(2L);
//		dao.insert(vo);
//		
//		vo = new BookVo();
//		vo.setTitle("풀하우스");
//		vo.setRate(1);
//		vo.setStatus(0);
//		vo.setAuthorNo(6L);
//		dao.insert(vo);
	}
	
	public static void testBookDaoGetList(){
		BookDao dao = new BookDao();
		List<BookVo> list = dao.getList();
		
		for(BookVo vo : list){
			System.out.println(vo);
		}
	}
}
