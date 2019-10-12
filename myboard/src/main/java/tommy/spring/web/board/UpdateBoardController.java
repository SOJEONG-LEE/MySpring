package tommy.spring.web.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import tommy.spring.web.board.impl.BoardDAO;
@Deprecated
//@Controller
public class UpdateBoardController {

	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("글 수정 기능 처리");
		boardDAO.updateBoard(vo);
		return "getBoardList.do";
	}

//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
//		System.out.println("글 수정 처리");
//
//		// updateBoardProc.jsp 코드
//		// 1. 사용자 입력 정보 추출
////		request.setCharacterEncoding("UTF-8");
//		String title = request.getParameter("title");
//		String content = request.getParameter("content");
//		String seq = request.getParameter("seq");
//
//		// 2. 데이터베이스 연동 처리
//		BoardVO vo = new BoardVO();
//		vo.setTitle(title);
//		vo.setContent(content);
//		vo.setSeq(Integer.parseInt(seq));
//		BoardDAO boardDAO = new BoardDAO();
//		boardDAO.updateBoard(vo);
//
//		// 3. 화면 네비게이션
////		response.sendRedirect("getBoardList.do");
////		return "getBoardList.do";
//		ModelAndView mav = new ModelAndView();
////		mav.setViewName("getBoardList.do");
//		mav.setViewName("redirect:getBoardList.do");
//		return mav;
//
//	}

}
