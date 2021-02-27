package ImplementazioniPostrgresDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

import Classi.CodaDiImbarco;
import Classi.Gate;
import ClassiDAO.CodaDiImbarcoDAO;
import Database.ConnessioneDatabase;

public class CodaDiImbarcoImplementazionePostgresDAO implements CodaDiImbarcoDAO{
	
	ConnessioneDatabase db = new ConnessioneDatabase();
	CodaDiImbarco codaImbarco = new CodaDiImbarco();

	@SuppressWarnings("finally")
	@Override // stampa Coda Di Imbarco
	public String stampaCodaDiImbarco() {
		String ListaCodaDiImbarco = null;

		PreparedStatement pst;
		ResultSet rs;
		String sql = "SELECT nomeCoda FROM codaDiImbarco";

		try {
			pst = db.ConnessioneDB().prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				String nome = rs.getString("nomeCoda");
			}
			db.ConnessioneDB().close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Errore: " + e.getMessage());
		} finally {
			return ListaCodaDiImbarco;
		}
	}

	
	@Override
	public HashMap<String, String> stampaCodaDiImbarcoInComboBox() {

		HashMap<String, String> map = new HashMap<String, String>();

		PreparedStatement pst;
		ResultSet rs;
		String sql = "SELECT codicecodadiimbarco, nomeCoda FROM codadiimbarco ORDER BY nomeCoda";

		try {
			pst = db.ConnessioneDB().prepareStatement(sql);
			rs = pst.executeQuery();
			CodaDiImbarco codaDiImbarco;
			
			while (rs.next()) {
				codaDiImbarco = new CodaDiImbarco(rs.getString(2), rs.getString(1));
				map.put(codaDiImbarco.getCodiceCodaDiImbarco(), codaDiImbarco.getNomeCoda());
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Errore: " + e.getMessage());
		}
		return map;
	}
	
	
}
