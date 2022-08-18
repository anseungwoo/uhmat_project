package controller;



import java.io.*;

<<<<<<< HEAD
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import action.*;
import action.MateDetailAction;
=======
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.MateDeleteProAction;
import action.MateDetailAction;
import action.MateListAction;
import action.MateModifyFromAction;
import action.MateModifyProAction;
import action.MateReplyWriteAction;
>>>>>>> 12d6daae7722c81bcfb179bc331188d66ab1c611
import action.MateWriteProAction;
import action.TmiDeleteProAction;
import action.TmiDetailAction;
import action.TmiListAction;
import action.TmiModifyFormAction;
import action.TmiModifyProAction;
<<<<<<< HEAD
import action.TmiWirteProAction;
import vo.*;
=======
import action.TmiReplyDeleteAction;
import action.TmiReplyModifyFormAction;
import action.TmiReplyModifyProAction;
import action.TmiReplyWriteAction;
import action.TmiRereplyFormAction;
import action.TmiRereplyWriteProAction;
import action.TmiWriteProAction;
import vo.ActionForward;
>>>>>>> 12d6daae7722c81bcfb179bc331188d66ab1c611


// 어맛커뮤니티의 FrontController
/*
 * 1. 리스트
 * 2. 글 등록
 * 3. 글 상세페이지
 * 4. 글 수정
 * 5. 글 삭제
 * 6. 댓글
 * 7. 답글 (?)
 */

@WebServlet("*.co")

public class CommunityFrontController extends HttpServlet {
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("CommunityFrontController");
		
		// POST 방식 요청에 대한 한글 처리
		request.setCharacterEncoding("UTF-8");
		
		// 서블릿 주소 추출
		String command = request.getServletPath();
		System.out.println("command : " + command);
		
		// Action 클래스 인스턴스들을 공통으로 관리하는 Action 타입 변수 선언
		Action action = null;
		// 포워딩 정보를 관리하는 ActionForward 타입 변수 선언
		ActionForward forward = null;
		

