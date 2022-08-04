package dao;

import java.sql.*;
import java.util.*;

import db.*;
import vo.*;

public class NoticeDAO {
	// 싱글톤
	private static NoticeDAO instance = new NoticeDAO();
	public NoticeDAO ()	{}
	public static  NoticeDAO getInstance() {
		return instance;
	}

	// 외부로부터 Connection 객체를 전달받아 관리하기 위해
	// Connection 타입 멤버변수와 Setter 메서드 정의
	private Connection con;
	public final void setConnection(Connection con) {
		this.con = con;
	}
	
	
	public int selectListcount() {
		System.out.println("NoticeDAO - selectListCount");
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT COUNT(*) FROM noticeBoard";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
			System.out.println("listCount : " + listCount);
		} catch (SQLException e) {
			System.out.println("SQL 구문 오류 발생! -  " + e.getMessage());
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		return listCount;
	}

	public ArrayList<NoticeDTO> selectNoticeList(int pageNum, int listLimit) {
		ArrayList<NoticeDTO> list = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int startRow = (pageNum- 1) * listLimit;
		
		try {
			String sql = "SELECT * FROM noticeBoard ORDER BY idx DESC LIMIT ?,?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, listLimit);
			rs = pstmt.executeQuery();
			
			list = new ArrayList<NoticeDTO>();
			
			while(rs.next()) {
				NoticeDTO notice = new NoticeDTO();
				notice.setContent(rs.getString("content"));
				notice.setDate(rs.getDate("date"));
				notice.setIdx(rs.getInt("idx"));
				notice.setName(rs.getString("name"));
				notice.setOriginal_file(rs.getString("original_file"));
				notice.setPasswd(rs.getString("passwd"));
				notice.setReal_file(rs.getString("real_file"));
				notice.setSubject(rs.getString("subject"));
				
				
				list.add(notice);
			}
			System.out.println("list : " + list);
		} catch (SQLException e) {
			System.out.println("SQL 구문 오류 발생! -  " + e.getMessage());
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return list;
	}
	public int insertNotice(NoticeDTO notice) {
		int insertCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int num = 1;
		
		try {
			String sql = "SELECT MAX(idx) FROM noticeBoard";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				num = rs.getInt(1) + 1; // 조회된 가장 큰 번호 + 1 값을 새 글 번호로 저장
			}
			
			// 전달받은 데이터를 board 테이블에 INSERT
			sql = "INSERT INTO noticeBoard VALUES (?,?,?,?,?,now(),?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, notice.getName());
			pstmt.setString(3, notice.getPasswd());
			pstmt.setString(4, notice.getSubject());
			pstmt.setString(5, notice.getContent());
			pstmt.setString(6, notice.getReal_file());
			pstmt.setString(7, notice.getOriginal_file());
			
			insertCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 구문 오류 발생! -  " + e.getMessage());
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		return insertCount;
	}
	public NoticeDTO selectBoard(int idx) {
		NoticeDTO notice = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM noticeboard WHERE idx=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				notice = new NoticeDTO();
				notice.setContent(rs.getString("content"));
				notice.setDate(rs.getDate("date"));
				notice.setIdx(rs.getInt("idx"));
				notice.setName(rs.getString("name"));
				notice.setOriginal_file(rs.getString("original_file"));
				notice.setPasswd(rs.getString("passwd"));
				notice.setReal_file(rs.getString("real_file"));
				notice.setSubject(rs.getString("subject"));
			}
			System.out.println("notice");
		} catch (SQLException e) {
			System.out.println("SQL 구문 오류 발생! selectBoard-  " + e.getMessage());
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return notice;
	}
	
	
	
}
