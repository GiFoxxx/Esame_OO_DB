package Controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;
import Amministrazione.*;
import Classi.*;
import GUI.*;
import Immagini.Immagini;
import ImplementazioniPostrgresDAO.*;

public class Controller {

	Immagini img = new Immagini();

	public Color sfondo = new Color(54, 57, 63);
	public Color coloreScritte = new Color(141, 142, 146);
	public Color coloreScritteSuBianco = new Color(35, 39, 42);
	public Color escoPannello = new Color(35, 39, 42);
	public Color entroPannello = new Color(40, 45, 48);
	public Color clickPannello = new Color(50, 55, 58);
	public Color pannelloScelto = new Color(60, 65, 68);
	public Color coloreScritturaAllerta = new Color(250, 45, 45);
	public Color trasparente = new Color(0, 0, 0, 0);
	public Font fontScritte = new Font("Arial", Font.PLAIN, 19);
	public Font fontTitolo = new Font("Arial", Font.BOLD, 18);
	public Font fontScritteJDialog = new Font("Arial", Font.BOLD, 20);
	public Color coloreLabel = new Color(111, 115, 122);
	public Color coloreLabelEntrata = new Color(205, 205, 205);
	public Color coloreLabelPressed = new Color(240, 240, 240);
	public Font fontScritteLabel = new Font("Arial", Font.BOLD, 12);

	private String emailAccesso;

	private Dashboard dashboard;
	private Home home;
	private Accesso accesso;
	private CambioPassword cambioPassword;
	private Registrazione registrazione;
	private Riconoscimenti riconoscimenti;
	private Profilo profilo;
	private GestioneVoliPartenze gestioneVoliPartenze;
	private GestioneVoliArrivi gestioneVoliArrivi;
	private Prenotazione prenotazioni;
	private GestioneUtenti gestioneUtenti;
	private GestioneCompagnieAeree gestioneCompagnieAeree;
	private GestioneTratte gestioneTratte;
	private GestioneGate gestioneGate;
	private SceltaProfiloSenzaAccesso sceltaProfiloSenzaAccesso;
	private SceltaVolo sceltaVolo;
	private Recensione recensioni;
	private Uscita uscita;
	private PasswordDimenticata passwordDimenticata;
	
	Utente utn;
	VoloPartenze vlprtz;
	VoloArrivi vlarr;
	Gate gt;
	Tratta trt;
	CompagniaAerea compAerea;

	// GETTER E SETTER
	public String getEmailAccesso() {
		return emailAccesso;
	}

	public void setEmailAccesso(String emailAccesso) {
		this.emailAccesso = emailAccesso;
	}

	public Dashboard getDashboard() {
		return dashboard;
	}

	public void setDashboard(Dashboard dashboard) {
		this.dashboard = dashboard;
	}

	public CambioPassword getCambioPassword() {
		return cambioPassword;
	}

	public void setCambioPassword(CambioPassword cambioPassword) {
		this.cambioPassword = cambioPassword;
	}

	public Home getHome() {
		return home;
	}

	public void setHome(Home home) {
		this.home = home;
	}

	public SceltaProfiloSenzaAccesso getSceltaProfiloSenzaAccesso() {
		return sceltaProfiloSenzaAccesso;
	}

	public void setSceltaProfiloSenzaAccesso(SceltaProfiloSenzaAccesso sceltaProfiloSenzaAccesso) {
		this.sceltaProfiloSenzaAccesso = sceltaProfiloSenzaAccesso;
	}

	public SceltaVolo getSceltaVolo() {
		return sceltaVolo;
	}

