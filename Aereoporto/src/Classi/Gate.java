package Classi;

import java.sql.Time;

public class Gate {

	// ATTRIBUTI
	private String numeroPorta;
	private String codice;
	private Time tempoInizioImbarco;
	private Time tempoFineImbarco;

	// GETTER E SETTER
	public String getNumeroPorta() {
		return numeroPorta;
	}

	public void setNumeroPorta(String numeroPorta) {
		this.numeroPorta = numeroPorta;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public Time getTempoInizioImbarco() {
		return tempoInizioImbarco;
	}

	public void setTempoInizioImbarco(Time tempoInizioImbarco) {
		this.tempoInizioImbarco = tempoInizioImbarco;
	}

	public Time getTempoFineImbarco() {
		return tempoFineImbarco;
	}

	public void setTempoFineImbarco(Time tempoFineImbarco) {
		this.tempoFineImbarco = tempoFineImbarco;
	}

	//COSTRUTTORI

	public Gate() {
		super();
	}

	public Gate(String numeroPorta, String codice, Time tempoInizioImbarco, Time tempoFineImbarco) {
		super();
		this.numeroPorta = numeroPorta;
		this.codice = codice;
		this.tempoInizioImbarco = tempoInizioImbarco;
		this.tempoFineImbarco = tempoFineImbarco;
	}

	@Override
	public String toString() {
		return "Gate [numeroPorta=" + numeroPorta + ", codice=" + codice + ", tempoInizioImbarco=" + tempoInizioImbarco
				+ ", tempoFineImbarco=" + tempoFineImbarco + "]";
	}
	

}
