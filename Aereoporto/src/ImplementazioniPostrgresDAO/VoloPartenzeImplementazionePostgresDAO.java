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
		String sql = "SELECT vp.codiceVoloPartenza, ca.nome AS nomecompagniaaerea, gt.numeroporta, tr.cittaarrivo, vp.datapartenza, vp.orapartenza, vp.minutopartenza, vp.oraarrivo, vp.minutoarrivo, vp.numeroprenotazioni, vp.ritardo FROM volopartenza AS vp, tratta AS tr, compagniaAerea AS ca, gate AS gt WHERE (xcodiceTratta = codiceTratta) AND (xcodicegate = codiceGate) ORDER BY datapartenza";

		try {
			pst = db.ConnessioneDB().prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				Object[] Lista = new Object[11];
				for (int i = 0; i <= 10; i++) {
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
		String sql = "DELETE FROM voloPartenza WHERE codiceVoloPartenza = ?";
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
		String sql = "UPDATE voloPartenza SET cittaarrivo = ?, datapartenza = ?, orapartenza = ?, minutoPartenza = ?, numeroprenotazioni = ?, ritardo = ?, minutoarrivo = ?, oraarrivo =? WHERE codiceVoloPartenza=?";
		try {
			db.ConnessioneDB();

			pst = db.ConnessioneDB().prepareStatement(sql);
			String dataPartenza = sdf.format(vlprtz.getDataPartenza());
			pst.setString(1, dataPartenza);
			pst.setString(2, vlprtz.getOraPartenza());
			pst.setString(3, vlprtz.getMinutoPartenza());
			pst.setString(4, vlprtz.getNumeroPrenotazioni());
			pst.setLong(5, vlprtz.getRitardo());
			pst.setString(6, vlprtz.getMinutoArrivo());
			pst.setString(7, vlprtz.getOraArrivo());
			pst.setString(8, vlprtz.getGt().getCodiceGate());
			pst.setString(9, vlprtz.getTrt().getCodiceTratta());
			pst.setString(10, vlprtz.getCompagniaAerea().getCodiceCompagniaAerea());
			pst.setString(11, vlprtz.getCodiceVoloPartenze());

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
		String sql = "INSERT INTO voloPartenza (codiceVoloPartenza, dataPartenza, oraPartenza, minutoPartenza, minutoarrivo, oraarrivo, numeroPrenotazioni, ritardo, xcodiceGate, xcodiceTratta, xcodiceCompagniaAerea) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		try {
			db.ConnessioneDB();

			pst = db.ConnessioneDB().prepareStatement(sql);

			pst.setString(1, vlprtz.getCodiceVoloPartenze());
			String dataPartenza = sdf.format(vlprtz.getDataPartenza());
			pst.setString(2, dataPartenza);
			pst.setString(3, vlprtz.getOraPartenza());
			pst.setString(4, vlprtz.getMinutoPartenza());
			pst.setString(5, vlprtz.getMinutoArrivo());
			pst.setString(6, vlprtz.getOraArrivo());
			pst.setString(7, vlprtz.getNumeroPrenotazioni());
			pst.setLong(8, vlprtz.getRitardo());
			pst.setString(9, vlprtz.getGt().getCodiceGate());
			pst.setString(10, vlprtz.getTrt().getCodiceTratta());
			pst.setString(11, vlprtz.getCompagniaAerea().getCodiceCompagniaAerea());
			

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
