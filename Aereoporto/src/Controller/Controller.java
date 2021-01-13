package Controller;

import java.sql.*;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;

import Classi.*;
import Database.*;
import GUI.*;

public class Controller {

	Accesso accesso;
	Avvio avvio;
	Registrazione registrazione;
	Riconoscimenti riconoscimenti;
	MenuGestione menuGestione;
	Voli voli;
	Prenotazione prenotazioni;
	GestioneUtenti gestioneUtenti;
	GestioneCompagnieAeree gestioneCompagnieAeree;
	GestioneTratte gestioneTratte;
	GestioneGate gestioneGate;
	Launcher launcher;

	public static void main(String[] args) {
		Controller controller = new Controller();
	}

	// COSTRUTTORE
	public Controller() { // prima schermata
		launcher = new Launcher(this);
		launcher.setVisible(true);
	}

	// METODI DI AVVIO
	public void Avvio() {
		avvio = new Avvio(this);
		accesso = new Accesso(this);
		registrazione = new Registrazione(this);
		menuGestione = new MenuGestione(this);
		voli = new Voli(this);
		riconoscimenti = new Riconoscimenti(this);
		prenotazioni = new Prenotazione(this);
		gestioneUtenti = new GestioneUtenti(this);
		gestioneCompagnieAeree = new GestioneCompagnieAeree(this);
		gestioneTratte = new GestioneTratte(this);
		gestioneGate = new GestioneGate(this);
		launcher.setVisible(false);
		avvio.setVisible(true);
	}

	// METODI DI ACCESSO
	public void Accesso() { // entro in accesso
		avvio.setVisible(false);
		accesso.setVisible(true);
	}

	public boolean controlloCampiSeVuotiAccesso() {
		if (accesso.getTxtEmail().getText().length() <= 0 && accesso.getTxtPassword().getText().length() <= 0) {
			return true;
		} else {
			return false;
		}
	}

	public void vaiARegistrazione() { // vai ad accesso da registrazione
		accesso.setVisible(false);
		registrazione.setVisible(true);
		accesso.svuotaCampi();
	}

	public void vaiAMenuGestione() {
		accesso.setVisible(false);
		menuGestione.setVisible(true);
	}

	public void gestioneUtentiDaAccesso() {
		accesso.setVisible(false);
		gestioneUtenti.setVisible(true);
	}

	public void vaiARegistrazioneDaAccesso() { // entro in registrazione da accesso tramite crea un nuovo account
		accesso.setVisible(false);
		registrazione.setVisible(true);
		registrazione.svuotaCampi();
	}

	public void menuGestioneDaAccesso() { // entro in menu gestione da accesso
		accesso.setVisible(false);
		menuGestione.setVisible(true);
	}

	public void tornaAdAvvioDaAccesso() { // torno ad avvio da accesso
		accesso.setVisible(false);
		avvio.setVisible(true);
	}

	// METODI DI REGISTRAZIONE
	public void Registrazione() { // entro in registrazione da avvio
		avvio.setVisible(false);
		registrazione.setVisible(true);
		registrazione.svuotaCampi();
	}

	public void tornaAdAccessoDaRegistrazione() { // torno ad accesso da registrazione
		registrazione.setVisible(false);
		accesso.setVisible(true);
		accesso.svuotaCampi();
	}

	public void tornaAdAvvioDaRegistrazione() { // torno ad avvio da registrazione
		registrazione.setVisible(false);
		avvio.setVisible(true);
	}

	public void vaiAdAccessoDopoRegistrazione() {
		registrazione.setVisible(false);
		accesso.setVisible(true);
		accesso.svuotaCampi();
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

	// METODI DI MENU' GESTIONE

	public void tornaAdAvvioDaMenuGestione() { // torno ad avvio da menu gestione
		menuGestione.setVisible(false);
		avvio.setVisible(true);
	}

	public void tornaAdAccessoDaMenuGestione() { // torno ad accesso da menu gestione
		menuGestione.setVisible(false);
		accesso.setVisible(true);
		accesso.svuotaCampi();
	}

	public void tornaARegistrazioneDaMenuGestione() { // torno a registrazione da menu gestione
		menuGestione.setVisible(false);
		registrazione.setVisible(true);
		registrazione.svuotaCampi();
	}

	public void vaiAGestioneCompagniaAereaDaMenuGestione() {
		menuGestione.setVisible(false);
		gestioneCompagnieAeree.setVisible(true);
	}

	public void vaiAGestioneTrattaDaMenuGestione() {
		menuGestione.setVisible(false);
		gestioneTratte.setVisible(true);
	}

	public void vaiAGestioneGateDaMenuGestione() {
		menuGestione.setVisible(false);
		gestioneGate.setVisible(true);
	}

	// METODI GESTIONE UTENTI
	public void svuotaCampiGestioneUtenti() {
		gestioneUtenti.getTxtNome().setText("");
		gestioneUtenti.getTxtCognome().setText("");
		gestioneUtenti.getTxtEmail().setText("");
		gestioneUtenti.getTxtPassword().setText("");
	}

	public void tornaAdAccessoDaGestioneUtenti() {
		gestioneUtenti.setVisible(false);
		accesso.setVisible(true);
		accesso.svuotaCampi();
	}

	public void tornaAdAvvioDaGestioneUtenti() {
		gestioneUtenti.setVisible(false);
		avvio.setVisible(true);
	}

	// METODI GESTIONE COMPAGNIA AEREA

	public void svuotaCampiCompagniaAerea() {
		gestioneCompagnieAeree.getTxtNome().setText("");
		gestioneCompagnieAeree.getTxtCodiceCompagniaAerea().setText("");
	}

	public void tornaAMenuGestioneDaGestioneCompagniaAeree() {
		gestioneCompagnieAeree.setVisible(false);
		menuGestione.setVisible(true);
	}

	public void tornaAdAvvioDaGestioneCompagniaAeree() {
		gestioneCompagnieAeree.setVisible(false);
		avvio.setVisible(true);
	}

	// METODI GESTIONE TRATTE

	public void svuotaCampiTratte() {
		gestioneTratte.getTxtCodiceTratta().setText("");
		gestioneTratte.getTxtCittaPartenza().setText("");
		gestioneTratte.getTxtCittaArrivo().setText("");
		gestioneTratte.getDateDataPartenza().setDate(null);
		gestioneTratte.getDateDataArrivo().setDate(null);
		gestioneTratte.getTxtOrarioPartenza().setText("");
		gestioneTratte.getTxtOrarioArrivo().setText("");
		gestioneTratte.getTxtNumeroPrenotazioni().setText(null);
	}

	public void tornaAMenuGestioneDaGestioneTratte() {
		gestioneTratte.setVisible(false);
		menuGestione.setVisible(true);
	}

	public void tornaAdAvvioDaGestioneTratte() {
		gestioneTratte.setVisible(false);
		avvio.setVisible(true);
	}

	// METODI GESTIONE GATE

	public void svuotaCampiGate() {
		gestioneGate.getTxtCodiceGate().setText("");
		gestioneGate.getTxtNumeroPorta().setText("");
		gestioneGate.getTxtInizioImbarco().setText("");
		gestioneGate.getTxtFineImbarco().setText("");
	}

	public void tornaAMenuGestioneDaGestioneGate() {
		gestioneGate.setVisible(false);
		menuGestione.setVisible(true);
	}

	public void tornaAdAvvioDaGestioneGate() {
		gestioneGate.setVisible(false);
		avvio.setVisible(true);
	}
	
	
	//METODI DI RITARDO
	
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
	
	
	

	// METODI DI PROVA
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
