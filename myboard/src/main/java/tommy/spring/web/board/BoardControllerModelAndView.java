package tommy.spring.web.board;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import tommy.spring.web.board.impl.BoardDAO;
@Deprecated
// ModelAndView 사용방법
//@Controller
public class BoardControllerModelAndView {

	// Controller 어노테이션 사용하는 경우
	// @RequestMapping: HandlerMapping을 대신해준다.
	@RequestMapping("/insertBoard.do")
	// DAO 객체 역시 Command 객체와 마찬가지로 매개변수 선언하면 스프링 컨테이너가 해당 객체를 생성하여 전달해준다.
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("글 등록 처리");
		boardDAO.insertBoard(vo);
		return "getBoardList.do";
	}

	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("글 수정 기능 처리");
		boardDAO.updateBoard(vo);
		return "getBoardList.do";
	}

	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("글 삭제 처리");
		boardDAO.deleteBoard(vo);
		return "getBoardList.do";
	}

	@RequestMapping("/getBoard.do")
	public ModelAndView getBoard(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		System.out.println("글 상세 보기 처리");
		mav.addObject("board", boardDAO.getBoard(vo));
		mav.setViewName("getBoard.jsp");
		return mav;
	}

	@RequestMapping("/getBoardList.do")
	public ModelAndView getBoardList(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		System.out.println("글 목록 검색 처리");
//		model.addAttribute("boardList", boardDAO.getBoardList(vo));
//		return "getBoardList.jsp";
		mav.addObject("boardList", boardDAO.getBoardList(vo)); // Model 정보저장
		mav.setViewName("getBoardList.jsp"); // View 정보저장
		return mav;
	}

}
