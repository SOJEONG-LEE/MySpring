package tommy.spring.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Deprecated
public interface Controller {
	String handleRequest(HttpServletRequest request, HttpServletResponse response);
}
