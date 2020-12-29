package Classi;

import Classi.CodaDiImbarco;

public class ClassePriority extends CodaDiImbarco{

	boolean Tessera;
	
	public ClassePriority(int numeroPersone, boolean tessera) {
		super(numeroPersone);
		Tessera = tessera;
	}

}
