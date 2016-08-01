package kr.ac.sungkyul.bookmaill.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.ac.sungkyul.bookmall.vo.OrdersVo;

public class OrdersDao {
	public int insert(OrdersVo vo){
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
			String sql = "insert into orders values(seq_orders.nextval, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			// 4. 바인딩
			pstmt.setLong(1, vo.getMemberNo());
			pstmt.setInt(2, vo.getCost());
			pstmt.setString(3, vo.getAddress());
			
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
	
	public List<OrdersVo> getList(){
		List<OrdersVo> list = new ArrayList<OrdersVo>();
		
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
			String sql = "select o.NO, m.NAME, m.EMAIL, o.COST, o.ADDRESS "
					+ "		from ORDERS o, MEMBER m "
					+ "		where o.MEMBER_NO = m.NO";
			rs = stmt.executeQuery(sql);
			
			// 5. 결과 처리
			while(rs.next()){
				Long no = rs.getLong(1);
				String memberName = rs.getString(2);
				String memberEmail = rs.getString(3);
				Integer cost = rs.getInt(4);
				String address = rs.getString(5);
				
				OrdersVo vo = new OrdersVo();
				vo.setNo((long)no);
				vo.setMemberName(memberName);
				vo.setMemberEmail(memberEmail);
				vo.setCost(cost);
				vo.setAddress(address);
				
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
