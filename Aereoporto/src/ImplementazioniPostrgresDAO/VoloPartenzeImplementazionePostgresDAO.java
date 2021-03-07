package ImplementazioniPostrgresDAO;

import ClassiDAO.VoloPartenzeDAO;
import Database.ConnessioneDatabase;
import Classi.VoloPartenze;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import Classi.*;

public class VoloPartenzeImplementazionePostgresDAO implements VoloPartenzeDAO {

	ConnessioneDatabase db;
	VoloPartenze vlprtz = new VoloPartenze();
	Gate gt = new Gate();
	Tratta trt = new Tratta();
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private Connection connection;
	private PreparedStatement getVoloPartenzePS, inserisciVoloPartenzaPS, eliminaVoloPartenzaPS, modificaVoloPartenzePS;
	
	public VoloPartenzeImplementazionePostgresDAO(Connection connection) throws SQLException {
        this.connection=connection;
        
        getVoloPartenzePS = connection.prepareStatement("SELECT vp.codiceVoloPartenza, ca.nome AS nomecompagniaaerea, gt.numeroporta, tr.cittaarrivo, vp.dataOrariopartenza, (vp.dataOrarioPartenza - gt.tempodiimbarcostimato - gt.tempochiusuragate) AS aperturagate, (vp.dataOrarioPartenza - gt.tempochiusuragate) AS chiusuragate, vp.numeroprenotazioni, vp.statusImbarco, vp.status, vp.tempoDiImbarcoEffettivo, gt.tempodiimbarcostimato "
        		+ "FROM volopartenza AS vp, tratta AS tr, compagniaAerea AS ca, gate AS gt "
        		+ "WHERE (xcodiceTratta = codiceTratta) AND (xcodicegate = codiceGate) AND (xcodiceCompagniaAerea = codiceCompagniaAerea) ORDER BY dataOrariopartenza ");
        
        inserisciVoloPartenzaPS = connection.prepareStatement("INSERT INTO voloPartenza (codiceVoloPartenza, dataOrarioPartenza, numeroPrenotazioni, tempoDiImbarcoEffettivo, status, xcodiceGate, xcodiceTratta) VALUES (?, ?, ?, ?, ?, ?, ?)");
        eliminaVoloPartenzaPS = connection.prepareStatement("DELETE FROM voloPartenza WHERE codiceVoloPartenza = ?");
        modificaVoloPartenzePS = connection.prepareStatement("UPDATE voloPartenza SET dataOrarioPartenza = ?, numeroPrenotazioni = ?, tempodiimbarcoeffettivo = ?, status = ?, xcodiceGate = ?, xcodiceTratta = ? WHERE codiceVoloPartenza=?");
    }
	
	public List<VoloPartenze> getAllVoloPartenze() throws SQLException{
		
		int tempoImbarcoStimato;
		int tempoImbarcoEffettivo;
		
		ResultSet rs = getVoloPartenzePS.executeQuery();
		List<VoloPartenze> lista = new ArrayList<VoloPartenze>();
		while(rs.next()) {
			VoloPartenze vp= new VoloPartenze(rs.getString(1));
			vp.getTrt().getCompagniaAerea().setNome(rs.getString(2));
			vp.getGt().setNumeroPorta(rs.getString(3));
			vp.getTrt().setCittaArrivo(rs.getString(4));
			vp.setDataOrarioPartenza(rs.getTimestamp(5));
			vp.setNumeroPrenotazioni(rs.getString(8));
			tempoImbarcoStimato = Integer.parseInt(String.valueOf(rs.getTime(11)));
			tempoImbarcoEffettivo = Integer.parseInt(String.valueOf(rs.getTime(12)));
			if(tempoImbarcoEffettivo<= tempoImbarcoStimato) {
				
			}else {
					
			}
		}		
		rs.close();
        return lista;
	}
	
