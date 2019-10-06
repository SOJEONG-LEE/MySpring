package tommy.spring.web.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import tommy.spring.web.board.impl.BoardDAO;

public class GetBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 상세 보기 처리");

		// getBoard.jsp 코드
		// 1. 검색할 게시글 번호 추출
		String seq = request.getParameter("seq");

		// 2. 데이터베이스 연동 처리
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
		BoardDAO boardDAO = new BoardDAO();
		BoardVO board = boardDAO.getBoard(vo);

		// 3. 응답 화면 구현
//		HttpSession session = request.getSession();
//		session.setAttribute("board", board);
//		response.sendRedirect("getBoard.jsp");
//		return "getBoard";
		ModelAndView mav = new ModelAndView();
		mav.addObject("board", board);
//		mav.setViewName("getBoard.jsp");
		mav.setViewName("getBoard");
		return mav;

	}

}
