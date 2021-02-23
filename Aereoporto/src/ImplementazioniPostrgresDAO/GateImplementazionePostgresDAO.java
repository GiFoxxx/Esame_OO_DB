package ImplementazioniPostrgresDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

import Amministrazione.Utente;
import Classi.Gate;
import ClassiDAO.GateDAO;
import Controller.Controller;
import Database.ConnessioneDatabase;
import GUI.GestioneVoliPartenze;

public class GateImplementazionePostgresDAO implements GateDAO {

	ConnessioneDatabase db = new ConnessioneDatabase();
	Gate gt;

	@SuppressWarnings("finally")
	@Override // stampa gate
	public ArrayList<Object[]> stampaGate() {
		ArrayList<Object[]> ListaGate = new ArrayList<>();

		PreparedStatement pst;
		ResultSet rs;
		String sql = "SELECT * FROM gate ORDER BY numeroPorta";

		try {
			pst = db.ConnessioneDB().prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				Object[] Lista = new Object[2];
				for (int i = 0; i <= 1; i++) {
					Lista[i] = rs.getObject(i + 1);
				}
				ListaGate.add(Lista);
			}
			db.ConnessioneDB().close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Errore: " + e.getMessage());
		} finally {
			return ListaGate;
		}
	}

	@Override // aggiungo un gate
	public boolean aggiungiGate(Object gate) {
		gt = (Gate) gate;
		PreparedStatement pst;
		String sql = "INSERT INTO gate (codiceGate, numeroPorta, codaDiImbarco1, codaDiImbarco2) VALUES (?, ?, ?, ?)";
		try {
			db.ConnessioneDB();

			pst = db.ConnessioneDB().prepareStatement(sql);

			pst.setString(1, gt.getCodiceGate());
			pst.setString(2, gt.getNumeroPorta());
			pst.setString(3, gt.getCodiceGate());
			pst.setString(4, gt.getNumeroPorta());

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
	public boolean cancellaGate(Object gate) {
		gt = (Gate) gate;

		PreparedStatement pst;
		String sql = "DELETE FROM gate WHERE codiceGate = ?";
		try {
			db.ConnessioneDB();

			pst = db.ConnessioneDB().prepareStatement(sql);

			pst.setString(1, gt.getCodiceGate());

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
	public boolean modificaGate(Object gate) {
		gt = (Gate) gate;
		PreparedStatement pst;
		String sql = "UPDATE gate SET numeroporta = ? WHERE codiceGate = ?";
		try {
			db.ConnessioneDB();

			pst = db.ConnessioneDB().prepareStatement(sql);

			pst.setString(1, gt.getNumeroPorta());
			pst.setString(2, gt.getCodiceGate());

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
	public HashMap<String, String> stampaCodiceGateInComboBox() {

		HashMap<String, String> map = new HashMap<String, String>();

		PreparedStatement pst;
		ResultSet rs;
		String sql = "SELECT * FROM gate ORDER BY codiceGate";

		try {
			pst = db.ConnessioneDB().prepareStatement(sql);
			rs = pst.executeQuery();
			Gate gt;
			
			while (rs.next()) {
				gt = new Gate(rs.getString(2), rs.getString(1));
				map.put(gt.getCodiceGate(), gt.getNumeroPorta());
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Errore: " + e.getMessage());
		}
		return map;
	}

}
