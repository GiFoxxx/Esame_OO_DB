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
		String sql = "SELECT vp.codiceVoloPartenza, ca.nome AS nomecompagniaaerea, gt.numeroporta, tr.cittaarrivo, vp.dataOrariopartenza, (vp.dataOrarioPartenza - gt.tempodiimbarcostimato) AS aperturagate, vp.dataOrarioPartenza AS chiusuragate, vp.numeroprenotazioni, vp.status "
				+ "FROM volopartenza AS vp, tratta AS tr, compagniaAerea AS ca, gate AS gt "
				+ "WHERE (xcodiceTratta = codiceTratta) AND (xcodicegate = codiceGate) AND (xcodiceCompagniaAerea = codiceCompagniaAerea) ORDER BY dataOrariopartenza";

		try {
			pst = db.ConnessioneDB().prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				Object[] Lista = new Object[9];
				for (int i = 0; i <= 8; i++) {
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
		String sql = "UPDATE voloPartenza SET dataPartenza = ?, orarioPartenza = ?, numeroPrenotazioni = ?, xcodiceGate = ?, xcodiceTratta = ? WHERE codiceVoloPartenza=?";
		try {
			db.ConnessioneDB();

			pst = db.ConnessioneDB().prepareStatement(sql);
			long tempoDataPartenza = vlprtz.getDataPartenza().getTime();
			java.sql.Date dataPartenza = new java.sql.Date(tempoDataPartenza);
			pst.setDate(1, dataPartenza);
			pst.setTime(2, vlprtz.getOrarioPartenza());
			pst.setString(3, vlprtz.getNumeroPrenotazioni());
			pst.setString(4, vlprtz.getGt().getCodiceGate());
			pst.setString(5, vlprtz.getTrt().getCodiceTratta());
			pst.setString(6, vlprtz.getCodiceVoloPartenze());

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
	public boolean modificaStatusVoloPartenze(Object voloPartenze) {
		vlprtz = (VoloPartenze) voloPartenze;

		PreparedStatement pst;
		String sql = "UPDATE voloPartenza SET status = ? WHERE codiceVoloPartenza=?";
		try {
			db.ConnessioneDB();

			pst = db.ConnessioneDB().prepareStatement(sql);
			
			pst.setBoolean(1, vlprtz.isStatus());
			pst.setString(2, vlprtz.getCodiceVoloPartenze());

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
		String sql = "INSERT INTO voloPartenza (codiceVoloPartenza, dataOrarioPartenza, numeroPrenotazioni, xcodiceGate, xcodiceTratta) VALUES (?,?,?,?,?)";
		try {
			db.ConnessioneDB();

			pst = db.ConnessioneDB().prepareStatement(sql);

			pst.setString(1, vlprtz.getCodiceVoloPartenze());
			pst.setTimestamp(2, vlprtz.getDataOrarioPartenza());
			pst.setString(3, vlprtz.getNumeroPrenotazioni());
			pst.setString(4, vlprtz.getGt().getCodiceGate());
			pst.setString(5, vlprtz.getTrt().getCodiceTratta());
			
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
