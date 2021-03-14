package ImplementazioniPostrgresDAO;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Classi.CodaDiImbarco;
import Classi.Gate;
import ClassiDAO.GateDAO;

public class GateImplementazionePostgresDAO implements GateDAO {

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private Connection connection;
	private PreparedStatement stampaGatePS, stampaGateCodeImbarcoPS, aggiungiGatePS, aggiungiGateInCodaDiImbarcoGatePS,
			cancellaGatePS, modificaGatePS, stampaUtilizzoGiornalieroPS, stampaUtilizzoSettimanalePS,
			stampaUtilizzoMensilePS, stampaNumeroPortaInComboBoxPS;

	public GateImplementazionePostgresDAO(Connection connection) throws SQLException {
		this.connection = connection;

		stampaGatePS = connection.prepareStatement("SELECT DISTINCT * FROM gate AS gt ORDER BY numeroPorta");
		stampaGateCodeImbarcoPS = connection
				.prepareStatement("SELECT DISTINCT gt.codicegate, gt.numeroporta, cdi.nomecoda AS nomeCoda "
						+ "FROM ((gate AS gt INNER JOIN codadiimbarcogate AS cdigt ON (xcodicegate=codicegate)) INNER JOIN codadiimbarco AS cdi ON (xcodicecodadiimbarco = codicecodadiimbarco)) "
						+ "ORDER BY numeroporta");
		aggiungiGatePS = connection.prepareStatement(
				"INSERT INTO gate (codiceGate, numeroPorta, tempodiimbarcostimato, tempoChiusuraGate) VALUES (?, ?, ?, ?)");
		aggiungiGateInCodaDiImbarcoGatePS = connection
				.prepareStatement("INSERT INTO codadiimbarcogate (xcodiceGate, xcodicecodaDiImbarco) VALUES (?, ?)");
		cancellaGatePS = connection.prepareStatement("DELETE FROM gate WHERE codiceGate = ?");
		modificaGatePS = connection.prepareStatement(
				"UPDATE gate SET numeroporta = ?, tempodiimbarcostimato = ?, tempoChiusuraGate = ? WHERE codiceGate = ?");
		stampaUtilizzoGiornalieroPS = connection.prepareStatement(
				"SELECT gt.codiceGate, extract(year from dataOrarioPartenza) AS annoUtilizzo , extract (day from dataOrarioPartenza) AS giorniUtilizzo,"
						+ "SUM (tempoDiImbarcoEffettivo) AS totaleUtilizzoEffettivo, SUM (tempoDiImbarcoStimato) AS totaleUtilizzoStimato "
						+ "FROM voloPartenza AS vlp INNER JOIN Gate AS gt ON  (xcodiceGate=codicegate) "
						+ "WHERE (CAST(vlp.dataOrarioPartenza AS date) = ?) AND (xcodiceGate = ?) "
						+ "GROUP BY annoUtilizzo,giorniUtilizzo, codiceGate;");
		stampaUtilizzoSettimanalePS = connection.prepareStatement(
				"SELECT gt.codiceGate, extract(year from dataOrarioPartenza) AS annoUtilizzo , extract (week from dataOrarioPartenza) AS settimanaUtilizzo, "
						+ "SUM (tempoDiImbarcoEffettivo) AS totaleUtilizzoEffettivo, SUM (tempoDiImbarcoStimato) AS totaleUtilizzoStimato "
						+ "FROM voloPartenza AS vlp INNER JOIN Gate AS gt ON  (xcodiceGate=codicegate) "
						+ "WHERE (extract (month from dataOrarioPartenza) = ?) AND (xcodiceGate = ?) "
						+ "GROUP BY annoUtilizzo,settimanaUtilizzo, codiceGate;");
		stampaUtilizzoMensilePS = connection.prepareStatement(
				"SELECT gt.codiceGate, extract(year from dataOrarioPartenza) AS annoUtilizzo , extract (month from dataOrarioPartenza) AS meseUtilizzo, "
						+ "SUM (tempoDiImbarcoEffettivo) AS totaleUtilizzoEffettivo, SUM (tempoDiImbarcoStimato) AS totaleUtilizzoStimato "
						+ "FROM voloPartenza AS vlp INNER JOIN Gate AS gt ON  (xcodiceGate=codicegate) "
						+ "WHERE (extract (month from dataOrarioPartenza) = ?) AND (xcodiceGate = ?) "
						+ "GROUP BY annoUtilizzo,meseUtilizzo, codiceGate;");
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

	public List<Gate> stampaUtilizzoGiornaliero(Gate gt, Timestamp dataUtilizzo) throws SQLException {
		stampaUtilizzoGiornalieroPS.setTimestamp(1, dataUtilizzo);
		stampaUtilizzoGiornalieroPS.setString(2, gt.getCodiceGate());

		ResultSet rs = stampaUtilizzoGiornalieroPS.executeQuery();
		List<Gate> lista = new ArrayList<Gate>();

		while (rs.next()) {
			Gate gate = new Gate();

			Time totaleUtilizzoEffettivo = rs.getTime("totaleUtilizzoEffettivo");
			Time totaleUtilizzoStimato = rs.getTime("totaleUtilizzoStimato");

			gate.setCodiceGate(rs.getString("codiceGate"));
			gate.setTotaleUtilizzoEffettivo(totaleUtilizzoEffettivo);
			gate.setTotaleUtilizzoStimato(totaleUtilizzoStimato);
			lista.add(gate);
		}
		rs.close();
		return lista;
	}

	@SuppressWarnings("deprecation")
	public List<Gate> stampaUtilizzoSettimanale(Gate gt, Timestamp dataUtilizzo) throws SQLException {
		stampaUtilizzoSettimanalePS.setInt(1, dataUtilizzo.getMonth()+1);
		stampaUtilizzoSettimanalePS.setString(2, gt.getCodiceGate());

		ResultSet rs = stampaUtilizzoSettimanalePS.executeQuery();
		List<Gate> lista = new ArrayList<Gate>();

		while (rs.next()) {
			Gate gate = new Gate();

			Time totaleUtilizzoEffettivo = rs.getTime("totaleUtilizzoEffettivo");
			Time totaleUtilizzoStimato = rs.getTime("totaleUtilizzoStimato");

			gate.setCodiceGate(rs.getString("codiceGate"));
			gate.setTotaleUtilizzoEffettivo(totaleUtilizzoEffettivo);
			gate.setTotaleUtilizzoStimato(totaleUtilizzoStimato);
			lista.add(gate);
		}
		rs.close();
		return lista;
	}

	@SuppressWarnings("deprecation")
	public List<Gate> stampaUtilizzoMensile(Gate gt, Timestamp dataUtilizzo) throws SQLException {
		stampaUtilizzoMensilePS.setInt(1, dataUtilizzo.getMonth()+1);
		stampaUtilizzoMensilePS.setString(2, gt.getCodiceGate());

		ResultSet rs = stampaUtilizzoMensilePS.executeQuery();
		List<Gate> lista = new ArrayList<Gate>();

		while (rs.next()) {
			Gate gate = new Gate();

			Time totaleUtilizzoEffettivo = rs.getTime("totaleUtilizzoEffettivo");
			Time totaleUtilizzoStimato = rs.getTime("totaleUtilizzoStimato");

			gate.setCodiceGate(rs.getString("codiceGate"));
			gate.setTotaleUtilizzoEffettivo(totaleUtilizzoEffettivo);
			gate.setTotaleUtilizzoStimato(totaleUtilizzoStimato);
			lista.add(gate);
		}
		rs.close();
		return lista;
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
}
