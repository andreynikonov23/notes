package nick.pack.servlets;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import nick.pack.data.DAO;
import nick.pack.data.EntityList;
import nick.pack.data.UserDataBase;
import nick.pack.models.User;

public class SignUpController extends HttpServlet {
	private static final Logger logger = Logger.getLogger(SignUpController.class);
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		logger.debug(": /registration - request POST-method " + SignUpController.class);
		String isoName = request.getParameter("name");
		Charset charset = Charset.forName("ISO-8859-1");
		byte[] bytes = isoName.getBytes(charset);
		String name = new String(bytes);
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		boolean loginValid = true;
		boolean passwordValid = true;
		String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
		for (User user : EntityList.userList) {
			if (user.getLogin().equals(login)) {
				loginValid = false;
				response.sendRedirect("/error");
			}
			if (!user.getPassword().matches(pattern)) {
				passwordValid = false;
				response.sendRedirect("/error")
			}
		}
		if (loginValid) {
			User user = new User(name, login, password);
			DAO<User> dao = new UserDataBase();
			dao.insert(user);
			logger.debug("user - " + name + " -- " + login + " is registred");
			response.sendRedirect("/notes/signin");
		}
	}
}
