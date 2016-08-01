package kr.ac.sungkyul.bookmaill.dao.test;

import java.util.List;

import kr.ac.sungkyul.bookmaill.dao.OrdersDao;
import kr.ac.sungkyul.bookmall.vo.OrdersVo;

public class OrdersDaoTest {

	public static void main(String[] args) {
		testOrdersDaoInsert();
		testOrdersDaoGetList();
	}
	
	public static void testOrdersDaoInsert(){
		OrdersVo vo = new OrdersVo();
		vo.setMemberNo(8L);
		vo.setCost(30000);
		vo.setAddress("asldfjlsakdf");
		
		OrdersDao dao = new OrdersDao();
		dao.insert(vo);
	}
	
	public static void testOrdersDaoGetList(){
		OrdersDao dao = new OrdersDao();
		List<OrdersVo> list = dao.getList();
		
		for(OrdersVo vo : list){
			System.out.println(vo);
		}
	}
}
