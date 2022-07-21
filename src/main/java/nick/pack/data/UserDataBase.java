package nick.pack.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import nick.pack.models.User;

public class UserDataBase extends Connect implements DAO<User>{
	private Logger logger = Logger.getLogger(UserDataBase.class);
	public void insert(User entity) {
		// TODO Auto-generated method stub
		try(Statement statemant = conn.createStatement()){
			logger.debug(UserDataBase.class + " insert value - " + entity);
			String name = entity.getName();
			String login = entity.getLogin();
			String password = entity.getPassword();
			String sql = String.format("INSERT INTO person (name, login, password) VALUES ('%s', '%s', '%s')", name, login, password);
			statemant.execute(sql);
			EntityList.userList.add(entity);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e);
			e.printStackTrace();
		}
	}

	public void update(User entity) {
		// TODO Auto-generated method stub
		try(Statement statement = conn.createStatement()){
			logger.debug(UserDataBase.class + " update value - " + entity);
			int id = entity.getId();
			String name = entity.getName();
			String login = entity.getLogin();
			String password = entity.getPassword();
			String sql = String.format("UPDATE person SET name='%s', login='%s', password='%s' WHERE id=%d", name, login, password, id);
			List<User> users = EntityList.userList;
			statement.execute(sql);
			for(int i=0; i < users.size(); i++) {
				if (users.get(i).getId() == entity.getId()) {
					users.set(i, entity);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e);
			e.printStackTrace();
		}
	}

	public void delete(User entity) {
		// TODO Auto-generated method stub
		try(Statement statement = conn.createStatement()){
			logger.debug(UserDataBase.class + " delete value - " + entity);
			int id = entity.getId();
			String sql = String.format("DELETE FROM person WHERE id=%d", id);
			statement.execute(sql);
			EntityList.userList.remove(entity);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e);
			e.printStackTrace();
		}
	}

	public List<User> selectAll() {
		// TODO Auto-generated method stub
		List<User> allUsers = new ArrayList<>();
		try(Statement statement = conn.createStatement()){
			logger.info("UserList initialize....");
			ResultSet resultSet = statement.executeQuery("SELECT * FROM person");
			int count = 1;
			while(resultSet.next()) {
				User user = new User(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("login"), resultSet.getString("password"));
				allUsers.add(user);
			}
			logger.debug("UserList is initialized");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.fatal("UserList not initialize" + e);
			e.printStackTrace();
		}
		return allUsers;
		
	}

	
}
