package Classi;

import java.util.ArrayList;

public class CompagniaAerea {
	
	//ATTRIBUTI
	private String nome;
	private String codiceCompagniaAerea;
	
	ArrayList<ClienteBusiness[]> ClientiBusiness = new ArrayList<>();
	ArrayList<Tratta[]> Tratte = new ArrayList<>();
	ArrayList<Volo[]> Voli = new ArrayList<>();

	
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
	public CompagniaAerea(String nome, String codiceCompagniaAerea) {
		super();
		this.nome = nome;
		this.codiceCompagniaAerea = codiceCompagniaAerea;
	}
	
	public CompagniaAerea() {
		super();
	}

	@Override
	public String toString() {
		return "CompagniaAerea [nome=" + nome + ", codiceCompagniaAerea=" + codiceCompagniaAerea + "]";
	}



	
	
	

}
