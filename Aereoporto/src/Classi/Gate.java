package Classi;

import java.sql.Time;
import java.util.ArrayList;

public class Gate {

	ArrayList<CodaDiImbarco[]> CodeDiImbarco = new ArrayList<>();
	ArrayList<Volo[]> Voli = new ArrayList<>();
//	Tratta trt = new Tratta();

	// ATTRIBUTI
	private String codiceGate;
	private String numeroPorta;
	private String inizioImbarco;
	private String fineImbarco;

	// GETTER E SETTER
	
	
	public String getCodiceGate() {
		return codiceGate;
	}

	public void setCodiceGate(String condiceGate) {
		this.codiceGate = condiceGate;
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
		this.codiceGate = codiceGate;
		this.numeroPorta = numeroPorta;
		this.inizioImbarco = inizioImbarco;
		this.fineImbarco = fineImbarco;
	}

	@Override
	public String toString() {
		return "Gate [codiceGate=" + codiceGate + ", numeroPorta=" + numeroPorta + ", inizioImbarco=" + inizioImbarco
				+ ", fineImbarco=" + fineImbarco + "]";
	}

	
	

}
