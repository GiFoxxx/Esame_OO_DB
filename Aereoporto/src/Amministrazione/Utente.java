package Amministrazione;

public class Utente {
	
	//ATTRIBUTI
		private String nome;
		private String cognome;
		private String email;
		private String password;
		
		//GETTER E SETTERE
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getCognome() {
			return cognome;
		}
		public void setCognome(String cognome) {
			this.cognome = cognome;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		
		//COSTRUTTORE
		public Utente(String nome, String cognome, String email, String password) {
			this.nome = nome;
			this.cognome = cognome;
			this.email = email;
			this.password = password;
		}
		
		public Utente(String email) {
			this.email = email;
		}
		
		public Utente() {
			super();
		}
		
		public Utente(String email, String password) {
			super();
			this.email = email;
			this.password = password;
		}
		
		@Override
		public String toString() {
			return "Utente [nome=" + nome + ", cognome=" + cognome + ", email=" + email + ", password=" + password
					+ "]";
		}

}
