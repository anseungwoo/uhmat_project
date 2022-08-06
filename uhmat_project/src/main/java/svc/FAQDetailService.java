package svc;

import java.sql.*;

import dao.*;
import db.*;
import vo.*;

public class FAQDetailService {

	public void increaseReadcount(int idx) {
		FAQDTO notice = null;
		
		Connection con = JdbcUtil.getConnection();
		
		FAQDAO dao = FAQDAO.getInstance();
		
		dao.setConnection(con);
		
		dao.updateReadCount(idx);
		
		JdbcUtil.commit(con);
		
		JdbcUtil.close(con);
		
	}
	
	public FAQDTO getFAQ(int idx) {
//		System.out.println("NoticeDetailService - getNoticeBoard");
		FAQDTO notice = null;
		
		Connection con = JdbcUtil.getConnection();
		
		FAQDAO dao = FAQDAO.getInstance();
		
		dao.setConnection(con);
		
		notice = dao.selectFAQ(idx);
//		System.out.println("notice : " + notice);
		
		JdbcUtil.close(con);
		
		return notice;
	}


}
