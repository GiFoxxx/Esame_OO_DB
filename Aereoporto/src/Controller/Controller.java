package Controller;

import java.awt.Component;
import java.sql.*;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;

import Amministrazione.*;
import Classi.*;
import Database.*;
import GUI.*;
import ImplementazioniPostrgresDAO.*;

public class Controller {

	private Dashboard dashboard;
	private Home home;
	private Accesso accesso;
	private Registrazione registrazione;
	private Riconoscimenti riconoscimenti;
	private MenuGestione menuGestione;
	private GestioneVoli gestioneVoli;
	private Prenotazione prenotazioni;
	private GestioneUtenti gestioneUtenti;
	private GestioneCompagnieAeree gestioneCompagnieAeree;
	private GestioneTratte gestioneTratte;
	private GestioneGate gestioneGate;
	private Uscita uscita;

	Utente utn;
	Volo vl;
	Gate gt;
	Tratta trt;
	CompagniaAerea compAerea;

	// GETTER E SETTER
	public Dashboard getDashboard() {
		return dashboard;
	}

	public void setDashboard(Dashboard dashboard) {
		this.dashboard = dashboard;
	}

	public Home getHome() {
		return home;
	}

	public void setHome(Home home) {
		this.home = home;
	}

	public Accesso getAccesso() {
		return accesso;
	}

	public void setAccesso(Accesso accesso) {
		this.accesso = accesso;
	}

	public Registrazione getRegistrazione() {
		return registrazione;
	}

	public void setRegistrazione(Registrazione registrazione) {
		this.registrazione = registrazione;
	}

	public Riconoscimenti getRiconoscimenti() {
		return riconoscimenti;
	}

	public void setRiconoscimenti(Riconoscimenti riconoscimenti) {
		this.riconoscimenti = riconoscimenti;
	}

	public MenuGestione getMenuGestione() {
		return menuGestione;
	}

	public void setMenuGestione(MenuGestione menuGestione) {
		this.menuGestione = menuGestione;
	}

	public GestioneVoli getGestioneVoli() {
		return gestioneVoli;
	}

	public void setGestioneVoli(GestioneVoli gestioneVoli) {
		this.gestioneVoli = gestioneVoli;
	}

	public Prenotazione getPrenotazioni() {
		return prenotazioni;
	}

	public void setPrenotazioni(Prenotazione prenotazioni) {
		this.prenotazioni = prenotazioni;
	}

	public GestioneUtenti getGestioneUtenti() {
		return gestioneUtenti;
	}

	public void setGestioneUtenti(GestioneUtenti gestioneUtenti) {
		this.gestioneUtenti = gestioneUtenti;
	}

	public GestioneCompagnieAeree getGestioneCompagnieAeree() {
		return gestioneCompagnieAeree;
	}

	public void setGestioneCompagnieAeree(GestioneCompagnieAeree gestioneCompagnieAeree) {
		this.gestioneCompagnieAeree = gestioneCompagnieAeree;
	}

	public GestioneTratte getGestioneTratte() {
		return gestioneTratte;
	}

	public void setGestioneTratte(GestioneTratte gestioneTratte) {
		this.gestioneTratte = gestioneTratte;
	}

	public GestioneGate getGestioneGate() {
		return gestioneGate;
	}

	public void setGestioneGate(GestioneGate gestioneGate) {
		this.gestioneGate = gestioneGate;
	}

	public Uscita getUscita() {
		return uscita;
	}

	public void setUscita(Uscita uscita) {
		this.uscita = uscita;
	}

	public static void main(String[] args) {
		Controller controller = new Controller();
	}

	// COSTRUTTORE
	public Controller() { // prima schermata
		home = new Home(this);
		dashboard = new Dashboard(this);
		accesso = new Accesso(this);
		registrazione = new Registrazione(this);
		menuGestione = new MenuGestione(this);
		riconoscimenti = new Riconoscimenti(this);
		prenotazioni = new Prenotazione(this);
		gestioneUtenti = new GestioneUtenti(this);
		gestioneCompagnieAeree = new GestioneCompagnieAeree(this);
		gestioneTratte = new GestioneTratte(this);
		gestioneGate = new GestioneGate(this);
		gestioneVoli = new GestioneVoli(this);
		dashboard.setVisible(true);
	}

	// METODI DI ACCESSO
	public void vaiAMenuGestioneDaAccesso() {
		accesso.setVisible(false);
		menuGestione.setVisible(true);
	}

