package ImplementazioniPostrgresDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Classi.CodaDiImbarco;
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
		String sql = "SELECT tipologiaClasse FROM codaDiImbarco ";

		try {
			pst = db.ConnessioneDB().prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				String nome = rs.getString("tipologiaClasse");
			}
			db.ConnessioneDB().close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Errore: " + e.getMessage());
		} finally {
			return ListaCodaDiImbarco;
		}
	}

}
