package com.javaex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestbookVo;

@Repository
public class GuestbookDao {

	// 필드
	@Autowired
	private DataSource dataSource;
	
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	// 생성자

	// 메소드 g/s

	// 메소드 일반

	private void getConnection() {
		// DB접속 기능
		try {
			
			conn = dataSource.getConnection();
			
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

	}

	// 자원정리
	private void close() {
		// 5. 자원정리
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
	}

	// 등록
	public int gbInsert(GuestbookVo guestbookVo) {

		int count = 0;

		// DB접속
		getConnection();

		try {
			String query = "insert into guestbook  values ( seq_no.nextval, ?, ?, ?, sysdate)";

			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, guestbookVo.getName());
			pstmt.setString(2, guestbookVo.getPassword());
			pstmt.setString(3, guestbookVo.getContent());
			

			count = pstmt.executeUpdate();

			// 결과처리
			System.out.println("[dao]" + count + "건 저장");

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

		// 자원정리
		close();
		return count;
	}
	
	
	//삭제
	public int gbDelete(int no, String password) {

		int count = 0;

		// DB접속
		getConnection();

		try {
			String query = " delete from guestbook where no = ?  and password = ? ";

			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no);
			pstmt.setString(2, password);

			count = pstmt.executeUpdate();

			// 결과처리
			System.out.println("[dao]" + count + "건 삭제");

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

		// 자원정리
		close();

		return count;

	}
	
	
	//리스트
	public List<GuestbookVo> getgdList(){
		List<GuestbookVo>gbList = new ArrayList<GuestbookVo>();
		
		//DB접속
		getConnection();
		
		try {
			String query= " select  no, name, password, content, reg_date from guestbook ";
			
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			//결과처리
			while(rs.next()) {
				int no = rs.getInt("no");
				String name = rs.getString("name");
				String password = rs.getString("password");
				String content = rs.getString("content");
				String reg_date = rs.getString("reg_date");
				
				GuestbookVo  vo = new GuestbookVo(no, name, password, content, reg_date);
				gbList.add(vo);
			}
			
		}catch (SQLException e) {
			System.out.println("error:" + e);
		}
		
		//자원정리
		close();
		return gbList;
		
	}
	
	
	
}
