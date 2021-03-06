package kr.ac.sungkyul.bookmaill.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.ac.sungkyul.bookmall.vo.BookVo;

public class BookDao {
//	public int updateStatus(Long no, Integer status){
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		int count = 0;
//		
//		try {
//			// 1. 드라이버 로딩
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//
//			// 2. 연결 얻어오기
//			String url = "jdbc:oracle:thin:@localhost:1521:xe";
//			conn = DriverManager.getConnection(url, "skudb", "skudb");
//			
//			// 3. SQL 준비
//			String sql = "update book set status = ? where no = ?";
//			pstmt = conn.prepareStatement(sql);
//						
//			// 4. 바인딩
//			pstmt.setInt(1, status);
//			pstmt.setLong(2, no);
//						
//			// 5. SQL 실행
//			count = pstmt.executeUpdate();
//		} catch (ClassNotFoundException e) {
//			System.out.println("드라이버 로딩 실패 : " + e);
//		} catch (SQLException e) {
//			System.out.println("error:" + e);
//		} finally {
//			try {
//				// 6. 자원 정리
//				if(pstmt != null){
//					pstmt.close();
//				}
//				
//				if(conn != null){
//					conn.close();
//				}
//			} catch (SQLException e) {
//				System.out.println("error:" + e);
//			}
//		}
//		
//		return count;
//	}
	
	public int delete(){
		/*
		 * 전체 삭제
		 */
		Connection conn = null;
		Statement stmt = null;
		int count = 0;
		
		try{
			// 1. 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "skudb", "skudb");
			
			// 3. SQL 준비
			String sql = "delete from book";
			stmt = conn.createStatement();
			
			// 4. SQL 실행
			count = stmt.executeUpdate(sql);
		} catch(ClassNotFoundException e){
			System.out.println("드라이버를 찾을 수 없습니다 : " + e);
		} catch(SQLException e){
			System.out.println("error : " + e);
		} finally {
			try {
				if(stmt != null){
					stmt.close();
				}
				
				if(conn != null){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}
		
		return count;
	}
	
	public int update(BookVo vo){
		Connection conn = null;
		PreparedStatement pstmt = null;
		int count = 0;
		
		try{
			// 1. 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "skudb", "skudb");
			
			// 3. SQL 준비
			String sql = "update book "
					+ "		set title = ?, cost = ?, author_no = ?, category_no = ? "
					+ "		where no = ?";
			pstmt = conn.prepareStatement(sql);
			
			// 4. 바인딩
			pstmt.setString(1, vo.getTitle());
			pstmt.setInt(2, vo.getCost());
			pstmt.setLong(3, vo.getAuthorNo());
			pstmt.setLong(4, vo.getCategoryNo());
			pstmt.setLong(5, vo.getNo());
			
			// 5. SQL 실행
			count = pstmt.executeUpdate();
		} catch(ClassNotFoundException e){
			System.out.println("드라이버를 찾을 수 없습니다 : " + e);
		} catch(SQLException e){
			System.out.println("error : " + e);
		} finally {
			try {
				if(pstmt != null){
					pstmt.close();
				}
				
				if(conn != null){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}
		
		return count;
	}
	
	public int delete(Long no){
		Connection conn = null;
		PreparedStatement pstmt = null;
		int count = 0;
		
		try{
			// 1. 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "skudb", "skudb");
			
			// 3. SQL 준비
			String sql = "delete from book where no = ?";
			pstmt = conn.prepareStatement(sql);
			
			// 4. 바인딩
			pstmt.setLong(1, no);
			
			// 5. SQL 실행
			count = pstmt.executeUpdate();
		} catch(ClassNotFoundException e){
			System.out.println("드라이버를 찾을 수 없습니다 : " + e);
		} catch(SQLException e){
			System.out.println("error : " + e);
		} finally {
			try {
				if(pstmt != null){
					pstmt.close();
				}
				
				if(conn != null){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}
		
		return count;
	}
	
	public int insert(BookVo vo){
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
			String sql = "insert into book values(seq_book.nextval, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			// 4. 바인딩
			pstmt.setString(1, vo.getTitle());
			pstmt.setInt(2, vo.getCost());
			pstmt.setLong(3, vo.getAuthorNo());
			pstmt.setLong(4, vo.getCategoryNo());
			
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
	
	public List<BookVo> getList(){
		List<BookVo> list = new ArrayList<BookVo>();
		
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
			String sql = "select b.no, b.TITLE, b.COST, a.NAME, c.NAME "
					+ "		from BOOK b, AUTHOR a, CATEGORY c "
					+ "		where b.AUTHOR_NO = a.NO and b.CATEGORY_NO = c.NO";
			rs = stmt.executeQuery(sql);
			
			// 5. 결과 처리
			while(rs.next()){
				Integer no = rs.getInt(1);
				String title = rs.getString(2);
				Integer cost = rs.getInt(3);
				String authorName = rs.getString(4);
				String categoryName = rs.getString(5);
				
				BookVo vo = new BookVo();
				vo.setNo((long)no);
				vo.setTitle(title);
				vo.setCost(cost);
				vo.setAuthorName(authorName);
				vo.setCategoryName(categoryName);
				
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
