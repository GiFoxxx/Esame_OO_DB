package Classi;

public class Gate {
	
	//ATTRIBUTI
	private String numeroPorta;
	private String codice;
	
	//GETTER E SETTER
	public String getNumeroPorta() {
		return numeroPorta;
	}
	public void setNumeroPorta(String numeroPorta) {
		this.numeroPorta = numeroPorta;
	}
	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	

	//COSTRUTTORI 	
	public Gate(String numeroPorta, String codice) {
		super();
		this.numeroPorta = numeroPorta;
		this.codice = codice;
	}
	
	public Gate() {
		super();
	}
	
	
}
