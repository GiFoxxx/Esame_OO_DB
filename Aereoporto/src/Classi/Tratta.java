package Classi;

import java.sql.Time;

public class Tratta {
	
	//ATTRIBUTI
		private String codiceTratta;
		private String cittaPartenza;
		private String cittaArrivo;
		private double dataPartenza ;
		private double dataArrivo;
		private Time orarioPartenza;
		private Time orarioArrivo; 
		private int numeroPrenotazioni;
		
		//GETTER E SETTER
		public String getCodiceTratta() {
			return codiceTratta;
		}
		public void setCodiceTratta(String codiceTratta) {
			this.codiceTratta = codiceTratta;
		}
		public String getCittaPartenza() {
			return cittaPartenza;
		}
		public void setCittaPartenza(String cittaPartenza) {
			this.cittaPartenza = cittaPartenza;
		}
		public String getCittaArrivo() {
			return cittaArrivo;
		}
		public void setCittaArrivo(String cittaArrivo) {
			this.cittaArrivo = cittaArrivo;
		}
		public double getDataPartenza() {
			return dataPartenza;
		}
		public void setDataPartenza(double dataPartenza) {
			this.dataPartenza = dataPartenza;
		}
		public double getDataArrivo() {
			return dataArrivo;
		}
		public void setDataArrivo(double dataArrivo) {
			this.dataArrivo = dataArrivo;
		}
		public Time getOrarioPartenza() {
			return orarioPartenza;
		}
		public void setOrarioPartenza(Time orarioPartenza) {
			this.orarioPartenza = orarioPartenza;
		}
		public Time getOrarioArrivo() {
			return orarioArrivo;
		}
		public void setOrarioArrivo(Time orarioArrivo) {
			this.orarioArrivo = orarioArrivo;
		}
		public int getNumeroPrenotazioni() {
			return numeroPrenotazioni;
		}
		public void setNumeroPrenotazioni(int numeroPrenotazioni) {
			this.numeroPrenotazioni = numeroPrenotazioni;
		}
		
		//COSTRUTTORE
		public Tratta(String codiceTratta, String cittaPartenza, String cittaArrivo, double dataPartenza, double dataArrivo,
				Time orarioPartenza, Time orarioArrivo, int numeroPrenotazioni) {
			super();
			this.codiceTratta = codiceTratta;
			this.cittaPartenza = cittaPartenza;
			this.cittaArrivo = cittaArrivo;
			this.dataPartenza = dataPartenza;
			this.dataArrivo = dataArrivo;
			this.orarioPartenza = orarioPartenza;
			this.orarioArrivo = orarioArrivo;
			this.numeroPrenotazioni = numeroPrenotazioni;
		} 
		

}
