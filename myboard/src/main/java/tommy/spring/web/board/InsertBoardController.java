package tommy.spring.web.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import tommy.spring.web.board.impl.BoardDAO;
@Deprecated
//@Controller
public class InsertBoardController {
	
	// Controller ������̼� ����ϴ� ���
	@RequestMapping("/insertBoard.do")
	// DAO ��ü ���� Command ��ü�� ���������� �Ű����� �����ϸ� ������ �����̳ʰ� �ش� ��ü�� �����Ͽ� �������ش�.
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		
		System.out.println("�� ��� ó��");

		// 1. ����� �Է� ���� ���� : Ŀ�ǵ� ��ü�� �ڵ����� ó���� ��. 
		// insertBoardProc.jsp �ڵ�
		// 1. ����� �Է� ���� ����
//		request.setCharacterEncoding("UTF-8");
//		String title = request.getParameter("title");
//		String writer = request.getParameter("writer");
//		String content = request.getParameter("content");

		// 2. �����ͺ��̽� ���� ó��
//		BoardVO vo = new BoardVO();
//		vo.setTitle(title);
//		vo.setWriter(writer);
//		vo.setContent(content);
//		BoardDAO boardDAO = new BoardDAO();
		boardDAO.insertBoard(vo);

		// 3. ȭ�� �׺���̼�
//		response.sendRedirect("getBoardList.do");
//		return "getBoardList.do";
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("getBoardList.do");
//		mav.setViewName("redirect:getBoardList.do");
//		return mav;
		
		return "getBoardList.do";
		
	}

/* Controller �������̽� ��ӹ��� ���
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("�� ��� ó��");

		// insertBoardProc.jsp �ڵ�
		// 1. ����� �Է� ���� ����
//		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");

		// 2. �����ͺ��̽� ���� ó��
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setWriter(writer);
		vo.setContent(content);
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.insertBoard(vo);

		// 3. ȭ�� �׺���̼�
//		response.sendRedirect("getBoardList.do");
//		return "getBoardList.do";
		ModelAndView mav = new ModelAndView();
//		mav.setViewName("getBoardList.do");
		mav.setViewName("redirect:getBoardList.do");
		return mav;

	}
*/

}
