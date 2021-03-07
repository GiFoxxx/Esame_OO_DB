package Database;

import java.sql.*;

public class ConnessioneDatabase1 {

	// ATTRIBUTI
	private static ConnessioneDatabase1 instance;
	private Connection connection = null;
	private String nome = "Admin";
	private String password = "Admin";
	private String url = "jdbc:postgresql://localhost:5432/Progetto_Aeroporto";
	private String driver = "org.postgresql.Driver";

	// COSTRUTTORE
	private ConnessioneDatabase1() throws SQLException {
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

	public static ConnessioneDatabase1 getInstance() throws SQLException {
		if (instance == null) {
			instance = new ConnessioneDatabase1();
		} else if (instance.getConnection().isClosed()) {
			instance = new ConnessioneDatabase1();
		}
		return instance;
	}
}