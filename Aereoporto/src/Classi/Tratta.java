package Classi;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class Tratta {

	ArrayList<CompagniaAerea[]> CompagnieAeree = new ArrayList<>();
	ArrayList<VoloPartenze[]> VoliPartenza = new ArrayList<>();
	Gate gt;

	// ATTRIBUTI
	private String codiceTratta;
	private String cittaPartenza;
	private String cittaArrivo;
	private Date dataPartenza;
	private Date dataArrivo;
	private String orarioPartenza;
	private String orarioArrivo;
	private String tempoImbarcoStimato;
	

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

	public Date getDataPartenza() {
		return dataPartenza;
	}

	public void setDataPartenza(Date dataPartenza) {
		this.dataPartenza = dataPartenza;
	}

	public Date getDataArrivo() {
		return dataArrivo;
	}

	public void setDataArrivo(Date dataArrivo) {
		this.dataArrivo = dataArrivo;
	}

	public String getOrarioPartenza() {
		return orarioPartenza;
	}

	public void setOrarioPartenza(String orarioPartenza) {
		this.orarioPartenza = orarioPartenza;
	}

	public String getOrarioArrivo() {
		return orarioArrivo;
	}

	public void setOrarioArrivo(String orarioArrivo) {
		this.orarioArrivo = orarioArrivo;
	}

	public String getTempoImbarcoStimato() {
		return tempoImbarcoStimato;
	}

	public void setTempoImbarcoStimato(String tempoImbarcoStimato) {
		this.tempoImbarcoStimato = tempoImbarcoStimato;
	}

	// COSTRUTTORI
	public Tratta(String codiceTratta, String cittaPartenza, String cittaArrivo, Date dataPartenza, Date dataArrivo, String orarioPartenza, String orarioArrivo, String tempoImbarcoStimato) {
		super();
		this.codiceTratta = codiceTratta;
		this.cittaPartenza = cittaPartenza;
		this.cittaArrivo = cittaArrivo;
		this.dataPartenza = dataPartenza;
		this.dataArrivo = dataArrivo;
		this.orarioPartenza = orarioPartenza;
		this.orarioArrivo = orarioArrivo;
		this.tempoImbarcoStimato = tempoImbarcoStimato;
	}

	public Tratta() {
		super();
	}

	
}