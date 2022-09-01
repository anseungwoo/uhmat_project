package action;

import java.util.*;

import javax.servlet.http.*;

import action.*;
import svc.*;
import vo.*;

public class MapAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("MapListAction");
		ActionForward forward = null;
		
		MapService service = new MapService();
		
		String keyword = request.getParameter("keyword");
		ArrayList<RestaurantInfoDTO> list = null;
		if(keyword!=null) {
			list = service.selectMapList(keyword);	//검색된 위치 정보만 조회
		}else{
			list = service.selectMapList();	//전체 위치정보 조회 
		}
		
		request.setAttribute("list", list);
		
		forward = new ActionForward();
		forward.setPath("food/map/map.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
