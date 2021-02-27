package Classi;

import java.sql.Time;
import java.util.Date;

public class VoloPartenze {

	
	Gate gt;
	Tratta trt;

	// ATTRIBUTI
	private String codiceVoloPartenze;
	private Date dataPartenza;
	private Time orarioPartenza;
	private String numeroPrenotazioni;
	private int ritardo;
	

	// GETTER E SETTER
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

	public Time getOrarioPartenza() {
		return orarioPartenza;
	}

	public void setOrarioPartenza(Time orarioPartenza) {
		this.orarioPartenza = orarioPartenza;
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

	public VoloPartenze(String codiceVoloPartenze, Date dataPartenza, Time orarioPartenza,
			String numeroPrenotazioni, int ritardo, Tratta trt, Gate gt) {
		super();
		this.gt = gt;
		this.trt = trt;
		this.codiceVoloPartenze = codiceVoloPartenze;
		this.dataPartenza = dataPartenza;
		this.orarioPartenza = orarioPartenza;
		this.numeroPrenotazioni = numeroPrenotazioni;
		this.ritardo = ritardo;
	}
	
	public VoloPartenze(String codiceVoloPartenze) {
		this.codiceVoloPartenze=codiceVoloPartenze;
	}

	public VoloPartenze(String string, String string2, String string3, String string4, java.sql.Date date,
			String string5, String string6, String string7, String string8, String string9, int int1) {
	}

	

	

	
}