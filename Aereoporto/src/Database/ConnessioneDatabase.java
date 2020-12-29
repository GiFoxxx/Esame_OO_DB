package Database;

import java.sql.*;


public class ConnessioneDatabase {
public static Connection connessioneDatabase() throws SQLException {
	 Connection conn = null;	
	 String NOME = "postgres";
	 String PASSWORD = "Mb.120200";
	 String NOMEDATABASE = "Amministrazione_Aereoporto";
	 String IP = "localhost";
	 String PORTA = "5432";

	        try{
	            Class.forName("org.postgresql.Driver");
	            conn = DriverManager.getConnection("jdbc:postgresql://"+IP+":"+PORTA+"/"+NOMEDATABASE+"", ""+NOME+"", ""+PASSWORD+"");
	            System.out.println("Connessione al database riuscita");	
	            return conn;
	        }catch (ClassNotFoundException ex) {
	            System.out.println("Connessione al database fallita: " + ex.getMessage());
	        }
			return null;
	    }
}