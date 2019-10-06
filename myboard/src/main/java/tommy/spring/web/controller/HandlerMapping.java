package tommy.spring.web.controller;

import java.util.HashMap;
import java.util.Map;

import tommy.spring.web.board.DeleteBoardController;
import tommy.spring.web.board.GetBoardController;
import tommy.spring.web.board.GetBoardListController;
import tommy.spring.web.board.InsertBoardController;
import tommy.spring.web.board.UpdateBoardController;
import tommy.spring.web.user.LoginController;
import tommy.spring.web.user.LogoutController;

@Deprecated
public class HandlerMapping {

	private Map<String, Controller> mappings;

	public HandlerMapping() {
//		mappings = new HashMap<String, Controller>();
//		mappings.put("/login.do", new LoginController());
//		mappings.put("/getBoardList.do", new GetBoardListController());
//		mappings.put("/getBoard.do", new GetBoardController());
//		mappings.put("/insertBoard.do", new InsertBoardController());
//		mappings.put("/updateBoard.do", new UpdateBoardController());
//		mappings.put("/deleteBoard.do", new DeleteBoardController());
//		mappings.put("/logout.do", new LogoutController());

		// 나중에 이 부분에 명령어(path)와 Controller 객체가 추가됨.
	}

	public Controller getController(String path) {
		return mappings.get(path);
	}

}
