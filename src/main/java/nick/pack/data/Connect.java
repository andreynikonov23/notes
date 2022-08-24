package nick.pack.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.postgresql.Driver;

public abstract class Connect {
	protected static Connection conn;
	private static Logger logger = Logger.getLogger(Connect.class);
	static {
		try {
		logger.debug("Data Base connect...");
		DriverManager.registerDriver(new Driver());
		String url = "jdbc:postgresql://localhost:5432/note_db";
		conn =  DriverManager.getConnection(url, "postgres", "1234");
		logger.debug("Data Base is connected");
		} catch(SQLException sql) {
			logger.fatal("Data Base not connected" + sql);
			sql.printStackTrace();
		}
	}
}

