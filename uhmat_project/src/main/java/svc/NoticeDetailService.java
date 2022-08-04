package svc;

import java.sql.*;

import dao.*;
import db.*;
import vo.*;

public class NoticeDetailService {

	public NoticeDTO getNoticeBoard(int idx) {
		NoticeDTO notice = null;
		
		Connection con = JdbcUtil.getConnection();
		
		NoticeDAO dao = NoticeDAO.getInstance();
		
		dao.setConnection(con);
		
		notice = dao.selectBoard(idx);
				
		JdbcUtil.close(con);
		
		return notice;
	}

}
