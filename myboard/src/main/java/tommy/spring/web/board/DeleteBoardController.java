package tommy.spring.web.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import tommy.spring.web.board.impl.BoardDAO;
@Deprecated
// 통합 Controller를 만들었기 때문에 개별적으로 만든 Controller 클래스는 삭제
//@Controller
public class DeleteBoardController {

	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("글 삭제 처리");
		boardDAO.deleteBoard(vo);
		return "getBoardList.do";
	}

//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
//		System.out.println("글 삭제 처리");
//
//		// deleteBoardProc.jsp 코드
//		// 1. 사용자 입력 정보 추출
//		String seq = request.getParameter("seq");
//		
//		// 2. 데이터베이스 연동 처리
//		BoardVO vo = new BoardVO();
//		vo.setSeq(Integer.parseInt(seq));
//		BoardDAO boardDAO = new BoardDAO();
//		boardDAO.deleteBoard(vo);
//		
//		// 3. 화면 네비게이션
////		response.sendRedirect("getBoardList.do");
////		return "getBoardList.do";
//		ModelAndView mav = new ModelAndView();
////		mav.setViewName("getBoardList.do");
//		mav.setViewName("redirect:getBoardList.do");
//		return mav;
//	}

}
