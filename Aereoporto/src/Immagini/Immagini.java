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

	/*-----------------------------------------------------------VARIO-----------------------------------------------------------*/

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

	public Image spuntaSuccesso() {
		Image spuntaSuccesso = new ImageIcon(Recensione.class.getResource("immaginiDashboard/SpuntaSuccesso.png"))
				.getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);
		return spuntaSuccesso;
	}

	public Image sfondoUscita() {
		Image imgSfondo = new ImageIcon(Dashboard.class.getResource("immaginiDashboard/SfondoUscita.png")).getImage()
				.getScaledInstance(500, 300, Image.SCALE_SMOOTH);
		return imgSfondo;
	}

	public Image spostaUscita() {
		Image spostaUscita = new ImageIcon(Uscita.class.getResource("immaginiDashboard/SpostaDashboard.png")).getImage()
				.getScaledInstance(499, 35, Image.SCALE_SMOOTH);
		return spostaUscita;
	}

	public Image sfondoPasswordDimenticata() {
		Image sfondoPasswordDimenticata = new ImageIcon(
				PasswordDimenticata.class.getResource("immaginiDashboard/sfondoUscita.png")).getImage()
						.getScaledInstance(500, 469, Image.SCALE_SMOOTH);
		return sfondoPasswordDimenticata;
	}

	/*-----------------------------------------------------------VARIO CHIARO-----------------------------------------------------------*/

	public Image sfondoUscitaTemaChiaro() {
		Image imgSfondo = new ImageIcon(Dashboard.class.getResource("immaginiDashboardChiare/SfondoUscitaChiaro.png"))
				.getImage().getScaledInstance(500, 300, Image.SCALE_SMOOTH);
		return imgSfondo;
	}

	public Image spostaUscitaTemaChiaro() {
		Image spostaUscita = new ImageIcon(
				Uscita.class.getResource("immaginiDashboardChiare/SpostaDashboardChiaro.png")).getImage()
						.getScaledInstance(499, 35, Image.SCALE_SMOOTH);
		return spostaUscita;
	}

	public Image sfondoPasswordDimenticataTemaChiaro() {
		Image sfondoPasswordDimenticata = new ImageIcon(
				PasswordDimenticata.class.getResource("immaginiDashboardChiare/SfondoUscitaChiaro.png")).getImage()
						.getScaledInstance(500, 469, Image.SCALE_SMOOTH);
		return sfondoPasswordDimenticata;
	}

	/*-----------------------------------------------------------DASHBOARD-----------------------------------------------------------*/

	//MENU
	public Image menu() {
		Image menu = new ImageIcon(Dashboard.class.getResource("immaginiDashboard/menu.png")).getImage()
				.getScaledInstance(265, 147, Image.SCALE_SMOOTH);
		return menu;
	}
	
	public Image frecciaMenu1() {
		Image frecciaMenu1 = new ImageIcon(Dashboard.class.getResource("immaginiDashboard/frecciaMenu1.png")).getImage()
				.getScaledInstance(23, 35, Image.SCALE_SMOOTH);
		return frecciaMenu1;
	}
	
	public Image frecciaMenu2() {
		Image frecciaMenu2 = new ImageIcon(Dashboard.class.getResource("immaginiDashboard/frecciaMenu2.png")).getImage()
				.getScaledInstance(23, 35, Image.SCALE_SMOOTH);
		return frecciaMenu2;
	}
	
	public Image frecciaMenu3() {
		Image frecciaMenu3 = new ImageIcon(Dashboard.class.getResource("immaginiDashboard/frecciaMenu3.png")).getImage()
				.getScaledInstance(23, 35, Image.SCALE_SMOOTH);
		return frecciaMenu3;
	}
	
	public Image frecciaMenu1TemaChiaro() {
		Image frecciaMenu1Chiaro = new ImageIcon(Dashboard.class.getResource("immaginiDashboardChiare/frecciaMenu1Chiaro.png")).getImage()
				.getScaledInstance(23, 35, Image.SCALE_SMOOTH);
		return frecciaMenu1Chiaro;
	}
	
	public Image frecciaMenu2TemaChiaro() {
		Image frecciaMenu2Chiaro = new ImageIcon(Dashboard.class.getResource("immaginiDashboardChiare/frecciaMenu2Chiaro.png")).getImage()
				.getScaledInstance(23, 35, Image.SCALE_SMOOTH);
		return frecciaMenu2Chiaro;
	}
	
	public Image frecciaMenu3TemaChiaro() {
		Image frecciaMenu3Chiaro = new ImageIcon(Dashboard.class.getResource("immaginiDashboardChiare/frecciaMenu3Chiaro.png")).getImage()
				.getScaledInstance(23, 35, Image.SCALE_SMOOTH);
		return frecciaMenu3Chiaro;
	}
	
	
	
	public Image sfondo() {
		Image imgSfondo = new ImageIcon(Dashboard.class.getResource("immaginiDashboard/SfondoDashboard.png")).getImage()
				.getScaledInstance(1143, 677, Image.SCALE_SMOOTH);
		return imgSfondo;
	}

	public Image tendina() {
		Image tendina = new ImageIcon(Accesso.class.getResource("immaginiDashboard/TendinaDashboard.png")).getImage()
				.getScaledInstance(238, 642, Image.SCALE_SMOOTH);
		return tendina;
	}

	public Image spostaDashboard() {
		Image spostaDashboard = new ImageIcon(Accesso.class.getResource("immaginiDashboard/SpostaDashboard.png"))
				.getImage().getScaledInstance(1143, 35, Image.SCALE_SMOOTH);
		return spostaDashboard;
	}

	public Image X1() {
		Image x1 = new ImageIcon(Accesso.class.getResource("immaginiDashboard/x1.png")).getImage().getScaledInstance(51,
				35, Image.SCALE_SMOOTH);
		return x1;
	}

	public Image X2() {
		Image x2 = new ImageIcon(Dashboard.class.getResource("immaginiDashboard/x2.png")).getImage()
				.getScaledInstance(51, 35, Image.SCALE_SMOOTH);
		return x2;
	}

	public Image X3() {
		Image x3 = new ImageIcon(Accesso.class.getResource("immaginiDashboard/x3.png")).getImage().getScaledInstance(51,
				35, Image.SCALE_SMOOTH);
		return x3;
	}

	public Image minimizza1() {
		Image _1 = new ImageIcon(Accesso.class.getResource("immaginiDashboard/_1.png")).getImage().getScaledInstance(51,
				35, Image.SCALE_SMOOTH);
		return _1;
	}

	public Image minimizza2() {
		Image _2 = new ImageIcon(Accesso.class.getResource("immaginiDashboard/_2.png")).getImage().getScaledInstance(51,
				35, Image.SCALE_SMOOTH);
		return _2;
	}

	public Image minimizza3() {
		Image _3 = new ImageIcon(Accesso.class.getResource("immaginiDashboard/_3.png")).getImage().getScaledInstance(51,
				35, Image.SCALE_SMOOTH);
		return _3;
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

	public Image lineeChiusura1() {
		Image lineeChiusura = new ImageIcon(Accesso.class.getResource("immaginiDashboard/lineeChiusura1.png"))
				.getImage().getScaledInstance(41, 41, Image.SCALE_SMOOTH);
		return lineeChiusura;
	}

	public Image lineeChiusura2() {
		Image lineeChiusura = new ImageIcon(Accesso.class.getResource("immaginiDashboard/lineeChiusura2.png"))
				.getImage().getScaledInstance(41, 41, Image.SCALE_SMOOTH);
		return lineeChiusura;
	}

	public Image lineeChiusura3() {
		Image lineeChiusura = new ImageIcon(Accesso.class.getResource("immaginiDashboard/lineeChiusura3.png"))
				.getImage().getScaledInstance(41, 41, Image.SCALE_SMOOTH);
		return lineeChiusura;
	}

	public Image lineeApertura1() {
		Image lineeApertura = new ImageIcon(Accesso.class.getResource("immaginiDashboard/lineeApertura1.png"))
				.getImage().getScaledInstance(41, 41, Image.SCALE_SMOOTH);
		return lineeApertura;
	}

	public Image lineeApertura2() {
		Image lineeApertura = new ImageIcon(Accesso.class.getResource("immaginiDashboard/lineeApertura2.png"))
				.getImage().getScaledInstance(41, 41, Image.SCALE_SMOOTH);
		return lineeApertura;
	}

	public Image lineeApertura3() {
		Image lineeApertura = new ImageIcon(Accesso.class.getResource("immaginiDashboard/lineeApertura3.png"))
				.getImage().getScaledInstance(41, 41, Image.SCALE_SMOOTH);
		return lineeApertura;
	}

	/*-----------------------------------------------------------DASHBOARD CHIARA------------------------------------------------------*/

	public Image menuTemaChiaro() {
		Image menuChiaro = new ImageIcon(Dashboard.class.getResource("immaginiDashboardChiare/menuChiaro.png")).getImage()
				.getScaledInstance(265, 147, Image.SCALE_SMOOTH);
		return menuChiaro;
	}
	
	public Image sfondoTemaChiaro() {
		Image imgSfondoChiaro = new ImageIcon(
				Dashboard.class.getResource("immaginiDashboardChiare/SfondoDashboardChiaro.png")).getImage()
						.getScaledInstance(1143, 677, Image.SCALE_SMOOTH);
		return imgSfondoChiaro;
	}

	public Image tendinaTemaChiaro() {
		Image tendinaChiara = new ImageIcon(
				Dashboard.class.getResource("immaginiDashboardChiare/TendinaDashboardChiara.png")).getImage()
						.getScaledInstance(238, 642, Image.SCALE_SMOOTH);
		return tendinaChiara;
	}

	public Image spostaDashboardTemaChiaro() {
		Image spostaDashboardChiaro = new ImageIcon(
				Accesso.class.getResource("immaginiDashboardChiare/SpostaDashboardChiaro.png")).getImage()
						.getScaledInstance(1143, 35, Image.SCALE_SMOOTH);
		return spostaDashboardChiaro;
	}

	public Image lineeChiusura1TemaChiaro() {
		Image lineeChiusura1Chiare = new ImageIcon(
				Accesso.class.getResource("immaginiDashboardChiare/lineeChiusura1Chiaro.png")).getImage()
						.getScaledInstance(41, 41, Image.SCALE_SMOOTH);
		return lineeChiusura1Chiare;
	}

	public Image lineeChiusura2TemaChiaro() {
		Image lineeChiusura2Chiare = new ImageIcon(
				Accesso.class.getResource("immaginiDashboardChiare/lineeChiusura2Chiaro.png")).getImage()
						.getScaledInstance(41, 41, Image.SCALE_SMOOTH);
		return lineeChiusura2Chiare;
	}

	public Image lineeChiusura3TemaChiaro() {
		Image lineeChiusura3Chiare = new ImageIcon(
				Accesso.class.getResource("immaginiDashboardChiare/lineeChiusura3Chiaro.png")).getImage()
						.getScaledInstance(41, 41, Image.SCALE_SMOOTH);
		return lineeChiusura3Chiare;
	}

	public Image lineeApertura1TemaChiaro() {
		Image lineeApertura1Chiaro = new ImageIcon(
				Accesso.class.getResource("immaginiDashboardChiare/lineeApertura1Chiaro.png")).getImage()
						.getScaledInstance(41, 41, Image.SCALE_SMOOTH);
		return lineeApertura1Chiaro;
	}

	public Image lineeApertura2TemaChiaro() {
		Image lineeApertura2Chiaro = new ImageIcon(
				Accesso.class.getResource("immaginiDashboardChiare/lineeApertura2Chiaro.png")).getImage()
						.getScaledInstance(41, 41, Image.SCALE_SMOOTH);
		return lineeApertura2Chiaro;
	}

	public Image lineeApertura3TemaChiaro() {
		Image lineeApertura3Chiaro = new ImageIcon(
				Accesso.class.getResource("immaginiDashboardChiare/lineeApertura3Chiaro.png")).getImage()
						.getScaledInstance(41, 41, Image.SCALE_SMOOTH);
		return lineeApertura3Chiaro;
	}

	public Image X1TemaChiaro() {
		Image X_1TemaChiaro = new ImageIcon(Accesso.class.getResource("immaginiDashboardChiare/x1Chiaro.png"))
				.getImage().getScaledInstance(51, 35, Image.SCALE_SMOOTH);
		return X_1TemaChiaro;
	}

	public Image X2TemaChiaro() {
		Image X_2TemaChiaro = new ImageIcon(Dashboard.class.getResource("immaginiDashboardChiare/x2Chiaro.png"))
				.getImage().getScaledInstance(51, 35, Image.SCALE_SMOOTH);
		return X_2TemaChiaro;
	}

	public Image X3TemaChiaro() {
		Image X_3TemaChiaro = new ImageIcon(Accesso.class.getResource("immaginiDashboardChiare/x3Chiaro.png"))
				.getImage().getScaledInstance(51, 35, Image.SCALE_SMOOTH);
		return X_3TemaChiaro;
	}

	public Image minimizza1TemaChiaro() {
		Image minimizza1TemaChiaro = new ImageIcon(Accesso.class.getResource("immaginiDashboardChiare/_1Chiaro.png"))
				.getImage().getScaledInstance(51, 35, Image.SCALE_SMOOTH);
		return minimizza1TemaChiaro;
	}

	public Image minimizza2TemaChiaro() {
		Image minimizza2TemaChiaro = new ImageIcon(Accesso.class.getResource("immaginiDashboardChiare/_2Chiaro.png"))
				.getImage().getScaledInstance(51, 35, Image.SCALE_SMOOTH);
		return minimizza2TemaChiaro;
	}

	public Image minimizza3TemaChiaro() {
		Image minimizza3TemaChiaro = new ImageIcon(Accesso.class.getResource("immaginiDashboardChiare/_3Chiaro.png"))
				.getImage().getScaledInstance(51, 35, Image.SCALE_SMOOTH);
		return minimizza3TemaChiaro;
	}

	/*-----------------------------------------------------------CREDENZIALI-----------------------------------------------------------*/

	public Image cambioPassword() {
		Image cambioPassword = new ImageIcon(CambioPassword.class.getResource("immaginiCredenziali/cambioPassword.png"))
				.getImage().getScaledInstance(344, 263, Image.SCALE_SMOOTH);
		return cambioPassword;
	}

	public Image mostraPassword() {
		Image mostraPassword = new ImageIcon(Accesso.class.getResource("immaginiInComune/mostraPassword.png"))
				.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		return mostraPassword;
	}

	public Image censuraPassword() {
		Image censuraPassword = new ImageIcon(Accesso.class.getResource("immaginiInComune/censuraPassword.png"))
				.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		return censuraPassword;
	}

	public Image credenzialiAccesso() {
		Image credenziali = new ImageIcon(Accesso.class.getResource("immaginiCredenziali/credenzialiAccesso.png"))
				.getImage().getScaledInstance(343, 158, Image.SCALE_SMOOTH);
		return credenziali;
	}

	public Image datiAccount() {
		Image datiAccount = new ImageIcon(Accesso.class.getResource("immaginiCredenziali/datiAccount.png")).getImage()
				.getScaledInstance(344, 263, Image.SCALE_SMOOTH);
		return datiAccount;
	}

	public Image credenzialiRegistrazione() {
		Image inserimentoCredenzialiRegistrazione = new ImageIcon(
				Accesso.class.getResource("immaginiCredenziali/credenzialiRegistrazione.png")).getImage()
						.getScaledInstance(344, 473, Image.SCALE_SMOOTH);
		return inserimentoCredenzialiRegistrazione;
	}

	public Image credenzialiPasswordDimenticata() {
		Image credenzialiPasswordDimenticata = new ImageIcon(
				PasswordDimenticata.class.getResource("immaginiCredenziali/credenzialiPasswordDimenticata.png"))
						.getImage().getScaledInstance(344, 263, Image.SCALE_SMOOTH);
		return credenzialiPasswordDimenticata;
	}

	/*-----------------------------------------------------------CREDENZIALI TEMA CHIARO-----------------------------------------------------------*/

	public Image credenzialiCambioPasswordTemaChiaro() {
		Image cambioPasswordTemaChiaro = new ImageIcon(
				CambioPassword.class.getResource("immaginiCredenzialiChiare/cambioPasswordChiaro.png")).getImage()
						.getScaledInstance(344, 263, Image.SCALE_SMOOTH);
		return cambioPasswordTemaChiaro;
	}

	public Image credenzialiAccessoTemaChiaro() {
		Image credenzialiTemaChiaro = new ImageIcon(
				Accesso.class.getResource("immaginiCredenzialiChiare/credenzialiAccessoChiaro.png")).getImage()
						.getScaledInstance(343, 158, Image.SCALE_SMOOTH);
		return credenzialiTemaChiaro;
	}

	public Image datiProfiloTemaChiaro() {
		Image datiAccountTemaChiaro = new ImageIcon(
				Accesso.class.getResource("immaginiCredenzialiChiare/datiAccountChiaro.png")).getImage()
						.getScaledInstance(344, 263, Image.SCALE_SMOOTH);
		return datiAccountTemaChiaro;
	}

	public Image credenzialiRegistrazioneTemaChiaro() {
		Image inserimentoCredenzialiRegistrazioneTemaChiaro = new ImageIcon(
				Accesso.class.getResource("immaginiCredenzialiChiare/credenzialiRegistrazioneChiaro.png")).getImage()
						.getScaledInstance(344, 473, Image.SCALE_SMOOTH);
		return inserimentoCredenzialiRegistrazioneTemaChiaro;
	}

	public Image credenzialiPasswordDimenticataTemaChiaro() {
		Image campiPasswordDimenticataTemaChiaro = new ImageIcon(PasswordDimenticata.class
				.getResource("immaginiCredenzialiChiare/credenzialiPasswordDimenticataChiaro.png")).getImage()
						.getScaledInstance(344, 263, Image.SCALE_SMOOTH);
		return campiPasswordDimenticataTemaChiaro;
	}

	/*-----------------------------------------------------------HOME-----------------------------------------------------------*/
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

	public Image voli3() {
		Image voli3 = new ImageIcon(Accesso.class.getResource("immaginiHome/voli3.png")).getImage()
				.getScaledInstance(276, 162, Image.SCALE_SMOOTH);
		return voli3;
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

	public Image gate3() {
		Image gate3 = new ImageIcon(Accesso.class.getResource("immaginiHome/gate3.png")).getImage()
				.getScaledInstance(276, 162, Image.SCALE_SMOOTH);
		return gate3;
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

	public Image tratte3() {
		Image tratte3 = new ImageIcon(Accesso.class.getResource("immaginiHome/tratte3.png")).getImage()
				.getScaledInstance(276, 162, Image.SCALE_SMOOTH);
		return tratte3;
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

	public Image compagnieAeree3() {
		Image compagnieAeree3 = new ImageIcon(Accesso.class.getResource("immaginiHome/compagnieAeree3.png")).getImage()
				.getScaledInstance(276, 162, Image.SCALE_SMOOTH);
		return compagnieAeree3;
	}

	/*-----------------------------------------------------------ICONE-----------------------------------------------------------*/

	// DASHBOARD

	public Image temaChiaro1() {
		Image temaChiaro = new ImageIcon(Accesso.class.getResource("immaginiDashboard/temaChiaro1.png")).getImage()
				.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		return temaChiaro;
	}

	public Image temaChiaro2() {
		Image temaChiaro2 = new ImageIcon(Accesso.class.getResource("immaginiDashboard/temaChiaro2.png")).getImage()
				.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		return temaChiaro2;
	}

	public Image temaChiaro3() {
		Image temaChiaro3 = new ImageIcon(Accesso.class.getResource("immaginiDashboard/temaChiaro3.png")).getImage()
				.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		return temaChiaro3;
	}

	public Image registrati() {
		Image registrati = new ImageIcon(Accesso.class.getResource("immaginiDashboard/registrazione.png")).getImage()
				.getScaledInstance(27, 27, Image.SCALE_SMOOTH);
		return registrati;
	}

	public Image casa() {
		Image casa = new ImageIcon(Accesso.class.getResource("immaginiDashboard/casa.png")).getImage()
				.getScaledInstance(27, 27, Image.SCALE_SMOOTH);
		return casa;
	}

	public Image accedi() {
		Image accedi = new ImageIcon(Accesso.class.getResource("immaginiDashboard/accedi.png")).getImage()
				.getScaledInstance(27, 27, Image.SCALE_SMOOTH);
		return accedi;
	}

	public Image profilo() {
		Image profilo = new ImageIcon(Accesso.class.getResource("immaginiDashboard/profilo.png")).getImage()
				.getScaledInstance(27, 27, Image.SCALE_SMOOTH);
		return profilo;
	}

	public Image impostazioni() {
		Image impostazioni = new ImageIcon(Accesso.class.getResource("immaginiDashboard/impostazioni.png")).getImage()
				.getScaledInstance(27, 27, Image.SCALE_SMOOTH);
		return impostazioni;
	}

	public Image esci() {
		Image esci = new ImageIcon(Accesso.class.getResource("immaginiDashboard/esci.png")).getImage()
				.getScaledInstance(27, 27, Image.SCALE_SMOOTH);
		return esci;
	}

	// IN COMUNE
	public Image frecciaIndietro1() {
		Image imgfrecciaIndietro1 = new ImageIcon(
				Registrazione.class.getResource("immaginiInComune/frecciaIndietro1.png")).getImage()
						.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		return imgfrecciaIndietro1;
	}

	public Image frecciaIndietro2() {
		Image frecciaIndietro2 = new ImageIcon(Registrazione.class.getResource("immaginiInComune/frecciaIndietro2.png"))
				.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		return frecciaIndietro2;
	}

	public Image frecciaIndietro3() {
		Image frecciaIndietro3 = new ImageIcon(Registrazione.class.getResource("immaginiInComune/frecciaIndietro3.png"))
				.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		return frecciaIndietro3;
	}

	public Image barraRicerca() {
		Image barraRicerca = new ImageIcon(Accesso.class.getResource("immaginiInComune/barraRicerca.png")).getImage()
				.getScaledInstance(184, 25, Image.SCALE_SMOOTH);
		return barraRicerca;
	}

	public Image frecciaIndietro1TemaChiaro() {
		Image frecciaIndietro1Chiaro = new ImageIcon(
				Registrazione.class.getResource("immaginiInComuneChiare/frecciaIndietro1Chiaro.png")).getImage()
						.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		return frecciaIndietro1Chiaro;
	}

	public Image frecciaIndietro2TemaChiaro() {
		Image frecciaIndietro2Chiaro = new ImageIcon(
				Registrazione.class.getResource("immaginiInComuneChiare/frecciaIndietro2Chiaro.png")).getImage()
						.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		return frecciaIndietro2Chiaro;
	}

	public Image frecciaIndietro3TemaChiaro() {
		Image frecciaIndietro3Chiaro = new ImageIcon(
				Registrazione.class.getResource("immaginiInComuneChiare/frecciaIndietro3Chiaro.png")).getImage()
						.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		return frecciaIndietro3Chiaro;
	}
	
	public Image barraRicercaTemaChiaro() {
		Image barraRicercaChiara = new ImageIcon(Accesso.class.getResource("immaginiInComuneChiare/barraRicercaChiara.png")).getImage()
				.getScaledInstance(184, 30, Image.SCALE_SMOOTH);
		return barraRicercaChiara;
	}

	/*-----------------------------------------------------------ICONE TEMA CHIARO-----------------------------------------------------*/
	// DASHBOARD
	public Image temaScuro1() {
		Image temaScuro1 = new ImageIcon(Accesso.class.getResource("immaginiDashboardChiare/temaScuro1.png")).getImage()
				.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		return temaScuro1;
	}

	public Image temaScuro2() {
		Image temaScuro2 = new ImageIcon(Accesso.class.getResource("immaginiDashboardChiare/temaScuro2.png")).getImage()
				.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		return temaScuro2;
	}

	public Image temaScuro3() {
		Image temaScuro3 = new ImageIcon(Accesso.class.getResource("immaginiDashboardChiare/temaScuro3.png")).getImage()
				.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		return temaScuro3;
	}

	public Image registratiTemaChiaro() {
		Image registrati = new ImageIcon(Accesso.class.getResource("immaginiDashboardChiare/registratiChiaro.png"))
				.getImage().getScaledInstance(27, 27, Image.SCALE_SMOOTH);
		return registrati;
	}

	public Image casaTemaChiaro() {
		Image casa = new ImageIcon(Accesso.class.getResource("immaginiDashboardChiare/casaChiaro.png")).getImage()
				.getScaledInstance(27, 27, Image.SCALE_SMOOTH);
		return casa;
	}

	public Image accediTemaChiaro() {
		Image accedi = new ImageIcon(Accesso.class.getResource("immaginiDashboardChiare/accediChiaro.png")).getImage()
				.getScaledInstance(27, 27, Image.SCALE_SMOOTH);
		return accedi;
	}

	public Image profiloTemaChiaro() {
		Image profilo = new ImageIcon(Accesso.class.getResource("immaginiDashboardChiare/profiloChiaro.png")).getImage()
				.getScaledInstance(27, 27, Image.SCALE_SMOOTH);
		return profilo;
	}

	public Image impostazioniTemaChiaro() {
		Image impostazioni = new ImageIcon(Accesso.class.getResource("immaginiDashboardChiare/impostazioniChiaro.png"))
				.getImage().getScaledInstance(27, 27, Image.SCALE_SMOOTH);
		return impostazioni;
	}

	public Image esciTemaChiaro() {
		Image esci = new ImageIcon(Accesso.class.getResource("immaginiDashboardChiare/esciChiaro.png")).getImage()
				.getScaledInstance(27, 27, Image.SCALE_SMOOTH);
		return esci;
	}

	/*-----------------------------------------------------------BOTTONI-----------------------------------------------------------*/
	
	//GIORNO
	public Image giorno1() {
		Image giorno1 = new ImageIcon(UtilizzoGate.class.getResource("immaginiBottoni/giorno1.png")).getImage()
				.getScaledInstance(130, 36, Image.SCALE_SMOOTH);
		return giorno1;
	}

	public Image giorno2() {
		Image giorno2 = new ImageIcon(UtilizzoGate.class.getResource("immaginiBottoni/giorno2.png")).getImage()
				.getScaledInstance(130, 36, Image.SCALE_SMOOTH);
		return giorno2;
	}

	public Image giorno3() {
		Image giorno3 = new ImageIcon(UtilizzoGate.class.getResource("immaginiBottoni/giorno3.png")).getImage()
				.getScaledInstance(130, 36, Image.SCALE_SMOOTH);
		return giorno3;
	}
	
	//SETTIMANA
	public Image settimana1() {
		Image settimana1 = new ImageIcon(UtilizzoGate.class.getResource("immaginiBottoni/settimana1.png")).getImage()
				.getScaledInstance(130, 36, Image.SCALE_SMOOTH);
		return settimana1;
	}

	public Image settimana2() {
		Image settimana2 = new ImageIcon(UtilizzoGate.class.getResource("immaginiBottoni/settimana2.png")).getImage()
				.getScaledInstance(130, 36, Image.SCALE_SMOOTH);
		return settimana2;
	}

	public Image settimana3() {
		Image settimana3 = new ImageIcon(UtilizzoGate.class.getResource("immaginiBottoni/settimana3.png")).getImage()
				.getScaledInstance(130, 36, Image.SCALE_SMOOTH);
		return settimana3;
	}
	
	
	//MESE
	public Image mese1() {
		Image mese1 = new ImageIcon(UtilizzoGate.class.getResource("immaginiBottoni/mese1.png")).getImage()
				.getScaledInstance(130, 36, Image.SCALE_SMOOTH);
		return mese1;
	}

	public Image mese2() {
		Image mese2 = new ImageIcon(UtilizzoGate.class.getResource("immaginiBottoni/mese2.png")).getImage()
				.getScaledInstance(130, 36, Image.SCALE_SMOOTH);
		return mese2;
	}

	public Image mese3() {
		Image mese3 = new ImageIcon(UtilizzoGate.class.getResource("immaginiBottoni/mese3.png")).getImage()
				.getScaledInstance(130, 36, Image.SCALE_SMOOTH);
		return mese3;
	}

	// TORNA INDIETRO
	public Image tornaIndietro1TemaChiaro() {
		Image tornaIndietro1Chiaro = new ImageIcon(
				SceltaGate.class.getResource("immaginiBottoniChiare/tornaIndietro1Chiaro.png")).getImage()
						.getScaledInstance(319, 36, Image.SCALE_SMOOTH);
		return tornaIndietro1Chiaro;
	}

	public Image tornaIndietro2TemaChiaro() {
		Image tornaIndietro2Chiaro = new ImageIcon(
				SceltaGate.class.getResource("immaginiBottoniChiare/tornaIndietro2Chiaro.png")).getImage()
						.getScaledInstance(319, 36, Image.SCALE_SMOOTH);
		return tornaIndietro2Chiaro;
	}

	public Image tornaIndietro3TemaChiaro() {
		Image tornaIndietro3Chiaro = new ImageIcon(
				SceltaGate.class.getResource("immaginiBottoniChiare/tornaIndietro3Chiaro.png")).getImage()
						.getScaledInstance(319, 36, Image.SCALE_SMOOTH);
		return tornaIndietro3Chiaro;
	}

	// AGGIUNGI
	public Image aggiungi1() {
		Image aggiungi1 = new ImageIcon(Uscita.class.getResource("immaginiBottoni/aggiungi1.png")).getImage()
				.getScaledInstance(130, 36, Image.SCALE_SMOOTH);
		return aggiungi1;
	}

	public Image aggiungi2() {
		Image aggiungi2 = new ImageIcon(Uscita.class.getResource("immaginiBottoni/aggiungi2.png")).getImage()
				.getScaledInstance(130, 36, Image.SCALE_SMOOTH);
		return aggiungi2;
	}

	public Image aggiungi3() {
		Image aggiungi3 = new ImageIcon(Uscita.class.getResource("immaginiBottoni/aggiungi3.png")).getImage()
				.getScaledInstance(130, 36, Image.SCALE_SMOOTH);
		return aggiungi3;
	}

	// ELIMINA
	public Image elimina1() {
		Image elimina1 = new ImageIcon(Uscita.class.getResource("immaginiBottoni/elimina1.png")).getImage()
				.getScaledInstance(130, 36, Image.SCALE_SMOOTH);
		return elimina1;
	}

	public Image elimina2() {
		Image elimina2 = new ImageIcon(Uscita.class.getResource("immaginiBottoni/elimina2.png")).getImage()
				.getScaledInstance(130, 36, Image.SCALE_SMOOTH);
		return elimina2;
	}

	public Image elimina3() {
		Image elimina3 = new ImageIcon(Uscita.class.getResource("immaginiBottoni/elimina3.png")).getImage()
				.getScaledInstance(130, 36, Image.SCALE_SMOOTH);
		return elimina3;
	}

	// SVUOTA
	public Image svuota1() {
		Image svuota1 = new ImageIcon(Uscita.class.getResource("immaginiBottoni/svuota1.png")).getImage()
				.getScaledInstance(130, 36, Image.SCALE_SMOOTH);
		return svuota1;
	}

	public Image svuota2() {
		Image svuota2 = new ImageIcon(Uscita.class.getResource("immaginiBottoni/svuota2.png")).getImage()
				.getScaledInstance(130, 36, Image.SCALE_SMOOTH);
		return svuota2;
	}

	public Image svuota3() {
		Image svuota3 = new ImageIcon(Uscita.class.getResource("immaginiBottoni/svuota3.png")).getImage()
				.getScaledInstance(130, 36, Image.SCALE_SMOOTH);
		return svuota3;
	}

	// MODIFICA
	public Image modifica1() {
		Image modifica1 = new ImageIcon(Uscita.class.getResource("immaginiBottoni/modifica1.png")).getImage()
				.getScaledInstance(130, 36, Image.SCALE_SMOOTH);
		return modifica1;
	}

	public Image modifica2() {
		Image modifica2 = new ImageIcon(Uscita.class.getResource("immaginiBottoni/modifica2.png")).getImage()
				.getScaledInstance(130, 36, Image.SCALE_SMOOTH);
		return modifica2;
	}

	public Image modifica3() {
		Image modifica3 = new ImageIcon(Uscita.class.getResource("immaginiBottoni/modifica3.png")).getImage()
				.getScaledInstance(130, 36, Image.SCALE_SMOOTH);
		return modifica3;
	}

	// SALVA
	public Image salva1() {
		Image salva1 = new ImageIcon(PasswordDimenticata.class.getResource("immaginiBottoni/salva1.png")).getImage()
				.getScaledInstance(130, 36, Image.SCALE_SMOOTH);
		return salva1;
	}

	public Image salva2() {
		Image salva2 = new ImageIcon(PasswordDimenticata.class.getResource("immaginiBottoni/salva2.png")).getImage()
				.getScaledInstance(130, 36, Image.SCALE_SMOOTH);
		return salva2;
	}

	public Image salva3() {
		Image salva3 = new ImageIcon(PasswordDimenticata.class.getResource("immaginiBottoni/salva3.png")).getImage()
				.getScaledInstance(130, 36, Image.SCALE_SMOOTH);
		return salva3;
	}

	// GATE
	public Image gateScelta1() {
		Image gateScelta1 = new ImageIcon(SceltaGate.class.getResource("immaginiBottoni/gateScelta1.png")).getImage()
				.getScaledInstance(319, 36, Image.SCALE_SMOOTH);
		return gateScelta1;
	}

	public Image gateScelta2() {
		Image gateScelta2 = new ImageIcon(SceltaGate.class.getResource("immaginiBottoni/gateScelta2.png")).getImage()
				.getScaledInstance(319, 36, Image.SCALE_SMOOTH);
		return gateScelta2;
	}

	public Image gateScelta3() {
		Image gateScelta3 = new ImageIcon(SceltaGate.class.getResource("immaginiBottoni/gateScelta3.png")).getImage()
				.getScaledInstance(319, 36, Image.SCALE_SMOOTH);
		return gateScelta3;
	}

	// CODE DI IMBARCO
	public Image codeDiImbarco1() {
		Image codeDiImbarco1 = new ImageIcon(SceltaGate.class.getResource("immaginiBottoni/codeDiImbarco1.png"))
				.getImage().getScaledInstance(319, 36, Image.SCALE_SMOOTH);
		return codeDiImbarco1;
	}

	public Image codeDiImbarco2() {
		Image codeDiImbarco2 = new ImageIcon(SceltaGate.class.getResource("immaginiBottoni/codeDiImbarco2.png"))
				.getImage().getScaledInstance(319, 36, Image.SCALE_SMOOTH);
		return codeDiImbarco2;
	}

	public Image codeDiImbarco3() {
		Image codeDiImbarco3 = new ImageIcon(SceltaGate.class.getResource("immaginiBottoni/codeDiImbarco3.png"))
				.getImage().getScaledInstance(319, 36, Image.SCALE_SMOOTH);
		return codeDiImbarco3;
	}

	// INFORMAZIONI E TERMINI E CONDIZIONI
	public Image tornaIndietro1() {
		Image tornaIndietro1 = new ImageIcon(
				PasswordDimenticata.class.getResource("immaginiBottoni/tornaIndietro1.png")).getImage()
						.getScaledInstance(319, 36, Image.SCALE_SMOOTH);
		return tornaIndietro1;
	}

	public Image tornaIndietro2() {
		Image tornaIndietro1 = new ImageIcon(
				PasswordDimenticata.class.getResource("immaginiBottoni/tornaIndietro1.png")).getImage()
						.getScaledInstance(319, 36, Image.SCALE_SMOOTH);
		return tornaIndietro1;
	}

	public Image tornaIndietro3() {
		Image tornaIndietro3 = new ImageIcon(
				PasswordDimenticata.class.getResource("immaginiBottoni/tornaIndietro3.png")).getImage()
						.getScaledInstance(319, 36, Image.SCALE_SMOOTH);
		return tornaIndietro3;
	}

	// ACCEDI
	public Image accedi1() {
		Image accedi1 = new ImageIcon(SceltaProfiloSenzaAccesso.class.getResource("immaginiBottoni/accedi1.png"))
				.getImage().getScaledInstance(319, 36, Image.SCALE_SMOOTH);
		return accedi1;
	}

	public Image accedi2() {
		Image accedi2 = new ImageIcon(SceltaProfiloSenzaAccesso.class.getResource("immaginiBottoni/accedi2.png"))
				.getImage().getScaledInstance(319, 36, Image.SCALE_SMOOTH);
		return accedi2;
	}

	public Image accedi3() {
		Image accedi3 = new ImageIcon(SceltaProfiloSenzaAccesso.class.getResource("immaginiBottoni/accedi3.png"))
				.getImage().getScaledInstance(319, 36, Image.SCALE_SMOOTH);
		return accedi3;
	}

	// REGISTRATI
	public Image registrati1() {
		Image registrati1 = new ImageIcon(
				SceltaProfiloSenzaAccesso.class.getResource("immaginiBottoni/registrati1.png")).getImage()
						.getScaledInstance(319, 36, Image.SCALE_SMOOTH);
		return registrati1;
	}

	public Image registrati2() {
		Image registrati2 = new ImageIcon(
				SceltaProfiloSenzaAccesso.class.getResource("immaginiBottoni/registrati2.png")).getImage()
						.getScaledInstance(319, 36, Image.SCALE_SMOOTH);
		return registrati2;
	}

	public Image registrati3() {
		Image registrati3 = new ImageIcon(
				SceltaProfiloSenzaAccesso.class.getResource("immaginiBottoni/registrati3.png")).getImage()
						.getScaledInstance(319, 36, Image.SCALE_SMOOTH);
		return registrati3;
	}

	// ARRIVI
	public Image arrivi1() {
		Image arrivi1 = new ImageIcon(SceltaVolo.class.getResource("immaginiBottoni/arrivi1.png")).getImage()
				.getScaledInstance(319, 36, Image.SCALE_SMOOTH);
		return arrivi1;
	}

	public Image arrivi2() {
		Image arrivi2 = new ImageIcon(SceltaVolo.class.getResource("immaginiBottoni/arrivi2.png")).getImage()
				.getScaledInstance(319, 36, Image.SCALE_SMOOTH);
		return arrivi2;
	}

	public Image arrivi3() {
		Image arrivi3 = new ImageIcon(SceltaVolo.class.getResource("immaginiBottoni/arrivi3.png")).getImage()
				.getScaledInstance(319, 36, Image.SCALE_SMOOTH);
		return arrivi3;
	}

	// ANNULLA
	public Image annulla1() {
		Image annulla1 = new ImageIcon(Uscita.class.getResource("immaginiBottoni/annulla1.png")).getImage()
				.getScaledInstance(319, 36, Image.SCALE_SMOOTH);
		return annulla1;
	}

	public Image annulla2() {
		Image annulla2 = new ImageIcon(Uscita.class.getResource("immaginiBottoni/annulla2.png")).getImage()
				.getScaledInstance(319, 36, Image.SCALE_SMOOTH);
		return annulla2;
	}

	public Image annulla3() {
		Image annulla3 = new ImageIcon(Uscita.class.getResource("immaginiBottoni/annulla3.png")).getImage()
				.getScaledInstance(319, 36, Image.SCALE_SMOOTH);
		return annulla3;
	}

	public Image annullaUscita1() {
		Image annullaUscita1 = new ImageIcon(Uscita.class.getResource("immaginiBottoni/annullaUscita1.png")).getImage()
				.getScaledInstance(130, 36, Image.SCALE_SMOOTH);
		return annullaUscita1;
	}

	public Image annullaUscita2() {
		Image annullaUscita2 = new ImageIcon(Uscita.class.getResource("immaginiBottoni/annullaUscita2.png")).getImage()
				.getScaledInstance(130, 36, Image.SCALE_SMOOTH);
		return annullaUscita2;
	}

	public Image annullaUscita3() {
		Image annullaUscita3 = new ImageIcon(Uscita.class.getResource("immaginiBottoni/annullaUscita3.png")).getImage()
				.getScaledInstance(130, 36, Image.SCALE_SMOOTH);
		return annullaUscita3;
	}

	// AVANTI
	public Image avanti1() {
		Image avanti1 = new ImageIcon(Accesso.class.getResource("immaginiBottoni/avanti1.png")).getImage()
				.getScaledInstance(319, 36, Image.SCALE_SMOOTH);
		return avanti1;
	}

	public Image avanti2() {
		Image avanti2 = new ImageIcon(Accesso.class.getResource("immaginiBottoni/avanti2.png")).getImage()
				.getScaledInstance(319, 36, Image.SCALE_SMOOTH);
		return avanti2;
	}

	public Image avanti3() {
		Image avanti3 = new ImageIcon(Accesso.class.getResource("immaginiBottoni/avanti3.png")).getImage()
				.getScaledInstance(319, 36, Image.SCALE_SMOOTH);
		return avanti3;
	}

	// INVIA
	public Image inviaRecensione1() {
		Image inviaRecensione1 = new ImageIcon(Recensione.class.getResource("immaginiBottoni/invia1.png")).getImage()
				.getScaledInstance(319, 36, Image.SCALE_SMOOTH);
		return inviaRecensione1;
	}

	public Image inviaRecensione2() {
		Image inviaRecensione2 = new ImageIcon(Recensione.class.getResource("immaginiBottoni/invia2.png")).getImage()
				.getScaledInstance(319, 36, Image.SCALE_SMOOTH);
		return inviaRecensione2;
	}

	public Image inviaRecensione3() {
		Image inviaRecensione3 = new ImageIcon(Recensione.class.getResource("immaginiBottoni/invia3.png")).getImage()
				.getScaledInstance(319, 36, Image.SCALE_SMOOTH);
		return inviaRecensione3;
	}

	// PARTENZE
	public Image partenze1() {
		Image partenze1 = new ImageIcon(SceltaVolo.class.getResource("immaginiBottoni/partenze1.png")).getImage()
				.getScaledInstance(319, 36, Image.SCALE_SMOOTH);
		return partenze1;
	}

	public Image partenze2() {
		Image partenze2 = new ImageIcon(SceltaVolo.class.getResource("immaginiBottoni/partenze2.png")).getImage()
				.getScaledInstance(319, 36, Image.SCALE_SMOOTH);
		return partenze2;
	}

	public Image partenze3() {
		Image partenze3 = new ImageIcon(SceltaVolo.class.getResource("immaginiBottoni/partenze3.png")).getImage()
				.getScaledInstance(319, 36, Image.SCALE_SMOOTH);
		return partenze3;
	}

	// SI
	public Image si1() {
		Image si1 = new ImageIcon(Uscita.class.getResource("immaginiBottoni/si1.png")).getImage().getScaledInstance(130,
				36, Image.SCALE_SMOOTH);
		return si1;
	}

	public Image si2() {
		Image si2 = new ImageIcon(Uscita.class.getResource("immaginiBottoni/si2.png")).getImage().getScaledInstance(130,
				36, Image.SCALE_SMOOTH);
		return si2;
	}

	public Image si3() {
		Image si3 = new ImageIcon(Uscita.class.getResource("immaginiBottoni/si3.png")).getImage().getScaledInstance(130,
				36, Image.SCALE_SMOOTH);
		return si3;
	}

	// SALVA MODIFICHE
	public Image salvaModifiche1() {
		Image salvaModifiche1 = new ImageIcon(
				PasswordDimenticata.class.getResource("immaginiBottoni/salvaModifiche1.png")).getImage()
						.getScaledInstance(319, 36, Image.SCALE_SMOOTH);
		return salvaModifiche1;
	}

	public Image salvaModifiche2() {
		Image salvaModifiche2 = new ImageIcon(
				PasswordDimenticata.class.getResource("immaginiBottoni/salvaModifiche2.png")).getImage()
						.getScaledInstance(319, 36, Image.SCALE_SMOOTH);
		return salvaModifiche2;
	}

	public Image salvaModifiche3() {
		Image salvaModifiche3 = new ImageIcon(
				PasswordDimenticata.class.getResource("immaginiBottoni/salvaModifiche3.png")).getImage()
						.getScaledInstance(319, 36, Image.SCALE_SMOOTH);
		return salvaModifiche3;
	}
	
	//UTILIZZO GATE
    public Image utilizzoGate1() {
        Image utilizzoGate1 = new ImageIcon(
                SceltaGate.class.getResource("immaginiBottoni/utilizzoGate1.png")).getImage()
                        .getScaledInstance(319, 36, Image.SCALE_SMOOTH);
        return utilizzoGate1;
    }

    public Image utilizzoGate2() {
        Image utilizzoGate2 = new ImageIcon(
                SceltaGate.class.getResource("immaginiBottoni/utilizzoGate2.png")).getImage()
                        .getScaledInstance(319, 36, Image.SCALE_SMOOTH);
        return utilizzoGate2;
    }

    public Image utilizzoGate3() {
        Image utilizzoGate3 = new ImageIcon(
                SceltaGate.class.getResource("immaginiBottoni/utilizzoGate3.png")).getImage()
                        .getScaledInstance(319, 36, Image.SCALE_SMOOTH);
        return utilizzoGate3;
    }
    
    //AGGIORNA
  	public Image aggiorna1() {
  		Image aggiorna1 = new ImageIcon(UtilizzoGate.class.getResource("immaginiBottoni/aggiorna1.png")).getImage()
  				.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
  		return aggiorna1;
  	}

  	public Image aggiorna2() {
  		Image aggiorna2 = new ImageIcon(UtilizzoGate.class.getResource("immaginiBottoni/aggiorna2.png")).getImage()
  				.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
  		return aggiorna2;
  	}
  	
  	public Image aggiorna3() {
  		Image aggiorna3 = new ImageIcon(UtilizzoGate.class.getResource("immaginiBottoni/aggiorna3.png")).getImage()
  				.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
  		return aggiorna3;
  	}

	/*-----------------------------------------------------------BOTTONI TEMA CHIARO-----------------------------------------------------------*/
    
    //AGGIORNA
  	public Image aggiorna1TemaChiaro() {
  		Image aggiorna1Chiaro = new ImageIcon(UtilizzoGate.class.getResource("immaginiBottoniChiare/aggiorna1Chiaro.png")).getImage()
  				.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
  		return aggiorna1Chiaro;
  	}

  	public Image aggiorna2TemaChiaro() {
  		Image aggiorna2Chiaro = new ImageIcon(UtilizzoGate.class.getResource("immaginiBottoniChiare/aggiorna2Chiaro.png")).getImage()
  				.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
  		return aggiorna2Chiaro;
  	}
  	
  	public Image aggiorna3TemaChiaro() {
  		Image aggiorna3Chiaro = new ImageIcon(UtilizzoGate.class.getResource("immaginiBottoniChiare/aggiorna3Chiaro.png")).getImage()
  				.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
  		return aggiorna3Chiaro;
  	}
  	
  //GIORNO
  	public Image giorno1TemaChiaro() {
  		Image giorno1Chiaro = new ImageIcon(UtilizzoGate.class.getResource("immaginiBottoniChiare/giorno1Chiaro.png")).getImage()
  				.getScaledInstance(130, 36, Image.SCALE_SMOOTH);
  		return giorno1Chiaro;
  	}

  	public Image giorno2TemaChiaro() {
  		Image giorno2Chiaro = new ImageIcon(UtilizzoGate.class.getResource("immaginiBottoniChiare/giorno2Chiaro.png")).getImage()
  				.getScaledInstance(130, 36, Image.SCALE_SMOOTH);
  		return giorno2Chiaro;
  	}

  	public Image giorno3TemaChiaro() {
  		Image giorno3Chiaro = new ImageIcon(UtilizzoGate.class.getResource("immaginiBottoniChiare/giorno3Chiaro.png")).getImage()
  				.getScaledInstance(130, 36, Image.SCALE_SMOOTH);
  		return giorno3Chiaro;
  	}
  	
  	//SETTIMANA
  	public Image settimana1TemaChiaro() {
  		Image settimana1Chiaro = new ImageIcon(UtilizzoGate.class.getResource("immaginiBottoniChiare/settimana1Chiaro.png")).getImage()
  				.getScaledInstance(130, 36, Image.SCALE_SMOOTH);
  		return settimana1Chiaro;
  	}

  	public Image settimana2TemaChiaro() {
  		Image settimana2Chiaro = new ImageIcon(UtilizzoGate.class.getResource("immaginiBottoniChiare/settimana2Chiaro.png")).getImage()
  				.getScaledInstance(130, 36, Image.SCALE_SMOOTH);
  		return settimana2Chiaro;
  	}

  	public Image settimana3TemaChiaro() {
  		Image settimana3Chiaro = new ImageIcon(UtilizzoGate.class.getResource("immaginiBottoniChiare/settimana3Chiaro.png")).getImage()
  				.getScaledInstance(130, 36, Image.SCALE_SMOOTH);
  		return settimana3Chiaro;
  	}
  	
  	
  	//MESE
  	public Image mese1TemaChiaro() {
  		Image mese1Chiaro = new ImageIcon(UtilizzoGate.class.getResource("immaginiBottoniChiare/mese1Chiaro.png")).getImage()
  				.getScaledInstance(130, 36, Image.SCALE_SMOOTH);
  		return mese1Chiaro;
  	}

  	public Image mese2TemaChiaro() {
  		Image mese2Chiaro = new ImageIcon(UtilizzoGate.class.getResource("immaginiBottoniChiare/mese2Chiaro.png")).getImage()
  				.getScaledInstance(130, 36, Image.SCALE_SMOOTH);
  		return mese2Chiaro;
  	}

  	public Image mese3TemaChiaro() {
  		Image mese3Chiaro = new ImageIcon(UtilizzoGate.class.getResource("immaginiBottoniChiare/mese3Chiaro.png")).getImage()
  				.getScaledInstance(130, 36, Image.SCALE_SMOOTH);
  		return mese3Chiaro;
  	}
  	

	// GATE
	public Image gateScelta1TemaChiaro() {
		Image gateScelta1Chiaro = new ImageIcon(
				SceltaGate.class.getResource("immaginiBottoniChiare/gateScelta1Chiaro.png")).getImage()
						.getScaledInstance(319, 36, Image.SCALE_SMOOTH);
		return gateScelta1Chiaro;
	}

	public Image gateScelta2TemaChiaro() {
		Image gateScelta2Chiaro = new ImageIcon(
				SceltaGate.class.getResource("immaginiBottoniChiare/gateScelta2Chiaro.png")).getImage()
						.getScaledInstance(319, 36, Image.SCALE_SMOOTH);
		return gateScelta2Chiaro;
	}

	public Image gateScelta3TemaChiaro() {
		Image gateScelta3Chiaro = new ImageIcon(
				SceltaGate.class.getResource("immaginiBottoniChiare/gateScelta3Chiaro.png")).getImage()
						.getScaledInstance(319, 36, Image.SCALE_SMOOTH);
		return gateScelta3Chiaro;
	}

	// CODE DI IMBARCO
	public Image codeDiImbarco1TemaChiaro() {
		Image codeDiImbarco1Chiaro = new ImageIcon(
				SceltaGate.class.getResource("immaginiBottoniChiare/codeDiImbarco1Chiaro.png")).getImage()
						.getScaledInstance(319, 36, Image.SCALE_SMOOTH);
		return codeDiImbarco1Chiaro;
	}

	public Image codeDiImbarco2TemaChiaro() {
		Image codeDiImbarco2Chiaro = new ImageIcon(
				SceltaGate.class.getResource("immaginiBottoniChiare/codeDiImbarco2Chiaro.png")).getImage()
						.getScaledInstance(319, 36, Image.SCALE_SMOOTH);
		return codeDiImbarco2Chiaro;
	}

	public Image codeDiImbarco3TemaChiaro() {
		Image codeDiImbarco3Chiaro = new ImageIcon(
				SceltaGate.class.getResource("immaginiBottoniChiare/codeDiImbarco3Chiaro.png")).getImage()
						.getScaledInstance(319, 36, Image.SCALE_SMOOTH);
		return codeDiImbarco3Chiaro;
	}

	// SALVA
	public Image salva1TemaChiaro() {
		Image salva1TemaChiaro = new ImageIcon(
				PasswordDimenticata.class.getResource("immaginiBottoniChiare/salva1Chiaro.png")).getImage()
						.getScaledInstance(130, 36, Image.SCALE_SMOOTH);
		return salva1TemaChiaro;
	}

	public Image salva2TemaChiaro() {
		Image salva2TemaChiaro = new ImageIcon(
				PasswordDimenticata.class.getResource("immaginiBottoniChiare/salva2Chiaro.png")).getImage()
						.getScaledInstance(130, 36, Image.SCALE_SMOOTH);
		return salva2TemaChiaro;
	}

	public Image salva3TemaChiaro() {
		Image salva3TemaChiaro = new ImageIcon(
				PasswordDimenticata.class.getResource("immaginiBottoniChiare/salva3Chiaro.png")).getImage()
						.getScaledInstance(130, 36, Image.SCALE_SMOOTH);
		return salva3TemaChiaro;
	}

	// ANNULLA USCITA
	public Image annullaUscita1TemaChiaro() {
		Image annullaUscita1Chiaro = new ImageIcon(
				PasswordDimenticata.class.getResource("immaginiBottoniChiare/annullaUscita1Chiaro.png")).getImage()
						.getScaledInstance(130, 36, Image.SCALE_SMOOTH);
		return annullaUscita1Chiaro;
	}

	public Image annullaUscita2TemaChiaro() {
		Image annullaUscita2Chiaro = new ImageIcon(
				PasswordDimenticata.class.getResource("immaginiBottoniChiare/annullaUscita2Chiaro.png")).getImage()
						.getScaledInstance(130, 36, Image.SCALE_SMOOTH);
		return annullaUscita2Chiaro;
	}

	public Image annullaUscita3TemaChiaro() {
		Image annullaUscita3Chiaro = new ImageIcon(
				PasswordDimenticata.class.getResource("immaginiBottoniChiare/annullaUscita3Chiaro.png")).getImage()
						.getScaledInstance(130, 36, Image.SCALE_SMOOTH);
		return annullaUscita3Chiaro;
	}

	// SALVA MODIFICHE
	public Image salvaModifiche1TemaChiaro() {
		Image salvaModifiche1Chiaro = new ImageIcon(
				CambioPassword.class.getResource("immaginiBottoniChiare/salvaModifiche1Chiaro.png")).getImage()
						.getScaledInstance(319, 36, Image.SCALE_SMOOTH);
		return salvaModifiche1Chiaro;
	}

	public Image salvaModifiche2TemaChiaro() {
		Image salvaModifiche2Chiaro = new ImageIcon(
				CambioPassword.class.getResource("immaginiBottoniChiare/salvaModifiche2Chiaro.png")).getImage()
						.getScaledInstance(319, 36, Image.SCALE_SMOOTH);
		return salvaModifiche2Chiaro;
	}

	public Image salvaModifiche3TemaChiaro() {
		Image salvaModifiche3Chiaro = new ImageIcon(
				CambioPassword.class.getResource("immaginiBoimmaginiBottoniChiarettoni/salvaModifiche3Chiaro.png"))
						.getImage().getScaledInstance(319, 36, Image.SCALE_SMOOTH);
		return salvaModifiche3Chiaro;
	}

	// ACCEDI
	public Image accedi1TemaChiaro() {
		Image accedi1TemaChiaro = new ImageIcon(
				SceltaProfiloSenzaAccesso.class.getResource("immaginiBottoniChiare/accedi1Chiaro.png")).getImage()
						.getScaledInstance(319, 36, Image.SCALE_SMOOTH);
		return accedi1TemaChiaro;
	}

	public Image accedi2TemaChiaro() {
		Image accedi2TemaChiaro = new ImageIcon(
				SceltaProfiloSenzaAccesso.class.getResource("immaginiBottoniChiare/accedi2Chiaro.png")).getImage()
						.getScaledInstance(319, 36, Image.SCALE_SMOOTH);
		return accedi2TemaChiaro;
	}

	public Image accedi3TemaChiaro() {
		Image accedi3TemaChiaro = new ImageIcon(
				SceltaProfiloSenzaAccesso.class.getResource("immaginiBottoniChiare/accedi3Chiaro.png")).getImage()
						.getScaledInstance(319, 36, Image.SCALE_SMOOTH);
		return accedi3TemaChiaro;
	}

	// REGISTRATI
	public Image registrati1TemaChiaro() {
		Image registrati1TemaChiaro = new ImageIcon(
				SceltaProfiloSenzaAccesso.class.getResource("immaginiBottoniChiare/registrati1Chiaro.png")).getImage()
						.getScaledInstance(319, 36, Image.SCALE_SMOOTH);
		return registrati1TemaChiaro;
	}

	public Image registrati2TemaChiaro() {
		Image registrati2TemaChiaro = new ImageIcon(
				SceltaProfiloSenzaAccesso.class.getResource("immaginiBottoniChiare/registrati2Chiaro.png")).getImage()
						.getScaledInstance(319, 36, Image.SCALE_SMOOTH);
		return registrati2TemaChiaro;
	}

	public Image registrati3TemaChiaro() {
		Image registrati3TemaChiaro = new ImageIcon(
				SceltaProfiloSenzaAccesso.class.getResource("immaginiBottoniChiare/registrati3Chiaro.png")).getImage()
						.getScaledInstance(319, 36, Image.SCALE_SMOOTH);
		return registrati3TemaChiaro;
	}

	// ARRIVI
	public Image arrivi1TemaChiaro() {
		Image arrivi1TemaChiaro = new ImageIcon(SceltaVolo.class.getResource("immaginiBottoniChiare/arrivi1Chiaro.png"))
				.getImage().getScaledInstance(319, 36, Image.SCALE_SMOOTH);
		return arrivi1TemaChiaro;
	}

	public Image arrivi2TemaChiaro() {
		Image arrivi2TemaChiaro = new ImageIcon(SceltaVolo.class.getResource("immaginiBottoniChiare/arrivi2Chiaro.png"))
				.getImage().getScaledInstance(319, 36, Image.SCALE_SMOOTH);
		return arrivi2TemaChiaro;
	}

	public Image arrivi3TemaChiaro() {
		Image arrivi3TemaChiaro = new ImageIcon(SceltaVolo.class.getResource("immaginiBottoniChiare/arrivi3Chiaro.png"))
				.getImage().getScaledInstance(319, 36, Image.SCALE_SMOOTH);
		return arrivi3TemaChiaro;
	}

	// ANNULLA
	public Image annulla1TemaChiaro() {
		Image annulla1TemaChiaro = new ImageIcon(Uscita.class.getResource("immaginiBottoniChiare/annulla1Chiaro.png"))
				.getImage().getScaledInstance(319, 36, Image.SCALE_SMOOTH);
		return annulla1TemaChiaro;
	}

	public Image annulla2TemaChiaro() {
		Image annulla2TemaChiaro = new ImageIcon(Uscita.class.getResource("immaginiBottoniChiare/annulla2Chiaro.png"))
				.getImage().getScaledInstance(319, 36, Image.SCALE_SMOOTH);
		return annulla2TemaChiaro;
	}

	public Image annulla3TemaChiaro() {
		Image annulla3TemaChiaro = new ImageIcon(Uscita.class.getResource("immaginiBottoniChiare/annulla3Chiaro.png"))
				.getImage().getScaledInstance(319, 36, Image.SCALE_SMOOTH);
		return annulla3TemaChiaro;
	}

	// AVANTI
	public Image avanti1TemaChiaro() {
		Image avanti1TemaChiaro = new ImageIcon(Accesso.class.getResource("immaginiBottoniChiare/avanti1Chiaro.png"))
				.getImage().getScaledInstance(319, 36, Image.SCALE_SMOOTH);
		return avanti1TemaChiaro;
	}

	public Image avanti2TemaChiaro() {
		Image avanti2TemaChiaro = new ImageIcon(Accesso.class.getResource("immaginiBottoniChiare/avanti2Chiaro.png"))
				.getImage().getScaledInstance(319, 36, Image.SCALE_SMOOTH);
		return avanti2TemaChiaro;
	}

	public Image avanti3TemaChiaro() {
		Image avanti3TemaChiaro = new ImageIcon(Accesso.class.getResource("immaginiBottoniChiare/avanti3Chiaro.png"))
				.getImage().getScaledInstance(319, 36, Image.SCALE_SMOOTH);
		return avanti3TemaChiaro;
	}

	// INVIA
	public Image inviaRecensione1TemaChiaro() {
		Image inviaRecensione1TemaChiaro = new ImageIcon(
				Recensione.class.getResource("immaginiBottoniChiare/invia1Chiaro.png")).getImage()
						.getScaledInstance(319, 36, Image.SCALE_SMOOTH);
		return inviaRecensione1TemaChiaro;
	}

	public Image inviaRecensione2TemaChiaro() {
		Image inviaRecensione2TemaChiaro = new ImageIcon(
				Recensione.class.getResource("immaginiBottoniChiare/invia2Chiaro.png")).getImage()
						.getScaledInstance(319, 36, Image.SCALE_SMOOTH);
		return inviaRecensione2TemaChiaro;
	}

	public Image inviaRecensione3TemaChiaro() {
		Image inviaRecensione3TemaChiaro = new ImageIcon(
				Recensione.class.getResource("immaginiBottoniChiare/invia3Chiaro.png")).getImage()
						.getScaledInstance(319, 36, Image.SCALE_SMOOTH);
		return inviaRecensione3TemaChiaro;
	}

	// PARTENZE
	public Image partenze1TemaChiaro() {
		Image partenze1TemaChiaro = new ImageIcon(
				SceltaVolo.class.getResource("immaginiBottoniChiare/partenze1Chiaro.png")).getImage()
						.getScaledInstance(319, 36, Image.SCALE_SMOOTH);
		return partenze1TemaChiaro;
	}

	public Image partenze2TemaChiaro() {
		Image partenze2TemaChiaro = new ImageIcon(
				SceltaVolo.class.getResource("immaginiBottoniChiare/partenze2Chiaro.png")).getImage()
						.getScaledInstance(319, 36, Image.SCALE_SMOOTH);
		return partenze2TemaChiaro;
	}

	public Image partenze3TemaChiaro() {
		Image partenze3TemaChiaro = new ImageIcon(
				SceltaVolo.class.getResource("immaginiBottoniChiare/partenze3Chiaro.png")).getImage()
						.getScaledInstance(319, 36, Image.SCALE_SMOOTH);
		return partenze3TemaChiaro;
	}

	// SI
	public Image si1TemaChiaro() {
		Image si1TemaChiaro = new ImageIcon(Uscita.class.getResource("immaginiBottoniChiare/si1Chiaro.png")).getImage()
				.getScaledInstance(130, 36, Image.SCALE_SMOOTH);
		return si1TemaChiaro;
	}

	public Image si2TemaChiaro() {
		Image si2TemaChiaro = new ImageIcon(Uscita.class.getResource("immaginiBottoniChiare/si2Chiaro.png")).getImage()
				.getScaledInstance(130, 36, Image.SCALE_SMOOTH);
		return si2TemaChiaro;
	}

	public Image si3TemaChiaro() {
		Image si3TemaChiaro = new ImageIcon(Uscita.class.getResource("immaginiBottoniChiare/si3Chiaro.png")).getImage()
				.getScaledInstance(130, 36, Image.SCALE_SMOOTH);
		return si3TemaChiaro;
	}
	
	// AGGIUNGI
		public Image aggiungi1TemaChiaro() {
			Image aggiungi1Chiaro = new ImageIcon(Uscita.class.getResource("immaginiBottoniChiare/aggiungi1Chiaro.png")).getImage()
					.getScaledInstance(130, 36, Image.SCALE_SMOOTH);
			return aggiungi1Chiaro;
		}

		public Image aggiungi2TemaChiaro() {
			Image aggiungi2Chiaro = new ImageIcon(Uscita.class.getResource("immaginiBottoniChiare/aggiungi2Chiaro.png")).getImage()
					.getScaledInstance(130, 36, Image.SCALE_SMOOTH);
			return aggiungi2Chiaro;
		}

		public Image aggiungi3TemaChiaro() {
			Image aggiungi3Chiaro = new ImageIcon(Uscita.class.getResource("immaginiBottoniChiare/aggiungi3Chiaro.png")).getImage()
					.getScaledInstance(130, 36, Image.SCALE_SMOOTH);
			return aggiungi3Chiaro;
		}
		
		// MODIFICA
		public Image modifica1TemaChiaro() {
			Image modifica1Chiaro = new ImageIcon(Uscita.class.getResource("immaginiBottoniChiare/modifica1Chiaro.png")).getImage()
					.getScaledInstance(130, 36, Image.SCALE_SMOOTH);
			return modifica1Chiaro;
		}

		public Image modifica2TemaChiaro() {
			Image modifica2Chiaro = new ImageIcon(Uscita.class.getResource("immaginiBottoniChiare/modifica2Chiaro.png")).getImage()
					.getScaledInstance(130, 36, Image.SCALE_SMOOTH);
			return modifica2Chiaro;
		}

		public Image modifica3TemaChiaro() {
			Image modifica3Chiaro = new ImageIcon(Uscita.class.getResource("immaginiBottoniChiare/modifica3Chiaro.png")).getImage()
					.getScaledInstance(130, 36, Image.SCALE_SMOOTH);
			return modifica3Chiaro;
		}
		
		// ELIMINA
		public Image elimina1TemaChiaro() {
			Image elimina1Chiaro = new ImageIcon(Uscita.class.getResource("immaginiBottoniChiare/elimina1Chiaro.png")).getImage()
					.getScaledInstance(130, 36, Image.SCALE_SMOOTH);
			return elimina1Chiaro;
		}

		public Image elimina2TemaChiaro() {
			Image elimina2Chiaro = new ImageIcon(Uscita.class.getResource("immaginiBottoniChiare/elimina2Chiaro.png")).getImage()
					.getScaledInstance(130, 36, Image.SCALE_SMOOTH);
			return elimina2Chiaro;
		}

		public Image elimina3TemaChiaro() {
			Image elimina3Chiaro = new ImageIcon(Uscita.class.getResource("immaginiBottoniChiare/elimina3Chiaro.png")).getImage()
					.getScaledInstance(130, 36, Image.SCALE_SMOOTH);
			return elimina3Chiaro;
		}
		
		// SVUOTA
		public Image svuota1TemaChiaro() {
			Image svuota1Chiaro = new ImageIcon(Uscita.class.getResource("immaginiBottoniChiare/svuota1Chiaro.png")).getImage()
					.getScaledInstance(130, 36, Image.SCALE_SMOOTH);
			return svuota1Chiaro;
		}

		public Image svuota2TemaChiaro() {
			Image svuota2Chiaro = new ImageIcon(Uscita.class.getResource("immaginiBottoniChiare/svuota2Chiaro.png")).getImage()
					.getScaledInstance(130, 36, Image.SCALE_SMOOTH);
			return svuota2Chiaro;
		}

		public Image svuota3TemaChiaro() {
			Image svuota3Chiaro = new ImageIcon(Uscita.class.getResource("immaginiBottoniChiare/svuota3Chiaro.png")).getImage()
					.getScaledInstance(130, 36, Image.SCALE_SMOOTH);
			return svuota3Chiaro;
		}
		
		//UTILIZZO GATE
	    public Image utilizzoGate1TemaChiaro() {
	        Image utilizzoGate1Chiaro = new ImageIcon(
	                SceltaGate.class.getResource("immaginiBottoniChiare/utilizzoGate1Chiaro.png")).getImage()
	                        .getScaledInstance(319, 36, Image.SCALE_SMOOTH);
	        return utilizzoGate1Chiaro;
	    }

	    public Image utilizzoGate2TemaChiaro() {
	        Image utilizzoGate2Chiaro = new ImageIcon(
	                SceltaGate.class.getResource("immaginiBottoniChiare/utilizzoGate2Chiaro.png")).getImage()
	                        .getScaledInstance(319, 36, Image.SCALE_SMOOTH);
	        return utilizzoGate2Chiaro;
	    }

	    public Image utilizzoGate3TemaChiaro() {
	        Image utilizzoGate3Chiaro = new ImageIcon(
	                SceltaGate.class.getResource("immaginiBottoniChiare/utilizzoGate3Chiaro.png")).getImage()
	                        .getScaledInstance(319, 36, Image.SCALE_SMOOTH);
	        return utilizzoGate3Chiaro;
	    }
		
		/*-----------------------------------------------------------TOOLTIP-----------------------------------------------------------*/
		
		public Image menuTT() {
			Image menuTT = new ImageIcon(Dashboard.class.getResource("immaginiToolTip/menuTT.png")).getImage()
					.getScaledInstance(60, 31, Image.SCALE_SMOOTH);
			return menuTT;
		}
		
		public Image accediTT() {
			Image accediTT = new ImageIcon(Dashboard.class.getResource("immaginiToolTip/accediTT.png")).getImage()
					.getScaledInstance(72, 31, Image.SCALE_SMOOTH);
			return accediTT;
		}
		
		public Image esciTT() {
			Image esciTT = new ImageIcon(Dashboard.class.getResource("immaginiToolTip/esciTT.png")).getImage()
					.getScaledInstance(54, 31, Image.SCALE_SMOOTH);
			return esciTT;
		}
		
		public Image homeTT() {
			Image homeTT = new ImageIcon(Dashboard.class.getResource("immaginiToolTip/homeTT.png")).getImage()
					.getScaledInstance(65, 31, Image.SCALE_SMOOTH);
			return homeTT;
		}
		
		public Image impostazioniTT() {
			Image impostazioniTT = new ImageIcon(Dashboard.class.getResource("immaginiToolTip/impostazioniTT.png")).getImage()
					.getScaledInstance(110, 31, Image.SCALE_SMOOTH);
			return impostazioniTT;
		}
		
		public Image nascondiPasswordTT() {
			Image nascondiPasswordTT = new ImageIcon(Dashboard.class.getResource("immaginiToolTip/nascondiPasswordTT.png")).getImage()
					.getScaledInstance(123, 31, Image.SCALE_SMOOTH);
			return nascondiPasswordTT;
		}
		
		public Image mostraPasswordTT() {
			Image mostraPasswordTT = new ImageIcon(Dashboard.class.getResource("immaginiToolTip/mostraPasswordTT.png")).getImage()
					.getScaledInstance(123, 31, Image.SCALE_SMOOTH);
			return mostraPasswordTT;
		}
		
		public Image profiloTT() {
			Image profiloTT = new ImageIcon(Dashboard.class.getResource("immaginiToolTip/profiloTT.png")).getImage()
					.getScaledInstance(70, 31, Image.SCALE_SMOOTH);
			return profiloTT;
		}
		
		public Image registratiTT() {
			Image registratiTT = new ImageIcon(Dashboard.class.getResource("immaginiToolTip/registratiTT.png")).getImage()
					.getScaledInstance(91, 31, Image.SCALE_SMOOTH);
			return registratiTT;
		}
		
		public Image temaChiaroTT() {
			Image temaChiaro = new ImageIcon(Dashboard.class.getResource("immaginiToolTip/temaChiaroTT.png")).getImage()
					.getScaledInstance(110, 31, Image.SCALE_SMOOTH);
			return temaChiaro;
		}
		
		public Image temaScuroTT() {
			Image temaScuroTT = new ImageIcon(Dashboard.class.getResource("immaginiToolTip/temaScuroTT.png")).getImage()
					.getScaledInstance(110, 31, Image.SCALE_SMOOTH);
			return temaScuroTT;
		}
		
/*-----------------------------------------------------------TOOLTIP TEMA CHIARO-----------------------------------------------------------*/
		
		public Image menuTTChiaro() {
			Image menuTTChiaro = new ImageIcon(Dashboard.class.getResource("immaginiToolTipChiare/menuTTChiaro.png")).getImage()
					.getScaledInstance(60, 31, Image.SCALE_SMOOTH);
			return menuTTChiaro;
		}
		
		public Image accediTTChiaro() {
			Image accediTTChiaro = new ImageIcon(Dashboard.class.getResource("immaginiToolTipChiare/accediTTChiaro.png")).getImage()
					.getScaledInstance(72, 31, Image.SCALE_SMOOTH);
			return accediTTChiaro;
		}
		
		public Image esciTTChiaro() {
			Image esciTTChiaro = new ImageIcon(Dashboard.class.getResource("immaginiToolTipChiare/esciTTChiaro.png")).getImage()
					.getScaledInstance(54, 31, Image.SCALE_SMOOTH);
			return esciTTChiaro;
		}
		
		public Image homeTTChiaro() {
			Image homeTTChiaro = new ImageIcon(Dashboard.class.getResource("immaginiToolTipChiare/homeTTChiaro.png")).getImage()
					.getScaledInstance(65, 31, Image.SCALE_SMOOTH);
			return homeTTChiaro;
		}
		
		public Image impostazioniTTChiaro() {
			Image impostazioniTTChiaro = new ImageIcon(Dashboard.class.getResource("immaginiToolTipChiare/impostazioniTTChiaro.png")).getImage()
					.getScaledInstance(110, 31, Image.SCALE_SMOOTH);
			return impostazioniTTChiaro;
		}
		
		public Image nascondiPasswordTTChiaro() {
			Image nascondiPasswordTTChiaro = new ImageIcon(Dashboard.class.getResource("immaginiToolTipChiare/nascondiPasswordTTChiaro.png")).getImage()
					.getScaledInstance(123, 31, Image.SCALE_SMOOTH);
			return nascondiPasswordTTChiaro;
		}
		
		public Image mostraPasswordTTChiaro() {
			Image mostraPasswordTTChiaro = new ImageIcon(Dashboard.class.getResource("immaginiToolTipChiare/mostraPasswordTTChiaro.png")).getImage()
					.getScaledInstance(123, 31, Image.SCALE_SMOOTH);
			return mostraPasswordTTChiaro;
		}
		
		public Image profiloTTChiaro() {
			Image profiloTTChiaro = new ImageIcon(Dashboard.class.getResource("immaginiToolTipChiare/profiloTTChiaro.png")).getImage()
					.getScaledInstance(70, 31, Image.SCALE_SMOOTH);
			return profiloTTChiaro;
		}
		
		public Image registratiTTChiaro() {
			Image registratiTTChiaro = new ImageIcon(Dashboard.class.getResource("immaginiToolTipChiare/registratiTTChiaro.png")).getImage()
					.getScaledInstance(91, 31, Image.SCALE_SMOOTH);
			return registratiTTChiaro;
		}
		
		public Image temaChiaroTTChiaro() {
			Image temaChiaroTTChiaro = new ImageIcon(Dashboard.class.getResource("immaginiToolTipChiare/temaChiaroTTChiaro.png")).getImage()
					.getScaledInstance(110, 31, Image.SCALE_SMOOTH);
			return temaChiaroTTChiaro;
		}
		
		public Image temaScuroTTChiaro() {
			Image temaScuroTTChiaro = new ImageIcon(Dashboard.class.getResource("immaginiToolTipChiare/temaScuroTTChiaro.png")).getImage()
					.getScaledInstance(110, 31, Image.SCALE_SMOOTH);
			return temaScuroTTChiaro;
		}


}