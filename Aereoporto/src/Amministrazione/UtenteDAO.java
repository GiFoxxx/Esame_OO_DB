package Amministrazione;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface UtenteDAO {

	public ArrayList<Object[]> stampaUtenti();
	public boolean registrazioneUtente(Object utente);
	public boolean accessoUtente(String email, String password);
	public boolean cancellaUtente(Object utente);
	public boolean modificaUtente(Object utente);

}
