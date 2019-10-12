package tommy.spring.web.board;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import tommy.spring.web.board.impl.BoardDAO;
@Deprecated
// ModelAndView �����
//@Controller
public class BoardControllerModelAndView {

	// Controller ������̼� ����ϴ� ���
	// @RequestMapping: HandlerMapping�� ������ش�.
	@RequestMapping("/insertBoard.do")
	// DAO ��ü ���� Command ��ü�� ���������� �Ű����� �����ϸ� ������ �����̳ʰ� �ش� ��ü�� �����Ͽ� �������ش�.
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("�� ��� ó��");
		boardDAO.insertBoard(vo);
		return "getBoardList.do";
	}

	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("�� ���� ��� ó��");
		boardDAO.updateBoard(vo);
		return "getBoardList.do";
	}

	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("�� ���� ó��");
		boardDAO.deleteBoard(vo);
		return "getBoardList.do";
	}

	@RequestMapping("/getBoard.do")
	public ModelAndView getBoard(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		System.out.println("�� �� ���� ó��");
		mav.addObject("board", boardDAO.getBoard(vo));
		mav.setViewName("getBoard.jsp");
		return mav;
	}

	@RequestMapping("/getBoardList.do")
	public ModelAndView getBoardList(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		System.out.println("�� ��� �˻� ó��");
//		model.addAttribute("boardList", boardDAO.getBoardList(vo));
//		return "getBoardList.jsp";
		mav.addObject("boardList", boardDAO.getBoardList(vo)); // Model ��������
		mav.setViewName("getBoardList.jsp"); // View ��������
		return mav;
	}

}
