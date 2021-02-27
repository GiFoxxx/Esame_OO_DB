package Controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;
import Amministrazione.*;
import Classi.*;
import ClassiDAO.*;
import GUI.*;
import Immagini.Immagini;
import ImplementazioniPostrgresDAO.*;

public class Controller {

	Immagini img = new Immagini();
	private int flagCambioTema = 0;

	// PALETTE COLORI TEMA SCURO
	public Color sfondoTemaScuro = new Color(54, 57, 63);
	public Color coloreBianco = new Color(255, 255, 255);
	public Color coloreScritteTemaScuro = new Color(242, 242, 242);
	public Color coloreScritteSuBiancoTemaScuro = new Color(35, 39, 42);
	public Color escoPannelloTemaScuro = new Color(35, 39, 42);
	public Color entroPannelloTemaScuro = new Color(40, 45, 48);
	public Color clickPannelloTemaScuro = new Color(50, 55, 58);
	public Color pannelloSceltoTemaScuro = new Color(60, 65, 68);
	public Color coloreScritturaAllertaTemaScuro = new Color(250, 45, 45);
	public Color coloreLabelTemaScuro = new Color(200, 200, 200);
	public Color coloreLabelEntrataTemaScuro = new Color(220, 220, 220);
	public Color coloreLabelPressedTemaScuro = new Color(242, 242, 242);

	// PALETTE COLORI TEMA CHIARO
	public Color sfondoTemaChiaro = new Color(255, 255, 255);
	public Color coloreScritteTemaChiaro = new Color(35, 39, 42);
	public Color coloreScritteTendinaTemaChiaro = new Color(106, 110, 117);
	public Color escoPannelloTemaChiaro = new Color(227, 229, 232);
	public Color entroPannelloTemaChiaro = new Color(232, 234, 237);
	public Color clickPannelloTemaChiaro = new Color(237, 239, 242);
	public Color pannelloSceltoTemaChiaro = new Color(212, 215, 220);
	public Color coloreScritturaAllertaTemaChiaro = new Color(250, 45, 45);
	public Color coloreLabelTemaChiaro = new Color(106, 110, 117);
	public Color coloreLabelEntrataTemaChiaro = new Color(65, 70, 74);
	public Color coloreLabelPressedTemaChiaro = new Color(46, 51, 56);

	public Color trasparente = new Color(0, 0, 0, 0);

	// FONT TESTI
	public Font fontScritte = new Font("Arial", Font.PLAIN, 18);
	public Font fontScritteTendina = new Font("Arial", Font.BOLD, 17);
	public Font fontTitolo = new Font("Arial", Font.BOLD, 18);
	public Font fontScritteJDialog = new Font("Arial", Font.BOLD, 18);
	public Font fontScritteGestioni = new Font("Arial", Font.PLAIN, 13);
	public Font fontLabel = new Font("Arial", Font.BOLD, 12);

	private String emailAccesso;
	private String passwordAccesso;
	private boolean entraGestioneUtenti = false;
	private int pannelloPrecedente = 1;

	private Dashboard dashboard;
	private Home home;
	private Accesso accesso;
	private CambioPassword cambioPassword;
	private Registrazione registrazione;
	private Profilo profilo;
	private GestioneVoliPartenze gestioneVoliPartenze;
	private GestioneVoliArrivi gestioneVoliArrivi;
	private GestioneUtenti gestioneUtenti;
	private GestioneCompagnieAeree gestioneCompagnieAeree;
	private GestioneTratte gestioneTratte;
	private GestioneGate gestioneGate;
	private GateCodeImbarco gateCodeImbarco;
	private SceltaGate sceltaGate;
	private Recensione recensioni;
	private NoClick noClick;

	private Informazioni informazioni;
	private TerminiECondizioni terminiECondizioni;
	private RegistrazioneEffettuataConSuccesso registrazioneEffettuataConSuccesso;
	private PasswordDimenticata passwordDimenticata;
	private SceltaProfiloSenzaAccesso sceltaProfiloSenzaAccesso;
	private SceltaVolo sceltaVolo;
	private Uscita uscita;

	Utente utn;
	VoloPartenze vlprtz;
	VoloArrivi vlarr;
	Gate gt;
	CodaDiImbarco codaImbarco;
	Tratta trt;
	CompagniaAerea compAerea;

	// GETTER E SETTER
	public String getEmailAccesso() {
		return emailAccesso;
	}

	public void setEmailAccesso(String emailAccesso) {
		this.emailAccesso = emailAccesso;
	}

	public String getPasswordAccesso() {
		return passwordAccesso;
	}

	public void setPasswordAccesso(String passwordAccesso) {
		this.passwordAccesso = passwordAccesso;
	}

	public int getPannelloPrecedente() {
		return pannelloPrecedente;
	}

	public void setPannelloPrecedente(int pannelloPrecedente) {
		this.pannelloPrecedente = pannelloPrecedente;
	}

	public boolean isEntraGestioneUtenti() {
		return entraGestioneUtenti;
	}

