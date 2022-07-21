package nick.pack.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import nick.pack.models.User;

public class InitServlet extends HttpServlet {
	
	private static Logger logger = Logger.getLogger(InitServlet.class);
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user == null) {
			//авторизация
			//задать сессию
		} else {
			//проверка url
			//главное меню
		}
	}
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		
	}
}
