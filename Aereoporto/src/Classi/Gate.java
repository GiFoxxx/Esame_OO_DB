package Classi;

import java.sql.Time;

public class Gate {

	// ATTRIBUTI
	private String codiceGate;
	private String numeroPorta;
	private Time inizioImbarco;
	private Time fineImbarco;

	// GETTER E SETTER
	
	public String getCodiceGate() {
		return codiceGate;
	}

	public void setCodiceGate(String codiceGate) {
		this.codiceGate = codiceGate;
	}

	public String getNumeroPorta() {
		return numeroPorta;
	}

	public void setNumeroPorta(String numeroPorta) {
		this.numeroPorta = numeroPorta;
	}

	public Time getInizioImbarco() {
		return inizioImbarco;
	}

	public void setInizioImbarco(Time inizioImbarco) {
		this.inizioImbarco = inizioImbarco;
	}

	public Time getFineImbarco() {
		return fineImbarco;
	}

	public void setFineImbarco(Time fineImbarco) {
		this.fineImbarco = fineImbarco;
	}

	//COSTRUTTORI

	public Gate() {
		super();
	}

	public Gate(String codiceGate, String numeroPorta, Time inizioImbarco, Time fineImbarco) {
		super();
		this.numeroPorta = numeroPorta;
		this.codiceGate = codiceGate;
		this.inizioImbarco = inizioImbarco;
		this.fineImbarco = fineImbarco;
	}

	@Override
	public String toString() {
		return "Gate [numeroPorta=" + numeroPorta + ", codiceGate=" + codiceGate + ", inizioImbarco=" + inizioImbarco
				+ ", fineImbarco=" + fineImbarco + "]";
	}
	

}
