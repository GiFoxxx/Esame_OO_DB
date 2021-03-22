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

}