	public void setEntraGestioneUtenti(boolean entraGestioneUtenti) {
		this.entraGestioneUtenti = entraGestioneUtenti;
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

	public GateCodeImbarco getGateCodeImbarco() {
		return gateCodeImbarco;
	}

	public void setGateCodeImbarco(GateCodeImbarco gateCodeImbarco) {
		this.gateCodeImbarco = gateCodeImbarco;
	}
	
	public SceltaGate getSceltaGate() {
        return sceltaGate;
    }

    public void setSceltaGate(SceltaGate sceltaGate) {
        this.sceltaGate = sceltaGate;
    }

	public Recensione getRecensioni() {
		return recensioni;
	}

	public void setRecensioni(Recensione recensioni) {
		this.recensioni = recensioni;
	}

	public Informazioni getInformazioni() {
		return informazioni;
	}

	public void setInformazioni(Informazioni informazioni) {
		this.informazioni = informazioni;
	}

	public TerminiECondizioni getTerminiECondizioni() {
		return terminiECondizioni;
	}

	public void setTerminiECondizioni(TerminiECondizioni terminiECondizioni) {
		this.terminiECondizioni = terminiECondizioni;
	}

	public RegistrazioneEffettuataConSuccesso getRegistrazioneEffettuataConSuccesso() {
		return registrazioneEffettuataConSuccesso;
	}

	public void setRegistrazioneEffettuataConSuccesso(
			RegistrazioneEffettuataConSuccesso registrazioneEffettuataConSuccesso) {
		this.registrazioneEffettuataConSuccesso = registrazioneEffettuataConSuccesso;
	}

	public Uscita getUscita() {
		return uscita;
	}

	public void setUscita(Uscita uscita) {
		this.uscita = uscita;
	}

	public NoClick getNoClick() {
		return noClick;
	}

	public void setNoClick(NoClick noClick) {
		this.noClick = noClick;
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
		gestioneUtenti = new GestioneUtenti(this);
		gestioneCompagnieAeree = new GestioneCompagnieAeree(this);
		gestioneTratte = new GestioneTratte(this);
		gestioneGate = new GestioneGate(this);
		gateCodeImbarco = new GateCodeImbarco(this);
		gestioneVoliPartenze = new GestioneVoliPartenze(this);
		gestioneVoliArrivi = new GestioneVoliArrivi(this);
		cambioPassword = new CambioPassword(this);
		sceltaProfiloSenzaAccesso = new SceltaProfiloSenzaAccesso(this);
		passwordDimenticata = new PasswordDimenticata(this);
		sceltaVolo = new SceltaVolo(this);
		recensioni = new Recensione(this);
		noClick = new NoClick(this);
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
		passwordAccesso = ((Accesso) getDashboard().getAccesso()).getTxtPassword().getText();

		if (implementazioneUtenteDAO().accessoUtente(email, password)) {
			mostraPannelli(getDashboard().getHome());
			mostraUtenteLoggato();
			setPannelloPrecedente(1);
			if (email.equals("luigidemarco@gmail.com") || email.equals("manuelbuonanno00@gmail.com")) {
				entraGestioneUtenti = true;
				((Profilo) getDashboard().getProfilo()).getLblGestioneUtenti().setText("Gestione utenti");
				((Profilo) getDashboard().getProfilo()).getLblGestioneUtenti().setEnabled(true);
			}
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
		if (formatoEmailInseritaErrato() && ripetiPassword() && nessunCampoVuoto()
				&& !((Accesso) getDashboard().getAccesso()).isSbloccaHome()) {
			Utente utn = new Utente(((Registrazione) getDashboard().getRegistrazione()).getTxtNome().getText(),
					((Registrazione) getDashboard().getRegistrazione()).getTxtCognome().getText(),
					((Registrazione) getDashboard().getRegistrazione()).getTxtEmail().getText(),
					((Registrazione) getDashboard().getRegistrazione()).getTxtPassword().getText());
			implementazioneUtenteDAO().registrazioneUtente(utn);

			mostraRegistrazioneEffettuataConSuccesso();

			mostraPannelli(getDashboard().getAccesso());
			((GestioneUtenti) getDashboard().getGestioneUtenti()).caricaTabella();
		} else if ((!formatoEmailInseritaErrato() || ripetiPassword()) && nessunCampoVuoto()
				&& !((Accesso) getDashboard().getAccesso()).isSbloccaHome()) {
			((Registrazione) getDashboard().getRegistrazione()).getLblMessaggioCredenziali().setText(
					"Formato email inserito non valido!\n" + "Inserire l'email dal formato tipo: example@example.com");

		} else if (formatoEmailInseritaErrato() && !ripetiPassword() && nessunCampoVuoto()
				&& !((Accesso) getDashboard().getAccesso()).isSbloccaHome()) {

			((Registrazione) getDashboard().getRegistrazione()).getLblMessaggioCredenziali()
					.setText("Le passwords non corrispondono.");

		} else if (formatoEmailInseritaErrato() && ripetiPassword() && nessunCampoVuoto()
				&& !((Accesso) getDashboard().getAccesso()).isSbloccaHome()) {
			((Registrazione) getDashboard().getRegistrazione()).getLblMessaggioCredenziali()
					.setText("Effettuare il logout prima della registrazione.");
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

	public UtenteDAO implementazioneUtenteDAO() {
		UtenteDAO dao = new UtenteImplementazionePostgresDAO();
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

	public void svuotaCampiGestioneCompagniaAerea() {
		((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).getTxtCodiceCompagniaAerea().setText("");
		((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).getTxtNome().setText("");
	}

	public CompagniaAereaDAO implementazioneCompagniaAereaDAO() {
		CompagniaAereaDAO dao = new CompagniaAereaImplementazionePostgresDAO();
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
		svuotaCampiGestioneCompagniaAerea();
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
		svuotaCampiGestioneCompagniaAerea();
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
		svuotaCampiGestioneCompagniaAerea();
		((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).caricaTabella();
	}

	// METODI GESTIONE TRATTE

	public void svuotaCampiGestioneTratta() {
		((GestioneTratte) getDashboard().getGestioneTratte()).getTxtCodiceTratta().setText("");
		((GestioneTratte) getDashboard().getGestioneTratte()).getTxtCittaPartenza().setText("");
		((GestioneTratte) getDashboard().getGestioneTratte()).getTxtCittaArrivo().setText("");
	}

	public TrattaDAO implementazioneTrattaDAO() {
		TrattaDAO dao = new TrattaImplementazionePostgresDAO();
		return dao;
	}

	public void aggiungiTratta() {

		compAerea = new CompagniaAerea(
				((GestioneTratte) getDashboard().getGestioneTratte()).getTxtCodiceCompagniaAerea().getText());

		trt = new Tratta(compAerea,
				((GestioneTratte) getDashboard().getGestioneTratte()).getTxtCodiceTratta().getText(),
				((GestioneTratte) getDashboard().getGestioneTratte()).getTxtCittaPartenza().getText(),
				((GestioneTratte) getDashboard().getGestioneTratte()).getTxtCittaArrivo().getText());

		implementazioneTrattaDAO().aggiungiTratta(trt);
		((GestioneTratte) getDashboard().getGestioneTratte()).getModello()
				.addRow(((GestioneTratte) getDashboard().getGestioneTratte()).getRow());
		svuotaCampiGestioneTratta();
		((GestioneTratte) getDashboard().getGestioneTratte()).caricaTabella();
	}

	public void eliminaTratta() {

		compAerea = new CompagniaAerea(
				((GestioneTratte) getDashboard().getGestioneTratte()).getTxtCodiceCompagniaAerea().getText());

		trt = new Tratta(((GestioneTratte) getDashboard().getGestioneTratte()).getTxtCodiceTratta().getText());

		int t = ((GestioneTratte) getDashboard().getGestioneTratte()).getTabella().getSelectedRow();
		implementazioneTrattaDAO().cancellaTratta(trt);
		((GestioneTratte) getDashboard().getGestioneTratte()).getModello().removeRow(t);
		svuotaCampiGestioneTratta();
		((GestioneTratte) getDashboard().getGestioneTratte()).caricaTabella();
	}

	public void modificaTratta() {
		compAerea = new CompagniaAerea(
				((GestioneTratte) getDashboard().getGestioneTratte()).getTxtCodiceCompagniaAerea().getText());

		trt = new Tratta(compAerea,
				((GestioneTratte) getDashboard().getGestioneTratte()).getTxtCodiceTratta().getText(),
				((GestioneTratte) getDashboard().getGestioneTratte()).getTxtCittaPartenza().getText(),
				((GestioneTratte) getDashboard().getGestioneTratte()).getTxtCittaArrivo().getText());

		int t = ((GestioneTratte) getDashboard().getGestioneTratte()).getTabella().getSelectedRow();

		((GestioneTratte) getDashboard().getGestioneTratte()).getModello()
				.setValueAt(((GestioneTratte) getDashboard().getGestioneTratte()).getTxtCodiceTratta().getText(), t, 0);
		((GestioneTratte) getDashboard().getGestioneTratte()).getModello().setValueAt(
				((GestioneTratte) getDashboard().getGestioneTratte()).getTxtCittaPartenza().getText(), t, 1);
		((GestioneTratte) getDashboard().getGestioneTratte()).getModello()
				.setValueAt(((GestioneTratte) getDashboard().getGestioneTratte()).getTxtCittaArrivo().getText(), t, 2);

		implementazioneTrattaDAO().modificaTratta(trt);
		svuotaCampiGestioneTratta();
		((GestioneTratte) getDashboard().getGestioneTratte()).caricaTabella();
	}

	// METODI GESTIONE VOLI PARTENZE

	public void svuotaCampiGestioneVoloPartenze() {
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtCodiceVoloPartenze().setText("");
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtCodiceTratta().setText("");
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtCodiceGate().setText("");
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getDateDataPartenza().setDate(null);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtOraPartenza().setText("");
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtMinutoPartenza().setText("");
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtNumeroPrenotazioni().setText(null);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtRitardo().setText("");
	}

	public VoloPartenzeDAO implementazioneVoloPartenzeDAO() {
		VoloPartenzeDAO dao = new VoloPartenzeImplementazionePostgresDAO();
		return dao;
	}

	public void aggiungiVoloPartenze() {
		gt = new Gate(((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtCodiceGate().getText());
		trt = new Tratta(
				((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtCodiceTratta().getText());

		int ritardo = Integer
				.parseInt(((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtRitardo().getText());

		int ora = Integer.parseInt(
				((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtOraPartenza().getText());
		int minuto = Integer.parseInt(
				((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtMinutoPartenza().getText());
		int secondo = 0;
		@SuppressWarnings("deprecation")
		Time tempo = new Time(ora, minuto, secondo);

		vlprtz = new VoloPartenze(
				((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtCodiceVoloPartenze().getText(),
				((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getDateDataPartenza().getDate(),
				tempo,
				((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtNumeroPrenotazioni().getText(),
				ritardo, trt, gt);

		implementazioneVoloPartenzeDAO().aggiungiVoloPartenze(vlprtz);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getModello()
				.addRow(((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getRow());
		svuotaCampiGestioneVoloPartenze();
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).caricaTabella();
	}

	public void eliminaVoloPartenze() {
		vlprtz = new VoloPartenze(((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtCodiceVoloPartenze().getText());

		int t = ((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTabella().getSelectedRow();
		implementazioneVoloPartenzeDAO().cancellaVoloPartenze(vlprtz);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getModello().removeRow(t);
		svuotaCampiGestioneVoloPartenze();
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).caricaTabella();
	}

	public void modificaVoloPartenze() {
		gt = new Gate(((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtCodiceGate().getText());
		trt = new Tratta(
				((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtCodiceTratta().getText());

		int ritardo = Integer
				.parseInt(((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtRitardo().getText());

		int ora = Integer.parseInt(
				((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtOraPartenza().getText());
		int minuto = Integer.parseInt(
				((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtMinutoPartenza().getText());
		int secondo = 0;
		@SuppressWarnings("deprecation")
		Time tempo = new Time(ora, minuto, secondo);

		vlprtz = new VoloPartenze(
				((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtCodiceVoloPartenze().getText(),
				((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getDateDataPartenza().getDate(),
				tempo,
				((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtNumeroPrenotazioni().getText(),
				ritardo, trt, gt);

		int t = ((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTabella().getSelectedRow();

		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getModello().setValueAt(
				((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtCodiceVoloPartenze().getText(),
				t, 0);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getModello().setValueAt(
				((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtCodiceGate().getText(), t, 1);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getModello().setValueAt(
				((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtCodiceTratta().getText(), t, 2);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getModello().setValueAt(
				((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getDateDataPartenza().getDate(), t,
				3);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getModello().setValueAt(
				((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtOraPartenza().getText(), t, 4);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getModello().setValueAt(
				((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtMinutoPartenza().getText(), t,
				5);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getModello().setValueAt(
				((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtNumeroPrenotazioni().getText(),
				t, 6);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getModello().setValueAt(
				((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtRitardo().getText(), t, 7);

		implementazioneVoloPartenzeDAO().modificaVoloPartenze(vlprtz);
		svuotaCampiGestioneVoloPartenze();
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).caricaTabella();
	}

	// METODI GESTIONE VOLI ARRIVI

	public void svuotaCampiGestioneVoloArrivi() {
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTxtCodiceVoloArrivi().setText("");
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTxtCittaPartenza().setText("");
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getDateDataArrivo().setDate(null);
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTxtOraArrivo().setText("");
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTxtMinutoArrivo().setText("");
	}

	public VoloArriviDAO implementazioneVoloArriviDAO() {
		VoloArriviDAO dao = new VoloArriviImplementazionePostgresDAO();
		return dao;
	}

	public void aggiungiVoloArrivi() {
		int ora = Integer
				.parseInt(((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTxtOraArrivo().getText());
		int minuto = Integer
				.parseInt(((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTxtMinutoArrivo().getText());
		int secondo = 0;
		@SuppressWarnings("deprecation")
		Time tempo = new Time(ora, minuto, secondo);

		vlarr = new VoloArrivi(
				((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTxtCodiceVoloArrivi().getText(),
				((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTxtCittaPartenza().getText(),
				((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getDateDataArrivo().getDate(), tempo);

		implementazioneVoloArriviDAO().aggiungiVoloArrivi(vlarr);
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getModello()
				.addRow(((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getRow());
		svuotaCampiGestioneVoloArrivi();
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).caricaTabella();
	}

	public void eliminaVoloArrivi() {
		vlarr = new VoloArrivi(
				((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTxtCodiceVoloArrivi().getText());

		int t = ((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTabella().getSelectedRow();
		implementazioneVoloArriviDAO().cancellaVoloArrivi(vlarr);
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getModello().removeRow(t);
		svuotaCampiGestioneVoloArrivi();
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).caricaTabella();
	}

	public void modificaVoloArrivi() {
		int ora = Integer
				.parseInt(((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTxtOraArrivo().getText());
		int minuto = Integer
				.parseInt(((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTxtMinutoArrivo().getText());
		int secondo = 0;
		@SuppressWarnings("deprecation")
		Time tempo = new Time(ora, minuto, secondo);

		vlarr = new VoloArrivi(
				((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTxtCodiceVoloArrivi().getText(),
				((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTxtCittaPartenza().getText(),
				((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getDateDataArrivo().getDate(), tempo);

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
		svuotaCampiGestioneVoloArrivi();
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).caricaTabella();
	}

	// METODI GESTIONE GATE

	public void svuotaCampiGestioneGate() {
		((GestioneGate) getDashboard().getGestioneGate()).getTxtCodiceGate().setText("");
		((GestioneGate) getDashboard().getGestioneGate()).getTxtNumeroPorta().setText("");
		((GestioneGate) getDashboard().getGestioneGate()).getTxtTempoImbarcoStimato().setText("");
	}

	public GateDAO implementazioneGateDAO() {
		GateDAO dao = new GateImplementazionePostgresDAO();
		return dao;
	}

	public CodaDiImbarcoDAO implementazioneCodaDiImbarcoDAO() {
		CodaDiImbarcoDAO dao = new CodaDiImbarcoImplementazionePostgresDAO();
		return dao;
	}

	public void aggiungiGate() {
		int ora = 0;
		int minuto = Integer.parseInt(((GestioneGate) getDashboard().getGestioneGate()).getTxtTempoImbarcoStimato().getText());
		int secondo = 0;
		@SuppressWarnings("deprecation")
		Time tempo = new Time(ora, minuto, secondo);

		gt = new Gate(((GestioneGate) getDashboard().getGestioneGate()).getTxtCodiceGate().getText(),
				((GestioneGate) getDashboard().getGestioneGate()).getTxtNumeroPorta().getText(), tempo);

		implementazioneGateDAO().aggiungiGate(gt);
		((GestioneGate) getDashboard().getGestioneGate()).getModello()
				.addRow(((GestioneGate) getDashboard().getGestioneGate()).getRow());
		svuotaCampiGestioneGate();
		((GestioneGate) getDashboard().getGestioneGate()).caricaTabella();
	}

	public void eliminaGate() {
		gt = new Gate(((GestioneGate) getDashboard().getGestioneGate()).getTxtCodiceGate().getText());

		int t = ((GestioneGate) getDashboard().getGestioneGate()).getTabella().getSelectedRow();
		implementazioneGateDAO().cancellaGate(gt);
		((GestioneGate) getDashboard().getGestioneGate()).getModello().removeRow(t);
		svuotaCampiGestioneGate();
		((GestioneGate) getDashboard().getGestioneGate()).caricaTabella();
	}

	public void modificaGate() {
		int ora = 0;
		int minuto = Integer.parseInt(((GestioneGate) getDashboard().getGestioneGate()).getTxtTempoImbarcoStimato().getText());
		int secondo = 0;
		@SuppressWarnings("deprecation")
		Time tempo = new Time(ora, minuto, secondo);

		gt = new Gate(((GestioneGate) getDashboard().getGestioneGate()).getTxtCodiceGate().getText(),
				((GestioneGate) getDashboard().getGestioneGate()).getTxtNumeroPorta().getText(), tempo);

		int t = ((GestioneGate) getDashboard().getGestioneGate()).getTabella().getSelectedRow();

		((GestioneGate) getDashboard().getGestioneGate()).getModello()
				.setValueAt(((GestioneGate) getDashboard().getGestioneGate()).getTxtCodiceGate().getText(), t, 0);
		((GestioneGate) getDashboard().getGestioneGate()).getModello()
				.setValueAt(((GestioneGate) getDashboard().getGestioneGate()).getTxtNumeroPorta().getText(), t, 1);

		implementazioneGateDAO().modificaGate(gt);
		svuotaCampiGestioneGate();
		((GestioneGate) getDashboard().getGestioneGate()).caricaTabella();
	}
	
	//METODI DI GATE CODE DI IMBARCO
	public void svuotaCampiGateCodeImbarco() {
		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getTxtCodiceGate().setText("");
		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getTxtCodaDiImbarco().setText("");
	}
	
	
	public void aggiungiGateCodeImbarco() {
		codaImbarco = new CodaDiImbarco(
				((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getTxtCodaDiImbarco().getText());

		gt = new Gate(((GestioneGate) getDashboard().getGestioneGate()).getTxtCodiceGate().getText());

		implementazioneGateDAO().aggiungiGateInCodaDiImbarcoGate(gt, codaImbarco);
		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getModello().addRow(((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getRow());
		svuotaCampiGateCodeImbarco();
		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).caricaTabella();
	}

	public void eliminaGateCodeImbarco() {
		CodaDiImbarco codaImbarco = new CodaDiImbarco(
				((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getTxtCodaDiImbarco().getText());

		gt = new Gate(codaImbarco, ((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getTxtCodiceGate().getText());

		int t = ((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getTabella().getSelectedRow();
		implementazioneGateDAO().cancellaGate(gt);
		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getModello().removeRow(t);
		svuotaCampiGestioneGate();
		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).caricaTabella();
	}

	public void modificaGateCodeImbarco() {
		CodaDiImbarco codaImbarco = new CodaDiImbarco(
				((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getTxtCodaDiImbarco().getText());

		gt = new Gate(codaImbarco, ((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getTxtCodiceGate().getText());
		int t = ((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getTabella().getSelectedRow();

		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getModello()
				.setValueAt(((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getTxtCodiceGate().getText(), t, 0);
		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getModello()
				.setValueAt(((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getTxtCodaDiImbarco().getText(), t, 1);

		implementazioneGateDAO().modificaGate(gt);
		svuotaCampiGestioneGate();
		((GestioneGate) getDashboard().getGestioneGate()).caricaTabella();
	}

	// METODI DI DASHBOARD

	public void clickPannelloLateraleHome() {
		setPannelloPrecedente(1);
		pannelloLateraleSelezionato();
		mostraPannelli(getDashboard().getHome());
		if (getDashboard().getHome().isVisible()) {
			if (cambioTema()) {
				getDashboard().getPanelHome().setBackground(pannelloSceltoTemaChiaro);
			} else {
				getDashboard().getPanelHome().setBackground(pannelloSceltoTemaScuro);
			}
		}
		chiudiTendinaIstantanea();
	}

	public void clickPannelloLateraleAccedi() {
		setPannelloPrecedente(2);
		pannelloLateraleSelezionato();
		mostraPannelli(getDashboard().getAccesso());
		if (getDashboard().getAccesso().isVisible()) {
			if (cambioTema()) {
				getDashboard().getPanelAccedi().setBackground(pannelloSceltoTemaChiaro);
			} else {
				getDashboard().getPanelAccedi().setBackground(pannelloSceltoTemaScuro);
			}
		}
		chiudiTendinaIstantanea();
	}

	public void clickPannelloLateraleRegistrati() {
		setPannelloPrecedente(3);
		pannelloLateraleSelezionato();
		mostraPannelli(getDashboard().getRegistrazione());
		if (getDashboard().getRegistrazione().isVisible()) {
			if (cambioTema()) {
				getDashboard().getPanelRegistrati().setBackground(pannelloSceltoTemaChiaro);
			} else {
				getDashboard().getPanelRegistrati().setBackground(pannelloSceltoTemaScuro);
			}
		}
		chiudiTendinaIstantanea();
	}

	public void clickPannelloLateraleProfilo() {
		chiudiTendinaIstantanea();
		if (sbloccaGestione()) {
			setPannelloPrecedente(4);
			pannelloLateraleSelezionato();
			mostraPannelli(getDashboard().getProfilo());
			profiloUtenteAccessoEffettuato();

			if (getDashboard().getProfilo().isVisible()) {
				if (cambioTema()) {
					getDashboard().getPanelProfilo().setBackground(pannelloSceltoTemaChiaro);
				} else {
					getDashboard().getPanelProfilo().setBackground(pannelloSceltoTemaScuro);
				}
			}
			chiudiTendinaIstantanea();
		} else {
			mostraSceltaProfiloSenzaAccesso();
		}
	}

	public void clickPannelloLateraleImpostazioni() {
		setPannelloPrecedente(5);
		pannelloLateraleSelezionato();
		mostraPannelli(getDashboard().getImpostazioni());
		if (getDashboard().getImpostazioni().isVisible()) {
			if (cambioTema()) {
				getDashboard().getPanelImpostazioni().setBackground(pannelloSceltoTemaChiaro);
			} else {
				getDashboard().getPanelImpostazioni().setBackground(pannelloSceltoTemaScuro);
			}
		}
		chiudiTendinaIstantanea();
	}

	public void clickPannelloLateraleUscita() {
		pannelloLateraleSelezionato();
		chiudiTendinaIstantanea();

		pannelloLateraleSelezionato();
		mostraUscita();
	}

	public void pannelloLateraleSelezionato() {
		if (cambioTema()) {
			getDashboard().getPanelHome().setBackground(escoPannelloTemaChiaro);
			getDashboard().getPanelAccedi().setBackground(escoPannelloTemaChiaro);
			getDashboard().getPanelRegistrati().setBackground(escoPannelloTemaChiaro);
			getDashboard().getPanelProfilo().setBackground(escoPannelloTemaChiaro);
			getDashboard().getPanelImpostazioni().setBackground(escoPannelloTemaChiaro);
			getDashboard().getPanelUscita().setBackground(escoPannelloTemaChiaro);
		} else {
			getDashboard().getPanelHome().setBackground(escoPannelloTemaScuro);
			getDashboard().getPanelAccedi().setBackground(escoPannelloTemaScuro);
			getDashboard().getPanelRegistrati().setBackground(escoPannelloTemaScuro);
			getDashboard().getPanelProfilo().setBackground(escoPannelloTemaScuro);
			getDashboard().getPanelImpostazioni().setBackground(escoPannelloTemaScuro);
			getDashboard().getPanelUscita().setBackground(escoPannelloTemaScuro);
		}
	}

	public void mostraUtenteLoggato() {
		utn = new Utente(getEmailAccesso());
		getDashboard().getLblAccount().setText(implementazioneUtenteDAO().stampaNomeAccount(utn) + " "
				+ implementazioneUtenteDAO().stampaCognomeAccount(utn));
		getDashboard().getLblAccount().setBounds(890, 7, 140, 23);
	}

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
			pannelloPrecedentementeSelezionato(pannelloPrecedente);
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
	
	public JPanel gateCodeImbarco() {
		GateCodeImbarco gateCodeImbarco = new GateCodeImbarco(this);
		return gateCodeImbarco;
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
	
	public JDialog sceltaGate() {
		SceltaGate sceltaGate = new SceltaGate(this);
		return sceltaGate;
	}
	
	public JDialog sceltaProfiloSenzaAccesso() {
		SceltaProfiloSenzaAccesso sceltaProfiloSenzaAccesso = new SceltaProfiloSenzaAccesso(this);
		return sceltaProfiloSenzaAccesso;
	}

	public JDialog registrazioneEffettuataConSuccesso() {
		RegistrazioneEffettuataConSuccesso registrazioneEffettuataConSuccesso = new RegistrazioneEffettuataConSuccesso(
				this);
		return registrazioneEffettuataConSuccesso;
	}

	public JDialog passwordDimenticata() {
		PasswordDimenticata passwordDimenticata = new PasswordDimenticata(this);
		return passwordDimenticata;
	}

	public JPanel recensione() {
		Recensione recensioni = new Recensione(this);
		return recensioni;
	}

	public JPanel noClick() {
		NoClick noClick = new NoClick(this);
		return noClick;
	}

	public JDialog informazioni() {
		Informazioni informazioni = new Informazioni(this);
		return informazioni;
	}

	public JDialog terminiECondizioni() {
		TerminiECondizioni terminiECondizioni = new TerminiECondizioni(this);
		return terminiECondizioni;
	}

	public JDialog uscita() {
		Uscita uscita = new Uscita(this);
		return uscita;
	}

	public void mostraPannelli(JPanel pane) {
		((Home) getDashboard().getHome()).getLblFareAccesso().setText("");
		((Accesso) getDashboard().getAccesso()).getLblMessaggioCredenziali().setText("");
		((Accesso) getDashboard().getAccesso()).getLblMostraPassword().setVisible(true);
		((Registrazione) getDashboard().getRegistrazione()).getLblMessaggioCredenziali().setText("");
		((Registrazione) getDashboard().getRegistrazione()).getLblMostraPassword().setVisible(true);
		((Registrazione) getDashboard().getRegistrazione()).getLblMostraRipetiPassword().setVisible(true);
		getDashboard().getHome().setVisible(false);
		getDashboard().getAccesso().setVisible(false);
		svuotaCampiAccesso();
		getDashboard().getRegistrazione().setVisible(false);
		svuotaCampiRegistrazione();
		getDashboard().getProfilo().setVisible(false);
		getDashboard().getImpostazioni().setVisible(false);
		getDashboard().getGestioneCompagnieAeree().setVisible(false);
		svuotaCampiGestioneCompagniaAerea();
		getDashboard().getGestioneUtenti().setVisible(false);
		svuotaCampiGestioneUtenti();
		getDashboard().getGestioneGate().setVisible(false);
		svuotaCampiGestioneGate();
		getDashboard().getGateCodeImbarco().setVisible(false);
		getDashboard().getGestioneTratte().setVisible(false);
		svuotaCampiGestioneTratta();
		getDashboard().getGestioneVoliPartenze().setVisible(false);
		svuotaCampiGestioneVoloPartenze();
		getDashboard().getGestioneVoliArrivi().setVisible(false);
		svuotaCampiGestioneVoloArrivi();
		getDashboard().getCambioPassword().setVisible(false);
		svuotaCampiCambioPassword();
		((CambioPassword) getDashboard().getCambioPassword()).getLblMostraNuovaPassword().setVisible(true);
		((CambioPassword) getDashboard().getCambioPassword()).getLblMostraRipetiNuovaPassword().setVisible(true);
		svuotaCampiCambioPassword();
		getDashboard().getRecensioni().setVisible(false);
		getDashboard().getNoClick().setVisible(false);
		pane.setVisible(true);
	}

	// METODI DI SCELTA PROFILO SENZA ACCESSO
	public void mostraSceltaProfiloSenzaAccesso() {
		svuotaCampiAccesso();
		svuotaCampiRegistrazione();
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
		pannelloPrecedentementeSelezionato(getPannelloPrecedente());
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
		pannelloPrecedentementeSelezionato(getPannelloPrecedente());
	}
	
	// METODI SCELTA GATE

		public void mostraSceltaGate() {
			getDashboard().setEnabled(false);
			getDashboard().getSceltaGate().setVisible(true);
		}

		public void vaiAGateDaSceltaGate() {
			getDashboard().getSceltaGate().dispose();
			getDashboard().setEnabled(true);
			getDashboard().setVisible(true);
			mostraPannelli(getDashboard().getGestioneGate());
		}

		public void vaiAGateCodeImbarcoDaSceltaVolo() {
			getDashboard().getSceltaGate().dispose();
			getDashboard().setEnabled(true);
			getDashboard().setVisible(true);
			mostraPannelli(getDashboard().getGateCodeImbarco());
		}

		public void annullaSceltaGate() {
			getDashboard().getSceltaGate().dispose();
			getDashboard().setEnabled(true);
			getDashboard().setVisible(true);
			pannelloPrecedentementeSelezionato(getPannelloPrecedente());
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

	public void entraInGestioneUtenti() {
		if (sbloccaGestione()) {
			setPannelloPrecedente(8);
			mostraPannelli(getDashboard().getGestioneUtenti());
		}
	}

	public void profiloUtenteAccessoEffettuato() {
		utn = new Utente(getEmailAccesso());
		((Profilo) getDashboard().getProfilo()).getTxtNome().setText(implementazioneUtenteDAO().stampaNomeAccount(utn));
		((Profilo) getDashboard().getProfilo()).getTxtCognome()
				.setText(implementazioneUtenteDAO().stampaCognomeAccount(utn));
		((Profilo) getDashboard().getProfilo()).getTxtEmail()
				.setText(implementazioneUtenteDAO().stampaEmailAccount(utn));
	}

	public void logout() {
		getDashboard().getLblAccount().setBounds(814, 7, 216, 23);
		getDashboard().getLblAccount().setText("Nessun utente ha effettuato l'accesso");
		entraGestioneUtenti = false;
		((Profilo) getDashboard().getProfilo()).getLblGestioneUtenti().setText("");
		((Profilo) getDashboard().getProfilo()).getLblGestioneUtenti().setEnabled(false);
		((Accesso) getDashboard().getAccesso()).setSbloccaHome(false);
		mostraPannelli(getDashboard().getAccesso());
	}

	// METODI DI CAMBIO PASSWORD

	public void svuotaCampiCambioPassword() {
		((CambioPassword) getDashboard().getCambioPassword()).getTxtVecchiaPassword().setText("");
		((CambioPassword) getDashboard().getCambioPassword()).getTxtNuovaPassword().setText("");
		((CambioPassword) getDashboard().getCambioPassword()).getTxtRipetiNuovaPassword().setText("");
	}

	public void cambioPasswordDaProfilo() {
		utn = new Utente(emailAccesso,
				((CambioPassword) getDashboard().getCambioPassword()).getTxtNuovaPassword().getText());

		if (passwordVecchiaUgualeAllaNuova() && ripetiCambioPassword()) {

			implementazioneUtenteDAO().cambioPasswordDB(utn);
			logout();
			mostraPannelli(getDashboard().getAccesso());

			((GestioneUtenti) getDashboard().getGestioneUtenti()).caricaTabella();
		}
	}

	public boolean passwordVecchiaUgualeAllaNuova() {
		if (((CambioPassword) getDashboard().getCambioPassword()).getTxtVecchiaPassword().getText()
				.equals(passwordAccesso)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean ripetiCambioPassword() {
		if (((CambioPassword) getDashboard().getCambioPassword()).getTxtNuovaPassword().getText()
				.equals(((CambioPassword) getDashboard().getCambioPassword()).getTxtRipetiNuovaPassword().getText())) {
			return true;
		} else {
			return false;
		}
	}

	// METODI PASSWORD DIMENTICATA
	public void svuotaCampiPasswordDimenticata() {
		((PasswordDimenticata) getDashboard().getPasswordDimenticata()).getTxtEmail().setText("");
		((PasswordDimenticata) getDashboard().getPasswordDimenticata()).getTxtNuovaPassword().setText("");
		((PasswordDimenticata) getDashboard().getPasswordDimenticata()).getTxtRipetiNuovaPassword().setText("");
	}

	public void mostraPasswordDimenticata() {
		svuotaCampiAccesso();
		svuotaCampiCambioPassword();
		getDashboard().setEnabled(false);
		getDashboard().getPasswordDimenticata().setVisible(true);
		((PasswordDimenticata) getDashboard().getPasswordDimenticata()).getLblMostraNuovaPassword().setVisible(true);
		((PasswordDimenticata) getDashboard().getPasswordDimenticata()).getLblMostraRipetiNuovaPassword()
				.setVisible(true);
		svuotaCampiPasswordDimenticata();
	}

	public void accessoPasswordDimenticata() {
		Utente utn = new Utente(((PasswordDimenticata) getDashboard().getPasswordDimenticata()).getTxtEmail().getText(),
				((PasswordDimenticata) getDashboard().getPasswordDimenticata()).getTxtNuovaPassword().getText());
		String email = ((PasswordDimenticata) getDashboard().getPasswordDimenticata()).getTxtEmail().getText();

		if (ripetiPasswordDimenticata() && implementazioneUtenteDAO().esisteEmail(email)
				&& !(controlloCampiSeVuotiPasswordDimenticata())) {
			implementazioneUtenteDAO().passwordDimenticata(utn);
			mostraPannelli(getDashboard().getAccesso());
			getDashboard().getPasswordDimenticata().dispose();
			getDashboard().setEnabled(true);
			getDashboard().setVisible(true);
			((GestioneUtenti) getDashboard().getGestioneUtenti()).caricaTabella();
		} else if (!ripetiPasswordDimenticata() && implementazioneUtenteDAO().esisteEmail(email)
				&& !(controlloCampiSeVuotiPasswordDimenticata())) {
			((PasswordDimenticata) getDashboard().getPasswordDimenticata()).getLblMessaggioCredenziali()
					.setText("Le passwords non corrispondono.");
		} else if (ripetiPasswordDimenticata()
				&& (implementazioneUtenteDAO().esisteEmail(email) && controlloCampiSeVuotiPasswordDimenticata())) {
			((PasswordDimenticata) getDashboard().getPasswordDimenticata()).getLblMessaggioCredenziali()
					.setText("Inserire i campi vuoti.");
		} else {
			((PasswordDimenticata) getDashboard().getPasswordDimenticata()).getLblMessaggioCredenziali()
					.setText("L'email non esiste.");
		}
	}

	public boolean controlloCampiSeVuotiPasswordDimenticata() {
		if (((PasswordDimenticata) getDashboard().getPasswordDimenticata()).getTxtEmail().getText().length() <= 0
				|| ((PasswordDimenticata) getDashboard().getPasswordDimenticata()).getTxtNuovaPassword().getText()
						.length() <= 0
				|| ((PasswordDimenticata) getDashboard().getPasswordDimenticata()).getTxtRipetiNuovaPassword().getText()
						.length() <= 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean ripetiPasswordDimenticata() {
		if (((PasswordDimenticata) getDashboard().getPasswordDimenticata()).getTxtNuovaPassword().getText()
				.equals(((PasswordDimenticata) getDashboard().getPasswordDimenticata()).getTxtRipetiNuovaPassword()
						.getText())) {
			return true;
		} else {
			return false;
		}
	}

	public void annullaPasswordDimenticata() {
		getDashboard().getPasswordDimenticata().dispose();
		getDashboard().setEnabled(true);
		getDashboard().setVisible(true);
		pannelloPrecedentementeSelezionato(getPannelloPrecedente());
	}

	// METODI DI REGISTRAZIONE EFFETTUATA CON SUCCESSO

	public void mostraRegistrazioneEffettuataConSuccesso() {
		dashboard.setEnabled(false);
		dashboard.getRegistrazioneEffettuataConSuccesso().setVisible(true);
	}

	public void fineRegistrazioneEffettuataConSuccesso() {
		dashboard.getRegistrazioneEffettuataConSuccesso().dispose();
		getDashboard().setEnabled(true);
		getDashboard().setVisible(true);
	}

	// TERMINI E CONDIZIONI
	public void mostraTerminiECondizioni() {
		getDashboard().setEnabled(false);
		getDashboard().getTerminiECondizioni().setVisible(true);
	}

	public void annullaTerminiECondizioni() {
		getDashboard().getTerminiECondizioni().dispose();
		getDashboard().setEnabled(true);
		getDashboard().setVisible(true);
		pannelloPrecedentementeSelezionato(getPannelloPrecedente());
	}

	// INFORMAZIONI
	public void mostraInformazioni() {
		getDashboard().setEnabled(false);
		getDashboard().getInformazioni().setVisible(true);
	}

	public void annullaInformazioni() {
		getDashboard().getInformazioni().dispose();
		getDashboard().setEnabled(true);
		getDashboard().setVisible(true);
		pannelloPrecedentementeSelezionato(getPannelloPrecedente());
	}

	// METODI DI USCITA

	public void mostraUscita() {
		svuotaCampiAccesso();
		svuotaCampiRegistrazione();
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
		pannelloPrecedentementeSelezionato(getPannelloPrecedente());
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

	// METODI DI NOCLICK

	public void pannelloPrecedentementeSelezionato(int PanelSelected) {
		int selezionePannello = PanelSelected;

		if (selezionePannello == 1) {
			mostraPannelli(getDashboard().getHome());
		} else if (selezionePannello == 2) {
			mostraPannelli(getDashboard().getAccesso());
		} else if (selezionePannello == 3) {
			mostraPannelli(getDashboard().getRegistrazione());
		} else if (selezionePannello == 4) {
			mostraPannelli(getDashboard().getProfilo());
		} else if (selezionePannello == 5) {
			mostraPannelli(getDashboard().getImpostazioni());
		} else if (selezionePannello == 6) {
			mostraPannelli(getDashboard().getGestioneTratte());
		} else if (selezionePannello == 7) {
			mostraPannelli(getDashboard().getGestioneCompagnieAeree());
		} else if (selezionePannello == 8) {
			mostraPannelli(getDashboard().getGestioneUtenti());
		} else if (selezionePannello == 9) {
			mostraPannelli(getDashboard().getGestioneUtenti());
		} else if (selezionePannello == 10) {
			mostraPannelli(getDashboard().getGestioneGate());
		} else if (selezionePannello == 11) {
			mostraPannelli(getDashboard().getGestioneVoliPartenze());
		} else if (selezionePannello == 12) {
			mostraPannelli(getDashboard().getGestioneVoliArrivi());
		} else if (selezionePannello == 13) {
			mostraPannelli(getDashboard().getGestioneGate());
		} else if (selezionePannello == 14) {
			mostraPannelli(getDashboard().getGateCodeImbarco());
		}else {
			mostraPannelli(getDashboard().getHome());
		}

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

		SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy  HH:mm:ss");
		Date dataCorrente = new Date(System.currentTimeMillis());
		formatoData.format(dataCorrente);

		int annoTeorico = ((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getDateDataPartenza()
				.getDate().getYear();
		int meseTeorico = ((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getDateDataPartenza()
				.getDate().getMonth();
		int giornoTeorico = ((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getDateDataPartenza()
				.getDate().getDate();
		int oraTeorica = Integer.parseInt(
				((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtOraPartenza().getText());
		int minutoTeorico = Integer.parseInt(
				((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtMinutoPartenza().getText());

		int annoEffettivo = dataCorrente.getYear();
		int meseEffettivo = dataCorrente.getMonth();
		int giornoEffettivo = dataCorrente.getDate();
		int oraEffettiva = (int) dataCorrente.getHours();
		int minutoEffettivo = dataCorrente.getMinutes();

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

	public boolean cambioTema() {
		if (flagCambioTema == 1) {
			return true;
		} else {
			return false;
		}
	}

	public void temaChiaro() {
		flagCambioTema = 1;

		getDashboard().getLblCambioTemaChiaro().setVisible(false);
		getDashboard().getLblCambioTemaScuro().setVisible(true);
		getDashboard().getLblLayout().setIcon(new ImageIcon(img.sfondoTemaChiaro()));
		getDashboard().getLblTendina().setIcon(new ImageIcon(img.tendinaTemaChiaro()));
		getDashboard().getLblTitolo().setForeground(coloreScritteTendinaTemaChiaro);
		getDashboard().getLblSpostaDashboard().setIcon(new ImageIcon(img.spostaDashboardTemaChiaro()));
		getDashboard().getLblX().setIcon(new ImageIcon(img.X1TemaChiaro()));
		getDashboard().getLblMinimizza().setIcon(new ImageIcon(img.minimizza1TemaChiaro()));
		getDashboard().getLblAccount().setForeground(coloreScritteTendinaTemaChiaro);

		getDashboard().getPannelloTendina().setBackground(trasparente);
		getDashboard().getLineeApertura().setIcon(new ImageIcon(img.lineeApertura1TemaChiaro()));
		getDashboard().getLineeChiusura().setIcon(new ImageIcon(img.lineeChiusura1TemaChiaro()));
		getDashboard().getLblHome().setIcon(new ImageIcon(img.casaTemaChiaro()));
		getDashboard().getLblAccesso().setIcon(new ImageIcon(img.accediTemaChiaro()));
		getDashboard().getLblRegistrazione().setIcon(new ImageIcon(img.registratiTemaChiaro()));
		getDashboard().getLblProfilo().setIcon(new ImageIcon(img.profiloTemaChiaro()));
		getDashboard().getLblImpostazioni().setIcon(new ImageIcon(img.impostazioniTemaChiaro()));
		getDashboard().getLblEsci().setIcon(new ImageIcon(img.esciTemaChiaro()));

		getDashboard().getLblScrittaHome().setForeground(coloreScritteTendinaTemaChiaro);
		getDashboard().getLblScrittaAccesso().setForeground(coloreScritteTendinaTemaChiaro);
		getDashboard().getLblScrittaRegistrazione().setForeground(coloreScritteTendinaTemaChiaro);
		getDashboard().getLblScrittaProfilo().setForeground(coloreScritteTendinaTemaChiaro);
		getDashboard().getLblScrittaImpostazioni().setForeground(coloreScritteTendinaTemaChiaro);
		getDashboard().getLblScrittaEsci().setForeground(coloreScritteTendinaTemaChiaro);

		getDashboard().getPanelHome().setBackground(escoPannelloTemaChiaro);
		getDashboard().getPanelAccedi().setBackground(escoPannelloTemaChiaro);
		getDashboard().getPanelRegistrati().setBackground(escoPannelloTemaChiaro);
		getDashboard().getPanelProfilo().setBackground(escoPannelloTemaChiaro);
		getDashboard().getPanelImpostazioni().setBackground(escoPannelloTemaChiaro);
		getDashboard().getPanelUscita().setBackground(escoPannelloTemaChiaro);

		// NO CLICK
		getDashboard().getNoClick().setBackground(trasparente);

		// HOME
		getDashboard().getHome().setBackground(sfondoTemaChiaro);

		// ACCESSO
		getDashboard().getAccesso().setBackground(sfondoTemaChiaro);
		((Accesso) getDashboard().getAccesso()).getTxtEmail().setBackground(sfondoTemaChiaro);
		((Accesso) getDashboard().getAccesso()).getTxtEmail().setForeground(coloreScritteTemaChiaro);
		((Accesso) getDashboard().getAccesso()).getTxtPassword().setBackground(sfondoTemaChiaro);
		((Accesso) getDashboard().getAccesso()).getTxtPassword().setForeground(coloreScritteTemaChiaro);
		((Accesso) getDashboard().getAccesso()).getLblPasswordDimenticata().setForeground(coloreLabelTemaChiaro);
		((Accesso) getDashboard().getAccesso()).getLblAvanti().setIcon(new ImageIcon(img.avanti1TemaChiaro()));
		((Accesso) getDashboard().getAccesso()).getLblCredenziali()
				.setIcon(new ImageIcon(img.credenzialiAccessoTemaChiaro()));

		// REGISTRAZIONE
		getDashboard().getRegistrazione().setBackground(sfondoTemaChiaro);
		((Registrazione) getDashboard().getRegistrazione()).getTxtNome().setBackground(sfondoTemaChiaro);
		((Registrazione) getDashboard().getRegistrazione()).getTxtNome().setForeground(coloreScritteTemaChiaro);
		((Registrazione) getDashboard().getRegistrazione()).getTxtCognome().setBackground(sfondoTemaChiaro);
		((Registrazione) getDashboard().getRegistrazione()).getTxtCognome().setForeground(coloreScritteTemaChiaro);
		((Registrazione) getDashboard().getRegistrazione()).getTxtEmail().setBackground(sfondoTemaChiaro);
		((Registrazione) getDashboard().getRegistrazione()).getTxtEmail().setForeground(coloreScritteTemaChiaro);
		((Registrazione) getDashboard().getRegistrazione()).getTxtPassword().setBackground(sfondoTemaChiaro);
		((Registrazione) getDashboard().getRegistrazione()).getTxtPassword().setForeground(coloreScritteTemaChiaro);
		((Registrazione) getDashboard().getRegistrazione()).getTxtRipetiPassword().setBackground(sfondoTemaChiaro);
		((Registrazione) getDashboard().getRegistrazione()).getTxtRipetiPassword()
				.setForeground(coloreScritteTemaChiaro);
		((Registrazione) getDashboard().getRegistrazione()).getLblAvanti()
				.setIcon(new ImageIcon(img.avanti1TemaChiaro()));
		((Registrazione) getDashboard().getRegistrazione()).getLblInserimentoCredenziali()
				.setIcon(new ImageIcon(img.credenzialiRegistrazioneTemaChiaro()));

		// PROFILO
		getDashboard().getProfilo().setBackground(sfondoTemaChiaro);
		((Profilo) getDashboard().getProfilo()).getTxtNome().setBackground(sfondoTemaChiaro);
		((Profilo) getDashboard().getProfilo()).getTxtNome().setForeground(coloreScritteTemaChiaro);
		((Profilo) getDashboard().getProfilo()).getTxtCognome().setBackground(sfondoTemaChiaro);
		((Profilo) getDashboard().getProfilo()).getTxtCognome().setForeground(coloreScritteTemaChiaro);
		((Profilo) getDashboard().getProfilo()).getTxtEmail().setBackground(sfondoTemaChiaro);
		((Profilo) getDashboard().getProfilo()).getTxtEmail().setForeground(coloreScritteTemaChiaro);
		((Profilo) getDashboard().getProfilo()).getLblLogout().setForeground(coloreLabelTemaChiaro);
		((Profilo) getDashboard().getProfilo()).getLblCambiaPassword().setForeground(coloreLabelTemaChiaro);
		((Profilo) getDashboard().getProfilo()).getLblDatiAccount().setIcon(new ImageIcon(img.datiProfiloTemaChiaro()));

		// IMPOSTAZIONI
		getDashboard().getImpostazioni().setBackground(sfondoTemaChiaro);
		((Impostazioni) getDashboard().getImpostazioni()).getLblInformazioni().setForeground(coloreLabelTemaChiaro);
		((Impostazioni) getDashboard().getImpostazioni()).getLblTerminiECondizioni()
				.setForeground(coloreLabelTemaChiaro);
		((Impostazioni) getDashboard().getImpostazioni()).getLblRecensione().setForeground(coloreLabelTemaChiaro);

		// GESTIONE TRATTA
		getDashboard().getGestioneTratte().setBackground(sfondoTemaChiaro);
		((GestioneTratte) getDashboard().getGestioneTratte()).getLblCodiceTratta().setForeground(coloreLabelTemaChiaro);
		((GestioneTratte) getDashboard().getGestioneTratte()).getLblCittaPartenza()
				.setForeground(coloreLabelTemaChiaro);
		((GestioneTratte) getDashboard().getGestioneTratte()).getLblCittaArrivo().setForeground(coloreLabelTemaChiaro);

		((GestioneTratte) getDashboard().getGestioneTratte()).getTxtCodiceTratta()
				.setForeground(coloreScritteTemaChiaro);
		((GestioneTratte) getDashboard().getGestioneTratte()).getTxtCittaPartenza()
				.setForeground(coloreScritteTemaChiaro);
		((GestioneTratte) getDashboard().getGestioneTratte()).getTxtCittaArrivo()
				.setForeground(coloreScritteTemaChiaro);

		// GESTIONE COMPAGNIE AEREE
		getDashboard().getGestioneCompagnieAeree().setBackground(sfondoTemaChiaro);
		((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).getLblCodiceCompagniaAerea()
				.setForeground(coloreLabelTemaChiaro);
		((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).getLblNome()
				.setForeground(coloreLabelTemaChiaro);
		((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).getTxtCodiceCompagniaAerea()
				.setForeground(coloreScritteTemaChiaro);

		((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).getTxtNome()
				.setForeground(coloreScritteTemaChiaro);

		// GESTIONE UTENTI
		getDashboard().getGestioneUtenti().setBackground(sfondoTemaChiaro);
		((GestioneUtenti) getDashboard().getGestioneUtenti()).getLblNome().setForeground(coloreLabelTemaChiaro);
		((GestioneUtenti) getDashboard().getGestioneUtenti()).getLblCognome().setForeground(coloreLabelTemaChiaro);
		((GestioneUtenti) getDashboard().getGestioneUtenti()).getLblEmail().setForeground(coloreLabelTemaChiaro);
		((GestioneUtenti) getDashboard().getGestioneUtenti()).getLblPassword().setForeground(coloreLabelTemaChiaro);

		((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtNome().setForeground(coloreScritteTemaChiaro);
		((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtCognome().setForeground(coloreScritteTemaChiaro);
		((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtEmail().setForeground(coloreScritteTemaChiaro);
		((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtPassword().setForeground(coloreScritteTemaChiaro);

		// GESTIONE VOLI PARTENZE
		getDashboard().getGestioneVoliPartenze().setBackground(sfondoTemaChiaro);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getLblCodiceVoloPartenze()
				.setForeground(coloreLabelTemaChiaro);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getLblDataPartenza()
				.setForeground(coloreLabelTemaChiaro);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getLblOraPartenza()
				.setForeground(coloreLabelTemaChiaro);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getLblDuePuntiPartenza()
				.setForeground(coloreLabelTemaChiaro);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getLblNumeroPrenoazioni()
				.setForeground(coloreLabelTemaChiaro);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getLblRitardo()
				.setForeground(coloreLabelTemaChiaro);

		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtCodiceVoloPartenze()
				.setForeground(coloreScritteTemaChiaro);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getDateDataPartenza()
				.setForeground(coloreScritteTemaChiaro);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtOraPartenza()
				.setForeground(coloreScritteTemaChiaro);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtMinutoPartenza()
				.setForeground(coloreScritteTemaChiaro);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtNumeroPrenotazioni()
				.setForeground(coloreScritteTemaChiaro);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtRitardo()
				.setForeground(coloreScritteTemaChiaro);

		// GESTIONE VOLO ARRIVI
		getDashboard().getGestioneVoliArrivi().setBackground(sfondoTemaChiaro);
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getLblCodiceVoloArrivi()
				.setForeground(coloreLabelTemaChiaro);
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getLblCittaPartenza()
				.setForeground(coloreLabelTemaChiaro);
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getLblDataArrivo()
				.setForeground(coloreLabelTemaChiaro);
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getLblOraArrivo()
				.setForeground(coloreLabelTemaChiaro);
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getLblDuePuntiArrivo()
				.setForeground(coloreLabelTemaChiaro);

		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTxtCodiceVoloArrivi()
				.setForeground(coloreScritteTemaChiaro);
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTxtCittaPartenza()
				.setForeground(coloreScritteTemaChiaro);
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getDateDataArrivo()
				.setForeground(coloreScritteTemaChiaro);
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTxtOraArrivo()
				.setForeground(coloreScritteTemaChiaro);
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTxtMinutoArrivo()
				.setForeground(coloreScritteTemaChiaro);

		// GESTIONE GATE
		getDashboard().getGestioneGate().setBackground(sfondoTemaChiaro);
		((GestioneGate) getDashboard().getGestioneGate()).getLblCodiceGate().setForeground(coloreLabelTemaChiaro);
		((GestioneGate) getDashboard().getGestioneGate()).getLblNumeroPorta().setForeground(coloreLabelTemaChiaro);
		((GestioneGate) getDashboard().getGestioneGate()).getLblTempoImbarcoStimato().setForeground(coloreLabelTemaChiaro);

		((GestioneGate) getDashboard().getGestioneGate()).getTxtCodiceGate().setForeground(coloreScritteTemaChiaro);
		((GestioneGate) getDashboard().getGestioneGate()).getTxtNumeroPorta().setForeground(coloreScritteTemaChiaro);
		((GestioneGate) getDashboard().getGestioneGate()).getTxtTempoImbarcoStimato().setForeground(coloreScritteTemaChiaro);

		// RECENSIONE
		getDashboard().getRecensioni().setBackground(sfondoTemaChiaro);

		// CAMBIO PASSWORD
		getDashboard().getCambioPassword().setBackground(sfondoTemaChiaro);

		// JDIALOG USCITA
		((Uscita) getDashboard().getUscita()).getLblLayout().setIcon(new ImageIcon(img.sfondoUscitaTemaChiaro()));
		((Uscita) getDashboard().getUscita()).getLblSpostaUscita().setIcon(new ImageIcon(img.spostaUscitaTemaChiaro()));
		((Uscita) getDashboard().getUscita()).getLblX().setIcon(new ImageIcon(img.X1TemaChiaro()));
		((Uscita) getDashboard().getUscita()).getLblUscire().setForeground(coloreScritteTemaChiaro);

		// PASSWORD DIMENTICATA
		((PasswordDimenticata) getDashboard().getPasswordDimenticata()).getLblLayout()
				.setIcon(new ImageIcon(img.sfondoPasswordDimenticataTemaChiaro()));
		((PasswordDimenticata) getDashboard().getPasswordDimenticata()).getLblSpostaPasswordDimenticata()
				.setIcon(new ImageIcon(img.spostaUscitaTemaChiaro()));
		((PasswordDimenticata) getDashboard().getPasswordDimenticata()).getLblX()
				.setIcon(new ImageIcon(img.X1TemaChiaro()));

		((PasswordDimenticata) getDashboard().getPasswordDimenticata()).getLblCampi()
				.setIcon(new ImageIcon(img.credenzialiPasswordDimenticataTemaChiaro()));
		((PasswordDimenticata) getDashboard().getPasswordDimenticata()).getLblSalva()
				.setIcon(new ImageIcon(img.salva1TemaChiaro()));

		((PasswordDimenticata) getDashboard().getPasswordDimenticata()).getTxtEmail().setBackground(sfondoTemaChiaro);
		((PasswordDimenticata) getDashboard().getPasswordDimenticata()).getTxtEmail()
				.setForeground(coloreScritteTemaChiaro);
		((PasswordDimenticata) getDashboard().getPasswordDimenticata()).getTxtNuovaPassword()
				.setBackground(sfondoTemaChiaro);
		((PasswordDimenticata) getDashboard().getPasswordDimenticata()).getTxtNuovaPassword()
				.setForeground(coloreScritteTemaChiaro);
		((PasswordDimenticata) getDashboard().getPasswordDimenticata()).getTxtRipetiNuovaPassword()
				.setBackground(sfondoTemaChiaro);
		((PasswordDimenticata) getDashboard().getPasswordDimenticata()).getTxtRipetiNuovaPassword()
				.setForeground(coloreScritteTemaChiaro);

		// JDIALOG SCELTA PROFILO SENZA ACCESSO
		((SceltaProfiloSenzaAccesso) getDashboard().getSceltaProfiloSenzaAccesso()).getLblLayout()
				.setIcon(new ImageIcon(img.sfondoUscitaTemaChiaro()));
		((SceltaProfiloSenzaAccesso) getDashboard().getSceltaProfiloSenzaAccesso())
				.getLblSpostaSceltaProfiloSenzaAccesso().setIcon(new ImageIcon(img.spostaUscitaTemaChiaro()));
		((SceltaProfiloSenzaAccesso) getDashboard().getSceltaProfiloSenzaAccesso()).getLblX()
				.setIcon(new ImageIcon(img.X1TemaChiaro()));
		((SceltaProfiloSenzaAccesso) getDashboard().getSceltaProfiloSenzaAccesso()).getLblContinuare()
				.setForeground(coloreLabelTemaChiaro);

		// JDIALOG SCELTA VOLI
		((SceltaVolo) getDashboard().getSceltaVolo()).getLblLayout()
				.setIcon(new ImageIcon(img.sfondoUscitaTemaChiaro()));
		((SceltaVolo) getDashboard().getSceltaVolo()).getLblSpostaSceltaVolo()
				.setIcon(new ImageIcon(img.spostaUscitaTemaChiaro()));
		((SceltaVolo) getDashboard().getSceltaVolo()).getLblX().setIcon(new ImageIcon(img.X1TemaChiaro()));

		pannelloPrecedentementeSelezionato(getPannelloPrecedente());
	}

	public void temaScuro() {
		flagCambioTema = 0;

		getDashboard().getLblCambioTemaScuro().setVisible(false);
		getDashboard().getLblCambioTemaChiaro().setVisible(true);
		getDashboard().getLblLayout().setIcon(new ImageIcon(img.sfondo()));
		getDashboard().getLblTendina().setIcon(new ImageIcon(img.tendina()));
		getDashboard().getLblTitolo().setForeground(coloreBianco);
		getDashboard().getLblSpostaDashboard().setIcon(new ImageIcon(img.spostaDashboard()));
		getDashboard().getLblX().setIcon(new ImageIcon(img.X1()));
		getDashboard().getLblMinimizza().setIcon(new ImageIcon(img.minimizza1()));
		getDashboard().getLblAccount().setForeground(coloreBianco);

		getDashboard().getPannelloTendina().setBackground(trasparente);
		getDashboard().getLineeApertura().setIcon(new ImageIcon(img.lineeApertura1()));
		getDashboard().getLineeChiusura().setIcon(new ImageIcon(img.lineeChiusura1()));
		getDashboard().getLblHome().setIcon(new ImageIcon(img.casa()));
		getDashboard().getLblAccesso().setIcon(new ImageIcon(img.accedi()));
		getDashboard().getLblRegistrazione().setIcon(new ImageIcon(img.registrati()));
		getDashboard().getLblProfilo().setIcon(new ImageIcon(img.profilo()));
		getDashboard().getLblImpostazioni().setIcon(new ImageIcon(img.impostazioni()));
		getDashboard().getLblEsci().setIcon(new ImageIcon(img.esci()));

		getDashboard().getLblScrittaHome().setForeground(coloreScritteTemaScuro);
		getDashboard().getLblScrittaAccesso().setForeground(coloreScritteTemaScuro);
		getDashboard().getLblScrittaRegistrazione().setForeground(coloreScritteTemaScuro);
		getDashboard().getLblScrittaProfilo().setForeground(coloreScritteTemaScuro);
		getDashboard().getLblScrittaImpostazioni().setForeground(coloreScritteTemaScuro);
		getDashboard().getLblScrittaEsci().setForeground(coloreScritteTemaScuro);

		getDashboard().getPanelHome().setBackground(escoPannelloTemaScuro);
		getDashboard().getPanelAccedi().setBackground(escoPannelloTemaScuro);
		getDashboard().getPanelRegistrati().setBackground(escoPannelloTemaScuro);
		getDashboard().getPanelProfilo().setBackground(escoPannelloTemaScuro);
		getDashboard().getPanelImpostazioni().setBackground(escoPannelloTemaScuro);
		getDashboard().getPanelUscita().setBackground(escoPannelloTemaScuro);

		// NO CLICK
		getDashboard().getNoClick().setBackground(trasparente);

		// HOME
		getDashboard().getHome().setBackground(sfondoTemaScuro);
		// ACCESSO
		getDashboard().getAccesso().setBackground(sfondoTemaScuro);
		((Accesso) getDashboard().getAccesso()).getTxtEmail().setBackground(sfondoTemaScuro);
		((Accesso) getDashboard().getAccesso()).getTxtEmail().setForeground(coloreScritteTemaScuro);
		((Accesso) getDashboard().getAccesso()).getTxtPassword().setBackground(sfondoTemaScuro);
		((Accesso) getDashboard().getAccesso()).getTxtPassword().setForeground(coloreScritteTemaScuro);
		((Accesso) getDashboard().getAccesso()).getLblPasswordDimenticata().setForeground(coloreScritteTemaScuro);
		((Accesso) getDashboard().getAccesso()).getLblAvanti().setIcon(new ImageIcon(img.avanti1()));
		((Accesso) getDashboard().getAccesso()).getLblCredenziali().setIcon(new ImageIcon(img.credenzialiAccesso()));

		// REGISTRAZIONE
		getDashboard().getRegistrazione().setBackground(sfondoTemaScuro);
		((Registrazione) getDashboard().getRegistrazione()).getTxtNome().setForeground(coloreScritteTemaScuro);
		((Registrazione) getDashboard().getRegistrazione()).getTxtCognome().setForeground(coloreScritteTemaScuro);
		((Registrazione) getDashboard().getRegistrazione()).getTxtEmail().setForeground(coloreScritteTemaScuro);
		((Registrazione) getDashboard().getRegistrazione()).getTxtPassword().setForeground(coloreScritteTemaScuro);
		((Registrazione) getDashboard().getRegistrazione()).getTxtRipetiPassword()
				.setForeground(coloreScritteTemaScuro);

		((Registrazione) getDashboard().getRegistrazione()).getTxtNome().setBackground(sfondoTemaScuro);
		((Registrazione) getDashboard().getRegistrazione()).getTxtCognome().setBackground(sfondoTemaScuro);
		((Registrazione) getDashboard().getRegistrazione()).getTxtEmail().setBackground(sfondoTemaScuro);
		((Registrazione) getDashboard().getRegistrazione()).getTxtPassword().setBackground(sfondoTemaScuro);
		((Registrazione) getDashboard().getRegistrazione()).getTxtRipetiPassword().setBackground(sfondoTemaScuro);

		((Registrazione) getDashboard().getRegistrazione()).getLblAvanti().setIcon(new ImageIcon(img.avanti1()));
		((Registrazione) getDashboard().getRegistrazione()).getLblInserimentoCredenziali()
				.setIcon(new ImageIcon(img.credenzialiRegistrazione()));

		// PROFILO
		getDashboard().getProfilo().setBackground(sfondoTemaScuro);
		((Profilo) getDashboard().getProfilo()).getLblLogout().setForeground(coloreScritteTemaScuro);
		((Profilo) getDashboard().getProfilo()).getLblCambiaPassword().setForeground(coloreScritteTemaScuro);

		((Profilo) getDashboard().getProfilo()).getTxtNome().setBackground(sfondoTemaScuro);
		((Profilo) getDashboard().getProfilo()).getTxtNome().setForeground(coloreScritteTemaScuro);
		((Profilo) getDashboard().getProfilo()).getTxtCognome().setBackground(sfondoTemaScuro);
		((Profilo) getDashboard().getProfilo()).getTxtCognome().setForeground(coloreScritteTemaScuro);
		((Profilo) getDashboard().getProfilo()).getTxtEmail().setBackground(sfondoTemaScuro);
		((Profilo) getDashboard().getProfilo()).getTxtEmail().setForeground(coloreScritteTemaScuro);

		((Profilo) getDashboard().getProfilo()).getLblDatiAccount().setIcon(new ImageIcon(img.datiAccount()));

		// IMPOSTAZIONI
		getDashboard().getImpostazioni().setBackground(sfondoTemaScuro);
		((Impostazioni) getDashboard().getImpostazioni()).getLblInformazioni().setForeground(coloreScritteTemaScuro);
		((Impostazioni) getDashboard().getImpostazioni()).getLblTerminiECondizioni()
				.setForeground(coloreScritteTemaScuro);
		((Impostazioni) getDashboard().getImpostazioni()).getLblRecensione().setForeground(coloreScritteTemaScuro);

		// GESTIONE TRATTA
		getDashboard().getGestioneTratte().setBackground(sfondoTemaScuro);
		((GestioneTratte) getDashboard().getGestioneTratte()).getLblCodiceTratta()
				.setForeground(coloreScritteTemaScuro);
		((GestioneTratte) getDashboard().getGestioneTratte()).getLblCittaPartenza()
				.setForeground(coloreScritteTemaScuro);
		((GestioneTratte) getDashboard().getGestioneTratte()).getLblCittaArrivo().setForeground(coloreScritteTemaScuro);

		((GestioneTratte) getDashboard().getGestioneTratte()).getTxtCodiceTratta()
				.setForeground(coloreScritteSuBiancoTemaScuro);
		((GestioneTratte) getDashboard().getGestioneTratte()).getTxtCittaPartenza()
				.setForeground(coloreScritteSuBiancoTemaScuro);
		((GestioneTratte) getDashboard().getGestioneTratte()).getTxtCittaArrivo()
				.setForeground(coloreScritteSuBiancoTemaScuro);

		// GESTIONE COMPAGNIE AEREE
		getDashboard().getGestioneCompagnieAeree().setBackground(sfondoTemaScuro);
		((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).getLblCodiceCompagniaAerea()
				.setForeground(coloreScritteTemaScuro);
		((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).getLblNome()
				.setForeground(coloreScritteTemaScuro);

		((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).getTxtNome()
				.setForeground(coloreScritteSuBiancoTemaScuro);
		((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).getTxtCodiceCompagniaAerea()
				.setForeground(coloreScritteSuBiancoTemaScuro);

		// GESTIONE UTENTI
		getDashboard().getGestioneUtenti().setBackground(sfondoTemaScuro);
		((GestioneUtenti) getDashboard().getGestioneUtenti()).getLblNome().setForeground(coloreLabelTemaScuro);
		((GestioneUtenti) getDashboard().getGestioneUtenti()).getLblCognome().setForeground(coloreLabelTemaScuro);
		((GestioneUtenti) getDashboard().getGestioneUtenti()).getLblEmail().setForeground(coloreLabelTemaScuro);
		((GestioneUtenti) getDashboard().getGestioneUtenti()).getLblPassword().setForeground(coloreLabelTemaScuro);

		((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtNome().setForeground(coloreScritteTemaScuro);
		((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtCognome().setForeground(coloreScritteTemaScuro);
		((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtEmail().setForeground(coloreScritteTemaScuro);
		((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtPassword().setForeground(coloreScritteTemaScuro);

		// GESTIONE VOLI PARTENZE
		getDashboard().getGestioneVoliPartenze().setBackground(sfondoTemaScuro);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getLblCodiceVoloPartenze()
				.setForeground(coloreLabelTemaScuro);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getLblDataPartenza()
				.setForeground(coloreLabelTemaScuro);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getLblOraPartenza()
				.setForeground(coloreLabelTemaScuro);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getLblDuePuntiPartenza()
				.setForeground(coloreLabelTemaScuro);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getLblNumeroPrenoazioni()
				.setForeground(coloreLabelTemaScuro);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getLblRitardo()
				.setForeground(coloreLabelTemaScuro);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtCodiceVoloPartenze()
				.setForeground(coloreScritteTemaScuro);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getDateDataPartenza()
				.setForeground(coloreScritteTemaScuro);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtOraPartenza()
				.setForeground(coloreScritteTemaScuro);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtMinutoPartenza()
				.setForeground(coloreScritteTemaScuro);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtNumeroPrenotazioni()
				.setForeground(coloreScritteTemaScuro);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtRitardo()
				.setForeground(coloreScritteTemaScuro);

		// GESTIONE VOLO ARRIVI
		getDashboard().getGestioneVoliArrivi().setBackground(sfondoTemaScuro);
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getLblCodiceVoloArrivi()
				.setForeground(coloreLabelTemaScuro);
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getLblCittaPartenza()
				.setForeground(coloreLabelTemaScuro);
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getLblDataArrivo()
				.setForeground(coloreLabelTemaScuro);
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getLblOraArrivo()
				.setForeground(coloreLabelTemaScuro);
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getLblDuePuntiArrivo()
				.setForeground(coloreLabelTemaScuro);

		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTxtCodiceVoloArrivi()
				.setForeground(coloreScritteTemaScuro);
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTxtCittaPartenza()
				.setForeground(coloreScritteTemaScuro);
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getDateDataArrivo()
				.setForeground(coloreScritteTemaScuro);
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTxtOraArrivo()
				.setForeground(coloreScritteTemaScuro);
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTxtMinutoArrivo()
				.setForeground(coloreScritteTemaScuro);

		// GESTIONE GATE
		getDashboard().getGestioneGate().setBackground(sfondoTemaScuro);
		((GestioneGate) getDashboard().getGestioneGate()).getLblCodiceGate().setForeground(coloreLabelTemaScuro);
		((GestioneGate) getDashboard().getGestioneGate()).getLblNumeroPorta().setForeground(coloreLabelTemaScuro);
		((GestioneGate) getDashboard().getGestioneGate()).getLblTempoImbarcoStimato().setForeground(coloreLabelTemaScuro);

		((GestioneGate) getDashboard().getGestioneGate()).getTxtCodiceGate().setForeground(coloreScritteSuBiancoTemaScuro);
		((GestioneGate) getDashboard().getGestioneGate()).getTxtNumeroPorta().setForeground(coloreScritteSuBiancoTemaScuro);
		((GestioneGate) getDashboard().getGestioneGate()).getTxtTempoImbarcoStimato().setForeground(coloreScritteSuBiancoTemaScuro);

		// RECENSIONE
		getDashboard().getRecensioni().setBackground(sfondoTemaScuro);

		// CAMBIO PASSWORD
		getDashboard().getCambioPassword().setBackground(sfondoTemaScuro);

		// JDIALOG USCITA
		((Uscita) getDashboard().getUscita()).getLblLayout().setIcon(new ImageIcon(img.sfondoUscita()));
		((Uscita) getDashboard().getUscita()).getLblSpostaUscita().setIcon(new ImageIcon(img.spostaUscita()));
		((Uscita) getDashboard().getUscita()).getLblX().setIcon(new ImageIcon(img.X1()));

		// JDIALOG PASSWORD DIMENTICATA
		((PasswordDimenticata) getDashboard().getPasswordDimenticata()).getLblLayout()
				.setIcon(new ImageIcon(img.sfondoPasswordDimenticata()));
		((PasswordDimenticata) getDashboard().getPasswordDimenticata()).getLblSpostaPasswordDimenticata()
				.setIcon(new ImageIcon(img.spostaUscita()));
		((PasswordDimenticata) getDashboard().getPasswordDimenticata()).getLblX().setIcon(new ImageIcon(img.X1()));
		((PasswordDimenticata) getDashboard().getPasswordDimenticata()).getLblCampi()
				.setIcon(new ImageIcon(img.credenzialiPasswordDimenticata()));
		((PasswordDimenticata) getDashboard().getPasswordDimenticata()).getLblSalva()
				.setIcon(new ImageIcon(img.salva1()));

		((PasswordDimenticata) getDashboard().getPasswordDimenticata()).getTxtEmail().setBackground(sfondoTemaScuro);
		((PasswordDimenticata) getDashboard().getPasswordDimenticata()).getTxtEmail()
				.setForeground(coloreScritteTemaScuro);
		((PasswordDimenticata) getDashboard().getPasswordDimenticata()).getTxtNuovaPassword()
				.setBackground(sfondoTemaScuro);
		((PasswordDimenticata) getDashboard().getPasswordDimenticata()).getTxtNuovaPassword()
				.setForeground(coloreScritteTemaScuro);
		((PasswordDimenticata) getDashboard().getPasswordDimenticata()).getTxtRipetiNuovaPassword()
				.setBackground(sfondoTemaScuro);
		((PasswordDimenticata) getDashboard().getPasswordDimenticata()).getTxtRipetiNuovaPassword()
				.setForeground(coloreScritteTemaScuro);

		// JDIALOG SCELTA PROFILO SENZA ACCESSO
		((SceltaProfiloSenzaAccesso) getDashboard().getSceltaProfiloSenzaAccesso()).getLblLayout()
				.setIcon(new ImageIcon(img.sfondoUscita()));
		((SceltaProfiloSenzaAccesso) getDashboard().getSceltaProfiloSenzaAccesso())
				.getLblSpostaSceltaProfiloSenzaAccesso().setIcon(new ImageIcon(img.spostaUscita()));
		((SceltaProfiloSenzaAccesso) getDashboard().getSceltaProfiloSenzaAccesso()).getLblX()
				.setIcon(new ImageIcon(img.X1()));
		((SceltaProfiloSenzaAccesso) getDashboard().getSceltaProfiloSenzaAccesso()).getLblContinuare()
				.setForeground(coloreLabelTemaScuro);

		// JDIALOG SCELTA VOLI
		((SceltaVolo) getDashboard().getSceltaVolo()).getLblLayout().setIcon(new ImageIcon(img.sfondoUscita()));
		((SceltaVolo) getDashboard().getSceltaVolo()).getLblSpostaSceltaVolo()
				.setIcon(new ImageIcon(img.spostaUscita()));
		((SceltaVolo) getDashboard().getSceltaVolo()).getLblX().setIcon(new ImageIcon(img.X1()));

		pannelloPrecedentementeSelezionato(getPannelloPrecedente());

	}

}
