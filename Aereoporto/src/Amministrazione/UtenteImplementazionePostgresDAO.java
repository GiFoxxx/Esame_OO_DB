package Amministrazione;

import java.sql.SQLException;
import java.util.List;

public class UtenteImplementazionePostgresDAO implements UtenteDAO{
	
	@Override
	public List<Utente> stampaUtenti() {
	
		return null;
	}

	@Override
	public int aggiungiUtente(Utente utente) throws SQLException {
		return 0;
	}

	@Override
	public int cancellaStudente(Utente utente) {
		return 0;
	}

}
