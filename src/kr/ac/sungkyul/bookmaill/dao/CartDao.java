package kr.ac.sungkyul.bookmaill.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.ac.sungkyul.bookmall.vo.CartVo;

public class CartDao {
	public int insert(CartVo vo){
		int count = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			// 1. 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. 연결 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 연결 url
			conn = DriverManager.getConnection(url, "skudb", "skudb");
			
			// 3. statement 준비
			String sql = "insert into cart "
					+ "		values(?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			// 4. 바인딩
			pstmt.setLong(1, vo.getBookNo());
			pstmt.setInt(2, vo.getNum());
//			pstmt.setString(3, vo.getNum() + "*(select cost from book where no = " + vo.getBookNo());
			pstmt.setLong(3, vo.getMemberNo());
			
			// 5. query 실행
			count = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패 : " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				// 6. 자원 정리
				if(pstmt != null){
					pstmt.close();
				}
				
				if(conn != null){
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error:" + e);
			}
		}

		return count;
	}
	
	public List<CartVo> getList(){
		List<CartVo> list = new ArrayList<CartVo>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			// 1. 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. 연결 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 연결 url
			conn = DriverManager.getConnection(url, "skudb", "skudb");
			
			// 3. statement 생성
			stmt = conn.createStatement();
			
			// 4. SQL문 실행
			String sql = "select m.NAME, b.TITLE, c.NUM"
					+ "		from CART c, BOOK b, MEMBER m "
					+ "		where c.BOOK_NO = b.NO and c.MEMBER_NO = m.NO";
			rs = stmt.executeQuery(sql);
			
			// 5. 결과 처리
			while(rs.next()){
				String memberName = rs.getString(1);
				String bookTitle = rs.getString(2);
				Integer num = rs.getInt(3);
				
				CartVo vo = new CartVo();
				vo.setMemberName(memberName);
				vo.setBookTitle(bookTitle);
				vo.setNum(num);
				
				list.add(vo);
			}
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패 : " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				// 6. 자원 정리
				if(rs != null){
					rs.close();
				}
				
				if(stmt != null){
					stmt.close();
				}
				
				if(conn != null){
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error:" + e);
			}
		}
		
		return list;
	}
}
