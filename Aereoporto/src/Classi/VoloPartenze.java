package Classi;

import java.util.ArrayList;
import java.util.Date;

public class VoloPartenze {

	CompagniaAerea compagniaAerea = new CompagniaAerea();
	Gate gt = new Gate();
	Tratta trt = new Tratta();
	ArrayList<ClienteBusiness[]> ClientiBusiness = new ArrayList<>();

	// ATTRIBUTI
	private String codiceVoloPartenze;
	private String cittaArrivo;
	private Date dataPartenza;
	private String oraPartenza;
	private String minutoPartenza;
	private String oraArrivo;
	private String minutoArrivo;
	private String numeroPrenotazioni;
	private String ritardo;

	// GETTER E SETTER
	
	public String getOraArrivo() {
		return oraArrivo;
	}
	
	public void setOraArrivo(String oraArrivo) {
		this.oraArrivo = oraArrivo;
	}
	
	public String getMinutoArrivo() {
		return minutoArrivo;
	}

	public void setMinutoArrivo(String minutoArrivo) {
		this.minutoArrivo = minutoArrivo;
	}
	
	public String getCodiceVoloPartenze() {
		return codiceVoloPartenze;
	}

	public void setCodiceVoloPartenze(String codiceVoloPartenze) {
		this.codiceVoloPartenze = codiceVoloPartenze;
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

	public String getOraPartenza() {
		return oraPartenza;
	}

	public void setOraPartenza(String orarioPartenza) {
		this.oraPartenza = orarioPartenza;
	}

	public String getMinutoPartenza() {
		return minutoPartenza;
	}

	public void setMinutoPartenza(String minutoPartenza) {
		this.minutoPartenza = minutoPartenza;
	}

	public String getNumeroPrenotazioni() {
		return numeroPrenotazioni;
	}

	public void setNumeroPrenotazioni(String numeroPrenotazioni) {
		this.numeroPrenotazioni = numeroPrenotazioni;
	}

	public String getRitardo() {
		return ritardo;
	}

	public void setRitardo(String ritardo) {
		this.ritardo = ritardo;
	}

	// COSTRUTTORE
	public VoloPartenze() {
		super();
	}

	public VoloPartenze(String codiceVoloPartenze, String cittaArrivo, Date dataPartenza, String oraPartenza,
			String minutoPartenza, String oraArrivo, String minutoArrivo, String numeroPrenotazioni, String ritardo) {
		super();
		this.codiceVoloPartenze = codiceVoloPartenze;
		this.cittaArrivo = cittaArrivo;
		this.dataPartenza = dataPartenza;
		this.oraPartenza = oraPartenza;
		this.minutoPartenza = minutoPartenza;
		this.oraArrivo = oraArrivo;
		this.minutoArrivo = minutoArrivo;
		this.numeroPrenotazioni = numeroPrenotazioni;
		this.ritardo = ritardo;
	}

	@Override
	public String toString() {
		return "VoloPartenze [codiceVoloPartenze=" + codiceVoloPartenze + ", cittaArrivo=" + cittaArrivo
				+ ", dataPartenza=" + dataPartenza + ", oraPartenza=" + oraPartenza + ", minutoPartenza="
				+ minutoPartenza + ", oraArrivo=" + oraArrivo + ", minutoArrivo=" + minutoArrivo
				+ ", numeroPrenotazioni=" + numeroPrenotazioni + ", ritardo=" + ritardo + "]";
	}
}