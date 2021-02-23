package Classi;

import java.util.ArrayList;
import java.util.Date;

public class VoloPartenze {

	CompagniaAerea compagniaAerea;
	Gate gt;
	Tratta trt;

	// ATTRIBUTI
	private String codiceVoloPartenze;
	private Date dataPartenza;
	private String oraPartenza;
	private String minutoPartenza;
	private String oraArrivo;
	private String minutoArrivo;
	private String numeroPrenotazioni;
	private int ritardo;
	

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

	public int getRitardo() {
		return ritardo;
	}

	public void setRitardo(int ritardo) {
		this.ritardo = ritardo;
	}

	public CompagniaAerea getCompagniaAerea() {
		return compagniaAerea;
	}

	public void setCompagniaAerea(CompagniaAerea compagniaAerea) {
		this.compagniaAerea = compagniaAerea;
	}

	public Gate getGt() {
		return gt;
	}

	public void setGt(Gate gt) {
		this.gt = gt;
	}

	public Tratta getTrt() {
		return trt;
	}

	public void setTrt(Tratta trt) {
		this.trt = trt;
	}

	// COSTRUTTORE
	public VoloPartenze() {
		super();
	}

	public VoloPartenze(String codiceVoloPartenze, Date dataPartenza, String oraPartenza, String minutoPartenza, String oraArrivo,
			String minutoArrivo, String numeroPrenotazioni, int ritardo, Tratta trt, Gate gt, CompagniaAerea compagniaAerea) {
		super();
		this.compagniaAerea = compagniaAerea;
		this.gt = gt;
		this.trt = trt;
		this.codiceVoloPartenze = codiceVoloPartenze;
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
		return "VoloPartenze [compagniaAerea=" + compagniaAerea + ", gt=" + gt + ", trt=" + trt
				+ ", codiceVoloPartenze=" + codiceVoloPartenze + ", dataPartenza=" + dataPartenza + ", oraPartenza="
				+ oraPartenza + ", minutoPartenza=" + minutoPartenza + ", oraArrivo=" + oraArrivo + ", minutoArrivo="
				+ minutoArrivo + ", numeroPrenotazioni=" + numeroPrenotazioni + ", ritardo=" + ritardo + "]";
	}

	
}