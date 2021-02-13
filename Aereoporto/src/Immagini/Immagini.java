package Immagini;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

import Controller.Controller;
import GUI.*;

public class Immagini {

	private Image immagine;

	public Immagini() {

	}

	// METODI PER RIDIMENSIONAMENTO
	public int dimensioneSchermoX() {
		Toolkit tk = Toolkit.getDefaultToolkit();
		int xSize = ((int) tk.getScreenSize().getWidth());
		return xSize;
	}

	public int dimensioneSchermoY() {
		Toolkit tk = Toolkit.getDefaultToolkit();
		int ySize = ((int) tk.getScreenSize().getHeight());
		return ySize;
	}

	// METODI

	public Image stellaVuota() {
		Image stellaVuota = new ImageIcon(Recensione.class.getResource("immaginiRecensione/stellaVuota.png")).getImage()
				.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
		return stellaVuota;
	}
	
	public Image stellaPiena() {
		Image stellaPiena = new ImageIcon(Recensione.class.getResource("immaginiRecensione/stellaPiena.png")).getImage()
				.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
		return stellaPiena;
	}
	
	public Image inviaRecensione1() {
		Image inviaRecensione1 = new ImageIcon(Recensione.class.getResource("immaginiRecensione/inviaRecensione1.png")).getImage()
				.getScaledInstance(174, 47, Image.SCALE_SMOOTH);
		return inviaRecensione1;
	}
	
	public Image inviaRecensione2() {
		Image inviaRecensione2 = new ImageIcon(Recensione.class.getResource("immaginiRecensione/inviaRecensione2.png")).getImage()
				.getScaledInstance(174, 47, Image.SCALE_SMOOTH);
		return inviaRecensione2;
	}
	
	public Image inviaRecensione3() {
		Image inviaRecensione3 = new ImageIcon(Recensione.class.getResource("immaginiRecensione/inviaRecensione3.png")).getImage()
				.getScaledInstance(174, 47, Image.SCALE_SMOOTH);
		return inviaRecensione3;
	}
	
	public Image sfondo() {
		Image imgSfondo = new ImageIcon(Dashboard.class.getResource("immaginiDashboard/SfondoDashboard.png")).getImage()
				.getScaledInstance(1143, 677, Image.SCALE_SMOOTH);
		return imgSfondo;
	}

	public Image cambioPassword() {
		Image cambioPassword = new ImageIcon(CambioPassword.class.getResource("immaginiCambioPassword/cambioPassword.png")).getImage()
				.getScaledInstance(344, 263, Image.SCALE_SMOOTH);
		return cambioPassword;
	}

	public Image sfondoUscita() {
		Image imgSfondo = new ImageIcon(Dashboard.class.getResource("immaginiDashboard/SfondoUscita.png")).getImage()
				.getScaledInstance(500, 300, Image.SCALE_SMOOTH);
		return imgSfondo;
	}
	
	public Image sfondoUscita2() {
		Image imgSfondo2 = new ImageIcon(Dashboard.class.getResource("immaginiDashboard/SfondoUscita2.png")).getImage()
				.getScaledInstance(500, 300, Image.SCALE_SMOOTH);
		return imgSfondo2;
	}

	public Image tendina() {
		Image tendina = new ImageIcon(Accesso.class.getResource("immaginiDashboard/TendinaDashboard.png")).getImage()
				.getScaledInstance(238, 642, Image.SCALE_SMOOTH);
		return tendina;
	}
	
	public Image spostaDashboard() {
		Image spostaDashboard = new ImageIcon(Accesso.class.getResource("immaginiDashboard/SpostaDashboard.png")).getImage()
				.getScaledInstance(1143, 35, Image.SCALE_SMOOTH);
		return spostaDashboard;
	}
	
	public Image spostaUscita() {
		Image spostaUscita = new ImageIcon(Uscita.class.getResource("immaginiDashboard/SpostaDashboard.png")).getImage()
				.getScaledInstance(499, 35, Image.SCALE_SMOOTH);
		return spostaUscita;
	}
	

