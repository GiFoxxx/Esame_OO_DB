package ImplementazioniPostrgresDAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import Classi.CodaDiImbarco;
import Classi.CompagniaAerea;
import Classi.Gate;
import ClassiDAO.CodaDiImbarcoDAO;

public class CodaDiImbarcoImplementazionePostgresDAO implements CodaDiImbarcoDAO {

	private Connection connection;
	private PreparedStatement stampaCodaDiImbarcoPS, aggiungiCodaDiImbarcoPS, modificaCodaDiImbarcoPS, cancellaCodaDiImbarcoPS, stampaCodaDiImbarcoInComboBoxPS;

	public CodaDiImbarcoImplementazionePostgresDAO(Connection connection) throws SQLException {
		this.connection = connection;

		stampaCodaDiImbarcoPS = connection.prepareStatement("SELECT * FROM codaDiImbarco ORDER BY tempodiimbarcostimatocdi");
		aggiungiCodaDiImbarcoPS = connection.prepareStatement("INSERT INTO codadiimbarco (codicecodaDiImbarco, nomeCoda, tempodiimbarcostimatocdi) VALUES (?, ?, ?)");
		modificaCodaDiImbarcoPS = connection.prepareStatement("UPDATE codaDiImbarco SET nomeCoda = ?, tempodiimbarcostimatocdi = ? WHERE codicecodaDiImbarco = ?");
		cancellaCodaDiImbarcoPS = connection.prepareStatement("DELETE FROM codaDiImbarco WHERE codicecodaDiImbarco = ?");		
		
		stampaCodaDiImbarcoInComboBoxPS = connection
				.prepareStatement("SELECT codicecodadiimbarco, nomeCoda FROM codadiimbarco ORDER BY nomeCoda");
	}
	
	public List<CodaDiImbarco> stampaCodaDiImbarco() throws SQLException {
		ResultSet rs = stampaCodaDiImbarcoPS.executeQuery();
		List<CodaDiImbarco> lista = new ArrayList<CodaDiImbarco>();
		while (rs.next()) {
			CodaDiImbarco codaImbarco = new CodaDiImbarco();
			codaImbarco.setCodiceCodaDiImbarco(rs.getString("codiceCodaDiImbarco"));
			codaImbarco.setNomeCoda(rs.getString("nomeCoda"));
			codaImbarco.setTempoImbarcoStimato(rs.getTime("tempodiimbarcostimatocdi"));
			lista.add(codaImbarco);
		}
		rs.close();
		return lista;
	}
	
	public int aggiungiCodaDiImbarco(CodaDiImbarco cdi) throws SQLException {
		aggiungiCodaDiImbarcoPS.setString(1, cdi.getCodiceCodaDiImbarco());
		aggiungiCodaDiImbarcoPS.setString(2, cdi.getNomeCoda());
		aggiungiCodaDiImbarcoPS.setTime(3, cdi.getTempoImbarcoStimato());

		int row = aggiungiCodaDiImbarcoPS.executeUpdate();
		return row;
	}
	
	public int cancellaCodaDiImbarco(CodaDiImbarco cdi) throws SQLException {
		cancellaCodaDiImbarcoPS.setString(1, cdi.getCodiceCodaDiImbarco());

		int row = cancellaCodaDiImbarcoPS.executeUpdate();
		return row;
	}
	
	public int modificaCodaDiImbarco(CodaDiImbarco cdi) throws SQLException {
		modificaCodaDiImbarcoPS.setString(1, cdi.getNomeCoda());
		modificaCodaDiImbarcoPS.setTime(2, cdi.getTempoImbarcoStimato());
		modificaCodaDiImbarcoPS.setString(3, cdi.getCodiceCodaDiImbarco());

		int row = modificaCodaDiImbarcoPS.executeUpdate();
		return row;
	}

	public HashMap<String, String> stampaCodaDiImbarcoInComboBox() throws SQLException {
		HashMap<String, String> map = new HashMap<String, String>();

		ResultSet rs = stampaCodaDiImbarcoInComboBoxPS.executeQuery();
		while (rs.next()) {
			CodaDiImbarco codaImbarco = new CodaDiImbarco(rs.getString(2), rs.getString(1));
			map.put(codaImbarco.getCodiceCodaDiImbarco(), codaImbarco.getNomeCoda());
		}

		return map;
	}


}
