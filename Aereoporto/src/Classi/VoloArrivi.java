package Classi;

import java.util.ArrayList;
import java.util.Date;

public class VoloArrivi {

	CompagniaAerea compagniaAerea = new CompagniaAerea();
	Tratta trt = new Tratta();

	// ATTRIBUTI
	private String codiceVoloArrivi;
	private String cittaPartenza;
	private Date dataArrivo;
	private String orarioArrivo;
	private String minutoArrivo;

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

	public String getOrarioArrivo() {
		return orarioArrivo;
	}

	public void setOrarioArrivo(String orarioPartenza) {
		this.orarioArrivo = orarioPartenza;
	}

	public String getMinutoArrivo() {
		return minutoArrivo;
	}

	public void setMinutoArrivo(String minutoArrivo) {
		this.minutoArrivo = minutoArrivo;
	}

	// COSTRUTTORE
	public VoloArrivi() {
		super();
	}

	public VoloArrivi(String codiceVoloArrivi, String cittaPartenza, Date dataArrivo, String orarioArrivo, String minutoArrivo) {
		super();
		this.codiceVoloArrivi = codiceVoloArrivi;
		this.cittaPartenza = cittaPartenza;
		this.dataArrivo = dataArrivo;
		this.orarioArrivo = orarioArrivo;
		this.minutoArrivo = minutoArrivo;
	}

	@Override
	public String toString() {
		return "VoloArrivi [codiceVoloArrivi=" + codiceVoloArrivi + ", cittaArrivo=" + cittaPartenza + ", dataArrivo="
				+ dataArrivo + ", orarioArrivo=" + orarioArrivo + "]";
	}

}