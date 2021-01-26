package Immagini;

import java.awt.Image;

import javax.swing.ImageIcon;

import GUI.Accesso;

public class Immagini {

	private Image immagine;

	public Immagini() {

	}

	// METODI
	public Image sfondo() {
		Image imgSfondo = new ImageIcon(Accesso.class.getResource("immaginiDashboard/SfondoDashboard.png")).getImage()
				.getScaledInstance(1143, 677, Image.SCALE_SMOOTH);
		return imgSfondo;
	}

	public Image tendina() {
		Image tendina = new ImageIcon(Accesso.class.getResource("immaginiDashboard/TendinaDashboard.png")).getImage()
				.getScaledInstance(238, 677, Image.SCALE_SMOOTH);
		return tendina;
	}

	public Image linee1() {
		Image linee1 = new ImageIcon(Accesso.class.getResource("immaginiDashboard/linee1.png")).getImage()
				.getScaledInstance(25, 15, Image.SCALE_SMOOTH);
		return linee1;
	}

	public Image linee2() {
		Image linee2 = new ImageIcon(Accesso.class.getResource("immaginiDashboard/linee2.png")).getImage()
				.getScaledInstance(25, 15, Image.SCALE_SMOOTH);
		return linee2;
	}

	public Image X1() {
		Image X1 = new ImageIcon(Accesso.class.getResource("immaginiDashboard/X1.png")).getImage().getScaledInstance(20,
				20, Image.SCALE_SMOOTH);
		return X1;
	}

	public Image X2() {
		Image X2 = new ImageIcon(Accesso.class.getResource("immaginiDashboard/X2.png")).getImage().getScaledInstance(20,
				20, Image.SCALE_SMOOTH);
		return X2;
	}

	public Image minimizza1() {
		Image minimizza1 = new ImageIcon(Accesso.class.getResource("immaginiDashboard/minimizza1.png")).getImage()
				.getScaledInstance(16, 5, Image.SCALE_SMOOTH);
		return minimizza1;
	}

	public Image minimizza2() {
		Image minimizza2 = new ImageIcon(Accesso.class.getResource("immaginiDashboard/minimizza2.png")).getImage()
				.getScaledInstance(16, 5, Image.SCALE_SMOOTH);
		return minimizza2;
	}

	public Image casa() {
		Image casa = new ImageIcon(Accesso.class.getResource("immaginiDashboard/home.png")).getImage()
				.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		return casa;
	}

	public Image accedi() {
		Image accedi = new ImageIcon(Accesso.class.getResource("immaginiDashboard/accesso.png")).getImage()
				.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		return accedi;
	}

	public Image registrati() {
		Image registrati = new ImageIcon(Accesso.class.getResource("immaginiDashboard/registrazione.png")).getImage()
				.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		return registrati;
	}

	public Image profilo() {
		Image profilo = new ImageIcon(Accesso.class.getResource("immaginiDashboard/profilo.png")).getImage()
				.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		return profilo;
	}

	public Image impostazioni() {
		Image impostazioni = new ImageIcon(Accesso.class.getResource("immaginiDashboard/impostazioni.png")).getImage()
				.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		return impostazioni;
	}

	public Image esci() {
		Image esci = new ImageIcon(Accesso.class.getResource("immaginiDashboard/esci.png")).getImage()
				.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		return esci;
	}

	public Image titolo() {
		Image titolo = new ImageIcon(Accesso.class.getResource("immaginiDashboard/titolo.png")).getImage()
				.getScaledInstance(217, 18, Image.SCALE_SMOOTH);
		return titolo;
	}

	public Image imgSfondoFull() {
		Image imgSfondoFull = new ImageIcon(Accesso.class.getResource("immaginiDashboard/SfondoDashboard.png"))
				.getImage().getScaledInstance(1920, 1080, Image.SCALE_SMOOTH);
		return imgSfondoFull;
	}

	public Image avanti1() {
		Image avanti1 = new ImageIcon(Accesso.class.getResource("immaginiAccesso/avanti1.png")).getImage()
				.getScaledInstance(196, 50, Image.SCALE_SMOOTH);
		return avanti1;
	}

	public Image avanti2() {
		Image avanti2 = new ImageIcon(Accesso.class.getResource("immaginiRegistrazione/avanti2.png")).getImage()
				.getScaledInstance(216, 70, Image.SCALE_SMOOTH);
		return avanti2;
	}

	public Image mostraPassword() {
		Image mostraPassword = new ImageIcon(Accesso.class.getResource("immaginiAccesso/mostraPassword.png")).getImage()
				.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		return mostraPassword;
	}

