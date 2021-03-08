package Classi;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

public class VoloPartenze {

	Gate gt;
	Tratta trt;
	CompagniaAerea compAerea;

	// ATTRIBUTI
	private String codiceVoloPartenze;
	private Timestamp dataOrarioPartenza;
	private Time tempoImbarcoEffettivo;
	private String numeroPrenotazioni;
	private String statusVolo;
	private String statusImbarco;
	private Time aperturaGate;
	private Time chiusuraGate;
	

	// GETTER E SETTER
	public String getCodiceVoloPartenze() {
		return codiceVoloPartenze;
	}

	public void setCodiceVoloPartenze(String codiceVoloPartenze) {
		this.codiceVoloPartenze = codiceVoloPartenze;
	}

	public String getNumeroPrenotazioni() {
		return numeroPrenotazioni;
	}

	public void setNumeroPrenotazioni(String numeroPrenotazioni) {
		this.numeroPrenotazioni = numeroPrenotazioni;
	}

	public String getStatusVolo() {
		return statusVolo;
	}

	public void setStatusVolo(String status) {
		this.statusVolo = status;
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

	public CompagniaAerea getCompAerea() {
		return compAerea;
	}

	public void setCompAerea(CompagniaAerea compAerea) {
		this.compAerea = compAerea;
	}

	public Timestamp getDataOrarioPartenza() {
		return dataOrarioPartenza;
	}

	public void setDataOrarioPartenza(Timestamp dataOrarioPartenza) {
		this.dataOrarioPartenza = dataOrarioPartenza;
	}

	public Time getTempoImbarcoEffettivo() {
		return tempoImbarcoEffettivo;
	}

	public void setTempoImbarcoEffettivo(Time tempoImbarcoEffettivo) {
		this.tempoImbarcoEffettivo = tempoImbarcoEffettivo;
	}

	public String getStatusImbarco() {
		return statusImbarco;
	}

	public void setStatusImbarco(String statusImbarco) {
		this.statusImbarco = statusImbarco;
	}

	public Time getAperturaGate() {
		return aperturaGate;
	}

	public void setAperturaGate(Time aperturaGate) {
		this.aperturaGate = aperturaGate;
	}

	public Time getChiusuraGate() {
		return chiusuraGate;
	}

	public void setChiusuraGate(Time chiusuraGate) {
		this.chiusuraGate = chiusuraGate;
	}

	// COSTRUTTORE
	public VoloPartenze() {
		super();
	}

	public VoloPartenze(String codiceVoloPartenze, Timestamp dataOrarioPartenza, String numeroPrenotazioni,
			Time tempoImbarcoEffettivo, Tratta trt, Gate gt, String statusVolo) {
		super();
		this.gt = gt;
		this.trt = trt;
		this.codiceVoloPartenze = codiceVoloPartenze;
		this.dataOrarioPartenza = dataOrarioPartenza;
		this.numeroPrenotazioni = numeroPrenotazioni;
		this.tempoImbarcoEffettivo = tempoImbarcoEffettivo;
		this.statusVolo = statusVolo;
	}

	public VoloPartenze(String codiceVoloPartenze) {
		this.codiceVoloPartenze = codiceVoloPartenze;
	}

	public VoloPartenze(String codiceVoloPartenze, String status) {
		super();
		this.codiceVoloPartenze = codiceVoloPartenze;
		this.statusVolo = status;
	}

	public VoloPartenze(String codiceVoloPartenze, Time tempoImbarcoEffettivo) {
		super();
		this.codiceVoloPartenze = codiceVoloPartenze;
		this.tempoImbarcoEffettivo = tempoImbarcoEffettivo;
	}

	public VoloPartenze(String codiceVoloPartenze, String statusVolo, Time tempoImbarcoEffettivo) {
		super();
		this.codiceVoloPartenze = codiceVoloPartenze;
		this.statusVolo = statusVolo;
		this.tempoImbarcoEffettivo = tempoImbarcoEffettivo;
	}

}