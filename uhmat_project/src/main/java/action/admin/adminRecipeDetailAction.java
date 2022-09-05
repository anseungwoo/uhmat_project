package action.admin;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.community.RecipeDetailService;
import vo.ActionForward;
import vo.RecipeDTO;
import vo.RecipeReplyDTO;

public class adminRecipeDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("RecipeDetailAction");
		
		ActionForward forward = null;
		 
		// request 객체를 통해 전달받은 파라미터(idx) 가져오기
		int idx = Integer.parseInt(request.getParameter("idx"));
//		System.out.println("idx : " + idx);
		
		// RecipeDetailService 인스턴스 생성 후 increaseRecipeReadcount 메서드 호출하여 조회수 증가 요청
		// => 파라미터 : 글번호(idx)   리턴타입 : void
		RecipeDetailService service = new RecipeDetailService();
		service.increaseRecipeReadcount(idx);
		
		// getRecipe() 메서드 호출하여 글 상세정보 조회 요청
		// => 파라미터 : 글번호(idx)   리턴타입 : RecipeDTO(recipe)
		RecipeDTO recipe = service.getRecipe(idx);
		
		// 조회 결과(1개 게시물 정보 = RecipeDTO 객체)를 request 객체에 저장
		request.setAttribute("recipe", recipe);
		
		// 댓글 리스트
		ArrayList<RecipeReplyDTO> recipeReplyList = service.getRecipeReply(idx);
		
		request.setAttribute("recipeReplyList", recipeReplyList);
		
		// ActionForward 객체를 활용하여 recipe 디렉토리의 recipe_view.jsp 페이지 포워딩 설정
		forward = new ActionForward();
		forward.setPath("admin/recipeDtail.jsp");
		forward.setRedirect(false);
		
		
		return forward;
	}

}
