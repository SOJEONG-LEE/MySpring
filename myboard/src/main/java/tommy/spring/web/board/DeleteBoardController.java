package tommy.spring.web.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import tommy.spring.web.board.impl.BoardDAO;
@Deprecated
// ���� Controller�� ������� ������ ���������� ���� Controller Ŭ������ ����
//@Controller
public class DeleteBoardController {

	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("�� ���� ó��");
		boardDAO.deleteBoard(vo);
		return "getBoardList.do";
	}

//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
//		System.out.println("�� ���� ó��");
//
//		// deleteBoardProc.jsp �ڵ�
//		// 1. ����� �Է� ���� ����
//		String seq = request.getParameter("seq");
//		
//		// 2. �����ͺ��̽� ���� ó��
//		BoardVO vo = new BoardVO();
//		vo.setSeq(Integer.parseInt(seq));
//		BoardDAO boardDAO = new BoardDAO();
//		boardDAO.deleteBoard(vo);
//		
//		// 3. ȭ�� �׺���̼�
////		response.sendRedirect("getBoardList.do");
////		return "getBoardList.do";
//		ModelAndView mav = new ModelAndView();
////		mav.setViewName("getBoardList.do");
//		mav.setViewName("redirect:getBoardList.do");
//		return mav;
//	}

}