		// 추출된 서블릿 주소를 if문을 사용하여 판별하고 각 주소에 따른 액션(작업) 요청
		// 글쓰기 폼을 요청하는 서블릿(/MateWriteForm.co) 요청
<<<<<<< HEAD
		if(command.equals("/TmiList.co")) {
			// tmi 게시판 글 전체 목록 조회
			try { 
=======
		// 리스트를 요청하는 서블릿(/MateListForm.co) 요청
		if(command.equals("/MateList.co")) {
			action = new MateListAction();

			try {
>>>>>>> 12d6daae7722c81bcfb179bc331188d66ab1c611
				action = new TmiListAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("TmiListAction 오류 - " + e.getMessage());
				e.printStackTrace();
			}
			

		// -----------------------------------------------------------------	
		// 글쓰기 폼을 요청하는 서블릿(/MateWriteForm.co) 요청
		} else if(command.equals("/MateWriteForm.co")) {
			forward = new ActionForward();
			forward.setPath("community/mate/mate_write.jsp");
			forward.setRedirect(false); // Dispatcher 방식(생략 가능)
			

		} else if(command.equals("/MateWritePro.co")) {

			action = new MateWriteProAction();
			try {

				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("TmiWriteProAction 오류 - " + e.getMessage());

				e.printStackTrace();

						}
		} else if(command.equals("/MateWritePro.mate")) {
			action = new MateWriteProAction();
			try {

				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("TmiWriteProAction 오류 - " + e.getMessage());
				e.printStackTrace();

						}
		// ------------------------------------------------------------------
		// 글 디테일 뷰를 요청하는 서블릿(/MateDetail.co) 요청
		} else if(command.equals("/MateDetail.co")) {
			action = new MateDetailAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("MateDetailAction 오류 - " + e.getMessage());

				e.printStackTrace();

			}
			
		} else if(command.equals("/TmiDetail.co")) {
			// tmi 게시글 상세내용 보기
			try {
				action = new TmiDetailAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("TmiDetailAction 오류 - " + e.getMessage());
				e.printStackTrace();
			}
		// -----------------------------------------------------------------------
		// 글 수정에 필요한 게시물 조회 요청하는 서블릿(/MateModifyForm.co) 요청
		} else if(command.equals("/MateModifyForm.co")) {
			action = new MateModifyFromAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("MateModifyFromAction 오류 - " + e.getMessage());
				e.printStackTrace();
			}
					
		} else if(command.equals("/MateModifyPro.co")) {
			action = new MateModifyProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("MateModifyProAction 오류 - " + e.getMessage());
				e.printStackTrace();
			}
		// --------------------------------------------------------------------------
		// 글 삭제 폼 이동
		} else if(command.equals("/MateDeleteForm.co")) {
			forward = new ActionForward();
			forward.setPath("community/mate/mate_delete.jsp");
			forward.setRedirect(false);
			

		} else if(command.equals("/MateDeletePro.co")) {
			action = new MateDeleteProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("MateDeleteProAction 오류 - " + e.getMessage());
				e.printStackTrace();
			}
			
		// -----------------------------------------------------------------------------
		// 댓글 폼 요청
		} else if(command.equals("/MateReplyForm.co")) {
			forward = new ActionForward();
			forward.setPath("community/mate/mate_replyForm.jsp");
			forward.setRedirect(false);
		// 댓글 쓰기
		} else if(command.equals("/MateReplyWrite.co")){
			action = new MateReplyWriteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("MateReplyProAction 오류 - " + e.getMessage());
				e.printStackTrace();
			} 
		}	else if(command.equals("/MateDeleteForm.co")) {
				forward = new ActionForward();
				forward.setPath("community/mate/mate_delete.jsp");
				forward.setRedirect(false);
				
		} else if(command.equals("/MateDeletePro.co")) {
			action = new MateDeleteProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("MateDeleteProAction 오류 - " + e.getMessage());
				e.printStackTrace();
			}
		
		}
		//-------------------------------------------------
		// Tmi 서블릿 요청 시작
		 else if (command.equals("/TmiList.co")) {
			System.out.println("게시물 전체목록 조회");
			try {
				action = new TmiListAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("TmiListAction 오류 - " + e.getMessage());
				e.printStackTrace();
			}
			
		} else if(command.equals("/TmiWriteForm.co")) {
			System.out.println("게시물 작성 작업");
			forward = new ActionForward();
			forward.setPath("community/tmiWrite.jsp");
			forward.setRedirect(false);
			
		} else if(command.equals("/TmiWritePro.co")) {
			System.out.println("게시물 작성 요청");
			try {
				action = new TmiWriteProAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("TmiWriteProAction 오류 - " + e.getMessage());
				e.printStackTrace();
			}
			
		} else if(command.equals("/TmiDetail.co")) {
			System.out.println("게시물 상세 내용 조회");
			try {
				action = new TmiDetailAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("TmiDetailAction 오류 - " + e.getMessage());
				e.printStackTrace();
			}
			
		} else if(command.equals("/TmiModifyForm.co")) {
			System.out.println("게시물 수정 조회");

			try {
				action = new TmiModifyFormAction();
				forward = action.execute(request, response); 
			} catch (Exception e) {
				System.out.println("TmiModifyFormAction 오류 - " + e.getMessage());
				e.printStackTrace();
			}

			
		} else if(command.equals("/TmiModifyPro.co")) {
			System.out.println("게시글 수정 요청");

			try {
				action = new TmiModifyProAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("TmiModifyProAction 오류 - " + e.getMessage());
				e.printStackTrace();
			}

			
		} else if(command.equals("/TmiDeleteForm.co")) {
			System.out.println("게시물 삭제 조회");
			forward = new ActionForward();
			forward.setPath("community/tmiDelete.jsp");
			forward.setRedirect(false);
			
		} else if(command.equals("/TmiDeletePro.co")) {
			System.out.println("댓글 삭제 요청");
			try {
				action = new TmiDeleteProAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("TmiDeleteProAction 오류 - " + e.getMessage());
				e.printStackTrace();
			}
		
		} else if(command.equals("/TmiReplyWrite.co")) {
			System.out.println("댓글 작성 작업");
			try {
				action = new TmiReplyWriteAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if(command.equals("/TmiReplyList.co")) {
			System.out.println("댓글 리스트 조회");
			
			// Tmi 상세 내용 페이지에서 댓글 리스트 작업 처리
			try {
				action = new TmiDetailAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("TmiDetailAction(댓글리스트) 오류 - " + e.getMessage());
				e.printStackTrace();
			}
		} else if(command.equals("/TmiReplyModifyForm.co")) {
			System.out.println("댓글 수정 작업");
			try {
				action = new TmiReplyModifyFormAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("TmiReplyModifyFormAction 오류 - " + e.getMessage());
				e.printStackTrace();
			}
		}
		else if(command.equals("/TmiReplyModifyPro.co")) {
			System.out.println("댓글 수정 요청 작업");
			try {
				action = new TmiReplyModifyProAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("TmiReplyModifyProAction 오류 - " + e.getMessage());
				e.printStackTrace();
			}
		} else if(command.equals("/TmiReplyDeleteForm.co")) {
			System.out.println("댓글 삭제 작업");
			forward = new ActionForward();
			forward.setPath("/community/tmiReplyDelete.jsp");
			forward.setRedirect(false);
		} else if(command.equals("/TmiReplyDeletePro.co")) {
			System.out.println("댓글 삭제 요청 작업");
			try {
				action = new TmiReplyDeleteAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("TmiReplyDeleteAction 오류 - " + e.getMessage());
			}
		} else if(command.equals("/TmiRereplyWriteForm.co")) {
			System.out.println("답글 작성 작업");
			try {
				action = new TmiRereplyFormAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("TmiRereplyWriteForm 오류 - " + e.getMessage());
			}
		} else if(command.equals("/TmiRereplyWritePro.co")) {
			System.out.println("답글 작성 작업 요청");
			try {
				action = new TmiRereplyWriteProAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("TmiRereplyWriteProAction 오류 - " + e.getMessage());
			}
		} else if(command.equals("/TmiRereplyList.co")) {
			System.out.println("답글 리스트 조회");
			
			// Tmi 상세 내용 페이지에서 답글 리스트 작업 처리
			try {
				action = new TmiDetailAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("TmiDetailAction(답글리스트) 오류 - " + e.getMessage());
				e.printStackTrace();
			}
		}
		// ------------------------------------------------------------------
		// ActionFoward 객체에 저장된 포워딩 정보에 따른 포워딩 작업을 수행하기 위한 공통코드 작성
		if(forward != null) {
			if(forward.isRedirect()) {

				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
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

