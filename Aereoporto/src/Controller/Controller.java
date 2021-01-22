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
	private GestioneGate1 gestioneGate1;
	private Launcher launcher;

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

	public GestioneGate1 getGestioneGate1() {
		return gestioneGate1;
	}

	public void setGestioneGate1(GestioneGate1 gestioneGate1) {
		this.gestioneGate1 = gestioneGate1;
	}

	public Launcher getLauncher() {
		return launcher;
	}

	public void setLauncher(Launcher launcher) {
		this.launcher = launcher;
	}

	public static void main(String[] args) {
		Controller controller = new Controller();
	}

	// COSTRUTTORE
	public Controller() { // prima schermata
		home = new Home(this);
		dashboard = new Dashboard(this);
		home = new Home(this);
		accesso = new Accesso(this);
		accesso = new Accesso(this);
		registrazione = new Registrazione(this);
		menuGestione = new MenuGestione(this);
		riconoscimenti = new Riconoscimenti(this);
		prenotazioni = new Prenotazione(this);
		gestioneUtenti = new GestioneUtenti(this);
		gestioneCompagnieAeree = new GestioneCompagnieAeree(this);
		gestioneTratte = new GestioneTratte(this);
		gestioneGate = new GestioneGate(this);
		gestioneGate1 = new GestioneGate1(this);
		gestioneVoli = new GestioneVoli(this);
		launcher = new Launcher(this);
		dashboard.setVisible(true);
	}

	// METODI DI ACCESSO
	public void Accesso() { // entro in accesso
		launcher.setVisible(false);
		accesso.setVisible(true);
	}

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
		registrazione.getTxtNome().setText("");
		registrazione.getTxtCognome().setText("");
		registrazione.getTxtEmail().setText("");
		registrazione.getTxtPassword().setText("");
		registrazione.getTxtRipetiPassword().setText("");
	}

	public void Registrazione() { // entro in registrazione da avvio
		launcher.setVisible(false);
		registrazione.setVisible(true);
		svuotaCampiRegistrazione();
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
		gestioneUtenti.getTxtNome().setText("");
		gestioneUtenti.getTxtCognome().setText("");
		gestioneUtenti.getTxtEmail().setText("");
		gestioneUtenti.getTxtPassword().setText("");
	}

	public UtenteImplementazionePostgresDAO implementazioneUtenteDAO() {
		UtenteImplementazionePostgresDAO dao = new UtenteImplementazionePostgresDAO();
		return dao;
	}

	public void aggiungiUtente() {
		utn = new Utente(gestioneUtenti.getTxtNome().getText(), gestioneUtenti.getTxtCognome().getText(),
				gestioneUtenti.getTxtEmail().getText(), gestioneUtenti.getTxtPassword().getText());
		implementazioneUtenteDAO().registrazioneUtente(utn);
		gestioneUtenti.getModello().addRow(gestioneUtenti.getRow());
		svuotaCampiGestioneUtenti();
		gestioneUtenti.caricamento();
	}

	public void eliminaUtente() {
		utn = new Utente(gestioneUtenti.getTxtNome().getText(), gestioneUtenti.getTxtCognome().getText(),
				gestioneUtenti.getTxtEmail().getText(), gestioneUtenti.getTxtPassword().getText());
		int t = gestioneUtenti.getTable().getSelectedRow();
		implementazioneUtenteDAO().cancellaUtente(utn);
		gestioneUtenti.getModello().removeRow(t);
		svuotaCampiGestioneUtenti();
		gestioneUtenti.caricamento();
	}

	public void modificaUtente() {
		utn = new Utente(gestioneUtenti.getTxtNome().getText(), gestioneUtenti.getTxtCognome().getText(),
				gestioneUtenti.getTxtEmail().getText(), gestioneUtenti.getTxtPassword().getText());
		int t = gestioneUtenti.getTable().getSelectedRow();

		gestioneUtenti.getModello().setValueAt(gestioneUtenti.getTxtNome().getText(), t, 0);
		gestioneUtenti.getModello().setValueAt(gestioneUtenti.getTxtCognome().getText(), t, 1);
		gestioneUtenti.getModello().setValueAt(gestioneUtenti.getTxtEmail().getText(), t, 2);
		gestioneUtenti.getModello().setValueAt(gestioneUtenti.getTxtPassword().getText(), t, 3);

		implementazioneUtenteDAO().modificaUtente(utn);
		svuotaCampiGestioneUtenti();
		gestioneUtenti.caricamento();
	}

	// METODI GESTIONE COMPAGNIA AEREA

	public void svuotaCampiCompagniaAerea() {
		gestioneCompagnieAeree.getTxtNome().setText("");
		gestioneCompagnieAeree.getTxtCodiceCompagniaAerea().setText("");
	}

	public CompagniaAereaImplementazionePostgresDAO implementazioneCompagniaAereaDAO() {
		CompagniaAereaImplementazionePostgresDAO dao = new CompagniaAereaImplementazionePostgresDAO();
		return dao;
	}

	public void aggiungiCompagniaAerea() {
		compAerea = new CompagniaAerea(gestioneCompagnieAeree.getTxtCodiceCompagniaAerea().getText(),
				gestioneCompagnieAeree.getTxtNome().getText());
		implementazioneCompagniaAereaDAO().aggiungiCompagniaAerea(compAerea);
		gestioneCompagnieAeree.getModello().addRow(gestioneCompagnieAeree.getRow());
		svuotaCampiCompagniaAerea();
		gestioneCompagnieAeree.caricamento();
	}

	public void eliminaCompagniaAerea() {
		compAerea = new CompagniaAerea(gestioneCompagnieAeree.getTxtNome().getText(),
				gestioneCompagnieAeree.getTxtCodiceCompagniaAerea().getText());
		int t = gestioneCompagnieAeree.getTable().getSelectedRow();
		implementazioneCompagniaAereaDAO().cancellaCompagniaAerea(compAerea);
		gestioneCompagnieAeree.getModello().removeRow(t);
		svuotaCampiCompagniaAerea();
		gestioneCompagnieAeree.caricamento();
	}

	public void modificaCompagniaAerea() {
		compAerea = new CompagniaAerea(gestioneCompagnieAeree.getTxtNome().getText(),
				gestioneCompagnieAeree.getTxtCodiceCompagniaAerea().getText());
		int t = gestioneCompagnieAeree.getTable().getSelectedRow();

		gestioneCompagnieAeree.getModello().setValueAt(gestioneCompagnieAeree.getTxtNome().getText(), t, 0);
		gestioneCompagnieAeree.getModello().setValueAt(gestioneCompagnieAeree.getTxtCodiceCompagniaAerea().getText(), t,
				1);

		implementazioneCompagniaAereaDAO().modificaCompagniaAerea(compAerea);
		svuotaCampiCompagniaAerea();
		gestioneCompagnieAeree.caricamento();
	}

	// METODI GESTIONE TRATTE

	public void svuotaCampiTratta() {
		gestioneTratte.getTxtCodiceTratta().setText("");
		gestioneTratte.getTxtCittaPartenza().setText("");
		gestioneTratte.getTxtCittaArrivo().setText("");
		gestioneTratte.getDateDataPartenza().setDate(null);
		gestioneTratte.getDateDataArrivo().setDate(null);
		gestioneTratte.getTxtOrarioPartenza().setText("");
		gestioneTratte.getTxtOrarioArrivo().setText("");
	}

	public TrattaImplementazionePostgresDAO implementazioneTrattaDAO() {
		TrattaImplementazionePostgresDAO dao = new TrattaImplementazionePostgresDAO();
		return dao;
	}

	public void aggiungiTratta() {
		trt = new Tratta(gestioneTratte.getTxtCodiceTratta().getText(), gestioneTratte.getTxtCittaPartenza().getText(),
				gestioneTratte.getTxtCittaArrivo().getText(), gestioneTratte.getDateDataPartenza().getDate(),
				gestioneTratte.getDateDataArrivo().getDate(), gestioneTratte.getTxtOrarioPartenza().getText(),
				gestioneTratte.getTxtOrarioArrivo().getText());
		implementazioneTrattaDAO().aggiungiTratta(trt);
		gestioneTratte.getModello().addRow(gestioneTratte.getRow());
		svuotaCampiTratta();
		gestioneTratte.caricamento();
	}

	public void eliminaTratta() {
		trt = new Tratta(gestioneTratte.getTxtCodiceTratta().getText(), gestioneTratte.getTxtCittaPartenza().getText(),
				gestioneTratte.getTxtCittaArrivo().getText(), gestioneTratte.getDateDataPartenza().getDate(),
				gestioneTratte.getDateDataArrivo().getDate(), gestioneTratte.getTxtOrarioPartenza().getText(),
				gestioneTratte.getTxtOrarioArrivo().getText());

		int t = gestioneTratte.getTable().getSelectedRow();
		implementazioneTrattaDAO().cancellaTratta(trt);
		gestioneTratte.getModello().removeRow(t);
		svuotaCampiTratta();
		gestioneTratte.caricamento();
	}

	public void modificaTratta() {
		trt = new Tratta(gestioneTratte.getTxtCodiceTratta().getText(), gestioneTratte.getTxtCittaPartenza().getText(),
				gestioneTratte.getTxtCittaArrivo().getText(), gestioneTratte.getDateDataPartenza().getDate(),
				gestioneTratte.getDateDataArrivo().getDate(), gestioneTratte.getTxtOrarioPartenza().getText(),
				gestioneTratte.getTxtOrarioArrivo().getText());

		int t = gestioneTratte.getTable().getSelectedRow();

		gestioneTratte.getModello().setValueAt(gestioneTratte.getTxtCodiceTratta().getText(), t, 0);
		gestioneTratte.getModello().setValueAt(gestioneTratte.getTxtCittaPartenza().getText(), t, 1);
		gestioneTratte.getModello().setValueAt(gestioneTratte.getTxtCittaArrivo().getText(), t, 2);

		implementazioneTrattaDAO().modificaTratta(trt);
		svuotaCampiTratta();
		gestioneTratte.caricamento();
	}

	// METODI GESTIONE VOLI

	public void svuotaCampiVolo() {
		gestioneVoli.getTxtCodiceVolo().setText("");
		gestioneVoli.getTxtCittaPartenza().setText("");
		gestioneVoli.getTxtCittaArrivo().setText("");
		gestioneVoli.getDateDataPartenza().setDate(null);
		gestioneVoli.getDateDataArrivo().setDate(null);
		gestioneVoli.getTxtOrarioPartenza().setText("");
		gestioneVoli.getTxtOrarioArrivo().setText("");
		gestioneVoli.getTxtNumeroPrenotazioni().setText(null);
	}

	public VoloImplementazionePostgresDAO implementazioneVoloDAO() {
		VoloImplementazionePostgresDAO dao = new VoloImplementazionePostgresDAO();
		return dao;
	}

	public void aggiungiVolo() {
		vl = new Volo(gestioneVoli.getTxtCodiceVolo().getText(), gestioneVoli.getTxtCittaPartenza().getText(),
				gestioneVoli.getTxtCittaArrivo().getText(), gestioneVoli.getDateDataPartenza().getDate(),
				gestioneVoli.getDateDataArrivo().getDate(), gestioneVoli.getTxtOrarioPartenza().getText(),
				gestioneVoli.getTxtOrarioArrivo().getText(), gestioneVoli.getTxtNumeroPrenotazioni().getText());

		implementazioneVoloDAO().aggiungiVolo(vl);
		gestioneVoli.getModello().addRow(gestioneVoli.getRow());
		svuotaCampiVolo();
		gestioneVoli.caricamento();
	}

	public void eliminaVolo() {
		vl = new Volo(gestioneVoli.getTxtCodiceVolo().getText(), gestioneVoli.getTxtCittaPartenza().getText(),
				gestioneVoli.getTxtCittaArrivo().getText(), gestioneVoli.getDateDataPartenza().getDate(),
				gestioneVoli.getDateDataArrivo().getDate(), gestioneVoli.getTxtOrarioPartenza().getText(),
				gestioneVoli.getTxtOrarioArrivo().getText(), gestioneVoli.getTxtNumeroPrenotazioni().getText());

		int t = gestioneVoli.getTable().getSelectedRow();
		implementazioneVoloDAO().cancellaVolo(vl);
		gestioneVoli.getModello().removeRow(t);
		svuotaCampiVolo();
		gestioneVoli.caricamento();
	}

	public void modificaVolo() {
		vl = new Volo(gestioneVoli.getTxtCodiceVolo().getText(), gestioneVoli.getTxtCittaPartenza().getText(),
				gestioneVoli.getTxtCittaArrivo().getText(), gestioneVoli.getDateDataPartenza().getDate(),
				gestioneVoli.getDateDataArrivo().getDate(), gestioneVoli.getTxtOrarioPartenza().getText(),
				gestioneVoli.getTxtOrarioArrivo().getText(), gestioneVoli.getTxtNumeroPrenotazioni().getText());

		int t = gestioneVoli.getTable().getSelectedRow();

		gestioneVoli.getModello().setValueAt(gestioneVoli.getTxtCodiceVolo().getText(), t, 0);
		gestioneVoli.getModello().setValueAt(gestioneVoli.getTxtCittaPartenza().getText(), t, 1);
		gestioneVoli.getModello().setValueAt(gestioneVoli.getTxtCittaArrivo().getText(), t, 2);
		gestioneVoli.getModello().setValueAt(gestioneVoli.getDateDataPartenza().getDate(), t, 3);
		gestioneVoli.getModello().setValueAt(gestioneVoli.getDateDataArrivo().getDate(), t, 4);
		gestioneVoli.getModello().setValueAt(gestioneVoli.getTxtOrarioPartenza().getText(), t, 5);
		gestioneVoli.getModello().setValueAt(gestioneVoli.getTxtOrarioArrivo().getText(), t, 6);
		gestioneVoli.getModello().setValueAt(gestioneVoli.getTxtNumeroPrenotazioni().getText(), t, 7);

		implementazioneVoloDAO().modificaVolo(vl);
		svuotaCampiVolo();
		gestioneVoli.caricamento();
	}

	// METODI GESTIONE GATE

	public void svuotaCampiGate() {
		((GestioneGate1) getDashboard().getGestioneGate1()).getTxtCodiceGate().setText("");
		((GestioneGate1) getDashboard().getGestioneGate1()).getTxtNumeroPorta().setText("");
		((GestioneGate1) getDashboard().getGestioneGate1()).getTxtInizioImbarco().setText("");
		((GestioneGate1) getDashboard().getGestioneGate1()).getTxtFineImbarco().setText("");
	}

	public GateImplementazionePostgresDAO implementazioneGateDAO() {
		GateImplementazionePostgresDAO dao = new GateImplementazionePostgresDAO();
		return dao;
	}

	public void aggiungiGate() {
		gt = new Gate(((GestioneGate1) getDashboard().getGestioneGate1()).getTxtCodiceGate().getText(),
				((GestioneGate1) getDashboard().getGestioneGate1()).getTxtNumeroPorta().getText(),
				((GestioneGate1) getDashboard().getGestioneGate1()).getTxtInizioImbarco().getText(),
				((GestioneGate1) getDashboard().getGestioneGate1()).getTxtFineImbarco().getText());
		implementazioneGateDAO().aggiungiGate(gt);
		((GestioneGate1) getDashboard().getGestioneGate1()).getModello()
				.addRow(((GestioneGate1) getDashboard().getGestioneGate1()).getRow());
		svuotaCampiGate();
		((GestioneGate1) getDashboard().getGestioneGate1()).caricamento();
	}

	public void eliminaGate() {
		gt = new Gate(((GestioneGate1) getDashboard().getGestioneGate1()).getTxtCodiceGate().getText(),
				((GestioneGate1) getDashboard().getGestioneGate1()).getTxtNumeroPorta().getText(),
				((GestioneGate1) getDashboard().getGestioneGate1()).getTxtInizioImbarco().getText(),
				((GestioneGate1) getDashboard().getGestioneGate1()).getTxtFineImbarco().getText());

		int t = ((GestioneGate1) getDashboard().getGestioneGate1()).getTable().getSelectedRow();
		implementazioneGateDAO().cancellaGate(gt);
		((GestioneGate1) getDashboard().getGestioneGate1()).getModello().removeRow(t);
		svuotaCampiGate();
		((GestioneGate1) getDashboard().getGestioneGate1()).caricamento();
	}

	public void modificaGate() {
		gt = new Gate(((GestioneGate1) getDashboard().getGestioneGate1()).getTxtCodiceGate().getText(),
				((GestioneGate1) getDashboard().getGestioneGate1()).getTxtNumeroPorta().getText(),
				((GestioneGate1) getDashboard().getGestioneGate1()).getTxtInizioImbarco().getText(),
				((GestioneGate1) getDashboard().getGestioneGate1()).getTxtFineImbarco().getText());

		int t = ((GestioneGate1) getDashboard().getGestioneGate1()).getTable().getSelectedRow();

		((GestioneGate1) getDashboard().getGestioneGate1()).getModello()
				.setValueAt(((GestioneGate1) getDashboard().getGestioneGate1()).getTxtCodiceGate().getText(), t, 0);
		((GestioneGate1) getDashboard().getGestioneGate1()).getModello()
				.setValueAt(((GestioneGate1) getDashboard().getGestioneGate1()).getTxtNumeroPorta().getText(), t, 1);
		((GestioneGate1) getDashboard().getGestioneGate1()).getModello()
				.setValueAt(((GestioneGate1) getDashboard().getGestioneGate1()).getTxtInizioImbarco().getText(), t, 2);
		((GestioneGate1) getDashboard().getGestioneGate1()).getModello()
				.setValueAt(((GestioneGate1) getDashboard().getGestioneGate1()).getTxtFineImbarco().getText(), t, 3);

		implementazioneGateDAO().modificaGate(gt);
		svuotaCampiGate();
		((GestioneGate1) getDashboard().getGestioneGate1()).caricamento();
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

	public JPanel gestioneGate() {
		GestioneGate1 gestioneGate1 = new GestioneGate1(this);
		return gestioneGate1;
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
		dashboard.getGestioneGate1().setVisible(false);
		pane.setVisible(true);

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
