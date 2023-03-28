package Database;

import java.sql.*;

public class Database_Connection {
	private static Connection connect;

	private static final String DB_DRIVER = "org.postgresql.Driver";
	private static final String DB_CONNECTION = "jdbc:postgresql://ec2-23-20-140-229.compute-1.amazonaws.com:5432/dvhqmt96jbi20";
	private static final String DB_USERNAME = "svbyiezukzwlds";
	private static final String DB_PASSWORD = "46d4760f15178d4508d62877450eb1b43d89b9400c2127e2d314f04897e1d40d";
	
	public static Connection getConnection() {
		try {
			Class.forName(DB_DRIVER);
			try {
				connect = DriverManager.getConnection(DB_CONNECTION, DB_USERNAME, DB_PASSWORD);
				System.out.println("Connection Success");
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connect;
	}
}