	public Image lineeChiusura() {
		Image lineeChiusura = new ImageIcon(Accesso.class.getResource("immaginiDashboard/linee1.png")).getImage()
				.getScaledInstance(25, 15, Image.SCALE_SMOOTH);
		return lineeChiusura;
	}

	public Image lineeApertura() {
		Image lineeApertura = new ImageIcon(Accesso.class.getResource("immaginiDashboard/linee2.png")).getImage()
				.getScaledInstance(25, 15, Image.SCALE_SMOOTH);
		return lineeApertura;
	}

	public Image X1() {
		Image x1 = new ImageIcon(Accesso.class.getResource("immaginiDashboard/x1.png")).getImage().getScaledInstance(51,
				35, Image.SCALE_SMOOTH);
		return x1;
	}

	public Image X2() {
		Image x2 = new ImageIcon(Dashboard.class.getResource("immaginiDashboard/x2.png")).getImage().getScaledInstance(51,
				35, Image.SCALE_SMOOTH);
		return x2;
	}
	
	public Image X3() {
		Image x3 = new ImageIcon(Accesso.class.getResource("immaginiDashboard/x3.png")).getImage().getScaledInstance(51,
				35, Image.SCALE_SMOOTH);
		return x3;
	}

	public Image minimizza1() {
		Image _1 = new ImageIcon(Accesso.class.getResource("immaginiDashboard/_1.png")).getImage()
				.getScaledInstance(51, 35, Image.SCALE_SMOOTH);
		return _1;
	}

	public Image minimizza2() {
		Image _2 = new ImageIcon(Accesso.class.getResource("immaginiDashboard/_2.png")).getImage()
				.getScaledInstance(51, 35, Image.SCALE_SMOOTH);
		return _2;
	}
	
	public Image minimizza3() {
		Image _3 = new ImageIcon(Accesso.class.getResource("immaginiDashboard/_3.png")).getImage()
				.getScaledInstance(51, 35, Image.SCALE_SMOOTH);
		return _3;
	}
	
	public Image si1() {
		Image si1 = new ImageIcon(Uscita.class.getResource("immaginiUscita/si1.png")).getImage()
				.getScaledInstance(174, 47, Image.SCALE_SMOOTH);
		return si1;
	}
	
	public Image si2() {
		Image si2 = new ImageIcon(Uscita.class.getResource("immaginiUscita/si2.png")).getImage()
				.getScaledInstance(174, 47, Image.SCALE_SMOOTH);
		return si2;
	}
	
	public Image si3() {
		Image si3 = new ImageIcon(Uscita.class.getResource("immaginiUscita/si3.png")).getImage()
				.getScaledInstance(174, 47, Image.SCALE_SMOOTH);
		return si3;
	}
	
	public Image annulla1() {
		Image annulla1 = new ImageIcon(Uscita.class.getResource("immaginiUscita/annulla1.png")).getImage()
				.getScaledInstance(174, 47, Image.SCALE_SMOOTH);
		return annulla1;
	}
	
	public Image annulla2() {
		Image annulla2 = new ImageIcon(Uscita.class.getResource("immaginiUscita/annulla2.png")).getImage()
				.getScaledInstance(174, 47, Image.SCALE_SMOOTH);
		return annulla2;
	}
	
	public Image annulla3() {
		Image annulla3 = new ImageIcon(Uscita.class.getResource("immaginiUscita/annulla3.png")).getImage()
				.getScaledInstance(174, 47, Image.SCALE_SMOOTH);
		return annulla3;
	}
	
	public Image accedi1() {
		Image accedi1 = new ImageIcon(JDialogProfilo.class.getResource("immaginiJDialogProfilo/accedi1.png")).getImage()
				.getScaledInstance(174, 47, Image.SCALE_SMOOTH);
		return accedi1;
	}
	
	public Image accedi2() {
		Image accedi2 = new ImageIcon(JDialogProfilo.class.getResource("immaginiJDialogProfilo/accedi2.png")).getImage()
				.getScaledInstance(174, 47, Image.SCALE_SMOOTH);
		return accedi2;
	}
	
