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
	private static final String DB_CONNECTION = "jdbc:postgresql://ec2-34-194-158-176.compute-1.amazonaws.com:5432/df2vgfq54gceej";
	private static final String DB_USERNAME = "";
	private static final String DB_PASSWORD = "67fb2c92cbb0266092ddcbb3a8743609bf7194658569cece25302d1e17ea652f";
	
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