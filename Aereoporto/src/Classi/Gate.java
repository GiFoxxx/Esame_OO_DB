package Classi;

import java.sql.Time;
import java.util.ArrayList;

public class Gate {

	CodaDiImbarco[] codeDiImbarco = new CodaDiImbarco[2];
	
	Tratta trt;

	// ATTRIBUTI
	private String codiceGate;
	private String numeroPorta;

	// GETTER E SETTER
	public CodaDiImbarco[] getCodeDiImbarco() {
		return codeDiImbarco;
	}

	public void setCodeDiImbarco(CodaDiImbarco[] codaDiImbarco) {
		this.codeDiImbarco = codaDiImbarco;
	}
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

	public Gate( String codiceGate, String numeroPorta, CodaDiImbarco codaDiImbarco1, CodaDiImbarco codaDiImbarco2) {
		super();
		this.codiceGate = codiceGate;
		this.numeroPorta = numeroPorta;
	}
	
	public Gate( String codiceGate, String numeroPorta) {
		super();
		this.codiceGate = codiceGate;
		this.numeroPorta = numeroPorta;
	}

	public Gate(String codiceGate) {
		super();
		this.codiceGate = codiceGate;
	}		

}
