package Database;

import java.sql.*;

public class ConnessioneDatabase {

	// ATTRIBUTI
	String Nome;
	String Password;
	String Url;
	String Driver;

	// COSTRUTTORE
	public ConnessioneDatabase() {
		this.Url = ("jdbc:postgresql://localhost:5432/Aereoporto");
		this.Driver = "org.postgresql.Driver";
		this.Nome = "postgres";
		this.Password = "Mb.120200";
	}

	// GETTER E SETTER
	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}

	public String getDriver() {
		return Driver;
	}

	public void setDriver(String driver) {
		Driver = driver;
	}
}