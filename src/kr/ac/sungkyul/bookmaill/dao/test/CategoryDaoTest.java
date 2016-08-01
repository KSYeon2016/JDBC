package kr.ac.sungkyul.bookmaill.dao.test;

import java.util.List;

import kr.ac.sungkyul.bookmaill.dao.CategoryDao;
import kr.ac.sungkyul.bookmall.vo.CategoryVo;

public class CategoryDaoTest {

	public static void main(String[] args) {
		//testCategoryDaoDeleteAll();
		//testCategoryDaoUpdate();
		//testCategoryDaoDelete();
		//testCategoryDaoInsert();
		testCategoryDaoGetList();
	}
	
	public static void testCategoryDaoDeleteAll(){
		CategoryDao dao = new CategoryDao();
		dao.delete();
		System.out.println("전체삭제");
	}
	
	public static void testCategoryDaoUpdate(){
		CategoryDao dao = new CategoryDao();
		
		CategoryVo vo = new CategoryVo();
		vo.setNo(1L);
		vo.setName("소설");
		
		int count = dao.update(vo);
		System.out.println("변경된 row 수 : " + count);
	}
	
	public static void testCategoryDaoDelete(){
		CategoryDao dao = new CategoryDao();
		int count = dao.delete(2L);
		System.out.println("삭제된 row 수 : " + count);
	}
	
	public static void testCategoryDaoInsert(){
		CategoryVo vo = new CategoryVo();
		vo.setName("소설");
		CategoryDao dao = new CategoryDao();
		dao.insert(vo);
		
		vo = new CategoryVo();
		vo.setName("수필");
		dao.insert(vo);
		
		vo = new CategoryVo();
		vo.setName("컴퓨터/IT");
		dao.insert(vo);
	}

	public static void testCategoryDaoGetList(){
		CategoryDao dao = new CategoryDao();
		List<CategoryVo> list = dao.getList();
		
		for(CategoryVo vo : list){
			System.out.println(vo);
		}
	}
}
