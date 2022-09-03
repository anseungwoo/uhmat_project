package action.serviceCenter;

import javax.servlet.http.*;

import action.Action;
import svc.*;
import vo.*;

public class NoticeDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		NoticeDetailService service = new NoticeDetailService();
		
		NoticeDTO notice = service.getNotice(idx);
		
		request.setAttribute("notice", notice);
		
		forward = new ActionForward();
		forward.setPath("serviceCenter/notice/noticeDetail.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
