package tommy.spring.web.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import tommy.spring.web.user.impl.UserDAO;

public class LoginController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("�α��� ó��");
		
		// loginProc.jsp
		// 1. ����� �Է� ���� ����
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		// 2. �����ͺ��̽� ���� ó��
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		UserDAO userDAO = new UserDAO();
		UserVO user = userDAO.getUser(vo);
		
		// 3. ȭ�� �׺���̼�
		ModelAndView mav = new ModelAndView();
		if (user != null) {
//			response.sendRedirect("getBoardList.do");
//			return "getBoardList.do";
//			mav.setViewName("getBoardList.do");
			//  redirect: �� �ٿ� �ִٸ� ViewResolver�� �����Ǿ� �ִ��� �̸� �����ϰ� �����̷�Ʈ �Ѵ�.
			mav.setViewName("redirect:getBoardList.do");
		} else {
//			response.sendRedirect("login.jsp");
//			return "login";
//			mav.setViewName("login.jsp");
			mav.setViewName("redirect:login.jsp");

		}
		
		return mav;
	}

}