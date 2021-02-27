package ImplementazioniPostrgresDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;


import Classi.CompagniaAerea;
import Classi.Gate;
import ClassiDAO.CompagniaAereaDAO;
import Database.ConnessioneDatabase;

public class CompagniaAereaImplementazionePostgresDAO implements CompagniaAereaDAO{

	ConnessioneDatabase db = new ConnessioneDatabase();
	CompagniaAerea compAerea = new CompagniaAerea();
	
	@SuppressWarnings("finally")
	@Override
	public ArrayList<Object[]> stampaCompagnieAeree() {
		ArrayList<Object[]> ListaCompagnieAeree = new ArrayList<>();
		
		PreparedStatement pst;
		ResultSet rs;
		String sql = "SELECT * FROM compagniaaerea ORDER BY nome";

		try {
			pst = db.ConnessioneDB().prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				Object[] Lista = new Object[2];
				for (int i = 0; i <= 1; i++) {
					Lista[i] = rs.getObject(i + 1);
				}
				ListaCompagnieAeree.add(Lista);
			}
			db.ConnessioneDB().close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Errore: " + e.getMessage());
		} finally {
			return ListaCompagnieAeree;
		}
	}

	@Override
	public boolean aggiungiCompagniaAerea(Object compagniaAerea) {
		compAerea = (CompagniaAerea) compagniaAerea;
		PreparedStatement pst;
		String sql = "INSERT INTO compagniaaerea (codiceCompagniaAerea, nome) VALUES (?,?)";
		try {
			db.ConnessioneDB();

			pst = db.ConnessioneDB().prepareStatement(sql);

			pst.setString(1, compAerea.getCodiceCompagniaAerea());
			pst.setString(2, compAerea.getNome());
			int res = pst.executeUpdate();

			if (res > 0) {
				db.ConnessioneDB().close();
				return true;
			} else {
				db.ConnessioneDB().close();
				return false;
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Errore: " + e.getMessage());
			return false;
		}
	}

	@Override
	public boolean cancellaCompagniaAerea(Object compagniaAerea) {
		compAerea = (CompagniaAerea) compagniaAerea;
		
		PreparedStatement pst;
		String sql = "DELETE FROM compagniaAerea WHERE codiceCompagniaAerea = ?";
		try {
			db.ConnessioneDB();

			pst = db.ConnessioneDB().prepareStatement(sql);

			pst.setString(1, compAerea.getCodiceCompagniaAerea());

			int res = pst.executeUpdate();

			if (res > 0) {
				db.ConnessioneDB().close();
				return true;
			} else {
				db.ConnessioneDB().close();
				return false;
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Errore: " + e.getMessage());
			return false;
		}
	}

	@Override
	public boolean modificaCompagniaAerea(Object compagniaAerea) {
		compAerea = (CompagniaAerea) compagniaAerea;
		PreparedStatement pst;
		String sql = "UPDATE compagniaaerea SET nome = ? WHERE codicecompagniaaerea = ? ";
		try {
			db.ConnessioneDB();

			pst = db.ConnessioneDB().prepareStatement(sql);
			
			pst.setString(1, compAerea.getNome());
			pst.setString(2, compAerea.getCodiceCompagniaAerea());
			
			int res = pst.executeUpdate();

			if (res > 0) {
				db.ConnessioneDB().close();
				return true;
			} else {
				db.ConnessioneDB().close();
				return false;
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Errore: " + e.getMessage());
			return false;
		}
	}
	
	@Override
	public HashMap<String, String> stampaNomeCompagniaAereaInComboBox() {

		HashMap<String, String> map = new HashMap<String, String>();

		PreparedStatement pst;
		ResultSet rs;
		String sql = "SELECT * FROM CompagniaAerea ORDER BY codiceCompagniaAerea";

		try {
			pst = db.ConnessioneDB().prepareStatement(sql);
			rs = pst.executeQuery();
			CompagniaAerea compAerea;
			
			while (rs.next()) {
				compAerea = new CompagniaAerea(rs.getString(2), rs.getString(1));
				map.put(compAerea.getCodiceCompagniaAerea(), compAerea.getNome());
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Errore: " + e.getMessage());
		}
		return map;
	}

}
