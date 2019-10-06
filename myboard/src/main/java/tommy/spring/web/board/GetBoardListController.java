package tommy.spring.web.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import tommy.spring.web.board.impl.BoardDAO;

@Controller
public class GetBoardListController {

	@RequestMapping("/getBoardList.do")
	public ModelAndView getBoardList(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		System.out.println("�� ��� �˻� ó��");
		mav.addObject("boardList", boardDAO.getBoardList(vo)); // Model ��������
		mav.setViewName("getBoardList.jsp"); // View ��������
		return mav;
	}


/*
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("�� ��� �˻� ó��");
		// getBoardList.jsp �ڵ�

		// 1. ����� �Է� ���� ���� : �˻� ����� ���߿� ����

		// 2. �����ͺ��̽� ���� ó��
		BoardVO vo = new BoardVO();
		BoardDAO boardDAO = new BoardDAO();
		List<BoardVO> boardList = boardDAO.getBoardList(vo);

		// 3. ���� ȭ�� ����
//		HttpSession session = request.getSession();
//		session.setAttribute("boardList", boardList);
//		response.sendRedirect("getBoardList.jsp");
//		return "getBoardList";
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardList", boardList); // Model ��������
//		mav.setViewName("getBoardList.jsp"); // View ��������
		mav.setViewName("getBoardList");
		return mav;

	}
*/

}
