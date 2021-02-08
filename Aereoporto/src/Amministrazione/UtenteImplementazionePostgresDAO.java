package Amministrazione;

import Database.*;
import GUI.Accesso;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class UtenteImplementazionePostgresDAO implements UtenteDAO {

	ConnessioneDatabase db = new ConnessioneDatabase();
	Utente utn = new Utente();

	@SuppressWarnings("finally")
	@Override
	public ArrayList<Object[]> stampaUtenti() {
		ArrayList<Object[]> ListaUtenti = new ArrayList<>();
		
		PreparedStatement pst;
		ResultSet rs;
		String sql = "SELECT * FROM utente";

		try {
			

			pst = db.ConnessioneDB().prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				Object[] Lista = new Object[4];
				for (int i = 0; i <= 3; i++) {
					Lista[i] = rs.getObject(i + 1);
				}
				ListaUtenti.add(Lista);
			}
			db.ConnessioneDB().close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Errore: " + e.getMessage());
		} finally {
			return ListaUtenti;
		}
	}
	
	@SuppressWarnings("finally")
	@Override
	public ArrayList<Object[]> stampaDatiAccount() {
		ArrayList<Object[]> DatiAccount = new ArrayList<>();
		
		PreparedStatement pst;
		ResultSet rs;
		String sql = "SELECT * FROM utente";

		try {

			pst = db.ConnessioneDB().prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				Object[] Lista = new Object[3];
				for (int i = 0; i <= 2; i++) {
					Lista[i] = rs.getObject(i + 1);
				}
				DatiAccount.add(Lista);
			}
			db.ConnessioneDB().close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Errore: " + e.getMessage());
		} finally {
			return DatiAccount;
		}
	}

	@Override
	public boolean registrazioneUtente(Object utente) {
		utn = (Utente) utente;
		PreparedStatement pst;
		String sql = "INSERT INTO utente VALUES (?,?,?,?)";
		try {
			db.ConnessioneDB();

			pst = db.ConnessioneDB().prepareStatement(sql);

			pst.setString(1, utn.getNome());
			pst.setString(2, utn.getCognome());
			pst.setString(3, utn.getEmail());
			pst.setString(4, utn.getPassword());

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

	@Override
	public boolean cancellaUtente(Object utente) {
		utn = (Utente) utente;
		
		PreparedStatement pst;
		String sql = "DELETE FROM utente WHERE email = ?";
		try {
			db.ConnessioneDB();

			pst = db.ConnessioneDB().prepareStatement(sql);

			pst.setString(1, utn.getEmail());

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

	@Override
	public boolean modificaUtente(Object utente) {
		utn = (Utente) utente;
		PreparedStatement pst;
		String sql = "UPDATE utente SET nome=?, cognome=?, password=? WHERE email=?";
		try {
			db.ConnessioneDB();

			pst = db.ConnessioneDB().prepareStatement(sql);

			pst.setString(1, utn.getNome());
			pst.setString(2, utn.getCognome());
			pst.setString(3, utn.getPassword());
			pst.setString(4, utn.getEmail());

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
	
	@Override
	public boolean modificaPassword(Object utente) {
		utn = (Utente) utente;
		PreparedStatement pst;
		String sql = "UPDATE utente SET password=? WHERE email=?";
		try {
			db.ConnessioneDB();

			pst = db.ConnessioneDB().prepareStatement(sql);

			pst.setString(1, utn.getPassword());
	
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
	
	@Override
	public boolean modificaDatiAccount(Object utente) {
		utn = (Utente) utente;
		PreparedStatement pst;
		String sql = "UPDATE utente SET nome=?, cognome=? WHERE email=?";
		try {
			db.ConnessioneDB();

			pst = db.ConnessioneDB().prepareStatement(sql);

			pst.setString(1, utn.getNome());
			pst.setString(2, utn.getCognome());
			pst.setString(3, utn.getEmail());

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

	@Override
	public boolean accessoUtente(String email, String password) {
		
		boolean eUtente=false;
		PreparedStatement pst;
		String sql = "SELECT * FROM utente WHERE email = ? AND password = ?";
		
		try {
			db.ConnessioneDB();
			pst = db.ConnessioneDB().prepareStatement(sql);

			pst.setString(1, email);
			pst.setString(2, password);

			ResultSet res = pst.executeQuery();
			
			if (res.next()) {
                eUtente = true;
//                System.out.println("Autenticazione utente riuscita");
            } else {
//                System.out.println("Email o password non valido!!!");
            }
			
			
		} catch (SQLException e) {
			Logger.getLogger(Accesso.class.getName()).log(Level.SEVERE, null, e);
			return false;
		}
		return eUtente;
	}
	
	
	

}
