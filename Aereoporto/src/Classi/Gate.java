package Classi;

import java.sql.Time;
import java.util.ArrayList;

public class Gate {

	ArrayList<CodaDiImbarco[]> CodeDiImbarco = new ArrayList<>();
	ArrayList<VoloPartenze[]> VoliPartenze = new ArrayList<>();
	Tratta trt;

	// ATTRIBUTI
	private String codiceGate;
	private String numeroPorta;

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


	//COSTRUTTORI

	public Gate() {
		super();
	}

	@Override
	public String toString() {
		return "Gate [CodeDiImbarco=" + CodeDiImbarco + ", VoliPartenze=" + VoliPartenze + ", trt=" + trt
				+ ", codiceGate=" + codiceGate + ", numeroPorta=" + numeroPorta + "]";
	}

	public Gate(ArrayList<CodaDiImbarco[]> codeDiImbarco, ArrayList<VoloPartenze[]> voliPartenze, Tratta trt,
			String codiceGate, String numeroPorta) {
		super();
		CodeDiImbarco = codeDiImbarco;
		VoliPartenze = voliPartenze;
		this.trt = trt;
		this.codiceGate = codiceGate;
		this.numeroPorta = numeroPorta;
	}

	public Gate(String codiceGate, String numeroPorta) {
		super();
		this.codiceGate = codiceGate;
	}		

}
