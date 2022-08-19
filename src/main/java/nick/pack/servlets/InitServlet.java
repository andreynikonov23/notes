package nick.pack.servlets;

import java.io.IOException;
import java.io.PrintWriter;
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

public class InitServlet extends HttpServlet {
	
	private static Logger logger = Logger.getLogger(InitServlet.class);
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		logger.debug(": /init - request" + ": " + InitServlet.class + " checked session");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user == null) {
			logger.debug(": session not found, redirect in /signin");
			response.sendRedirect("/notes/signin");
		} else {
			logger.debug(": session found, user - " + user);
			response.sendRedirect("/notes/main");
		}
	}
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		
	}
}
