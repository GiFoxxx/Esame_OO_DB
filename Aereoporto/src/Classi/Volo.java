package Classi;

import java.util.ArrayList;
import java.util.Date;

public class Volo {
	
	CompagniaAerea compagniaAerea = new CompagniaAerea();
	Gate gate = new Gate();
	Tratta tratta = new Tratta();
	ArrayList<ClienteBusiness[]> ClientiBusiness = new ArrayList<>();
	
	// ATTRIBUTI
		private String codiceVolo;
		private String cittaPartenza;
		private String cittaArrivo;
		private Date dataPartenza;
		private Date dataArrivo;
		private String orarioPartenza;
		private String orarioArrivo;
		private String numeroPrenotazioni;
		
	

		// GETTER E SETTER
		public String getCodiceVolo() {
			return codiceVolo;
		}

		public void setCodiceVolo(String codiceTratta) {
			this.codiceVolo = codiceTratta;
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

		public Date getDataPartenza() {
			return dataPartenza;
		}

		public void setDataPartenza(Date dataPartenza) {
			this.dataPartenza = dataPartenza;
		}

		public Date getDataArrivo() {
			return dataArrivo;
		}

		public void setDataArrivo(Date dataArrivo) {
			this.dataArrivo = dataArrivo;
		}

		public String getOrarioPartenza() {
			return orarioPartenza;
		}

		public void setOrarioPartenza(String orarioPartenza) {
			this.orarioPartenza = orarioPartenza;
		}

		public String getOrarioArrivo() {
			return orarioArrivo;
		}

		public void setOrarioArrivo(String orarioArrivo) {
			this.orarioArrivo = orarioArrivo;
		}

		public String getNumeroPrenotazioni() {
			return numeroPrenotazioni;
		}

		public void setNumeroPrenotazioni(String numeroPrenotazioni) {
			this.numeroPrenotazioni = numeroPrenotazioni;
		}	
		
		// COSTRUTTORE
		public Volo(String codiceVolo, String cittaPartenza, String cittaArrivo, Date dataPartenza, Date dataArrivo, String orarioPartenza, String orarioArrivo, String numeroPrenotazioni) {
			super();
			this.codiceVolo = codiceVolo;
			this.cittaPartenza = cittaPartenza;
			this.cittaArrivo = cittaArrivo;
			this.dataPartenza = dataPartenza;
			this.dataArrivo = dataArrivo;
			this.orarioPartenza = orarioPartenza;
			this.orarioArrivo = orarioArrivo;
			this.numeroPrenotazioni = numeroPrenotazioni;
		}

		public Volo() {
			super();
		}

		@Override
		public String toString() {
			return "Volo [codiceVolo=" + codiceVolo + ", cittaPartenza=" + cittaPartenza + ", cittaArrivo="
					+ cittaArrivo + ", dataPartenza=" + dataPartenza + ", dataArrivo=" + dataArrivo + ", orarioPartenza="
					+ orarioPartenza + ", orarioArrivo=" + orarioArrivo + ", numeroPrenotazioni=" + numeroPrenotazioni
					+ "]";
		}


	}