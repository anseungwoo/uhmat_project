package action;

import javax.servlet.http.*;

import vo.*;

public class FAQlistCategoryAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("FAQlistCategoryAction - execute");
		ActionForward forward = null;
		
		String category = request.getParameter("category");
		
		
		
		
		return forward;
	}

}
