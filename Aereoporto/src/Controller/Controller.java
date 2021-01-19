package Controller;

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

	Accesso accesso;

	Registrazione registrazione;
	Riconoscimenti riconoscimenti;
	MenuGestione menuGestione;
	GestioneVoli gestioneVoli;
	Prenotazione prenotazioni;
	GestioneUtenti gestioneUtenti;
	GestioneCompagnieAeree gestioneCompagnieAeree;
	GestioneTratte gestioneTratte;
	GestioneGate gestioneGate;
	Launcher launcher;

	Utente utn;
	Volo vl;
	Gate gt;
	Tratta trt;
	CompagniaAerea compAerea;

	public static void main(String[] args) {
		Controller controller = new Controller();
	}

	// COSTRUTTORE
	public Controller() { // prima schermata

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
		launcher = new Launcher(this);
		launcher.setVisible(true);
	}

	// METODI LAUNCHER
	public void vaiAdAccessoDaLauncher() {
		launcher.setVisible(false);
		accesso.setVisible(true);
	}

	// METODI DI ACCESSO
	public void Accesso() { // entro in accesso
		launcher.setVisible(false);
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

	// METODI DI REGISTRAZIONE
	public void Registrazione() { // entro in registrazione da avvio
		launcher.setVisible(false);
		registrazione.setVisible(true);
		registrazione.svuotaCampi();
	}

	public void tornaAdAccessoDaRegistrazione() { // torno ad accesso da registrazione
		registrazione.setVisible(false);
		accesso.setVisible(true);
		accesso.svuotaCampi();
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

	public void vaiAGestioneVoliDaMenuGestione() {
		menuGestione.setVisible(false);
		gestioneVoli.setVisible(true);
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
	
	public UtenteImplementazionePostgresDAO implementazioneUtenteDAO() {
		UtenteImplementazionePostgresDAO dao = new UtenteImplementazionePostgresDAO();
		return dao;
	}

	public void aggiungiUtente() {
		utn = new Utente(gestioneUtenti.getTxtNome().getText(), gestioneUtenti.getTxtCognome().getText(), gestioneUtenti.getTxtEmail().getText(), gestioneUtenti.getTxtPassword().getText());
		implementazioneUtenteDAO().registrazioneUtente(utn);
		gestioneUtenti.getModello().addRow(gestioneUtenti.getRow());
		svuotaCampiGestioneUtenti();
		gestioneUtenti.caricamento();
	}

	public void eliminaUtente() {
		utn = new Utente(gestioneUtenti.getTxtNome().getText(), gestioneUtenti.getTxtCognome().getText(), gestioneUtenti.getTxtEmail().getText(), gestioneUtenti.getTxtPassword().getText());
		int t = gestioneUtenti.getTable().getSelectedRow();
		implementazioneUtenteDAO().cancellaUtente(utn);
		gestioneUtenti.getModello().removeRow(t);
		svuotaCampiGestioneUtenti();
		gestioneUtenti.caricamento();
	}

	public void modificaUtente() {
		utn = new Utente(gestioneUtenti.getTxtNome().getText(), gestioneUtenti.getTxtCognome().getText(), gestioneUtenti.getTxtEmail().getText(), gestioneUtenti.getTxtPassword().getText());
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

	public void tornaAMenuGestioneDaGestioneCompagniaAeree() {
		gestioneCompagnieAeree.setVisible(false);
		menuGestione.setVisible(true);
	}

	public CompagniaAereaImplementazionePostgresDAO implementazioneCompagniaAereaDAO() {
		CompagniaAereaImplementazionePostgresDAO dao = new CompagniaAereaImplementazionePostgresDAO();
		return dao;
	}

	public void aggiungiCompagniaAerea() {
		compAerea = new CompagniaAerea(gestioneCompagnieAeree.getTxtCodiceCompagniaAerea().getText(), gestioneCompagnieAeree.getTxtNome().getText());
		implementazioneCompagniaAereaDAO().aggiungiCompagniaAerea(compAerea);
		gestioneCompagnieAeree.getModello().addRow(gestioneCompagnieAeree.getRow());
		svuotaCampiCompagniaAerea();
		gestioneCompagnieAeree.caricamento();
	}

	public void eliminaCompagniaAerea() {
		compAerea = new CompagniaAerea(gestioneCompagnieAeree.getTxtNome().getText(), gestioneCompagnieAeree.getTxtCodiceCompagniaAerea().getText());
		int t = gestioneCompagnieAeree.getTable().getSelectedRow();
		implementazioneCompagniaAereaDAO().cancellaCompagniaAerea(compAerea);
		gestioneCompagnieAeree.getModello().removeRow(t);
		svuotaCampiCompagniaAerea();
		gestioneCompagnieAeree.caricamento();
	}

	public void modificaCompagniaAerea() {
		compAerea = new CompagniaAerea(gestioneCompagnieAeree.getTxtNome().getText(), gestioneCompagnieAeree.getTxtCodiceCompagniaAerea().getText());
		int t = gestioneCompagnieAeree.getTable().getSelectedRow();
		
		gestioneCompagnieAeree.getModello().setValueAt(gestioneCompagnieAeree.getTxtNome().getText(), t, 0);
		gestioneCompagnieAeree.getModello().setValueAt(gestioneCompagnieAeree.getTxtCodiceCompagniaAerea().getText(), t, 1);
		
		implementazioneCompagniaAereaDAO().modificaCompagniaAerea(compAerea);
		svuotaCampiCompagniaAerea();
		gestioneCompagnieAeree.caricamento();
	}

	// METODI GESTIONE TRATTE

	public void svuotaCampiTratta() {
		gestioneTratte.getTxtCodiceTratta().setText("");
		gestioneTratte.getTxtCittaPartenza().setText("");
		gestioneTratte.getTxtCittaArrivo().setText("");
	}

	public void tornaAMenuGestioneDaGestioneTratte() {
		gestioneTratte.setVisible(false);
		menuGestione.setVisible(true);
	}

	public TrattaImplementazionePostgresDAO implementazioneTrattaDAO() {
		TrattaImplementazionePostgresDAO dao = new TrattaImplementazionePostgresDAO();
		return dao;
	}

	public void aggiungiTratta() {
		trt = new Tratta(gestioneTratte.getTxtCodiceTratta().getText(), gestioneTratte.getTxtCittaPartenza().getText(),
				gestioneTratte.getTxtCittaArrivo().getText());
		implementazioneTrattaDAO().aggiungiTratta(trt);
		gestioneTratte.getModello().addRow(gestioneTratte.getRow());
		svuotaCampiTratta();
		gestioneTratte.caricamento();
	}

	public void eliminaTratta() {
		trt = new Tratta(gestioneTratte.getTxtCodiceTratta().getText(), gestioneTratte.getTxtCittaPartenza().getText(),
				gestioneTratte.getTxtCittaArrivo().getText());

		int t = gestioneTratte.getTable().getSelectedRow();
		implementazioneTrattaDAO().cancellaTratta(trt);
		gestioneTratte.getModello().removeRow(t);
		svuotaCampiTratta();
		gestioneTratte.caricamento();
	}

	public void modificaTratta() {
		trt = new Tratta(gestioneTratte.getTxtCodiceTratta().getText(), gestioneTratte.getTxtCittaPartenza().getText(),
				gestioneTratte.getTxtCittaArrivo().getText());

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

	public void tornaAMenuGestioneDaGestioneVoli() {
		gestioneVoli.setVisible(false);
		menuGestione.setVisible(true);
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
		gestioneGate.getTxtCodiceGate().setText("");
		gestioneGate.getTxtNumeroPorta().setText("");
		gestioneGate.getTxtInizioImbarco().setText("");
		gestioneGate.getTxtFineImbarco().setText("");
	}

	public void tornaAMenuGestioneDaGestioneGate() {
		gestioneGate.setVisible(false);
		menuGestione.setVisible(true);
	}

	public GateImplementazionePostgresDAO implementazioneGateDAO() {
		GateImplementazionePostgresDAO dao = new GateImplementazionePostgresDAO();
		return dao;
	}

	public void aggiungiGate() {
		gt = new Gate(gestioneGate.getTxtCodiceGate().getText(), gestioneGate.getTxtNumeroPorta().getText(),
				gestioneGate.getTxtInizioImbarco().getText(), gestioneGate.getTxtFineImbarco().getText());
		implementazioneGateDAO().aggiungiGate(gt);
		gestioneGate.getModello().addRow(gestioneGate.getRow());
		svuotaCampiVolo();
		gestioneGate.caricamento();
	}

	public void eliminaGate() {
		gt = new Gate(gestioneGate.getTxtCodiceGate().getText(), gestioneGate.getTxtNumeroPorta().getText(),
				gestioneGate.getTxtInizioImbarco().getText(), gestioneGate.getTxtFineImbarco().getText());

		int t = gestioneGate.getTable().getSelectedRow();
		implementazioneGateDAO().cancellaGate(gt);
		gestioneGate.getModello().removeRow(t);
		svuotaCampiVolo();
		gestioneGate.caricamento();
	}

	public void modificaGate() {
		gt = new Gate(gestioneGate.getTxtCodiceGate().getText(), gestioneGate.getTxtNumeroPorta().getText(),
				gestioneGate.getTxtInizioImbarco().getText(), gestioneGate.getTxtFineImbarco().getText());

		int t = gestioneGate.getTable().getSelectedRow();

		gestioneGate.getModello().setValueAt(gestioneGate.getTxtCodiceGate().getText(), t, 0);
		gestioneGate.getModello().setValueAt(gestioneGate.getTxtNumeroPorta().getText(), t, 1);
		gestioneGate.getModello().setValueAt(gestioneGate.getTxtInizioImbarco().getText(), t, 2);
		gestioneGate.getModello().setValueAt(gestioneGate.getTxtFineImbarco().getText(), t, 3);

		implementazioneGateDAO().modificaGate(gt);
		svuotaCampiGate();
		gestioneGate.caricamento();
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
