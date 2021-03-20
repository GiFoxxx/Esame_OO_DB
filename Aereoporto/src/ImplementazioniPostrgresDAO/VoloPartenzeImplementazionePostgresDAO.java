package ImplementazioniPostrgresDAO;

import ClassiDAO.VoloPartenzeDAO;

import Classi.VoloPartenze;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import org.postgresql.util.PSQLException;

import Classi.*;

public class VoloPartenzeImplementazionePostgresDAO implements VoloPartenzeDAO {

	private String statusScrittoImbarco;

	private PreparedStatement stampaVoloPartenzePS, stampaRegistroVoloPartenzePS, inserisciVoloPartenzaPS, eliminaVoloPartenzaPS,
			modificaVoloPartenzePS, modificaStatusVoloPartenzePS, selezioneTempiImbarcoPerVoloModificatoPS;

	public VoloPartenzeImplementazionePostgresDAO(Connection connection) throws SQLException {
		stampaVoloPartenzePS = connection.prepareStatement(
				"SELECT vp.codiceVoloPartenza, ca.nome AS nomecompagniaaerea, gt.numeroporta, tr.cittaarrivo, vp.dataOrariopartenza, (vp.dataOrarioPartenza - gt.tempodiimbarcostimato - gt.tempochiusuragate) AS aperturagate, (vp.dataOrarioPartenza - gt.tempochiusuragate) AS chiusuragate, vp.numeroprenotazioni, vp.statusImbarco, vp.statusVolo, vp.tempoDiImbarcoEffettivo, gt.tempoDiImbarcoStimato\r\n"
						+ "FROM (((volopartenza AS vp INNER JOIN tratta AS tr ON (xcodiceTratta = codiceTratta)) INNER JOIN compagniaAerea AS ca ON (xcodiceCompagniaAerea = codiceCompagniaAerea)) INNER JOIN gate AS gt ON (xcodicegate = codiceGate))\r\n"
						+ "WHERE dataOrariopartenza>NOW() ORDER BY dataOrariopartenza; ");
		stampaRegistroVoloPartenzePS = connection.prepareStatement(
				"SELECT vp.codiceVoloPartenza, ca.nome AS nomecompagniaaerea, gt.numeroporta, tr.cittaarrivo, vp.dataOrariopartenza, (vp.dataOrarioPartenza - gt.tempodiimbarcostimato - gt.tempochiusuragate) AS aperturagate, (vp.dataOrarioPartenza - gt.tempochiusuragate) AS chiusuragate, vp.numeroprenotazioni, vp.statusImbarco, vp.statusVolo, vp.tempoDiImbarcoEffettivo, gt.tempoDiImbarcoStimato\r\n"
						+ "FROM (((volopartenza AS vp INNER JOIN tratta AS tr ON (xcodiceTratta = codiceTratta)) INNER JOIN compagniaAerea AS ca ON (xcodiceCompagniaAerea = codiceCompagniaAerea)) INNER JOIN gate AS gt ON (xcodicegate = codiceGate))\r\n"
						+ "WHERE dataOrariopartenza<NOW() ORDER BY dataOrariopartenza; ");
		inserisciVoloPartenzaPS = connection.prepareStatement(
				"INSERT INTO voloPartenza (codiceVoloPartenza, dataOrarioPartenza, numeroPrenotazioni, tempoDiImbarcoEffettivo, statusVolo, statusImbarco, xcodiceGate, xcodiceTratta) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
		eliminaVoloPartenzaPS = connection.prepareStatement("DELETE FROM voloPartenza WHERE codiceVoloPartenza = ?");
		modificaVoloPartenzePS = connection.prepareStatement(
				"UPDATE voloPartenza SET dataOrarioPartenza = ?, numeroPrenotazioni = ?, tempodiimbarcoeffettivo = ?, statusVolo = ?, xcodiceGate = ?, xcodiceTratta = ? WHERE codiceVoloPartenza=?");
		modificaStatusVoloPartenzePS = connection.prepareStatement(
				"UPDATE voloPartenza SET statusVolo = ?, statusImbarco = ?, tempodiimbarcoeffettivo = ? WHERE codiceVoloPartenza=?");
		selezioneTempiImbarcoPerVoloModificatoPS = connection.prepareStatement(
				"SELECT vp.tempoDiImbarcoEffettivo, gt.tempoDiImbarcoStimato FROM volopartenza AS vp, gate AS gt WHERE (xcodicegate = codiceGate) AND codiceVoloPartenza = ?");

	}

	public List<VoloPartenze> stampaVoliPartenze() throws SQLException {
		ResultSet rs = stampaVoloPartenzePS.executeQuery();
		List<VoloPartenze> lista = new ArrayList<VoloPartenze>();
		while (rs.next()) {
			VoloPartenze vp = new VoloPartenze();
			CompagniaAerea compAerea = new CompagniaAerea();
			Gate gt = new Gate();
			Tratta trt = new Tratta();

			Time tempoImbarcoStimato = rs.getTime("tempoDiImbarcoStimato");
			Time tempoImbarcoEffettivo = rs.getTime("tempoDiImbarcoEffettivo");

			if (tempoImbarcoEffettivo.before(tempoImbarcoStimato)) {
				statusScrittoImbarco = "In orario";
			} else {
				statusScrittoImbarco = "In ritardo";
			}

			vp.setCodiceVoloPartenze(rs.getString("codiceVoloPartenza"));
			compAerea.setNome(rs.getString("nomecompagniaaerea"));
			vp.setCompAerea(compAerea);
			gt.setNumeroPorta(rs.getString("numeroporta"));
			vp.setGt(gt);
			trt.setCittaArrivo(rs.getString("cittaarrivo"));
			vp.setTrt(trt);
			vp.setDataOrarioPartenza(rs.getTimestamp("dataOrariopartenza"));
			vp.setAperturaGate(rs.getTime("aperturaGate"));
			vp.setChiusuraGate(rs.getTime("chiusuraGate"));
			vp.setNumeroPrenotazioni(rs.getString("numeroprenotazioni"));
			vp.setStatusImbarco(statusScrittoImbarco);
			vp.setStatusVolo(rs.getString("statusVolo"));
			lista.add(vp);
		}
		rs.close();
		return lista;
	}
	
	public List<VoloPartenze> stampaRegistroVoliPartenze() throws SQLException {
		ResultSet rs = stampaRegistroVoloPartenzePS.executeQuery();
		List<VoloPartenze> lista = new ArrayList<VoloPartenze>();
		while (rs.next()) {
			VoloPartenze vp = new VoloPartenze();
			CompagniaAerea compAerea = new CompagniaAerea();
			Gate gt = new Gate();
			Tratta trt = new Tratta();

			Time tempoImbarcoStimato = rs.getTime("tempoDiImbarcoStimato");
			Time tempoImbarcoEffettivo = rs.getTime("tempoDiImbarcoEffettivo");

			if (tempoImbarcoEffettivo.before(tempoImbarcoStimato)) {
				statusScrittoImbarco = "In orario";
			} else {
				statusScrittoImbarco = "In ritardo";
			}

			vp.setCodiceVoloPartenze(rs.getString("codiceVoloPartenza"));
			compAerea.setNome(rs.getString("nomecompagniaaerea"));
			vp.setCompAerea(compAerea);
			gt.setNumeroPorta(rs.getString("numeroporta"));
			vp.setGt(gt);
			trt.setCittaArrivo(rs.getString("cittaarrivo"));
			vp.setTrt(trt);
			vp.setDataOrarioPartenza(rs.getTimestamp("dataOrariopartenza"));
			vp.setAperturaGate(rs.getTime("aperturaGate"));
			vp.setChiusuraGate(rs.getTime("chiusuraGate"));
			vp.setNumeroPrenotazioni(rs.getString("numeroprenotazioni"));
			vp.setStatusImbarco(statusScrittoImbarco);
			vp.setStatusVolo(rs.getString("statusVolo"));
			lista.add(vp);
		}
		rs.close();
		return lista;
	}

	public int inserisciVoloPartenze(VoloPartenze voloPartenze) throws SQLException, PSQLException {
		inserisciVoloPartenzaPS.setString(1, voloPartenze.getCodiceVoloPartenze());
		inserisciVoloPartenzaPS.setTimestamp(2, voloPartenze.getDataOrarioPartenza());
		inserisciVoloPartenzaPS.setString(3, voloPartenze.getNumeroPrenotazioni());
		inserisciVoloPartenzaPS.setTime(4, voloPartenze.getTempoImbarcoEffettivo());
		inserisciVoloPartenzaPS.setString(5, String.valueOf(voloPartenze.getStatusVolo()));
		inserisciVoloPartenzaPS.setString(6, risultatoStatusImbarco(voloPartenze));
		inserisciVoloPartenzaPS.setString(7, voloPartenze.getGt().getCodiceGate());
		inserisciVoloPartenzaPS.setString(8, voloPartenze.getTrt().getCodiceTratta());

		int row = inserisciVoloPartenzaPS.executeUpdate();
		return row;
	}

	public int cancellaVoloPartenze(VoloPartenze voloPartenze) throws SQLException {
		eliminaVoloPartenzaPS.setString(1, voloPartenze.getCodiceVoloPartenze());

		int row = eliminaVoloPartenzaPS.executeUpdate();
		return row;
	}

	public int modificaVoloPartenze(VoloPartenze voloPartenze) throws SQLException {
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

	public int modificaStatusVoloPartenze(VoloPartenze voloPartenze) throws SQLException {
		modificaStatusVoloPartenzePS.setString(1, voloPartenze.getStatusVolo());
		modificaStatusVoloPartenzePS.setString(2, risultatoStatusImbarco(voloPartenze));
		modificaStatusVoloPartenzePS.setTime(3, voloPartenze.getTempoImbarcoEffettivo());
		modificaStatusVoloPartenzePS.setString(4, voloPartenze.getCodiceVoloPartenze());

		int row = modificaStatusVoloPartenzePS.executeUpdate();
		return row;
	}
	
	public String risultatoStatusImbarco(VoloPartenze codice) throws SQLException {
		selezioneTempiImbarcoPerVoloModificatoPS.setString(1, codice.getCodiceVoloPartenze());
		ResultSet rs = selezioneTempiImbarcoPerVoloModificatoPS.executeQuery();

		while (rs.next()) {
			Time tempoImbarcoStimato = rs.getTime("tempoDiImbarcoStimato");
			Time tempoImbarcoEffettivo = rs.getTime("tempoDiImbarcoEffettivo");

			if (tempoImbarcoEffettivo.after(tempoImbarcoStimato)) {
				statusScrittoImbarco = "In orario";
			} else {
				statusScrittoImbarco = "In ritardo";
			}
		}
		return statusScrittoImbarco;
	}
}
