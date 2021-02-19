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
	private int tempoImbarcoEffettivo;

	// GETTER E SETTER
	public String getCodiceGate() {
		return codiceGate;
	}

	public int getTempoImbarcoEffettivo() {
		return tempoImbarcoEffettivo;
	}

	public void setTempoImbarcoEffettivo(int tempoImbarcoEffettivo) {
		this.tempoImbarcoEffettivo = tempoImbarcoEffettivo;
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
				+ ", codiceGate=" + codiceGate + ", numeroPorta=" + numeroPorta + ", tempoImbarcoEffettivo="
				+ tempoImbarcoEffettivo + "]";
	}
	
	

	public Gate(ArrayList<CodaDiImbarco[]> codeDiImbarco, ArrayList<VoloPartenze[]> voliPartenze, Tratta trt,
			String codiceGate, String numeroPorta, int tempoImbarcoEffettivo) {
		super();
		CodeDiImbarco = codeDiImbarco;
		VoliPartenze = voliPartenze;
		this.trt = trt;
		this.codiceGate = codiceGate;
		this.numeroPorta = numeroPorta;
		this.tempoImbarcoEffettivo = tempoImbarcoEffettivo;
	}

	public Gate(String codiceGate, String numeroPorta, int tempoImbarcoEffettivo) {
		super();
		this.codiceGate = codiceGate;
		this.numeroPorta = numeroPorta;
		this.tempoImbarcoEffettivo = tempoImbarcoEffettivo;
	}		

}
