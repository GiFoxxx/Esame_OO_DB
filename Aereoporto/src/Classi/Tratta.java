package Classi;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class Tratta {

	VoloPartenze[] VoliPartenza = new VoloPartenze[2];

	// ATTRIBUTI
	private String codiceTratta;
	private String cittaPartenza;
	private String cittaArrivo;

	// GETTER E SETTER
	public String getCodiceTratta() {
		return codiceTratta;
	}

	public void setCodiceTratta(String codiceTratta) {
		this.codiceTratta = codiceTratta;
	}

	public String getCittaPartenza() {
		return cittaPartenza;
	}

	public void setCittaPartenza(String cittaPartenza) {
		this.cittaPartenza = cittaPartenza;
	}

	public String getCittaArrivo() {
		return cittaArrivo;
	}

	public void setCittaArrivo(String cittaArrivo) {
		this.cittaArrivo = cittaArrivo;
	}

	// COSTRUTTORI
	public Tratta(String codiceTratta, String cittaPartenza, String cittaArrivo) {
		super();
		this.codiceTratta = codiceTratta;
		this.cittaPartenza = cittaPartenza;
		this.cittaArrivo = cittaArrivo;
	}

	public Tratta(String codiceTratta) {
		super();
		this.codiceTratta = codiceTratta;
	}
	
	public Tratta() {
		super();
	}
}