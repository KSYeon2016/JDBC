package kr.ac.sungkyul.bookmall.app;

import java.util.List;

import kr.ac.sungkyul.bookmaill.dao.BookDao;
import kr.ac.sungkyul.bookmaill.dao.MemberDao;
import kr.ac.sungkyul.bookmall.vo.BookVo;
import kr.ac.sungkyul.bookmall.vo.MemberVo;

public class BookMall {

	public static void main(String[] args) {
		System.out.println("1. 회원 리스트");
		displayMemberInfo();
		System.out.println("2. 카테고리 리스트");
		System.out.println("3. 상품 리스트");
		displayBookInfo();
		System.out.println("4. 카트 리스트");
		System.out.println("5. 주문 리스트");
		System.out.println("6. 주문 도서 리스트");
	}

	public static void displayBookInfo() {
		BookDao dao = new BookDao();
		List<BookVo> list = dao.getList();
		
		for(BookVo vo : list){
			System.out.println(vo);
		}
	}
	
	public static void displayMemberInfo() {
		MemberDao dao = new MemberDao();
		List<MemberVo> list = dao.getList();
		
		for(MemberVo vo : list){
			System.out.println(vo);
		}
	}
}
