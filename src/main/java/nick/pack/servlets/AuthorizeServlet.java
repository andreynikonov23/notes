package nick.pack.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import nick.pack.data.DAO;
import nick.pack.data.EntityList;
import nick.pack.data.NoteDataBase;
import nick.pack.data.UserDataBase;
import nick.pack.models.Note;
import nick.pack.models.User;

public class AuthorizeServlet extends HttpServlet {
	private static Logger logger = Logger.getLogger(AuthorizeServlet.class);
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		logger.debug(": /authorize request this is post-method" + " " + AuthorizeServlet.class);
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		System.out.println(login);
		System.out.println(password);
		boolean isTrue = false;
		logger.debug("Checked user");
		for (User user : EntityList.userList) {
			if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
				logger.debug(": user " + login + " is authorized");
				logger.debug(": redirect in /main");
				try {
					HttpSession session = request.getSession();
					session.setAttribute("user", user);
					response.sendRedirect("/notes/main");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					logger.error(e);
					e.printStackTrace();
				}
				isTrue = true;
				break;
			}
		}
		if (isTrue == false) {
			logger.debug(": invalid username or password - " + login);
			try {
				getServletContext().getRequestDispatcher("/err").forward(request, response);
			} catch (ServletException e) {
				logger.error(e);
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				logger.error(e);
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
