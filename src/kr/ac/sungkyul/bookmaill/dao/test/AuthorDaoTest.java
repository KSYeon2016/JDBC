package kr.ac.sungkyul.bookmaill.dao.test;

import java.util.List;

import kr.ac.sungkyul.bookmaill.dao.AuthorDao;
import kr.ac.sungkyul.bookmall.vo.AuthorVo;

public class AuthorDaoTest {

	public static void main(String[] args) {
		//testAuthorDaoInsert();
		//testAuthorDaoDelete();
		//testAuthorDaoUpdate();
		//testAuthorDaoDeleteAll();
		testAuthorDaoGetList();
	}
	
	public static void testAuthorDaoDeleteAll(){
		AuthorDao dao = new AuthorDao();
		dao.delete();
		System.out.println("전체삭제");
	}
	
	public static void testAuthorDaoUpdate(){
		AuthorDao dao = new AuthorDao();
		
		AuthorVo vo = new AuthorVo();
		vo.setNo(6L);
		vo.setName("원수연2");
		vo.setDescription("가나다");
		
		dao.update(vo);
	}
	
	public static void testAuthorDaoDelete(){
		AuthorDao dao = new AuthorDao();
		int count = dao.delete(6L);
		System.out.println("삭제된 row 수 : " + count);
	}
	
	public static void testAuthorDaoGetList(){
		AuthorDao dao = new AuthorDao();
		List<AuthorVo> list = dao.getList();
		
		for(AuthorVo vo : list){
			System.out.println(vo);
		}
	}
	
	public static void testAuthorDaoInsert(){
		AuthorVo vo = new AuthorVo();
		vo.setName("스테파니 메이어");
		vo.setDescription("");
		AuthorDao dao = new AuthorDao();
		dao.insert(vo);
		
		vo = new AuthorVo();
		vo.setName("조정래");
		vo.setDescription("");
		dao.insert(vo);
		
		vo = new AuthorVo();
		vo.setName("김동인");
		vo.setDescription("");
		dao.insert(vo);
		
		vo = new AuthorVo();
		vo.setName("김난도");
		vo.setDescription("");
		dao.insert(vo);
		
		vo = new AuthorVo();
		vo.setName("천상병");
		vo.setDescription("");
		dao.insert(vo);
		
		vo = new AuthorVo();
		vo.setName("원수연");
		vo.setDescription("");
		dao.insert(vo);
	}
	
}
