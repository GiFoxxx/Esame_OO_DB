package Database;

import java.sql.*;

public class ConnessioneDatabase {

	// ATTRIBUTI
	private static ConnessioneDatabase instance;
	private Connection connection = null;
	private String nome = "postgres";
	private String password = "postgres";
	private String url = "jdbc:postgresql://localhost:5432/Aeroporto";
	private String driver = "org.postgresql.Driver";

	// COSTRUTTORE
	private ConnessioneDatabase() throws SQLException {
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, nome, password);

		} catch (ClassNotFoundException ex) {
			System.out.println("Database Connection Creation Failed : " + ex.getMessage());
		}

	}

	public Connection getConnection() {
		return connection;
	}

	public static ConnessioneDatabase getInstance() throws SQLException {
		if (instance == null) {
			instance = new ConnessioneDatabase();
		} else if (instance.getConnection().isClosed()) {
			instance = new ConnessioneDatabase();
		}
		return instance;
	}
}