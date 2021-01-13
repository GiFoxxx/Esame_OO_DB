package Classi;

import java.sql.Time;

public class Gate {

	// ATTRIBUTI
	private String codiceGate;
	private String numeroPorta;
	private String inizioImbarco;
	private String fineImbarco;

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

	public String getInizioImbarco() {
		return inizioImbarco;
	}

	public void setInizioImbarco(String inizioImbarco) {
		this.inizioImbarco = inizioImbarco;
	}

	public String getFineImbarco() {
		return fineImbarco;
	}

	public void setFineImbarco(String fineImbarco) {
		this.fineImbarco = fineImbarco;
	}

	//COSTRUTTORI

	public Gate() {
		super();
	}

	public Gate(String codiceGate, String numeroPorta, String inizioImbarco, String fineImbarco) {
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
