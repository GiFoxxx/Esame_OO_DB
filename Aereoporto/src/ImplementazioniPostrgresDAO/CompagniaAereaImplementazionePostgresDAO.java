package ImplementazioniPostrgresDAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import Amministrazione.Utente;
import Classi.CompagniaAerea;
import Classi.Gate;
import ClassiDAO.CompagniaAereaDAO;

public class CompagniaAereaImplementazionePostgresDAO implements CompagniaAereaDAO {

	private Connection connection;
	private PreparedStatement stampaCompagnieAereePS, aggiungiCompagniaAereaPS, cancellaCompagniaAereaPS,
			modificaCompagniaAereaPS, stampaNomeCompagniaAereaInComboBoxPS;

	public CompagniaAereaImplementazionePostgresDAO(Connection connection) throws SQLException {
		this.connection = connection;

		stampaCompagnieAereePS = connection.prepareStatement("SELECT * FROM compagniaaerea ORDER BY nome");
		aggiungiCompagniaAereaPS = connection
				.prepareStatement("INSERT INTO compagniaaerea (codiceCompagniaAerea, nome) VALUES (?,?)");
		cancellaCompagniaAereaPS = connection
				.prepareStatement("DELETE FROM compagniaAerea WHERE codiceCompagniaAerea = ?");
		modificaCompagniaAereaPS = connection
				.prepareStatement("UPDATE compagniaaerea SET nome = ? WHERE codicecompagniaaerea = ? ");
		stampaNomeCompagniaAereaInComboBoxPS = connection
				.prepareStatement("SELECT * FROM CompagniaAerea ORDER BY codiceCompagniaAerea");
	}

	public List<CompagniaAerea> stampaCompagnieAeree() throws SQLException {

		ResultSet rs = stampaCompagnieAereePS.executeQuery();
		List<CompagniaAerea> lista = new ArrayList<CompagniaAerea>();
		while (rs.next()) {
			CompagniaAerea compAerea = new CompagniaAerea();
			compAerea.setCodiceCompagniaAerea(rs.getString("codiceCompagniaAerea"));
			compAerea.setNome(rs.getString("nome"));
			lista.add(compAerea);
		}
		rs.close();
		return lista;
	}

	public int aggiungiCompagniaAerea(CompagniaAerea compAerea) throws SQLException {
		aggiungiCompagniaAereaPS.setString(1, compAerea.getCodiceCompagniaAerea());
		aggiungiCompagniaAereaPS.setString(2, compAerea.getNome());

		int row = aggiungiCompagniaAereaPS.executeUpdate();
		return row;
	}

	public int cancellaCompagniaAerea(CompagniaAerea compAerea) throws SQLException {
		cancellaCompagniaAereaPS.setString(1, compAerea.getCodiceCompagniaAerea());

		int row = cancellaCompagniaAereaPS.executeUpdate();
		return row;
	}

	public int modificaCompagniaAerea(CompagniaAerea compAerea) throws SQLException {
		modificaCompagniaAereaPS.setString(1, compAerea.getNome());
		modificaCompagniaAereaPS.setString(2, compAerea.getCodiceCompagniaAerea());

		int row = modificaCompagniaAereaPS.executeUpdate();
		return row;
	}

	public HashMap<String, String> stampaNomeCompagniaAereaInComboBox() throws SQLException {
		HashMap<String, String> map = new HashMap<String, String>();

		ResultSet rs = stampaNomeCompagniaAereaInComboBoxPS.executeQuery();
		while (rs.next()) {
			CompagniaAerea compAerea = new CompagniaAerea(rs.getString(2), rs.getString(1));
			map.put(compAerea.getCodiceCompagniaAerea(), compAerea.getNome());
		}

		return map;
	}

}
