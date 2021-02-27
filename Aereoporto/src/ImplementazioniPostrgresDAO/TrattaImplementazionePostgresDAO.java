package ImplementazioniPostrgresDAO;

import ClassiDAO.TrattaDAO;
import Database.ConnessioneDatabase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

import Classi.*;

public class TrattaImplementazionePostgresDAO implements TrattaDAO {

	ConnessioneDatabase db = new ConnessioneDatabase();
	Tratta trt = new Tratta();
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	@SuppressWarnings("finally")
	@Override // stampa tratte
	public ArrayList<Object[]> stampaTratte() {
		ArrayList<Object[]> ListaTratta = new ArrayList<>();

		PreparedStatement pst;
		ResultSet rs;
		String sql = "SELECT * FROM tratta ORDER BY codicetratta ASC";

		try {
			pst = db.ConnessioneDB().prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				Object[] Lista = new Object[4];
				for (int i = 0; i <= 3; i++) {
					Lista[i] = rs.getObject(i + 1);
				}
				ListaTratta.add(Lista);
			}
			db.ConnessioneDB().close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Errore: " + e.getMessage());
		} finally {
			return ListaTratta;
		}
	}

	@Override // cancello una tratta
	public boolean cancellaTratta(Object tratta) {
		trt = (Tratta) tratta;

		PreparedStatement pst;
		String sql = "DELETE FROM tratta WHERE codicetratta = ?";
		try {
			db.ConnessioneDB();

			pst = db.ConnessioneDB().prepareStatement(sql);

			pst.setString(1, trt.getCodiceTratta());

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

	@Override // modifica info tratta
	public boolean modificaTratta(Object tratta) {
		trt = (Tratta) tratta;
		
		PreparedStatement pst;
		String sql = "UPDATE tratta SET cittapartenza=?, cittaarrivo=? xcodiceCompagniaAerea=? WHERE codicetratta=?";
		try {
			db.ConnessioneDB();

			pst = db.ConnessioneDB().prepareStatement(sql);

			pst.setString(1, trt.getCittaPartenza());
			pst.setString(2, trt.getCittaArrivo());
			pst.setString(3, trt.getCodiceTratta());
			pst.setString(4, trt.getCompagniaAerea().getCodiceCompagniaAerea());
			
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

	@Override // aggiungi tratta
	public boolean aggiungiTratta(Object tratta) {
		trt = (Tratta) tratta;
		
		PreparedStatement pst;
		String sql = "INSERT INTO tratta (codiceTratta, cittaPartenza, cittaArrivo, xcodiceCompagniaAerea) VALUES (?,?,?,?)";
		try {
			db.ConnessioneDB();

			pst = db.ConnessioneDB().prepareStatement(sql);

			pst.setString(1, trt.getCodiceTratta());
			pst.setString(2, trt.getCittaPartenza());
			pst.setString(3, trt.getCittaArrivo());
			pst.setString(4, trt.getCompagniaAerea().getCodiceCompagniaAerea());
			
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
	public HashMap<String, String> stampaCittaArrivoInComboBox() {

		HashMap<String, String> map = new HashMap<String, String>();

		PreparedStatement pst;
		ResultSet rs;
		String sql = "SELECT codiceTratta, cittaArrivo FROM tratta ORDER BY codicetratta ASC";

		try {
			pst = db.ConnessioneDB().prepareStatement(sql);
			rs = pst.executeQuery();
			Tratta trt;
			
			while (rs.next()) {
				trt = new Tratta(rs.getString(2), rs.getString(1));
				map.put(trt.getCodiceTratta(), trt.getCittaArrivo());
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Errore: " + e.getMessage());
		}
		return map;
	}
	
}