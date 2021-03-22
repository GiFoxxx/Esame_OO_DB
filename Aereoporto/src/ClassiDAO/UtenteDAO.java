package ClassiDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Classi.Utente;

public interface UtenteDAO {
	
	public List<Utente> stampaUtenti() throws SQLException;
	
	public int registrazioneUtente(Utente utente) throws SQLException;
	
	public int cancellaUtente(Utente utente) throws SQLException;
	
	public int modificaUtente(Utente utente) throws SQLException;
	
	public String stampaNomeAccount(Utente utente) throws SQLException;
	
	public String stampaCognomeAccount(Utente utente) throws SQLException;
	
	public String stampaEmailAccount(Utente utente) throws SQLException;
	
	public int passwordDimenticata(Utente utente) throws SQLException;
	
	public int cambioPasswordDB(Utente utente) throws SQLException;
	
	public boolean accessoUtente(String email, String password) throws SQLException;
	
	public boolean esisteEmail(String email) throws SQLException;
}
