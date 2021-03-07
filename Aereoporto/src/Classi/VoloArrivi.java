package Classi;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class VoloArrivi {

	CompagniaAerea compagniaAerea = new CompagniaAerea();
	Tratta trt = new Tratta();

	// ATTRIBUTI
	private String codiceVoloArrivi;
	private String cittaPartenza;
	private Timestamp dataOrarioPartenza;

	// GETTER E SETTER
	public String getCodiceVoloArrivi() {
		return codiceVoloArrivi;
	}

	public void setCodiceVoloArrivi(String codiceVoloArrivi) {
		this.codiceVoloArrivi = codiceVoloArrivi;
	}

	public String getCittaPartenza() {
		return cittaPartenza;
	}

	public void setCittaPartenza(String cittaPartenza) {
		this.cittaPartenza = cittaPartenza;
	}

	public Timestamp getDataOrarioPartenza() {
		return dataOrarioPartenza;
	}

	public void setDataOrarioPartenza(Timestamp dataOrarioPartenza) {
		this.dataOrarioPartenza = dataOrarioPartenza;
	}

	// COSTRUTTORE
	public VoloArrivi() {
		super();
	}

	public VoloArrivi(String codiceVoloArrivi, String cittaPartenza, Timestamp dataOrarioPartenza) {
		super();
		this.codiceVoloArrivi = codiceVoloArrivi;
		this.cittaPartenza = cittaPartenza;
		this.dataOrarioPartenza = dataOrarioPartenza;
	}

	public VoloArrivi(String codiceVoloArrivi) {
		super();
		this.codiceVoloArrivi = codiceVoloArrivi;
	}

	@Override
	public String toString() {
		return "VoloArrivi [compagniaAerea=" + compagniaAerea + ", trt=" + trt + ", codiceVoloArrivi="
				+ codiceVoloArrivi + ", cittaPartenza=" + cittaPartenza + ", dataOrarioPartenza=" + dataOrarioPartenza
				+ "]";
	}

	

}