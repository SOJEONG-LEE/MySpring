package tommy.spring.web.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import tommy.spring.web.user.impl.UserDAO;

public class LoginController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("로그인 처리");
		
		// loginProc.jsp
		// 1. 사용자 입력 정보 추출
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		// 2. 데이터베이스 연동 처리
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		UserDAO userDAO = new UserDAO();
		UserVO user = userDAO.getUser(vo);
		
		// 3. 화면 네비게이션
		ModelAndView mav = new ModelAndView();
		if (user != null) {
//			response.sendRedirect("getBoardList.do");
//			return "getBoardList.do";
//			mav.setViewName("getBoardList.do");
			//  redirect: 이 붙여 있다면 ViewResolver가 설정되어 있더라도 이를 무시하고 리다이렉트 한다.
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
