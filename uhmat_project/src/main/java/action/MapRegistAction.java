package action;

import javax.servlet.http.*;

import vo.*;

public class MapRegistAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		String resName = request.getParameter("resName");
		double latitude = Integer.parseInt(request.getParameter("latitude"));
		double logitude = Integer.parseInt(request.getParameter("logitude"));
		
		System.out.println("resName : " + resName + ", latitude : " + latitude + ", logitude : "+ logitude);
		
		return forward;
	}

}
