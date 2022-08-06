package action;

import javax.servlet.http.*;

import svc.*;
import vo.*;

public class FAQDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		System.out.println("FAQDetailAction - execute");
		ActionForward forward = null;
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		FAQDetailService service = new FAQDetailService();
		
		service.increaseReadcount(idx);
		
		FAQDTO faq = service.getFAQ(idx);
		
		request.setAttribute("faq", faq);
		
		forward = new ActionForward();
		forward.setPath("serviceCenter/faq/faqDetail.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
