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
	
	@Override
	public String stampaNomeAccount(Object utente) {
		utn = (Utente) utente;
		
		String nome = null;
		PreparedStatement pst;
		ResultSet rs;
		String sql = "SELECT nome FROM utente WHERE email=?";

		try {

			pst = db.ConnessioneDB().prepareStatement(sql);
			pst.setString(1, utn.getEmail());
			rs = pst.executeQuery();
			StringBuilder resultText = new StringBuilder();

			while (rs.next()) {
			    resultText.append(rs.getString(1));
			}
			nome = resultText.toString();
			

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Errore: " + e.getMessage());
		} 
		return nome;
	}

	@Override
	public String stampaCognomeAccount(Object utente) {
		utn = (Utente) utente;
		
		String cognome = null;
		PreparedStatement pst;
		ResultSet rs;
		String sql = "SELECT cognome FROM utente WHERE email=?";

		try {

			pst = db.ConnessioneDB().prepareStatement(sql);
			
			pst.setString(1, utn.getEmail());
			
			rs = pst.executeQuery();
			
			StringBuilder resultText = new StringBuilder();

			while (rs.next()) {
			    resultText.append(rs.getString(1));
			}
			cognome = resultText.toString();
			

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Errore: " + e.getMessage());
		}
		return cognome;
	}

	@Override
	public String stampaEmailAccount(Object utente) {
		utn = (Utente) utente;
		
		String email = null;
		PreparedStatement pst;
		ResultSet rs;
		String sql = "SELECT email FROM utente WHERE email=?";

		try {

			pst = db.ConnessioneDB().prepareStatement(sql);
			pst.setString(1, utn.getEmail());
			rs = pst.executeQuery();
			StringBuilder resultText = new StringBuilder();

			while (rs.next()) {
			    resultText.append(rs.getString(1));
			}
			email = resultText.toString();
			

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Errore: " + e.getMessage());
		} 
		return email;
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
	public boolean passwordDimenticata(Object utente) {
		utn = (Utente) utente;
		PreparedStatement pst;
		String sql = "UPDATE utente SET password=? WHERE email=?";
		try {
			db.ConnessioneDB();

			pst = db.ConnessioneDB().prepareStatement(sql);
			
			pst.setString(1, utn.getPassword());
			pst.setString(2, utn.getEmail());
		
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
	public boolean cambioPasswordDB(Object utente) {
		utn = (Utente) utente;
		PreparedStatement pst;
		String sql = "UPDATE utente SET password=? WHERE email=?";
		try {
			db.ConnessioneDB();

			pst = db.ConnessioneDB().prepareStatement(sql);
			
			pst.setString(1, utn.getPassword());
			pst.setString(2, utn.getEmail());
		
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
            } else {
            }
			
			
		} catch (SQLException e) {
			Logger.getLogger(Accesso.class.getName()).log(Level.SEVERE, null, e);
			return false;
		}
		return eUtente;
	}
	
	@Override
	public boolean esisteEmail(String email) {
		
		boolean eUtente=false;
		PreparedStatement pst;
		String sql = "SELECT * FROM utente WHERE email = ? ";
		
		try {
			db.ConnessioneDB();
			pst = db.ConnessioneDB().prepareStatement(sql);

			pst.setString(1, email);

			ResultSet res = pst.executeQuery();
			
			if (res.next()) {
                eUtente = true;
            } else {
            }
			
			
		} catch (SQLException e) {
			Logger.getLogger(Accesso.class.getName()).log(Level.SEVERE, null, e);
			return false;
		}
		return eUtente;
	}
	

}
