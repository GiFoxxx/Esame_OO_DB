package ImplementazioniPostrgresDAO;

import ClassiDAO.VoloPartenzeDAO;
import Database.ConnessioneDatabase;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
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

		int tempoImbarcoStimato;
		int tempoImbarcoEffettivo;
		String status = null;
		PreparedStatement pst;
		ResultSet rs;

		String sql = "SELECT vp.codiceVoloPartenza, ca.nome AS nomecompagniaaerea, gt.numeroporta, tr.cittaarrivo, vp.dataOrariopartenza, (vp.dataOrarioPartenza - gt.tempodiimbarcostimato - gt.tempochiusuragate) AS aperturagate, (vp.dataOrarioPartenza - gt.tempochiusuragate) AS chiusuragate, vp.numeroprenotazioni, vp.statusImbarco, vp.status, vp.tempoDiImbarcoEffettivo, gt.tempodiimbarcostimato "
				+ "FROM volopartenza AS vp, tratta AS tr, compagniaAerea AS ca, gate AS gt "
				+ "WHERE (xcodiceTratta = codiceTratta) AND (xcodicegate = codiceGate) AND (xcodiceCompagniaAerea = codiceCompagniaAerea) ORDER BY dataOrariopartenza";

		try {
			pst = db.ConnessioneDB().prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				Object[] Lista = new Object[12];
				for (int i = 0; i <= 9; i++) {
					Lista[i] = rs.getObject(i + 1);

					status = rs.getString(9);

//					switch (status) {
//					case "0":
//						Lista[9] = "In preparazione";
//						break;
//					case "1":
//						Lista[9] = "In partenza";
//						break;
//					case "2":
//						Lista[9] = "In ritardo";
//						break;
//					}
						
//					tempoImbarcoStimato = Integer.parseInt(String.valueOf(rs.getTime(11)));
//					tempoImbarcoEffettivo = Integer.parseInt(String.valueOf(rs.getTime(12)));
//					if(tempoImbarcoEffettivo<= tempoImbarcoStimato) {
//						Lista[8] = "In orario";
//					}else {
//						Lista[8] = "In ritardo";
//					}
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

//	@SuppressWarnings("finally")
//	public int tempoImbarcoStimato() {
//		int tempoImbarcoStimato = 0;
//		PreparedStatement pst;
//		ResultSet rs;
//		
//		String sql = "SELECT gt.tempodiimbarcostimato " + "FROM volopartenza AS vp, gate AS gt "
//				+ "WHERE (xcodicegate = codiceGate) ORDER BY dataOrariopartenza";
//		
//		try {
//			pst = db.ConnessioneDB().prepareStatement(sql);
//			rs = pst.executeQuery();
//			while (rs.next()) {
//				tempoImbarcoStimato = Integer.parseInt(String.valueOf(rs.getTime(1)));
//			}
//			
//
//		} catch (SQLException e) {
//			JOptionPane.showMessageDialog(null, "Errore: " + e.getMessage());
//		} finally {
//			return tempoImbarcoStimato;
//		}
//	}
//
//	@SuppressWarnings("finally")
//	public int tempoImbarcoEffettivo() {
//		int tempoImbarcoEffettivo = 0;
//		PreparedStatement pst;
//		ResultSet rs;
//		
//		String sql = "SELECT vp.tempodiimbarcoeffettivo  " + "FROM volopartenza AS vp, gate AS gt "
//				+ "WHERE (xcodicegate = codiceGate) ORDER BY dataOrariopartenza";
//		
//		try {
//			pst = db.ConnessioneDB().prepareStatement(sql);
//			rs = pst.executeQuery();
//			while (rs.next()) {
//				tempoImbarcoEffettivo = Integer.parseInt(String.valueOf(rs.getTime(1)));
//			}
//			
//
//		} catch (SQLException e) {
//			JOptionPane.showMessageDialog(null, "Errore: " + e.getMessage());
//		} finally {
//			return tempoImbarcoEffettivo;
//		}
//	}

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
		String sql = "UPDATE voloPartenza SET dataOrarioPartenza = ?, numeroPrenotazioni = ?, tempodiimbarcoeffettivo = ?, status = ?, xcodiceGate = ?, xcodiceTratta = ? WHERE codiceVoloPartenza=?";
		try {
			db.ConnessioneDB();

			pst = db.ConnessioneDB().prepareStatement(sql);
			pst.setTimestamp(1, vlprtz.getDataOrarioPartenza());
			pst.setString(2, vlprtz.getNumeroPrenotazioni());
			pst.setTime(3, vlprtz.getTempoImbarcoEffettivo());
			pst.setInt(4, vlprtz.getStatusVolo());
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
		String sql = "UPDATE voloPartenza SET status = ?, tempodiimbarcoeffettivo = ? WHERE codiceVoloPartenza=?";
		try {
			db.ConnessioneDB();

			pst = db.ConnessioneDB().prepareStatement(sql);

			pst.setInt(1, vlprtz.getStatusVolo());
			pst.setTime(2, vlprtz.getTempoImbarcoEffettivo());
			pst.setString(3, vlprtz.getCodiceVoloPartenze());

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
		String sql = "INSERT INTO voloPartenza (codiceVoloPartenza, dataOrarioPartenza, numeroPrenotazioni, tempoDiImbarcoEffettivo, status, xcodiceGate, xcodiceTratta) VALUES (?, ?, ?, ?, ?, ?, ?)";
		try {
			db.ConnessioneDB();

			pst = db.ConnessioneDB().prepareStatement(sql);

			pst.setString(1, vlprtz.getCodiceVoloPartenze());
			pst.setTimestamp(2, vlprtz.getDataOrarioPartenza());
			pst.setString(3, vlprtz.getNumeroPrenotazioni());
			pst.setTime(4, vlprtz.getTempoImbarcoEffettivo());
			pst.setInt(5, vlprtz.getStatusVolo());
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
