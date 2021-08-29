package Database;

import java.sql.*;

public class Database_Connection {
	private static Connection connect;
//	localhost Postgres database connection
//	private static final String DB_DRIVER = "org.postgresql.Driver";
//	private static final String DB_CONNECTION = "jdbc:postgresql://localhost:5432/academic_inventory";
//	private static final String DB_USERNAME = "postgres";
//	private static final String DB_PASSWORD = "system";
	
	private static final String DB_DRIVER = "org.postgresql.Driver";
	private static final String DB_CONNECTION = "jdbc:postgresql://ec2-34-254-69-72.eu-west-1.compute.amazonaws.com:5432/d9hqp3u89runob";
	private static final String DB_USERNAME = "cveacmynneeusc";
	private static final String DB_PASSWORD = "9db67c3df0013d6416b52bac3892a460749cbb1270c8b242fb95017623c06506";
	
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