package Classi;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

public class VoloPartenze {

	Gate gt;
	Tratta trt;

	// ATTRIBUTI
	private String codiceVoloPartenze;
	private Timestamp dataOrarioPartenza;
	private Date dataPartenza;
	private Time orarioPartenza;
	private String numeroPrenotazioni;
	private boolean status;

	public VoloPartenze(String codiceVoloPartenze, boolean status) {
		super();
		this.codiceVoloPartenze = codiceVoloPartenze;
		this.status = status;
	}

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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
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

	public Timestamp getDataOrarioPartenza() {
		return dataOrarioPartenza;
	}

	public void setDataOrarioPartenza(Timestamp dataOrarioPartenza) {
		this.dataOrarioPartenza = dataOrarioPartenza;
	}

	// COSTRUTTORE
	public VoloPartenze() {
		super();
	}

	public VoloPartenze(String codiceVoloPartenze, Date dataPartenza, Time orarioPartenza, String numeroPrenotazioni,
			Tratta trt, Gate gt, boolean status) {
		super();
		this.gt = gt;
		this.trt = trt;
		this.status = status;
		this.codiceVoloPartenze = codiceVoloPartenze;
		this.dataPartenza = dataPartenza;
		this.orarioPartenza = orarioPartenza;
		this.numeroPrenotazioni = numeroPrenotazioni;
	}

	public VoloPartenze(String codiceVoloPartenze, Timestamp dataOrarioPartenza, String numeroPrenotazioni, Tratta trt,
			Gate gt, boolean status) {
		super();
		this.gt = gt;
		this.trt = trt;
		this.codiceVoloPartenze = codiceVoloPartenze;
		this.dataOrarioPartenza = dataOrarioPartenza;
		this.numeroPrenotazioni = numeroPrenotazioni;
	}

	public VoloPartenze(String codiceVoloPartenze) {
		this.codiceVoloPartenze = codiceVoloPartenze;
	}

	public VoloPartenze(String string, String string2, String string3, String string4, java.sql.Date date,
			String string5, String string6, String string7, String string8, String string9, int int1) {
	}

}