	public Image censuraPassword() {
		Image censuraPassword = new ImageIcon(Accesso.class.getResource("immaginiAccesso/censuraPassword.png"))
				.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		return censuraPassword;
	}

	public Image voli1() {
		Image voli1 = new ImageIcon(Accesso.class.getResource("immaginiHome/voli1.png")).getImage()
				.getScaledInstance(272, 157, Image.SCALE_SMOOTH);
		return voli1;
	}

	public Image voli2() {
		Image voli2 = new ImageIcon(Accesso.class.getResource("immaginiHome/voli2.png")).getImage()
				.getScaledInstance(276, 162, Image.SCALE_SMOOTH);
		return voli2;
	}

	public Image gate1() {
		Image gate1 = new ImageIcon(Accesso.class.getResource("immaginiHome/gate1.png")).getImage()
				.getScaledInstance(272, 157, Image.SCALE_SMOOTH);
		return gate1;
	}

	public Image gate2() {
		Image gate2 = new ImageIcon(Accesso.class.getResource("immaginiHome/gate2.png")).getImage()
				.getScaledInstance(276, 162, Image.SCALE_SMOOTH);
		return gate2;
	}

	public Image prenotazioni1() {
		Image prenotazioni1 = new ImageIcon(Accesso.class.getResource("immaginiHome/prenotazioni1.png")).getImage()
				.getScaledInstance(272, 157, Image.SCALE_SMOOTH);
		return prenotazioni1;
	}

	public Image prenotazioni2() {
		Image prenotazioni2 = new ImageIcon(Accesso.class.getResource("immaginiHome/prenotazioni2.png")).getImage()
				.getScaledInstance(276, 162, Image.SCALE_SMOOTH);
		return prenotazioni2;
	}

	public Image tratte1() {
		Image tratte1 = new ImageIcon(Accesso.class.getResource("immaginiHome/tratte1.png")).getImage()
				.getScaledInstance(272, 157, Image.SCALE_SMOOTH);
		return tratte1;
	}

	public Image tratte2() {
		Image tratte2 = new ImageIcon(Accesso.class.getResource("immaginiHome/tratte2.png")).getImage()
				.getScaledInstance(276, 162, Image.SCALE_SMOOTH);
		return tratte2;
	}

	public Image compagnieAeree1() {
		Image compagnieAeree1 = new ImageIcon(Accesso.class.getResource("immaginiHome/compagnieAeree1.png")).getImage()
				.getScaledInstance(272, 157, Image.SCALE_SMOOTH);
		return compagnieAeree1;
	}

	public Image compagnieAeree2() {
		Image compagnieAeree2 = new ImageIcon(Accesso.class.getResource("immaginiHome/compagnieAeree2.png")).getImage()
				.getScaledInstance(276, 162, Image.SCALE_SMOOTH);
		return compagnieAeree2;
	}

	public Image gestioneAccount1() {
		Image gestioneAccount1 = new ImageIcon(Accesso.class.getResource("immaginiHome/gestioneAccount1.png"))
				.getImage().getScaledInstance(272, 157, Image.SCALE_SMOOTH);
		return gestioneAccount1;
	}

	public Image gestioneAccount2() {
		Image gestioneAccount2 = new ImageIcon(Accesso.class.getResource("immaginiHome/gestioneAccount2.png"))
				.getImage().getScaledInstance(276, 162, Image.SCALE_SMOOTH);
		return gestioneAccount2;
	}

	public Image inserimentoCredenziali() {
		Image inserimentoCredenziali = new ImageIcon(
				Accesso.class.getResource("immaginiRegistrazione/inserimentoCredenziali.png")).getImage()
						.getScaledInstance(370, 470, Image.SCALE_SMOOTH);
		return inserimentoCredenziali;
	}
	
	public Image barraRicerca() {
		Image barraRicerca = new ImageIcon(Accesso.class.getResource("immaginiGate/barraRicerca.png"))
				.getImage().getScaledInstance(220, 38, Image.SCALE_SMOOTH);
		return barraRicerca;
	}
	
	public Image ricerca1() {
		Image ricerca1 = new ImageIcon(Accesso.class.getResource("immaginiGate/ricerca1.png"))
				.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		return ricerca1;
	}
	
	public Image ricerca2() {
		Image ricerca2 = new ImageIcon(Accesso.class.getResource("immaginiGate/ricerca2.png"))
				.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		return ricerca2;
	}

}
