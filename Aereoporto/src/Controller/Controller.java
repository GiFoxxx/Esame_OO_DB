package Controller;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import Database.ConnessioneDatabase;

import javax.swing.*;
import javax.swing.border.LineBorder;

import org.postgresql.util.PSQLException;

import Classi.*;
import ClassiDAO.*;
import GUI.*;
import Immagini.Immagini;
import ImplementazioniPostrgresDAO.*;

public class Controller {

	Immagini img = new Immagini();

	private int flagCambioTema = 0;

	private boolean erroreMostrato = false;
	private boolean successoMostrato = false;

	private boolean stopMenuTT = false;
	private boolean stopHomeTT = false;
	private boolean stopAccediTT = false;
	private boolean stopRegistratiTT = false;
	private boolean stopProfiloTT = false;
	private boolean stopImpostazioniTT = false;
	private boolean stopEsciTT = false;
	private boolean stopCambioTemaTT = false;
	private boolean stopMostraPasswordTT = false;
	private boolean stopCensuraPasswordTT = false;
	private boolean stopRegistroVoliTT = false;


	// PALETTE COLORI TEMA SCURO
	public Color bordiTemaScuro = new Color(35, 39, 42);
	public Color sfondoTemaScuro = new Color(54, 57, 63);
	public Color coloreBianco = new Color(255, 255, 255);
	public Color coloreScritteTemaScuro = new Color(242, 242, 242);
	public Color coloreScritteSuBiancoTemaScuro = new Color(35, 39, 42);
	public Color escoPannelloTemaScuro = new Color(35, 39, 42);
	public Color entroPannelloTemaScuro = new Color(40, 45, 48);
	public Color clickPannelloTemaScuro = new Color(50, 55, 58);
	public Color pannelloSceltoTemaScuro = new Color(60, 65, 68);
	public Color coloreLabelTemaScuro = new Color(200, 200, 200);
	public Color coloreLabelEntrataTemaScuro = new Color(220, 220, 220);
	public Color coloreLabelPressedTemaScuro = new Color(242, 242, 242);

	// PALETTE COLORI TEMA CHIARO
	public Color bordiTemaChiaro = new Color(227, 229, 232);
	public Color sfondoTemaChiaro = new Color(255, 255, 255);
	public Color coloreScritteTemaChiaro = new Color(106, 110, 117);
	public Color coloreScritteTendinaTemaChiaro = new Color(106, 110, 117);
	public Color escoPannelloTemaChiaro = new Color(227, 229, 232);
	public Color entroPannelloTemaChiaro = new Color(222, 223, 228);
	public Color clickPannelloTemaChiaro = new Color(212, 213, 218);
	public Color pannelloSceltoTemaChiaro = new Color(202, 203, 208);
	public Color coloreScritturaAllertaTemaChiaro = new Color(250, 45, 45);
	public Color coloreLabelTemaChiaro = new Color(106, 110, 117);
	public Color coloreLabelEntrataTemaChiaro = new Color(86, 90, 97);
	public Color coloreLabelPressedTemaChiaro = new Color(64, 68, 75);

	// PALETTE COLORI IN COMUNE
	public Color trasparente = new Color(0, 0, 0, 0);
	public Color coloreScrittaErrore = new Color(35, 39, 42);
	public Color coloreScrittaErroreInMenuInfo = new Color(201, 22, 22);
	public Color temaNC = new Color(0, 0, 0, 50);

	// FONT TESTI
	public Font fontScritte = new Font("Arial", Font.PLAIN, 18);
	public Font fontScritteTendina = new Font("Arial", Font.BOLD, 17);
	public Font fontTitolo = new Font("Arial", Font.BOLD, 18);
	public Font fontScritteJDialog = new Font("Arial", Font.BOLD, 18);
	public Font fontScritteGestioni = new Font("Arial", Font.PLAIN, 13);
	public Font fontLabel = new Font("Arial", Font.BOLD, 12);

	// MESSAGGI DI ERRORE E NOTIFICA
	public String erroreAccessoInserimentoCredenziali = "Inserire le credenziali";
	public String erroreAccessoCredenzialiSbagliate = "Nome utente o password errati. Riprova";
	public String erroreAccessoGiaUtilizziAccount = "Stai già utilizzando questo account";
	public String erroreAccessoEseguirePrimaLogout = "Devi effettuare il logout se vuoi accedere con altre credenziali.";
	public String erroreRegistrazioneFormatoSbagliato = "Formato email inserito non valido!"
			+ " Inserire l'email dal formato tipo: exp@example.com";
	public String erroreRegistrazioneEmailEsistente = "Email gi\u00E0� esistente";
	public String errorePasswordsNonCorrispondenti = "Le passwords non corrispondono";
	public String erroreRegistrazioneLoginGiaEffettuato = "Effettuare il logout prima della registrazione";
	public String erroreCampiVuoti = "Riempire tutti i campi per continuare";
	public String erroreGestioneVoliPartenzeOrarioSbagliato = "Errore nell'inserimento dell'orario";
	public String erroreCambioPasswordNonCorrispondenteConAttuale = "La password che hai attualmente non corrisponde con quella scritta";
	public String errorePasswordDimenticataEmailNonRegistrata = "Email non trovata";
	public String erroreGeneraleHome = "Per continuare, effettuare prima l'accesso";
	public String erroreGenericoInInserimentiCampi = "Attenzione, ci sono degli errori";
	public String erroreRecensioneMancataValutazione = "Dare una votazione per continuare";
	public String erroreGestioniNessunaRigaSelezionata = "Nessuna riga della tabella \u00E8 stata selezionata";
	public String erroreGestioniGenerale = "Ops...qualcosa \u00E8 andato storto";
	public String errorePasswordCorta = "La password deve essere minimo di 8 caratteri";

	public String registrazioneCompletata = "Registrazione effettuata con successo";
	public String passwordCambiata = "Password cambiata con successo";
	public String accessoEffettuato = "Accesso effettuato";
	public String invioRecensione = "Recensione inviata con successo";
	public String logout = "Logout avvenuto con successo";
	public String operazioneRiuscitaInGestioni = "Operazione riuscita con successo";

	// ATTRIBUTI
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
	private RegistroVoliPartenze registroVoliPartenze;
	private GestioneVoliArrivi gestioneVoliArrivi;
	private GestioneUtenti gestioneUtenti;
	private GestioneCompagnieAeree gestioneCompagnieAeree;
	private GestioneTratte gestioneTratte;
	private GestioneGate gestioneGate;
	private GateCodeImbarco gateCodeImbarco;
	private UtilizzoGate utilizzoGate;
	private SceltaGate sceltaGate;
	private Recensione recensioni;
	private NoClick noClick;
	private MenuInfoAccount menuInfoAccount;

	private Informazioni informazioni;
	private TerminiECondizioni terminiECondizioni;
	private PasswordDimenticata passwordDimenticata;
	private SceltaProfiloSenzaAccesso sceltaProfiloSenzaAccesso;
	private SceltaVolo sceltaVolo;
	private Uscita uscita;

	Utente utn;
	VoloPartenze vlprtz;
	VoloArrivi vlarr;
	Gate gt;
	CodaDiImbarco cdi;
	Tratta trt;
	CompagniaAerea compAerea;

	// GETTER E SETTER
	public boolean isErroreMostrato() {
		return erroreMostrato;
	}

	public void setErroreMostrato(boolean notificaMostrata) {
		this.erroreMostrato = notificaMostrata;
	}

	public boolean isSuccessoMostrato() {
		return successoMostrato;
	}

	public void setSuccessoMostrato(boolean successoMostrato) {
		this.successoMostrato = successoMostrato;
	}

	public boolean isStopCambioTemaTT() {
		return stopCambioTemaTT;
	}

	public void setStopCambioTemaTT(boolean stopCambioTemaTT) {
		this.stopCambioTemaTT = stopCambioTemaTT;
	}

	public boolean isStopHomeTT() {
		return stopHomeTT;
	}

	public void setStopHomeTT(boolean stopHomeTT) {
		this.stopHomeTT = stopHomeTT;
	}

	public boolean isStopAccediTT() {
		return stopAccediTT;
	}

	public void setStopAccediTT(boolean stopAccediTT) {
		this.stopAccediTT = stopAccediTT;
	}

	public boolean isStopRegistratiTT() {
		return stopRegistratiTT;
	}

	public void setStopRegistratiTT(boolean stopRegistratiTT) {
		this.stopRegistratiTT = stopRegistratiTT;
	}

	public boolean isStopProfiloTT() {
		return stopProfiloTT;
	}

	public void setStopProfiloTT(boolean stopProfiloTT) {
		this.stopProfiloTT = stopProfiloTT;
	}

	public boolean isStopImpostazioniTT() {
		return stopImpostazioniTT;
	}

	public void setStopImpostazioniTT(boolean stopImpostazioniTT) {
		this.stopImpostazioniTT = stopImpostazioniTT;
	}

	public boolean isStopEsciTT() {
		return stopEsciTT;
	}

	public void setStopEsciTT(boolean stopEsciTT) {
		this.stopEsciTT = stopEsciTT;
	}

	public boolean isStopMostraPasswordTT() {
		return stopMostraPasswordTT;
	}

	public void setStopMostraPasswordTT(boolean stopMostraPasswordAccessoTT) {
		this.stopMostraPasswordTT = stopMostraPasswordAccessoTT;
	}

	public boolean isStopCensuraPasswordTT() {
		return stopCensuraPasswordTT;
	}

	public void setStopCensuraPasswordTT(boolean stopCensuraPasswordAccessoTT) {
		this.stopCensuraPasswordTT = stopCensuraPasswordAccessoTT;
	}

	public boolean isStopRegistroVoliTT() {
		return stopRegistroVoliTT;
	}

	public void setStopRegistroVoliTT(boolean stopRegistroVoliTT) {
		this.stopRegistroVoliTT = stopRegistroVoliTT;
	}

	public int getFlagCambioTema() {
		return flagCambioTema;
	}

	public void setFlagCambioTema(int flagCambioTema) {
		this.flagCambioTema = flagCambioTema;
	}

	public boolean isStopMenuTT() {
		return stopMenuTT;
	}

	public void setStopMenuTT(boolean stopMenuTT) {
		this.stopMenuTT = stopMenuTT;
	}

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

	public RegistroVoliPartenze getRegistroVoliPartenze() {
		return registroVoliPartenze;
	}