	public void setSceltaVolo(SceltaVolo sceltaVolo) {
		this.sceltaVolo = sceltaVolo;
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

	public Profilo getProfilo() {
		return profilo;
	}

	public void setProfilo(Profilo profilo) {
		this.profilo = profilo;
	}

	public Riconoscimenti getRiconoscimenti() {
		return riconoscimenti;
	}

	public void setRiconoscimenti(Riconoscimenti riconoscimenti) {
		this.riconoscimenti = riconoscimenti;
	}

	public GestioneVoliPartenze getGestioneVoliPartenze() {
		return gestioneVoliPartenze;
	}

	public void setGestioneVoliPartenze(GestioneVoliPartenze gestioneVoliPartenze) {
		this.gestioneVoliPartenze = gestioneVoliPartenze;
	}

	public GestioneVoliArrivi getGestioneVoliArrivi() {
		return gestioneVoliArrivi;
	}

	public void setGestioneVoliArrivi(GestioneVoliArrivi gestioneVoliArrivi) {
		this.gestioneVoliArrivi = gestioneVoliArrivi;
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

	public Recensione getRecensioni() {
		return recensioni;
	}

	public void setRecensioni(Recensione recensioni) {
		this.recensioni = recensioni;
	}

	public Uscita getUscita() {
		return uscita;
	}

	public void setUscita(Uscita uscita) {
		this.uscita = uscita;
	}

	public PasswordDimenticata getPasswordDimenticata() {
		return passwordDimenticata;
	}

	public void setPasswordDimenticata(PasswordDimenticata passwordDimenticata) {
		this.passwordDimenticata = passwordDimenticata;
	}

	public Recensione getRecensione() {
		return recensioni;
	}

	public void setRecensione(Recensione recensione) {
		this.recensioni = recensione;
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
		riconoscimenti = new Riconoscimenti(this);
		prenotazioni = new Prenotazione(this);
		gestioneUtenti = new GestioneUtenti(this);
		gestioneCompagnieAeree = new GestioneCompagnieAeree(this);
		gestioneTratte = new GestioneTratte(this);
		gestioneGate = new GestioneGate(this);
		gestioneVoliPartenze = new GestioneVoliPartenze(this);
		gestioneVoliArrivi = new GestioneVoliArrivi(this);
		cambioPassword = new CambioPassword(this);
		sceltaProfiloSenzaAccesso = new SceltaProfiloSenzaAccesso(this);
		passwordDimenticata = new PasswordDimenticata(this);
		sceltaVolo = new SceltaVolo(this);
		recensioni = new Recensione(this);
		dashboard.setVisible(true);
	}

	// METODI DI ACCESSO
	public void svuotaCampiAccesso() {
		((Accesso) getDashboard().getAccesso()).getTxtEmail().setText("");
		((Accesso) getDashboard().getAccesso()).getTxtPassword().setText("");

	}

	@SuppressWarnings("deprecation")
	public void accedi() {
		String email = ((Accesso) getDashboard().getAccesso()).getTxtEmail().getText();
		emailAccesso = ((Accesso) getDashboard().getAccesso()).getTxtEmail().getText();
		String password = ((Accesso) getDashboard().getAccesso()).getTxtPassword().getText();

		if (implementazioneUtenteDAO().accessoUtente(email, password)) {
			mostraPannelli(getDashboard().getHome());
			((Accesso) getDashboard().getAccesso()).setSbloccaHome(true);
		} else if (controlloCampiSeVuotiAccesso()) {
			((Accesso) getDashboard().getAccesso()).mostraInserimentoCredenziali();
		} else {
			((Accesso) getDashboard().getAccesso()).mostraErroreAccesso();
		}
	}

	@SuppressWarnings("deprecation")
	public boolean controlloCampiSeVuotiAccesso() {
		if (((Accesso) getDashboard().getAccesso()).getTxtEmail().getText().length() <= 0
				|| ((Accesso) getDashboard().getAccesso()).getTxtPassword().getText().length() <= 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public void accessoPasswordDimenticata() {
		Utente utn = new Utente(((PasswordDimenticata) getDashboard().getPasswordDimenticata()).getTxtEmail().getText(),
				((PasswordDimenticata) getDashboard().getPasswordDimenticata()).getTxtNuovaPassword().getText());
		implementazioneUtenteDAO().modificaPassword(utn);
		mostraPannelli(getDashboard().getAccesso());
		getDashboard().getPasswordDimenticata().dispose();
		getDashboard().setEnabled(true);
		getDashboard().setVisible(true);
		((GestioneVoliPartenze) getDashboard().getGestioneUtenti()).caricaTabella();
	}

	// METODI DI REGISTRAZIONE
	public void svuotaCampiRegistrazione() {
		((Registrazione) getDashboard().getRegistrazione()).getTxtNome().setText("");
		((Registrazione) getDashboard().getRegistrazione()).getTxtCognome().setText("");
		((Registrazione) getDashboard().getRegistrazione()).getTxtEmail().setText("");
		((Registrazione) getDashboard().getRegistrazione()).getTxtPassword().setText("");
		((Registrazione) getDashboard().getRegistrazione()).getTxtRipetiPassword().setText("");
	}

	public boolean formatoEmailInseritaErrato() {
		boolean emailCorretta = controlloInserimentoEmailCorrettamenteRegistrazione(
				((Registrazione) getDashboard().getRegistrazione()).getTxtEmail().getText());

		if (emailCorretta) {
			return true;
		} else {
			return false;
		}
	}

	@SuppressWarnings("deprecation")
	public boolean ripetiPassword() {
		if (((Registrazione) getDashboard().getRegistrazione()).getTxtRipetiPassword().getText()
				.equals(((Registrazione) getDashboard().getRegistrazione()).getTxtPassword().getText())) {
			return true;
		} else {
			return false;
		}
	}

	@SuppressWarnings("deprecation")
	public void registrati() {
		((Registrazione) getDashboard().getRegistrazione()).getLblMessaggioCredenziali().setText("");
		if (formatoEmailInseritaErrato() && ripetiPassword() && nessunCampoVuoto()) {
			Utente utn = new Utente(((Registrazione) getDashboard().getRegistrazione()).getTxtNome().getText(),
					((Registrazione) getDashboard().getRegistrazione()).getTxtCognome().getText(),
					((Registrazione) getDashboard().getRegistrazione()).getTxtEmail().getText(),
					((Registrazione) getDashboard().getRegistrazione()).getTxtPassword().getText());
			implementazioneUtenteDAO().registrazioneUtente(utn);
			mostraPannelli(getDashboard().getAccesso());

		} else if ((!formatoEmailInseritaErrato() || ripetiPassword()) && nessunCampoVuoto()) {

			JOptionPane.showMessageDialog(null,
					"Formato email inserito non valido!\n" + "Inserire l'email dal formato tipo: example@example.com");

		} else if (formatoEmailInseritaErrato() && !ripetiPassword() && nessunCampoVuoto()) {

			((Registrazione) getDashboard().getRegistrazione()).getLblMessaggioCredenziali()
					.setText("La password ripetuta non � corretta.");
			((Registrazione) getDashboard().getRegistrazione()).getTxtPassword().setText("");
			((Registrazione) getDashboard().getRegistrazione()).getTxtRipetiPassword().setText("");

		} else {
			((Registrazione) getDashboard().getRegistrazione()).getLblMessaggioCredenziali()
					.setText("Ci sono campi vuoti, riempirli tutti per la registrazione.");
		}
	}

	@SuppressWarnings("deprecation")
	public boolean nessunCampoVuoto() {
		if (((Registrazione) getDashboard().getRegistrazione()).getTxtNome().getText().length() <= 0
				|| ((Registrazione) getDashboard().getRegistrazione()).getTxtCognome().getText().length() <= 0
				|| ((Registrazione) getDashboard().getRegistrazione()).getTxtEmail().getText().length() <= 0
				|| ((Registrazione) getDashboard().getRegistrazione()).getTxtPassword().getText().length() <= 0
				|| ((Registrazione) getDashboard().getRegistrazione()).getTxtRipetiPassword().getText().length() <= 0) {

			return false;
		} else {
			return true;
		}
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
		utn = new Utente(((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtNome().getText(),
				((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtCognome().getText(),
				((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtEmail().getText(),
				((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtPassword().getText());
		implementazioneUtenteDAO().registrazioneUtente(utn);
		((GestioneUtenti) getDashboard().getGestioneUtenti()).getModello()
				.addRow(((GestioneUtenti) getDashboard().getGestioneUtenti()).getRow());
		svuotaCampiGestioneUtenti();
		((GestioneUtenti) getDashboard().getGestioneUtenti()).caricaTabella();
	}

	public void eliminaUtente() {
		utn = new Utente(((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtNome().getText(),
				((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtCognome().getText(),
				((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtEmail().getText(),
				((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtPassword().getText());
		int t = ((GestioneUtenti) getDashboard().getGestioneUtenti()).getTabella().getSelectedRow();
		implementazioneUtenteDAO().cancellaUtente(utn);
		((GestioneUtenti) getDashboard().getGestioneUtenti()).getModello().removeRow(t);
		svuotaCampiGestioneUtenti();
		((GestioneUtenti) getDashboard().getGestioneUtenti()).caricaTabella();
	}

	public void modificaUtente() {
		utn = new Utente(((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtNome().getText(),
				((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtCognome().getText(),
				((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtEmail().getText(),
				((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtPassword().getText());
		int t = ((GestioneUtenti) getDashboard().getGestioneUtenti()).getTabella().getSelectedRow();

		((GestioneUtenti) getDashboard().getGestioneUtenti()).getModello()
				.setValueAt(((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtNome().getText(), t, 0);
		((GestioneUtenti) getDashboard().getGestioneUtenti()).getModello()
				.setValueAt(((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtCognome().getText(), t, 1);
		((GestioneUtenti) getDashboard().getGestioneUtenti()).getModello()
				.setValueAt(((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtEmail().getText(), t, 2);
		((GestioneUtenti) getDashboard().getGestioneUtenti()).getModello()
				.setValueAt(((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtPassword().getText(), t, 3);

		implementazioneUtenteDAO().modificaUtente(utn);
		svuotaCampiGestioneUtenti();
		((GestioneUtenti) getDashboard().getGestioneUtenti()).caricaTabella();
	}

	// METODI GESTIONE COMPAGNIA AEREA

	public void svuotaCampiCompagniaAerea() {
		((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).getTxtCodiceCompagniaAerea().setText("");
		((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).getTxtNome().setText("");
	}

	public CompagniaAereaImplementazionePostgresDAO implementazioneCompagniaAereaDAO() {
		CompagniaAereaImplementazionePostgresDAO dao = new CompagniaAereaImplementazionePostgresDAO();
		return dao;
	}

	public void aggiungiCompagniaAerea() {
		compAerea = new CompagniaAerea(
				((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).getTxtCodiceCompagniaAerea()
						.getText(),
				((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).getTxtNome().getText());
		implementazioneCompagniaAereaDAO().aggiungiCompagniaAerea(compAerea);
		((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).getModello()
				.addRow(((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).getRow());
		svuotaCampiCompagniaAerea();
		((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).caricaTabella();
	}

	public void eliminaCompagniaAerea() {
		compAerea = new CompagniaAerea(
				((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).getTxtCodiceCompagniaAerea()
						.getText(),
				((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).getTxtNome().getText());
		int t = ((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).getTabella().getSelectedRow();
		implementazioneCompagniaAereaDAO().cancellaCompagniaAerea(compAerea);
		((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).getModello().removeRow(t);
		svuotaCampiCompagniaAerea();
		((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).caricaTabella();
	}

	public void modificaCompagniaAerea() {
		compAerea = new CompagniaAerea(
				((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).getTxtCodiceCompagniaAerea()
						.getText(),
				((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).getTxtNome().getText());
		int t = ((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).getTabella().getSelectedRow();

		((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).getModello()
				.setValueAt(((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree())
						.getTxtCodiceCompagniaAerea().getText(), t, 0);
		((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).getModello().setValueAt(
				((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).getTxtNome().getText(), t, 1);

		implementazioneCompagniaAereaDAO().modificaCompagniaAerea(compAerea);
		svuotaCampiCompagniaAerea();
		((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).caricaTabella();
	}

	// METODI GESTIONE TRATTE

	public void svuotaCampiTratta() {
		((GestioneTratte) getDashboard().getGestioneTratte()).getTxtCodiceTratta().setText("");
		((GestioneTratte) getDashboard().getGestioneTratte()).getTxtCittaPartenza().setText("");
		((GestioneTratte) getDashboard().getGestioneTratte()).getTxtCittaArrivo().setText("");
		((GestioneTratte) getDashboard().getGestioneTratte()).getDateDataPartenza().setDate(null);
		((GestioneTratte) getDashboard().getGestioneTratte()).getDateDataArrivo().setDate(null);
		((GestioneTratte) getDashboard().getGestioneTratte()).getTxtOraPartenza().setText("");
		((GestioneTratte) getDashboard().getGestioneTratte()).getTxtOraArrivo().setText("");
	}

	public TrattaImplementazionePostgresDAO implementazioneTrattaDAO() {
		TrattaImplementazionePostgresDAO dao = new TrattaImplementazionePostgresDAO();
		return dao;
	}

	public void aggiungiTratta() {
		trt = new Tratta(((GestioneTratte) getDashboard().getGestioneTratte()).getTxtCodiceTratta().getText(),
				((GestioneTratte) getDashboard().getGestioneTratte()).getTxtCittaPartenza().getText(),
				((GestioneTratte) getDashboard().getGestioneTratte()).getTxtCittaArrivo().getText(),
				((GestioneTratte) getDashboard().getGestioneTratte()).getDateDataPartenza().getDate(),
				((GestioneTratte) getDashboard().getGestioneTratte()).getDateDataArrivo().getDate(),
				((GestioneTratte) getDashboard().getGestioneTratte()).getTxtOraPartenza().getText(),
				((GestioneTratte) getDashboard().getGestioneTratte()).getTxtOraArrivo().getText());
		implementazioneTrattaDAO().aggiungiTratta(trt);
		((GestioneTratte) getDashboard().getGestioneTratte()).getModello()
				.addRow(((GestioneTratte) getDashboard().getGestioneTratte()).getRow());
		svuotaCampiTratta();
		((GestioneTratte) getDashboard().getGestioneTratte()).caricaTabella();
	}

	public void eliminaTratta() {
		trt = new Tratta(((GestioneTratte) getDashboard().getGestioneTratte()).getTxtCodiceTratta().getText(),
				((GestioneTratte) getDashboard().getGestioneTratte()).getTxtCittaPartenza().getText(),
				((GestioneTratte) getDashboard().getGestioneTratte()).getTxtCittaArrivo().getText(),
				((GestioneTratte) getDashboard().getGestioneTratte()).getDateDataPartenza().getDate(),
				((GestioneTratte) getDashboard().getGestioneTratte()).getDateDataArrivo().getDate(),
				((GestioneTratte) getDashboard().getGestioneTratte()).getTxtOraPartenza().getText(),
				((GestioneTratte) getDashboard().getGestioneTratte()).getTxtOraArrivo().getText());

		int t = ((GestioneTratte) getDashboard().getGestioneTratte()).getTabella().getSelectedRow();
		implementazioneTrattaDAO().cancellaTratta(trt);
		((GestioneTratte) getDashboard().getGestioneTratte()).getModello().removeRow(t);
		svuotaCampiTratta();
		((GestioneTratte) getDashboard().getGestioneTratte()).caricaTabella();
	}

	public void modificaTratta() {
		trt = new Tratta(((GestioneTratte) getDashboard().getGestioneTratte()).getTxtCodiceTratta().getText(),
				((GestioneTratte) getDashboard().getGestioneTratte()).getTxtCittaPartenza().getText(),
				((GestioneTratte) getDashboard().getGestioneTratte()).getTxtCittaArrivo().getText(),
				((GestioneTratte) getDashboard().getGestioneTratte()).getDateDataPartenza().getDate(),
				((GestioneTratte) getDashboard().getGestioneTratte()).getDateDataArrivo().getDate(),
				((GestioneTratte) getDashboard().getGestioneTratte()).getTxtOraPartenza().getText(),
				((GestioneTratte) getDashboard().getGestioneTratte()).getTxtOraArrivo().getText());

		int t = ((GestioneTratte) getDashboard().getGestioneTratte()).getTabella().getSelectedRow();

		((GestioneTratte) getDashboard().getGestioneTratte()).getModello()
				.setValueAt(((GestioneTratte) getDashboard().getGestioneTratte()).getTxtCodiceTratta().getText(), t, 0);
		((GestioneTratte) getDashboard().getGestioneTratte()).getModello().setValueAt(
				((GestioneTratte) getDashboard().getGestioneTratte()).getTxtCittaPartenza().getText(), t, 1);
		((GestioneTratte) getDashboard().getGestioneTratte()).getModello()
				.setValueAt(((GestioneTratte) getDashboard().getGestioneTratte()).getTxtCittaArrivo().getText(), t, 2);

		implementazioneTrattaDAO().modificaTratta(trt);
		svuotaCampiTratta();
		((GestioneTratte) getDashboard().getGestioneTratte()).caricaTabella();
	}

	// METODI GESTIONE VOLI PARTENZE

	public void svuotaCampiVoloPartenze() {
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtCodiceVoloPartenze().setText("");
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtCittaArrivo().setText("");
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getDateDataPartenza().setDate(null);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtOraPartenza().setText("");
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtMinutoPartenza().setText("");
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtNumeroPrenotazioni().setText(null);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtRitardo().setText("");
	}

	public VoloPartenzeImplementazionePostgresDAO implementazioneVoloPartenzeDAO() {
		VoloPartenzeImplementazionePostgresDAO dao = new VoloPartenzeImplementazionePostgresDAO();
		return dao;
	}

	public void aggiungiVoloPartenze() {
		vlprtz = new VoloPartenze(
				((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtCodiceVoloPartenze().getText(),
				((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtCittaArrivo().getText(),
				((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getDateDataPartenza().getDate(),
				((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtOraPartenza().getText(),
				((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtMinutoPartenza().getText(),
				((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtNumeroPrenotazioni().getText(),
				((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtRitardo().getText());

		implementazioneVoloPartenzeDAO().aggiungiVoloPartenze(vlprtz);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getModello()
				.addRow(((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getRow());
		svuotaCampiVoloPartenze();
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).caricaTabella();
	}

	public void eliminaVoloPartenze() {
		vlprtz = new VoloPartenze(
				((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtCodiceVoloPartenze().getText(),
				((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtCittaArrivo().getText(),
				((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getDateDataPartenza().getDate(),
				((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtOraPartenza().getText(),
				((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtMinutoPartenza().getText(),
				((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtNumeroPrenotazioni().getText(),
				((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtRitardo().getText());

		int t = ((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTabella().getSelectedRow();
		implementazioneVoloPartenzeDAO().cancellaVoloPartenze(vlprtz);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getModello().removeRow(t);
		svuotaCampiVoloPartenze();
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).caricaTabella();
	}

	public void modificaVoloPartenze() {
		vlprtz = new VoloPartenze(
				((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtCodiceVoloPartenze().getText(),
				((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtCittaArrivo().getText(),
				((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getDateDataPartenza().getDate(),
				((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtOraPartenza().getText(),
				((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtMinutoPartenza().getText(),
				((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtNumeroPrenotazioni().getText(),
				((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtRitardo().getText());

		int t = ((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTabella().getSelectedRow();

		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getModello().setValueAt(
				((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtCodiceVoloPartenze().getText(),
				t, 0);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getModello().setValueAt(
				((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtCittaArrivo().getText(), t, 1);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getModello().setValueAt(
				((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getDateDataPartenza().getDate(), t,
				2);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getModello().setValueAt(
				((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtOraPartenza().getText(), t, 3);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getModello().setValueAt(
				((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtNumeroPrenotazioni().getText(),
				t, 4);

		implementazioneVoloPartenzeDAO().modificaVoloPartenze(vlprtz);
		svuotaCampiVoloPartenze();
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).caricaTabella();
	}

	// METODI GESTIONE VOLI ARRIVI

	public void svuotaCampiVoloArrivi() {
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTxtCodiceVoloArrivi().setText("");
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTxtCittaPartenza().setText("");
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getDateDataArrivo().setDate(null);
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTxtOraArrivo().setText("");
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTxtMinutoArrivo().setText("");
	}

	public VoloArriviImplementazionePostgresDAO implementazioneVoloArriviDAO() {
		VoloArriviImplementazionePostgresDAO dao = new VoloArriviImplementazionePostgresDAO();
		return dao;
	}

	public void aggiungiVoloArrivi() {
		vlarr = new VoloArrivi(
				((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTxtCodiceVoloArrivi().getText(),
				((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTxtCittaPartenza().getText(),
				((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getDateDataArrivo().getDate(),
				((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTxtOraArrivo().getText(),
				((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTxtMinutoArrivo().getText());

		implementazioneVoloArriviDAO().aggiungiVoloArrivi(vlarr);
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getModello()
				.addRow(((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getRow());
		svuotaCampiVoloArrivi();
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).caricaTabella();
	}

	public void eliminaVoloArrivi() {
		vlarr = new VoloArrivi(
				((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTxtCodiceVoloArrivi().getText(),
				((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTxtCittaPartenza().getText(),
				((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getDateDataArrivo().getDate(),
				((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTxtOraArrivo().getText(),
				((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTxtMinutoArrivo().getText());

		int t = ((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTabella().getSelectedRow();
		implementazioneVoloArriviDAO().cancellaVoloArrivi(vlarr);
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getModello().removeRow(t);
		svuotaCampiVoloArrivi();
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).caricaTabella();
	}

	public void modificaVoloArrivi() {
		vlarr = new VoloArrivi(
				((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTxtCodiceVoloArrivi().getText(),
				((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTxtCittaPartenza().getText(),
				((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getDateDataArrivo().getDate(),
				((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTxtOraArrivo().getText(),
				((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTxtMinutoArrivo().getText());

		int t = ((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTabella().getSelectedRow();

		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getModello().setValueAt(
				((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTxtCodiceVoloArrivi().getText(), t, 0);
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getModello().setValueAt(
				((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTxtCittaPartenza().getText(), t, 1);
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getModello().setValueAt(
				((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getDateDataArrivo().getDate(), t, 2);
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getModello().setValueAt(
				((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTxtOraArrivo().getText(), t, 3);
		implementazioneVoloArriviDAO().modificaVoloArrivi(vlarr);
		svuotaCampiVoloArrivi();
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).caricaTabella();
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
		((GestioneGate) getDashboard().getGestioneGate()).caricaTabella();
	}

	public void eliminaGate() {
		gt = new Gate(((GestioneGate) getDashboard().getGestioneGate()).getTxtCodiceGate().getText(),
				((GestioneGate) getDashboard().getGestioneGate()).getTxtNumeroPorta().getText(),
				((GestioneGate) getDashboard().getGestioneGate()).getTxtInizioImbarco().getText(),
				((GestioneGate) getDashboard().getGestioneGate()).getTxtFineImbarco().getText());

		int t = ((GestioneGate) getDashboard().getGestioneGate()).getTabella().getSelectedRow();
		implementazioneGateDAO().cancellaGate(gt);
		((GestioneGate) getDashboard().getGestioneGate()).getModello().removeRow(t);
		svuotaCampiGate();
		((GestioneGate) getDashboard().getGestioneGate()).caricaTabella();
	}

	public void modificaGate() {
		gt = new Gate(((GestioneGate) getDashboard().getGestioneGate()).getTxtCodiceGate().getText(),
				((GestioneGate) getDashboard().getGestioneGate()).getTxtNumeroPorta().getText(),
				((GestioneGate) getDashboard().getGestioneGate()).getTxtInizioImbarco().getText(),
				((GestioneGate) getDashboard().getGestioneGate()).getTxtFineImbarco().getText());

		int t = ((GestioneGate) getDashboard().getGestioneGate()).getTabella().getSelectedRow();

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
		((GestioneGate) getDashboard().getGestioneGate()).caricaTabella();
	}

	// METODI DASHBOARD

	@SuppressWarnings("deprecation")
	public void apriTendina() {
		getDashboard().getLineeApertura().setVisible(false);
		if (getDashboard().getPosizioneTendina() == 50) {
			getDashboard().getPannelloTendina().show();
			getDashboard().getPannelloTendina().setSize(getDashboard().getPosizioneTendina(), 642);
			Thread th = new Thread() {
				@Override
				public void run() {
					try {
						for (int i = 50; i <= getDashboard().getPosizioneTendina(); i++) {
							Thread.sleep(1, 01);
							getDashboard().getPannelloTendina().setSize(i, 642);
						}
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, e);
					}
					getDashboard().getLineeChiusura().setVisible(true);
				}
			};
			th.start();
			getDashboard().setPosizioneTendina(238);
		}
	}

	public void chiudiTendina() {
		getDashboard().getLineeChiusura().setVisible(false);
		if (getDashboard().getPosizioneTendina() == 238) {
			getDashboard().getPannelloTendina().setSize(50, 642);
			Thread th = new Thread() {
				@Override
				public void run() {
					try {
						for (int i = 238; i >= 50; i--) {
							Thread.sleep(1, 01);
							getDashboard().getPannelloTendina().setSize(i, 642);
						}
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, e);
					}
					getDashboard().getLineeApertura().setVisible(true);
				}
			};
			th.start();
			getDashboard().setPosizioneTendina(50);
		}

	}

	public void chiudiTendinaIstantanea() {
		getDashboard().getLineeChiusura().setVisible(false);
		if (getDashboard().getPosizioneTendina() == 238) {
			getDashboard().getPannelloTendina().setSize(50, 642);
			Thread th = new Thread() {
				@Override
				public void run() {
					try {
						for (int i = 238; i >= 50; i--) {
							Thread.sleep(0, 0);
							getDashboard().getPannelloTendina().setSize(i, 642);
						}
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, e);
					}
					getDashboard().getLineeApertura().setVisible(true);
				}
			};
			th.start();
			getDashboard().setPosizioneTendina(50);
		}
	}

	public JPanel home() {
		Home home = new Home(this);
		return home;
	}

	public JPanel accesso() {
		Accesso accesso = new Accesso(this);
		return accesso;
	}

	public JPanel cambioPassword() {
		CambioPassword cambioPassword = new CambioPassword(this);
		return cambioPassword;

	}

	public JPanel registrazione() {
		Registrazione registrazione = new Registrazione(this);
		return registrazione;
	}

	public JPanel profilo() {
		Profilo profilo = new Profilo(this);
		return profilo;
	}

	public JPanel impostazioni() {
		Impostazioni impostazioni = new Impostazioni(this);
		return impostazioni;
	}

	public JPanel gestioneUtenti() {
		GestioneUtenti gestioneUtenti = new GestioneUtenti(this);
		return gestioneUtenti;
	}

	public JPanel gestioneCompagnieAeree() {
		GestioneCompagnieAeree gestioneCompagnieAeree = new GestioneCompagnieAeree(this);
		return gestioneCompagnieAeree;
	}

	public JPanel gestioneGate() {
		GestioneGate gestioneGate = new GestioneGate(this);
		return gestioneGate;
	}

	public JPanel gestioneTratte() {
		GestioneTratte gestioneTratte = new GestioneTratte(this);
		return gestioneTratte;
	}

	public JPanel gestioneVoliPartenze() {
		GestioneVoliPartenze gestioneVoliParternze = new GestioneVoliPartenze(this);
		return gestioneVoliParternze;
	}

	public JPanel gestioneVoliArrivi() {
		GestioneVoliArrivi gestioneVoliArrivi = new GestioneVoliArrivi(this);
		return gestioneVoliArrivi;
	}

	public JDialog sceltaVolo() {
		SceltaVolo sceltaVolo = new SceltaVolo(this);
		return sceltaVolo;
	}

	public JDialog sceltaProfiloSenzaAccesso() {
		SceltaProfiloSenzaAccesso sceltaProfiloSenzaAccesso = new SceltaProfiloSenzaAccesso(this);
		return sceltaProfiloSenzaAccesso;
	}
	
	public JDialog passwordDimenticata() {
		PasswordDimenticata passwordDimenticata = new PasswordDimenticata(this);
		return passwordDimenticata;
	}

	public JPanel recensione() {
		Recensione recensioni = new Recensione(this);
		return recensioni;
	}

	public JDialog uscita() {
		Uscita uscita = new Uscita(this);
		return uscita;
	}

	public void mostraNoClick() {

		if (getDashboard().getHome().isVisible()) {
			getDashboard().getHome().setVisible(true);
		} else if (getDashboard().getAccesso().isVisible()) {
			getDashboard().getAccesso().setVisible(true);
		} else if (getDashboard().getRegistrazione().isVisible()) {
			getDashboard().getRegistrazione().setVisible(true);
		} else if (getDashboard().getProfilo().isVisible()) {
			getDashboard().getProfilo().setVisible(true);
		} else if (getDashboard().getImpostazioni().isVisible()) {
			getDashboard().getImpostazioni().setVisible(true);
		}
		getDashboard().getNoClickDestra().setVisible(true);
	}

	public void mostraPannelloNoClick() {
		getDashboard().getNoClickDestra().setVisible(true);
	}

	public void mostraPannelli(JPanel pane) {
		((Home) getDashboard().getHome()).getLblFareAccesso().setText("");
		((Accesso) getDashboard().getAccesso()).getLblMessaggioCredenziali().setText("");
		((Registrazione) getDashboard().getRegistrazione()).getLblMessaggioCredenziali().setText("");
		getDashboard().getNoClickDestra().setVisible(false);
		getDashboard().getHome().setVisible(false);
		getDashboard().getAccesso().setVisible(false);
		svuotaCampiAccesso();
		getDashboard().getRegistrazione().setVisible(false);
		svuotaCampiRegistrazione();
		getDashboard().getProfilo().setVisible(false);
		getDashboard().getImpostazioni().setVisible(false);
		getDashboard().getGestioneCompagnieAeree().setVisible(false);
		getDashboard().getGestioneUtenti().setVisible(false);
		getDashboard().getGestioneGate().setVisible(false);
		getDashboard().getGestioneTratte().setVisible(false);
		getDashboard().getGestioneVoliPartenze().setVisible(false);
		getDashboard().getGestioneVoliArrivi().setVisible(false);
		getDashboard().getCambioPassword().setVisible(false);
		getDashboard().getRecensione().setVisible(false);
		pane.setVisible(true);
	}

	// METODI DI SCELTA PROFILO SENZA ACCESSO
	public void mostraSceltaProfiloSenzaAccesso() {
		getDashboard().setEnabled(false);
		getDashboard().getSceltaProfiloSenzaAccesso().setVisible(true);
	}

	public void vaiAdAccediDaSceltaProfiloSenzaAccesso() {
		getDashboard().getSceltaProfiloSenzaAccesso().dispose();
		getDashboard().setEnabled(true);
		getDashboard().setVisible(true);
		mostraPannelli(getDashboard().getAccesso());
	}

	public void vaiARegistrazioneDaSceltaProfiloSenzaAccesso() {
		getDashboard().getSceltaProfiloSenzaAccesso().dispose();
		getDashboard().setEnabled(true);
		getDashboard().setVisible(true);
		mostraPannelli(getDashboard().getRegistrazione());
	}

	public void annullaSceltaProfiloSenzaAccesso() {
		getDashboard().getSceltaProfiloSenzaAccesso().dispose();
		getDashboard().setEnabled(true);
		getDashboard().setVisible(true);
	}

	// METODI SCELTA VOLI

	public void mostraSceltaVolo() {
		getDashboard().setEnabled(false);
		getDashboard().getSceltaVolo().setVisible(true);
	}

	public void vaiAVoliPartenzeDaSceltaVolo() {
		getDashboard().getSceltaVolo().dispose();
		getDashboard().setEnabled(true);
		getDashboard().setVisible(true);
		mostraPannelli(getDashboard().getGestioneVoliPartenze());
	}

	public void vaiAVoliArriviDaSceltaVolo() {
		getDashboard().getSceltaVolo().dispose();
		getDashboard().setEnabled(true);
		getDashboard().setVisible(true);
		mostraPannelli(getDashboard().getGestioneVoliArrivi());
	}

	public void annullaSceltaVolo() {
		getDashboard().getSceltaVolo().dispose();
		getDashboard().setEnabled(true);
		getDashboard().setVisible(true);
	}

	// METODI DI HOME

	public boolean sbloccaGestione() {
		if (((Accesso) getDashboard().getAccesso()).isSbloccaHome()) {
			return true;
		} else {
			return false;
		}
	}

	// METODI DI PROFILO

	public void profiloUtenteAccessoEffettuato() {
		utn = new Utente(getEmailAccesso());
		((Profilo) getDashboard().getProfilo()).getTxtNome().setText(implementazioneUtenteDAO().stampaNomeAccount(utn));
		((Profilo) getDashboard().getProfilo()).getTxtCognome().setText(implementazioneUtenteDAO().stampaCognomeAccount(utn));
		((Profilo) getDashboard().getProfilo()).getTxtEmail().setText(implementazioneUtenteDAO().stampaEmailAccount(utn));
	}

	public void logout() {
		((Accesso) getDashboard().getAccesso()).setSbloccaHome(false);
		mostraPannelli(getDashboard().getAccesso());
	}
	

	//METODI PASSWORD DIMENTICATA
		public void svuotaCampiPasswordDimenticata() {
			((PasswordDimenticata) getDashboard().getPasswordDimenticata()).getTxtEmail().setText("");
			((PasswordDimenticata) getDashboard().getPasswordDimenticata()).getTxtNuovaPassword().setText("");
			((PasswordDimenticata) getDashboard().getPasswordDimenticata()).getTxtRipetiNuovaPassword().setText("");
		}
	
	public void mostraPasswordDimenticata() {
		dashboard.setEnabled(false);
		dashboard.getPasswordDimenticata().setVisible(true);
		svuotaCampiPasswordDimenticata();
	}

	public void annullaPasswordDimenticata() {
		dashboard.getPasswordDimenticata().dispose();
		getDashboard().setEnabled(true);
		getDashboard().setVisible(true);
	}

	// METODI DI USCITA

	public void mostraUscita() {
		dashboard.setEnabled(false);
		dashboard.getUscita().setVisible(true);
	}

	public void esci() {
		getDashboard().getUscita().dispose();
		getDashboard().dispose();
	}

	public void annullaUscita() {
		dashboard.getUscita().dispose();
		getDashboard().setEnabled(true);
		getDashboard().setVisible(true);
	}

	// METODI PER RIDIMENSIONAMENTO
	public int dimensioneSchermoX() {
		Toolkit tk = Toolkit.getDefaultToolkit();
		int xSize = ((int) tk.getScreenSize().getHeight());
		return xSize;
	}

	public int dimensioneSchermoY() {
		Toolkit tk = Toolkit.getDefaultToolkit();
		int ySize = ((int) tk.getScreenSize().getWidth());
		return ySize;
	}

	// rimozione background java e adattamento al centro dello schermo
	public Dimension centramentoJFrame(JFrame frame) {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
		frame.setBackground(new Color(0, 0, 0, 0));

		return dim;
	}

	public Dimension centramentoJDialog(JDialog option) {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		option.setLocation(dim.width / 2 - option.getSize().width / 2, dim.height / 2 - option.getSize().height / 2);
		option.setUndecorated(true);

		return dim;
	}

	// METODI DI PROVA

//	public void calcoloRitardo() {
//		int annoTeorico = ((GestioneVoliParternze) getDashboard().getGestioneVoli()).getDateDataPartenza().getDate().getYear();
//		int meseTeorico = ((GestioneVoliParternze) getDashboard().getGestioneVoli()).getDateDataPartenza().getDate().getMonth() + 1;
//		int giornoTeorico = ((GestioneVoliParternze) getDashboard().getGestioneVoli()).getDateDataPartenza().getDate().getDate();
//		int oraTeorica = Integer.parseInt(((GestioneVoliParternze) getDashboard().getGestioneVoli()).getTxtOraPartenza().getText());
//		int minutoTeorico = Integer.parseInt(((GestioneVoliParternze) getDashboard().getGestioneVoli()).getTxtMinutoPartenza().getText());
//		
//		int annoEffettivo = ((GestioneVoliParternze) getDashboard().getGestioneVoli()).getDateDataArrivo().getDate().getYear();
//		int meseEffettivo = ((GestioneVoliParternze) getDashboard().getGestioneVoli()).getDateDataArrivo().getDate().getMonth() + 1;
//		int giornoEffettivo = ((GestioneVoliParternze) getDashboard().getGestioneVoli()).getDateDataArrivo().getDate().getDate();
//		int oraEffettiva = Integer.parseInt(((GestioneVoliParternze) getDashboard().getGestioneVoli()).getTxtOraArrivo().getText());
//		int minutoEffettivo = Integer.parseInt(((GestioneVoliParternze) getDashboard().getGestioneVoli()).getTxtMinutoArrivo().getText());
//		
//		LocalDate DataArrivoTeorico = LocalDate.of(annoTeorico, meseTeorico, giornoTeorico);
//		LocalTime OrarioArrivoTeorico = LocalTime.of(oraTeorica, minutoTeorico);
//		LocalDate DataArrivoEffettivo = LocalDate.of(annoEffettivo, meseEffettivo, giornoEffettivo); 
//		LocalTime OrarioArrivoEffettivo = LocalTime.of(oraEffettiva, minutoEffettivo);
//		
//		int ritardoAnno = Period.between(DataArrivoEffettivo, DataArrivoTeorico).getYears();
//		int ritardoMese = Period.between(DataArrivoEffettivo, DataArrivoTeorico).getMonths();
//		int ritardoGiorno = Period.between(DataArrivoEffettivo, DataArrivoTeorico).getDays();
//		
//		int ritardoAnno = annoEffettivo - annoTeorico;
//		int ritardoMese = meseEffettivo - meseTeorico ;
//		int ritardoGiorno = giornoEffettivo - giornoTeorico;
//		int ritardoOra = oraEffettiva - oraTeorica;
//		int ritardoMinuto = minutoEffettivo - minutoTeorico;
//
//		System.out.println("Il ritardo della partenze è di: " + ritardoAnno + " anni.");
//		System.out.println("Il ritardo della partenze è di: " + ritardoMese + " mesi.");
//		System.out.println("Il ritardo della partenze è di: " + ritardoGiorno + " giorni.");
//		System.out.println("Il ritardo della partenze è di: " + ritardoOra + " ore.");
//		System.out.println("Il ritardo della partenze è di: " + ritardoMinuto + " minuti.\n\n");
//	}

	@SuppressWarnings("deprecation")
	public void calcoloRitardo() {
		Calendar ArrivoTeorico = Calendar.getInstance();
		Calendar ArrivoEffettivo = Calendar.getInstance();

		int annoTeorico = ((GestioneTratte) getDashboard().getGestioneTratte()).getDateDataArrivo().getDate().getYear();
		int meseTeorico = ((GestioneTratte) getDashboard().getGestioneTratte()).getDateDataArrivo().getDate()
				.getMonth();
		int giornoTeorico = ((GestioneTratte) getDashboard().getGestioneTratte()).getDateDataArrivo().getDate()
				.getDate();
		int oraTeorica = Integer
				.parseInt(((GestioneTratte) getDashboard().getGestioneTratte()).getTxtOraArrivo().getText());
		int minutoTeorico = Integer
				.parseInt(((GestioneTratte) getDashboard().getGestioneTratte()).getTxtMinutoArrivo().getText());

		int annoEffettivo = ((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getDateDataPartenza()
				.getDate().getYear();
		int meseEffettivo = ((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getDateDataPartenza()
				.getDate().getMonth();
		int giornoEffettivo = ((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getDateDataPartenza()
				.getDate().getDate();
		int oraEffettiva = Integer.parseInt(
				((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtOraPartenza().getText());
		int minutoEffettivo = Integer.parseInt(
				((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtMinutoPartenza().getText());

		ArrivoTeorico.set(Calendar.YEAR, annoTeorico);
		ArrivoTeorico.set(Calendar.MONTH, meseTeorico);
		ArrivoTeorico.set(Calendar.DAY_OF_MONTH, giornoTeorico);
		ArrivoTeorico.set(Calendar.HOUR_OF_DAY, oraTeorica);
		ArrivoTeorico.set(Calendar.MINUTE, minutoTeorico);

		ArrivoEffettivo.set(Calendar.YEAR, annoEffettivo);
		ArrivoEffettivo.set(Calendar.MONTH, meseEffettivo);
		ArrivoEffettivo.set(Calendar.DAY_OF_MONTH, giornoEffettivo);
		ArrivoEffettivo.set(Calendar.HOUR_OF_DAY, oraEffettiva);
		ArrivoEffettivo.set(Calendar.MINUTE, minutoEffettivo);

		long Differenza_ArrivoTeorico = ArrivoTeorico.getTimeInMillis();
		long Differenza_ArrivoEffettivo = ArrivoEffettivo.getTimeInMillis();
		long ritardo_Arrivo = Differenza_ArrivoEffettivo - Differenza_ArrivoTeorico;
		long ritardoSecondo_Arrivo = ritardo_Arrivo / 1000;
		long ritardoMinuto_Arrivo = ritardoSecondo_Arrivo / 60;
		long ritardoOra_Arrivo = ritardoMinuto_Arrivo / 60;
		long ritardoGiorno_Arrivo = ritardoOra_Arrivo / 24;
		long ritardoMese_Arrivo = ritardoGiorno_Arrivo / 30;
		long ritardoAnno_Arrivo = ritardoMese_Arrivo / 12;

		if (ritardoAnno_Arrivo == 1) {
			System.out.println("Il ritardo dell'arrivo è di: " + ritardoAnno_Arrivo + " anno.");
		} else if (ritardoAnno_Arrivo > 1) {
			System.out.println("Il ritardo dell'arrivo è di: " + ritardoAnno_Arrivo + " anni.");
		} else if (ritardoMese_Arrivo == 1) {
			System.out.println("Il ritardo dell'arrivo è di: " + ritardoMese_Arrivo + " mese.");
		} else if (ritardoMese_Arrivo > 1) {
			System.out.println("Il ritardo della partenze è di: " + ritardoMese_Arrivo + " mesi.");
		} else if (ritardoGiorno_Arrivo == 1) {
			System.out.println("Il ritardo della partenze è di: " + ritardoGiorno_Arrivo + " giorno.");
		} else if (ritardoGiorno_Arrivo > 1) {
			System.out.println("Il ritardo della partenze è di: " + ritardoGiorno_Arrivo + " giorni.");
		} else if (ritardoOra_Arrivo == 1) {
			System.out.println("Il ritardo della partenze è di: " + ritardoOra_Arrivo + " ora.");
		} else if (ritardoOra_Arrivo > 1) {
			System.out.println("Il ritardo della partenze è di: " + ritardoOra_Arrivo + " ore.");
		} else if (ritardoMinuto_Arrivo == 1) {
			System.out.println("Il ritardo della partenze è di: " + ritardoMinuto_Arrivo + " minuto.");
		} else if (ritardoMinuto_Arrivo > 1) {
			System.out.println("Il ritardo della partenze è di: " + ritardoMinuto_Arrivo + " minuti.");
		} else if (ritardoSecondo_Arrivo == 1) {
			System.out.println("Il ritardo della partenze è di: " + ritardoSecondo_Arrivo + " secondo.");
		} else if (ritardoSecondo_Arrivo > 1) {
			System.out.println("Il ritardo della partenze è di: " + ritardoSecondo_Arrivo + " secondi.");
		}
	}
}