	public void vaiAGateDaMenuGestione() {
		menuGestione.setVisible(false);
		gestioneCompagnieAeree.setVisible(true);
	}

	public void svuotaCampiAccesso() {
		((GUI.Accesso) getDashboard().getAccesso()).getTxtEmail().setText("");
		((GUI.Accesso) getDashboard().getAccesso()).getTxtPassword().setText("");

	}

	public boolean controlloCampiSeVuotiAccesso() {
		if (accesso.getTxtEmail().getText().length() <= 0 && accesso.getTxtPassword().getText().length() <= 0) {
			return true;
		} else {
			return false;
		}
	}

	// METODI DI REGISTRAZIONE
	public void svuotaCampiRegistrazione() {
		((GUI.Registrazione) getDashboard().getAccesso()).getTxtNome().setText("");
		((GUI.Registrazione) getDashboard().getAccesso()).getTxtCognome().setText("");
		((GUI.Registrazione) getDashboard().getAccesso()).getTxtEmail().setText("");
		((GUI.Registrazione) getDashboard().getAccesso()).getTxtPassword().setText("");
		((GUI.Registrazione) getDashboard().getAccesso()).getTxtRipetiPassword().setText("");
	}

	public void vaiAdAccessoDopoRegistrazione() {
		mostraPannelli(accesso);
	}

