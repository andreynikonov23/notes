package nick.pack.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import nick.pack.data.DAO;
import nick.pack.data.EntityList;
import nick.pack.data.NoteDataBase;
import nick.pack.models.Note;
import nick.pack.models.User;

public class DeleteNoteServlet extends HttpServlet {
	private Logger logger = Logger.getLogger(DeleteNoteServlet.class);
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		logger.debug(": /delete - request POST-method " + EditNoteServlet.class + " --- user: " + user.getLogin());
		int id = Integer.parseInt(request.getParameter("id"));
		Note note = EntityList.binarySearchNoteList(id);
		DAO<Note> dao = new NoteDataBase();
		dao.delete(note);
		response.sendRedirect("/notes/main");
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		
	}
}
