package Classi;

public class ClienteBusiness {

	CompagniaAerea ca = new CompagniaAerea();
	VoloPartenze vlprtz = new VoloPartenze();
	
	// ATTRIBUTI
	private String Nome;
	private String Cognome;
	private String CodiceCentoKilometri;
	private String Punti;

	// GETTER E SETTER
	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getCognome() {
		return Cognome;
	}

	public void setCognome(String cognome) {
		Cognome = cognome;
	}

	public String getCodiceCentoKilometri() {
		return CodiceCentoKilometri;
	}

	public void setCodiceCentoKilometri(String codiceCentoKilometri) {
		CodiceCentoKilometri = codiceCentoKilometri;
	}
	
	// COSTRUTTORE
	public ClienteBusiness(CompagniaAerea compagniaAerea, String nome, String cognome, String codiceCentoKilometri, String punti) {
		super();
		Nome = nome;
		Cognome = cognome;
		CodiceCentoKilometri = codiceCentoKilometri;
		Punti = punti;
	}
}
