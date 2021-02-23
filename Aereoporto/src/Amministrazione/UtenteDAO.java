package Amministrazione;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface UtenteDAO {

public ArrayList<Object[]> stampaUtenti();
	
	public boolean modificaDatiAccount(Object utente);
	
	public boolean registrazioneUtente(Object utente);

	public boolean cancellaUtente(Object utente);

	public boolean modificaUtente(Object utente);
	
	public boolean passwordDimenticata(Object utente);

	boolean accessoUtente(String email, String password);

	public String stampaNomeAccount(Object utente);

	public String stampaCognomeAccount(Object utente);

	public String stampaEmailAccount(Object utente);

	boolean cambioPasswordDB(Object utente);

	boolean esisteEmail(String email);
}
