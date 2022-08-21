package nick.pack.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import nick.pack.data.EntityList;

public class User {
	private int id;
	private String name;
	private String login;
	private String password;
	
	
	public User(int id, String name, String login, String password) {
		this.id = id;
		this.name = name;
		this.login = login;
		this.password = password;
	}
	public User(String name, String login, String password) {
		this.name = name;
		this.login = login;
		this.password = password;
	}
	public User() {
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getLogin() {
		return login;
	}
	public String getPassword() {
		return password;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	public int hashCode() {
		return Objects.hash(id, name, login, password);
	}
	public boolean equals(Object obj) {
		boolean isTrue = false;
		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		User user = (User) obj;
		if (this.hashCode() != user.hashCode()) {
			return false;
		} else {
			isTrue = id == user.getId() && name.equals(user.getName()) && login.equals(user.getLogin()) && password.equals(user.getPassword());
		}
		return isTrue;
	}
	
	
	public String toString() {
		return String.format("User: %d, %s, %s, %s", id, name, login, password);
	}
	
	public List<Note> getNotes(){
		List<Note> noteList = EntityList.noteList;
		List<Note> notes = new ArrayList<>();
		for (Note note : noteList) {
			if (note.getUser().equals(this)) {
				notes.add(note);
			}
		}
		return notes;
	}
}
