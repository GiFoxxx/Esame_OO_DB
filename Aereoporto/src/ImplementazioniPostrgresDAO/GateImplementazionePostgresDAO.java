package ImplementazioniPostrgresDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import Amministrazione.Utente;
import Classi.CodaDiImbarco;
import Classi.CompagniaAerea;
import Classi.Gate;
import ClassiDAO.GateDAO;
import Controller.Controller;
import Database.ConnessioneDatabase;
import GUI.GestioneVoliPartenze;

public class GateImplementazionePostgresDAO implements GateDAO {

	private Connection connection;
	private PreparedStatement stampaGatePS, stampaGateCodeImbarcoPS, aggiungiGatePS, aggiungiGateInCodaDiImbarcoGatePS,
			cancellaGatePS, modificaGatePS, stampaNumeroPortaInComboBoxPS;

	public GateImplementazionePostgresDAO(Connection connection) throws SQLException {
		this.connection = connection;

		stampaGatePS = connection.prepareStatement("SELECT DISTINCT * FROM gate AS gt ORDER BY numeroPorta");
		stampaGateCodeImbarcoPS = connection
				.prepareStatement("SELECT DISTINCT gt.codicegate, gt.numeroporta, cdi.nomecoda AS nomeCoda "
						+ "FROM gate AS gt , codadiimbarco AS cdi, codadiimbarcogate AS cdigt "
						+ "WHERE ((xcodicecodadiimbarco = codicecodadiimbarco)) AND (xcodicegate=codicegate) ORDER BY numeroporta");
		aggiungiGatePS = connection.prepareStatement(
				"INSERT INTO gate (codiceGate, numeroPorta, tempodiimbarcostimato, tempoChiusuraGate) VALUES (?, ?, ?, ?)");
		aggiungiGateInCodaDiImbarcoGatePS = connection
				.prepareStatement("INSERT INTO codadiimbarcogate (xcodiceGate, xcodicecodaDiImbarco) VALUES (?, ?)");
		cancellaGatePS = connection.prepareStatement("DELETE FROM gate WHERE codiceGate = ?");
		modificaGatePS = connection.prepareStatement(
				"UPDATE gate SET numeroporta = ?, tempodiimbarcostimato = ?, tempoChiusuraGate = ? WHERE codiceGate = ?");
		stampaNumeroPortaInComboBoxPS = connection.prepareStatement("SELECT * FROM gate ORDER BY numeroPorta");
	}

	public List<Gate> stampaGate() throws SQLException {

		ResultSet rs = stampaGatePS.executeQuery();
		List<Gate> lista = new ArrayList<Gate>();
		while (rs.next()) {
			Gate gt = new Gate();
			gt.setCodiceGate(rs.getString("codiceGate"));
			gt.setNumeroPorta(rs.getString("numeroPorta"));
			gt.setTempoImbarcoStimato(rs.getTime("tempoDiImbarcoStimato"));
			lista.add(gt);
		}
		rs.close();
		return lista;
	}
	
	public List<Gate> stampaGateCodeImbarco() throws SQLException {

		ResultSet rs = stampaGateCodeImbarcoPS.executeQuery();
		List<Gate> lista = new ArrayList<Gate>();
		while (rs.next()) {
			Gate gt = new Gate();
			CodaDiImbarco codaImbarco = new CodaDiImbarco();
			gt.setCodiceGate(rs.getString("codiceGate"));
			gt.setNumeroPorta(rs.getString("numeroPorta"));
			codaImbarco.setNomeCoda(rs.getString("nomeCoda"));
			gt.setCodeDiImbarco(codaImbarco);
			lista.add(gt);
		}
		rs.close();
		return lista;
	}

	public int aggiungiGate(Gate gt) throws SQLException {
		aggiungiGatePS.setString(1, gt.getCodiceGate());
		aggiungiGatePS.setString(2, gt.getNumeroPorta());
		aggiungiGatePS.setTime(3, gt.getTempoImbarcoStimato());
		aggiungiGatePS.setTime(4, gt.getTempoChiusuraGate());

		int row = aggiungiGatePS.executeUpdate();
		return row;
	}
	
	public int aggiungiGateInCodaDiImbarcoGate(Gate gt, CodaDiImbarco codaImbarco) throws SQLException {
		aggiungiGateInCodaDiImbarcoGatePS.setString(1, gt.getCodiceGate());
		aggiungiGateInCodaDiImbarcoGatePS.setString(2, codaImbarco.getCodiceCodaDiImbarco());

		int row = aggiungiGateInCodaDiImbarcoGatePS.executeUpdate();
		return row;
	}

	public int cancellaGate(Gate gt) throws SQLException {
		cancellaGatePS.setString(1, gt.getCodiceGate());

		int row = cancellaGatePS.executeUpdate();
		return row;
	}

	public int modificaGate(Gate gt) throws SQLException {
		modificaGatePS.setString(1, gt.getNumeroPorta());
		modificaGatePS.setTime(2, gt.getTempoImbarcoStimato());
		modificaGatePS.setTime(3, gt.getTempoChiusuraGate());
		modificaGatePS.setString(4, gt.getCodiceGate());

		int row = modificaGatePS.executeUpdate();
		return row;
	}

