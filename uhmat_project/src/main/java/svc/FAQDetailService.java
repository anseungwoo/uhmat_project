package svc;

import java.sql.*;

import dao.*;
import db.*;
import vo.*;

public class FAQDetailService {

	public FAQDTO getFAQBoard(int idx) {
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
