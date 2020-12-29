package Amministrazione;

import java.sql.SQLException;
import java.util.List;

public interface UtenteDAO {
	
public List<Utente> stampaUtenti();
	
	public int aggiungiUtente(Utente utente) throws SQLException;

    public int cancellaStudente(Utente utente);

}
