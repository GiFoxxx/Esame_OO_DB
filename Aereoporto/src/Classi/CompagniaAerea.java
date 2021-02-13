package Classi;

import java.util.ArrayList;

public class CompagniaAerea {
	
	//ATTRIBUTI
	private String codiceCompagniaAerea;
	private String nome;
	
	ArrayList<ClienteBusiness[]> ClientiBusiness = new ArrayList<>();
	ArrayList<Tratta[]> Tratte = new ArrayList<>();
	ArrayList<VoloPartenze[]> VoliPartenze = new ArrayList<>();

	
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
	
	public CompagniaAerea() {
		super();
	}

	@Override
	public String toString() {
		return "CompagniaAerea [codiceCompagniaAerea=" + codiceCompagniaAerea + ", nome=" + nome + "]";
	}

	

	



	
	
	

}