	public int inserisciVoloPartenze(VoloPartenze voloPartenze) throws SQLException{
		inserisciVoloPartenzaPS.setString(1, voloPartenze.getCodiceVoloPartenze());
		inserisciVoloPartenzaPS.setTimestamp(2, voloPartenze.getDataOrarioPartenza());
		inserisciVoloPartenzaPS.setString(3, voloPartenze.getNumeroPrenotazioni());
		inserisciVoloPartenzaPS.setTime(4, voloPartenze.getTempoImbarcoEffettivo());
		inserisciVoloPartenzaPS.setString(5, String.valueOf(voloPartenze.getStatusVolo()));
		inserisciVoloPartenzaPS.setString(6, voloPartenze.getGt().getCodiceGate());
		inserisciVoloPartenzaPS.setString(7, voloPartenze.getTrt().getCodiceTratta());
		
		int row = inserisciVoloPartenzaPS.executeUpdate();
		return row;
	}
	
	public int cancellaVoloPartenze(VoloPartenze voloPartenze) throws SQLException{
		eliminaVoloPartenzaPS.setString(1, voloPartenze.getCodiceVoloPartenze());
		
		int row = eliminaVoloPartenzaPS.executeUpdate();
		return row;
	}
	
	public int modificaVoloPartenze(VoloPartenze voloPartenze) throws SQLException{
		modificaVoloPartenzePS.setTimestamp(1, voloPartenze.getDataOrarioPartenza());
		modificaVoloPartenzePS.setString(2, voloPartenze.getNumeroPrenotazioni());
		modificaVoloPartenzePS.setTime(3, voloPartenze.getTempoImbarcoEffettivo());
		modificaVoloPartenzePS.setString(4, String.valueOf(voloPartenze.getStatusVolo()));
		modificaVoloPartenzePS.setString(5, voloPartenze.getGt().getCodiceGate());
		modificaVoloPartenzePS.setString(6, voloPartenze.getTrt().getCodiceTratta());
		modificaVoloPartenzePS.setString(7, voloPartenze.getCodiceVoloPartenze());
		
		int row = modificaVoloPartenzePS.executeUpdate();
		return row;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@SuppressWarnings("finally")
//	@Override // stampa voli
//	public ArrayList<Object[]> stampaVoliPartenze() {
//		ArrayList<Object[]> ListaVoliPartenze = new ArrayList<>();
//
//		int tempoImbarcoStimato;
//		int tempoImbarcoEffettivo;
//		String status = null;
//		PreparedStatement pst;
//		ResultSet rs;
//
//		String sql = "SELECT vp.codiceVoloPartenza, ca.nome AS nomecompagniaaerea, gt.numeroporta, tr.cittaarrivo, vp.dataOrariopartenza, (vp.dataOrarioPartenza - gt.tempodiimbarcostimato - gt.tempochiusuragate) AS aperturagate, (vp.dataOrarioPartenza - gt.tempochiusuragate) AS chiusuragate, vp.numeroprenotazioni, vp.statusImbarco, vp.status, vp.tempoDiImbarcoEffettivo, gt.tempodiimbarcostimato "
//				+ "FROM volopartenza AS vp, tratta AS tr, compagniaAerea AS ca, gate AS gt "
//				+ "WHERE (xcodiceTratta = codiceTratta) AND (xcodicegate = codiceGate) AND (xcodiceCompagniaAerea = codiceCompagniaAerea) ORDER BY dataOrariopartenza";
//
//		try {
//			pst = db.ConnessioneDB().prepareStatement(sql);
//			rs = pst.executeQuery();
//
//			while (rs.next()) {
//				
//				Object[] Lista = new Object[12];
//				for (int i = 0; i <= 9; i++) {
//					Lista[i] = rs.getObject(i + 1);
//	
//					tempoImbarcoStimato = Integer.parseInt(String.valueOf(rs.getTime(11)));
//					tempoImbarcoEffettivo = Integer.parseInt(String.valueOf(rs.getTime(12)));
//					if(tempoImbarcoEffettivo<= tempoImbarcoStimato) {
//						Lista[8] = "In orario";
//					}else {
//						Lista[8] = "In ritardo";
//					}
//					
//					status = rs.getString(9);
//					
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
//				}
//				
//				ListaVoliPartenze.add(Lista);
//			}
//			db.ConnessioneDB().close();
//
//		} catch (SQLException e) {
//			JOptionPane.showMessageDialog(null, "Errore: " + e.getMessage());
//		} finally {
//			return ListaVoliPartenze;
//		}
//	}
//
//
//	@Override // cancello una volo partenze
//	public boolean cancellaVoloPartenze(Object voloPartenze) {
//		vlprtz = (VoloPartenze) voloPartenze;
//
//		PreparedStatement pst;
//		String sql = "DELETE FROM voloPartenza WHERE codiceVoloPartenza = ?";
//		try {
//			db.ConnessioneDB();
//
//			pst = db.ConnessioneDB().prepareStatement(sql);
//
//			pst.setString(1, vlprtz.getCodiceVoloPartenze());
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
//	@Override // modifica info volo partenze
//	public boolean modificaVoloPartenze(Object voloPartenze) {
//		vlprtz = (VoloPartenze) voloPartenze;
//
//		PreparedStatement pst;
//		String sql = "UPDATE voloPartenza SET dataOrarioPartenza = ?, numeroPrenotazioni = ?, tempodiimbarcoeffettivo = ?,
//						status = ?, statisImbarco = ?, xcodiceGate = ?, xcodiceTratta = ? WHERE codiceVoloPartenza=?";
//		try {
//			db.ConnessioneDB();
//
//			pst = db.ConnessioneDB().prepareStatement(sql);
//			pst.setTimestamp(1, vlprtz.getDataOrarioPartenza());
//			pst.setString(2, vlprtz.getNumeroPrenotazioni());
//			pst.setTime(3, vlprtz.getTempoImbarcoEffettivo());
//			pst.setInt(4, vlprtz.getStatusVolo());
//			pst.setString(4, vlprtz.getGt().getCodiceGate());
//			pst.setString(5, vlprtz.getTrt().getCodiceTratta());
//			pst.setString(6, vlprtz.getCodiceVoloPartenze());
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
//	@Override // modifica info volo partenze
//	public boolean modificaStatusVoloPartenze(Object voloPartenze) {
//		vlprtz = (VoloPartenze) voloPartenze;
//
//		PreparedStatement pst;
//		String sql = "UPDATE voloPartenza SET status = ?, tempodiimbarcoeffettivo = ? WHERE codiceVoloPartenza=?";
//		try {
//			db.ConnessioneDB();
//
//			pst = db.ConnessioneDB().prepareStatement(sql);
//
//			pst.setInt(1, vlprtz.getStatusVolo());
//			pst.setTime(2, vlprtz.getTempoImbarcoEffettivo());
//			pst.setString(3, vlprtz.getCodiceVoloPartenze());
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
//	@Override // aggiungi volo partenze
//	public boolean aggiungiVoloPartenze(Object voloPartenze) {
//		vlprtz = (VoloPartenze) voloPartenze;
//
//		PreparedStatement pst;
//		String sql = "INSERT INTO voloPartenza (codiceVoloPartenza, dataOrarioPartenza, numeroPrenotazioni, tempoDiImbarcoEffettivo, status, xcodiceGate, xcodiceTratta) VALUES (?, ?, ?, ?, ?, ?, ?)";
//		try {
//			db.ConnessioneDB();
//
//			pst = db.ConnessioneDB().prepareStatement(sql);
//
//			pst.setString(1, vlprtz.getCodiceVoloPartenze());
//			pst.setTimestamp(2, vlprtz.getDataOrarioPartenza());
//			pst.setString(3, vlprtz.getNumeroPrenotazioni());
//			pst.setTime(4, vlprtz.getTempoImbarcoEffettivo());
//			pst.setInt(5, vlprtz.getStatusVolo());
//			pst.setString(6, vlprtz.getGt().getCodiceGate());
//			pst.setString(7, vlprtz.getTrt().getCodiceTratta());
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
