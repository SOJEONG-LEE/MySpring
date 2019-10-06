package tommy.spring.web.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import tommy.spring.web.board.impl.BoardDAO;

public class DeleteBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("�� ���� ó��");

		// deleteBoardProc.jsp �ڵ�
		// 1. ����� �Է� ���� ����
		String seq = request.getParameter("seq");
		
		// 2. �����ͺ��̽� ���� ó��
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.deleteBoard(vo);
		
		// 3. ȭ�� �׺���̼�
//		response.sendRedirect("getBoardList.do");
//		return "getBoardList.do";
		ModelAndView mav = new ModelAndView();
//		mav.setViewName("getBoardList.do");
		mav.setViewName("redirect:getBoardList.do");
		return mav;
	}

}
