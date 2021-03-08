package ImplementazioniPostrgresDAO;

import ClassiDAO.VoloPartenzeDAO;
import Database.ConnessioneDatabase;
import Classi.VoloPartenze;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
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
	private PreparedStatement getVoloPartenzePS, inserisciVoloPartenzaPS, eliminaVoloPartenzaPS, modificaVoloPartenzePS,
			modificaStatusVoloPartenzePS;

	public VoloPartenzeImplementazionePostgresDAO(Connection connection) throws SQLException {
		this.connection = connection;

		getVoloPartenzePS = connection.prepareStatement(
				"SELECT vp.codiceVoloPartenza, ca.nome AS nomecompagniaaerea, gt.numeroporta, tr.cittaarrivo, vp.dataOrariopartenza, (vp.dataOrarioPartenza - gt.tempodiimbarcostimato - gt.tempochiusuragate) AS aperturagate, (vp.dataOrarioPartenza - gt.tempochiusuragate) AS chiusuragate, vp.numeroprenotazioni, vp.statusImbarco, vp.statusVolo, vp.tempoDiImbarcoEffettivo, gt.tempoDiImbarcoStimato "
						+ "FROM volopartenza AS vp, tratta AS tr, compagniaAerea AS ca, gate AS gt "
						+ "WHERE (xcodiceTratta = codiceTratta) AND (xcodicegate = codiceGate) AND (xcodiceCompagniaAerea = codiceCompagniaAerea) ORDER BY dataOrariopartenza ");

		inserisciVoloPartenzaPS = connection.prepareStatement(
				"INSERT INTO voloPartenza (codiceVoloPartenza, dataOrarioPartenza, numeroPrenotazioni, tempoDiImbarcoEffettivo, statusVolo, xcodiceGate, xcodiceTratta) VALUES (?, ?, ?, ?, ?, ?, ?)");
		eliminaVoloPartenzaPS = connection.prepareStatement("DELETE FROM voloPartenza WHERE codiceVoloPartenza = ?");
		modificaVoloPartenzePS = connection.prepareStatement(
				"UPDATE voloPartenza SET dataOrarioPartenza = ?, numeroPrenotazioni = ?, tempodiimbarcoeffettivo = ?, statusVolo = ?, xcodiceGate = ?, xcodiceTratta = ? WHERE codiceVoloPartenza=?");
		modificaStatusVoloPartenzePS = connection.prepareStatement(
				"UPDATE voloPartenza SET statusVolo = ?, tempodiimbarcoeffettivo = ? WHERE codiceVoloPartenza=?");
	}

	public List<VoloPartenze> stampaVoliPartenze() throws SQLException {
		ResultSet rs = getVoloPartenzePS.executeQuery();
		List<VoloPartenze> lista = new ArrayList<VoloPartenze>();
		while (rs.next()) {
			VoloPartenze vp = new VoloPartenze();
			CompagniaAerea compAerea = new CompagniaAerea();
			Gate gt = new Gate();
			Tratta trt = new Tratta();

			String statusScrittoImbarco;
			Time tempoImbarcoStimato1 = rs.getTime("tempoDiImbarcoStimato");
			Time tempoImbarcoEffettivo1 = rs.getTime("tempoDiImbarcoEffettivo");

			if (tempoImbarcoEffettivo1.before(tempoImbarcoStimato1)) {
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

	public int inserisciVoloPartenze(VoloPartenze voloPartenze) throws SQLException {
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
		modificaStatusVoloPartenzePS.setTime(2, voloPartenze.getTempoImbarcoEffettivo());
		modificaStatusVoloPartenzePS.setString(3, voloPartenze.getCodiceVoloPartenze());

		int row = modificaStatusVoloPartenzePS.executeUpdate();
		return row;
	}
}
