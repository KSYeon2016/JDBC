package kr.ac.sungkyul.bookmaill.dao.test;

import java.util.List;

import kr.ac.sungkyul.bookmaill.dao.CartDao;
import kr.ac.sungkyul.bookmall.vo.CartVo;

public class CartDaoTest {

	public static void main(String[] args) {
		testCartDaoInsert();
		testCartDaoGetList();
	}
	
	public static void testCartDaoInsert(){
		CartVo vo = new CartVo();
		vo.setMemberNo(8L);
		vo.setBookNo(5L);
		vo.setNum(3);
		
		CartDao dao = new CartDao();
		dao.insert(vo);
	}
	
	public static void testCartDaoGetList(){
		CartDao dao = new CartDao();
		List<CartVo> list = dao.getList();
		
		for(CartVo vo : list){
			System.out.println(vo);
		}
	}
}
