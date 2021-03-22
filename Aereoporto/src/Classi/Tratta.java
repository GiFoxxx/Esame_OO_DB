package Classi;

public class Tratta {

	CompagniaAerea compagniaAerea;

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
	
	public CompagniaAerea getCompagniaAerea() {
		return compagniaAerea;
	}

	public void setCompagniaAerea(CompagniaAerea compagniaAerea) {
		this.compagniaAerea = compagniaAerea;
	}
	

	// COSTRUTTORI
	public Tratta(CompagniaAerea compagniaAerea, String codiceTratta, String cittaPartenza, String cittaArrivo) {
		super();
		this.compagniaAerea = compagniaAerea;
		this.codiceTratta = codiceTratta;
		this.cittaPartenza = cittaPartenza;
		this.cittaArrivo = cittaArrivo;
	}

	public Tratta(String codiceTratta) {
		super();
		this.codiceTratta = codiceTratta;
	}
	
	public Tratta(String codiceTratta, String cittaArrivo) {
		super();
		this.codiceTratta = codiceTratta;
		this.cittaArrivo = cittaArrivo;
	}

	public Tratta() {
		super();
	}
}