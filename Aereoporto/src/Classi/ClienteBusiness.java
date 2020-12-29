package Classi;

public class ClienteBusiness {
	
	// ATTRIBUTI
		private String Nome;
		private String Cognome;
		private String CodiceCentoKilometri;
		
		

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
		public ClienteBusiness(String nome, String cognome, String codiceCentoKilometri) {
			super();
			setNome(nome);
			setCognome(cognome);
			setCodiceCentoKilometri(codiceCentoKilometri);
			
		}
	

}
