package nick.pack.data;

import java.util.ArrayList;
import java.util.List;

import nick.pack.models.Note;
import nick.pack.models.User;

public class EntityList {
	public static final List<User> userList = new ArrayList<>();
	public static final List<Note> noteList = new ArrayList<>();
	
	static {
		DAO<User> userDAO = new UserDataBase();
		System.out.println("Hello World");
		EntityList.userList.addAll(userDAO.selectAll());
		DAO<Note> noteDAO = new NoteDataBase();
		EntityList.noteList.addAll(noteDAO.selectAll());
	}
}
