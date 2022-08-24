package nick.pack.data;

import java.util.ArrayList;
import java.util.Collections;
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
	
	public static Note binarySearchNoteList(int id) {
		int low = 0;
		int high = noteList.size() - 1;
		
		while(low <= high) {
			int mid = (low + high)/2;
			Note guess = noteList.get(mid);
			
			if (guess.getId() == id) {
				return guess;
			}
			if (guess.getId() > id) {
				high = mid - 1;
			}
			if (guess.getId() < id) {
				low = mid + 1;
			}
		}
		return null;
	}
}
