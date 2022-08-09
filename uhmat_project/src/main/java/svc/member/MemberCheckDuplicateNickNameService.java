package svc.member;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.MemberDAO;

public class MemberCheckDuplicateNickNameService {

	public boolean checkDuplicateNickName(String nickName) {
boolean isDuplicate = false;
		
		Connection con = getConnection();
		MemberDAO dao = MemberDAO.getInstance();
		dao.setConnection(con);
		
		// MemberDAO 의 selectDuplicateId() 메서드를 호출하여 아이디 검색 수행
		// => 파라미터 : 아이디(id)   리턴타입 : boolean(isDuplicate)
		isDuplicate = dao.selectDuplicateNickName(nickName);
		
		close(con);
		
		return isDuplicate;
	}

}