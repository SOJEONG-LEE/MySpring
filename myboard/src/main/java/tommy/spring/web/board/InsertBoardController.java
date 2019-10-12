package tommy.spring.web.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import tommy.spring.web.board.impl.BoardDAO;
@Deprecated
//@Controller
public class InsertBoardController {
	
	// Controller 어노테이션 사용하는 경우
	@RequestMapping("/insertBoard.do")
	// DAO 객체 역시 Command 객체와 마찬가지로 매개변수 선언하면 스프링 컨테이너가 해당 객체를 생성하여 전달해준다.
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		
		System.out.println("글 등록 처리");

		// 1. 사용자 입력 정보 추출 : 커맨드 객체가 자동으로 처리해 줌. 
		// insertBoardProc.jsp 코드
		// 1. 사용자 입력 정보 추출
//		request.setCharacterEncoding("UTF-8");
//		String title = request.getParameter("title");
//		String writer = request.getParameter("writer");
//		String content = request.getParameter("content");

		// 2. 데이터베이스 연동 처리
//		BoardVO vo = new BoardVO();
//		vo.setTitle(title);
//		vo.setWriter(writer);
//		vo.setContent(content);
//		BoardDAO boardDAO = new BoardDAO();
		boardDAO.insertBoard(vo);

		// 3. 화면 네비게이션
//		response.sendRedirect("getBoardList.do");
//		return "getBoardList.do";
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("getBoardList.do");
//		mav.setViewName("redirect:getBoardList.do");
//		return mav;
		
		return "getBoardList.do";
		
	}

/* Controller 인터페이스 상속받을 경우
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 등록 처리");

		// insertBoardProc.jsp 코드
		// 1. 사용자 입력 정보 추출
//		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");

		// 2. 데이터베이스 연동 처리
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setWriter(writer);
		vo.setContent(content);
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.insertBoard(vo);

		// 3. 화면 네비게이션
//		response.sendRedirect("getBoardList.do");
//		return "getBoardList.do";
		ModelAndView mav = new ModelAndView();
//		mav.setViewName("getBoardList.do");
		mav.setViewName("redirect:getBoardList.do");
		return mav;

	}
*/

}
