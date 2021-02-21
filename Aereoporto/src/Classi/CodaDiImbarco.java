package Classi;

public class CodaDiImbarco {

	Gate gt = new Gate();

	int numeroPersone;

	int capienza = 850;
	int tempoImbarcoTeorico = 0;

	public CodaDiImbarco(int numeroPersone) {
		super();
		this.numeroPersone = numeroPersone;
	}

	public void conteggio() {
		if (capienza <= 200) {
			tempoImbarcoTeorico = tempoImbarcoTeorico + 15;
		}else if(capienza >= 201 && capienza <=400) {
			tempoImbarcoTeorico = tempoImbarcoTeorico + 20;
		}else if(capienza >= 401 && capienza <=600) {
			tempoImbarcoTeorico = tempoImbarcoTeorico + 25;
		}else if(capienza >= 601 && capienza <=850) {
			tempoImbarcoTeorico = tempoImbarcoTeorico + 30;
		}
	}
}
