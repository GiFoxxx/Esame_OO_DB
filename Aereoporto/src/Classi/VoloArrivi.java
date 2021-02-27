package Classi;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class VoloArrivi {

	CompagniaAerea compagniaAerea = new CompagniaAerea();
	Tratta trt = new Tratta();

	// ATTRIBUTI
	private String codiceVoloArrivi;
	private String cittaPartenza;
	private Date dataArrivo;
	private Time orarioArrivo;

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

	public Date getDataArrivo() {
		return dataArrivo;
	}

	public void setDataArrivo(Date dataPartenza) {
		this.dataArrivo = dataPartenza;
	}

	public Time getOrarioArrivo() {
		return orarioArrivo;
	}

	public void setOrarioArrivo(Time orarioPartenza) {
		this.orarioArrivo = orarioPartenza;
	}

	// COSTRUTTORE
	public VoloArrivi() {
		super();
	}

	public VoloArrivi(String codiceVoloArrivi, String cittaPartenza, Date dataArrivo, Time orarioArrivo) {
		super();
		this.codiceVoloArrivi = codiceVoloArrivi;
		this.cittaPartenza = cittaPartenza;
		this.dataArrivo = dataArrivo;
		this.orarioArrivo = orarioArrivo;
	}

	public VoloArrivi(String codiceVoloArrivi) {
		super();
		this.codiceVoloArrivi = codiceVoloArrivi;
	}

	@Override
	public String toString() {
		return "VoloArrivi [codiceVoloArrivi=" + codiceVoloArrivi + ", cittaArrivo=" + cittaPartenza + ", dataArrivo="
				+ dataArrivo + ", orarioArrivo=" + orarioArrivo + "]";
	}

}