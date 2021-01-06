package Amministrazione;

import Database.*;
import GUI.RegistrazioneDaAccesso;
import Controller.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Amministrazione.*;

public class UtenteImplementazionePostgresDAO implements UtenteDAO {

	ConnessioneDatabase db = new ConnessioneDatabase();
	Utente utn = new Utente();
	
	
	
	@SuppressWarnings("finally")
	@Override
	public ArrayList<Object[]> stampaUtenti() {
		ArrayList<Object[]> ListaUtenti = new ArrayList<>();
		Connection con;
		PreparedStatement pst;
		ResultSet rs;
		String sql = "SELECT * FROM utente";
		
		try {
			Class.forName(db.getDriver());
			con = DriverManager.getConnection(
					db.getUrl(),
					db.getNome(),
					db.getPassword()
			);
			
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				Object[] Lista = new Object[4];
				for( int i=0; i<=3; i++) {
					Lista[i] = rs.getObject(i+1);
				}
				ListaUtenti.add(Lista);
			}
			con.close();
			
		} catch(SQLException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Errore: "+ e.getMessage());
		}finally{
			return ListaUtenti;
		}
	}

	@Override
	public boolean aggiungiUtente(Object utente) {
		utn = (Utente) utente;
		Connection con;
		PreparedStatement pst;
		String sql = "INSERT INTO utente VALUES (?,?,?,?)";
		try {
			Class.forName(db.getDriver());
			con=DriverManager.getConnection(
					db.getUrl(),
					db.getNome(),
					db.getPassword()
			);
			
			pst = con.prepareStatement(sql);
			
			pst.setString(1, utn.getNome());
			pst.setString(2, utn.getCognome());
			pst.setString(3, utn.getEmail());
			pst.setString(4, utn.getPassword());
			
			int res = pst.executeUpdate();
			
			if(res>0) {
				con.close();
				return true;
			}else {
				con.close();
				return false;
			}

		}catch(SQLException | ClassNotFoundException e){
			JOptionPane.showMessageDialog(null, "Errore: "+ e.getMessage());
			return false;
		}
	}

	@Override
	public boolean cancellaUtente(Object utente) {
		utn = (Utente) utente;
		Connection con;
		PreparedStatement pst;
		String sql = "DELETE FROM utente WHERE email (?)";
		try {
			Class.forName(db.getDriver());
			con=DriverManager.getConnection(
					db.getUrl(),
					db.getNome(),
					db.getPassword()
			);
			
			pst = con.prepareStatement(sql);
			
			pst.setString(1, utn.getEmail());
			
			int res = pst.executeUpdate();
			
			if(res>0) {
				con.close();
				return true;
			}else {
				con.close();
				return false;
			}

		}catch(SQLException | ClassNotFoundException e){
			JOptionPane.showMessageDialog(null, "Errore: "+ e.getMessage());
			return false;
		}
	}

	@Override
	public boolean modificaUtente(Object utente) {
		utn = (Utente) utente;
		Connection con;
		PreparedStatement pst;
		String sql = "UPDATE utente SET nome=?, cognome=?, password=? WHERE email=?";
		try {
			Class.forName(db.getDriver());
			con=DriverManager.getConnection(
					db.getUrl(),
					db.getNome(),
					db.getPassword()
			);
			
			pst = con.prepareStatement(sql);
			
			pst.setString(1, utn.getNome());
			pst.setString(2, utn.getCognome());
			pst.setString(3, utn.getPassword());
			pst.setString(4, utn.getEmail());
			
			int res = pst.executeUpdate();
			
			if(res>0) {
				con.close();
				return true;
			}else {
				con.close();
				return false;
			}

		}catch(SQLException | ClassNotFoundException e){
			JOptionPane.showMessageDialog(null, "Errore: "+ e.getMessage());
			return false;
		}
	}

}
