package nick.pack.servlets;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import nick.pack.models.Note;
import nick.pack.models.User;

public class SearchServlet  extends HttpServlet{
	private static Logger logger = Logger.getLogger(SearchServlet.class);
	private static final List<Note> result = new ArrayList<>();
	private static String search;
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		logger.debug(": User is " + user.getLogin() + " search note");
		
		String isoSearch = request.getParameter("search");
		
		Charset charset = Charset.forName("ISO-8859-1");
		byte[] bytes = isoSearch.getBytes(charset);
		
		search = new String(bytes);
		
		for(Note note : user.getNotes()) {
			if (note.getName().contains(search)) {
				result.add(note);
			}
		}
		
		response.sendRedirect("/notes/result");
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		
	}
	
	public static List<Note> getResult(){
		logger.debug("return static List notes for " + SearchServlet.class);
		return result;
	}
	public static String getSearchInfo() {
		logger.debug("return search info for " + SearchServlet.class);
		return search;
	}
	
}
