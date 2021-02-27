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
		String sql = "SELECT vp.codiceVoloPartenza, ca.nome AS nomecompagniaaerea, gt.numeroporta, tr.cittaarrivo, vp.datapartenza, vp.orariopartenza, (orariopartenza - gt.tempodiimbarcostimato - '00:20:00') AS inizioimbarco, (orariopartenza - '00:20:00') AS fineimbarco, vp.numeroprenotazioni, vp.ritardo "
				+ "FROM volopartenza AS vp, tratta AS tr, compagniaAerea AS ca, gate AS gt "
				+ "WHERE (xcodiceTratta = codiceTratta) AND (xcodicegate = codiceGate) AND (xcodiceCompagniaAerea = codiceCompagniaAerea) ORDER BY datapartenza";

		try {
			pst = db.ConnessioneDB().prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				Object[] Lista = new Object[10];
				for (int i = 0; i <= 9; i++) {
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
		String sql = "UPDATE voloPartenza SET dataPartenza = ?, orarioPartenza = ?, numeroPrenotazioni = ?, ritardo = ?, xcodiceGate = ?, xcodiceTratta = ? WHERE codiceVoloPartenza=?";
		try {
			db.ConnessioneDB();

			pst = db.ConnessioneDB().prepareStatement(sql);
			long tempoDataPartenza = vlprtz.getDataPartenza().getTime();
			java.sql.Date dataPartenza = new java.sql.Date(tempoDataPartenza);
			pst.setDate(1, dataPartenza);
			pst.setTime(2, vlprtz.getOrarioPartenza());
			pst.setString(3, vlprtz.getNumeroPrenotazioni());
			pst.setLong(4, vlprtz.getRitardo());
			pst.setString(5, vlprtz.getGt().getCodiceGate());
			pst.setString(6, vlprtz.getTrt().getCodiceTratta());
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
		String sql = "INSERT INTO voloPartenza (codiceVoloPartenza, dataPartenza, orarioPartenza, numeroPrenotazioni, ritardo, xcodiceGate, xcodiceTratta) VALUES (?,?,?,?,?,?,?)";
		try {
			db.ConnessioneDB();

			pst = db.ConnessioneDB().prepareStatement(sql);

			pst.setString(1, vlprtz.getCodiceVoloPartenze());
			long tempoDataPartenza = vlprtz.getDataPartenza().getTime();
			java.sql.Date dataPartenza = new java.sql.Date(tempoDataPartenza);
			pst.setDate(2, dataPartenza);
			pst.setTime(3, vlprtz.getOrarioPartenza());
			pst.setString(4, vlprtz.getNumeroPrenotazioni());
			pst.setLong(5, vlprtz.getRitardo());
			pst.setString(6, vlprtz.getGt().getCodiceGate());
			pst.setString(7, vlprtz.getTrt().getCodiceTratta());
			
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
