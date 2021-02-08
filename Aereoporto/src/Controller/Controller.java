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
	public Color clickPannello = new Color(40, 40, 40);
	public Color entroPannello = new Color(30, 30, 30);
	public Color escoPannelloLaterale = new Color(35, 39, 42);
	public Color coloreScritturaAllerta = new Color(250, 45, 45);
	public Color trasparente = new Color(0, 0, 0, 0);
	public Font fontScritte = new Font("Arial", Font.BOLD, 14);
	public Font fontTitolo = new Font("Arial", Font.BOLD, 18);
	public Font fontScritteUscita = new Font("Arial", Font.BOLD, 20);

	private Dashboard dashboard;
	private Home home;
	private Accesso accesso;
	private CambioPassword cambioPassword;
	private Registrazione registrazione;
	private Riconoscimenti riconoscimenti;
	private Profilo profilo;
	private MenuGestione menuGestione;
	private GestioneVoli gestioneVoli;
	private Prenotazione prenotazioni;
	private GestioneUtenti gestioneUtenti;
	private GestioneCompagnieAeree gestioneCompagnieAeree;
	private GestioneTratte gestioneTratte;
	private GestioneGate gestioneGate;
	private JDialogProfilo jdialogProfilo;
	private Recensione recensione;
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

	public JDialogProfilo getJdialogProfilo() {
		return jdialogProfilo;
	}

	public void setJdialogProfilo(JDialogProfilo jdialogProfilo) {
		this.jdialogProfilo = jdialogProfilo;
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

	public Recensione getRecensione() {
		return recensione;
	}

	public void setRecensione(Recensione recensione) {
		this.recensione = recensione;
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
		cambioPassword = new CambioPassword(this);
		jdialogProfilo = new JDialogProfilo(this);
		recensione = new Recensione(this);
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
		((Accesso) getDashboard().getAccesso()).getTxtEmail().setText("");
		((Accesso) getDashboard().getAccesso()).getTxtPassword().setText("");

	}

	public void accedi() {
		String email = ((Accesso) getDashboard().getAccesso()).getTxtEmail().getText();
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

	public boolean controlloCampiSeVuotiAccesso() {
		if (((Accesso) getDashboard().getAccesso()).getTxtEmail().getText().length() <= 0
				|| ((Accesso) getDashboard().getAccesso()).getTxtPassword().getText().length() <= 0) {
			return true;
		} else {
			return false;
		}
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
		boolean emailCorretta = controlloInserimentoEmailCorrettamenteRegistrazione(((Registrazione) getDashboard().getRegistrazione()).getTxtEmail().getText());

		if (emailCorretta) {
			return true;
		} else {
			return false;
		}
	}

	public boolean ripetiPassword() {
		if (((Registrazione) getDashboard().getRegistrazione()).getTxtRipetiPassword().getText()
				.equals(((Registrazione) getDashboard().getRegistrazione()).getTxtPassword().getText())) {
			return true;
		} else {
			return false;
		}
	}

	public void registrati() {
		((Registrazione) getDashboard().getRegistrazione()).getLblMessaggioCredenziali().setText("");;
		if (formatoEmailInseritaErrato() && ripetiPassword() && nessunCampoVuoto()) {
			Utente utn = new Utente(((Registrazione) getDashboard().getRegistrazione()).getTxtNome().getText(),
					((Registrazione) getDashboard().getRegistrazione()).getTxtCognome().getText(),
					((Registrazione) getDashboard().getRegistrazione()).getTxtEmail().getText(),
					((Registrazione) getDashboard().getRegistrazione()).getTxtPassword().getText());
			implementazioneUtenteDAO().registrazioneUtente(utn);
			mostraPannelli(getDashboard().getAccesso());
			
		} else if ((!formatoEmailInseritaErrato() || ripetiPassword()) && nessunCampoVuoto()){
			
			JOptionPane.showMessageDialog(null, "Formato email inserito non valido!\n" + "Inserire l'email dal formato tipo: example@example.com");
			
		} else if (formatoEmailInseritaErrato() && !ripetiPassword() && nessunCampoVuoto()) {
			
			((Registrazione) getDashboard().getRegistrazione()).getLblMessaggioCredenziali().setText("La password ripetuta non � corretta.");
			((Registrazione) getDashboard().getRegistrazione()).getTxtPassword().setText("");
			((Registrazione) getDashboard().getRegistrazione()).getTxtRipetiPassword().setText("");
		
		}  else {
			((Registrazione) getDashboard().getRegistrazione()).getLblMessaggioCredenziali().setText("Ci sono campi vuoti, riempirli tutti per la registrazione.");
		}
	}

	public boolean nessunCampoVuoto() {
		if(	((Registrazione) getDashboard().getRegistrazione()).getTxtNome().getText().length() <= 0 ||
			((Registrazione) getDashboard().getRegistrazione()).getTxtCognome().getText().length() <= 0 ||
			((Registrazione) getDashboard().getRegistrazione()).getTxtEmail().getText().length() <= 0 ||
			((Registrazione) getDashboard().getRegistrazione()).getTxtPassword().getText().length() <= 0 ||
			((Registrazione) getDashboard().getRegistrazione()).getTxtRipetiPassword().getText().length() <= 0 ) {
			
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
		((GestioneTratte) getDashboard().getGestioneTratte()).getTxtOrarioPartenza().setText("");
		((GestioneTratte) getDashboard().getGestioneTratte()).getTxtOrarioArrivo().setText("");
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
				((GestioneTratte) getDashboard().getGestioneTratte()).getTxtOrarioPartenza().getText(),
				((GestioneTratte) getDashboard().getGestioneTratte()).getTxtOrarioArrivo().getText());
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
				((GestioneTratte) getDashboard().getGestioneTratte()).getTxtOrarioPartenza().getText(),
				((GestioneTratte) getDashboard().getGestioneTratte()).getTxtOrarioArrivo().getText());

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
				((GestioneTratte) getDashboard().getGestioneTratte()).getTxtOrarioPartenza().getText(),
				((GestioneTratte) getDashboard().getGestioneTratte()).getTxtOrarioArrivo().getText());

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
		vl = new Volo(((GestioneVoli) getDashboard().getGestioneVoli()).getTxtCodiceVolo().getText(),
				((GestioneVoli) getDashboard().getGestioneVoli()).getTxtCittaPartenza().getText(),
				((GestioneVoli) getDashboard().getGestioneVoli()).getTxtCittaArrivo().getText(),
				((GestioneVoli) getDashboard().getGestioneVoli()).getDateDataPartenza().getDate(),
				((GestioneVoli) getDashboard().getGestioneVoli()).getDateDataArrivo().getDate(),
				((GestioneVoli) getDashboard().getGestioneVoli()).getTxtOrarioPartenza().getText(),
				((GestioneVoli) getDashboard().getGestioneVoli()).getTxtOrarioArrivo().getText(),
				((GestioneVoli) getDashboard().getGestioneVoli()).getTxtNumeroPrenotazioni().getText());

		implementazioneVoloDAO().aggiungiVolo(vl);
		((GestioneVoli) getDashboard().getGestioneVoli()).getModello()
				.addRow(((GestioneVoli) getDashboard().getGestioneVoli()).getRow());
		svuotaCampiVolo();
		((GestioneVoli) getDashboard().getGestioneVoli()).caricaTabella();
	}

	public void eliminaVolo() {
		vl = new Volo(((GestioneVoli) getDashboard().getGestioneVoli()).getTxtCodiceVolo().getText(),
				((GestioneVoli) getDashboard().getGestioneVoli()).getTxtCittaPartenza().getText(),
				((GestioneVoli) getDashboard().getGestioneVoli()).getTxtCittaArrivo().getText(),
				((GestioneVoli) getDashboard().getGestioneVoli()).getDateDataPartenza().getDate(),
				((GestioneVoli) getDashboard().getGestioneVoli()).getDateDataArrivo().getDate(),
				((GestioneVoli) getDashboard().getGestioneVoli()).getTxtOrarioPartenza().getText(),
				((GestioneVoli) getDashboard().getGestioneVoli()).getTxtOrarioArrivo().getText(),
				((GestioneVoli) getDashboard().getGestioneVoli()).getTxtNumeroPrenotazioni().getText());

		int t = ((GestioneVoli) getDashboard().getGestioneVoli()).getTabella().getSelectedRow();
		implementazioneVoloDAO().cancellaVolo(vl);
		((GestioneVoli) getDashboard().getGestioneVoli()).getModello().removeRow(t);
		svuotaCampiVolo();
		((GestioneVoli) getDashboard().getGestioneVoli()).caricaTabella();
	}

	public void modificaVolo() {
		vl = new Volo(((GestioneVoli) getDashboard().getGestioneVoli()).getTxtCodiceVolo().getText(),
				((GestioneVoli) getDashboard().getGestioneVoli()).getTxtCittaPartenza().getText(),
				((GestioneVoli) getDashboard().getGestioneVoli()).getTxtCittaArrivo().getText(),
				((GestioneVoli) getDashboard().getGestioneVoli()).getDateDataPartenza().getDate(),
				((GestioneVoli) getDashboard().getGestioneVoli()).getDateDataArrivo().getDate(),
				((GestioneVoli) getDashboard().getGestioneVoli()).getTxtOrarioPartenza().getText(),
				((GestioneVoli) getDashboard().getGestioneVoli()).getTxtOrarioArrivo().getText(),
				((GestioneVoli) getDashboard().getGestioneVoli()).getTxtNumeroPrenotazioni().getText());

		int t = ((GestioneVoli) getDashboard().getGestioneVoli()).getTabella().getSelectedRow();

		((GestioneVoli) getDashboard().getGestioneVoli()).getModello()
				.setValueAt(((GestioneVoli) getDashboard().getGestioneVoli()).getTxtCodiceVolo().getText(), t, 0);
		((GestioneVoli) getDashboard().getGestioneVoli()).getModello()
				.setValueAt(((GestioneVoli) getDashboard().getGestioneVoli()).getTxtCittaPartenza().getText(), t, 1);
		((GestioneVoli) getDashboard().getGestioneVoli()).getModello()
				.setValueAt(((GestioneVoli) getDashboard().getGestioneVoli()).getTxtCittaArrivo().getText(), t, 2);
		((GestioneVoli) getDashboard().getGestioneVoli()).getModello()
				.setValueAt(((GestioneVoli) getDashboard().getGestioneVoli()).getDateDataPartenza().getDate(), t, 3);
		((GestioneVoli) getDashboard().getGestioneVoli()).getModello()
				.setValueAt(((GestioneVoli) getDashboard().getGestioneVoli()).getDateDataArrivo().getDate(), t, 4);
		((GestioneVoli) getDashboard().getGestioneVoli()).getModello()
				.setValueAt(((GestioneVoli) getDashboard().getGestioneVoli()).getTxtOrarioPartenza().getText(), t, 5);
		((GestioneVoli) getDashboard().getGestioneVoli()).getModello()
				.setValueAt(((GestioneVoli) getDashboard().getGestioneVoli()).getTxtOrarioArrivo().getText(), t, 6);
		((GestioneVoli) getDashboard().getGestioneVoli()).getModello().setValueAt(
				((GestioneVoli) getDashboard().getGestioneVoli()).getTxtNumeroPrenotazioni().getText(), t, 7);

		implementazioneVoloDAO().modificaVolo(vl);
		svuotaCampiVolo();
		((GestioneVoli) getDashboard().getGestioneVoli()).caricaTabella();
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
			getDashboard().getPannelloTendina().setSize(getDashboard().getPosizioneTendina(), 634);
			Thread th = new Thread() {
				@Override
				public void run() {
					try {
						for (int i = 50; i <= getDashboard().getPosizioneTendina(); i++) {
							Thread.sleep(1, 01);
							getDashboard().getPannelloTendina().setSize(i, 634);
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
			getDashboard().getPannelloTendina().setSize(50, 634);
			Thread th = new Thread() {
				@Override
				public void run() {
					try {
						for (int i = 238; i >= 50; i--) {
							Thread.sleep(1, 01);
							getDashboard().getPannelloTendina().setSize(i, 634);
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
			getDashboard().getPannelloTendina().setSize(50, 634);
			Thread th = new Thread() {
				@Override
				public void run() {
					try {
						for (int i = 238; i >= 50; i--) {
							Thread.sleep(0, 0);
							getDashboard().getPannelloTendina().setSize(i, 634);
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

	public JPanel gestioneVoli() {
		GestioneVoli gestioneVoli = new GestioneVoli(this);
		return gestioneVoli;
	}
	
	public JDialog jdialogProfilo() {
		JDialogProfilo jdialogProfilo = new JDialogProfilo(this);
		return jdialogProfilo;
	}
	
	public JDialog recensione() {
		Recensione recensione = new Recensione(this);
		return recensione;
	}
	
	public JDialog uscita() {
		Uscita uscita = new Uscita(this);
		return uscita;
	}

	public void mostraNoClick() {
		
		if(getDashboard().getHome().isVisible()) {
			getDashboard().getHome().setVisible(true);
		} else if(getDashboard().getAccesso().isVisible()) {
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
		getDashboard().getGestioneVoli().setVisible(false);
		getDashboard().getCambioPassword().setVisible(false);
		pane.setVisible(true);

	}

	public void mostraUscita() {
		dashboard.setEnabled(false);
		dashboard.getUscita().setVisible(true);
	}
	
	public void mostraJDialogProfilo() {
		dashboard.setEnabled(false);
		dashboard.getJDialogProfilo().setVisible(true);
	}
	

	// METODI DI HOME

	public boolean sbloccaGestione() {
		if (((Accesso) getDashboard().getAccesso()).isSbloccaHome()) {
			return true;
		} else {
			return false;
		}
	}
	
	
	// METODI DI LOGOUT
	public void logout() {
		((Accesso) getDashboard().getAccesso()).setSbloccaHome(false);
		mostraPannelli(getDashboard().getAccesso());
	}

	// METODI DI USCITA

	public void vaiAdAccediDaJDialogProfilo() {
		jdialogProfilo.setVisible(false);
		dashboard.getAccesso();
		
	}
	
	public void esci() {
		dashboard.getUscita().dispose();
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

	@SuppressWarnings("deprecation")
	public void calcoloRitardo() {
		Calendar ArrivoTeorico = Calendar.getInstance();
		Calendar ArrivoEffettivo = Calendar.getInstance();

		ArrivoTeorico.set(Calendar.YEAR, gestioneTratte.getDateDataPartenza().getDate().getYear());
		ArrivoTeorico.set(Calendar.MONTH, gestioneTratte.getDateDataPartenza().getDate().getMonth());
		ArrivoTeorico.set(Calendar.DAY_OF_MONTH, gestioneTratte.getDateDataPartenza().getDate().getDay());
		ArrivoTeorico.set(Calendar.HOUR_OF_DAY, gestioneTratte.getDateDataPartenza().getDate().getHours());
		ArrivoTeorico.set(Calendar.MINUTE, gestioneTratte.getDateDataPartenza().getDate().getMinutes());
		ArrivoTeorico.set(Calendar.SECOND, gestioneTratte.getDateDataPartenza().getDate().getSeconds());

		ArrivoEffettivo.set(Calendar.YEAR, gestioneTratte.getDateDataArrivo().getDate().getYear());
		ArrivoEffettivo.set(Calendar.MONTH, gestioneTratte.getDateDataArrivo().getDate().getMonth());
		ArrivoEffettivo.set(Calendar.DAY_OF_MONTH, gestioneTratte.getDateDataArrivo().getDate().getDay());
		ArrivoEffettivo.set(Calendar.HOUR_OF_DAY, gestioneTratte.getDateDataArrivo().getDate().getHours());
		ArrivoEffettivo.set(Calendar.MINUTE, gestioneTratte.getDateDataArrivo().getDate().getMinutes());
		ArrivoEffettivo.set(Calendar.SECOND, gestioneTratte.getDateDataArrivo().getDate().getSeconds());

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
			System.out.println("Il ritardo della partenze è di: " + ritardoAnno_Arrivo + " anno.");
		} else if (ritardoAnno_Arrivo > 1) {
			System.out.println("Il ritardo della partenze è di: " + ritardoAnno_Arrivo + " anni.");
		} else if (ritardoMese_Arrivo == 1) {
			System.out.println("Il ritardo della partenze è di: " + ritardoMese_Arrivo + " mese.");
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
