package svc;

import java.sql.*;

import dao.*;

import static db.JdbcUtil.*;
import vo.*;

public class MapWriteProService {

	public void insertMapInfo(MapDTO map) {
		System.out.println("MapWriteProService-insertMapInfo");
		System.out.println(map);
<<<<<<< HEAD
		
		Connection con = getConnection();
		
		RestaurantDAO dao = RestaurantDAO.getInstance();
		
		dao.setConnection(con);
		
		int insertCount = dao.insertMapInfo(map);
		
=======
		Connection con = getConnection();
		RestaurantDAO dao = RestaurantDAO.getInstance();
		dao.setConnection(con);
		int insertCount = dao.insertMapInfo(map);
>>>>>>> 12d6daae7722c81bcfb179bc331188d66ab1c611
		if(insertCount>0) {
			commit(con);
			System.out.println("지도 입력 성공!");
		}else {
			rollback(con);
			System.out.println("지도 입력 실패!");
		}
		
		close(con);
	}

<<<<<<< HEAD
}
=======
}
>>>>>>> 12d6daae7722c81bcfb179bc331188d66ab1c611
