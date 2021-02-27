package Classi;

public class CodaDiImbarco {

	Gate gate;

	// ATTRIBUTI
	String codiceCodaDiImbarco;
	String nomeCoda;
	int tempoImbarcoStimato = 0;

	// GETTER E SETTER

	public String getCodiceCodaDiImbarco() {
		return codiceCodaDiImbarco;
	}

	public void setCodiceCodaDiImbarco(String codiceCodaDiImbarco) {
		this.codiceCodaDiImbarco = codiceCodaDiImbarco;
	}

	public String getNomeCoda() {
		return nomeCoda;
	}

	public void setNomeCoda(String nomeCoda) {
		this.nomeCoda = nomeCoda;
	}

	// COSTRUTTORE
	public CodaDiImbarco(String codiceCodaDiImbarco) {
		super();
		this.codiceCodaDiImbarco = codiceCodaDiImbarco;
	}
	
	public CodaDiImbarco(String codiceCodaDiImbarco, String nomeCoda) {
		super();
		this.codiceCodaDiImbarco = codiceCodaDiImbarco;
		this.nomeCoda = nomeCoda;
	}

	public CodaDiImbarco(String codiceCodaDiImbarco, String nomeCoda, int tempoImbarcoStimato) {
		super();
		this.codiceCodaDiImbarco = codiceCodaDiImbarco;
		this.nomeCoda = nomeCoda;
		this.tempoImbarcoStimato = tempoImbarcoStimato;
	}

	public CodaDiImbarco() {
		super();
	}

}
