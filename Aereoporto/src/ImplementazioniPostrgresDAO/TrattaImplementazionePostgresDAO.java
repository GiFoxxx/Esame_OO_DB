package ImplementazioniPostrgresDAO;

import ClassiDAO.TrattaDAO;
import Database.ConnessioneDatabase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Classi.*;

public class TrattaImplementazionePostgresDAO implements TrattaDAO {

	ConnessioneDatabase db = new ConnessioneDatabase();
	Tratta trt = new Tratta();
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

	@SuppressWarnings("finally")
	@Override // stampa tratte
	public ArrayList<Object[]> stampaTratte() {
		ArrayList<Object[]> ListaTratta = new ArrayList<>();

		PreparedStatement pst;
		ResultSet rs;
		String sql = "SELECT * FROM tratta";

		try {
			pst = db.ConnessioneDB().prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				Object[] Lista = new Object[8];
				for (int i = 0; i <= 6; i++) {
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
		String sql = "UPDATE tratta SET cittapartenza=?, cittaarrivo=?, dataPartenza=?, dataArrivo=?, orarioPartenza=?, orarioArrivo=? WHERE codicetratta=?";
		try {
			db.ConnessioneDB();

			pst = db.ConnessioneDB().prepareStatement(sql);

			pst.setString(1, trt.getCittaPartenza());
			pst.setString(2, trt.getCittaArrivo());
			String dataPartenza = sdf.format(trt.getDataPartenza());
			pst.setString(3, dataPartenza);
			String dataArrivo = sdf.format(trt.getDataArrivo());
			pst.setString(4, dataArrivo);
			pst.setString(5, trt.getOrarioPartenza());
			pst.setString(6, trt.getOrarioArrivo());
			pst.setString(7, trt.getCodiceTratta());
			
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
		String sql = "INSERT INTO tratta (codiceTratta, cittaPartenza, cittaArrivo, dataPartenza, dataArrivo, orarioPartenza, orarioArrivo) VALUES (?,?,?,?,?,?,?)";
		try {
			db.ConnessioneDB();

			pst = db.ConnessioneDB().prepareStatement(sql);

			pst.setString(1, trt.getCodiceTratta());
			pst.setString(2, trt.getCittaPartenza());
			pst.setString(3, trt.getCittaArrivo());
			String dataPartenza = sdf.format(trt.getDataPartenza());
			pst.setString(4, dataPartenza);
			String dataArrivo = sdf.format(trt.getDataArrivo());
			pst.setString(5, dataArrivo);
			pst.setString(6, trt.getOrarioPartenza());
			pst.setString(7, trt.getOrarioArrivo());
			
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