	public HashMap<String, String> stampaNumeroPortaInComboBox() throws SQLException {
		HashMap<String, String> map = new HashMap<String, String>();

		ResultSet rs = stampaNumeroPortaInComboBoxPS.executeQuery();
		while (rs.next()) {
			Gate gt = new Gate(rs.getString(2), rs.getString(1));
			map.put(gt.getCodiceGate(), gt.getNumeroPorta());
		}

		return map;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@SuppressWarnings("finally")
//	@Override // stampa gate
//	public ArrayList<Object[]> stampaGate() {
//		ArrayList<Object[]> ListaGate = new ArrayList<>();
//
//		PreparedStatement pst;
//		ResultSet rs;
//		String sql = "SELECT DISTINCT * " + "FROM gate AS gt " + "ORDER BY numeroPorta";
//
//		try {
//			pst = db.ConnessioneDB().prepareStatement(sql);
//			rs = pst.executeQuery();
//			while (rs.next()) {
//				Object[] Lista = new Object[3];
//				for (int i = 0; i <= 2; i++) {
//					Lista[i] = rs.getObject(i + 1);
//				}
//				ListaGate.add(Lista);
//			}
//			db.ConnessioneDB().close();
//
//		} catch (SQLException e) {
//			JOptionPane.showMessageDialog(null, "Errore: " + e.getMessage());
//		} finally {
//			return ListaGate;
//		}
//	}
//
//	@SuppressWarnings("finally")
//	@Override // stampa gate
//	public ArrayList<Object[]> stampaGateCodeImbarco() {
//		ArrayList<Object[]> ListaGate = new ArrayList<>();
//
//		PreparedStatement pst;
//		ResultSet rs;
//		String sql = "SELECT DISTINCT gt.codicegate, gt.numeroporta, nomecoda AS nomeCoda "
//				+ "FROM gate AS gt , codadiimbarco AS cdi, codadiimbarcogate AS cdigt "
//				+ "WHERE ((xcodicecodadiimbarco = codicecodadiimbarco)) AND (xcodicegate=codicegate) ORDER BY numeroporta";
//
//		try {
//			pst = db.ConnessioneDB().prepareStatement(sql);
//			rs = pst.executeQuery();
//			while (rs.next()) {
//				Object[] Lista = new Object[3];
//				for (int i = 0; i <= 2; i++) {
//					Lista[i] = rs.getObject(i + 1);
//				}
//				ListaGate.add(Lista);
//			}
//			db.ConnessioneDB().close();
//
//		} catch (SQLException e) {
//			JOptionPane.showMessageDialog(null, "Errore: " + e.getMessage());
//		} finally {
//			return ListaGate;
//		}
//	}
//
//	@Override // aggiungo un gate
//	public boolean aggiungiGate(Object gate) {
//		gt = (Gate) gate;
//		PreparedStatement pst;
//		String sql = "INSERT INTO gate (codiceGate, numeroPorta, tempodiimbarcostimato, tempoChiusuraGate) VALUES (?, ?, ?, ?)";
//		try {
//			db.ConnessioneDB();
//
//			pst = db.ConnessioneDB().prepareStatement(sql);
//
//			pst.setString(1, gt.getCodiceGate());
//			pst.setString(2, gt.getNumeroPorta());
//			pst.setTime(3, gt.getTempoImbarcoStimato());
//			pst.setTime(4, gt.getTempoChiusuraGate());
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
//	@Override // aggiungo un codadiimbarcogate
//	public boolean aggiungiGateInCodaDiImbarcoGate(Object gate, Object codaDiImbarco) {
//		gt = (Gate) gate;
//		codaImbarco = (CodaDiImbarco) codaDiImbarco;
//		PreparedStatement pst;
//
//		String sql = "INSERT INTO codadiimbarcogate (xcodiceGate, xcodicecodaDiImbarco) VALUES (?, ?)";
//		try {
//			db.ConnessioneDB();
//
//			pst = db.ConnessioneDB().prepareStatement(sql);
//
//			pst.setString(1, gt.getCodiceGate());
//			pst.setString(2, codaImbarco.getCodiceCodaDiImbarco());
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
//	@Override
//	public boolean cancellaGate(Object gate) {
//		gt = (Gate) gate;
//
//		PreparedStatement pst;
//		String sql = "DELETE FROM gate WHERE codiceGate = ?";
//		try {
//			db.ConnessioneDB();
//
//			pst = db.ConnessioneDB().prepareStatement(sql);
//
//			pst.setString(1, gt.getCodiceGate());
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
//	@Override
//	public boolean modificaGate(Object gate) {
//		gt = (Gate) gate;
//		PreparedStatement pst;
//		String sql = "UPDATE gate SET numeroporta = ?, tempodiimbarcostimato = ?, tempoChiusuraGate = ? WHERE codiceGate = ?";
//		try {
//			db.ConnessioneDB();
//
//			pst = db.ConnessioneDB().prepareStatement(sql);
//
//			pst.setString(1, gt.getNumeroPorta());
//			pst.setTime(2, gt.getTempoImbarcoStimato());
//			pst.setTime(3, gt.getTempoChiusuraGate());
//			pst.setString(4, gt.getCodiceGate());
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
//	@Override
//	public HashMap<String, String> stampaNumeroPortaInComboBox() {
//
//		HashMap<String, String> map = new HashMap<String, String>();
//
//		PreparedStatement pst;
//		ResultSet rs;
//		String sql = "SELECT * FROM gate ORDER BY numeroPorta";
//
//		try {
//			pst = db.ConnessioneDB().prepareStatement(sql);
//			rs = pst.executeQuery();
//			Gate gt;
//
//			while (rs.next()) {
//				gt = new Gate(rs.getString(2), rs.getString(1));
//				map.put(gt.getCodiceGate(), gt.getNumeroPorta());
//			}
//
//		} catch (SQLException e) {
//			JOptionPane.showMessageDialog(null, "Errore: " + e.getMessage());
//		}
//		return map;
//	}

}
