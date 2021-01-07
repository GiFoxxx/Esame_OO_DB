package Amministrazione;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface UtenteDAO {

	public ArrayList<Object[]> stampaUtenti();

	public boolean registrazioneUtente(Object utente);

	public boolean cancellaUtente(Object utente);

	public boolean modificaUtente(Object utente);

	boolean accessoUtente(String email, String password);
}
