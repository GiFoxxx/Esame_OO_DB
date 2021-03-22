package ImplementazioniPostrgresDAO;

import ClassiDAO.TrattaDAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import Classi.*;

public class TrattaImplementazionePostgresDAO implements TrattaDAO {

	private Connection connection;
	private PreparedStatement stampaTrattePS, aggiungiTrattaPS, cancellaTrattaPS, modificaTrattaPS,
			stampaCittaArrivoInComboBoxPS;

	public TrattaImplementazionePostgresDAO(Connection connection) throws SQLException {
		this.connection = connection;

		stampaTrattePS = connection.prepareStatement(
				"SELECT trt.codicetratta, trt.cittaPartenza, trt.cittaArrivo, ca.nome AS nomecompagniaaerea "
						+ "FROM tratta AS trt INNER JOIN compagniaaerea AS ca ON (xcodiceCompagniaAerea = codiceCompagniaAerea)");
		aggiungiTrattaPS = connection.prepareStatement(
				"INSERT INTO tratta (codiceTratta, cittaPartenza, cittaArrivo, xcodiceCompagniaAerea) VALUES (?,?,?,?)");
		cancellaTrattaPS = connection.prepareStatement("DELETE FROM tratta WHERE codicetratta = ?");
		modificaTrattaPS = connection.prepareStatement(
				"UPDATE tratta SET cittapartenza=?, cittaarrivo=?, xcodiceCompagniaAerea=? WHERE codicetratta=?");
		stampaCittaArrivoInComboBoxPS = connection
				.prepareStatement("SELECT codiceTratta, cittaArrivo FROM tratta ORDER BY codicetratta ASC");
	}

	public List<Tratta> stampaTratte() throws SQLException {

		ResultSet rs = stampaTrattePS.executeQuery();
		List<Tratta> lista = new ArrayList<Tratta>();
		while (rs.next()) {
			Tratta trt = new Tratta();
			CompagniaAerea compAerea = new CompagniaAerea();
			trt.setCodiceTratta(rs.getString("codiceTratta"));
			trt.setCittaPartenza(rs.getString("cittaPartenza"));
			trt.setCittaArrivo(rs.getString("cittaArrivo"));
			compAerea.setCodiceCompagniaAerea(rs.getString("nomecompagniaaerea"));
			trt.setCompagniaAerea(compAerea);
			lista.add(trt);
		}
		rs.close();
		return lista;
	}

	public int aggiungiTratta(Tratta trt) throws SQLException {
		aggiungiTrattaPS.setString(1, trt.getCodiceTratta());
		aggiungiTrattaPS.setString(2, trt.getCittaPartenza());
		aggiungiTrattaPS.setString(3, trt.getCittaArrivo());
		aggiungiTrattaPS.setString(4, trt.getCompagniaAerea().getCodiceCompagniaAerea());

		int row = aggiungiTrattaPS.executeUpdate();
		return row;
	}

	public int cancellaTratta(Tratta trt) throws SQLException {
		cancellaTrattaPS.setString(1, trt.getCodiceTratta());

		int row = cancellaTrattaPS.executeUpdate();
		return row;
	}

	public int modificaTratta(Tratta trt) throws SQLException {
		modificaTrattaPS.setString(1, trt.getCittaPartenza());
		modificaTrattaPS.setString(2, trt.getCittaArrivo());
		modificaTrattaPS.setString(3, trt.getCompagniaAerea().getCodiceCompagniaAerea());
		modificaTrattaPS.setString(4, trt.getCodiceTratta());

		int row = modificaTrattaPS.executeUpdate();
		return row;
	}

	public HashMap<String, String> stampaCittaArrivoInComboBox() throws SQLException {
		HashMap<String, String> map = new HashMap<String, String>();

		ResultSet rs = stampaCittaArrivoInComboBoxPS.executeQuery();
		while (rs.next()) {
			Tratta trt = new Tratta(rs.getString(2), rs.getString(1));
			map.put(trt.getCodiceTratta(), trt.getCittaArrivo());
		}
		return map;
	}
}