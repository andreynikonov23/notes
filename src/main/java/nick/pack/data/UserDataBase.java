package nick.pack.data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import nick.pack.models.User;

public class UserDataBase extends Connect implements DAO<User>{
	private Logger logger = Logger.getLogger(UserDataBase.class);
	public void insert(User entity) {
		// TODO Auto-generated method stub
			logger.debug(UserDataBase.class + " insert value - " + entity);
			String name = entity.getName();
			String login = entity.getLogin();
			String password = entity.getPassword();
			PreparedStatement statement;
			try {
				statement = conn.prepareStatement("INSERT INTO person (name, login, password) VALUES (?, ?, ?)");
				statement.setString(1, name);
				statement.setString(2, login);
				statement.setString(3, password);
				statement.execute();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				logger.error(e);
				e.printStackTrace();
			}
			if (entity.getId() == 0) {
				int id = EntityList.userList.get(EntityList.userList.size() - 1).getId() + 1;
				entity.setId(id);
			}
			EntityList.userList.add(entity);
	}

	public void update(User entity) {
		// TODO Auto-generated method stub
		try{
			logger.debug(UserDataBase.class + " update value - " + entity);
			int id = entity.getId();
			String name = entity.getName();
			String login = entity.getLogin();
			String password = entity.getPassword();
			List<User> users = EntityList.userList;
			PreparedStatement statement = conn.prepareStatement("UPDATE person SET name='?', login='?', password='?' WHERE id=?");
			statement.setString(1, name);
			statement.setString(2, login);
			statement.setString(3, password);
			statement.setInt(4, id);
			for(int i=0; i < users.size(); i++) {
				if (users.get(i).getId() == entity.getId()) {
					users.set(i, entity);
				}
			}
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e);
			e.printStackTrace();
		}
	}

	public void delete(User entity) {
		// TODO Auto-generated method stub
		try{
			logger.debug(UserDataBase.class + " delete value - " + entity);
			int id = entity.getId();
			String sql = String.format("DELETE FROM person WHERE id=%d", id);
			PreparedStatement statement = conn.prepareStatement("DELETE FROM person WHERE id=?");
			statement.setInt(0, id);
			statement.execute();
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
