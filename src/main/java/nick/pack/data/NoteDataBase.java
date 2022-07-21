package nick.pack.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import nick.pack.models.Note;
import nick.pack.models.User;

public class NoteDataBase extends Connect implements DAO<Note> {
	private static Logger logger = Logger.getLogger(NoteDataBase.class);
	private final List<Note> notes = EntityList.noteList;

	@Override
	public void insert(Note entity) {
		// TODO Auto-generated method stub
		try(Statement statement = conn.createStatement()){
			logger.debug(NoteDataBase.class + "insert value - " + entity);
			String name = entity.getName();
			String text = entity.getText();
			String sql = String.format("INSERT INTO note (name, text) VALUES ('%s', '%s')", name, text);
			statement.execute(sql);
			notes.add(entity);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e);
			e.printStackTrace();
		}
	}

	@Override
	public void update(Note entity) {
		// TODO Auto-generated method stub
		try(Statement statement = conn.createStatement()){
			logger.debug(NoteDataBase.class + "update value - " + entity);
			int id = entity.getId();
			String name = entity.getName();
			String text = entity.getText();
			String sql = String.format("UPDATE note SET name='%s', text='%s' WHERE id=%d", name, text, id);
			statement.execute(sql);
			for(int i=0; i < notes.size(); i++) {
				if (notes.get(i).getId() == entity.getId()) {
					notes.set(i, entity);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e);
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Note entity) {
		// TODO Auto-generated method stub
		try(Statement statement = conn.createStatement()){
			logger.debug(NoteDataBase.class + " delete value - " + entity);
			int id = entity.getId();
			String sql = String.format("DELETE FROM note WHERE id=%d", id);
			statement.execute(sql);
			notes.remove(entity);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e);
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Note> selectAll() {
		// TODO Auto-generated method stub
		List<Note> noteList = new ArrayList<>();
		List<User> users = EntityList.userList;
		try(Statement statement = conn.createStatement()){
			logger.info("NoteList initialize....");
			String sql = "SELECT * FROM note";
			ResultSet result = statement.executeQuery(sql);
			while(result.next()) {
				int idUser = result.getInt("person_id");
				User user = null;
				for (User person : users) {
					if (person.getId() == idUser) {
						user = person;
					}
				}
				Note note = new Note (result.getInt("id"), result.getString("name"), result.getString("text"), user);
				noteList.add(note);
			}
			logger.debug("NoteList is initialized");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e);
			e.printStackTrace();
		}
		return noteList;
	}

}