	public Image accedi3() {
		Image accedi3 = new ImageIcon(JDialogProfilo.class.getResource("immaginiJDialogProfilo/accedi3.png")).getImage()
				.getScaledInstance(174, 47, Image.SCALE_SMOOTH);
		return accedi3;
	}
	
	public Image registrati1() {
		Image registrati1 = new ImageIcon(JDialogProfilo.class.getResource("immaginiJDialogProfilo/registrati1.png")).getImage()
				.getScaledInstance(174, 47, Image.SCALE_SMOOTH);
		return registrati1;
	}
	
	public Image registrati2() {
		Image registrati2 = new ImageIcon(JDialogProfilo.class.getResource("immaginiJDialogProfilo/registrati2.png")).getImage()
				.getScaledInstance(174, 47, Image.SCALE_SMOOTH);
		return registrati2;
	}
	
	public Image registrati3() {
		Image registrati3 = new ImageIcon(JDialogProfilo.class.getResource("immaginiJDialogProfilo/registrati3.png")).getImage()
				.getScaledInstance(174, 47, Image.SCALE_SMOOTH);
		return registrati3;
	}
	
	public Image partenze1() {
		Image partenze1 = new ImageIcon(SceltaVolo.class.getResource("immaginiSceltaVolo/partenze1.png")).getImage()
				.getScaledInstance(135, 41, Image.SCALE_SMOOTH);
		return partenze1;
	}
	
	public Image partenze2() {
		Image partenze2 = new ImageIcon(SceltaVolo.class.getResource("immaginiSceltaVolo/partenze2.png")).getImage()
				.getScaledInstance(135, 41, Image.SCALE_SMOOTH);
		return partenze2;
	}
	
	public Image partenze3() {
		Image partenze3 = new ImageIcon(SceltaVolo.class.getResource("immaginiSceltaVolo/partenze3.png")).getImage()
				.getScaledInstance(135, 41, Image.SCALE_SMOOTH);
		return partenze3;
	}
	
	public Image arrivi1() {
		Image arrivi1 = new ImageIcon(SceltaVolo.class.getResource("immaginiSceltaVolo/arrivi1.png")).getImage()
				.getScaledInstance(135, 41, Image.SCALE_SMOOTH);
		return arrivi1;
	}
	
	public Image arrivi2() {
		Image arrivi2 = new ImageIcon(SceltaVolo.class.getResource("immaginiSceltaVolo/arrivi2.png")).getImage()
				.getScaledInstance(135, 41, Image.SCALE_SMOOTH);
		return arrivi2;
	}
	
	public Image arrivi3() {
		Image arrivi3 = new ImageIcon(SceltaVolo.class.getResource("immaginiSceltaVolo/arrivi3.png")).getImage()
				.getScaledInstance(135, 41, Image.SCALE_SMOOTH);
		return arrivi3;
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
				.getImage().getScaledInstance(dimensioneSchermoX(), dimensioneSchermoY(), Image.SCALE_SMOOTH);
		return imgSfondoFull;
	}

	public Image avanti1() {
		Image avanti1 = new ImageIcon(Accesso.class.getResource("immaginiAccesso/avanti1.png")).getImage()
				.getScaledInstance(174, 47, Image.SCALE_SMOOTH);
		return avanti1;
	}

	public Image avanti2() {
		Image avanti2 = new ImageIcon(Accesso.class.getResource("immaginiAccesso/avanti2.png")).getImage()
				.getScaledInstance(174, 47, Image.SCALE_SMOOTH);
		return avanti2;
	}
	
	public Image avanti3() {
		Image avanti3 = new ImageIcon(Accesso.class.getResource("immaginiAccesso/avanti3.png")).getImage()
				.getScaledInstance(174, 47, Image.SCALE_SMOOTH);
		return avanti3;
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
				.getScaledInstance(292, 177, Image.SCALE_SMOOTH);
		return voli2;
	}

	public Image gate1() {
		Image gate1 = new ImageIcon(Accesso.class.getResource("immaginiHome/gate1.png")).getImage()
				.getScaledInstance(272, 157, Image.SCALE_SMOOTH);
		return gate1;
	}