	public void setRegistroVoliPartenze(RegistroVoliPartenze registroVoliPartenze) {
		this.registroVoliPartenze = registroVoliPartenze;
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

	public UtilizzoGate getTempisticheGate() {
		return utilizzoGate;
	}

	public void setTempisticheGate(UtilizzoGate utilizzoGate) {
		this.utilizzoGate = utilizzoGate;
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

	public MenuInfoAccount getMenuInfoAccount() {
		return menuInfoAccount;
	}

	public void setMenuInfoAccount(MenuInfoAccount menuInfoAccount) {
		this.menuInfoAccount = menuInfoAccount;
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

	// MAIN
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
		utilizzoGate = new UtilizzoGate(this);
		gestioneVoliPartenze = new GestioneVoliPartenze(this);
		registroVoliPartenze = new RegistroVoliPartenze(this);
		gestioneVoliArrivi = new GestioneVoliArrivi(this);
		cambioPassword = new CambioPassword(this);
		sceltaProfiloSenzaAccesso = new SceltaProfiloSenzaAccesso(this);
		passwordDimenticata = new PasswordDimenticata(this);
		sceltaVolo = new SceltaVolo(this);
		recensioni = new Recensione(this);
		noClick = new NoClick(this);
		menuInfoAccount = new MenuInfoAccount(this);
		dashboard.setVisible(true);
	}

	// METODI DI ACCESSO
	public void svuotaCampiAccesso() {
		((Accesso) getDashboard().getAccesso()).getTxtEmail().setText("");
		((Accesso) getDashboard().getAccesso()).getTxtPassword().setText("");
	}

	public void controlloAccessoGiaEseguito() {
		if (!sbloccaGestione()) {
			accedi();
		} else if (getEmailAccesso().equals(((Accesso) getDashboard().getAccesso()).getTxtEmail().getText())) {
			mostraNotifica(erroreAccessoGiaUtilizziAccount, img.messaggioErrore(), erroreMostrato);
		} else {
			mostraNotifica(erroreAccessoEseguirePrimaLogout, img.messaggioErrore(), erroreMostrato);
		}
	}

	@SuppressWarnings("deprecation")
	public void accedi() {
		String email = ((Accesso) getDashboard().getAccesso()).getTxtEmail().getText();
		emailAccesso = ((Accesso) getDashboard().getAccesso()).getTxtEmail().getText();
		String password = ((Accesso) getDashboard().getAccesso()).getTxtPassword().getText();
		passwordAccesso = ((Accesso) getDashboard().getAccesso()).getTxtPassword().getText();

		try {
			if (implementazioneUtenteDAO().accessoUtente(email, password)) {
				mostraPannelli(getDashboard().getHome());
				setPannelloPrecedente(1);
				mostraNotifica(accessoEffettuato, img.messaggioNotifica(), successoMostrato);
				mostraUtenteLoggato();
				getDashboard().getLblFrecciaMenu().setVisible(true);

				cambioPannelloTema(getDashboard().getPanelAccedi(), escoPannelloTemaChiaro, escoPannelloTemaScuro);

				if (email.equals("luigidemarco@gmail.com") || email.equals("manuelbuonanno00@gmail.com")) {
					entraGestioneUtenti = true;
				} else {
					((MenuInfoAccount) getDashboard().getMenuInfoAccount()).getLblErrore()
							.setText("Non sei amministratore");
				}
				((Accesso) getDashboard().getAccesso()).setSbloccaHome(true);
			} else if (controlloCampiSeVuotiAccesso()) {
				mostraNotifica(erroreAccessoInserimentoCredenziali, img.messaggioErrore(), erroreMostrato);
				mostraIconaErroreEmailMancanteAccesso();
			} else {
				mostraNotifica(erroreAccessoCredenzialiSbagliate, img.messaggioErrore(), erroreMostrato);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void mostraIconaErroreEmailMancanteAccesso() {
		if (((Accesso) getDashboard().getAccesso()).getTxtEmail().getText().equals("")) {
			((Accesso) getDashboard().getAccesso()).getLblIconaErrore().setVisible(true);
		} else {
			((Accesso) getDashboard().getAccesso()).getLblIconaErrore().setVisible(false);
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

	public void chiudiMostraPasswordTT(JLabel lbl) {
		lbl.setVisible(false);
	}

	public void mostraMostraPasswordTT(JLabel lbl) {
		Thread th = new Thread() {
			@Override
			public void run() {
				try {
					Thread.sleep(750);
					lbl.setVisible(true);
					if (stopMostraPasswordTT) {
						lbl.setVisible(false);
					}
					cambioImmagineTema(lbl, img.mostraPasswordTTChiaro(), img.mostraPasswordTT());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
			}
		};
		th.start();
	}

	public void chiudiCensuraPasswordTT(JLabel lbl) {
		lbl.setVisible(false);
	}

	public void mostraCensuraPasswordTT(JLabel lbl) {
		Thread th = new Thread() {
			@Override
			public void run() {
				try {
					Thread.sleep(750);
					lbl.setVisible(true);
					if (stopCensuraPasswordTT) {
						lbl.setVisible(false);
					}
					cambioImmagineTema(lbl, img.nascondiPasswordTTChiaro(), img.nascondiPasswordTT());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
			}
		};
		th.start();
	}

	// METODI DI REGISTRAZIONE
	public void svuotaCampiRegistrazione() {
		((Registrazione) getDashboard().getRegistrazione()).getTxtNome().setText("");
		((Registrazione) getDashboard().getRegistrazione()).getTxtCognome().setText("");
		((Registrazione) getDashboard().getRegistrazione()).getTxtEmail().setText("");
		((Registrazione) getDashboard().getRegistrazione()).getTxtPassword().setText("");
		((Registrazione) getDashboard().getRegistrazione()).getTxtRipetiPassword().setText("");
	}

	public void mostraIconaErroreEmailMancanteRegistrazione() {
		if (((Registrazione) getDashboard().getRegistrazione()).getTxtEmail().getText().equals("")) {
			((Registrazione) getDashboard().getRegistrazione()).getLblIconaErroreEmail().setVisible(true);
		} else {
			((Registrazione) getDashboard().getRegistrazione()).getLblIconaErroreEmail().setVisible(false);
		}
	}

	public void mostraIconaErroreNomeMancanteRegistrazione() {
		if (((Registrazione) getDashboard().getRegistrazione()).getTxtNome().getText().equals("")) {
			((Registrazione) getDashboard().getRegistrazione()).getLblIconaErroreNome().setVisible(true);
		} else {
			((Registrazione) getDashboard().getRegistrazione()).getLblIconaErroreNome().setVisible(false);
		}
	}

	public void mostraIconaErroreCognomeMancanteRegistrazione() {
		if (((Registrazione) getDashboard().getRegistrazione()).getTxtCognome().getText().equals("")) {
			((Registrazione) getDashboard().getRegistrazione()).getLblIconaErroreCognome().setVisible(true);
		} else {
			((Registrazione) getDashboard().getRegistrazione()).getLblIconaErroreCognome().setVisible(false);
		}
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
		if (controlloRegistrazioneBuona()) {
			Utente utn = new Utente(((Registrazione) getDashboard().getRegistrazione()).getTxtNome().getText(),
					((Registrazione) getDashboard().getRegistrazione()).getTxtCognome().getText(),
					((Registrazione) getDashboard().getRegistrazione()).getTxtEmail().getText(),
					((Registrazione) getDashboard().getRegistrazione()).getTxtPassword().getText());
			try {
				implementazioneUtenteDAO().registrazioneUtente(utn);
				mostraNotifica(registrazioneCompletata, img.messaggioNotifica(), successoMostrato);
				mostraPannelli(getDashboard().getAccesso());
				setPannelloPrecedente(2);
				((GestioneUtenti) getDashboard().getGestioneUtenti()).caricaTabella();
			} catch (SQLException e) {
				mostraNotifica(errorePasswordCorta, img.messaggioErrore(), erroreMostrato);
			}
		} else if (erroreFormatoEmail()) {
			mostraNotifica(erroreRegistrazioneFormatoSbagliato, img.messaggioErrore(), erroreMostrato);
			((Registrazione) getDashboard().getRegistrazione()).getLblIconaErroreEmail().setVisible(true);
		} else if (errorePasswordRipetuteErrate()) {
			mostraNotifica(errorePasswordsNonCorrispondenti, img.messaggioErrore(), erroreMostrato);
		} else if (erroreLoginGiaFatto()) {
			mostraNotifica(erroreRegistrazioneLoginGiaEffettuato, img.messaggioErrore(), erroreMostrato);
		} else {
			mostraIconaErroreNomeMancanteRegistrazione();
			mostraIconaErroreCognomeMancanteRegistrazione();
			mostraIconaErroreEmailMancanteRegistrazione();
			mostraNotifica(erroreCampiVuoti, img.messaggioErrore(), erroreMostrato);
		}
	}

	private boolean controlloRegistrazioneBuona() {
		if (formatoEmailInseritaErrato() && ripetiPassword() && nessunCampoVuotoRegistrazione()
				&& !((Accesso) getDashboard().getAccesso()).isSbloccaHome()) {
			return true;
		} else {
			return false;
		}
	}

	private boolean erroreFormatoEmail() {
		if (!formatoEmailInseritaErrato() && ripetiPassword() && nessunCampoVuotoRegistrazione()
				&& (!((Accesso) getDashboard().getAccesso()).isSbloccaHome()
						|| ((Accesso) getDashboard().getAccesso()).isSbloccaHome())) {
			return true;
		} else {
			return false;
		}
	}

	private boolean errorePasswordRipetuteErrate() {
		if (formatoEmailInseritaErrato() && !ripetiPassword() && nessunCampoVuotoRegistrazione()
				&& (!((Accesso) getDashboard().getAccesso()).isSbloccaHome()
						|| ((Accesso) getDashboard().getAccesso()).isSbloccaHome())) {
			return true;
		} else {
			return false;
		}
	}

	private boolean erroreLoginGiaFatto() {
		if (formatoEmailInseritaErrato() && ripetiPassword() && nessunCampoVuotoRegistrazione()
				&& ((Accesso) getDashboard().getAccesso()).isSbloccaHome()) {
			return true;
		} else {
			return false;
		}
	}

	@SuppressWarnings("deprecation")
	public boolean nessunCampoVuotoRegistrazione() {
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
		((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtBarraRicerca().setText("");
	}

	public UtenteDAO implementazioneUtenteDAO() {
		ConnessioneDatabase dbconn = null;
		Connection connection = null;
		UtenteDAO dao = null;
		try {
			dbconn = ConnessioneDatabase.getInstance();
			connection = dbconn.getConnection();
			dao = new UtenteImplementazionePostgresDAO(connection);
		} catch (SQLException exception) {
			System.out.println("SQLException: " + exception.getMessage());
		}
		return dao;
	}

	public void eliminaUtente() {
		utn = new Utente(((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtNome().getText(),
				((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtCognome().getText(),
				((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtEmail().getText(),
				((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtPassword().getText());
		int t = ((GestioneUtenti) getDashboard().getGestioneUtenti()).getTabella().getSelectedRow();
		try {
			implementazioneUtenteDAO().cancellaUtente(utn);
			mostraNotifica(operazioneRiuscitaInGestioni, img.messaggioNotifica(), successoMostrato);
			((GestioneUtenti) getDashboard().getGestioneUtenti()).getModello().removeRow(t);
			svuotaCampiGestioneUtenti();
			((GestioneUtenti) getDashboard().getGestioneUtenti()).caricaTabella();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void modificaUtente() {
		utn = new Utente(((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtNome().getText(),
				((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtCognome().getText(),
				((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtEmail().getText(),
				((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtPassword().getText());
		try {
			implementazioneUtenteDAO().modificaUtente(utn);
			mostraNotifica(operazioneRiuscitaInGestioni, img.messaggioNotifica(), successoMostrato);
			svuotaCampiGestioneUtenti();
			((GestioneUtenti) getDashboard().getGestioneUtenti()).caricaTabella();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// METODI GESTIONE COMPAGNIA AEREA
	public void svuotaCampiGestioneCompagniaAerea() {
		((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).getTxtCodiceCompagniaAerea().setText("");
		((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).getTxtNome().setText("");
		((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).getTxtBarraRicerca().setText("");

	}

	public CompagniaAereaDAO implementazioneCompagniaAereaDAO() {
		ConnessioneDatabase dbconn = null;
		Connection connection = null;
		CompagniaAereaDAO dao = null;
		try {
			dbconn = ConnessioneDatabase.getInstance();
			connection = dbconn.getConnection();
			dao = new CompagniaAereaImplementazionePostgresDAO(connection);
		} catch (SQLException exception) {
			System.out.println("SQLException: " + exception.getMessage());
		}
		return dao;
	}

	public void aggiungiCompagniaAerea() {
		compAerea = new CompagniaAerea(
				((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).getTxtCodiceCompagniaAerea()
						.getText(),
				((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).getTxtNome().getText());
		try {
			implementazioneCompagniaAereaDAO().aggiungiCompagniaAerea(compAerea);
			mostraNotifica(operazioneRiuscitaInGestioni, img.messaggioNotifica(), successoMostrato);
			((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).getModello()
					.addRow(((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).getRow());
			svuotaCampiGestioneCompagniaAerea();
			((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).caricaTabella();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void eliminaCompagniaAerea() {
		compAerea = new CompagniaAerea(
				((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).getTxtCodiceCompagniaAerea()
						.getText(),
				((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).getTxtNome().getText());
		int t = ((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).getTabella().getSelectedRow();
		try {
			implementazioneCompagniaAereaDAO().cancellaCompagniaAerea(compAerea);
			mostraNotifica(operazioneRiuscitaInGestioni, img.messaggioNotifica(), successoMostrato);
			((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).getModello().removeRow(t);
			svuotaCampiGestioneCompagniaAerea();
			((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).caricaTabella();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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

		try {
			implementazioneCompagniaAereaDAO().modificaCompagniaAerea(compAerea);
			mostraNotifica(operazioneRiuscitaInGestioni, img.messaggioNotifica(), successoMostrato);
			svuotaCampiGestioneCompagniaAerea();
			((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).caricaTabella();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// METODI GESTIONE TRATTE
	public void svuotaCampiGestioneTratta() {
		((GestioneTratte) getDashboard().getGestioneTratte()).getTxtCodiceTratta().setText("");
		((GestioneTratte) getDashboard().getGestioneTratte()).getTxtCittaPartenza().setText("");
		((GestioneTratte) getDashboard().getGestioneTratte()).getTxtCittaArrivo().setText("");
		((GestioneTratte) getDashboard().getGestioneTratte()).getTxtBarraRicerca().setText("");
		((GestioneTratte) getDashboard().getGestioneTratte()).getComboBoxNomeCompagniaAerea().setSelectedIndex(0);
	}

	public TrattaDAO implementazioneTrattaDAO() {
		ConnessioneDatabase dbconn = null;
		Connection connection = null;
		TrattaDAO dao = null;
		try {
			dbconn = ConnessioneDatabase.getInstance();
			connection = dbconn.getConnection();
			dao = new TrattaImplementazionePostgresDAO(connection);
		} catch (SQLException exception) {
			System.out.println("SQLException: " + exception.getMessage());
		}
		return dao;
	}

	public void aggiungiTratta() {

		compAerea = new CompagniaAerea(
				((GestioneTratte) getDashboard().getGestioneTratte()).getTxtCodiceCompagniaAerea().getText());

		trt = new Tratta(compAerea,
				((GestioneTratte) getDashboard().getGestioneTratte()).getTxtCodiceTratta().getText(),
				((GestioneTratte) getDashboard().getGestioneTratte()).getTxtCittaPartenza().getText(),
				((GestioneTratte) getDashboard().getGestioneTratte()).getTxtCittaArrivo().getText());

		try {
			implementazioneTrattaDAO().aggiungiTratta(trt);
			mostraNotifica(operazioneRiuscitaInGestioni, img.messaggioNotifica(), successoMostrato);
			((GestioneTratte) getDashboard().getGestioneTratte()).getModello()
					.addRow(((GestioneTratte) getDashboard().getGestioneTratte()).getRow());
			svuotaCampiGestioneTratta();
			((GestioneTratte) getDashboard().getGestioneTratte()).caricaTabella();
		} catch (SQLException e) {
			mostraNotifica(erroreGestioniGenerale, img.messaggioErrore(), erroreMostrato);
		}

	}

	public void eliminaTratta() {

		compAerea = new CompagniaAerea(
				((GestioneTratte) getDashboard().getGestioneTratte()).getTxtCodiceCompagniaAerea().getText());

		trt = new Tratta(((GestioneTratte) getDashboard().getGestioneTratte()).getTxtCodiceTratta().getText());

		int t = ((GestioneTratte) getDashboard().getGestioneTratte()).getTabella().getSelectedRow();
		try {
			implementazioneTrattaDAO().cancellaTratta(trt);
			mostraNotifica(operazioneRiuscitaInGestioni, img.messaggioNotifica(), successoMostrato);
			((GestioneTratte) getDashboard().getGestioneTratte()).getModello().removeRow(t);
			svuotaCampiGestioneTratta();
			((GestioneTratte) getDashboard().getGestioneTratte()).caricaTabella();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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

		try {
			implementazioneTrattaDAO().modificaTratta(trt);
			mostraNotifica(operazioneRiuscitaInGestioni, img.messaggioNotifica(), successoMostrato);
			svuotaCampiGestioneTratta();
			((GestioneTratte) getDashboard().getGestioneTratte()).caricaTabella();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// METODI GESTIONE VOLI PARTENZE
	public void svuotaCampiGestioneVoloPartenze() {
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtBarraRicerca().setText("");
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtCodiceVoloPartenze().setText("");
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtCodiceTratta().setText("");
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtCodiceGate().setText("");
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getDateDataPartenza().setDate(null);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtOraPartenza().setText("");
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtMinutoPartenza().setText("");
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtNumeroPrenotazioni().setText(null);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtTempoDiImbarcoEffettivo().setText(null);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtStatus().setText(null);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getComboBoxNumeroPorta().setSelectedIndex(0);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getComboBoxCittaArrivo().setSelectedIndex(0);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getComboBoxStatus().setSelectedIndex(0);
	}

	public VoloPartenzeDAO implementazioneVoloPartenzeDAO() {
		ConnessioneDatabase dbconn = null;
		Connection connection = null;
		VoloPartenzeDAO dao = null;
		try {
			dbconn = ConnessioneDatabase.getInstance();
			connection = dbconn.getConnection();
			dao = new VoloPartenzeImplementazionePostgresDAO(connection);
		} catch (SQLException exception) {
			System.out.println("SQLException: " + exception.getMessage());
		}
		return dao;
	}

	@SuppressWarnings("deprecation")
	public void aggiungiVoloPartenze() {
		gt = new Gate(((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtCodiceGate().getText());
		trt = new Tratta(
				((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtCodiceTratta().getText());

		int ora = Integer.parseInt(
				((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtOraPartenza().getText());
		int minuto = Integer.parseInt(
				((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtMinutoPartenza().getText());
		int secondo = 0;
		Time tempo = new Time(ora, minuto, secondo);
		int minutoTempoImbarcoEffettivo = Integer
				.parseInt(((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze())
						.getTxtTempoDiImbarcoEffettivo().getText());
		Time tempoImbarcoEffettivo = new Time(0, minutoTempoImbarcoEffettivo, 0);

		String status = ((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtStatus().getText();

		VoloPartenze codice = new VoloPartenze(
				((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtCodiceVoloPartenze().getText());
		String statusImbarco = null;
		try {
			statusImbarco = implementazioneVoloPartenzeDAO().risultatoStatusImbarco(codice);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		if ((ora < 24 && ora > -1) && (minuto < 60 && minuto > -1)) {

			Timestamp dataTempo = new Timestamp(
					((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getDateDataPartenza().getDate()
							.getYear(),
					((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getDateDataPartenza().getDate()
							.getMonth(),
					((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getDateDataPartenza().getDate()
							.getDate(),
					tempo.getHours(), tempo.getMinutes(), tempo.getSeconds(), 0);

			vlprtz = new VoloPartenze(
					((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtCodiceVoloPartenze()
							.getText(),
					dataTempo, ((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze())
							.getTxtNumeroPrenotazioni().getText(),
					tempoImbarcoEffettivo, trt, gt, status, statusImbarco);

			try {
				implementazioneVoloPartenzeDAO().inserisciVoloPartenze(vlprtz);
				mostraNotifica(operazioneRiuscitaInGestioni, img.messaggioNotifica(), successoMostrato);
				((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getModello()
						.addRow(((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getRow());
				svuotaCampiGestioneVoloPartenze();
				((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).caricaTabella();
			} catch (PSQLException e) {
				mostraNotifica(erroreGestioniGenerale, img.messaggioErrore(), erroreMostrato);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			mostraNotifica(erroreGestioneVoliPartenzeOrarioSbagliato, img.messaggioErrore(), erroreMostrato);
		}
	}

	public void eliminaVoloPartenze() {
		vlprtz = new VoloPartenze(
				((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtCodiceVoloPartenze().getText());

		int t = ((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTabella().getSelectedRow();
		try {
			implementazioneVoloPartenzeDAO().cancellaVoloPartenze(vlprtz);
			mostraNotifica(operazioneRiuscitaInGestioni, img.messaggioNotifica(), successoMostrato);
			((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getModello().removeRow(t);
			svuotaCampiGestioneVoloPartenze();
			((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).caricaTabella();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	public void modificaVoloPartenze() {
		gt = new Gate(((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtCodiceGate().getText());
		trt = new Tratta(
				((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtCodiceTratta().getText());

		int ora = Integer.parseInt(
				((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtOraPartenza().getText());
		int minuto = Integer.parseInt(
				((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtMinutoPartenza().getText());
		int secondo = 0;

		Time tempo = new Time(ora, minuto, secondo);
		int minutoTempoImbarcoEffettivo = Integer
				.parseInt(((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze())
						.getTxtTempoDiImbarcoEffettivo().getText());
		Time tempoImbarcoEffettivo = new Time(0, minutoTempoImbarcoEffettivo, 0);

		String status = ((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtStatus().getText();

		VoloPartenze codice = new VoloPartenze(
				((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtCodiceVoloPartenze().getText());
		String statusImbarco = null;
		try {
			statusImbarco = implementazioneVoloPartenzeDAO().risultatoStatusImbarco(codice);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		if ((ora < 24 && ora > -1) && (minuto < 60 && minuto > -1)) {

			Timestamp dataTempo = new Timestamp(
					((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getDateDataPartenza().getDate()
							.getYear(),
					((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getDateDataPartenza().getDate()
							.getMonth(),
					((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getDateDataPartenza().getDate()
							.getDate(),
					tempo.getHours(), tempo.getMinutes(), tempo.getSeconds(), 0);

			vlprtz = new VoloPartenze(
					((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtCodiceVoloPartenze()
							.getText(),
					dataTempo, ((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze())
							.getTxtNumeroPrenotazioni().getText(),
					tempoImbarcoEffettivo, trt, gt, status, statusImbarco);

			try {
				implementazioneVoloPartenzeDAO().modificaVoloPartenze(vlprtz);
				mostraNotifica(operazioneRiuscitaInGestioni, img.messaggioNotifica(), successoMostrato);
				svuotaCampiGestioneVoloPartenze();
				((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).caricaTabella();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			mostraNotifica(erroreGestioneVoliPartenzeOrarioSbagliato, img.messaggioErrore(), erroreMostrato);
		}
	}

	@SuppressWarnings("deprecation")
	public void modificaStatusImbarcoVoloPartenze() {
		int minutoTempoImbarco = Integer.parseInt(((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze())
				.getTxtTempoDiImbarcoEffettivo().getText());

		Time tempoImbarcoEffettivo = new Time(0, minutoTempoImbarco, 0);

		vlprtz = new VoloPartenze(
				((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtCodiceVoloPartenze().getText(),
				tempoImbarcoEffettivo);

		int t = ((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTabella().getSelectedRow();

		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getModello().setValueAt(
				((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtCodiceVoloPartenze().getText(),
				t, 0);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getModello().setValueAt(
				((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtStatus().getText(), t, 8);

		try {
			implementazioneVoloPartenzeDAO().modificaStatusVoloPartenze(vlprtz);
			mostraNotifica(operazioneRiuscitaInGestioni, img.messaggioNotifica(), successoMostrato);
			svuotaCampiGestioneVoloPartenze();
			((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).caricaTabella();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	public void modificaStatusVoloPartenze() {
		String statusVolo = ((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtStatus().getText();

		int minutoImbarcoEffettivo = Integer.parseInt(((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze())
				.getTxtTempoDiImbarcoEffettivo().getText());

		Time tempoImbarcoEffettivo = new Time(0, minutoImbarcoEffettivo, 0);

		vlprtz = new VoloPartenze(
				((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtCodiceVoloPartenze().getText(),
				statusVolo, tempoImbarcoEffettivo);

		try {
			implementazioneVoloPartenzeDAO().modificaStatusVoloPartenze(vlprtz);
			mostraNotifica(operazioneRiuscitaInGestioni, img.messaggioNotifica(), successoMostrato);
			svuotaCampiGestioneVoloPartenze();
			((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).caricaTabella();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// METODI GESTIONE VOLI ARRIVI
	public void svuotaCampiGestioneVoloArrivi() {
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTxtCodiceVoloArrivi().setText("");
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTxtCittaPartenza().setText("");
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getDateDataArrivo().setDate(null);
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTxtOraArrivo().setText("");
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTxtMinutoArrivo().setText("");
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTxtBarraRicerca().setText("");
	}

	public VoloArriviDAO implementazioneVoloArriviDAO() {
		ConnessioneDatabase dbconn = null;
		Connection connection = null;
		VoloArriviDAO dao = null;
		try {
			dbconn = ConnessioneDatabase.getInstance();
			connection = dbconn.getConnection();
			dao = new VoloArriviImplementazionePostgresDAO(connection);
		} catch (SQLException exception) {
			System.out.println("SQLException: " + exception.getMessage());
		}
		return dao;
	}

	@SuppressWarnings("deprecation")
	public void aggiungiVoloArrivi() {
		int ora = Integer
				.parseInt(((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTxtOraArrivo().getText());
		int minuto = Integer
				.parseInt(((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTxtMinutoArrivo().getText());
		int secondo = 0;

		Time tempo = new Time(ora, minuto, secondo);

		if ((ora < 24 && ora > -1) && (minuto < 60 && minuto > -1)) {

			Timestamp dataTempo = new Timestamp(
					((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getDateDataArrivo().getDate()
							.getYear(),
					((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getDateDataArrivo().getDate()
							.getMonth(),
					((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getDateDataArrivo().getDate()
							.getDate(),
					tempo.getHours(), tempo.getMinutes(), tempo.getSeconds(), 0);

			vlarr = new VoloArrivi(
					((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTxtCodiceVoloArrivi().getText(),
					((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTxtCittaPartenza().getText(),
					dataTempo);

			try {
				implementazioneVoloArriviDAO().aggiungiVoloArrivi(vlarr);
				mostraNotifica(operazioneRiuscitaInGestioni, img.messaggioNotifica(), successoMostrato);
				((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getModello()
						.addRow(((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getRow());
				svuotaCampiGestioneVoloArrivi();
				((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).caricaTabella();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			mostraNotifica(erroreGestioneVoliPartenzeOrarioSbagliato, img.messaggioErrore(), erroreMostrato);
		}
	}

	public void eliminaVoloArrivi() {
		vlarr = new VoloArrivi(
				((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTxtCodiceVoloArrivi().getText());

		int t = ((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTabella().getSelectedRow();
		try {
			implementazioneVoloArriviDAO().cancellaVoloArrivi(vlarr);
			mostraNotifica(operazioneRiuscitaInGestioni, img.messaggioNotifica(), successoMostrato);
			((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getModello().removeRow(t);
			svuotaCampiGestioneVoloArrivi();
			((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).caricaTabella();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	public void modificaVoloArrivi() {
		int ora = Integer
				.parseInt(((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTxtOraArrivo().getText());
		int minuto = Integer
				.parseInt(((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTxtMinutoArrivo().getText());
		int secondo = 0;

		Time tempo = new Time(ora, minuto, secondo);

		if ((ora < 24 && ora > -1) && (minuto < 60 && minuto > -1)) {

			Timestamp dataTempo = new Timestamp(
					((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getDateDataArrivo().getDate()
							.getYear(),
					((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getDateDataArrivo().getDate()
							.getMonth(),
					((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getDateDataArrivo().getDate()
							.getDate(),
					tempo.getHours(), tempo.getMinutes(), tempo.getSeconds(), 0);

			vlarr = new VoloArrivi(
					((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTxtCodiceVoloArrivi().getText(),
					((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTxtCittaPartenza().getText(),
					dataTempo);
			try {
				implementazioneVoloArriviDAO().modificaVoloArrivi(vlarr);
				mostraNotifica(operazioneRiuscitaInGestioni, img.messaggioNotifica(), successoMostrato);
				svuotaCampiGestioneVoloArrivi();
				((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).caricaTabella();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			mostraNotifica(erroreGestioneVoliPartenzeOrarioSbagliato, img.messaggioErrore(), erroreMostrato);
		}
	}

	// METODI GESTIONE GATE
	public void svuotaCampiGestioneGate() {
		((GestioneGate) getDashboard().getGestioneGate()).getTxtCodiceGate().setText("");
		((GestioneGate) getDashboard().getGestioneGate()).getTxtNumeroPorta().setText("");
		((GestioneGate) getDashboard().getGestioneGate()).getTxtBarraRicerca().setText("");
	}

	public GateDAO implementazioneGateDAO() {
		ConnessioneDatabase dbconn = null;
		Connection connection = null;
		GateDAO dao = null;
		try {
			dbconn = ConnessioneDatabase.getInstance();
			connection = dbconn.getConnection();
			dao = new GateImplementazionePostgresDAO(connection);
		} catch (SQLException exception) {
			System.out.println("SQLException: " + exception.getMessage());
		}
		return dao;
	}

	public CodaDiImbarcoDAO implementazioneCodaDiImbarcoDAO() {
		ConnessioneDatabase dbconn = null;
		Connection connection = null;
		CodaDiImbarcoDAO dao = null;
		try {
			dbconn = ConnessioneDatabase.getInstance();
			connection = dbconn.getConnection();
			dao = new CodaDiImbarcoImplementazionePostgresDAO(connection);
		} catch (SQLException exception) {
			System.out.println("SQLException: " + exception.getMessage());
		}
		return dao;
	}

	@SuppressWarnings("deprecation")
	public void aggiungiGate() {
		int ora = 0;
		int minutoChiusuraGate = 20;
		int secondo = 0;

		Time chiusuraGate = new Time(ora, minutoChiusuraGate, secondo);

		gt = new Gate(((GestioneGate) getDashboard().getGestioneGate()).getTxtCodiceGate().getText(),
				((GestioneGate) getDashboard().getGestioneGate()).getTxtNumeroPorta().getText(), chiusuraGate);

		try {
			implementazioneGateDAO().aggiungiGate(gt);
			mostraNotifica(operazioneRiuscitaInGestioni, img.messaggioNotifica(), successoMostrato);
			((GestioneGate) getDashboard().getGestioneGate()).getModello()
					.addRow(((GestioneGate) getDashboard().getGestioneGate()).getRow());
			svuotaCampiGestioneGate();
			((GestioneGate) getDashboard().getGestioneGate()).caricaTabella();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void eliminaGate() {
		gt = new Gate(((GestioneGate) getDashboard().getGestioneGate()).getTxtCodiceGate().getText());

		int t = ((GestioneGate) getDashboard().getGestioneGate()).getTabella().getSelectedRow();
		try {
			implementazioneGateDAO().cancellaGate(gt);
			mostraNotifica(operazioneRiuscitaInGestioni, img.messaggioNotifica(), successoMostrato);
			((GestioneGate) getDashboard().getGestioneGate()).getModello().removeRow(t);
			svuotaCampiGestioneGate();
			((GestioneGate) getDashboard().getGestioneGate()).caricaTabella();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	public void modificaGate() {
		int ora = 0;
		int minutoChiusuraGate = 20;
		int secondo = 0;

		Time chiusuraGate = new Time(ora, minutoChiusuraGate, secondo);

		gt = new Gate(((GestioneGate) getDashboard().getGestioneGate()).getTxtCodiceGate().getText(),
				((GestioneGate) getDashboard().getGestioneGate()).getTxtNumeroPorta().getText(), chiusuraGate);

		int t = ((GestioneGate) getDashboard().getGestioneGate()).getTabella().getSelectedRow();

		((GestioneGate) getDashboard().getGestioneGate()).getModello()
				.setValueAt(((GestioneGate) getDashboard().getGestioneGate()).getTxtCodiceGate().getText(), t, 0);
		((GestioneGate) getDashboard().getGestioneGate()).getModello()
				.setValueAt(((GestioneGate) getDashboard().getGestioneGate()).getTxtNumeroPorta().getText(), t, 1);

		try {
			implementazioneGateDAO().modificaGate(gt);
			mostraNotifica(operazioneRiuscitaInGestioni, img.messaggioNotifica(), successoMostrato);
			svuotaCampiGestioneGate();
			((GestioneGate) getDashboard().getGestioneGate()).caricaTabella();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// METODI DI GATE CODE DI IMBARCO
	public void svuotaCampiGateCodeImbarco() {
		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getTxtCodiceGate().setText("");
		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getTxtCodaDiImbarco().setText("");
		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getTxtBarraRicerca().setText("");
		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getComboBoxCodaDiImbarco().setSelectedIndex(0);
		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getComboBoxNumeroPorta().setSelectedIndex(0);
	}

	public void aggiungiGateCodeImbarco() {
		cdi = new CodaDiImbarco(
				((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getTxtCodaDiImbarco().getText());

		gt = new Gate(((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getTxtCodiceGate().getText());

		try {
			implementazioneGateDAO().aggiungiGateInCodaDiImbarco(gt, cdi);
			mostraNotifica(operazioneRiuscitaInGestioni, img.messaggioNotifica(), successoMostrato);
			((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getModelloTabellaAssociazione()
					.addRow(((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getRigaAssociazione());
			svuotaCampiGateCodeImbarco();
			((GateCodeImbarco) getDashboard().getGateCodeImbarco()).caricaTabellaAssociazione();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void eliminaGateCodeImbarco() {
		cdi = new CodaDiImbarco(
				((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getTxtCodaDiImbarco().getText());

		gt = new Gate(((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getTxtCodiceGate().getText());

		int t = ((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getTabellaAssociazioni().getSelectedRow();
		try {
			implementazioneGateDAO().cancellaGateInCodaDiImbarco(gt, cdi);
			mostraNotifica(operazioneRiuscitaInGestioni, img.messaggioNotifica(), successoMostrato);
			((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getModelloTabellaAssociazione().removeRow(t);
			svuotaCampiGestioneGate();
			((GateCodeImbarco) getDashboard().getGateCodeImbarco()).caricaTabellaAssociazione();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// METODI DI UTILIZZO GATE
	public void svuotaCampiUtilizzoGate() {
		((UtilizzoGate) getDashboard().getUtilizzoGate()).getTxtCodiceGate().setText("");
		((UtilizzoGate) getDashboard().getUtilizzoGate()).getTxtNumeroPorta().setText("");
		((UtilizzoGate) getDashboard().getUtilizzoGate()).getTxtBarraRicerca().setText("");
		((UtilizzoGate) getDashboard().getUtilizzoGate()).getDataUtilizzo().setDate(null);
	}

	@SuppressWarnings("deprecation")
	public void caricaTabellaUtilizzoGiornaliero() {
		Timestamp dataUtilizzo = new Timestamp(
				((UtilizzoGate) getDashboard().getUtilizzoGate()).getDataUtilizzo().getDate().getYear(),
				((UtilizzoGate) getDashboard().getUtilizzoGate()).getDataUtilizzo().getDate().getMonth(),
				((UtilizzoGate) getDashboard().getUtilizzoGate()).getDataUtilizzo().getDate().getDate(), 0, 0, 0, 0);

		Gate gt = new Gate(((UtilizzoGate) getDashboard().getUtilizzoGate()).getTxtCodiceGate().getText());

		try {
			((UtilizzoGate) getDashboard().getUtilizzoGate())
					.setListaUtilizzoGate(implementazioneGateDAO().stampaUtilizzoGiornaliero(gt, dataUtilizzo));
			((UtilizzoGate) getDashboard().getUtilizzoGate()).getModelloTabellaUtilizzi().setNumRows(0);
			for (Gate dato : ((UtilizzoGate) getDashboard().getUtilizzoGate()).getListaUtilizzoGate()) {
				((UtilizzoGate) getDashboard().getUtilizzoGate()).getModelloTabellaUtilizzi()
						.addRow(new Object[] { dato.getCodiceGate(), dato.getTotaleUtilizzoEffettivo(),
								dato.getTotaleUtilizzoStimato(), dataUtilizzo });
			}
			((UtilizzoGate) getDashboard().getUtilizzoGate()).getTabellaUtilizzi()
					.setModel(((UtilizzoGate) getDashboard().getUtilizzoGate()).getModelloTabellaUtilizzi());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	public void caricaTabellaUtilizzoSettimanale() {
		Timestamp dataUtilizzo = new Timestamp(
				((UtilizzoGate) getDashboard().getUtilizzoGate()).getDataUtilizzo().getDate().getYear(),
				((UtilizzoGate) getDashboard().getUtilizzoGate()).getDataUtilizzo().getDate().getMonth(),
				((UtilizzoGate) getDashboard().getUtilizzoGate()).getDataUtilizzo().getDate().getDate(), 0, 0, 0, 0);

		Gate gt = new Gate(((UtilizzoGate) getDashboard().getUtilizzoGate()).getTxtCodiceGate().getText());
		String settimana = "Settimana ";
		int i = 1;

		try {
			((UtilizzoGate) getDashboard().getUtilizzoGate())
					.setListaUtilizzoGate(implementazioneGateDAO().stampaUtilizzoSettimanale(gt, dataUtilizzo));
			((UtilizzoGate) getDashboard().getUtilizzoGate()).getModelloTabellaUtilizzi().setNumRows(0);
			for (Gate dato : ((UtilizzoGate) getDashboard().getUtilizzoGate()).getListaUtilizzoGate()) {

				((UtilizzoGate) getDashboard().getUtilizzoGate()).getModelloTabellaUtilizzi()
						.addRow(new Object[] { dato.getCodiceGate(), dato.getTotaleUtilizzoEffettivo(),
								dato.getTotaleUtilizzoStimato(), settimana.concat(String.valueOf(i)) });
				i = i + 1;
			}
			((UtilizzoGate) getDashboard().getUtilizzoGate()).getTabellaUtilizzi()
					.setModel(((UtilizzoGate) getDashboard().getUtilizzoGate()).getModelloTabellaUtilizzi());
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("deprecation")
	public void caricaTabellaUtilizzoMensile() {
		Timestamp dataUtilizzo = new Timestamp(
				((UtilizzoGate) getDashboard().getUtilizzoGate()).getDataUtilizzo().getDate().getYear(),
				((UtilizzoGate) getDashboard().getUtilizzoGate()).getDataUtilizzo().getDate().getMonth(),
				((UtilizzoGate) getDashboard().getUtilizzoGate()).getDataUtilizzo().getDate().getDate(), 0, 0, 0, 0);

		Gate gt = new Gate(((UtilizzoGate) getDashboard().getUtilizzoGate()).getTxtCodiceGate().getText());

		try {
			((UtilizzoGate) getDashboard().getUtilizzoGate())
					.setListaUtilizzoGate(implementazioneGateDAO().stampaUtilizzoMensile(gt, dataUtilizzo));
			((UtilizzoGate) getDashboard().getUtilizzoGate()).getModelloTabellaUtilizzi().setNumRows(0);

			for (Gate dato : ((UtilizzoGate) getDashboard().getUtilizzoGate()).getListaUtilizzoGate()) {
				((UtilizzoGate) getDashboard().getUtilizzoGate()).getModelloTabellaUtilizzi()
						.addRow(new Object[] { dato.getCodiceGate(), dato.getTotaleUtilizzoEffettivo(),
								dato.getTotaleUtilizzoStimato(), stampaMese() });
			}
			((UtilizzoGate) getDashboard().getUtilizzoGate()).getTabellaUtilizzi()
					.setModel(((UtilizzoGate) getDashboard().getUtilizzoGate()).getModelloTabellaUtilizzi());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	public String stampaMese() {
		String mese = null;
		Timestamp dataUtilizzo = new Timestamp(
				((UtilizzoGate) getDashboard().getUtilizzoGate()).getDataUtilizzo().getDate().getYear(),
				((UtilizzoGate) getDashboard().getUtilizzoGate()).getDataUtilizzo().getDate().getMonth(),
				((UtilizzoGate) getDashboard().getUtilizzoGate()).getDataUtilizzo().getDate().getDate(), 0, 0, 0, 0);

		switch (dataUtilizzo.getMonth() + 1) {
		case 1:
			mese = "Gennaio";
			break;
		case 2:
			mese = "Febbraio";
			break;
		case 3:
			mese = "Marzo";
			break;
		case 4:
			mese = "Aprile";
			break;
		case 5:
			mese = "Maggio";
			break;
		case 6:
			mese = "Giugno";
			break;
		case 7:
			mese = "Luglio";
			break;
		case 8:
			mese = "Agosto";
			break;
		case 9:
			mese = "Settembre";
			break;
		case 10:
			mese = "Ottobre";
			break;
		case 11:
			mese = "Novembre";
			break;
		case 12:
			mese = "Dicembre";
			break;
		}
		return mese;
	}

	// METODI DI CODA DI IMBARCO
	public void svuotaCampiCodaDiImbarco() {
		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getTxtCodiceCodaDiImbarco().setText(null);
		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getTxtNomeCodaDiImbarco().setText(null);
		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getTxtTempoDiImbarcoStimato().setText(null);
	}

	@SuppressWarnings("deprecation")
	public void aggiungiCodaDiImbarco() {
		int ora = 0;
		int minutoImbarcoStimato = Integer.parseInt(
				((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getTxtTempoDiImbarcoStimato().getText());
		;
		int secondo = 0;

		Time tempoDiImbarcoStimato = new Time(ora, minutoImbarcoStimato, secondo);

		cdi = new CodaDiImbarco(
				((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getTxtCodiceCodaDiImbarco().getText(),
				((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getTxtNomeCodaDiImbarco().getText(),
				tempoDiImbarcoStimato);

		try {
			implementazioneCodaDiImbarcoDAO().aggiungiCodaDiImbarco(cdi);
			mostraNotifica(operazioneRiuscitaInGestioni, img.messaggioNotifica(), successoMostrato);
			((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getModelloTabellaCodaDiImbarco()
					.addRow(((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getRigaCodaDiImbarco());
			svuotaCampiCodaDiImbarco();
			((GateCodeImbarco) getDashboard().getGateCodeImbarco()).caricaTabellaCodaDiImbarco();
		} catch (SQLException e) {
			mostraNotifica(erroreGeneraleHome, img.messaggioErrore(), erroreMostrato);
		}
	}

	public void eliminaCodaDiImbarco() {
		cdi = new CodaDiImbarco(
				((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getTxtCodiceCodaDiImbarco().getText());

		int t = ((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getTabellaCodaDiImbarco().getSelectedRow();
		try {
			implementazioneCodaDiImbarcoDAO().cancellaCodaDiImbarco(cdi);
			mostraNotifica(operazioneRiuscitaInGestioni, img.messaggioNotifica(), successoMostrato);
			((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getModelloTabellaCodaDiImbarco().removeRow(t);
			svuotaCampiCodaDiImbarco();
			((GateCodeImbarco) getDashboard().getGateCodeImbarco()).caricaTabellaCodaDiImbarco();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	public void modificaCodaDiImbarco() {
		int ora = 0;
		int minutoImbarcoStimato = Integer.parseInt(
				((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getTxtTempoDiImbarcoStimato().getText());
		;
		int secondo = 0;

		Time tempoDiImbarcoStimato = new Time(ora, minutoImbarcoStimato, secondo);

		cdi = new CodaDiImbarco(
				((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getTxtCodiceCodaDiImbarco().getText(),
				((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getTxtNomeCodaDiImbarco().getText(),
				tempoDiImbarcoStimato);
		try {
			implementazioneCodaDiImbarcoDAO().modificaCodaDiImbarco(cdi);
			mostraNotifica(operazioneRiuscitaInGestioni, img.messaggioNotifica(), successoMostrato);
			svuotaCampiCodaDiImbarco();
			((GateCodeImbarco) getDashboard().getGateCodeImbarco()).caricaTabellaCodaDiImbarco();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// AGGIORNAMENTO COMBOBOX
	public void rimuoviElementiComboBox(JComboBox<String> comboBox) {
		for (int i = comboBox.getItemCount() - 1; i > 0; i--) {
			comboBox.removeItemAt(i);
		}

	}

	// METODI DI DASHBOARD

	// METODI TOOLTIP

	Thread th;

	public void chiudiTT(JLabel lbl, boolean flag) {
		lbl.setVisible(false);
		if (flag) {
			th.interrupt();
		}
	}

	public void mostraTT(JLabel lbl, boolean flag, Image imgTemaChiaro, Image imgTemaScuro) {
		th = new Thread() {
			@Override
			public void run() {
				try {
					Thread.sleep(750);
					lbl.setVisible(true);
					if (flag) {
						lbl.setVisible(false);
					}
					cambioImmagineTema(lbl, imgTemaChiaro, imgTemaScuro);
				} catch (Exception e) {

				}
			}
		};
		th.start();
	}

	// PANEL HOME
	public void clickPannelloLateraleHome() {
		pannelloLateraleSelezionato();
		mostraPannelli(getDashboard().getHome());
		setPannelloPrecedente(1);
		if (getDashboard().getHome().isVisible()) {
			cambioPannelloTema(getDashboard().getPanelHome(), pannelloSceltoTemaChiaro, pannelloSceltoTemaScuro);
		}
		chiudiTendinaIstantanea();
	}

	// PANEL ACCEDI
	public void clickPannelloLateraleAccedi() {
		pannelloLateraleSelezionato();
		mostraPannelli(getDashboard().getAccesso());
		setPannelloPrecedente(2);
		if (getDashboard().getAccesso().isVisible()) {
			cambioPannelloTema(getDashboard().getPanelAccedi(), pannelloSceltoTemaChiaro, pannelloSceltoTemaScuro);

		}
		chiudiTendinaIstantanea();
	}

	// PANEL REGISTRATI
	public void clickPannelloLateraleRegistrati() {
		pannelloLateraleSelezionato();
		mostraPannelli(getDashboard().getRegistrazione());
		setPannelloPrecedente(3);
		if (getDashboard().getRegistrazione().isVisible()) {
			cambioPannelloTema(getDashboard().getPanelRegistrati(), pannelloSceltoTemaChiaro, pannelloSceltoTemaScuro);

		}
		chiudiTendinaIstantanea();
	}

	// PANEL PROFILO
	public void clickPannelloLateraleProfilo() {
		chiudiTendinaIstantanea();
		if (sbloccaGestione()) {
			pannelloLateraleSelezionato();
			mostraPannelli(getDashboard().getProfilo());
			setPannelloPrecedente(4);
			profiloUtenteAccessoEffettuato();

			if (getDashboard().getProfilo().isVisible()) {
				cambioPannelloTema(getDashboard().getPanelProfilo(), pannelloSceltoTemaChiaro, pannelloSceltoTemaScuro);

			}
			chiudiTendinaIstantanea();
		} else {
			mostraSceltaProfiloSenzaAccesso();
		}
	}

	// PANEL IMPOSTAZIONI
	public void clickPannelloLateraleImpostazioni() {
		pannelloLateraleSelezionato();
		mostraPannelli(getDashboard().getImpostazioni());
		setPannelloPrecedente(5);
		if (getDashboard().getImpostazioni().isVisible()) {
			cambioPannelloTema(getDashboard().getPanelImpostazioni(), pannelloSceltoTemaChiaro,
					pannelloSceltoTemaScuro);

		}
		chiudiTendinaIstantanea();
	}

	// PANEL ESCI
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
		int larghezzaLbl = 0;
		try {
			getDashboard().getLblAccount().setText(implementazioneUtenteDAO().stampaNomeAccount(utn) + " "
					+ implementazioneUtenteDAO().stampaCognomeAccount(utn));
			larghezzaLbl = implementazioneUtenteDAO().stampaNomeAccount(utn).length()
					+ implementazioneUtenteDAO().stampaCognomeAccount(utn).length();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		larghezzaLbl = larghezzaLbl * 8;
		getDashboard().getLblAccount().setBounds(970 - larghezzaLbl, 7, larghezzaLbl, 23);
	}

	// METODI ERRORI
	public void mostraNotifica(String errore, Image immagine, boolean bool) {
		if (!bool) {
			getDashboard().getLblMessaggioNotificaLayout().setIcon(new ImageIcon(immagine));
			if (getDashboard().getPosizioneMessaggioNotifica() == 0) {
				Thread th = new Thread() {
					@Override
					public void run() {
						try {
							for (int i = 0; i <= 25; i++) {
								Thread.sleep(1, 01);
								getDashboard().getPannelloErrore().setSize(1078, i);
							}
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, e);
						}
					}
				};
				th.start();
				getDashboard().getLblMessaggioNotificaTesto().setText(errore);
				getDashboard().setPosizioneMessaggioNotifica(25);
				erroreMostrato = true;
				chiudiNotifica();
			}
		}
	}

	public void chiudiNotifica() {
		if (getDashboard().getPosizioneMessaggioNotifica() == 25) {
			getDashboard().getPannelloErrore().setSize(1078, 0);
			Thread th = new Thread() {
				@Override
				public void run() {
					try {
						Thread.sleep(2500);
						for (int i = 25; i >= 0; i--) {
							Thread.sleep(1, 01);
							getDashboard().getPannelloErrore().setSize(1078, i);
						}
						erroreMostrato = false;
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, e);
					}
				}
			};
			th.start();
			getDashboard().setPosizioneMessaggioNotifica(0);
		}
	}

	// METODI TENDINA
	public void apriTendina() {
		chiudiTuttiTT();
		pannelloPrecedentementeSelezionato(pannelloPrecedente);
		getDashboard().getNoClick().setVisible(true);
		getDashboard().getLineeApertura().setVisible(false);
		getDashboard().getLblCambioTemaTT().setVisible(false);
		if (getDashboard().getPosizioneTendina() == 50) {
			getDashboard().getPannelloTendina().setSize(getDashboard().getPosizioneTendina(), 642);
			Thread th = new Thread() {
				@Override
				public void run() {
					try {
						for (int i = 50; i <= 240; i = i + 5) {
							Thread.sleep(0, 01);
							getDashboard().getPannelloTendina().setSize(i - 2, 642);
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
		chiudiTuttiTT();
		getDashboard().getLineeChiusura().setVisible(false);
		if (getDashboard().getPosizioneTendina() == 238) {
			getDashboard().getPannelloTendina().setSize(50, 642);
			Thread th = new Thread() {
				int i;

				@Override
				public void run() {
					try {
						for (i = 240; i >= 50; i = i - 5) {
							Thread.sleep(0, 01);
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
			pannelloPrecedentementeSelezionato(getPannelloPrecedente());
		}

	}

	public void chiudiTendinaIstantanea() {
		chiudiTuttiTT();

		getDashboard().getLineeChiusura().setVisible(false);
		if (getDashboard().getPosizioneTendina() == 238) {
			getDashboard().getPannelloTendina().setSize(50, 642);
			Thread th = new Thread() {
				@Override
				public void run() {
					try {
						for (int i = 240; i >= 50; i = i - 10) {
							Thread.sleep(1);
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
			pannelloPrecedentementeSelezionato(getPannelloPrecedente());
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

	public JPanel utilizzoGate() {
		UtilizzoGate utilizzoGate = new UtilizzoGate(this);
		return utilizzoGate;
	}

	public JPanel gestioneTratte() {
		GestioneTratte gestioneTratte = new GestioneTratte(this);
		return gestioneTratte;
	}

	public JPanel gestioneVoliPartenze() {
		GestioneVoliPartenze gestioneVoliParternze = new GestioneVoliPartenze(this);
		return gestioneVoliParternze;
	}

	public JPanel registroVoliPartenze() {
		RegistroVoliPartenze registroVoliPartenze = new RegistroVoliPartenze(this);
		return registroVoliPartenze;
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

	public JPanel menuInfoAccount() {
		MenuInfoAccount menuInfoAccount = new MenuInfoAccount(this);
		return menuInfoAccount;
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

	public void mostraPannelli(JPanel pannello) {
		((Accesso) getDashboard().getAccesso()).getLblMostraPassword().setVisible(true);
		((Accesso) getDashboard().getAccesso()).getLblIconaErrore().setVisible(false);
		((Registrazione) getDashboard().getRegistrazione()).getLblMostraPassword().setVisible(true);
		((Registrazione) getDashboard().getRegistrazione()).getLblMostraRipetiPassword().setVisible(true);
		((Registrazione) getDashboard().getRegistrazione()).getLblIconaErroreNome().setVisible(false);
		((Registrazione) getDashboard().getRegistrazione()).getLblIconaErroreCognome().setVisible(false);
		((Registrazione) getDashboard().getRegistrazione()).getLblIconaErroreEmail().setVisible(false);
		((CambioPassword) getDashboard().getCambioPassword()).getLblIconaErroreVecchiaPassword().setVisible(false);
		((CambioPassword) getDashboard().getCambioPassword()).getLblMostraNuovaPassword().setVisible(true);
		((CambioPassword) getDashboard().getCambioPassword()).getLblMostraRipetiNuovaPassword().setVisible(true);
		((PasswordDimenticata) getDashboard().getPasswordDimenticata()).getLblIconaErroreEmail().setVisible(false);
		((PasswordDimenticata) getDashboard().getPasswordDimenticata()).getLblMostraNuovaPassword().setVisible(true);
		((PasswordDimenticata) getDashboard().getPasswordDimenticata()).getLblMostraRipetiNuovaPassword()
				.setVisible(true);

		getDashboard().getHome().setVisible(false);
		getDashboard().getAccesso().setVisible(false);
		getDashboard().getRegistrazione().setVisible(false);
		getDashboard().getProfilo().setVisible(false);
		getDashboard().getImpostazioni().setVisible(false);
		getDashboard().getGestioneCompagnieAeree().setVisible(false);
		getDashboard().getGestioneUtenti().setVisible(false);
		getDashboard().getGestioneGate().setVisible(false);
		getDashboard().getGateCodeImbarco().setVisible(false);
		getDashboard().getUtilizzoGate().setVisible(false);
		getDashboard().getGestioneTratte().setVisible(false);
		getDashboard().getGestioneVoliPartenze().setVisible(false);
		getDashboard().getRegistroVoliPartenze().setVisible(false);
		getDashboard().getGestioneVoliArrivi().setVisible(false);
		getDashboard().getCambioPassword().setVisible(false);
		getDashboard().getRecensioni().setVisible(false);

		svuotaCampiAccesso();
		svuotaCampiRegistrazione();
		svuotaCampiGestioneUtenti();
		svuotaCampiGestioneCompagniaAerea();
		svuotaCampiGestioneGate();
		svuotaCampiGateCodeImbarco();
		svuotaCampiCodaDiImbarco();
		svuotaCampiUtilizzoGate();
		svuotaCampiGestioneTratta();
		svuotaCampiGestioneVoloPartenze();
		svuotaCampiGestioneVoloArrivi();
		svuotaCampiCambioPassword();

		getDashboard().getNoClick().setBounds(0, 0, 1093, 642);
		getDashboard().getNoClick().setVisible(false);
		getDashboard().getMenuInfoAccount().setVisible(false);

		pannello.setVisible(true);
	}

	// METODI DI MENU INFO ACCOUNT
	public void clickFrecciaMenuInfoAccount() {
		setStopMenuTT(true);
		if (((MenuInfoAccount) getDashboard().getMenuInfoAccount()).isVisible()) {
			chiudiTT(getDashboard().getLblMenuTT(), isStopMenuTT());
			chiudiTendinaIstantanea();
			chiudiMenuInfoAccount();
		} else {
			cambioImmagineTema(getDashboard().getLblFrecciaMenu(), img.frecciaMenu3TemaChiaro(), img.frecciaMenu3());
			chiudiTT(getDashboard().getLblMenuTT(), isStopMenuTT());
			mostraMenuInfoAccount();
		}
	}

	public void mostraMenuInfoAccount() {
		getDashboard().getHome().setVisible(false);
		getDashboard().getAccesso().setVisible(false);
		getDashboard().getRegistrazione().setVisible(false);
		getDashboard().getProfilo().setVisible(false);
		getDashboard().getImpostazioni().setVisible(false);
		getDashboard().getGestioneCompagnieAeree().setVisible(false);
		getDashboard().getGestioneUtenti().setVisible(false);
		getDashboard().getGestioneGate().setVisible(false);
		getDashboard().getUtilizzoGate().setVisible(false);
		getDashboard().getGateCodeImbarco().setVisible(false);
		getDashboard().getGestioneTratte().setVisible(false);
		getDashboard().getGestioneVoliPartenze().setVisible(false);
		getDashboard().getGestioneVoliArrivi().setVisible(false);
		getDashboard().getCambioPassword().setVisible(false);
		getDashboard().getMenuInfoAccount().setVisible(false);

		if (getDashboard().getPosizioneTendina() == 238) {
			getDashboard().getNoClick().setBounds(185, 0, 908, 642);
		} else {
			getDashboard().getNoClick().setVisible(true);
			getDashboard().getNoClick().setBounds(0, 0, 1093, 642);
		}
		getDashboard().getMenuInfoAccount().setVisible(true);
	}

	public void chiudiMenuInfoAccount() {
		pannelloPrecedentementeSelezionato(getPannelloPrecedente());
		getDashboard().getMenuInfoAccount().setVisible(false);
	}

	// METODI DI SCELTA PROFILO SENZA ACCESSO
	public void mostraSceltaProfiloSenzaAccesso() {
		svuotaCampiAccesso();
		svuotaCampiRegistrazione();
		setStopProfiloTT(true);
		chiudiTT(getDashboard().getLblProfiloTT(), isStopProfiloTT());
		getDashboard().setEnabled(false);
		if (cambioTema()) {
			((SceltaProfiloSenzaAccesso) getDashboard().getSceltaProfiloSenzaAccesso()).getLblAccedi()
					.setIcon(new ImageIcon(img.accedi1TemaChiaro()));
			((SceltaProfiloSenzaAccesso) getDashboard().getSceltaProfiloSenzaAccesso()).getLblRegistrati()
					.setIcon(new ImageIcon(img.registrati1TemaChiaro()));
			((SceltaProfiloSenzaAccesso) getDashboard().getSceltaProfiloSenzaAccesso()).getLblAnnulla()
					.setIcon(new ImageIcon(img.annulla1TemaChiaro()));
		} else {
			((SceltaProfiloSenzaAccesso) getDashboard().getSceltaProfiloSenzaAccesso()).getLblAccedi()
					.setIcon(new ImageIcon(img.accedi1()));
			((SceltaProfiloSenzaAccesso) getDashboard().getSceltaProfiloSenzaAccesso()).getLblRegistrati()
					.setIcon(new ImageIcon(img.registrati1()));
			((SceltaProfiloSenzaAccesso) getDashboard().getSceltaProfiloSenzaAccesso()).getLblAnnulla()
					.setIcon(new ImageIcon(img.annulla1()));
		}

		getDashboard().getSceltaProfiloSenzaAccesso().setVisible(true);
	}

	public void vaiAdAccediDaSceltaProfiloSenzaAccesso() {
		getDashboard().getSceltaProfiloSenzaAccesso().dispose();
		getDashboard().setEnabled(true);
		getDashboard().setVisible(true);
		mostraPannelli(getDashboard().getAccesso());
		setPannelloPrecedente(2);
	}

	public void vaiARegistrazioneDaSceltaProfiloSenzaAccesso() {
		getDashboard().getSceltaProfiloSenzaAccesso().dispose();
		getDashboard().setEnabled(true);
		getDashboard().setVisible(true);
		mostraPannelli(getDashboard().getRegistrazione());
		setPannelloPrecedente(3);
	}

	public void annullaSceltaProfiloSenzaAccesso() {
		getDashboard().getSceltaProfiloSenzaAccesso().dispose();
		pannelloLateraleSelezionato();
		getDashboard().setEnabled(true);
		getDashboard().setVisible(true);
		pannelloPrecedentementeSelezionato(getPannelloPrecedente());
	}

	// METODI SCELTA VOLI
	public void mostraSceltaVolo() {
		getDashboard().setEnabled(false);
		if (cambioTema()) {
			ripristinoImmaginiSceltaVoloTemaChiaro();
		} else {
			ripristinoImmaginiSceltaVolo();
		}
		getDashboard().getSceltaVolo().setVisible(true);
	}

	public void vaiAVoliPartenzeDaSceltaVolo() {
		getDashboard().getSceltaVolo().dispose();
		getDashboard().setEnabled(true);
		getDashboard().setVisible(true);
		mostraPannelli(getDashboard().getGestioneVoliPartenze());
		setPannelloPrecedente(9);
	}

	public void vaiAVoliArriviDaSceltaVolo() {
		getDashboard().getSceltaVolo().dispose();
		getDashboard().setEnabled(true);
		getDashboard().setVisible(true);
		mostraPannelli(getDashboard().getGestioneVoliArrivi());
		setPannelloPrecedente(10);
	}

	public void annullaSceltaVolo() {
		getDashboard().getSceltaVolo().dispose();
		getDashboard().setEnabled(true);
		getDashboard().setVisible(true);
		pannelloPrecedentementeSelezionato(getPannelloPrecedente());
	}

	public void ripristinoImmaginiSceltaVolo() {
		((SceltaVolo) getDashboard().getSceltaVolo()).getLblPartenze().setIcon(new ImageIcon(img.partenze1()));
		((SceltaVolo) getDashboard().getSceltaVolo()).getLblArrivi().setIcon(new ImageIcon(img.arrivi1()));
		((SceltaVolo) getDashboard().getSceltaVolo()).getLblAnnulla().setIcon(new ImageIcon(img.annulla1()));
	}

	public void ripristinoImmaginiSceltaVoloTemaChiaro() {
		((SceltaVolo) getDashboard().getSceltaVolo()).getLblPartenze()
				.setIcon(new ImageIcon(img.partenze1TemaChiaro()));
		((SceltaVolo) getDashboard().getSceltaVolo()).getLblArrivi().setIcon(new ImageIcon(img.arrivi1TemaChiaro()));
		((SceltaVolo) getDashboard().getSceltaVolo()).getLblAnnulla().setIcon(new ImageIcon(img.annulla1TemaChiaro()));
	}

	// METODI SCELTA GATE
	public void mostraSceltaGate() {
		getDashboard().setEnabled(false);
		if (cambioTema()) {
			ripristinoImmaginiSceltaGateTemaChiaro();
		} else {
			ripristinoImmaginiSceltaGate();

		}
		getDashboard().getSceltaGate().setVisible(true);
	}

	public void vaiAGateDaSceltaGate() {
		getDashboard().getSceltaGate().dispose();
		getDashboard().setEnabled(true);
		getDashboard().setVisible(true);
		mostraPannelli(getDashboard().getGestioneGate());
		setPannelloPrecedente(8);
	}

	public void vaiAGateCodeImbarcoDaSceltaVolo() {
		getDashboard().getSceltaGate().dispose();
		getDashboard().setEnabled(true);
		getDashboard().setVisible(true);
		mostraPannelli(getDashboard().getGateCodeImbarco());
		setPannelloPrecedente(11);
	}

	public void vaiATempisticheGateDaSceltaVolo() {
		getDashboard().getSceltaGate().dispose();
		getDashboard().setEnabled(true);
		getDashboard().setVisible(true);
		mostraPannelli(getDashboard().getUtilizzoGate());
		setPannelloPrecedente(14);
	}

	public void annullaSceltaGate() {
		getDashboard().getSceltaGate().dispose();
		getDashboard().setEnabled(true);
		getDashboard().setVisible(true);
		pannelloPrecedentementeSelezionato(getPannelloPrecedente());
	}

	public void ripristinoImmaginiSceltaGate() {
		((SceltaGate) getDashboard().getSceltaGate()).getLblGate().setIcon(new ImageIcon(img.gateScelta1()));
		((SceltaGate) getDashboard().getSceltaGate()).getLblTempisticheGate()
				.setIcon(new ImageIcon(img.utilizzoGate1()));
		((SceltaGate) getDashboard().getSceltaGate()).getLblCodeDiImbarco()
				.setIcon(new ImageIcon(img.codeDiImbarco1()));
		((SceltaGate) getDashboard().getSceltaGate()).getLblAnnulla().setIcon(new ImageIcon(img.annulla1()));
	}

	public void ripristinoImmaginiSceltaGateTemaChiaro() {
		((SceltaGate) getDashboard().getSceltaGate()).getLblGate().setIcon(new ImageIcon(img.gateScelta1TemaChiaro()));
		((SceltaGate) getDashboard().getSceltaGate()).getLblTempisticheGate()
				.setIcon(new ImageIcon(img.utilizzoGate1TemaChiaro()));
		((SceltaGate) getDashboard().getSceltaGate()).getLblCodeDiImbarco()
				.setIcon(new ImageIcon(img.codeDiImbarco1TemaChiaro()));
		((SceltaGate) getDashboard().getSceltaGate()).getLblAnnulla().setIcon(new ImageIcon(img.annulla1TemaChiaro()));
	}

	// METODI DI HOME
	public boolean sbloccaGestione() {
		if (((Accesso) getDashboard().getAccesso()).isSbloccaHome()) {
			return true;
		} else {
			return false;
		}
	}

	// MENU INFO ACCOUNT
	public void entraInGestioneUtenti() {
		if (sbloccaGestione()) {
			mostraPannelli(getDashboard().getGestioneUtenti());
			setPannelloPrecedente(15);
		}
	}

	public void logout() {
		getDashboard().getLblAccount().setBounds(760, 7, 216, 23);
		mostraNotifica(logout, img.messaggioNotifica(), successoMostrato);
		getDashboard().getLblAccount().setText("Nessun accesso effettuato");
		getDashboard().getLblAccount().setBounds(970 - 170, 7, 170, 23);
		getDashboard().getLblFrecciaMenu().setVisible(false);
		((MenuInfoAccount) getDashboard().getMenuInfoAccount()).getLblErrore().setText("");
		entraGestioneUtenti = false;
		((Accesso) getDashboard().getAccesso()).setSbloccaHome(false);
		mostraPannelli(getDashboard().getAccesso());
		setPannelloPrecedente(2);
	}

	// METODI DI PROFILO
	public void profiloUtenteAccessoEffettuato() {
		utn = new Utente(getEmailAccesso());
		try {
			((Profilo) getDashboard().getProfilo()).getTxtNome()
					.setText(implementazioneUtenteDAO().stampaNomeAccount(utn));

			((Profilo) getDashboard().getProfilo()).getTxtCognome()
					.setText(implementazioneUtenteDAO().stampaCognomeAccount(utn));
			((Profilo) getDashboard().getProfilo()).getTxtEmail()
					.setText(implementazioneUtenteDAO().stampaEmailAccount(utn));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// METODI DI CAMBIO PASSWORD
	public void svuotaCampiCambioPassword() {
		((CambioPassword) getDashboard().getCambioPassword()).getTxtVecchiaPassword().setText("");
		((CambioPassword) getDashboard().getCambioPassword()).getTxtNuovaPassword().setText("");
		((CambioPassword) getDashboard().getCambioPassword()).getTxtRipetiNuovaPassword().setText("");
	}

	@SuppressWarnings("deprecation")
	public void cambioPasswordDaProfilo() {
		utn = new Utente(emailAccesso,
				((CambioPassword) getDashboard().getCambioPassword()).getTxtNuovaPassword().getText());

		if (passwordVecchiaUgualeAllaNuova() && ripetiCambioPassword() && !(controlloCampiSeVuotiCambioPassword())) {
			try {
				implementazioneUtenteDAO().cambioPasswordDB(utn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			logout();
			mostraNotifica(passwordCambiata, img.messaggioNotifica(), successoMostrato);
			mostraPannelli(getDashboard().getAccesso());
			setPannelloPrecedente(2);

		} else if (erroreCambioPasswordNonCorrispondenteConAttuale()) {
			mostraNotifica(erroreCambioPasswordNonCorrispondenteConAttuale, img.messaggioErrore(), erroreMostrato);
		} else if (errorePasswordsNonCorrispondenti()) {
			mostraNotifica(errorePasswordsNonCorrispondenti, img.messaggioErrore(), erroreMostrato);
		} else if (erroriMultipliCambioPassword()) {
			mostraNotifica(erroreGenericoInInserimentiCampi, img.messaggioErrore(), erroreMostrato);
		} else {
			mostraIconaErroreVecchiaPasswordaMancanteCambioPassword();
			mostraNotifica(erroreCampiVuoti, img.messaggioErrore(), erroreMostrato);
		}
	}

	// ERRORI CAMBIO PASSWORD
	public void mostraIconaErroreVecchiaPasswordaMancanteCambioPassword() {
		if (((CambioPassword) getDashboard().getCambioPassword()).getTxtVecchiaPassword().getText().equals("")) {
			((CambioPassword) getDashboard().getCambioPassword()).getLblIconaErroreVecchiaPassword().setVisible(true);
		} else {
			((CambioPassword) getDashboard().getRegistrazione()).getLblIconaErroreVecchiaPassword().setVisible(false);
		}
	}

	public boolean errorePasswordsNonCorrispondenti() {
		if ((passwordVecchiaUgualeAllaNuova()) && !(ripetiCambioPassword())
				&& !(controlloCampiSeVuotiCambioPassword())) {
			return true;
		} else {
			return false;
		}
	}

	public boolean erroreCambioPasswordNonCorrispondenteConAttuale() {
		if (!(passwordVecchiaUgualeAllaNuova()) && (ripetiCambioPassword())
				&& !(controlloCampiSeVuotiCambioPassword())) {
			return true;
		} else {
			return false;
		}
	}

	public boolean erroriMultipliCambioPassword() {
		if (!(passwordVecchiaUgualeAllaNuova()) && !(ripetiCambioPassword())
				&& !(controlloCampiSeVuotiCambioPassword())) {
			return true;
		} else {
			return false;
		}
	}

	@SuppressWarnings("deprecation")
	public boolean controlloCampiSeVuotiCambioPassword() {
		if (((CambioPassword) getDashboard().getCambioPassword()).getTxtVecchiaPassword().getText().length() <= 0
				|| ((CambioPassword) getDashboard().getCambioPassword()).getTxtNuovaPassword().getText().length() <= 0
				|| ((CambioPassword) getDashboard().getCambioPassword()).getTxtRipetiNuovaPassword().getText()
						.length() <= 0) {
			return true;
		} else {
			return false;
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

	@SuppressWarnings("deprecation")
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
		chiudiTuttiTT();
		getDashboard().setEnabled(false);
		getDashboard().getPasswordDimenticata().setVisible(true);
		((PasswordDimenticata) getDashboard().getPasswordDimenticata()).getLblIconaErroreEmail().setVisible(false);
		((PasswordDimenticata) getDashboard().getPasswordDimenticata()).getLblMostraNuovaPassword().setVisible(true);
		((PasswordDimenticata) getDashboard().getPasswordDimenticata()).getLblMostraRipetiNuovaPassword()
				.setVisible(true);
		svuotaCampiPasswordDimenticata();
	}

	public void accessoPasswordDimenticata() {
		Utente utn = new Utente(((PasswordDimenticata) getDashboard().getPasswordDimenticata()).getTxtEmail().getText(),
				((PasswordDimenticata) getDashboard().getPasswordDimenticata()).getTxtNuovaPassword().getText());
		String email = ((PasswordDimenticata) getDashboard().getPasswordDimenticata()).getTxtEmail().getText();

		try {
			if (ripetiPasswordDimenticata() && implementazioneUtenteDAO().esisteEmail(email)
					&& !(controlloCampiSeVuotiPasswordDimenticata())) {
				implementazioneUtenteDAO().passwordDimenticata(utn);
				mostraPannelli(getDashboard().getAccesso());
				setPannelloPrecedente(2);
				getDashboard().getPasswordDimenticata().dispose();
				mostraNotifica(passwordCambiata, img.messaggioNotifica(), successoMostrato);
				getDashboard().setEnabled(true);
				getDashboard().setVisible(true);
				((GestioneUtenti) getDashboard().getGestioneUtenti()).caricaTabella();
			} else if (erroreRipetiPasswordDimenticata()) {
				mostraNotifica(errorePasswordsNonCorrispondenti, img.messaggioErrore(), erroreMostrato);
			} else if (erroriMultipliPasswordDimenticata()) {
				mostraNotifica(erroreGenericoInInserimentiCampi, img.messaggioErrore(), erroreMostrato);
			} else if (erroreEmailNonRegistrata()) {
				mostraNotifica(errorePasswordDimenticataEmailNonRegistrata, img.messaggioErrore(), erroreMostrato);
			} else {
				mostraIconaErroreEmailMancantePasswordDimenticata();
				mostraNotifica(erroreCampiVuoti, img.messaggioErrore(), erroreMostrato);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// ERRORI PASSWORD DIMENTICATA
	public void mostraIconaErroreEmailMancantePasswordDimenticata() {
		if (((PasswordDimenticata) getDashboard().getPasswordDimenticata()).getTxtEmail().getText().equals("")) {
			((PasswordDimenticata) getDashboard().getPasswordDimenticata()).getLblIconaErroreEmail().setVisible(true);
		} else {
			((PasswordDimenticata) getDashboard().getPasswordDimenticata()).getLblIconaErroreEmail().setVisible(false);
		}
	}

	public boolean erroreRipetiPasswordDimenticata() {
		String email = ((PasswordDimenticata) getDashboard().getPasswordDimenticata()).getTxtEmail().getText();
		boolean esisteEmail = false;
		try {
			esisteEmail = implementazioneUtenteDAO().esisteEmail(email);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (!ripetiPasswordDimenticata() && esisteEmail && !(controlloCampiSeVuotiPasswordDimenticata())) {
			return true;
		} else {
			return false;
		}
	}

	public boolean erroreEmailNonRegistrata() {
		String email = ((PasswordDimenticata) getDashboard().getPasswordDimenticata()).getTxtEmail().getText();
		boolean esisteEmail = false;
		try {
			esisteEmail = implementazioneUtenteDAO().esisteEmail(email);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (ripetiPasswordDimenticata() && !esisteEmail && !controlloCampiSeVuotiPasswordDimenticata()) {
			return true;
		} else {
			return false;
		}

	}

	public boolean erroriMultipliPasswordDimenticata() {
		String email = ((PasswordDimenticata) getDashboard().getPasswordDimenticata()).getTxtEmail().getText();
		boolean esisteEmail = false;
		try {
			esisteEmail = implementazioneUtenteDAO().esisteEmail(email);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (!ripetiPasswordDimenticata() && !esisteEmail && !controlloCampiSeVuotiPasswordDimenticata()) {
			return true;
		} else {
			return false;
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

	public void mostraOperazioneEffettuataConSuccesso() {
		chiudiTuttiTT();
		dashboard.setEnabled(false);
		dashboard.getOperazioneEffettuataConSuccesso().setVisible(true);
	}

	public void operazioneRiuscitaConSuccesso() {
		dashboard.getOperazioneEffettuataConSuccesso().dispose();
		getDashboard().setEnabled(true);
		getDashboard().setVisible(true);
	}

	// TERMINI E CONDIZIONI
	public void mostraTerminiECondizioni() {
		chiudiTuttiTT();
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

	// RECENSIONE
	public void svuotaAreaRecensione() {
		((Recensione) getDashboard().getRecensioni()).getTextArea().setText("");
	}

	public void invioRecensione() {
		if (lasciaRecensione()) {
			((Recensione) getDashboard().getRecensioni()).stella0();
			svuotaAreaRecensione();
			mostraNotifica(invioRecensione, img.messaggioNotifica(), successoMostrato);
		} else if (erroreMancataValutazione()) {
			mostraNotifica(erroreRecensioneMancataValutazione, img.messaggioErrore(), erroreMostrato);
		} else {
			mostraNotifica(erroreGeneraleHome, img.messaggioErrore(), erroreMostrato);
		}
	}

	public boolean lasciaRecensione() {
		if (((Accesso) getDashboard().getAccesso()).isSbloccaHome()
				&& ((Recensione) getDashboard().getRecensioni()).getValutazione() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean erroreMancataValutazione() {
		if (((Accesso) getDashboard().getAccesso()).isSbloccaHome()
				&& ((Recensione) getDashboard().getRecensioni()).getValutazione() <= 0) {
			return true;
		} else {
			return false;
		}
	}

	// METODI DI USCITA

	public void mostraUscita() {
		svuotaCampiAccesso();
		svuotaCampiRegistrazione();
		setStopEsciTT(true);
		chiudiTT(getDashboard().getLblEsciTT(), isStopEsciTT());
		dashboard.setEnabled(false);
		dashboard.getUscita().setVisible(true);
	}

	public void esci() {
		getDashboard().getUscita().dispose();
		getDashboard().dispose();
	}

	public void annullaUscita() {
		cambioImmagineTema(((Uscita) getDashboard().getUscita()).getLblX(), img.X1TemaChiaro(), img.X1());
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

	// RIMOZIONE BACKGROUND JAVA E ADATTAMENTO AL CENTRO DELLO SCHERMO
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
			cambioPannelloTema(getDashboard().getPanelHome(), pannelloSceltoTemaChiaro, pannelloSceltoTemaScuro);
		} else if (selezionePannello == 2) {
			mostraPannelli(getDashboard().getAccesso());
			cambioPannelloTema(getDashboard().getPanelAccedi(), pannelloSceltoTemaChiaro, pannelloSceltoTemaScuro);
		} else if (selezionePannello == 3) {
			mostraPannelli(getDashboard().getRegistrazione());
			cambioPannelloTema(getDashboard().getPanelRegistrati(), pannelloSceltoTemaChiaro, pannelloSceltoTemaScuro);
		} else if (selezionePannello == 4) {
			mostraPannelli(getDashboard().getProfilo());
			cambioPannelloTema(getDashboard().getPanelProfilo(), pannelloSceltoTemaChiaro, pannelloSceltoTemaScuro);
		} else if (selezionePannello == 5) {
			mostraPannelli(getDashboard().getImpostazioni());
			cambioPannelloTema(getDashboard().getPanelImpostazioni(), pannelloSceltoTemaChiaro,
					pannelloSceltoTemaScuro);
		} else if (selezionePannello == 6) {
			mostraPannelli(getDashboard().getGestioneTratte());
		} else if (selezionePannello == 7) {
			mostraPannelli(getDashboard().getGestioneCompagnieAeree());
		} else if (selezionePannello == 8) {
			mostraPannelli(getDashboard().getGestioneGate());
		} else if (selezionePannello == 9) {
			mostraPannelli(getDashboard().getGestioneVoliPartenze());
		} else if (selezionePannello == 10) {
			mostraPannelli(getDashboard().getGestioneVoliArrivi());
		} else if (selezionePannello == 11) {
			mostraPannelli(getDashboard().getGateCodeImbarco());
		} else if (selezionePannello == 12) {
			mostraPannelli(getDashboard().getRecensioni());
		} else if (selezionePannello == 13) {
			mostraPannelli(getDashboard().getCambioPassword());
		} else if (selezionePannello == 14) {
			mostraPannelli(getDashboard().getUtilizzoGate());
		} else if (selezionePannello == 15) {
			mostraPannelli(getDashboard().getGestioneUtenti());
		} else if (selezionePannello == 16) {
			mostraPannelli(getDashboard().getRegistroVoliPartenze());
		} else {
			mostraPannelli(getDashboard().getHome());
		}

	}

	// METODI DI CAMBIO TEMA E IMMAGINI
	public boolean cambioTema() {
		if (flagCambioTema == 1) {
			return true;
		} else {
			return false;
		}
	}

	public void cambioPannelloTema(JPanel pannello, Color coloreTemaChiaro, Color coloreTemaScuro) {
		if (cambioTema()) {
			pannello.setBackground(coloreTemaChiaro);
		} else {
			pannello.setBackground(coloreTemaScuro);
		}
	}

	public void cambioLabelTema(JLabel lbl, Color coloreTemaChiaro, Color coloreTemaScuro) {
		if (cambioTema()) {
			lbl.setForeground((coloreTemaChiaro));
		} else {
			lbl.setForeground((coloreTemaScuro));
		}
	}

	public void cambioImmagineTema(JLabel lbl, Image imgTemaChiaro, Image imgTemaScuro) {
		if (cambioTema()) {
			lbl.setIcon(new ImageIcon(imgTemaChiaro));
		} else {
			lbl.setIcon(new ImageIcon(imgTemaScuro));
		}
	}

	public void temaChiaro() {
		flagCambioTema = 1;

		getDashboard().getLblCambioTemaChiaro().setVisible(false);
		getDashboard().getLblCambioTemaScuro().setVisible(true);

		getDashboard().getLblSpostaDashboard().setIcon(new ImageIcon(img.spostaDashboardTemaChiaro()));
		getDashboard().getLblX().setIcon(new ImageIcon(img.X1TemaChiaro()));
		getDashboard().getLblMinimizza().setIcon(new ImageIcon(img.minimizza1TemaChiaro()));
		getDashboard().getLineeApertura().setIcon(new ImageIcon(img.lineeApertura1TemaChiaro()));
		getDashboard().getLineeChiusura().setIcon(new ImageIcon(img.lineeChiusura1TemaChiaro()));
		getDashboard().getLblHome().setIcon(new ImageIcon(img.casaTemaChiaro()));
		getDashboard().getLblAccesso().setIcon(new ImageIcon(img.accediTemaChiaro()));
		getDashboard().getLblRegistrazione().setIcon(new ImageIcon(img.registratiTemaChiaro()));
		getDashboard().getLblProfilo().setIcon(new ImageIcon(img.profiloTemaChiaro()));
		getDashboard().getLblImpostazioni().setIcon(new ImageIcon(img.impostazioniTemaChiaro()));
		getDashboard().getLblEsci().setIcon(new ImageIcon(img.esciTemaChiaro()));
		getDashboard().getLblLayout().setIcon(new ImageIcon(img.sfondoTemaChiaro()));
		getDashboard().getLblTendina().setIcon(new ImageIcon(img.tendinaTemaChiaro()));

		getDashboard().getLblScrittaHome().setForeground(coloreScritteTendinaTemaChiaro);
		getDashboard().getLblScrittaAccesso().setForeground(coloreScritteTendinaTemaChiaro);
		getDashboard().getLblScrittaRegistrazione().setForeground(coloreScritteTendinaTemaChiaro);
		getDashboard().getLblScrittaProfilo().setForeground(coloreScritteTendinaTemaChiaro);
		getDashboard().getLblScrittaImpostazioni().setForeground(coloreScritteTendinaTemaChiaro);
		getDashboard().getLblScrittaEsci().setForeground(coloreScritteTendinaTemaChiaro);
		getDashboard().getLblTitolo().setForeground(coloreScritteTendinaTemaChiaro);
		getDashboard().getLblAccount().setForeground(coloreScritteTendinaTemaChiaro);
		getDashboard().getLblVersione().setForeground(coloreLabelTemaChiaro);

		getDashboard().getPannelloTendina().setBackground(trasparente);
		getDashboard().getPanelHome().setBackground(escoPannelloTemaChiaro);
		getDashboard().getPanelAccedi().setBackground(escoPannelloTemaChiaro);
		getDashboard().getPanelRegistrati().setBackground(escoPannelloTemaChiaro);
		getDashboard().getPanelProfilo().setBackground(escoPannelloTemaChiaro);
		getDashboard().getPanelImpostazioni().setBackground(escoPannelloTemaChiaro);
		getDashboard().getPanelUscita().setBackground(escoPannelloTemaChiaro);

		// MENU INFO ACCOUNT
		getDashboard().getLblFrecciaMenu().setIcon(new ImageIcon(img.frecciaMenu1TemaChiaro()));
		((MenuInfoAccount) getDashboard().getMenuInfoAccount()).getLblFrecciaInAlto()
				.setIcon(new ImageIcon(img.frecciaInSuTemaChiaro()));

		((MenuInfoAccount) getDashboard().getMenuInfoAccount()).setBackground(trasparente);
		((MenuInfoAccount) getDashboard().getMenuInfoAccount()).getLblGestioneUtenti().setBackground(sfondoTemaChiaro);
		((MenuInfoAccount) getDashboard().getMenuInfoAccount()).getLblPrestoInArrivo().setBackground(sfondoTemaChiaro);
		((MenuInfoAccount) getDashboard().getMenuInfoAccount()).getLblLogout().setBackground(sfondoTemaChiaro);
		((MenuInfoAccount) getDashboard().getMenuInfoAccount()).getPanelLogout().setBackground(escoPannelloTemaChiaro);
		((MenuInfoAccount) getDashboard().getMenuInfoAccount()).getPanelGestioneUtente()
				.setBackground(escoPannelloTemaChiaro);
		((MenuInfoAccount) getDashboard().getMenuInfoAccount()).getPanelPrestoInArrivo()
				.setBackground(escoPannelloTemaChiaro);

		((MenuInfoAccount) getDashboard().getMenuInfoAccount()).getLblGestioneUtenti()
				.setForeground(coloreLabelTemaChiaro);
		((MenuInfoAccount) getDashboard().getMenuInfoAccount()).getLblPrestoInArrivo()
				.setForeground(coloreLabelTemaChiaro);
		((MenuInfoAccount) getDashboard().getMenuInfoAccount()).getLblLogout().setForeground(coloreLabelTemaChiaro);

		// NO CLICK
		getDashboard().getNoClick().setBackground(temaNC);

		// HOME
		getDashboard().getHome().setBackground(sfondoTemaChiaro);

		// ACCESSO
		getDashboard().getAccesso().setBackground(sfondoTemaChiaro);
		((Accesso) getDashboard().getAccesso()).getTxtEmail().setBackground(sfondoTemaChiaro);
		((Accesso) getDashboard().getAccesso()).getTxtPassword().setBackground(sfondoTemaChiaro);

		((Accesso) getDashboard().getAccesso()).getTxtEmail().setForeground(coloreScritteTemaChiaro);
		((Accesso) getDashboard().getAccesso()).getTxtPassword().setForeground(coloreScritteTemaChiaro);
		((Accesso) getDashboard().getAccesso()).getLblPasswordDimenticata().setForeground(coloreLabelTemaChiaro);

		((Accesso) getDashboard().getAccesso()).getLblAvanti().setIcon(new ImageIcon(img.avanti1TemaChiaro()));
		((Accesso) getDashboard().getAccesso()).getLblCredenziali()
				.setIcon(new ImageIcon(img.credenzialiAccessoTemaChiaro()));

		// REGISTRAZIONE
		getDashboard().getRegistrazione().setBackground(sfondoTemaChiaro);
		((Registrazione) getDashboard().getRegistrazione()).getTxtNome().setBackground(sfondoTemaChiaro);
		((Registrazione) getDashboard().getRegistrazione()).getTxtCognome().setBackground(sfondoTemaChiaro);
		((Registrazione) getDashboard().getRegistrazione()).getTxtEmail().setBackground(sfondoTemaChiaro);
		((Registrazione) getDashboard().getRegistrazione()).getTxtPassword().setBackground(sfondoTemaChiaro);
		((Registrazione) getDashboard().getRegistrazione()).getTxtRipetiPassword().setBackground(sfondoTemaChiaro);

		((Registrazione) getDashboard().getRegistrazione()).getTxtNome().setForeground(coloreScritteTemaChiaro);
		((Registrazione) getDashboard().getRegistrazione()).getTxtCognome().setForeground(coloreScritteTemaChiaro);
		((Registrazione) getDashboard().getRegistrazione()).getTxtEmail().setForeground(coloreScritteTemaChiaro);
		((Registrazione) getDashboard().getRegistrazione()).getTxtPassword().setForeground(coloreScritteTemaChiaro);
		((Registrazione) getDashboard().getRegistrazione()).getTxtRipetiPassword()
				.setForeground(coloreScritteTemaChiaro);

		((Registrazione) getDashboard().getRegistrazione()).getLblAvanti()
				.setIcon(new ImageIcon(img.avanti1TemaChiaro()));
		((Registrazione) getDashboard().getRegistrazione()).getLblInserimentoCredenziali()
				.setIcon(new ImageIcon(img.credenzialiRegistrazioneTemaChiaro()));

		// PROFILO
		getDashboard().getProfilo().setBackground(sfondoTemaChiaro);
		((Profilo) getDashboard().getProfilo()).getTxtNome().setBackground(sfondoTemaChiaro);
		((Profilo) getDashboard().getProfilo()).getTxtCognome().setBackground(sfondoTemaChiaro);
		((Profilo) getDashboard().getProfilo()).getTxtEmail().setBackground(sfondoTemaChiaro);

		((Profilo) getDashboard().getProfilo()).getTxtNome().setForeground(coloreScritteTemaChiaro);
		((Profilo) getDashboard().getProfilo()).getTxtCognome().setForeground(coloreScritteTemaChiaro);
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
		((GestioneTratte) getDashboard().getGestioneTratte()).getTxtBarraRicerca()
				.setBackground(escoPannelloTemaChiaro);

		((GestioneTratte) getDashboard().getGestioneTratte()).getTxtCittaPartenza()
				.setBorder(new LineBorder(bordiTemaChiaro));
		((GestioneTratte) getDashboard().getGestioneTratte()).getTxtCittaArrivo()
				.setBorder(new LineBorder(bordiTemaChiaro));
		((GestioneTratte) getDashboard().getGestioneTratte()).getTxtCodiceTratta()
				.setBorder(new LineBorder(bordiTemaChiaro));
		((GestioneTratte) getDashboard().getGestioneTratte()).getComboBoxNomeCompagniaAerea()
				.setBorder(new LineBorder(bordiTemaChiaro));
		((GestioneTratte) getDashboard().getGestioneTratte()).getTabella().setBorder(new LineBorder(bordiTemaChiaro));

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
		((GestioneTratte) getDashboard().getGestioneTratte()).getTxtBarraRicerca()
				.setForeground(coloreScritteTemaChiaro);
		((GestioneTratte) getDashboard().getGestioneTratte()).getLblCompagniaAerea()
				.setForeground(coloreLabelTemaChiaro);
		((GestioneTratte) getDashboard().getGestioneTratte()).getComboBoxNomeCompagniaAerea()
				.setForeground(coloreLabelTemaChiaro);

		((GestioneTratte) getDashboard().getGestioneTratte()).getLblModifica()
				.setIcon(new ImageIcon(img.modifica1TemaChiaro()));
		((GestioneTratte) getDashboard().getGestioneTratte()).getLblAggiungi()
				.setIcon(new ImageIcon(img.aggiungi1TemaChiaro()));
		((GestioneTratte) getDashboard().getGestioneTratte()).getLblElimina()
				.setIcon(new ImageIcon(img.elimina1TemaChiaro()));
		((GestioneTratte) getDashboard().getGestioneTratte()).getLblSvuota()
				.setIcon(new ImageIcon(img.svuota1TemaChiaro()));
		((GestioneTratte) getDashboard().getGestioneTratte()).getLblimgfrecciaIndietro()
				.setIcon(new ImageIcon(img.frecciaIndietro1TemaChiaro()));
		((GestioneTratte) getDashboard().getGestioneTratte()).getLblBarraRicerca()
				.setIcon(new ImageIcon(img.barraRicercaTemaChiaro()));
		((GestioneTratte) getDashboard().getGestioneTratte()).getLblRicaricaTabella()
				.setIcon(new ImageIcon(img.aggiorna1TemaChiaro()));

		// GESTIONE COMPAGNIE AEREE
		getDashboard().getGestioneCompagnieAeree().setBackground(sfondoTemaChiaro);
		((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).getTxtBarraRicerca()
				.setBackground(escoPannelloTemaChiaro);

		((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).getTxtNome()
				.setBorder(new LineBorder(bordiTemaChiaro));
		((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).getTxtCodiceCompagniaAerea()
				.setBorder(new LineBorder(bordiTemaChiaro));
		((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).getTabella()
				.setBorder(new LineBorder(bordiTemaChiaro));

		((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).getLblCodiceCompagniaAerea()
				.setForeground(coloreLabelTemaChiaro);
		((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).getLblNome()
				.setForeground(coloreLabelTemaChiaro);
		((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).getTxtCodiceCompagniaAerea()
				.setForeground(coloreScritteTemaChiaro);
		((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).getTxtNome()
				.setForeground(coloreScritteTemaChiaro);
		((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).getTxtBarraRicerca()
				.setForeground(coloreScritteTemaChiaro);

		((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).getLblModifica()
				.setIcon(new ImageIcon(img.modifica1TemaChiaro()));
		((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).getLblAggiungi()
				.setIcon(new ImageIcon(img.aggiungi1TemaChiaro()));
		((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).getLblElimina()
				.setIcon(new ImageIcon(img.elimina1TemaChiaro()));
		((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).getLblSvuota()
				.setIcon(new ImageIcon(img.svuota1TemaChiaro()));
		((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).getLblimgfrecciaIndietro()
				.setIcon(new ImageIcon(img.frecciaIndietro1TemaChiaro()));
		((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).getLblBarraRicerca()
				.setIcon(new ImageIcon(img.barraRicercaTemaChiaro()));
		((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).getLblRicaricaTabella()
				.setIcon(new ImageIcon(img.aggiorna1TemaChiaro()));

		// GESTIONE UTENTI
		getDashboard().getGestioneUtenti().setBackground(sfondoTemaChiaro);
		((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtBarraRicerca()
				.setBackground(escoPannelloTemaChiaro);

		((GestioneUtenti) getDashboard().getGestioneUtenti()).getLblNome().setForeground(coloreLabelTemaChiaro);
		((GestioneUtenti) getDashboard().getGestioneUtenti()).getLblCognome().setForeground(coloreLabelTemaChiaro);
		((GestioneUtenti) getDashboard().getGestioneUtenti()).getLblEmail().setForeground(coloreLabelTemaChiaro);
		((GestioneUtenti) getDashboard().getGestioneUtenti()).getLblPassword().setForeground(coloreLabelTemaChiaro);
		((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtBarraRicerca()
				.setForeground(coloreScritteTemaChiaro);

		((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtNome().setForeground(coloreScritteTemaChiaro);
		((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtCognome().setForeground(coloreScritteTemaChiaro);
		((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtEmail().setForeground(coloreScritteTemaChiaro);
		((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtPassword().setForeground(coloreScritteTemaChiaro);

		((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtNome().setBorder(new LineBorder(bordiTemaChiaro));
		((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtCognome()
				.setBorder(new LineBorder(bordiTemaChiaro));
		((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtEmail().setBorder(new LineBorder(bordiTemaChiaro));
		((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtPassword()
				.setBorder(new LineBorder(bordiTemaChiaro));

		((GestioneUtenti) getDashboard().getGestioneUtenti()).getLblModifica()
				.setIcon(new ImageIcon(img.modifica1TemaChiaro()));
		((GestioneUtenti) getDashboard().getGestioneUtenti()).getLblElimina()
				.setIcon(new ImageIcon(img.elimina1TemaChiaro()));
		((GestioneUtenti) getDashboard().getGestioneUtenti()).getLblSvuota()
				.setIcon(new ImageIcon(img.svuota1TemaChiaro()));
		((GestioneUtenti) getDashboard().getGestioneUtenti()).getLblimgfrecciaIndietro()
				.setIcon(new ImageIcon(img.frecciaIndietro1TemaChiaro()));
		((GestioneUtenti) getDashboard().getGestioneUtenti()).getLblBarraRicerca()
				.setIcon(new ImageIcon(img.barraRicercaTemaChiaro()));
		((GestioneUtenti) getDashboard().getGestioneUtenti()).getLblRicaricaTabella()
				.setIcon(new ImageIcon(img.aggiorna1TemaChiaro()));

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
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getLblGate()
				.setForeground(coloreLabelTemaChiaro);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getLblCodiceTratta()
				.setForeground(coloreLabelTemaChiaro);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getLblTempoDiImbarcoEffettivo()
				.setForeground(coloreLabelTemaChiaro);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getLblStatus()
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
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getDateDataPartenza()
				.setForeground(coloreScritteTemaChiaro);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtTempoDiImbarcoEffettivo()
				.setForeground(coloreLabelTemaChiaro);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getComboBoxNumeroPorta()
				.setForeground(coloreLabelTemaChiaro);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getComboBoxCittaArrivo()
				.setForeground(coloreLabelTemaChiaro);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getComboBoxStatus()
				.setForeground(coloreLabelTemaChiaro);

		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtCodiceVoloPartenze()
				.setBorder(new LineBorder(bordiTemaChiaro));
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getDateDataPartenza()
				.setBorder(new LineBorder(bordiTemaChiaro));
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTabella()
				.setBorder(new LineBorder(bordiTemaChiaro));
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtTempoDiImbarcoEffettivo()
				.setBorder(new LineBorder(bordiTemaChiaro));
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtMinutoPartenza()
				.setBorder(new LineBorder(bordiTemaChiaro));
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtOraPartenza()
				.setBorder(new LineBorder(bordiTemaChiaro));
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtNumeroPrenotazioni()
				.setBorder(new LineBorder(bordiTemaChiaro));
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getComboBoxNumeroPorta()
				.setBorder(new LineBorder(bordiTemaChiaro));
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getComboBoxCittaArrivo()
				.setBorder(new LineBorder(bordiTemaChiaro));
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getComboBoxStatus()
				.setBorder(new LineBorder(bordiTemaChiaro));

		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getLblModifica()
				.setIcon(new ImageIcon(img.modifica1TemaChiaro()));
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getLblAggiungi()
				.setIcon(new ImageIcon(img.aggiungi1TemaChiaro()));
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getLblElimina()
				.setIcon(new ImageIcon(img.elimina1TemaChiaro()));
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getLblSvuota()
				.setIcon(new ImageIcon(img.svuota1TemaChiaro()));
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getLblRegistroVoli()
				.setIcon(new ImageIcon(img.registroVoli1TemaChiaro()));
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getLblimgfrecciaIndietro()
				.setIcon(new ImageIcon(img.frecciaIndietro1TemaChiaro()));
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getLblBarraRicerca()
				.setIcon(new ImageIcon(img.barraRicercaTemaChiaro()));
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtBarraRicerca()
				.setForeground(coloreScritteTemaChiaro);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtBarraRicerca()
				.setBackground(escoPannelloTemaChiaro);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getLblRicaricaTabella()
				.setIcon(new ImageIcon(img.aggiorna1TemaChiaro()));

		// REGISTRO VOLI PARTENZE
		getDashboard().getRegistroVoliPartenze().setBackground(sfondoTemaChiaro);
		((RegistroVoliPartenze) getDashboard().getRegistroVoliPartenze()).getLblRicaricaTabella()
				.setIcon(new ImageIcon(img.aggiorna1TemaChiaro()));
		((RegistroVoliPartenze) getDashboard().getRegistroVoliPartenze()).getLblimgfrecciaIndietro()
				.setIcon(new ImageIcon(img.frecciaIndietro1TemaChiaro()));
		((RegistroVoliPartenze) getDashboard().getRegistroVoliPartenze()).getLblBarraRicerca()
				.setIcon(new ImageIcon(img.barraRicercaTemaChiaro()));
		((RegistroVoliPartenze) getDashboard().getRegistroVoliPartenze()).getTxtBarraRicerca()
				.setBackground(escoPannelloTemaChiaro);
		((RegistroVoliPartenze) getDashboard().getRegistroVoliPartenze()).getTxtBarraRicerca()
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
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getLblDataArrivo()
				.setForeground(coloreScritteTemaChiaro);
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getDateDataArrivo()
				.setForeground(coloreScritteTemaChiaro);

		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTxtCodiceVoloArrivi()
				.setBorder(new LineBorder(bordiTemaChiaro));
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTxtCittaPartenza()
				.setBorder(new LineBorder(bordiTemaChiaro));
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTxtOraArrivo()
				.setBorder(new LineBorder(bordiTemaChiaro));
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTxtMinutoArrivo()
				.setBorder(new LineBorder(bordiTemaChiaro));

		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getLblModifica()
				.setIcon(new ImageIcon(img.modifica1TemaChiaro()));
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getLblAggiungi()
				.setIcon(new ImageIcon(img.aggiungi1TemaChiaro()));
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getLblElimina()
				.setIcon(new ImageIcon(img.elimina1TemaChiaro()));
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getLblSvuota()
				.setIcon(new ImageIcon(img.svuota1TemaChiaro()));
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getLblimgfrecciaIndietro()
				.setIcon(new ImageIcon(img.frecciaIndietro1TemaChiaro()));
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getLblBarraRicerca()
				.setIcon(new ImageIcon(img.barraRicercaTemaChiaro()));
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTxtBarraRicerca()
				.setForeground(coloreScritteTemaChiaro);
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTxtBarraRicerca()
				.setBackground(escoPannelloTemaChiaro);
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getLblRicaricaTabella()
				.setIcon(new ImageIcon(img.aggiorna1TemaChiaro()));

		// GESTIONE GATE
		getDashboard().getGestioneGate().setBackground(sfondoTemaChiaro);

		((GestioneGate) getDashboard().getGestioneGate()).getLblCodiceGate().setForeground(coloreLabelTemaChiaro);
		((GestioneGate) getDashboard().getGestioneGate()).getLblNumeroPorta().setForeground(coloreLabelTemaChiaro);
		((GestioneGate) getDashboard().getGestioneGate()).getTxtBarraRicerca().setForeground(coloreScritteTemaChiaro);

		((GestioneGate) getDashboard().getGestioneGate()).getTxtCodiceGate().setBorder(new LineBorder(bordiTemaChiaro));
		((GestioneGate) getDashboard().getGestioneGate()).getTxtNumeroPorta()
				.setBorder(new LineBorder(bordiTemaChiaro));

		((GestioneGate) getDashboard().getGestioneGate()).getLblRicaricaTabella()
				.setIcon(new ImageIcon(img.aggiorna1TemaChiaro()));
		((GestioneGate) getDashboard().getGestioneGate()).getLblModifica()
				.setIcon(new ImageIcon(img.modifica1TemaChiaro()));
		((GestioneGate) getDashboard().getGestioneGate()).getLblAggiungi()
				.setIcon(new ImageIcon(img.aggiungi1TemaChiaro()));
		((GestioneGate) getDashboard().getGestioneGate()).getLblElimina()
				.setIcon(new ImageIcon(img.elimina1TemaChiaro()));
		((GestioneGate) getDashboard().getGestioneGate()).getLblSvuota()
				.setIcon(new ImageIcon(img.svuota1TemaChiaro()));
		((GestioneGate) getDashboard().getGestioneGate()).getLblimgfrecciaIndietro()
				.setIcon(new ImageIcon(img.frecciaIndietro1TemaChiaro()));
		((GestioneGate) getDashboard().getGestioneGate()).getLblBarraRicerca()
				.setIcon(new ImageIcon(img.barraRicercaTemaChiaro()));

		((GestioneGate) getDashboard().getGestioneGate()).getTxtBarraRicerca().setBackground(escoPannelloTemaChiaro);
		((GestioneGate) getDashboard().getGestioneGate()).getTxtCodiceGate().setForeground(coloreScritteTemaChiaro);
		((GestioneGate) getDashboard().getGestioneGate()).getTxtNumeroPorta().setForeground(coloreScritteTemaChiaro);

		// GESTIONE GATE CODA DI IMBARCO
		getDashboard().getGateCodeImbarco().setBackground(sfondoTemaChiaro);
		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getTxtBarraRicerca()
				.setBackground(escoPannelloTemaChiaro);

		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getLblCodiceGate().setForeground(coloreLabelTemaChiaro);
		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getLblCodaImbarco()
				.setForeground(coloreLabelTemaChiaro);
		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getLblCodiceCodaDiImbarco()
				.setForeground(coloreLabelTemaChiaro);
		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getLblNomeCodaDiImbarco()
				.setForeground(coloreLabelTemaChiaro);
		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getLblTempoDiImbarcoStimato()
				.setForeground(coloreLabelTemaChiaro);
		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getTxtBarraRicerca()
				.setForeground(coloreScritteTemaChiaro);

		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getTxtCodiceCodaDiImbarco()
				.setBorder(new LineBorder(bordiTemaChiaro));
		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getTxtNomeCodaDiImbarco()
				.setBorder(new LineBorder(bordiTemaChiaro));
		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getTxtTempoDiImbarcoStimato()
				.setBorder(new LineBorder(bordiTemaChiaro));
		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getComboBoxNumeroPorta()
				.setBorder(new LineBorder(bordiTemaChiaro));
		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getComboBoxCodaDiImbarco()
				.setBorder(new LineBorder(bordiTemaChiaro));

		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getTxtCodiceCodaDiImbarco()
				.setForeground(coloreScritteTemaChiaro);
		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getTxtNomeCodaDiImbarco()
				.setForeground(coloreScritteTemaChiaro);
		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getTxtTempoDiImbarcoStimato()
				.setForeground(coloreScritteTemaChiaro);
		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getComboBoxNumeroPorta()
				.setForeground(coloreScritteTemaChiaro);
		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getComboBoxCodaDiImbarco()
				.setForeground(coloreScritteTemaChiaro);

		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getLblAggiungiAssociazione()
				.setIcon(new ImageIcon(img.aggiungi1TemaChiaro()));
		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getLblEliminaAssociazione()
				.setIcon(new ImageIcon(img.elimina1TemaChiaro()));
		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getLblSvuotaAssociazione()
				.setIcon(new ImageIcon(img.svuota1TemaChiaro()));
		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getLblAggiungiCodaImbarco()
				.setIcon(new ImageIcon(img.aggiungi1TemaChiaro()));
		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getLblEliminaCodaImbarco()
				.setIcon(new ImageIcon(img.elimina1TemaChiaro()));
		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getLblSvuotaCodaImbarco()
				.setIcon(new ImageIcon(img.svuota1TemaChiaro()));
		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getLblModificaCodaImbarco()
				.setIcon(new ImageIcon(img.modifica1TemaChiaro()));
		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getLblimgfrecciaIndietro()
				.setIcon(new ImageIcon(img.frecciaIndietro1TemaChiaro()));
		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getLblBarraRicerca()
				.setIcon(new ImageIcon(img.barraRicercaTemaChiaro()));
		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getLblRicaricaTabelle()
				.setIcon(new ImageIcon(img.aggiorna1TemaChiaro()));

		// RECENSIONE
		getDashboard().getRecensioni().setBackground(sfondoTemaChiaro);

		((Recensione) getDashboard().getRecensioni()).getLblCommento().setForeground(coloreScritteTemaChiaro);

		((Recensione) getDashboard().getRecensioni()).getLblimgfrecciaIndietro()
				.setIcon(new ImageIcon(img.frecciaIndietro1TemaChiaro()));
		((Recensione) getDashboard().getRecensioni()).getLblInviaRecensione()
				.setIcon(new ImageIcon(img.inviaRecensione1TemaChiaro()));

		// CAMBIO PASSWORD
		getDashboard().getCambioPassword().setBackground(sfondoTemaChiaro);
		((CambioPassword) getDashboard().getCambioPassword()).getTxtVecchiaPassword().setBackground(sfondoTemaChiaro);
		((CambioPassword) getDashboard().getCambioPassword()).getTxtNuovaPassword().setBackground(sfondoTemaChiaro);
		((CambioPassword) getDashboard().getCambioPassword()).getTxtRipetiNuovaPassword()
				.setBackground(sfondoTemaChiaro);

		((CambioPassword) getDashboard().getCambioPassword()).getTxtRipetiNuovaPassword()
				.setForeground(coloreScritteTemaChiaro);
		((CambioPassword) getDashboard().getCambioPassword()).getTxtNuovaPassword()
				.setForeground(coloreScritteTemaChiaro);
		((CambioPassword) getDashboard().getCambioPassword()).getTxtVecchiaPassword()
				.setForeground(coloreScritteTemaChiaro);

		((CambioPassword) getDashboard().getCambioPassword()).getLblSalva()
				.setIcon(new ImageIcon(img.salvaModifiche1TemaChiaro()));
		((CambioPassword) getDashboard().getCambioPassword()).getLblAnnulla()
				.setIcon(new ImageIcon(img.frecciaIndietro1TemaChiaro()));
		((CambioPassword) getDashboard().getCambioPassword()).getLblCambioPassword()
				.setIcon(new ImageIcon(img.credenzialiCambioPasswordTemaChiaro()));

		// JDIALOG USCITA
		((Uscita) getDashboard().getUscita()).getLblUscire().setForeground(coloreLabelTemaChiaro);

		((Uscita) getDashboard().getUscita()).getLblLayout().setIcon(new ImageIcon(img.sfondoUscitaTemaChiaro()));
		((Uscita) getDashboard().getUscita()).getLblSpostaUscita().setIcon(new ImageIcon(img.spostaUscitaTemaChiaro()));
		((Uscita) getDashboard().getUscita()).getLblX().setIcon(new ImageIcon(img.X1TemaChiaro()));
		((Uscita) getDashboard().getUscita()).getLblSi().setIcon(new ImageIcon(img.si1TemaChiaro()));
		((Uscita) getDashboard().getUscita()).getLblAnnulla().setIcon(new ImageIcon(img.annullaUscita1TemaChiaro()));

		// PASSWORD DIMENTICATA
		((PasswordDimenticata) getDashboard().getPasswordDimenticata()).getTxtEmail().setBackground(sfondoTemaChiaro);
		((PasswordDimenticata) getDashboard().getPasswordDimenticata()).getTxtNuovaPassword()
				.setBackground(sfondoTemaChiaro);
		((PasswordDimenticata) getDashboard().getPasswordDimenticata()).getTxtRipetiNuovaPassword()
				.setBackground(sfondoTemaChiaro);

		((PasswordDimenticata) getDashboard().getPasswordDimenticata()).getTxtEmail()
				.setForeground(coloreScritteTemaChiaro);
		((PasswordDimenticata) getDashboard().getPasswordDimenticata()).getTxtNuovaPassword()
				.setForeground(coloreScritteTemaChiaro);
		((PasswordDimenticata) getDashboard().getPasswordDimenticata()).getTxtRipetiNuovaPassword()
				.setForeground(coloreScritteTemaChiaro);

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
		((PasswordDimenticata) getDashboard().getPasswordDimenticata()).getLblAnnulla()
				.setIcon(new ImageIcon(img.annullaUscita1TemaChiaro()));

		// JDIALOG SCELTA PROFILO SENZA ACCESSO
		((SceltaProfiloSenzaAccesso) getDashboard().getSceltaProfiloSenzaAccesso()).getLblContinuare()
				.setForeground(coloreLabelTemaChiaro);

		((SceltaProfiloSenzaAccesso) getDashboard().getSceltaProfiloSenzaAccesso()).getLblLayout()
				.setIcon(new ImageIcon(img.sfondoUscitaTemaChiaro()));
		((SceltaProfiloSenzaAccesso) getDashboard().getSceltaProfiloSenzaAccesso())
				.getLblSpostaSceltaProfiloSenzaAccesso().setIcon(new ImageIcon(img.spostaUscitaTemaChiaro()));
		((SceltaProfiloSenzaAccesso) getDashboard().getSceltaProfiloSenzaAccesso()).getLblX()
				.setIcon(new ImageIcon(img.X1TemaChiaro()));
		((SceltaProfiloSenzaAccesso) getDashboard().getSceltaProfiloSenzaAccesso()).getLblAccedi()
				.setIcon(new ImageIcon(img.accedi1TemaChiaro()));
		((SceltaProfiloSenzaAccesso) getDashboard().getSceltaProfiloSenzaAccesso()).getLblRegistrati()
				.setIcon(new ImageIcon(img.registrati1TemaChiaro()));
		((SceltaProfiloSenzaAccesso) getDashboard().getSceltaProfiloSenzaAccesso()).getLblAnnulla()
				.setIcon(new ImageIcon(img.annulla1TemaChiaro()));

		// JDIALOG SCELTA VOLI
		((SceltaVolo) getDashboard().getSceltaVolo()).getLblScelta().setForeground(coloreLabelTemaChiaro);

		((SceltaVolo) getDashboard().getSceltaVolo()).getLblLayout()
				.setIcon(new ImageIcon(img.sfondoUscitaTemaChiaro()));
		((SceltaVolo) getDashboard().getSceltaVolo()).getLblSpostaSceltaVolo()
				.setIcon(new ImageIcon(img.spostaUscitaTemaChiaro()));
		((SceltaVolo) getDashboard().getSceltaVolo()).getLblX().setIcon(new ImageIcon(img.X1TemaChiaro()));
		((SceltaVolo) getDashboard().getSceltaVolo()).getLblPartenze()
				.setIcon(new ImageIcon(img.partenze1TemaChiaro()));
		((SceltaVolo) getDashboard().getSceltaVolo()).getLblArrivi().setIcon(new ImageIcon(img.arrivi1TemaChiaro()));
		((SceltaVolo) getDashboard().getSceltaVolo()).getLblAnnulla().setIcon(new ImageIcon(img.annulla1TemaChiaro()));

		// TERMINI E CONDIZIONI
		((TerminiECondizioni) getDashboard().getTerminiECondizioni()).getLblAnnulla()
				.setIcon(new ImageIcon(img.tornaIndietro1TemaChiaro()));

		// INFORMAZIONI
		((Informazioni) getDashboard().getInformazioni()).getLblTornaIndietro()
				.setIcon(new ImageIcon(img.tornaIndietro1TemaChiaro()));

		// JDIALOG SCELTA GATE
		((SceltaGate) getDashboard().getSceltaGate()).getLblScelta().setForeground(coloreLabelTemaChiaro);

		((SceltaGate) getDashboard().getSceltaGate()).getLblCodeDiImbarco()
				.setIcon(new ImageIcon(img.codeDiImbarco1TemaChiaro()));
		((SceltaGate) getDashboard().getSceltaGate()).getLblGate().setIcon(new ImageIcon(img.gateScelta1TemaChiaro()));
		((SceltaGate) getDashboard().getSceltaGate()).getLblAnnulla().setIcon(new ImageIcon(img.annulla1TemaChiaro()));
		((SceltaGate) getDashboard().getSceltaGate()).getLblX().setIcon(new ImageIcon(img.X1TemaChiaro()));
		((SceltaGate) getDashboard().getSceltaGate()).getLblLayout()
				.setIcon(new ImageIcon(img.sfondoUscitaTemaChiaro()));
		((SceltaGate) getDashboard().getSceltaGate()).getLblSpostaSceltaVolo()
				.setIcon(new ImageIcon(img.spostaUscitaTemaChiaro()));
		((SceltaGate) getDashboard().getSceltaGate()).getLblTempisticheGate()
				.setIcon(new ImageIcon(img.utilizzoGate1TemaChiaro()));

		// UTILIZZO GATE
		getDashboard().getUtilizzoGate().setBackground(sfondoTemaChiaro);
		((UtilizzoGate) getDashboard().getUtilizzoGate()).getTxtBarraRicerca().setBackground(escoPannelloTemaChiaro);
		((UtilizzoGate) getDashboard().getUtilizzoGate()).getTxtBarraRicerca().setForeground(coloreScritteTemaChiaro);

		((UtilizzoGate) getDashboard().getUtilizzoGate()).getTxtCodiceGate().setForeground(coloreScritteTemaChiaro);
		((UtilizzoGate) getDashboard().getUtilizzoGate()).getTxtNumeroPorta().setForeground(coloreScritteTemaChiaro);
		((UtilizzoGate) getDashboard().getUtilizzoGate()).getDataUtilizzo().setForeground(coloreScritteTemaChiaro);

		((UtilizzoGate) getDashboard().getUtilizzoGate()).getLblSelezionaData().setForeground(coloreLabelTemaChiaro);
		((UtilizzoGate) getDashboard().getUtilizzoGate()).getLblCodiceGate().setForeground(coloreLabelTemaChiaro);
		((UtilizzoGate) getDashboard().getUtilizzoGate()).getLblNumeroPorta().setForeground(coloreLabelTemaChiaro);
		((UtilizzoGate) getDashboard().getUtilizzoGate()).getLblCalcolaUtilizzo().setForeground(coloreLabelTemaChiaro);

		((UtilizzoGate) getDashboard().getUtilizzoGate()).getTxtCodiceGate().setBorder(new LineBorder(bordiTemaChiaro));
		((UtilizzoGate) getDashboard().getUtilizzoGate()).getTxtNumeroPorta()
				.setBorder(new LineBorder(bordiTemaChiaro));

		((UtilizzoGate) getDashboard().getUtilizzoGate()).getTxtNumeroPorta()
				.setBorder(new LineBorder(bordiTemaChiaro));
		((UtilizzoGate) getDashboard().getUtilizzoGate()).getTxtNumeroPorta()
				.setBorder(new LineBorder(bordiTemaChiaro));

		((UtilizzoGate) getDashboard().getUtilizzoGate()).getLblimgfrecciaIndietro()
				.setIcon(new ImageIcon(img.frecciaIndietro1TemaChiaro()));
		((UtilizzoGate) getDashboard().getUtilizzoGate()).getLblRicaricaTabella()
				.setIcon(new ImageIcon(img.aggiorna1TemaChiaro()));
		((UtilizzoGate) getDashboard().getUtilizzoGate()).getLblBarraRicerca()
				.setIcon(new ImageIcon(img.barraRicercaTemaChiaro()));
		((UtilizzoGate) getDashboard().getUtilizzoGate()).getLblSvuota()
				.setIcon(new ImageIcon(img.svuota1TemaChiaro()));
		((UtilizzoGate) getDashboard().getUtilizzoGate()).getLblGiorno()
				.setIcon(new ImageIcon(img.giorno1TemaChiaro()));
		((UtilizzoGate) getDashboard().getUtilizzoGate()).getLblMese().setIcon(new ImageIcon(img.mese1TemaChiaro()));
		((UtilizzoGate) getDashboard().getUtilizzoGate()).getLblSettimana()
				.setIcon(new ImageIcon(img.settimana1TemaChiaro()));

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
		getDashboard().getLblVersione().setForeground(coloreScritteTemaScuro);

		getDashboard().getPanelHome().setBackground(escoPannelloTemaScuro);
		getDashboard().getPanelAccedi().setBackground(escoPannelloTemaScuro);
		getDashboard().getPanelRegistrati().setBackground(escoPannelloTemaScuro);
		getDashboard().getPanelProfilo().setBackground(escoPannelloTemaScuro);
		getDashboard().getPanelImpostazioni().setBackground(escoPannelloTemaScuro);
		getDashboard().getPanelUscita().setBackground(escoPannelloTemaScuro);

		// MENU INFO ACCOUNT
		getDashboard().getLblFrecciaMenu().setIcon(new ImageIcon(img.frecciaMenu1()));
		((MenuInfoAccount) getDashboard().getMenuInfoAccount()).getLblFrecciaInAlto()
				.setIcon(new ImageIcon(img.frecciaInSu()));
		((MenuInfoAccount) getDashboard().getMenuInfoAccount()).getLblGestioneUtenti()
				.setBackground(escoPannelloTemaScuro);
		((MenuInfoAccount) getDashboard().getMenuInfoAccount()).getLblGestioneUtenti()
				.setForeground(coloreScritteTemaScuro);
		((MenuInfoAccount) getDashboard().getMenuInfoAccount()).getLblPrestoInArrivo()
				.setBackground(escoPannelloTemaScuro);
		((MenuInfoAccount) getDashboard().getMenuInfoAccount()).getLblPrestoInArrivo()
				.setForeground(coloreScritteTemaScuro);
		((MenuInfoAccount) getDashboard().getMenuInfoAccount()).getLblLogout().setBackground(escoPannelloTemaScuro);
		((MenuInfoAccount) getDashboard().getMenuInfoAccount()).getLblLogout().setForeground(coloreScritteTemaScuro);
		((MenuInfoAccount) getDashboard().getMenuInfoAccount()).getPanelGestioneUtente()
				.setBackground(escoPannelloTemaScuro);
		((MenuInfoAccount) getDashboard().getMenuInfoAccount()).getPanelLogout().setBackground(escoPannelloTemaScuro);
		((MenuInfoAccount) getDashboard().getMenuInfoAccount()).getPanelPrestoInArrivo()
				.setBackground(escoPannelloTemaScuro);

		// NO CLICK
		getDashboard().getNoClick().setBackground(temaNC);

		// HOME
		getDashboard().getHome().setBackground(sfondoTemaScuro);

		// ACCESSO
		getDashboard().getAccesso().setBackground(sfondoTemaScuro);
		((Accesso) getDashboard().getAccesso()).getTxtEmail().setBackground(sfondoTemaScuro);
		((Accesso) getDashboard().getAccesso()).getTxtEmail().setForeground(coloreScritteTemaScuro);
		((Accesso) getDashboard().getAccesso()).getTxtPassword().setBackground(sfondoTemaScuro);
		((Accesso) getDashboard().getAccesso()).getTxtPassword().setForeground(coloreScritteTemaScuro);
		((Accesso) getDashboard().getAccesso()).getLblPasswordDimenticata().setForeground(coloreLabelTemaScuro);
		((Accesso) getDashboard().getAccesso()).getLblAvanti().setIcon(new ImageIcon(img.avanti1()));
		((Accesso) getDashboard().getAccesso()).getLblCredenziali().setIcon(new ImageIcon(img.credenzialiAccesso()));

		// REGISTRAZIONE
		getDashboard().getRegistrazione().setBackground(sfondoTemaScuro);
		((Registrazione) getDashboard().getRegistrazione()).getTxtNome().setBackground(sfondoTemaScuro);
		((Registrazione) getDashboard().getRegistrazione()).getTxtNome().setForeground(coloreScritteTemaScuro);
		((Registrazione) getDashboard().getRegistrazione()).getTxtCognome().setBackground(sfondoTemaScuro);
		((Registrazione) getDashboard().getRegistrazione()).getTxtCognome().setForeground(coloreScritteTemaScuro);
		((Registrazione) getDashboard().getRegistrazione()).getTxtEmail().setBackground(sfondoTemaScuro);
		((Registrazione) getDashboard().getRegistrazione()).getTxtEmail().setForeground(coloreScritteTemaScuro);
		((Registrazione) getDashboard().getRegistrazione()).getTxtPassword().setBackground(sfondoTemaScuro);
		((Registrazione) getDashboard().getRegistrazione()).getTxtPassword().setForeground(coloreScritteTemaScuro);
		((Registrazione) getDashboard().getRegistrazione()).getTxtRipetiPassword().setBackground(sfondoTemaScuro);
		((Registrazione) getDashboard().getRegistrazione()).getTxtRipetiPassword()
				.setForeground(coloreScritteTemaScuro);
		((Registrazione) getDashboard().getRegistrazione()).getLblAvanti().setIcon(new ImageIcon(img.avanti1()));
		((Registrazione) getDashboard().getRegistrazione()).getLblInserimentoCredenziali()
				.setIcon(new ImageIcon(img.credenzialiRegistrazione()));

		// PROFILO
		getDashboard().getProfilo().setBackground(sfondoTemaScuro);
		((Profilo) getDashboard().getProfilo()).getTxtNome().setBackground(sfondoTemaScuro);
		((Profilo) getDashboard().getProfilo()).getTxtNome().setForeground(coloreScritteTemaScuro);
		((Profilo) getDashboard().getProfilo()).getTxtCognome().setBackground(sfondoTemaScuro);
		((Profilo) getDashboard().getProfilo()).getTxtCognome().setForeground(coloreScritteTemaScuro);
		((Profilo) getDashboard().getProfilo()).getTxtEmail().setBackground(sfondoTemaScuro);
		((Profilo) getDashboard().getProfilo()).getTxtEmail().setForeground(coloreScritteTemaScuro);
		((Profilo) getDashboard().getProfilo()).getLblLogout().setForeground(coloreLabelTemaScuro);
		((Profilo) getDashboard().getProfilo()).getLblCambiaPassword().setForeground(coloreLabelTemaScuro);
		((Profilo) getDashboard().getProfilo()).getLblDatiAccount().setIcon(new ImageIcon(img.datiAccount()));

		// IMPOSTAZIONI
		getDashboard().getImpostazioni().setBackground(sfondoTemaScuro);
		((Impostazioni) getDashboard().getImpostazioni()).getLblInformazioni().setForeground(coloreLabelTemaScuro);
		((Impostazioni) getDashboard().getImpostazioni()).getLblTerminiECondizioni()
				.setForeground(coloreLabelTemaScuro);
		((Impostazioni) getDashboard().getImpostazioni()).getLblRecensione().setForeground(coloreLabelTemaScuro);

		// GESTIONE TRATTA
		getDashboard().getGestioneTratte().setBackground(sfondoTemaScuro);
		((GestioneTratte) getDashboard().getGestioneTratte()).getTxtBarraRicerca().setBackground(escoPannelloTemaScuro);

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
		((GestioneTratte) getDashboard().getGestioneTratte()).getTxtBarraRicerca()
				.setForeground(coloreScritteTemaScuro);
		((GestioneTratte) getDashboard().getGestioneTratte()).getLblCompagniaAerea()
				.setForeground(coloreScritteTemaScuro);

		((GestioneTratte) getDashboard().getGestioneTratte()).getTxtCittaPartenza()
				.setBorder(new LineBorder(bordiTemaScuro));
		((GestioneTratte) getDashboard().getGestioneTratte()).getTxtCittaArrivo()
				.setBorder(new LineBorder(bordiTemaScuro));
		((GestioneTratte) getDashboard().getGestioneTratte()).getTxtCodiceTratta()
				.setBorder(new LineBorder(bordiTemaScuro));
		((GestioneTratte) getDashboard().getGestioneTratte()).getComboBoxNomeCompagniaAerea()
				.setBorder(new LineBorder(bordiTemaScuro));
		((GestioneTratte) getDashboard().getGestioneTratte()).getTabella().setBorder(new LineBorder(bordiTemaScuro));

		((GestioneTratte) getDashboard().getGestioneTratte()).getLblModifica().setIcon(new ImageIcon(img.modifica1()));
		((GestioneTratte) getDashboard().getGestioneTratte()).getLblAggiungi().setIcon(new ImageIcon(img.aggiungi1()));
		((GestioneTratte) getDashboard().getGestioneTratte()).getLblElimina().setIcon(new ImageIcon(img.elimina1()));
		((GestioneTratte) getDashboard().getGestioneTratte()).getLblSvuota().setIcon(new ImageIcon(img.svuota1()));
		((GestioneTratte) getDashboard().getGestioneTratte()).getLblimgfrecciaIndietro()
				.setIcon(new ImageIcon(img.frecciaIndietro1()));
		((GestioneTratte) getDashboard().getGestioneTratte()).getLblBarraRicerca()
				.setIcon(new ImageIcon(img.barraRicerca()));
		((GestioneTratte) getDashboard().getGestioneTratte()).getLblRicaricaTabella()
				.setIcon(new ImageIcon(img.aggiorna1()));

		// GESTIONE COMPAGNIE AEREE
		getDashboard().getGestioneCompagnieAeree().setBackground(sfondoTemaScuro);
		((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).getLblCodiceCompagniaAerea()
				.setForeground(coloreScritteTemaScuro);
		((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).getLblNome()
				.setForeground(coloreScritteTemaScuro);
		((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).getTxtCodiceCompagniaAerea()
				.setForeground(coloreScritteSuBiancoTemaScuro);
		((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).getTxtNome()
				.setForeground(coloreScritteSuBiancoTemaScuro);

		((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).getLblModifica()
				.setIcon(new ImageIcon(img.modifica1()));
		((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).getLblAggiungi()
				.setIcon(new ImageIcon(img.aggiungi1()));
		((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).getLblElimina()
				.setIcon(new ImageIcon(img.elimina1()));
		((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).getLblSvuota()
				.setIcon(new ImageIcon(img.svuota1()));
		((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).getLblimgfrecciaIndietro()
				.setIcon(new ImageIcon(img.frecciaIndietro1()));
		((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).getLblBarraRicerca()
				.setIcon(new ImageIcon(img.barraRicerca()));
		((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).getTxtBarraRicerca()
				.setForeground(coloreScritteTemaScuro);

		((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).getTxtNome()
				.setBorder(new LineBorder(bordiTemaScuro));
		((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).getTxtCodiceCompagniaAerea()
				.setBorder(new LineBorder(bordiTemaScuro));
		((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).getTabella()
				.setBorder(new LineBorder(bordiTemaScuro));

		((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).getLblRicaricaTabella()
				.setIcon(new ImageIcon(img.aggiorna1()));
		((GestioneCompagnieAeree) getDashboard().getGestioneCompagnieAeree()).getTxtBarraRicerca()
				.setBackground(escoPannelloTemaScuro);

		// GESTIONE UTENTI
		getDashboard().getGestioneUtenti().setBackground(sfondoTemaScuro);
		((GestioneUtenti) getDashboard().getGestioneUtenti()).getLblNome().setForeground(coloreScritteTemaScuro);
		((GestioneUtenti) getDashboard().getGestioneUtenti()).getLblCognome().setForeground(coloreScritteTemaScuro);
		((GestioneUtenti) getDashboard().getGestioneUtenti()).getLblEmail().setForeground(coloreScritteTemaScuro);
		((GestioneUtenti) getDashboard().getGestioneUtenti()).getLblPassword().setForeground(coloreScritteTemaScuro);

		((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtNome().setForeground(coloreScritteTemaScuro);
		((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtCognome().setForeground(coloreScritteTemaScuro);
		((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtEmail().setForeground(coloreScritteTemaScuro);
		((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtPassword().setForeground(coloreScritteTemaScuro);

		((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtNome()
				.setForeground(coloreScritteSuBiancoTemaScuro);
		((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtCognome()
				.setForeground(coloreScritteSuBiancoTemaScuro);
		((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtEmail()
				.setForeground(coloreScritteSuBiancoTemaScuro);
		((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtPassword()
				.setForeground(coloreScritteSuBiancoTemaScuro);

		((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtNome().setBorder(new LineBorder(bordiTemaScuro));
		((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtCognome().setBorder(new LineBorder(bordiTemaScuro));
		((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtEmail().setBorder(new LineBorder(bordiTemaScuro));
		((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtPassword()
				.setBorder(new LineBorder(bordiTemaScuro));

		((GestioneUtenti) getDashboard().getGestioneUtenti()).getLblModifica().setIcon(new ImageIcon(img.modifica1()));
		((GestioneUtenti) getDashboard().getGestioneUtenti()).getLblElimina().setIcon(new ImageIcon(img.elimina1()));
		((GestioneUtenti) getDashboard().getGestioneUtenti()).getLblSvuota().setIcon(new ImageIcon(img.svuota1()));
		((GestioneUtenti) getDashboard().getGestioneUtenti()).getLblimgfrecciaIndietro()
				.setIcon(new ImageIcon(img.frecciaIndietro1()));
		((GestioneUtenti) getDashboard().getGestioneUtenti()).getLblBarraRicerca()
				.setIcon(new ImageIcon(img.barraRicerca()));
		((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtBarraRicerca()
				.setForeground(coloreScritteTemaScuro);

		((GestioneUtenti) getDashboard().getGestioneUtenti()).getLblRicaricaTabella()
				.setIcon(new ImageIcon(img.aggiorna1()));
		((GestioneUtenti) getDashboard().getGestioneUtenti()).getTxtBarraRicerca().setBackground(escoPannelloTemaScuro);

		// GESTIONE VOLI PARTENZE
		getDashboard().getGestioneVoliPartenze().setBackground(sfondoTemaScuro);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getLblCodiceVoloPartenze()
				.setForeground(coloreScritteTemaScuro);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getLblDataPartenza()
				.setForeground(coloreScritteTemaScuro);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getLblOraPartenza()
				.setForeground(coloreScritteTemaScuro);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getLblDuePuntiPartenza()
				.setForeground(coloreScritteTemaScuro);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getLblNumeroPrenoazioni()
				.setForeground(coloreScritteTemaScuro);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getLblGate()
				.setForeground(coloreScritteTemaScuro);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getLblCodiceTratta()
				.setForeground(coloreScritteTemaScuro);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getLblTempoDiImbarcoEffettivo()
				.setForeground(coloreScritteTemaScuro);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getLblStatus()
				.setForeground(coloreScritteTemaScuro);

		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtCodiceVoloPartenze()
				.setBorder(new LineBorder(bordiTemaScuro));
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getDateDataPartenza()
				.setBorder(new LineBorder(bordiTemaScuro));
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTabella()
				.setBorder(new LineBorder(bordiTemaScuro));
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtTempoDiImbarcoEffettivo()
				.setBorder(new LineBorder(bordiTemaScuro));
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtMinutoPartenza()
				.setBorder(new LineBorder(bordiTemaScuro));
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtOraPartenza()
				.setBorder(new LineBorder(bordiTemaScuro));
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtNumeroPrenotazioni()
				.setBorder(new LineBorder(bordiTemaScuro));

		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getComboBoxNumeroPorta()
				.setBorder(new LineBorder(bordiTemaScuro));
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getComboBoxCittaArrivo()
				.setBorder(new LineBorder(bordiTemaScuro));
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getComboBoxStatus()
				.setBorder(new LineBorder(bordiTemaScuro));

		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtCodiceVoloPartenze()
				.setForeground(coloreScritteSuBiancoTemaScuro);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getDateDataPartenza()
				.setForeground(coloreScritteSuBiancoTemaScuro);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtOraPartenza()
				.setForeground(coloreScritteSuBiancoTemaScuro);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtMinutoPartenza()
				.setForeground(coloreScritteSuBiancoTemaScuro);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtNumeroPrenotazioni()
				.setForeground(coloreScritteSuBiancoTemaScuro);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtTempoDiImbarcoEffettivo()
				.setForeground(coloreScritteSuBiancoTemaScuro);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getComboBoxNumeroPorta()
				.setForeground(coloreScritteSuBiancoTemaScuro);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getComboBoxCittaArrivo()
				.setForeground(coloreScritteSuBiancoTemaScuro);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getComboBoxStatus()
				.setForeground(coloreScritteSuBiancoTemaScuro);

		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getLblModifica()
				.setIcon(new ImageIcon(img.modifica1()));
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getLblAggiungi()
				.setIcon(new ImageIcon(img.aggiungi1()));
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getLblElimina()
				.setIcon(new ImageIcon(img.elimina1()));
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getLblSvuota()
				.setIcon(new ImageIcon(img.svuota1()));
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getLblRegistroVoli()
				.setIcon(new ImageIcon(img.registroVoli1()));
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getLblimgfrecciaIndietro()
				.setIcon(new ImageIcon(img.frecciaIndietro1()));
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getLblBarraRicerca()
				.setIcon(new ImageIcon(img.barraRicerca()));
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtBarraRicerca()
				.setForeground(coloreScritteTemaScuro);

		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getLblRicaricaTabella()
				.setIcon(new ImageIcon(img.aggiorna1()));
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getTxtBarraRicerca()
				.setBackground(escoPannelloTemaScuro);

		// REGISTRO VOLI PARTENZE
		getDashboard().getRegistroVoliPartenze().setBackground(sfondoTemaScuro);
		((RegistroVoliPartenze) getDashboard().getRegistroVoliPartenze()).getLblRicaricaTabella()
				.setIcon(new ImageIcon(img.aggiorna1()));
		((RegistroVoliPartenze) getDashboard().getRegistroVoliPartenze()).getLblimgfrecciaIndietro()
				.setIcon(new ImageIcon(img.frecciaIndietro1()));
		((RegistroVoliPartenze) getDashboard().getRegistroVoliPartenze()).getLblBarraRicerca()
				.setIcon(new ImageIcon(img.barraRicerca()));
		((RegistroVoliPartenze) getDashboard().getRegistroVoliPartenze()).getTxtBarraRicerca()
				.setBackground(escoPannelloTemaScuro);
		((RegistroVoliPartenze) getDashboard().getRegistroVoliPartenze()).getTxtBarraRicerca()
				.setForeground(coloreScritteTemaScuro);

		// GESTIONE VOLO ARRIVI
		getDashboard().getGestioneVoliArrivi().setBackground(sfondoTemaScuro);
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getLblCodiceVoloArrivi()
				.setForeground(bordiTemaScuro);
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getLblCittaPartenza()
				.setForeground(bordiTemaScuro);
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getLblDataArrivo().setForeground(bordiTemaScuro);
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getLblOraArrivo().setForeground(bordiTemaScuro);
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getLblDuePuntiArrivo()
				.setForeground(bordiTemaScuro);

		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTxtCodiceVoloArrivi()
				.setBorder(new LineBorder(bordiTemaChiaro));
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTxtCittaPartenza()
				.setBorder(new LineBorder(bordiTemaChiaro));
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTxtOraArrivo()
				.setBorder(new LineBorder(bordiTemaChiaro));
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTxtMinutoArrivo()
				.setBorder(new LineBorder(bordiTemaChiaro));

		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTxtCodiceVoloArrivi()
				.setForeground(coloreScritteSuBiancoTemaScuro);
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTxtCittaPartenza()
				.setForeground(coloreScritteSuBiancoTemaScuro);
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getDateDataArrivo()
				.setForeground(coloreScritteSuBiancoTemaScuro);
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTxtOraArrivo()
				.setForeground(coloreScritteSuBiancoTemaScuro);
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTxtMinutoArrivo()
				.setForeground(coloreScritteSuBiancoTemaScuro);

		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getLblModifica()
				.setIcon(new ImageIcon(img.modifica1()));
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getLblAggiungi()
				.setIcon(new ImageIcon(img.aggiungi1()));
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getLblElimina()
				.setIcon(new ImageIcon(img.elimina1()));
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getLblSvuota()
				.setIcon(new ImageIcon(img.svuota1()));
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getLblimgfrecciaIndietro()
				.setIcon(new ImageIcon(img.frecciaIndietro1()));
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getLblBarraRicerca()
				.setIcon(new ImageIcon(img.barraRicerca()));
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTxtBarraRicerca()
				.setForeground(coloreScritteTemaScuro);

		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getLblRicaricaTabella()
				.setIcon(new ImageIcon(img.aggiorna1()));
		((GestioneVoliArrivi) getDashboard().getGestioneVoliArrivi()).getTxtBarraRicerca()
				.setBackground(escoPannelloTemaScuro);

		// GESTIONE GATE
		getDashboard().getGestioneGate().setBackground(sfondoTemaScuro);
		((GestioneGate) getDashboard().getGestioneGate()).getLblCodiceGate().setForeground(coloreScritteTemaScuro);
		((GestioneGate) getDashboard().getGestioneGate()).getLblNumeroPorta().setForeground(coloreScritteTemaScuro);
		((GestioneGate) getDashboard().getGestioneGate()).getTxtCodiceGate()
				.setForeground(coloreScritteSuBiancoTemaScuro);
		((GestioneGate) getDashboard().getGestioneGate()).getTxtNumeroPorta()
				.setForeground(coloreScritteSuBiancoTemaScuro);

		((GestioneGate) getDashboard().getGestioneGate()).getTxtCodiceGate().setBorder(new LineBorder(bordiTemaScuro));
		((GestioneGate) getDashboard().getGestioneGate()).getTxtNumeroPorta().setBorder(new LineBorder(bordiTemaScuro));

		((GestioneGate) getDashboard().getGestioneGate()).getLblModifica().setIcon(new ImageIcon(img.modifica1()));
		((GestioneGate) getDashboard().getGestioneGate()).getLblAggiungi().setIcon(new ImageIcon(img.aggiungi1()));
		((GestioneGate) getDashboard().getGestioneGate()).getLblElimina().setIcon(new ImageIcon(img.elimina1()));
		((GestioneGate) getDashboard().getGestioneGate()).getLblSvuota().setIcon(new ImageIcon(img.svuota1()));
		((GestioneGate) getDashboard().getGestioneGate()).getLblimgfrecciaIndietro()
				.setIcon(new ImageIcon(img.frecciaIndietro1()));
		((GestioneGate) getDashboard().getGestioneGate()).getLblBarraRicerca()
				.setIcon(new ImageIcon(img.barraRicerca()));
		((GestioneGate) getDashboard().getGestioneGate()).getTxtBarraRicerca().setForeground(coloreScritteTemaScuro);

		((GestioneGate) getDashboard().getGestioneGate()).getLblRicaricaTabella()
				.setIcon(new ImageIcon(img.aggiorna1()));
		((GestioneGate) getDashboard().getGestioneGate()).getTxtBarraRicerca().setBackground(escoPannelloTemaScuro);

		// GESTIONE GATE CODA DI IMBARCO
		getDashboard().getGateCodeImbarco().setBackground(sfondoTemaScuro);
		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getTxtBarraRicerca()
				.setBackground(escoPannelloTemaScuro);
		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getTxtBarraRicerca()
				.setBackground(escoPannelloTemaScuro);

		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getLblCodiceGate()
				.setForeground(coloreScritteTemaScuro);
		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getLblCodaImbarco()
				.setForeground(coloreScritteTemaScuro);
		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getLblNomeCodaDiImbarco()
				.setForeground(coloreScritteTemaScuro);
		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getLblCodiceCodaDiImbarco()
				.setForeground(coloreScritteTemaScuro);
		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getLblTempoDiImbarcoStimato()
				.setForeground(coloreScritteTemaScuro);

		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getTxtBarraRicerca()
				.setForeground(coloreScritteTemaScuro);
		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getTxtCodaDiImbarco()
				.setForeground(coloreScritteSuBiancoTemaScuro);
		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getTxtCodiceCodaDiImbarco()
				.setForeground(coloreScritteSuBiancoTemaScuro);
		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getTxtCodiceGate()
				.setForeground(coloreScritteSuBiancoTemaScuro);
		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getTxtNomeCodaDiImbarco()
				.setForeground(coloreScritteSuBiancoTemaScuro);
		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getTxtTempoDiImbarcoStimato()
				.setForeground(coloreScritteSuBiancoTemaScuro);
		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getComboBoxNumeroPorta()
				.setForeground(coloreScritteSuBiancoTemaScuro);
		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getComboBoxCodaDiImbarco()
				.setForeground(coloreScritteSuBiancoTemaScuro);

		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getTxtCodiceCodaDiImbarco()
				.setBorder(new LineBorder(bordiTemaScuro));
		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getTxtNomeCodaDiImbarco()
				.setBorder(new LineBorder(bordiTemaScuro));
		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getTxtTempoDiImbarcoStimato()
				.setBorder(new LineBorder(bordiTemaScuro));
		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getComboBoxNumeroPorta()
				.setBorder(new LineBorder(bordiTemaScuro));
		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getComboBoxCodaDiImbarco()
				.setBorder(new LineBorder(bordiTemaScuro));

		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getLblAggiungiAssociazione()
				.setIcon(new ImageIcon(img.aggiungi1()));
		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getLblEliminaAssociazione()
				.setIcon(new ImageIcon(img.elimina1()));
		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getLblSvuotaAssociazione()
				.setIcon(new ImageIcon(img.svuota1()));
		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getLblimgfrecciaIndietro()
				.setIcon(new ImageIcon(img.frecciaIndietro1()));
		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getLblBarraRicerca()
				.setIcon(new ImageIcon(img.barraRicerca()));
		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getLblAggiungiCodaImbarco()
				.setIcon(new ImageIcon(img.aggiungi1()));
		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getLblEliminaCodaImbarco()
				.setIcon(new ImageIcon(img.elimina1()));
		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getLblSvuotaCodaImbarco()
				.setIcon(new ImageIcon(img.svuota1()));
		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getLblModificaCodaImbarco()
				.setIcon(new ImageIcon(img.modifica1()));
		((GateCodeImbarco) getDashboard().getGateCodeImbarco()).getLblRicaricaTabelle()
				.setIcon(new ImageIcon(img.aggiorna1()));

		// GESTIONE UTILIZZO GATE
		getDashboard().getUtilizzoGate().setBackground(sfondoTemaScuro);
		((UtilizzoGate) getDashboard().getUtilizzoGate()).getLblimgfrecciaIndietro()
				.setIcon(new ImageIcon(img.frecciaIndietro1()));
		((UtilizzoGate) getDashboard().getUtilizzoGate()).getLblSvuota().setIcon(new ImageIcon(img.svuota1()));
		((UtilizzoGate) getDashboard().getUtilizzoGate()).getLblRicaricaTabella()
				.setIcon(new ImageIcon(img.aggiorna1()));
		((UtilizzoGate) getDashboard().getUtilizzoGate()).getTxtBarraRicerca().setBackground(escoPannelloTemaScuro);
		((UtilizzoGate) getDashboard().getUtilizzoGate()).getTxtBarraRicerca().setForeground(coloreScritteTemaScuro);
		((UtilizzoGate) getDashboard().getUtilizzoGate()).getLblBarraRicerca()
				.setIcon(new ImageIcon(img.barraRicerca()));

		((UtilizzoGate) getDashboard().getUtilizzoGate()).getLblGiorno().setIcon(new ImageIcon(img.giorno1()));
		((UtilizzoGate) getDashboard().getUtilizzoGate()).getLblSettimana().setIcon(new ImageIcon(img.settimana1()));
		((UtilizzoGate) getDashboard().getUtilizzoGate()).getLblMese().setIcon(new ImageIcon(img.mese1()));

		((UtilizzoGate) getDashboard().getUtilizzoGate()).getLblCodiceGate().setForeground(coloreScritteTemaScuro);
		((UtilizzoGate) getDashboard().getUtilizzoGate()).getLblNumeroPorta().setForeground(coloreScritteTemaScuro);
		((UtilizzoGate) getDashboard().getUtilizzoGate()).getLblSelezionaData().setForeground(coloreScritteTemaScuro);
		((UtilizzoGate) getDashboard().getUtilizzoGate()).getLblCalcolaUtilizzo().setForeground(coloreScritteTemaScuro);

		((UtilizzoGate) getDashboard().getUtilizzoGate()).getTxtCodiceGate().setBorder(new LineBorder(bordiTemaScuro));
		((UtilizzoGate) getDashboard().getUtilizzoGate()).getTxtNumeroPorta().setBorder(new LineBorder(bordiTemaScuro));

		((UtilizzoGate) getDashboard().getUtilizzoGate()).getTxtCodiceGate()
				.setForeground(coloreScritteSuBiancoTemaScuro);
		((UtilizzoGate) getDashboard().getUtilizzoGate()).getTxtNumeroPorta()
				.setForeground(coloreScritteSuBiancoTemaScuro);

		// RECENSIONE
		getDashboard().getRecensioni().setBackground(sfondoTemaScuro);
		((Recensione) getDashboard().getRecensioni()).getLblimgfrecciaIndietro()
				.setIcon(new ImageIcon(img.frecciaIndietro1()));
		((Recensione) getDashboard().getRecensioni()).getLblInviaRecensione()
				.setIcon(new ImageIcon(img.inviaRecensione1()));
		((Recensione) getDashboard().getRecensioni()).getLblCommento().setForeground(coloreScritteTemaScuro);

		// CAMBIO PASSWORD
		getDashboard().getCambioPassword().setBackground(sfondoTemaScuro);
		((CambioPassword) getDashboard().getCambioPassword()).getTxtRipetiNuovaPassword()
				.setForeground(coloreScritteTemaScuro);
		((CambioPassword) getDashboard().getCambioPassword()).getTxtNuovaPassword()
				.setForeground(coloreScritteTemaScuro);
		((CambioPassword) getDashboard().getCambioPassword()).getTxtVecchiaPassword()
				.setForeground(coloreScritteTemaScuro);
		((CambioPassword) getDashboard().getCambioPassword()).getTxtVecchiaPassword().setBackground(sfondoTemaScuro);
		((CambioPassword) getDashboard().getCambioPassword()).getTxtNuovaPassword().setBackground(sfondoTemaScuro);
		((CambioPassword) getDashboard().getCambioPassword()).getTxtRipetiNuovaPassword()
				.setBackground(sfondoTemaScuro);
		((CambioPassword) getDashboard().getCambioPassword()).getLblSalva()
				.setIcon(new ImageIcon(img.salvaModifiche1()));
		((CambioPassword) getDashboard().getCambioPassword()).getLblAnnulla()
				.setIcon(new ImageIcon(img.frecciaIndietro1()));
		((CambioPassword) getDashboard().getCambioPassword()).getLblCambioPassword()
				.setIcon(new ImageIcon(img.cambioPassword()));

		// JDIALOG USCITA
		((Uscita) getDashboard().getUscita()).getLblLayout().setIcon(new ImageIcon(img.sfondoUscita()));
		((Uscita) getDashboard().getUscita()).getLblSpostaUscita().setIcon(new ImageIcon(img.spostaUscita()));
		((Uscita) getDashboard().getUscita()).getLblX().setIcon(new ImageIcon(img.X1()));
		((Uscita) getDashboard().getUscita()).getLblSi().setIcon(new ImageIcon(img.si1()));
		((Uscita) getDashboard().getUscita()).getLblAnnulla().setIcon(new ImageIcon(img.annullaUscita1()));
		((Uscita) getDashboard().getUscita()).getLblUscire().setForeground(coloreScritteTemaScuro);

		// PASSWORD DIMENTICATA
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
		((PasswordDimenticata) getDashboard().getPasswordDimenticata()).getLblAnnulla()
				.setIcon(new ImageIcon(img.annullaUscita1()));

		// JDIALOG SCELTA PROFILO SENZA ACCESSO
		((SceltaProfiloSenzaAccesso) getDashboard().getSceltaProfiloSenzaAccesso()).getLblLayout()
				.setIcon(new ImageIcon(img.sfondoUscita()));
		((SceltaProfiloSenzaAccesso) getDashboard().getSceltaProfiloSenzaAccesso())
				.getLblSpostaSceltaProfiloSenzaAccesso().setIcon(new ImageIcon(img.spostaUscita()));
		((SceltaProfiloSenzaAccesso) getDashboard().getSceltaProfiloSenzaAccesso()).getLblX()
				.setIcon(new ImageIcon(img.X1()));
		((SceltaProfiloSenzaAccesso) getDashboard().getSceltaProfiloSenzaAccesso()).getLblContinuare()
				.setForeground(coloreLabelTemaScuro);

		((SceltaProfiloSenzaAccesso) getDashboard().getSceltaProfiloSenzaAccesso()).getLblAccedi()
				.setIcon(new ImageIcon(img.accedi1()));
		((SceltaProfiloSenzaAccesso) getDashboard().getSceltaProfiloSenzaAccesso()).getLblRegistrati()
				.setIcon(new ImageIcon(img.registrati1()));
		((SceltaProfiloSenzaAccesso) getDashboard().getSceltaProfiloSenzaAccesso()).getLblAnnulla()
				.setIcon(new ImageIcon(img.annulla1()));

		// JDIALOG SCELTA VOLI
		((SceltaVolo) getDashboard().getSceltaVolo()).getLblLayout().setIcon(new ImageIcon(img.sfondoUscita()));
		((SceltaVolo) getDashboard().getSceltaVolo()).getLblSpostaSceltaVolo()
				.setIcon(new ImageIcon(img.spostaUscita()));
		((SceltaVolo) getDashboard().getSceltaVolo()).getLblX().setIcon(new ImageIcon(img.X1()));

		((SceltaVolo) getDashboard().getSceltaVolo()).getLblPartenze().setIcon(new ImageIcon(img.partenze1()));
		((SceltaVolo) getDashboard().getSceltaVolo()).getLblArrivi().setIcon(new ImageIcon(img.arrivi1()));
		((SceltaVolo) getDashboard().getSceltaVolo()).getLblAnnulla().setIcon(new ImageIcon(img.annulla1()));

		((SceltaVolo) getDashboard().getSceltaVolo()).getLblScelta().setForeground(coloreLabelTemaScuro);

		// TERMINI E CONDIZIONI
		((TerminiECondizioni) getDashboard().getTerminiECondizioni()).getLblAnnulla()
				.setIcon(new ImageIcon(img.tornaIndietro1()));

		// INFORMAZIONI
		((Informazioni) getDashboard().getInformazioni()).getLblTornaIndietro()
				.setIcon(new ImageIcon(img.tornaIndietro1()));

		// JDIALOG SCELTA GATE
		((SceltaGate) getDashboard().getSceltaGate()).getLblCodeDiImbarco()
				.setIcon(new ImageIcon(img.codeDiImbarco1()));
		((SceltaGate) getDashboard().getSceltaGate()).getLblGate().setIcon(new ImageIcon(img.gateScelta1()));
		((SceltaGate) getDashboard().getSceltaGate()).getLblAnnulla().setIcon(new ImageIcon(img.annulla1()));
		((SceltaGate) getDashboard().getSceltaGate()).getLblX().setIcon(new ImageIcon(img.X1()));
		((SceltaGate) getDashboard().getSceltaGate()).getLblScelta().setForeground(coloreLabelTemaScuro);
		((SceltaGate) getDashboard().getSceltaGate()).getLblLayout().setIcon(new ImageIcon(img.sfondoUscita()));
		((SceltaGate) getDashboard().getSceltaGate()).getLblSpostaSceltaVolo()
				.setIcon(new ImageIcon(img.spostaUscita()));

	}

	// METODI TOOLTIP
	public void chiudiTuttiTT() {
		getDashboard().getLblMenuTT().setVisible(false);
		getDashboard().getLblHomeTT().setVisible(false);
		getDashboard().getLblAccediTT().setVisible(false);
		getDashboard().getLblRegistratiTT().setVisible(false);
		getDashboard().getLblProfiloTT().setVisible(false);
		getDashboard().getLblImpostazioniTT().setVisible(false);
		getDashboard().getLblEsciTT().setVisible(false);
		getDashboard().getLblCambioTemaTT().setVisible(false);
		((GestioneVoliPartenze) getDashboard().getGestioneVoliPartenze()).getLblRegistroVoliTT().setVisible(false);
	}
}