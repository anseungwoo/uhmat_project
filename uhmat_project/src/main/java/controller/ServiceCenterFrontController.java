package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.*;
import vo.*;

@WebServlet("*.sc")
public class ServiceCenterFrontController extends HttpServlet {
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ServiceCenterFrontController");
		request.setCharacterEncoding("UTF-8");
		
		String command = request.getServletPath();
		System.out.println("command : " + command );
		ActionForward forward = null;
		Action action = null;
		
		if (command.equals("/NoticeList.sc")) {
			try {
				action = new NoticeListAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if(command.equals("/NoticeWriteForm.sc")) {
			forward = new ActionForward();
			forward.setPath("serviceCenter/notice/noticeWriteForm.jsp");
			forward.setRedirect(false);
			
		} else if(command.equals("/NoticeWritePro.sc")) {
			try {
				action = new NoticeWriteProAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if(command.equals("/NoticeDetail.sc")) {
			try {
				action = new NoticeDetailAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				request.getRequestDispatcher(forward.getPath()).forward(request, response);
			}
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
