package nick.pack.models;

import java.util.Objects;

public class Note {
	private int id;
	private String name;
	private String text;
	private User user;
	
	
	
	public Note(int id, String name, String text, User user) {
		this.id = id;
		this.name = name;
		this.text = text;
		this.user = user;
	}
	public Note() {
		
	}
	
	
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getText() {
		return text;
	}
	public User getUser() {
		return user;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
	public int hashCode() {
		return Objects.hash(id, name, text, user);
	}
	public boolean equals(Object obj) {
		boolean isTrue = false;
		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Note)) {
			return false;
		}
		Note another = (Note) obj;
		if (this.hashCode() == another.hashCode()) {
			isTrue = id == another.getId() && name.equals(another.getName()) && text.equals(another.getText()) && user.equals(another.getUser());
		} else
			return false;
		return isTrue;
	}
	
	
	
	public String toString() {
		return String.format("Note: %d, %s", id, name);
	}
}

