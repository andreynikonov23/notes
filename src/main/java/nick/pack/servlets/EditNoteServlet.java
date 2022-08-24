package nick.pack.servlets;

import java.io.IOException;
import java.nio.charset.Charset;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import nick.pack.data.DAO;
import nick.pack.data.NoteDataBase;
import nick.pack.models.Note;
import nick.pack.models.User;

public class EditNoteServlet extends HttpServlet {
	private Logger logger = Logger.getLogger(EditNoteServlet.class);
	
	
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		String idStr = request.getParameter("id");
		String isoName = request.getParameter("name");
		String isoText = request.getParameter("text");
		
		
		Charset charset = Charset.forName("ISO-8859-1");
		byte[] nameBytes = isoName.getBytes(charset);
		byte[] textBytes = isoText.getBytes(charset);
		
		int id = Integer.parseInt(idStr);
		String name = new String(nameBytes);
		String text = new String(textBytes);
		
		if (!(name.isEmpty() && text.isEmpty())) {
			logger.debug(": /edit - request POST-method " + EditNoteServlet.class + " --- user: " + user.getLogin());
			Note note = new Note(id, name, text, user);
			DAO<Note> dao = new NoteDataBase();
			dao.update(note);
			response.sendRedirect("/notes/main");
		} else
			logger.debug(": incorrect filling of the note updating form - user: " + user.getLogin());
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		
	}
}
