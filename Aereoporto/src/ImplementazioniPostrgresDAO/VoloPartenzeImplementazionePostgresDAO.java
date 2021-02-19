package ImplementazioniPostrgresDAO;

import ClassiDAO.VoloPartenzeDAO;
import Database.ConnessioneDatabase;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Classi.*;

public class VoloPartenzeImplementazionePostgresDAO implements VoloPartenzeDAO {

	ConnessioneDatabase db = new ConnessioneDatabase();
	VoloPartenze vlprtz = new VoloPartenze();
	Gate gt = new Gate();
	Tratta trt = new Tratta();
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	

	@SuppressWarnings("finally")
	@Override // stampa voli
	public ArrayList<Object[]> stampaVoliPartenze() {
		ArrayList<Object[]> ListaVoliPartenze = new ArrayList<>();

		PreparedStatement pst;
		ResultSet rs;
		String sql = "SELECT * FROM voloPartenza";

		try {
			pst = db.ConnessioneDB().prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				Object[] Lista = new Object[6];
				for (int i = 0; i <= 5; i++) {
					Lista[i] = rs.getObject(i + 1);
				}
				ListaVoliPartenze.add(Lista);
			}
			db.ConnessioneDB().close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Errore: " + e.getMessage());
		} finally {
			return ListaVoliPartenze;
		}
	}

	@Override // cancello una volo partenze
	public boolean cancellaVoloPartenze(Object voloPartenze) {
		vlprtz = (VoloPartenze) voloPartenze;

		PreparedStatement pst;
		String sql = "DELETE FROM voloPartenze WHERE codiceVoloPartenze = ?";
		try {
			db.ConnessioneDB();

			pst = db.ConnessioneDB().prepareStatement(sql);

			pst.setString(1, vlprtz.getCodiceVoloPartenze());

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

	@Override // modifica info volo partenze
	public boolean modificaVoloPartenze(Object voloPartenze) {
		vlprtz = (VoloPartenze) voloPartenze;
		
		PreparedStatement pst;
		String sql = "UPDATE voloPartenze SET cittaarrivo = ?, datapartenza = ?, orapartenza = ?, minutoPartenza = ?, numeroprenotazioni = ?, ritardo = ? WHERE codiceVoloPartenze=?";
		try {
			db.ConnessioneDB();

			pst = db.ConnessioneDB().prepareStatement(sql);
			pst.setString(1, vlprtz.getCittaArrivo());
			String dataPartenza = sdf.format(vlprtz.getDataPartenza());
			pst.setString(2, dataPartenza);
			pst.setString(3, vlprtz.getOraPartenza());
			pst.setString(4, vlprtz.getMinutoPartenza());
			pst.setString(5, vlprtz.getNumeroPrenotazioni());
			pst.setString(6, vlprtz.getRitardo());
			pst.setString(7, vlprtz.getCodiceVoloPartenze());

			
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

	@Override // aggiungi volo partenze
	public boolean aggiungiVoloPartenze(Object voloPartenze) {
		vlprtz = (VoloPartenze) voloPartenze;
		
		PreparedStatement pst;
		String sql = "INSERT INTO voloPartenze (codiceVoloPartenze, cittaArrivo, dataPartenza, oraPartenza, minutoPartenza, numeroPrenotazioni, ritardo) VALUES (?,?,?,?,?,?,?)";
		try {
			db.ConnessioneDB();

			pst = db.ConnessioneDB().prepareStatement(sql);

			pst.setString(1, vlprtz.getCodiceVoloPartenze());
			pst.setString(2, vlprtz.getCittaArrivo());
			String dataPartenza = sdf.format(vlprtz.getDataPartenza());
			pst.setString(3, dataPartenza);
			pst.setString(4, vlprtz.getOraPartenza());
			pst.setString(5, vlprtz.getMinutoPartenza());
			pst.setString(6, vlprtz.getNumeroPrenotazioni());
			pst.setString(7, vlprtz.getRitardo());

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
