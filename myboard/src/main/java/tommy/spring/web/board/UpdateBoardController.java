package tommy.spring.web.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import tommy.spring.web.board.impl.BoardDAO;
@Deprecated
//@Controller
public class UpdateBoardController {

	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("�� ���� ��� ó��");
		boardDAO.updateBoard(vo);
		return "getBoardList.do";
	}

//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
//		System.out.println("�� ���� ó��");
//
//		// updateBoardProc.jsp �ڵ�
//		// 1. ����� �Է� ���� ����
////		request.setCharacterEncoding("UTF-8");
//		String title = request.getParameter("title");
//		String content = request.getParameter("content");
//		String seq = request.getParameter("seq");
//
//		// 2. �����ͺ��̽� ���� ó��
//		BoardVO vo = new BoardVO();
//		vo.setTitle(title);
//		vo.setContent(content);
//		vo.setSeq(Integer.parseInt(seq));
//		BoardDAO boardDAO = new BoardDAO();
//		boardDAO.updateBoard(vo);
//
//		// 3. ȭ�� �׺���̼�
////		response.sendRedirect("getBoardList.do");
////		return "getBoardList.do";
//		ModelAndView mav = new ModelAndView();
////		mav.setViewName("getBoardList.do");
//		mav.setViewName("redirect:getBoardList.do");
//		return mav;
//
//	}

}
