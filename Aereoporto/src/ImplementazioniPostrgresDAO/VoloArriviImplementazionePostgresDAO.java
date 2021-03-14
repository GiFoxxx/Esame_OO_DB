package ImplementazioniPostrgresDAO;

import ClassiDAO.VoloArriviDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Classi.*;

public class VoloArriviImplementazionePostgresDAO implements VoloArriviDAO {

	private Connection connection;
	private PreparedStatement stampaVoliArriviPS, aggiungiVoloArriviPS, cancellaVoloArriviPS,
	modificaVoloArriviPS;

	public VoloArriviImplementazionePostgresDAO(Connection connection) throws SQLException {
		this.connection = connection;

		stampaVoliArriviPS = connection.prepareStatement("SELECT * FROM voloArrivo ORDER BY dataOrarioArrivo");
		aggiungiVoloArriviPS = connection
				.prepareStatement("INSERT INTO voloArrivo (codiceVoloArrivo, cittaPartenza, dataOrarioArrivo) VALUES (?,?,?)");
		cancellaVoloArriviPS = connection
				.prepareStatement("DELETE FROM voloArrivo WHERE codiceVoloArrivo = ?");
		modificaVoloArriviPS = connection
				.prepareStatement("UPDATE voloArrivo SET cittapartenza = ?, dataorarioarrivo = ? WHERE codiceVoloArrivo = ?");
	}

	public List<VoloArrivi> stampaVoliArrivi() throws SQLException {

		ResultSet rs = stampaVoliArriviPS.executeQuery();
		List<VoloArrivi> lista = new ArrayList<VoloArrivi>();
		while (rs.next()) {
			VoloArrivi vlArr = new VoloArrivi();
			vlArr.setCodiceVoloArrivi(rs.getString("codicevoloarrivo"));
			vlArr.setCittaPartenza(rs.getString("cittapartenza"));
			vlArr.setDataOrarioPartenza(rs.getTimestamp("dataorarioArrivo"));
			
			lista.add(vlArr);
		}
		rs.close();
		return lista;
	}

	public int aggiungiVoloArrivi(VoloArrivi vlArr) throws SQLException {
		aggiungiVoloArriviPS.setString(1, vlArr.getCodiceVoloArrivi());
		aggiungiVoloArriviPS.setString(2, vlArr.getCittaPartenza());
		aggiungiVoloArriviPS.setTimestamp(3, vlArr.getDataOrarioPartenza());

		int row = aggiungiVoloArriviPS.executeUpdate();
		return row;
	}

	public int cancellaVoloArrivi(VoloArrivi vlArr) throws SQLException {
		cancellaVoloArriviPS.setString(1, vlArr.getCodiceVoloArrivi());

		int row = cancellaVoloArriviPS.executeUpdate();
		return row;
	}

	public int modificaVoloArrivi(VoloArrivi vlArr) throws SQLException {
		modificaVoloArriviPS.setString(1, vlArr.getCittaPartenza());
		modificaVoloArriviPS.setTimestamp(2, vlArr.getDataOrarioPartenza());
		modificaVoloArriviPS.setString(3, vlArr.getCodiceVoloArrivi());

		int row = modificaVoloArriviPS.executeUpdate();
		return row;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

//	@SuppressWarnings("finally")
//	@Override // stampa voli
//	public ArrayList<Object[]> stampaVoliArrivi() {
//		ArrayList<Object[]> ListaVoliArrivi = new ArrayList<>();
//
//		PreparedStatement pst;
//		ResultSet rs;
//		String sql = "SELECT * FROM voloArrivo ORDER BY dataarrivo";
//
//		try {
//			pst = db.ConnessioneDB().prepareStatement(sql);
//			rs = pst.executeQuery();
//			while (rs.next()) {
//				Object[] Lista = new Object[4];
//				for (int i = 0; i <= 3; i++) {
//					Lista[i] = rs.getObject(i + 1);
//				}
//				ListaVoliArrivi.add(Lista);
//			}
//			db.ConnessioneDB().close();
//
//		} catch (SQLException e) {
//			JOptionPane.showMessageDialog(null, "Errore: " + e.getMessage());
//		} finally {
//			return ListaVoliArrivi;
//		}
//	}
//
//	@Override // cancello una volo
//	public boolean cancellaVoloArrivi(Object voloArrivi) {
//		vlarr = (VoloArrivi) voloArrivi;
//
//		PreparedStatement pst;
//		String sql = "DELETE FROM voloArrivo WHERE codiceVoloArrivo = ?";
//		try {
//			db.ConnessioneDB();
//
//			pst = db.ConnessioneDB().prepareStatement(sql);
//
//			pst.setString(1, vlarr.getCodiceVoloArrivi());
//
//			int res = pst.executeUpdate();
//
//			if (res > 0) {
//				db.ConnessioneDB().close();
//				return true;
//			} else {
//				db.ConnessioneDB().close();
//				return false;
//			}
//
//		} catch (SQLException e) {
//			JOptionPane.showMessageDialog(null, "Errore: " + e.getMessage());
//			return false;
//		}
//	}
//
//	@Override // modifica info volo
//	public boolean modificaVoloArrivi(Object voloArrivi) {
//		vlarr = (VoloArrivi) voloArrivi;
//		
//		PreparedStatement pst;
//		String sql = "UPDATE voloArrivo SET cittapartenza = ?, dataarrivo = ?, orarioarrivo = ? WHERE codiceVoloArrivo = ?";
//		try {
//			db.ConnessioneDB();
//
//			pst = db.ConnessioneDB().prepareStatement(sql);
//			pst.setString(1, vlarr.getCittaPartenza());
//			long tempoDataPartenza = vlarr.getDataArrivo().getTime();
//			java.sql.Date dataPartenza = new java.sql.Date(tempoDataPartenza);
//			pst.setDate(2, dataPartenza);
//			pst.setTime(3, vlarr.getOrarioArrivo());
//			pst.setString(4, vlarr.getCodiceVoloArrivi());
//
//			
//			int res = pst.executeUpdate();
//
//			if (res > 0) {
//				db.ConnessioneDB().close();
//				return true;
//			} else {
//				db.ConnessioneDB().close();
//				return false;
//			}
//		} catch (SQLException e) {
//			JOptionPane.showMessageDialog(null, "Errore: " + e.getMessage());
//			return false;
//		}
//	}
//
//	@Override // aggiungi volo arrivi
//	public boolean aggiungiVoloArrivi(Object voloArrivi) {
//		vlarr = (VoloArrivi) voloArrivi;
//		
//		PreparedStatement pst;
//		String sql = "INSERT INTO voloArrivo (codiceVoloArrivo, cittaPartenza, dataArrivo, orarioArrivo) VALUES (?,?,?,?)";
//		try {
//			db.ConnessioneDB();
//
//			pst = db.ConnessioneDB().prepareStatement(sql);
//
//			pst.setString(1, vlarr.getCodiceVoloArrivi());
//			pst.setString(2, vlarr.getCittaPartenza());
//			long tempoDataPartenza = vlarr.getDataArrivo().getTime();
//			java.sql.Date dataPartenza = new java.sql.Date(tempoDataPartenza);
//			pst.setDate(3, dataPartenza);
//			pst.setTime(4, vlarr.getOrarioArrivo());
//
//			int res = pst.executeUpdate();
//
//			if (res > 0) {
//				db.ConnessioneDB().close();
//				return true;
//			} else {
//				db.ConnessioneDB().close();
//				return false;
//			}
//
//		} catch (SQLException e) {
//			JOptionPane.showMessageDialog(null, "Errore: " + e.getMessage());
//			return false;
//		}
//	}

}
