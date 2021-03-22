package Classi;

import java.util.ArrayList;

public class CompagniaAerea {
	
	//ATTRIBUTI
	private String codiceCompagniaAerea;
	private String nome;
	
	//GETTER E SETTER
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCodiceCompagniaAerea() {
		return codiceCompagniaAerea;
	}

	public void setCodiceCompagniaAerea(String codiceCompagniaAerea) {
		this.codiceCompagniaAerea = codiceCompagniaAerea;
	}
	
	//COSTRUTTORI
	public CompagniaAerea(String codiceCompagniaAerea, String nome) {
		super();	
		this.codiceCompagniaAerea = codiceCompagniaAerea;
		this.nome = nome;
	}
	
	public CompagniaAerea(String codiceCompagniaAerea) {
		super();	
		this.codiceCompagniaAerea = codiceCompagniaAerea;
	}
	
	public CompagniaAerea() {
		super();
	}

}
