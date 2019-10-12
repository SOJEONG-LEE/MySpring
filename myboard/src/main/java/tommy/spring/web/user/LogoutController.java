package tommy.spring.web.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {

	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		System.out.println("�α׾ƿ� ó��");
		session.invalidate();
		return "login.jsp";
	}

//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
//		System.out.println("�α׾ƿ� ó��");
//
//		// logout.jsp �ڵ�
//		// 1. �������� ����� ���� ��ü�� ����
//		HttpSession session = request.getSession(false);
//		session.invalidate();
//		
//		// 2. ���� ���� �� ���� ȭ������ �̵�
////		response.sendRedirect("login.jsp");
////		return "login";
//		ModelAndView mav = new ModelAndView();
////		mav.setViewName("login.jsp");
//		mav.setViewName("redirect:login.jsp");
//		return mav;
//	}

}
