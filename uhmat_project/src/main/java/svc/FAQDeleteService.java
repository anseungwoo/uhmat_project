package svc;

import java.sql.*;

import dao.*;
import db.*;

public class FAQDeleteService {

	public boolean removeFAQ(int idx) {
//		System.out.println("FAQDeleteService - removeFAQ");
		boolean deleteSuccess = false;
		
		Connection con = JdbcUtil.getConnection();
		
		FAQDAO dao = FAQDAO.getInstance();
		
		dao.setConnection(con);
		
		deleteSuccess = dao.deleteFAQ(idx);
//		System.out.println("deleteSuccess : "+ deleteSuccess);
		
		if(!deleteSuccess) {
			JdbcUtil.commit(con);
		} else {
			JdbcUtil.rollback(con);
		}
		
		return deleteSuccess;
	}

}
