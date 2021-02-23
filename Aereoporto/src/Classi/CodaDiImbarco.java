package Classi;

public class CodaDiImbarco {

	
	Gate gate;
	
	//ATTRIBUTI
	String nomeCoda;
	int tempoImbarcoStimato = 0;
	
	//COSTRUTTORE
	public CodaDiImbarco(int tempoImbarcoStimato, String nome, Gate gt) {
		super();
		this.nomeCoda = nome;
		this.tempoImbarcoStimato = tempoImbarcoStimato;
		gate=gt;
	}



	

	public CodaDiImbarco() {
		super();
	}
	
	
	//METODI
	public void conteggio() {
//		if (capienza <= 200) {
//			tempoImbarcoTeorico = tempoImbarcoTeorico + 15;
//		}else if(capienza >= 201 && capienza <=400) {
//			tempoImbarcoTeorico = tempoImbarcoTeorico + 20;
//		}else if(capienza >= 401 && capienza <=600) {
//			tempoImbarcoTeorico = tempoImbarcoTeorico + 25;
//		}else if(capienza >= 601 && capienza <=850) {
//			tempoImbarcoTeorico = tempoImbarcoTeorico + 30;
//		}
	}
}