	public boolean controlloInserimentoEmailCorrettamenteRegistrazione(String mail) {
		Pattern p = Pattern.compile(".+@.+\\.[a-z]+", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(mail);
		boolean matchFound = m.matches();
		String expressionPlus = "^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
		Pattern pPlus = Pattern.compile(expressionPlus, Pattern.CASE_INSENSITIVE);
		Matcher mPlus = pPlus.matcher(mail);
		boolean matchFoundPlus = mPlus.matches();

		return matchFound && matchFoundPlus;
	}

	// METODI GESTIONE UTENTI
	public void svuotaCampiGestioneUtenti() {
		((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtNome().setText("");
		((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtCognome().setText("");
		((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtEmail().setText("");
		((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtPassword().setText("");
	}

	public UtenteImplementazionePostgresDAO implementazioneUtenteDAO() {
		UtenteImplementazionePostgresDAO dao = new UtenteImplementazionePostgresDAO();
		return dao;
	}

	public void aggiungiUtente() {
		utn = new Utente(((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtNome().getText(), ((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtCognome().getText(),
				((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtEmail().getText(), ((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtPassword().getText());
		implementazioneUtenteDAO().registrazioneUtente(utn);
		((GestioneUtenti) getDashboard().getGestioneUtenti()).getModello().addRow(((GestioneUtenti) getDashboard().getGestioneUtenti()).getRow());
		svuotaCampiGestioneUtenti();
		((GestioneUtenti) getDashboard().getGestioneUtenti()).caricamento();
	}

	public void eliminaUtente() {
		utn = new Utente(((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtNome().getText(), ((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtCognome().getText(),
				((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtEmail().getText(), ((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtPassword().getText());
		int t = ((GestioneUtenti) getDashboard().getGestioneUtenti()).getTable().getSelectedRow();
		implementazioneUtenteDAO().cancellaUtente(utn);
		((GestioneUtenti) getDashboard().getGestioneUtenti()).getModello().removeRow(t);
		svuotaCampiGestioneUtenti();
		((GestioneUtenti) getDashboard().getGestioneUtenti()).caricamento();
	}

	public void modificaUtente() {
		utn = new Utente(((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtNome().getText(), ((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtCognome().getText(),
				((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtEmail().getText(), ((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtPassword().getText());
		int t = ((GestioneUtenti) getDashboard().getGestioneUtenti()).getTable().getSelectedRow();

		((GestioneUtenti) getDashboard().getGestioneUtenti()).getModello().setValueAt(((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtNome().getText(), t, 0);
		((GestioneUtenti) getDashboard().getGestioneUtenti()).getModello().setValueAt(((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtCognome().getText(), t, 1);
		((GestioneUtenti) getDashboard().getGestioneUtenti()).getModello().setValueAt(((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtEmail().getText(), t, 2);
		((GestioneUtenti) getDashboard().getGestioneUtenti()).getModello().setValueAt(((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtPassword().getText(), t, 3);

		implementazioneUtenteDAO().modificaUtente(utn);
		svuotaCampiGestioneUtenti();
		((GestioneUtenti) getDashboard().getGestioneUtenti()).caricamento();
	}

	// METODI GESTIONE COMPAGNIA AEREA

	public void svuotaCampiCompagniaAerea() {
		((GestioneCompagnieAeree1) getDashboard().getGestioneCompagnieAeree()).getTxtCodiceCompagniaAerea().setText("");
		((GestioneCompagnieAeree1) getDashboard().getGestioneCompagnieAeree()).getTxtNome().setText("");
	}

	public CompagniaAereaImplementazionePostgresDAO implementazioneCompagniaAereaDAO() {
		CompagniaAereaImplementazionePostgresDAO dao = new CompagniaAereaImplementazionePostgresDAO();
		return dao;
	}

	public void aggiungiCompagniaAerea() {
		compAerea = new CompagniaAerea(((GestioneCompagnieAeree1) getDashboard().getGestioneCompagnieAeree()).getTxtCodiceCompagniaAerea().getText(),
				((GestioneCompagnieAeree1) getDashboard().getGestioneCompagnieAeree()).getTxtNome().getText());
		implementazioneCompagniaAereaDAO().aggiungiCompagniaAerea(compAerea);
		((GestioneCompagnieAeree1) getDashboard().getGestioneCompagnieAeree()).getModello().addRow(((GestioneCompagnieAeree1) getDashboard().getGestioneCompagnieAeree()).getRow());
		svuotaCampiCompagniaAerea();
		((GestioneCompagnieAeree1) getDashboard().getGestioneCompagnieAeree()).caricamento();
	}

	public void eliminaCompagniaAerea() {
		compAerea = new CompagniaAerea(((GestioneCompagnieAeree1) getDashboard().getGestioneCompagnieAeree()).getTxtCodiceCompagniaAerea().getText(),
				((GestioneCompagnieAeree1) getDashboard().getGestioneCompagnieAeree()).getTxtNome().getText());
		int t = ((GestioneCompagnieAeree1) getDashboard().getGestioneCompagnieAeree()).getTable().getSelectedRow();
		implementazioneCompagniaAereaDAO().cancellaCompagniaAerea(compAerea);
		((GestioneCompagnieAeree1) getDashboard().getGestioneCompagnieAeree()).getModello().removeRow(t);
		svuotaCampiCompagniaAerea();
		((GestioneCompagnieAeree1) getDashboard().getGestioneCompagnieAeree()).caricamento();
	}

	public void modificaCompagniaAerea() {
		compAerea = new CompagniaAerea(((GestioneCompagnieAeree1) getDashboard().getGestioneCompagnieAeree()).getTxtCodiceCompagniaAerea().getText(),
				((GestioneCompagnieAeree1) getDashboard().getGestioneCompagnieAeree()).getTxtNome().getText());
		int t = ((GestioneCompagnieAeree1) getDashboard().getGestioneCompagnieAeree()).getTable().getSelectedRow();

		((GestioneCompagnieAeree1) getDashboard().getGestioneCompagnieAeree()).getModello().setValueAt(((GestioneCompagnieAeree1) getDashboard().getGestioneCompagnieAeree()).getTxtCodiceCompagniaAerea().getText(), t, 0);
		((GestioneCompagnieAeree1) getDashboard().getGestioneCompagnieAeree()).getModello().setValueAt(((GestioneCompagnieAeree1) getDashboard().getGestioneCompagnieAeree()).getTxtNome().getText(), t,1);

		implementazioneCompagniaAereaDAO().modificaCompagniaAerea(compAerea);
		svuotaCampiCompagniaAerea();
		((GestioneCompagnieAeree1) getDashboard().getGestioneCompagnieAeree()).caricamento();
	}

	// METODI GESTIONE TRATTE

	public void svuotaCampiTratta() {
		((GestioneTratte) getDashboard().getGestioneTratte()).getTxtCodiceTratta().setText("");
		((GestioneTratte) getDashboard().getGestioneTratte()).getTxtCittaPartenza().setText("");
		((GestioneTratte) getDashboard().getGestioneTratte()).getTxtCittaArrivo().setText("");
		((GestioneTratte) getDashboard().getGestioneTratte()).getDateDataPartenza().setDate(null);
		((GestioneTratte) getDashboard().getGestioneTratte()).getDateDataArrivo().setDate(null);
		((GestioneTratte) getDashboard().getGestioneTratte()).getTxtOrarioPartenza().setText("");
		((GestioneTratte) getDashboard().getGestioneTratte()).getTxtOrarioArrivo().setText("");
	}

	public TrattaImplementazionePostgresDAO implementazioneTrattaDAO() {
		TrattaImplementazionePostgresDAO dao = new TrattaImplementazionePostgresDAO();
		return dao;
	}

	public void aggiungiTratta() {
		trt = new Tratta(((GestioneTratte) getDashboard().getGestioneTratte()).getTxtCodiceTratta().getText(), ((GestioneTratte) getDashboard().getGestioneTratte()).getTxtCittaPartenza().getText(),
				((GestioneTratte) getDashboard().getGestioneTratte()).getTxtCittaArrivo().getText(), ((GestioneTratte) getDashboard().getGestioneTratte()).getDateDataPartenza().getDate(),
				((GestioneTratte) getDashboard().getGestioneTratte()).getDateDataArrivo().getDate(), ((GestioneTratte) getDashboard().getGestioneTratte()).getTxtOrarioPartenza().getText(),
				((GestioneTratte) getDashboard().getGestioneTratte()).getTxtOrarioArrivo().getText());
		implementazioneTrattaDAO().aggiungiTratta(trt);
		((GestioneTratte) getDashboard().getGestioneTratte()).getModello().addRow(((GestioneTratte) getDashboard().getGestioneTratte()).getRow());
		svuotaCampiTratta();
		((GestioneTratte) getDashboard().getGestioneTratte()).caricamento();
	}

	public void eliminaTratta() {
		trt = new Tratta(((GestioneTratte) getDashboard().getGestioneTratte()).getTxtCodiceTratta().getText(), ((GestioneTratte) getDashboard().getGestioneTratte()).getTxtCittaPartenza().getText(),
				((GestioneTratte) getDashboard().getGestioneTratte()).getTxtCittaArrivo().getText(), ((GestioneTratte) getDashboard().getGestioneTratte()).getDateDataPartenza().getDate(),
				((GestioneTratte) getDashboard().getGestioneTratte()).getDateDataArrivo().getDate(), ((GestioneTratte) getDashboard().getGestioneTratte()).getTxtOrarioPartenza().getText(),
				((GestioneTratte) getDashboard().getGestioneTratte()).getTxtOrarioArrivo().getText());

		int t = ((GestioneTratte) getDashboard().getGestioneTratte()).getTable().getSelectedRow();
		implementazioneTrattaDAO().cancellaTratta(trt);
		((GestioneTratte) getDashboard().getGestioneTratte()).getModello().removeRow(t);
		svuotaCampiTratta();
		((GestioneTratte) getDashboard().getGestioneTratte()).caricamento();
	}

	public void modificaTratta() {
		trt = new Tratta(((GestioneTratte) getDashboard().getGestioneTratte()).getTxtCodiceTratta().getText(), ((GestioneTratte) getDashboard().getGestioneTratte()).getTxtCittaPartenza().getText(),
				((GestioneTratte) getDashboard().getGestioneTratte()).getTxtCittaArrivo().getText(), ((GestioneTratte) getDashboard().getGestioneTratte()).getDateDataPartenza().getDate(),
				((GestioneTratte) getDashboard().getGestioneTratte()).getDateDataArrivo().getDate(), ((GestioneTratte) getDashboard().getGestioneTratte()).getTxtOrarioPartenza().getText(),
				((GestioneTratte) getDashboard().getGestioneTratte()).getTxtOrarioArrivo().getText());

		int t = ((GestioneTratte) getDashboard().getGestioneTratte()).getTable().getSelectedRow();

		((GestioneTratte) getDashboard().getGestioneTratte()).getModello().setValueAt(((GestioneTratte) getDashboard().getGestioneTratte()).getTxtCodiceTratta().getText(), t, 0);
		((GestioneTratte) getDashboard().getGestioneTratte()).getModello().setValueAt(((GestioneTratte) getDashboard().getGestioneTratte()).getTxtCittaPartenza().getText(), t, 1);
		((GestioneTratte) getDashboard().getGestioneTratte()).getModello().setValueAt(((GestioneTratte) getDashboard().getGestioneTratte()).getTxtCittaArrivo().getText(), t, 2);

		implementazioneTrattaDAO().modificaTratta(trt);
		svuotaCampiTratta();
		((GestioneTratte) getDashboard().getGestioneTratte()).caricamento();
	}

	// METODI GESTIONE VOLI

	public void svuotaCampiVolo() {
		((GestioneVoli) getDashboard().getGestioneVoli()).getTxtCodiceVolo().setText("");
		((GestioneVoli) getDashboard().getGestioneVoli()).getTxtCittaPartenza().setText("");
		((GestioneVoli) getDashboard().getGestioneVoli()).getTxtCittaArrivo().setText("");
		((GestioneVoli) getDashboard().getGestioneVoli()).getDateDataPartenza().setDate(null);
		((GestioneVoli) getDashboard().getGestioneVoli()).getDateDataArrivo().setDate(null);
		((GestioneVoli) getDashboard().getGestioneVoli()).getTxtOrarioPartenza().setText("");
		((GestioneVoli) getDashboard().getGestioneVoli()).getTxtOrarioArrivo().setText("");
		((GestioneVoli) getDashboard().getGestioneVoli()).getTxtNumeroPrenotazioni().setText(null);
	}

	public VoloImplementazionePostgresDAO implementazioneVoloDAO() {
		VoloImplementazionePostgresDAO dao = new VoloImplementazionePostgresDAO();
		return dao;
	}

	public void aggiungiVolo() {
		vl = new Volo(((GestioneVoli) getDashboard().getGestioneVoli()).getTxtCodiceVolo().getText(), ((GestioneVoli) getDashboard().getGestioneVoli()).getTxtCittaPartenza().getText(),
				((GestioneVoli) getDashboard().getGestioneVoli()).getTxtCittaArrivo().getText(), ((GestioneVoli) getDashboard().getGestioneVoli()).getDateDataPartenza().getDate(),
				((GestioneVoli) getDashboard().getGestioneVoli()).getDateDataArrivo().getDate(), ((GestioneVoli) getDashboard().getGestioneVoli()).getTxtOrarioPartenza().getText(),
				((GestioneVoli) getDashboard().getGestioneVoli()).getTxtOrarioArrivo().getText(), ((GestioneVoli) getDashboard().getGestioneVoli()).getTxtNumeroPrenotazioni().getText());

		implementazioneVoloDAO().aggiungiVolo(vl);
		((GestioneVoli) getDashboard().getGestioneVoli()).getModello().addRow(((GestioneVoli) getDashboard().getGestioneVoli()).getRow());
		svuotaCampiVolo();
		((GestioneVoli) getDashboard().getGestioneVoli()).caricamento();
	}

	public void eliminaVolo() {
		vl = new Volo(((GestioneVoli) getDashboard().getGestioneVoli()).getTxtCodiceVolo().getText(), ((GestioneVoli) getDashboard().getGestioneVoli()).getTxtCittaPartenza().getText(),
				((GestioneVoli) getDashboard().getGestioneVoli()).getTxtCittaArrivo().getText(), ((GestioneVoli) getDashboard().getGestioneVoli()).getDateDataPartenza().getDate(),
				((GestioneVoli) getDashboard().getGestioneVoli()).getDateDataArrivo().getDate(), ((GestioneVoli) getDashboard().getGestioneVoli()).getTxtOrarioPartenza().getText(),
				((GestioneVoli) getDashboard().getGestioneVoli()).getTxtOrarioArrivo().getText(), ((GestioneVoli) getDashboard().getGestioneVoli()).getTxtNumeroPrenotazioni().getText());

		int t = ((GestioneVoli) getDashboard().getGestioneVoli()).getTable().getSelectedRow();
		implementazioneVoloDAO().cancellaVolo(vl);
		((GestioneVoli) getDashboard().getGestioneVoli()).getModello().removeRow(t);
		svuotaCampiVolo();
		((GestioneVoli) getDashboard().getGestioneVoli()).caricamento();
	}

	public void modificaVolo() {
		vl = new Volo(((GestioneVoli) getDashboard().getGestioneVoli()).getTxtCodiceVolo().getText(), ((GestioneVoli) getDashboard().getGestioneVoli()).getTxtCittaPartenza().getText(),
				((GestioneVoli) getDashboard().getGestioneVoli()).getTxtCittaArrivo().getText(), ((GestioneVoli) getDashboard().getGestioneVoli()).getDateDataPartenza().getDate(),
				((GestioneVoli) getDashboard().getGestioneVoli()).getDateDataArrivo().getDate(), ((GestioneVoli) getDashboard().getGestioneVoli()).getTxtOrarioPartenza().getText(),
				((GestioneVoli) getDashboard().getGestioneVoli()).getTxtOrarioArrivo().getText(), ((GestioneVoli) getDashboard().getGestioneVoli()).getTxtNumeroPrenotazioni().getText());

		int t = ((GestioneVoli) getDashboard().getGestioneVoli()).getTable().getSelectedRow();

		((GestioneVoli) getDashboard().getGestioneVoli()).getModello().setValueAt(((GestioneVoli) getDashboard().getGestioneVoli()).getTxtCodiceVolo().getText(), t, 0);
		((GestioneVoli) getDashboard().getGestioneVoli()).getModello().setValueAt(((GestioneVoli) getDashboard().getGestioneVoli()).getTxtCittaPartenza().getText(), t, 1);
		((GestioneVoli) getDashboard().getGestioneVoli()).getModello().setValueAt(((GestioneVoli) getDashboard().getGestioneVoli()).getTxtCittaArrivo().getText(), t, 2);
		((GestioneVoli) getDashboard().getGestioneVoli()).getModello().setValueAt(((GestioneVoli) getDashboard().getGestioneVoli()).getDateDataPartenza().getDate(), t, 3);
		((GestioneVoli) getDashboard().getGestioneVoli()).getModello().setValueAt(((GestioneVoli) getDashboard().getGestioneVoli()).getDateDataArrivo().getDate(), t, 4);
		((GestioneVoli) getDashboard().getGestioneVoli()).getModello().setValueAt(((GestioneVoli) getDashboard().getGestioneVoli()).getTxtOrarioPartenza().getText(), t, 5);
		((GestioneVoli) getDashboard().getGestioneVoli()).getModello().setValueAt(((GestioneVoli) getDashboard().getGestioneVoli()).getTxtOrarioArrivo().getText(), t, 6);
		((GestioneVoli) getDashboard().getGestioneVoli()).getModello().setValueAt(((GestioneVoli) getDashboard().getGestioneVoli()).getTxtNumeroPrenotazioni().getText(), t, 7);

		implementazioneVoloDAO().modificaVolo(vl);
		svuotaCampiVolo();
		((GestioneVoli) getDashboard().getGestioneVoli()).caricamento();
	}

	// METODI GESTIONE GATE

	public void svuotaCampiGate() {
		((GestioneGate) getDashboard().getGestioneGate()).getTxtCodiceGate().setText("");
		((GestioneGate) getDashboard().getGestioneGate()).getTxtNumeroPorta().setText("");
		((GestioneGate) getDashboard().getGestioneGate()).getTxtInizioImbarco().setText("");
		((GestioneGate) getDashboard().getGestioneGate()).getTxtFineImbarco().setText("");
	}

	public GateImplementazionePostgresDAO implementazioneGateDAO() {
		GateImplementazionePostgresDAO dao = new GateImplementazionePostgresDAO();
		return dao;
	}

	public void aggiungiGate() {
		gt = new Gate(((GestioneGate) getDashboard().getGestioneGate()).getTxtCodiceGate().getText(),
				((GestioneGate) getDashboard().getGestioneGate()).getTxtNumeroPorta().getText(),
				((GestioneGate) getDashboard().getGestioneGate()).getTxtInizioImbarco().getText(),
				((GestioneGate) getDashboard().getGestioneGate()).getTxtFineImbarco().getText());
		implementazioneGateDAO().aggiungiGate(gt);
		((GestioneGate) getDashboard().getGestioneGate()).getModello()
				.addRow(((GestioneGate) getDashboard().getGestioneGate()).getRow());
		svuotaCampiGate();
		((GestioneGate) getDashboard().getGestioneGate()).caricamento();
	}

	public void eliminaGate() {
		gt = new Gate(((GestioneGate) getDashboard().getGestioneGate()).getTxtCodiceGate().getText(),
				((GestioneGate) getDashboard().getGestioneGate()).getTxtNumeroPorta().getText(),
				((GestioneGate) getDashboard().getGestioneGate()).getTxtInizioImbarco().getText(),
				((GestioneGate) getDashboard().getGestioneGate()).getTxtFineImbarco().getText());

		int t = ((GestioneGate) getDashboard().getGestioneGate()).getTable().getSelectedRow();
		implementazioneGateDAO().cancellaGate(gt);
		((GestioneGate) getDashboard().getGestioneGate()).getModello().removeRow(t);
		svuotaCampiGate();
		((GestioneGate) getDashboard().getGestioneGate()).caricamento();
	}

	public void modificaGate() {
		gt = new Gate(((GestioneGate) getDashboard().getGestioneGate()).getTxtCodiceGate().getText(),
				((GestioneGate) getDashboard().getGestioneGate()).getTxtNumeroPorta().getText(),
				((GestioneGate) getDashboard().getGestioneGate()).getTxtInizioImbarco().getText(),
				((GestioneGate) getDashboard().getGestioneGate()).getTxtFineImbarco().getText());

		int t = ((GestioneGate) getDashboard().getGestioneGate()).getTable().getSelectedRow();

		((GestioneGate) getDashboard().getGestioneGate()).getModello()
				.setValueAt(((GestioneGate) getDashboard().getGestioneGate()).getTxtCodiceGate().getText(), t, 0);
		((GestioneGate) getDashboard().getGestioneGate()).getModello()
				.setValueAt(((GestioneGate) getDashboard().getGestioneGate()).getTxtNumeroPorta().getText(), t, 1);
		((GestioneGate) getDashboard().getGestioneGate()).getModello()
				.setValueAt(((GestioneGate) getDashboard().getGestioneGate()).getTxtInizioImbarco().getText(), t, 2);
		((GestioneGate) getDashboard().getGestioneGate()).getModello()
				.setValueAt(((GestioneGate) getDashboard().getGestioneGate()).getTxtFineImbarco().getText(), t, 3);

		implementazioneGateDAO().modificaGate(gt);
		svuotaCampiGate();
		((GestioneGate) getDashboard().getGestioneGate()).caricamento();
	}

	// METODI DASHBOARD

	public JPanel home() {
		Home home = new Home(this);
		return home;
	}

	public JPanel accesso() {
		Accesso accesso = new Accesso(this);
		return accesso;
	}

	public JPanel registrazione() {
		Registrazione registrazione = new Registrazione(this);
		return registrazione;
	}

	public JPanel gestioneUtenti() {
		GestioneUtenti gestioneUtenti = new GestioneUtenti(this);
		return gestioneUtenti;
	}
	
	public JPanel gestioneCompagnieAeree() {
		GestioneCompagnieAeree1 gestioneCompagnieAeree1 = new GestioneCompagnieAeree1(this);
		return gestioneCompagnieAeree1;
	}
	
	public JPanel gestioneGate() {
		GestioneGate gestioneGate = new GestioneGate(this);
		return gestioneGate;
	}
	
	public JPanel gestioneTratte() {
		GestioneTratte gestioneTratte = new GestioneTratte(this);
		return gestioneTratte;
	}
	
	public JPanel gestioneVoli() {
		GestioneVoli gestioneVoli = new GestioneVoli(this);
		return gestioneVoli;
	}
	
	public JDialog uscita() {
		Uscita uscita = new Uscita(this);
		return uscita;
	}
//	
//	public JPanel home() {
//		Home home = new Home(this);
//		return home;
//	}

	public void mostraPannelli(JPanel pane) {
		dashboard.getHome().setVisible(false);
		dashboard.getAccesso().setVisible(false);
		dashboard.getRegistrazione().setVisible(false);
		dashboard.getGestioneGate().setVisible(false);
		dashboard.getGestioneTratte().setVisible(false);
		dashboard.getGestioneVoli().setVisible(false);
		pane.setVisible(true);

	}
	
	public void mostraUscita() {
		dashboard.getUscita().setVisible(true);;
	}

	// METODI DI PROVA

//	@SuppressWarnings("deprecation")
//	public void calcoloRitardo() {
//		Calendar ArrivoTeorico = Calendar.getInstance();
//		Calendar ArrivoEffettivo = Calendar.getInstance();
//
//		ArrivoTeorico.set(Calendar.YEAR, gestioneTratte.getDateDataPartenza().getDate().getYear());
//		ArrivoTeorico.set(Calendar.MONTH, gestioneTratte.getDateDataPartenza().getDate().getMonth());
//		ArrivoTeorico.set(Calendar.DAY_OF_MONTH, gestioneTratte.getDateDataPartenza().getDate().getDay());
//		ArrivoTeorico.set(Calendar.HOUR_OF_DAY , gestioneTratte.getDateDataPartenza().getDate().getHours());
//		ArrivoTeorico.set(Calendar.MINUTE, gestioneTratte.getDateDataPartenza().getDate().getMinutes());
//		ArrivoTeorico.set(Calendar.SECOND, gestioneTratte.getDateDataPartenza().getDate().getSeconds());
//		
//		ArrivoEffettivo.set(Calendar.YEAR, gestioneTratte.getDateDataArrivo().getDate().getYear());
//		ArrivoEffettivo.set(Calendar.MONTH, gestioneTratte.getDateDataArrivo().getDate().getMonth());
//		ArrivoEffettivo.set(Calendar.DAY_OF_MONTH, gestioneTratte.getDateDataArrivo().getDate().getDay());
//		ArrivoEffettivo.set(Calendar.HOUR_OF_DAY , gestioneTratte.getDateDataArrivo().getDate().getHours());
//		ArrivoEffettivo.set(Calendar.MINUTE, gestioneTratte.getDateDataArrivo().getDate().getMinutes());
//		ArrivoEffettivo.set(Calendar.SECOND, gestioneTratte.getDateDataArrivo().getDate().getSeconds());
//
//		long Differenza_ArrivoTeorico = ArrivoTeorico.getTimeInMillis();
//		long Differenza_ArrivoEffettivo = ArrivoEffettivo.getTimeInMillis();
//		long ritardo_Arrivo = Differenza_ArrivoEffettivo - Differenza_ArrivoTeorico;
//		long ritardoSecondo_Arrivo = ritardo_Arrivo / 1000;
//		long ritardoMinuto_Arrivo = ritardoSecondo_Arrivo / 60;
//		long ritardoOra_Arrivo = ritardoMinuto_Arrivo / 60;
//		long ritardoGiorno_Arrivo = ritardoOra_Arrivo / 24;
//		long ritardoMese_Arrivo = ritardoGiorno_Arrivo / 30;
//		long ritardoAnno_Arrivo = ritardoMese_Arrivo / 12;
//
//		if (ritardoAnno_Arrivo == 1) {
//			System.out.println("Il ritardo della partenze è di: " + ritardoAnno_Arrivo + " anno.");
//		} else if (ritardoAnno_Arrivo > 1) {
//			System.out.println("Il ritardo della partenze è di: " + ritardoAnno_Arrivo + " anni.");
//		} else if (ritardoMese_Arrivo == 1) {
//			System.out.println("Il ritardo della partenze è di: " + ritardoMese_Arrivo + " mese.");
//		} else if (ritardoMese_Arrivo > 1) {
//			System.out.println("Il ritardo della partenze è di: " + ritardoMese_Arrivo + " mesi.");
//		} else if (ritardoGiorno_Arrivo == 1) {
//			System.out.println("Il ritardo della partenze è di: " + ritardoGiorno_Arrivo + " giorno.");
//		} else if (ritardoGiorno_Arrivo > 1) {
//			System.out.println("Il ritardo della partenze è di: " + ritardoGiorno_Arrivo + " giorni.");
//		} else if (ritardoOra_Arrivo == 1) {
//			System.out.println("Il ritardo della partenze è di: " + ritardoOra_Arrivo + " ora.");
//		} else if (ritardoOra_Arrivo > 1) {
//			System.out.println("Il ritardo della partenze è di: " + ritardoOra_Arrivo + " ore.");
//		} else if (ritardoMinuto_Arrivo == 1) {
//			System.out.println("Il ritardo della partenze è di: " + ritardoMinuto_Arrivo + " minuto.");
//		} else if (ritardoMinuto_Arrivo > 1) {
//			System.out.println("Il ritardo della partenze è di: " + ritardoMinuto_Arrivo + " minuti.");
//		} else if (ritardoSecondo_Arrivo == 1) {
//			System.out.println("Il ritardo della partenze è di: " + ritardoSecondo_Arrivo + " secondo.");
//		} else if (ritardoSecondo_Arrivo > 1) {
//			System.out.println("Il ritardo della partenze è di: " + ritardoSecondo_Arrivo + " secondi.");
//		}
//	}

//	public int tentativoAccesso() { // controllo credenziali
//		if (accesso.getTxtUtente().getText().equals("io") && accesso.getTxtPassword().getText().equals("io")) {
//			return 1;
//		} else if (accesso.getTxtUtente().getText().equals("") || accesso.getTxtUtente().getText().equals("Nome utente")
//				|| accesso.getTxtPassword().getText().equals("")
//				|| accesso.getTxtPassword().getText().equals("Password")) {
//			return 0;
//		} else {
//			return -1;
//		}
//	}
//
//	public void Accedi() { // opzioni credenziali
//		if (tentativoAccesso() == 1) {
//			menuGestioneDaAccesso();
//		} else if (tentativoAccesso() == 0) {
//			accesso.MostraInserimentoCredenziali();
//		} else if (tentativoAccesso() == -1) {
//			accesso.MostraErroreAccesso();
//		}
//	}

}
