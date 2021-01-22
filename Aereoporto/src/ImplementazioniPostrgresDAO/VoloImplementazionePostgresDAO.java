package ImplementazioniPostrgresDAO;

import ClassiDAO.VoloDAO;
import Database.ConnessioneDatabase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Classi.Gate;
import Classi.Tratta;
import Classi.Volo;

public class VoloImplementazionePostgresDAO implements VoloDAO {

	ConnessioneDatabase db = new ConnessioneDatabase();
	Volo vl = new Volo();
	Gate gt = new Gate();
	Tratta trt = new Tratta();
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	

	@SuppressWarnings("finally")
	@Override // stampa voli
	public ArrayList<Object[]> stampaVoli() {
		ArrayList<Object[]> ListaVoli = new ArrayList<>();

		PreparedStatement pst;
		ResultSet rs;
		String sql = "SELECT * FROM volo";

		try {
			pst = db.ConnessioneDB().prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				Object[] Lista = new Object[8];
				for (int i = 0; i <= 7; i++) {
					Lista[i] = rs.getObject(i + 1);
				}
				ListaVoli.add(Lista);
			}
			db.ConnessioneDB().close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Errore: " + e.getMessage());
		} finally {
			return ListaVoli;
		}
	}

	@Override // cancello una volo
	public boolean cancellaVolo(Object volo) {
		vl = (Volo) volo;

		PreparedStatement pst;
		String sql = "DELETE FROM volo WHERE codicevolo = ?";
		try {
			db.ConnessioneDB();

			pst = db.ConnessioneDB().prepareStatement(sql);

			pst.setString(1, vl.getCodiceVolo());

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
	public boolean modificaVolo(Object volo) {
		vl = (Volo) volo;
		
		PreparedStatement pst;
		String sql = "UPDATE volo SET cittapartenza=?, cittaarrivo=?, datapartenza=?, dataarrivo=?, orariopartenza=?, orarioarrivo=?, numeroprenotazioni=? WHERE codicevolo=?";
		try {
			db.ConnessioneDB();

			pst = db.ConnessioneDB().prepareStatement(sql);

			pst.setString(1, vl.getCittaPartenza());
			pst.setString(2, vl.getCittaArrivo());
			String dataPartenza = sdf.format(vl.getDataPartenza());
			pst.setString(3, dataPartenza);
			String dataArrivo = sdf.format(vl.getDataArrivo());
			pst.setString(4, dataArrivo);
			pst.setString(5, vl.getOrarioPartenza());
			pst.setString(6, vl.getOrarioArrivo());
			pst.setString(7, vl.getNumeroPrenotazioni());
			pst.setString(8, vl.getCodiceVolo());

			
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

	@Override // aggiungi volo
	public boolean aggiungiVolo(Object volo) {
		vl = (Volo) volo;
		
		PreparedStatement pst;
		String sql = "INSERT INTO volo (codiceVolo, cittaPartenza, cittaArrivo, dataPartenza, dataArrivo, orarioPartenza, orarioArrivo, numeroPrenotazioni) VALUES (?,?,?,?,?,?,?,?)";
		try {
			db.ConnessioneDB();

			pst = db.ConnessioneDB().prepareStatement(sql);

			pst.setString(1, vl.getCodiceVolo());
			pst.setString(2, vl.getCittaPartenza());
			pst.setString(3, vl.getCittaArrivo());
			String dataPartenza = sdf.format(vl.getDataPartenza());
			pst.setString(4, dataPartenza);
			String dataArrivo = sdf.format(vl.getDataArrivo());
			pst.setString(5, dataArrivo);
			pst.setString(6, vl.getOrarioPartenza());
			pst.setString(7, vl.getOrarioArrivo());
			pst.setString(8, vl.getNumeroPrenotazioni());

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
