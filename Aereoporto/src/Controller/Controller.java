package Controller;

import java.sql.*;

import java.util.List;
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
	Prenotazioni prenotazioni;
	Launcher launcher;

	public static void main(String[] args) {

		Controller controller = new Controller();

	}

	public Controller() { // prima schermata
		launcher = new Launcher(this);
		launcher.setVisible(true);
	}

	public boolean controlloCampiSeVuoti() {
		if (accesso.getTxtUtente().getText().length() <= 0 && accesso.getTxtPassword().getText().length() <= 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean controlloAccessoPassword() {
		if (!(accesso.getTxtPassword().getText().equals("Password"))) {
			return false;
		} else {
			return true;
		}
	}

	public void Avvio() {
		avvio = new Avvio(this);
		launcher.setVisible(false);
		avvio.setVisible(true);
	}

	public void Accesso() { // entro in accesso
		accesso = new Accesso(this);
		avvio.setVisible(false);
		accesso.setVisible(true);
	}

	public void Registrazione() { // entro in registrazione da avvio
		registrazione = new Registrazione(this);
		avvio.setVisible(false);
		registrazione.setVisible(true);
	}

	public void registrazioneDaAccesso() { // entro in registrazione da accesso tramite crea un nuovo account
		registrazione = new Registrazione(this);
		accesso.setVisible(false);
		registrazione.setVisible(true);
	}

	public void menuGestioneDaAccesso() { // entro in menu gestione da accesso
		menuGestione = new MenuGestione(this);
		accesso.setVisible(false);
		menuGestione.setVisible(true);
	}

	public void menuGestioneDaRegistrazione() { // entro in menu gestione da registrazione
		menuGestione = new MenuGestione(this);
		registrazione.setVisible(false);
		menuGestione.setVisible(true);
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

	public void tornaAdAvvioDaAccesso() { // torno ad avvio da accesso
		accesso.setVisible(false);
		avvio.setVisible(true);
	}

	public void tornaAdAvvioDaRegistrazione() { // torno ad avvio da registrazione
		registrazione.setVisible(false);
		avvio.setVisible(true);
	}

	public void tornaAdAccessoDaRegistrazione() { // torno ad accesso da registrazione
		registrazione.setVisible(false);
		accesso.setVisible(true);
	}
}
