package ImplementazioniPostrgresDAO;

import ClassiDAO.VoloArriviDAO;
import Database.ConnessioneDatabase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Classi.*;

public class VoloArriviImplementazionePostgresDAO implements VoloArriviDAO {

	ConnessioneDatabase db = new ConnessioneDatabase();
	VoloArrivi vlarr = new VoloArrivi();
	Gate gt = new Gate();
	Tratta trt = new Tratta();
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	

	@SuppressWarnings("finally")
	@Override // stampa voli
	public ArrayList<Object[]> stampaVoliArrivi() {
		ArrayList<Object[]> ListaVoliArrivi = new ArrayList<>();

		PreparedStatement pst;
		ResultSet rs;
		String sql = "SELECT * FROM voloArrivo ORDER BY dataarrivo";

		try {
			pst = db.ConnessioneDB().prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				Object[] Lista = new Object[4];
				for (int i = 0; i <= 3; i++) {
					Lista[i] = rs.getObject(i + 1);
				}
				ListaVoliArrivi.add(Lista);
			}
			db.ConnessioneDB().close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Errore: " + e.getMessage());
		} finally {
			return ListaVoliArrivi;
		}
	}

	@Override // cancello una volo
	public boolean cancellaVoloArrivi(Object voloArrivi) {
		vlarr = (VoloArrivi) voloArrivi;

		PreparedStatement pst;
		String sql = "DELETE FROM voloArrivo WHERE codiceVoloArrivo = ?";
		try {
			db.ConnessioneDB();

			pst = db.ConnessioneDB().prepareStatement(sql);

			pst.setString(1, vlarr.getCodiceVoloArrivi());

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

	@Override // modifica info volo
	public boolean modificaVoloArrivi(Object voloArrivi) {
		vlarr = (VoloArrivi) voloArrivi;
		
		PreparedStatement pst;
		String sql = "UPDATE voloArrivo SET cittapartenza = ?, dataarrivo = ?, orarioarrivo = ? WHERE codiceVoloArrivo = ?";
		try {
			db.ConnessioneDB();

			pst = db.ConnessioneDB().prepareStatement(sql);
			pst.setString(1, vlarr.getCittaPartenza());
			long tempoDataPartenza = vlarr.getDataArrivo().getTime();
			java.sql.Date dataPartenza = new java.sql.Date(tempoDataPartenza);
			pst.setDate(2, dataPartenza);
			pst.setTime(3, vlarr.getOrarioArrivo());
			pst.setString(4, vlarr.getCodiceVoloArrivi());

			
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

	@Override // aggiungi volo arrivi
	public boolean aggiungiVoloArrivi(Object voloArrivi) {
		vlarr = (VoloArrivi) voloArrivi;
		
		PreparedStatement pst;
		String sql = "INSERT INTO voloArrivo (codiceVoloArrivo, cittaPartenza, dataArrivo, orarioArrivo) VALUES (?,?,?,?)";
		try {
			db.ConnessioneDB();

			pst = db.ConnessioneDB().prepareStatement(sql);

			pst.setString(1, vlarr.getCodiceVoloArrivi());
			pst.setString(2, vlarr.getCittaPartenza());
			long tempoDataPartenza = vlarr.getDataArrivo().getTime();
			java.sql.Date dataPartenza = new java.sql.Date(tempoDataPartenza);
			pst.setDate(3, dataPartenza);
			pst.setTime(4, vlarr.getOrarioArrivo());

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
