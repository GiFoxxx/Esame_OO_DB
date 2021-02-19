package ImplementazioniPostrgresDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Classi.Gate;
import ClassiDAO.GateDAO;
import Database.ConnessioneDatabase;

public class GateImplementazionePostgresDAO implements GateDAO {

	ConnessioneDatabase db = new ConnessioneDatabase();
	Gate gt = new Gate();

	@SuppressWarnings("finally")
	@Override // stampa gate
	public ArrayList<Object[]> stampaGate() {
		ArrayList<Object[]> ListaGate = new ArrayList<>();

		PreparedStatement pst;
		ResultSet rs;
		String sql = "SELECT * FROM gate";

		try {
			pst = db.ConnessioneDB().prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				Object[] Lista = new Object[3];
				for (int i = 0; i <= 2; i++) {
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
		String sql = "INSERT INTO gate (codiceGate, numeroPorta, tempoImbarcoEffettivo) VALUES (?, ?, ?)";
		try {
			db.ConnessioneDB();

			pst = db.ConnessioneDB().prepareStatement(sql);

			pst.setString(1, gt.getCodiceGate());
			pst.setString(2, gt.getNumeroPorta());
			pst.setInt(3, gt.getTempoImbarcoEffettivo());

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
		String sql = "UPDATE gate SET numeroporta = ?, tempoimbarcoeffettivo = ? WHERE codiceGate = ?";
		try {
			db.ConnessioneDB();

			pst = db.ConnessioneDB().prepareStatement(sql);

			pst.setString(1, gt.getNumeroPorta());
			pst.setInt(2, gt.getTempoImbarcoEffettivo());
			pst.setString(3, gt.getCodiceGate());

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
	
	

}
