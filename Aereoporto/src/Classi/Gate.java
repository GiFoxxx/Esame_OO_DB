package Classi;

import java.sql.Time;
import java.util.ArrayList;

public class Gate {

	CodaDiImbarco codeDiImbarco;

	// ATTRIBUTI
	private String codiceGate;
	private String numeroPorta;
	private Time tempoImbarcoStimato;

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

	public CodaDiImbarco getCodeDiImbarco() {
		return codeDiImbarco;
	}

	public void setCodeDiImbarco(CodaDiImbarco codeDiImbarco) {
		this.codeDiImbarco = codeDiImbarco;
	}

	public Time getTempoImbarcoStimato() {
		return tempoImbarcoStimato;
	}

	public void setTempoImbarcoStimato(Time tempoImbarcoStimato) {
		this.tempoImbarcoStimato = tempoImbarcoStimato;
	}

	// COSTRUTTORI

	public Gate() {
		super();
	}

	public Gate(CodaDiImbarco codeDiImbarco, String codiceGate, String numeroPorta, Time tempoImbarcoStimato) {
		super();
		this.codeDiImbarco = codeDiImbarco;
		this.codiceGate = codiceGate;
		this.numeroPorta = numeroPorta;
		this.tempoImbarcoStimato = tempoImbarcoStimato;
	}

	public Gate(String codiceGate, String numeroPorta) {
		super();
		this.codiceGate = codiceGate;
		this.numeroPorta = numeroPorta;
	}
	
	

	public Gate(String codiceGate, String numeroPorta, Time tempoImbarcoStimato) {
		super();
		this.codiceGate = codiceGate;
		this.numeroPorta = numeroPorta;
		this.tempoImbarcoStimato = tempoImbarcoStimato;
	}

	public Gate(CodaDiImbarco codeDiImbarco, String codiceGate) {
		super();
		this.codeDiImbarco = codeDiImbarco;
		this.codiceGate = codiceGate;
	}

	public Gate(String codiceGate) {
		super();
		this.codiceGate = codiceGate;
	}

}