	public Image gate2() {
		Image gate2 = new ImageIcon(Accesso.class.getResource("immaginiHome/gate2.png")).getImage()
				.getScaledInstance(292, 177, Image.SCALE_SMOOTH);
		return gate2;
	}

	public Image prenotazioni1() {
		Image prenotazioni1 = new ImageIcon(Accesso.class.getResource("immaginiHome/prenotazioni1.png")).getImage()
				.getScaledInstance(272, 157, Image.SCALE_SMOOTH);
		return prenotazioni1;
	}

	public Image prenotazioni2() {
		Image prenotazioni2 = new ImageIcon(Accesso.class.getResource("immaginiHome/prenotazioni2.png")).getImage()
				.getScaledInstance(292, 177, Image.SCALE_SMOOTH);
		return prenotazioni2;
	}

	public Image tratte1() {
		Image tratte1 = new ImageIcon(Accesso.class.getResource("immaginiHome/tratte1.png")).getImage()
				.getScaledInstance(272, 157, Image.SCALE_SMOOTH);
		return tratte1;
	}

	public Image tratte2() {
		Image tratte2 = new ImageIcon(Accesso.class.getResource("immaginiHome/tratte2.png")).getImage()
				.getScaledInstance(292, 177, Image.SCALE_SMOOTH);
		return tratte2;
	}

	public Image compagnieAeree1() {
		Image compagnieAeree1 = new ImageIcon(Accesso.class.getResource("immaginiHome/compagnieAeree1.png")).getImage()
				.getScaledInstance(272, 157, Image.SCALE_SMOOTH);
		return compagnieAeree1;
	}

	public Image compagnieAeree2() {
		Image compagnieAeree2 = new ImageIcon(Accesso.class.getResource("immaginiHome/compagnieAeree2.png")).getImage()
				.getScaledInstance(292, 177, Image.SCALE_SMOOTH);
		return compagnieAeree2;
	}

	public Image gestioneAccount1() {
		Image gestioneAccount1 = new ImageIcon(Accesso.class.getResource("immaginiHome/gestioneAccount1.png"))
				.getImage().getScaledInstance(272, 157, Image.SCALE_SMOOTH);
		return gestioneAccount1;
	}

	public Image gestioneAccount2() {
		Image gestioneAccount2 = new ImageIcon(Accesso.class.getResource("immaginiHome/gestioneAccount2.png"))
				.getImage().getScaledInstance(292, 177, Image.SCALE_SMOOTH);
		return gestioneAccount2;
	}

	public Image inserimentoCredenzialiRegistrazione() {
		Image inserimentoCredenzialiRegistrazione = new ImageIcon(
				Accesso.class.getResource("immaginiRegistrazione/inserimentoCredenzialiRegistrazione.png")).getImage()
						.getScaledInstance(370, 470, Image.SCALE_SMOOTH);
		return inserimentoCredenzialiRegistrazione;
	}
	
	public Image datiAccount() {
		Image datiAccount = new ImageIcon(
				Accesso.class.getResource("immaginiProfilo/datiAccount.png")).getImage()
						.getScaledInstance(344, 263, Image.SCALE_SMOOTH);
		return datiAccount;
	}

	public Image barraRicerca() {
		Image barraRicerca = new ImageIcon(Accesso.class.getResource("immaginiGate/barraRicerca.png")).getImage()
				.getScaledInstance(180, 30, Image.SCALE_SMOOTH);
		return barraRicerca;
	}

	public Image ricerca() {
		Image ricerca = new ImageIcon(Accesso.class.getResource("immaginiGate/ricerca.png")).getImage()
				.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		return ricerca;
	}

	public Image frecciaIndietro1() {
		Image imgfrecciaIndietro1 = new ImageIcon(Registrazione.class.getResource("immaginiHome/frecciaIndietro1.png"))
				.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		return imgfrecciaIndietro1;
	}

	public Image frecciaIndietro2() {
		Image frecciaIndietro2 = new ImageIcon(Registrazione.class.getResource("immaginiHome/frecciaIndietro2.png"))
				.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		return frecciaIndietro2;
	}

}
