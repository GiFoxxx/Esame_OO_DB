package Amministrazione;

import Database.*;
import GUI.Accesso;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import Classi.VoloPartenze;

public class UtenteImplementazionePostgresDAO implements UtenteDAO {

	private Connection connection;
	private PreparedStatement stampaUtentiPS, registrazioneUtentePS, cancellaUtentePS, modificaUtentePS,
			stampaNomeAccountPS, stampaCognomeAccountPS, stampaEmailAccountPS, passwordDimenticataPS, cambioPasswordPS,
			accessoUtentePS, esisteEmailPS;

	public UtenteImplementazionePostgresDAO(Connection connection) throws SQLException {
		this.connection = connection;

		stampaUtentiPS = connection.prepareStatement("SELECT * FROM utente");
		registrazioneUtentePS = connection.prepareStatement("INSERT INTO utente VALUES (?,?,?,?)");
		cancellaUtentePS = connection.prepareStatement("DELETE FROM utente WHERE email = ?");
		modificaUtentePS = connection.prepareStatement("UPDATE utente SET nome=?, cognome=?, password=? WHERE email=?");
		stampaNomeAccountPS = connection.prepareStatement("SELECT nome FROM utente WHERE email=?");
		stampaCognomeAccountPS = connection.prepareStatement("SELECT cognome FROM utente WHERE email=?");
		stampaEmailAccountPS = connection.prepareStatement("SELECT email FROM utente WHERE email=?");
		passwordDimenticataPS = connection.prepareStatement("UPDATE utente SET password=? WHERE email=?");
		cambioPasswordPS = connection.prepareStatement("UPDATE utente SET password=? WHERE email=?");
		accessoUtentePS = connection.prepareStatement("SELECT * FROM utente WHERE email = ? AND password = ?");
		esisteEmailPS = connection.prepareStatement("SELECT * FROM utente WHERE email = ? ");
	}

	public List<Utente> stampaUtenti() throws SQLException {

		ResultSet rs = stampaUtentiPS.executeQuery();
		List<Utente> lista = new ArrayList<Utente>();
		while (rs.next()) {
			Utente utn = new Utente();
			utn.setNome(rs.getString("nome"));
			utn.setCognome(rs.getString("cognome"));
			utn.setEmail(rs.getString("email"));
			utn.setPassword(rs.getString("password"));
			lista.add(utn);
		}
		rs.close();
		return lista;
	}

	public int registrazioneUtente(Utente utente) throws SQLException {
		registrazioneUtentePS.setString(1, utente.getNome());
		registrazioneUtentePS.setString(2, utente.getCognome());
		registrazioneUtentePS.setString(3, utente.getEmail());
		registrazioneUtentePS.setString(4, utente.getPassword());

		int row = registrazioneUtentePS.executeUpdate();
		return row;
	}

	public int cancellaUtente(Utente utente) throws SQLException {
		cancellaUtentePS.setString(1, utente.getEmail());

		int row = cancellaUtentePS.executeUpdate();
		return row;
	}

	public int modificaUtente(Utente utente) throws SQLException {
		modificaUtentePS.setString(1, utente.getNome());
		modificaUtentePS.setString(2, utente.getCognome());
		modificaUtentePS.setString(3, utente.getPassword());
		modificaUtentePS.setString(4, utente.getEmail());

		int row = modificaUtentePS.executeUpdate();
		return row;
	}

	public String stampaNomeAccount(Utente utente) throws SQLException {
		String nome = null;

		stampaNomeAccountPS.setString(1, utente.getEmail());
		ResultSet rs = stampaNomeAccountPS.executeQuery();
		StringBuilder resultText = new StringBuilder();

		while (rs.next()) {
			resultText.append(rs.getString(1));
		}
		nome = resultText.toString();

		return nome;
	}

	public String stampaCognomeAccount(Utente utente) throws SQLException {
		String cognome = null;

		stampaCognomeAccountPS.setString(1, utente.getEmail());
		ResultSet rs = stampaCognomeAccountPS.executeQuery();
		StringBuilder resultText = new StringBuilder();

		while (rs.next()) {
			resultText.append(rs.getString(1));
		}
		cognome = resultText.toString();

		return cognome;
	}

	public String stampaEmailAccount(Utente utente) throws SQLException {
		String email = null;

		stampaEmailAccountPS.setString(1, utente.getEmail());
		ResultSet rs = stampaEmailAccountPS.executeQuery();
		StringBuilder resultText = new StringBuilder();

		while (rs.next()) {
			resultText.append(rs.getString(1));
		}
		email = resultText.toString();

		return email;
	}

	public int passwordDimenticata(Utente utente) throws SQLException {
		passwordDimenticataPS.setString(1, utente.getPassword());
		passwordDimenticataPS.setString(2, utente.getEmail());

		int row = passwordDimenticataPS.executeUpdate();
		return row;
	}

	public int cambioPasswordDB(Utente utente) throws SQLException {
		cambioPasswordPS.setString(1, utente.getPassword());
		cambioPasswordPS.setString(2, utente.getEmail());

		int row = cambioPasswordPS.executeUpdate();
		return row;
	}

	public boolean accessoUtente(String email, String password) throws SQLException {
		boolean eUtente = false;

		accessoUtentePS.setString(1, email);
		accessoUtentePS.setString(2, password);

		ResultSet res = accessoUtentePS.executeQuery();
		if (res.next()) {
			eUtente = true;
		}

		return eUtente;
	}

	public boolean esisteEmail(String email) throws SQLException {
		boolean eUtente = false;

		esisteEmailPS.setString(1, email);

		ResultSet res = esisteEmailPS.executeQuery();
		if (res.next()) {
			eUtente = true;
		}

		return eUtente;
	}
}
