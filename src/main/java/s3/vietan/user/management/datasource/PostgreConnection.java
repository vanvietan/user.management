package s3.vietan.user.management.datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreConnection {
	/*
	 * Check Db
	 */
	private static final String url = "jdbc:postgresql://localhost/postgres";
    private static final String user = "postgres";
    private static final String password = "admin";
	
	public static Connection getConnection() {
		Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
	}
	
	public static void main(String[] args) {
		PostgreConnection connection = new PostgreConnection();
        connection.getConnection();
    }
}
