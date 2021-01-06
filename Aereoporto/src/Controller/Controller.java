package Controller;

import java.sql.*;

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
	Launcher launcher;

	public static void main(String[] args) {
		Controller controller = new Controller();
	}

	// COSTRUTTORE
	public Controller() { // prima schermata
		avvio = new Avvio(this);
		accesso = new Accesso(this);
		registrazione = new Registrazione(this);
		menuGestione = new MenuGestione(this);
		voli = new Voli(this);
		riconoscimenti = new Riconoscimenti(this);
		prenotazioni = new Prenotazione(this);
		gestioneUtenti = new GestioneUtenti(this);
		launcher = new Launcher(this);
		launcher.setVisible(true);
	}

	// METODI DI AVVIO
	public void Avvio() {
		launcher.setVisible(false);
		avvio.setVisible(true);
	}

	// METODI DI ACCESSO
	public boolean controlloCampiSeVuotiAccesso() {
		if (accesso.getTxtUtente().getText().length() <= 0 && accesso.getTxtPassword().getText().length() <= 0) {
			return true;
		} else {
			return false;
		}
	}

	public void Accesso() { // entro in accesso
		avvio.setVisible(false);
		accesso.setVisible(true);
	}

	public void gestioneUtentiDaAccesso() {
		accesso.setVisible(false);
		gestioneUtenti.setVisible(true);
	}

	public void registrazioneDaAccesso() { // entro in registrazione da accesso tramite crea un nuovo account
		accesso.setVisible(false);
		registrazione.setVisible(true);
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
	}

	public void tornaAdAvvioDaRegistrazione() { // torno ad avvio da registrazione
		registrazione.setVisible(false);
		avvio.setVisible(true);
	}

	public void tornaAdAccessoDaRegistrazione() { // torno ad accesso da registrazione
		registrazione.setVisible(false);
		accesso.setVisible(true);
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
	}
	public void tornaARegistrazioneDaMenuGestione() { // torno a registrazione da menu gestione
		menuGestione.setVisible(false);
		registrazione.setVisible(true);
	}

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
