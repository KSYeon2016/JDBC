package kr.ac.sungkyul.bookmaill.dao.test;

import java.util.List;

import kr.ac.sungkyul.bookmaill.dao.MemberDao;
import kr.ac.sungkyul.bookmall.vo.MemberVo;

public class MemberDaoTest {

	public static void main(String[] args) {
		testMemberDaoInsert();
		testMemberDaoGetList();
	}
	
	public static void testMemberDaoInsert(){
		MemberVo vo = new MemberVo();
		vo.setName("고객1");
		vo.setEmail("aa11@email.com");
		vo.setTel("12341242142");
		vo.setPw("alsasfkf");
		MemberDao dao = new MemberDao();
		dao.insert(vo);
		
		vo = new MemberVo();
		vo.setName("고객2");
		vo.setEmail("aa22@email.com");
		vo.setTel("24214234322");
		vo.setPw("aslkjfdla");
		dao.insert(vo);
		
		vo = new MemberVo();
		vo.setName("고객3");
		vo.setEmail("aa33@email.com");
		vo.setTel("29385394850");
		vo.setPw("alskjdflsa");
		dao.insert(vo);
	}
	
	public static void testMemberDaoGetList(){
		MemberDao dao = new MemberDao();
		List<MemberVo> list = dao.getList();
		
		for(MemberVo vo : list){
			System.out.println(vo);
		}
	}
}
