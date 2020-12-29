package Classi;

import Classi.CodaDiImbarco;

public class ClasseDiversamenteAbile extends CodaDiImbarco{
	
	String tipologiaUtensile;

	public ClasseDiversamenteAbile(int numeroPersone, String tipoUtensile) {
		super(numeroPersone);
		tipologiaUtensile = tipoUtensile;
	}

}
