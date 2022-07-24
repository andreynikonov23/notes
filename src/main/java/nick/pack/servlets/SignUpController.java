package nick.pack.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import nick.pack.data.DAO;
import nick.pack.data.UserDataBase;
import nick.pack.models.User;

public class SignUpController extends HttpServlet {
	private static final Logger logger = Logger.getLogger(SignUpController.class);
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		logger.debug(": /registration - request POST-method " + SignUpController.class);
		String name = request.getParameter("name");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		User user = new User(name, login, password);
		DAO<User> dao = new UserDataBase();
		dao.insert(user);
		logger.debug("user -" + name + "--" + login + "is registred");
	}
}
