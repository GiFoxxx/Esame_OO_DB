package GUI;

import java.awt.Color;

import javax.swing.*;

import Controller.Controller;
import Immagini.Immagini;

import javax.swing.border.EmptyBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import java.awt.event.MouseMotionAdapter;
import java.awt.Font;

public class Dashboard extends JFrame {

	private Immagini img = new Immagini();

	int posizioneTendina = 50;
	int posizioneMessaggioErrore = 0;
	int xMouse;
	int yMouse;
	int xMouseSuSchermo;
	int yMouseSuSchermo;
	int x;
	int y;

	private JPanel contentPane;

	private JLabel lblX;
	private JLabel lblMinimizza;
	private JLabel lineeChiusura;
	private JLabel lineeApertura;
	private JLabel lblSpostaDashboard;
	private JLabel lblTitolo;
	private JLabel lblScrittaHome;
	private JLabel lblHome;
	private JLabel lblScrittaAccesso;
	private JLabel lblAccesso;
	private JLabel lblScrittaRegistrazione;
	private JLabel lblRegistrazione;
	private JLabel lblScrittaProfilo;
	private JLabel lblProfilo;
	private JLabel lblScrittaImpostazioni;
	private JLabel lblImpostazioni;
	private JLabel lblScrittaEsci;
	private JLabel lblEsci;
	private JLabel lblTendina;
	private JLabel lblCambioTemaChiaro;
	private JLabel lblCambioTemaScuro;
	private JLabel lblMessaggioErroreTesto;
	private JLabel lblMessaggioErroreLayout;
	private JLabel lblLayout;
	private JLabel lblAccount;
	private JLabel lblFrecciaMenu;
	private JLabel lblCambioTemaTT;
	private JLabel lblMenuTT;
	private JLabel lblHomeTT;
	private JLabel lblAccediTT;
	private JLabel lblRegistratiTT;
	private JLabel lblProfiloTT;
	private JLabel lblImpostazioniTT;
	private JLabel lblEsciTT;

	private JPanel pannelloTendina;
	private JPanel pannelloBase;
	private JPanel pannelloDestra;
	private JPanel pannelloErrore;
	private JPanel noClick;
	private JPanel panelHome;
	private JPanel panelAccedi;
	private JPanel panelRegistrati;
	private JPanel panelProfilo;
	private JPanel panelImpostazioni;
	private JPanel panelUscita;

	private JPanel home;
	private JPanel accesso;
	private JPanel registrazione;
	private JPanel profilo;
	private JPanel impostazioni;
	private JPanel gestioneUtenti;
	private JPanel gestioneCompagnieAeree;
	private JPanel gestioneVoliPartenze;
	private JPanel gestioneVoliArrivi;
	private JPanel gestioneGate;
	private JPanel gateCodeImbarco;
	private JPanel utilizzoGate;
	private JPanel gestioneTratte;
	private JPanel recensioni;
	private JPanel cambioPassword;
	private JPanel menuInfoAccount;

	private JDialog informazioni;
	private JDialog terminiECondizioni;
	private JDialog operazioneEffettuataConSuccesso;
	private JDialog sceltaProfiloSenzaAccesso;
	private JDialog PasswordDimenticata;
	private JDialog sceltaVolo;
	private JDialog sceltaGate;
	private JDialog uscita;

	// GETTER E SETTER

	public JLabel getLblScrittaHome() {
		return lblScrittaHome;
	}

	public JLabel getLblFrecciaMenu() {
		return lblFrecciaMenu;
	}

	public void setLblFrecciaMenu(JLabel lblFrecciaMenu) {
		this.lblFrecciaMenu = lblFrecciaMenu;
	}

	public void setLblScrittaHome(JLabel lblScrittaHome) {
		this.lblScrittaHome = lblScrittaHome;
	}

	public JLabel getLblScrittaAccesso() {
		return lblScrittaAccesso;
	}

	public void setLblScrittaAccesso(JLabel lblScrittaAccesso) {
		this.lblScrittaAccesso = lblScrittaAccesso;
	}

	public JLabel getLblScrittaRegistrazione() {
		return lblScrittaRegistrazione;
	}

	public void setLblScrittaRegistrazione(JLabel lblScrittaRegistrazione) {
		this.lblScrittaRegistrazione = lblScrittaRegistrazione;
	}

	public JLabel getLblScrittaProfilo() {
		return lblScrittaProfilo;
	}

	public void setLblScrittaProfilo(JLabel lblScrittaProfilo) {
		this.lblScrittaProfilo = lblScrittaProfilo;
	}

	public JLabel getLblScrittaImpostazioni() {
		return lblScrittaImpostazioni;
	}

	public void setLblScrittaImpostazioni(JLabel lblScrittaImpostazioni) {
		this.lblScrittaImpostazioni = lblScrittaImpostazioni;
	}

	public JLabel getLblScrittaEsci() {
		return lblScrittaEsci;
	}

	public void setLblScrittaEsci(JLabel lblScrittaEsci) {
		this.lblScrittaEsci = lblScrittaEsci;
	}

	public JLabel getLblCambioTemaChiaro() {
		return lblCambioTemaChiaro;
	}

	public void setLblCambioTemaChiaro(JLabel lblCambioTema) {
		this.lblCambioTemaChiaro = lblCambioTema;
	}

	public JLabel getLblCambioTemaScuro() {
		return lblCambioTemaScuro;
	}

	public void setLblCambioTemaScuro(JLabel lblCambioTemaScuro) {
		this.lblCambioTemaScuro = lblCambioTemaScuro;
	}

	public JLabel getLblX() {
		return lblX;
	}

	public void setLblX(JLabel lblX) {
		this.lblX = lblX;
	}

	public JLabel getLblMinimizza() {
		return lblMinimizza;
	}

	public void setLblMinimizza(JLabel lblMinimizza) {
		this.lblMinimizza = lblMinimizza;
	}

	public JLabel getLblTitolo() {
		return lblTitolo;
	}

	public void setLblTitolo(JLabel lblTitolo) {
		this.lblTitolo = lblTitolo;
	}

	public JLabel getLblAccount() {
		return lblAccount;
	}

	public void setLblAccount(JLabel lblAccount) {
		this.lblAccount = lblAccount;
	}

	public JLabel getLblSpostaDashboard() {
		return lblSpostaDashboard;
	}

	public void setLblSpostaDashboard(JLabel lblSpostaDashboard) {
		this.lblSpostaDashboard = lblSpostaDashboard;
	}

	public JLabel getLblHome() {
		return lblHome;
	}

	public void setLblHome(JLabel lblHome) {
		this.lblHome = lblHome;
	}

	public JLabel getLblAccesso() {
		return lblAccesso;
	}

	public void setLblAccesso(JLabel lblAccesso) {
		this.lblAccesso = lblAccesso;
	}

	public JLabel getLblRegistrazione() {
		return lblRegistrazione;
	}

	public void setLblRegistrazione(JLabel lblRegistrazione) {
		this.lblRegistrazione = lblRegistrazione;
	}

	public JLabel getLblProfilo() {
		return lblProfilo;
	}

	public void setLblProfilo(JLabel lblProfilo) {
		this.lblProfilo = lblProfilo;
	}

	public JLabel getLblImpostazioni() {
		return lblImpostazioni;
	}

	public void setLblImpostazioni(JLabel lblImpostazioni) {
		this.lblImpostazioni = lblImpostazioni;
	}

	public JLabel getLblEsci() {
		return lblEsci;
	}

	public void setLblEsci(JLabel lblEsci) {
		this.lblEsci = lblEsci;
	}

	public JLabel getLblCambioTemaTT() {
		return lblCambioTemaTT;
	}

	public void setLblCambioTemaTT(JLabel lblCambioTemaTT) {
		this.lblCambioTemaTT = lblCambioTemaTT;
	}

	public JLabel getLblMenuTT() {
		return lblMenuTT;
	}

	public void setLblMenuTT(JLabel lblMenuTT) {
		this.lblMenuTT = lblMenuTT;
	}

	public JLabel getLblHomeTT() {
		return lblHomeTT;
	}

	public void setLblHomeTT(JLabel lblHomeTT) {
		this.lblHomeTT = lblHomeTT;
	}

	public JLabel getLblAccediTT() {
		return lblAccediTT;
	}

	public void setLblAccediTT(JLabel lblAccediTT) {
		this.lblAccediTT = lblAccediTT;
	}

	public JLabel getLblRegistratiTT() {
		return lblRegistratiTT;
	}

	public void setLblRegistratiTT(JLabel lblRegistratiTT) {
		this.lblRegistratiTT = lblRegistratiTT;
	}

	public JLabel getLblProfiloTT() {
		return lblProfiloTT;
	}

	public void setLblProfiloTT(JLabel lblProfiloTT) {
		this.lblProfiloTT = lblProfiloTT;
	}

	public JLabel getLblImpostazioniTT() {
		return lblImpostazioniTT;
	}

	public void setLblImpostazioniTT(JLabel lblImpostazioniTT) {
		this.lblImpostazioniTT = lblImpostazioniTT;
	}

	public JLabel getLblEsciTT() {
		return lblEsciTT;
	}

	public void setLblEsciTT(JLabel lblEsciTT) {
		this.lblEsciTT = lblEsciTT;
	}

	public JLabel getLineeChiusura() {
		return lineeChiusura;
	}

	public void setLineeChiusura(JLabel lineeChiusura) {
		this.lineeChiusura = lineeChiusura;
	}

	public JLabel getLineeApertura() {
		return lineeApertura;
	}

	public void setLineeApertura(JLabel lineeApertura) {
		this.lineeApertura = lineeApertura;
	}

	public int getPosizioneTendina() {
		return posizioneTendina;
	}

	public void setPosizioneTendina(int posizioneTendina) {
		this.posizioneTendina = posizioneTendina;
	}

	public int getPosizioneMessaggioErrore() {
		return posizioneMessaggioErrore;
	}

	public void setPosizioneMessaggioErrore(int posizioneMessaggioErrore) {
		this.posizioneMessaggioErrore = posizioneMessaggioErrore;
	}

	public JPanel getHome() {
		return home;
	}

	public void setHome(JPanel home) {
		this.home = home;
	}

	public JPanel getAccesso() {
		return accesso;
	}

	public void setAccesso(JPanel accesso) {
		this.accesso = accesso;
	}

	public JPanel getRegistrazione() {
		return registrazione;
	}

	public void setRegistrazione(JPanel registrazione1) {
		this.registrazione = registrazione1;
	}

	public JPanel getProfilo() {
		return profilo;
	}

	public void setProfilo(JPanel profilo) {
		this.profilo = profilo;
	}

	public JPanel getImpostazioni() {
		return impostazioni;
	}

	public void setImpostazioni(JPanel impostazioni) {
		this.impostazioni = impostazioni;
	}

	public JPanel getGestioneUtenti() {
		return gestioneUtenti;
	}

	public void setGestioneUtenti(JPanel gestioneUtenti) {
		this.gestioneUtenti = gestioneUtenti;
	}

	public JPanel getGestioneCompagnieAeree() {
		return gestioneCompagnieAeree;
	}

	public void setGestioneCompagnieAeree(JPanel gestioneCompagnieAeree) {
		this.gestioneCompagnieAeree = gestioneCompagnieAeree;
	}

	public JPanel getGestioneGate() {
		return gestioneGate;
	}

	public void setGestioneGate(JPanel gestioneGate) {
		this.gestioneGate = gestioneGate;
	}

	public JPanel getGateCodeImbarco() {
		return gateCodeImbarco;
	}

	public void setGateCodeImbarco(JPanel gateCodeImbarco) {
		this.gateCodeImbarco = gateCodeImbarco;
	}
	
	public JPanel getUtilizzoGate() {
		return utilizzoGate;
	}

	public void setUtilizzoGate(JPanel tempisticheGate) {
		this.utilizzoGate = tempisticheGate;
	}

	public JPanel getGestioneVoliArrivi() {
		return gestioneVoliArrivi;
	}

	public void setGestioneVoliArrivi(JPanel gestioneVoliArrivi) {
		this.gestioneVoliArrivi = gestioneVoliArrivi;
	}

	public JPanel getGestioneVoliPartenze() {
		return gestioneVoliPartenze;
	}

	public void setGestioneVoliPartenze(JPanel gestioneVoliPartenze) {
		this.gestioneVoliPartenze = gestioneVoliPartenze;
	}

	public JPanel getGestioneTratte() {
		return gestioneTratte;
	}

	public void setGestioneTratte(JPanel gestioneTratte1) {
		this.gestioneTratte = gestioneTratte1;
	}

	public JPanel getRecensioni() {
		return recensioni;
	}

	public void setRecensioni(JPanel recensioni) {
		this.recensioni = recensioni;
	}

	public JDialog getOperazioneEffettuataConSuccesso() {
		return operazioneEffettuataConSuccesso;
	}

	public void setOperazioneEffettuataConSuccesso(JDialog operazioneEffettuataConSuccesso) {
		this.operazioneEffettuataConSuccesso = operazioneEffettuataConSuccesso;
	}

	public JDialog getSceltaGate() {
		return sceltaGate;
	}

	public void setSceltaGate(JDialog sceltaGate) {
		this.sceltaGate = sceltaGate;
	}

	public JDialog getUscita() {
		return uscita;
	}

	public void setUscita(JDialog uscita) {
		this.uscita = uscita;
	}

	public JDialog getPasswordDimenticata() {
		return PasswordDimenticata;
	}

	public void setPasswordDimenticata(JDialog passwordDimenticata) {
		PasswordDimenticata = passwordDimenticata;
	}

	public JDialog getSceltaProfiloSenzaAccesso() {
		return sceltaProfiloSenzaAccesso;
	}

	public void setSceltaProfiloSenzaAccesso(JDialog sceltaProfiloSenzaAccesso) {
		this.sceltaProfiloSenzaAccesso = sceltaProfiloSenzaAccesso;
	}

	public JDialog getSceltaVolo() {
		return sceltaVolo;
	}

	public void setSceltaVolo(JDialog sceltaVolo) {
		this.sceltaVolo = sceltaVolo;
	}

	public JPanel getPannelloTendina() {
		return pannelloTendina;
	}

	public void setPannelloTendina(JPanel pannelloTendina) {
		this.pannelloTendina = pannelloTendina;
	}

	public JPanel getPannelloBase() {
		return pannelloBase;
	}

	public void setPannelloBase(JPanel pannelloBase) {
		this.pannelloBase = pannelloBase;
	}

	public JPanel getPannelloDestra() {
		return pannelloDestra;
	}

	public void setPannelloDestra(JPanel pannelloDestra) {
		this.pannelloDestra = pannelloDestra;
	}

	public JPanel getPannelloErrore() {
		return pannelloErrore;
	}

	public void setPannelloErrore(JPanel pannelloErrore) {
		this.pannelloErrore = pannelloErrore;
	}

	public JPanel getNoClick() {
		return noClick;
	}

	public void setNoClick(JPanel noClick) {
		this.noClick = noClick;
	}

	public JPanel getPanelHome() {
		return panelHome;
	}

	public void setPanelHome(JPanel panelHome) {
		this.panelHome = panelHome;
	}

	public JPanel getPanelAccedi() {
		return panelAccedi;
	}

	public void setPanelAccedi(JPanel panelAccedi) {
		this.panelAccedi = panelAccedi;
	}

	public JPanel getPanelRegistrati() {
		return panelRegistrati;
	}

	public void setPanelRegistrati(JPanel panelRegistrati) {
		this.panelRegistrati = panelRegistrati;
	}

	public JPanel getPanelProfilo() {
		return panelProfilo;
	}

	public void setPanelProfilo(JPanel panelProfilo) {
		this.panelProfilo = panelProfilo;
	}

	public JPanel getPanelImpostazioni() {
		return panelImpostazioni;
	}

	public void setPanelImpostazioni(JPanel panelImpostazioni) {
		this.panelImpostazioni = panelImpostazioni;
	}

	public JPanel getPanelUscita() {
		return panelUscita;
	}

	public void setPanelUscita(JPanel panelUscita) {
		this.panelUscita = panelUscita;
	}

	public JPanel getCambioPassword() {
		return cambioPassword;
	}

	public void setCambioPassword(JPanel cambioPassword) {
		this.cambioPassword = cambioPassword;
	}

	public JPanel getMenuInfoAccount() {
		return menuInfoAccount;
	}

	public void setMenuInfoAccount(JPanel menuInfoAccount) {
		this.menuInfoAccount = menuInfoAccount;
	}

	public JLabel getLblMessaggioErroreTesto() {
		return lblMessaggioErroreTesto;
	}

	public void setLblMessaggioErroreTesto(JLabel lblMessaggioErroreTesto) {
		this.lblMessaggioErroreTesto = lblMessaggioErroreTesto;
	}

	public JLabel getLblMessaggioErroreLayout() {
		return lblMessaggioErroreLayout;
	}

	public void setLblMessaggioErroreLayout(JLabel lblMessaggioErrore) {
		this.lblMessaggioErroreLayout = lblMessaggioErrore;
	}

	public JLabel getLblLayout() {
		return lblLayout;
	}

	public void setLblLayout(JLabel lblLayout) {
		this.lblLayout = lblLayout;
	}

	public JLabel getLblTendina() {
		return lblTendina;
	}

	public void setLblTendina(JLabel lblTendina) {
		this.lblTendina = lblTendina;
	}

	public JDialog getInformazioni() {
		return informazioni;
	}

	public void setInformazioni(JDialog informazioni) {
		this.informazioni = informazioni;
	}

	public JDialog getTerminiECondizioni() {
		return terminiECondizioni;
	}

	public void setTerminiECondizioni(JDialog terminiECondizioni) {
		this.terminiECondizioni = terminiECondizioni;
	}

	Controller controllerDashboard;

	public Dashboard(Controller controller) {

		controllerDashboard = controller;

		home = controllerDashboard.home();
		accesso = controllerDashboard.accesso();
		cambioPassword = controllerDashboard.cambioPassword();
		registrazione = controllerDashboard.registrazione();
		profilo = controllerDashboard.profilo();
		impostazioni = controllerDashboard.impostazioni();
		gestioneUtenti = controllerDashboard.gestioneUtenti();
		gestioneCompagnieAeree = controllerDashboard.gestioneCompagnieAeree();
		gestioneGate = controllerDashboard.gestioneGate();
		gateCodeImbarco = controllerDashboard.gateCodeImbarco();
		utilizzoGate = controllerDashboard.utilizzoGate();
		gestioneTratte = controllerDashboard.gestioneTratte();
		gestioneVoliPartenze = controllerDashboard.gestioneVoliPartenze();
		gestioneVoliArrivi = controllerDashboard.gestioneVoliArrivi();
		sceltaProfiloSenzaAccesso = controllerDashboard.sceltaProfiloSenzaAccesso();
		PasswordDimenticata = controllerDashboard.passwordDimenticata();
		sceltaGate = controllerDashboard.sceltaGate();
		sceltaVolo = controllerDashboard.sceltaVolo();
		recensioni = controllerDashboard.recensione();
		noClick = controllerDashboard.noClick();
		menuInfoAccount = controllerDashboard.menuInfoAccount();
		operazioneEffettuataConSuccesso = controllerDashboard.registrazioneEffettuataConSuccesso();
		terminiECondizioni = controllerDashboard.terminiECondizioni();
		informazioni = controllerDashboard.informazioni();
		uscita = controllerDashboard.uscita();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1143, 677);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setUndecorated(true);
		contentPane.setLayout(null);

		lblFrecciaMenu = new JLabel("");
		lblFrecciaMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerDashboard.setStopMenuTT(false);
				if (menuInfoAccount.isVisible()) {
					controllerDashboard.chiudiTendinaIstantanea();
					controllerDashboard.chiudiMenuTT();
					controllerDashboard.chiudiMenuInfoAccount();
				} else {
					controllerDashboard.cambioImmagineTema(lblFrecciaMenu, img.frecciaMenu3TemaChiaro(), img.frecciaMenu3());
					controllerDashboard.chiudiMenuTT();
					controllerDashboard.mostraMenuInfoAccount();
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				controllerDashboard.setStopMenuTT(false);
				controllerDashboard.cambioImmagineTema(lblFrecciaMenu, img.frecciaMenu2TemaChiaro(), img.frecciaMenu2());
				if (!menuInfoAccount.isVisible()) {
					controllerDashboard.mostraMenuTT();
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerDashboard.setStopMenuTT(true);
				controllerDashboard.cambioImmagineTema(lblFrecciaMenu, img.frecciaMenu1TemaChiaro(), img.frecciaMenu1());
				controllerDashboard.chiudiMenuTT();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				controllerDashboard.cambioImmagineTema(lblFrecciaMenu, img.frecciaMenu3TemaChiaro(), img.frecciaMenu3());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				controllerDashboard.cambioImmagineTema(lblFrecciaMenu, img.frecciaMenu1TemaChiaro(), img.frecciaMenu1());
			}
		});
		lblFrecciaMenu.setVisible(false);
		lblFrecciaMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblFrecciaMenu.setIcon(new ImageIcon(img.frecciaMenu1()));
		lblFrecciaMenu.setBounds(980, 0, 23, 35);
		contentPane.add(lblFrecciaMenu);

		lblTitolo = new JLabel("AIRPORT MANAGEMENT");
		lblTitolo.setBounds(0, 0, 238, 37);
		lblTitolo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitolo.setForeground(controllerDashboard.coloreScritteTemaScuro);
		lblTitolo.setFont(controllerDashboard.fontTitolo);
		contentPane.add(lblTitolo);

		lblX = new JLabel("");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Dashboard.this.dispose();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				controllerDashboard.cambioImmagineTema(lblX, img.X2TemaChiaro(), img.X2());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerDashboard.cambioImmagineTema(lblX, img.X1TemaChiaro(), img.X1());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				controllerDashboard.cambioImmagineTema(lblX, img.X3TemaChiaro(), img.X3());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				controllerDashboard.cambioImmagineTema(lblX, img.X1TemaChiaro(), img.X1());
			}
		});
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setIcon(new ImageIcon(img.X1()));
		lblX.setBounds(1092, 0, 51, 35);
		contentPane.add(lblX);

		lblMinimizza = new JLabel("");
		lblMinimizza.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(Dashboard.ICONIFIED);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				controllerDashboard.cambioImmagineTema(lblMinimizza, img.minimizza2TemaChiaro(), img.minimizza2());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerDashboard.cambioImmagineTema(lblMinimizza, img.minimizza1TemaChiaro(), img.minimizza1());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				controllerDashboard.cambioImmagineTema(lblMinimizza, img.minimizza3TemaChiaro(), img.minimizza3());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				controllerDashboard.cambioImmagineTema(lblMinimizza, img.minimizza1TemaChiaro(), img.minimizza1());
				}
		});

		lblMinimizza.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinimizza.setIcon(new ImageIcon(img.minimizza1()));
		lblMinimizza.setBounds(1040, 0, 51, 35);
		contentPane.add(lblMinimizza);

		lblAccount = new JLabel("Nessun accesso effettuato");
		lblAccount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerDashboard.pannelloLateraleSelezionato();
				controllerDashboard.clickPannelloLateraleProfilo();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblProfiloTT.setBounds(825, 11, 90, 23);
				controllerDashboard.setStopProfiloTT(false);
				controllerDashboard.chiudiTuttiTT();
				controllerDashboard.mostraProfiloTT();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerDashboard.setStopProfiloTT(true);
				controllerDashboard.chiudiTuttiTT();
				controllerDashboard.chiudiProfiloTT();
			}
		});
		lblAccount.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAccount.setForeground(controllerDashboard.coloreScritteTemaScuro);
		lblAccount.setFont(controllerDashboard.fontLabel);
		lblAccount.setBorder(null);
		lblAccount.setBackground(controllerDashboard.trasparente);
		lblAccount.setBounds(760, 7, 216, 23);
		contentPane.add(lblAccount);

		lblSpostaDashboard = new JLabel("");
		lblSpostaDashboard.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent spostaDashboard) {
				x = spostaDashboard.getXOnScreen();
				y = spostaDashboard.getYOnScreen();
				xMouseSuSchermo = spostaDashboard.getXOnScreen();
				yMouseSuSchermo = spostaDashboard.getYOnScreen();
				setLocation(x - xMouse, y - yMouse);
//				if (yMouseSuSchermo >= 2) {
//					contentPane.setSize(1143, 677);
//					pannelloBase.setSize(1143, 677);
//					pannelloDestra.setSize(1090, 642);
//					lblLayout.setIcon(new ImageIcon(img.sfondo()));
//				}

			}
		});
		lblSpostaDashboard.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent prendiPosizioneMouse) {

				xMouse = prendiPosizioneMouse.getX();
				yMouse = prendiPosizioneMouse.getY();

			}

			@Override
			public void mouseReleased(MouseEvent e) {

//				if (yMouseSuSchermo < 2) {
//					contentPane.setSize(controllerDashboard.dimensioneSchermoX(),
//							controllerDashboard.dimensioneSchermoY());
//					pannelloBase.setSize(controllerDashboard.dimensioneSchermoX(),
//							controllerDashboard.dimensioneSchermoY());
//					pannelloDestra.setSize(controllerDashboard.dimensioneSchermoX(),
//							controllerDashboard.dimensioneSchermoY());
//					lblLayout.setIcon(new ImageIcon(img.imgSfondoFull()));
//
//					setExtendedState(Dashboard.MAXIMIZED_BOTH);
//				}
			}
		});
		lblSpostaDashboard.setIcon(new ImageIcon(img.spostaDashboard()));
		lblSpostaDashboard.setBounds(0, 0, 1143, 35);
		contentPane.add(lblSpostaDashboard);

		pannelloBase = new JPanel();
		pannelloBase.setBackground(controllerDashboard.trasparente);
		pannelloBase.setBounds(0, 35, 1143, 642);
		contentPane.add(pannelloBase);
		pannelloBase.setLayout(null);

		pannelloTendina = new JPanel();
		pannelloTendina.setBackground(controllerDashboard.trasparente);
		pannelloTendina.setBounds(0, 0, 50, 642);
		pannelloTendina.setLayout(null);
		pannelloBase.add(pannelloTendina);

		panelHome = new JPanel();
		panelHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerDashboard.clickPannelloLateraleHome();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				if (home.isVisible()) {
					controllerDashboard.cambioPannelloTema(panelHome, controllerDashboard.pannelloSceltoTemaChiaro, controllerDashboard.pannelloSceltoTemaScuro);
				} else {
					controllerDashboard.cambioPannelloTema(panelHome, controllerDashboard.entroPannelloTemaChiaro, controllerDashboard.entroPannelloTemaScuro);
				}
				if (getPosizioneTendina() == 50) {
					controllerDashboard.setStopHomeTT(false);
					controllerDashboard.chiudiTuttiTT();
					controllerDashboard.mostraHomeTT();
				}

			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerDashboard.setStopHomeTT(true);
				if (home.isVisible()) {
					controllerDashboard.cambioPannelloTema(panelHome, controllerDashboard.pannelloSceltoTemaChiaro, controllerDashboard.pannelloSceltoTemaScuro);
				} else {
					controllerDashboard.cambioPannelloTema(panelHome, controllerDashboard.escoPannelloTemaChiaro, controllerDashboard.escoPannelloTemaScuro);
				}
				if (getPosizioneTendina() == 50) {
					controllerDashboard.chiudiTuttiTT();
					controllerDashboard.chiudiHomeTT();
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (home.isVisible()) {
					controllerDashboard.cambioPannelloTema(panelHome, controllerDashboard.pannelloSceltoTemaChiaro, controllerDashboard.pannelloSceltoTemaScuro);
				} else {
					controllerDashboard.cambioPannelloTema(panelHome, controllerDashboard.clickPannelloTemaChiaro, controllerDashboard.clickPannelloTemaScuro);
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (home.isVisible()) {
					controllerDashboard.cambioPannelloTema(panelHome, controllerDashboard.pannelloSceltoTemaChiaro, controllerDashboard.pannelloSceltoTemaScuro);
				} else {
					controllerDashboard.cambioPannelloTema(panelHome, controllerDashboard.escoPannelloTemaChiaro, controllerDashboard.escoPannelloTemaScuro);
				}
			}
		});
		panelHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelHome.setBounds(1, 135, 236, 70);
		panelHome.setBackground(controllerDashboard.trasparente);
		panelHome.setLayout(null);
		pannelloTendina.add(panelHome);

		lblScrittaHome = new JLabel("Home");
		lblScrittaHome.setBounds(57, 0, 180, 70);
		lblScrittaHome.setFont(controllerDashboard.fontScritteTendina);
		lblScrittaHome.setForeground(controllerDashboard.coloreScritteTemaScuro);
		lblScrittaHome.setHorizontalAlignment(SwingConstants.LEFT);
		panelHome.add(lblScrittaHome);

		lblHome = new JLabel("");
		lblHome.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		lblHome.setBounds(0, 0, 50, 70);
		lblHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblHome.setIcon(new ImageIcon(img.casa()));
		panelHome.add(lblHome);

		panelAccedi = new JPanel();
		panelAccedi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerDashboard.clickPannelloLateraleAccedi();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				if (accesso.isVisible()) {
					controllerDashboard.cambioPannelloTema(panelAccedi, controllerDashboard.pannelloSceltoTemaChiaro, controllerDashboard.pannelloSceltoTemaScuro);
				} else {
					controllerDashboard.cambioPannelloTema(panelAccedi, controllerDashboard.entroPannelloTemaChiaro, controllerDashboard.entroPannelloTemaScuro);
				}
				if (getPosizioneTendina() == 50) {
					controllerDashboard.setStopAccediTT(false);
					controllerDashboard.chiudiTuttiTT();
					controllerDashboard.mostraAccediTT();

				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerDashboard.setStopAccediTT(true);
				if (accesso.isVisible()) {
					controllerDashboard.cambioPannelloTema(panelAccedi, controllerDashboard.pannelloSceltoTemaChiaro, controllerDashboard.pannelloSceltoTemaScuro);
				} else {
					controllerDashboard.cambioPannelloTema(panelAccedi, controllerDashboard.escoPannelloTemaChiaro, controllerDashboard.escoPannelloTemaScuro);
				}
				if (getPosizioneTendina() == 50) {
					controllerDashboard.chiudiTuttiTT();
					controllerDashboard.chiudiAccediTT();

				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (accesso.isVisible()) {
					controllerDashboard.cambioPannelloTema(panelAccedi, controllerDashboard.pannelloSceltoTemaChiaro, controllerDashboard.pannelloSceltoTemaScuro);
				} else {
					controllerDashboard.cambioPannelloTema(panelAccedi, controllerDashboard.clickPannelloTemaChiaro, controllerDashboard.clickPannelloTemaScuro);
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (accesso.isVisible()) {
					controllerDashboard.cambioPannelloTema(panelAccedi, controllerDashboard.pannelloSceltoTemaChiaro, controllerDashboard.pannelloSceltoTemaScuro);
				} else {
					controllerDashboard.cambioPannelloTema(panelAccedi, controllerDashboard.escoPannelloTemaChiaro, controllerDashboard.escoPannelloTemaScuro);
				}
			}
		});
		panelAccedi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelAccedi.setBounds(1, 205, 236, 70);
		panelAccedi.setBackground(controllerDashboard.trasparente);
		pannelloTendina.add(panelAccedi);
		panelAccedi.setLayout(null);

		lblScrittaAccesso = new JLabel("Accedi");
		lblScrittaAccesso.setBounds(57, 0, 180, 70);
		lblScrittaAccesso.setFont(controllerDashboard.fontScritteTendina);
		lblScrittaAccesso.setForeground(controllerDashboard.coloreScritteTemaScuro);
		lblScrittaAccesso.setHorizontalAlignment(SwingConstants.LEFT);
		panelAccedi.add(lblScrittaAccesso);

		lblAccesso = new JLabel("");
		lblAccesso.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		lblAccesso.setBounds(0, 0, 50, 70);
		panelAccedi.add(lblAccesso);
		lblAccesso.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccesso.setIcon(new ImageIcon(img.accedi()));

		panelRegistrati = new JPanel();
		panelRegistrati.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelRegistrati.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerDashboard.clickPannelloLateraleRegistrati();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				if (registrazione.isVisible()) {
					controllerDashboard.cambioPannelloTema(panelRegistrati, controllerDashboard.pannelloSceltoTemaChiaro, controllerDashboard.pannelloSceltoTemaScuro);
				} else {
					controllerDashboard.cambioPannelloTema(panelRegistrati, controllerDashboard.entroPannelloTemaChiaro, controllerDashboard.entroPannelloTemaScuro);
				}
				if (getPosizioneTendina() == 50) {
					controllerDashboard.setStopRegistratiTT(false);
					controllerDashboard.chiudiTuttiTT();
					controllerDashboard.mostraRegistratiTT();

				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerDashboard.setStopRegistratiTT(true);
				if (registrazione.isVisible()) {
					controllerDashboard.cambioPannelloTema(panelRegistrati, controllerDashboard.pannelloSceltoTemaChiaro, controllerDashboard.pannelloSceltoTemaScuro);
				} else {
					controllerDashboard.cambioPannelloTema(panelRegistrati, controllerDashboard.escoPannelloTemaChiaro, controllerDashboard.escoPannelloTemaScuro);
				}
				if (getPosizioneTendina() == 50) {
					controllerDashboard.chiudiTuttiTT();
					controllerDashboard.chiudiRegistratiTT();

				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (registrazione.isVisible()) {
					controllerDashboard.cambioPannelloTema(panelRegistrati, controllerDashboard.pannelloSceltoTemaChiaro, controllerDashboard.pannelloSceltoTemaScuro);
				} else {
					controllerDashboard.cambioPannelloTema(panelRegistrati, controllerDashboard.clickPannelloTemaChiaro, controllerDashboard.clickPannelloTemaScuro);
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (registrazione.isVisible()) {
					controllerDashboard.cambioPannelloTema(panelRegistrati, controllerDashboard.pannelloSceltoTemaChiaro, controllerDashboard.pannelloSceltoTemaScuro);
				} else {
					controllerDashboard.cambioPannelloTema(panelRegistrati, controllerDashboard.escoPannelloTemaChiaro, controllerDashboard.escoPannelloTemaScuro);
				}
			}
		});
		panelRegistrati.setBounds(1, 275, 236, 70);
		panelRegistrati.setBackground(controllerDashboard.trasparente);
		pannelloTendina.add(panelRegistrati);
		panelRegistrati.setLayout(null);

		lblScrittaRegistrazione = new JLabel("Registrati");
		lblScrittaRegistrazione.setBounds(57, 0, 180, 70);
		lblScrittaRegistrazione.setFont(controllerDashboard.fontScritteTendina);
		lblScrittaRegistrazione.setForeground(controllerDashboard.coloreScritteTemaScuro);
		lblScrittaRegistrazione.setHorizontalAlignment(SwingConstants.LEFT);
		panelRegistrati.add(lblScrittaRegistrazione);

		lblRegistrazione = new JLabel("");
		lblRegistrazione.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		lblRegistrazione.setBounds(0, 0, 50, 70);
		lblRegistrazione.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrazione.setIcon(new ImageIcon(img.registrati()));
		panelRegistrati.add(lblRegistrazione);

		panelProfilo = new JPanel();
		panelProfilo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelProfilo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerDashboard.clickPannelloLateraleProfilo();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblProfiloTT.setBounds(10, 365, 90, 23);
				if (profilo.isVisible()) {
					controllerDashboard.cambioPannelloTema(panelProfilo, controllerDashboard.pannelloSceltoTemaChiaro, controllerDashboard.pannelloSceltoTemaScuro);
				} else {
					controllerDashboard.cambioPannelloTema(panelProfilo, controllerDashboard.entroPannelloTemaChiaro, controllerDashboard.entroPannelloTemaScuro);
				}
				if (getPosizioneTendina() == 50) {
					controllerDashboard.setStopProfiloTT(false);
					controllerDashboard.chiudiTuttiTT();
					controllerDashboard.mostraProfiloTT();

				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerDashboard.setStopProfiloTT(true);
				if (profilo.isVisible()) {
					controllerDashboard.cambioPannelloTema(panelProfilo, controllerDashboard.pannelloSceltoTemaChiaro, controllerDashboard.pannelloSceltoTemaScuro);
				} else {
					controllerDashboard.cambioPannelloTema(panelProfilo, controllerDashboard.escoPannelloTemaChiaro, controllerDashboard.escoPannelloTemaScuro);
				}
				if (getPosizioneTendina() == 50) {
					controllerDashboard.chiudiTuttiTT();
					controllerDashboard.chiudiProfiloTT();
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (profilo.isVisible()) {
					controllerDashboard.cambioPannelloTema(panelProfilo, controllerDashboard.pannelloSceltoTemaChiaro, controllerDashboard.pannelloSceltoTemaScuro);
				} else {
					controllerDashboard.cambioPannelloTema(panelProfilo, controllerDashboard.clickPannelloTemaChiaro, controllerDashboard.clickPannelloTemaScuro);
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (profilo.isVisible()) {
					controllerDashboard.cambioPannelloTema(panelProfilo, controllerDashboard.pannelloSceltoTemaChiaro, controllerDashboard.pannelloSceltoTemaScuro);
				} else {
					controllerDashboard.cambioPannelloTema(panelProfilo, controllerDashboard.escoPannelloTemaChiaro, controllerDashboard.escoPannelloTemaScuro);
				}
			}
		});
		panelProfilo.setBounds(1, 345, 236, 70);
		panelProfilo.setBackground(controllerDashboard.trasparente);
		panelProfilo.setLayout(null);
		pannelloTendina.add(panelProfilo);

		lblScrittaProfilo = new JLabel("Profilo");
		lblScrittaProfilo.setBounds(57, 0, 180, 70);
		lblScrittaProfilo.setFont(controllerDashboard.fontScritteTendina);
		lblScrittaProfilo.setForeground(controllerDashboard.coloreScritteTemaScuro);
		lblScrittaProfilo.setHorizontalAlignment(SwingConstants.LEFT);
		panelProfilo.add(lblScrittaProfilo);

		lblProfilo = new JLabel("");
		lblProfilo.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		lblProfilo.setBounds(0, 0, 50, 70);
		lblProfilo.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfilo.setIcon(new ImageIcon(img.profilo()));
		panelProfilo.add(lblProfilo);

		panelImpostazioni = new JPanel();
		panelImpostazioni.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelImpostazioni.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerDashboard.clickPannelloLateraleImpostazioni();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				if (impostazioni.isVisible()) {
					controllerDashboard.cambioPannelloTema(panelImpostazioni, controllerDashboard.pannelloSceltoTemaChiaro, controllerDashboard.pannelloSceltoTemaScuro);
				} else {
					controllerDashboard.cambioPannelloTema(panelImpostazioni, controllerDashboard.entroPannelloTemaChiaro, controllerDashboard.entroPannelloTemaScuro);
				}
				if (getPosizioneTendina() == 50) {
					controllerDashboard.setStopImpostazioniTT(false);
					controllerDashboard.chiudiTuttiTT();
					controllerDashboard.mostraImpostazioniTT();
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerDashboard.setStopImpostazioniTT(true);
				if (impostazioni.isVisible()) {
					controllerDashboard.cambioPannelloTema(panelImpostazioni, controllerDashboard.pannelloSceltoTemaChiaro, controllerDashboard.pannelloSceltoTemaScuro);
				} else {
					controllerDashboard.cambioPannelloTema(panelImpostazioni, controllerDashboard.escoPannelloTemaChiaro, controllerDashboard.escoPannelloTemaScuro);
				}
				if (getPosizioneTendina() == 50) {
					controllerDashboard.chiudiTuttiTT();
					controllerDashboard.chiudiImpostazioniTT();
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (impostazioni.isVisible()) {
					controllerDashboard.cambioPannelloTema(panelImpostazioni, controllerDashboard.pannelloSceltoTemaChiaro, controllerDashboard.pannelloSceltoTemaScuro);
				} else {
					controllerDashboard.cambioPannelloTema(panelImpostazioni, controllerDashboard.clickPannelloTemaChiaro, controllerDashboard.clickPannelloTemaScuro);
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (impostazioni.isVisible()) {
					controllerDashboard.cambioPannelloTema(panelImpostazioni, controllerDashboard.pannelloSceltoTemaChiaro, controllerDashboard.pannelloSceltoTemaScuro);
				} else {
					controllerDashboard.cambioPannelloTema(panelImpostazioni, controllerDashboard.escoPannelloTemaChiaro, controllerDashboard.escoPannelloTemaScuro);
				}
			}
		});
		panelImpostazioni.setBounds(1, 415, 236, 70);
		panelImpostazioni.setBackground(controllerDashboard.trasparente);
		pannelloTendina.add(panelImpostazioni);
		panelImpostazioni.setLayout(null);

		lblScrittaImpostazioni = new JLabel("Impostazioni");
		lblScrittaImpostazioni.setBounds(57, 0, 180, 70);
		lblScrittaImpostazioni.setFont(controllerDashboard.fontScritteTendina);
		lblScrittaImpostazioni.setForeground(controllerDashboard.coloreScritteTemaScuro);
		lblScrittaImpostazioni.setHorizontalAlignment(SwingConstants.LEFT);
		panelImpostazioni.add(lblScrittaImpostazioni);

		lblImpostazioni = new JLabel("");
		lblImpostazioni.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		lblImpostazioni.setBounds(0, 0, 50, 70);
		panelImpostazioni.add(lblImpostazioni);
		lblImpostazioni.setHorizontalAlignment(SwingConstants.CENTER);
		lblImpostazioni.setIcon(new ImageIcon(img.impostazioni()));

		panelUscita = new JPanel();
		panelUscita.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelUscita.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerDashboard.clickPannelloLateraleUscita();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				if (uscita.isVisible()) {
					controllerDashboard.cambioPannelloTema(panelUscita, controllerDashboard.pannelloSceltoTemaChiaro, controllerDashboard.pannelloSceltoTemaScuro);
				} else {
					controllerDashboard.cambioPannelloTema(panelUscita, controllerDashboard.entroPannelloTemaChiaro, controllerDashboard.entroPannelloTemaScuro);
				}
				if (getPosizioneTendina() == 50) {
					controllerDashboard.setStopEsciTT(false);
					controllerDashboard.chiudiTuttiTT();
					controllerDashboard.mostraEsciTT();
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerDashboard.setStopEsciTT(true);
				if (uscita.isVisible()) {
					controllerDashboard.cambioPannelloTema(panelUscita, controllerDashboard.pannelloSceltoTemaChiaro, controllerDashboard.pannelloSceltoTemaScuro);
				} else {
					controllerDashboard.cambioPannelloTema(panelUscita, controllerDashboard.escoPannelloTemaChiaro, controllerDashboard.escoPannelloTemaScuro);
				}
				if (getPosizioneTendina() == 50) {
					controllerDashboard.chiudiTuttiTT();
					controllerDashboard.chiudiEsciTT();
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (uscita.isVisible()) {
					controllerDashboard.cambioPannelloTema(panelUscita, controllerDashboard.pannelloSceltoTemaChiaro, controllerDashboard.pannelloSceltoTemaScuro);
				} else {
					controllerDashboard.cambioPannelloTema(panelUscita, controllerDashboard.clickPannelloTemaChiaro, controllerDashboard.clickPannelloTemaScuro);
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (uscita.isVisible()) {
					controllerDashboard.cambioPannelloTema(panelUscita, controllerDashboard.pannelloSceltoTemaChiaro, controllerDashboard.pannelloSceltoTemaScuro);
				} else {
					controllerDashboard.cambioPannelloTema(panelUscita, controllerDashboard.escoPannelloTemaChiaro, controllerDashboard.escoPannelloTemaScuro);
				}
			}
		});
		panelUscita.setBounds(1, 485, 236, 70);
		panelUscita.setBackground(controllerDashboard.trasparente);
		pannelloTendina.add(panelUscita);
		panelUscita.setLayout(null);

		lblScrittaEsci = new JLabel("Esci");
		lblScrittaEsci.setBounds(57, 0, 180, 70);
		lblScrittaEsci.setFont(controllerDashboard.fontScritteTendina);
		lblScrittaEsci.setForeground(controllerDashboard.coloreScritteTemaScuro);
		lblScrittaEsci.setHorizontalAlignment(SwingConstants.LEFT);
		panelUscita.add(lblScrittaEsci);

		lblEsci = new JLabel("");
		lblEsci.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		lblEsci.setBounds(0, 0, 50, 70);
		lblEsci.setHorizontalAlignment(SwingConstants.CENTER);
		lblEsci.setIcon(new ImageIcon(img.esci()));
		panelUscita.add(lblEsci);

		lineeChiusura = new JLabel("");
		lineeApertura = new JLabel("");
		lineeChiusura.setVisible(false);
		lineeApertura.setVisible(true);
		lineeChiusura.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerDashboard.chiudiTendina();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				controllerDashboard.cambioImmagineTema(lineeChiusura, img.lineeChiusura2TemaChiaro(), img.lineeChiusura2());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerDashboard.cambioImmagineTema(lineeChiusura, img.lineeChiusura1TemaChiaro(), img.lineeChiusura1());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				controllerDashboard.cambioImmagineTema(lineeChiusura, img.lineeChiusura3TemaChiaro(), img.lineeChiusura3());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				controllerDashboard.cambioImmagineTema(lineeChiusura, img.lineeChiusura1TemaChiaro(), img.lineeChiusura1());
			}
		});
		lineeChiusura.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lineeChiusura.setHorizontalAlignment(SwingConstants.CENTER);
		lineeChiusura.setIcon(new ImageIcon(img.lineeChiusura1()));
		lineeChiusura.setBounds(182, 20, 50, 50);
		pannelloTendina.add(lineeChiusura);

		lineeApertura.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerDashboard.apriTendina();
				controllerDashboard.mostraPannelli(noClick);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				controllerDashboard.cambioImmagineTema(lineeApertura, img.lineeApertura2TemaChiaro(), img.lineeApertura2());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerDashboard.cambioImmagineTema(lineeApertura, img.lineeApertura1TemaChiaro(), img.lineeApertura1());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				controllerDashboard.cambioImmagineTema(lineeApertura, img.lineeApertura3TemaChiaro(), img.lineeApertura3());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				controllerDashboard.cambioImmagineTema(lineeApertura, img.lineeApertura1TemaChiaro(), img.lineeApertura1());
			}
		});
		lineeApertura.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lineeApertura.setBounds(1, 20, 50, 50);
		lineeApertura.setHorizontalAlignment(SwingConstants.CENTER);
		lineeApertura.setIcon(new ImageIcon(img.lineeApertura1()));
		pannelloTendina.add(lineeApertura);

		lblCambioTemaChiaro = new JLabel("");
		lblCambioTemaChiaro.setHorizontalAlignment(SwingConstants.CENTER);
		lblCambioTemaChiaro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerDashboard.temaChiaro();
				controllerDashboard.chiudiTendinaIstantanea();
				controllerDashboard.pannelloPrecedentementeSelezionato(controllerDashboard.getPannelloPrecedente());
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblCambioTemaChiaro.setIcon(new ImageIcon(img.temaChiaro2()));
				if (getPosizioneTendina() == 238) {
					controllerDashboard.setStopCambioTemaTT(false);
					controllerDashboard.chiudiTuttiTT();
					controllerDashboard.mostraCambioTemaTT();
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				lblCambioTemaChiaro.setIcon(new ImageIcon(img.temaChiaro3()));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerDashboard.setStopHomeTT(true);
				lblCambioTemaChiaro.setIcon(new ImageIcon(img.temaChiaro1()));
				if (getPosizioneTendina() == 238) {
					controllerDashboard.setStopCambioTemaTT(true);
					controllerDashboard.chiudiTuttiTT();
					controllerDashboard.chiudiCambioTemaTT();
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				lblCambioTemaChiaro.setIcon(new ImageIcon(img.temaChiaro1()));
			}
		});
		lblCambioTemaChiaro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblCambioTemaChiaro.setIcon(new ImageIcon(img.temaChiaro1()));
		lblCambioTemaChiaro.setBounds(94, 81, 50, 50);
		pannelloTendina.add(lblCambioTemaChiaro);

		lblCambioTemaScuro = new JLabel("");
		lblCambioTemaScuro.setVisible(false);
		lblCambioTemaScuro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerDashboard.temaScuro();
				controllerDashboard.chiudiTendinaIstantanea();
				controllerDashboard.pannelloPrecedentementeSelezionato(controllerDashboard.getPannelloPrecedente());
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblCambioTemaScuro.setIcon(new ImageIcon(img.temaScuro2()));
				if (getPosizioneTendina() == 238) {
					controllerDashboard.setStopCambioTemaTT(false);
					controllerDashboard.chiudiTuttiTT();
					controllerDashboard.mostraCambioTemaTT();
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerDashboard.setStopCambioTemaTT(true);
				lblCambioTemaScuro.setIcon(new ImageIcon(img.temaScuro1()));
				if (getPosizioneTendina() == 238) {
					controllerDashboard.setStopCambioTemaTT(true);
					controllerDashboard.chiudiTuttiTT();
					controllerDashboard.chiudiCambioTemaTT();
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				lblCambioTemaScuro.setIcon(new ImageIcon(img.temaScuro3()));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				lblCambioTemaScuro.setIcon(new ImageIcon(img.temaScuro1()));
			}
		});
		lblCambioTemaScuro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblCambioTemaScuro.setIcon(new ImageIcon(img.temaScuro1()));
		lblCambioTemaScuro.setBounds(94, 81, 50, 50);
		pannelloTendina.add(lblCambioTemaScuro);

		lblCambioTemaTT = new JLabel("");
		lblCambioTemaTT.setHorizontalAlignment(SwingConstants.CENTER);
		lblCambioTemaTT.setBounds(64, 40, 110, 31);
		pannelloTendina.add(lblCambioTemaTT);

		lblTendina = new JLabel("");
		lblTendina.setBounds(0, 0, 237, 642);
		lblTendina.setHorizontalAlignment(SwingConstants.CENTER);
		lblTendina.setIcon(new ImageIcon(img.tendina()));
		pannelloTendina.add(lblTendina);

		lblHomeTT = new JLabel("");
		lblHomeTT.setHorizontalAlignment(SwingConstants.CENTER);
		lblHomeTT.setBounds(10, 155, 65, 31);

		lblAccediTT = new JLabel("");
		lblAccediTT.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccediTT.setBounds(10, 225, 72, 31);

		lblRegistratiTT = new JLabel("");
		lblRegistratiTT.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistratiTT.setBounds(10, 295, 91, 31);

		lblProfiloTT = new JLabel("");
		lblProfiloTT.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfiloTT.setBounds(10, 365, 70, 31);

		lblImpostazioniTT = new JLabel("");
		lblImpostazioniTT.setHorizontalAlignment(SwingConstants.CENTER);
		lblImpostazioniTT.setBounds(10, 435, 110, 31);

		lblEsciTT = new JLabel("");
		lblEsciTT.setHorizontalAlignment(SwingConstants.CENTER);
		lblEsciTT.setBounds(10, 505, 54, 31);

		lblMenuTT = new JLabel("");
		lblMenuTT.setVisible(false);
		lblMenuTT.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuTT.setBounds(911, 11, 60, 31);
		
		pannelloErrore = new JPanel();
		pannelloErrore.setBackground(controllerDashboard.trasparente);
		pannelloErrore.setBounds(5, 0, 1078, 0);
		pannelloErrore.setLayout(null);
		
		lblMessaggioErroreTesto = new JLabel("");
		lblMessaggioErroreTesto.setForeground(controllerDashboard.coloreScrittaErrore);
		lblMessaggioErroreTesto.setFont(controllerDashboard.fontLabel);
		lblMessaggioErroreTesto.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessaggioErroreTesto.setText("Qualcosa è andato storto");
		lblMessaggioErroreTesto.setBounds(5, 0, 1078, 25);
		pannelloErrore.add(lblMessaggioErroreTesto);
		
		lblMessaggioErroreLayout = new JLabel("");
		lblMessaggioErroreLayout.setIcon(new ImageIcon(img.messaggioErroreGestioni()));
		lblMessaggioErroreLayout.setBounds(5, 0, 1078, 25);
		pannelloErrore.add(lblMessaggioErroreLayout);


		pannelloDestra = new JPanel();
		pannelloDestra.setBounds(50, 0, 1093, 642);
		pannelloDestra.setBackground(controllerDashboard.trasparente);

		pannelloDestra.add(lblHomeTT);
		pannelloDestra.add(lblHomeTT);
		pannelloDestra.add(lblAccediTT);
		pannelloDestra.add(lblRegistratiTT);
		pannelloDestra.add(lblProfiloTT);
		pannelloDestra.add(lblImpostazioniTT);
		pannelloDestra.add(lblEsciTT);
		pannelloDestra.add(lblMenuTT);
		
		pannelloDestra.add(pannelloErrore);
		pannelloDestra.add(home);
		pannelloDestra.add(accesso);
		pannelloDestra.add(cambioPassword);
		pannelloDestra.add(registrazione);
		pannelloDestra.add(profilo);
		pannelloDestra.add(impostazioni);
		pannelloDestra.add(gestioneUtenti);
		pannelloDestra.add(gestioneGate);
		pannelloDestra.add(utilizzoGate);
		pannelloDestra.add(gateCodeImbarco);
		pannelloDestra.add(gestioneCompagnieAeree);
		pannelloDestra.add(gestioneTratte);
		pannelloDestra.add(gestioneVoliPartenze);
		pannelloDestra.add(gestioneVoliArrivi);
		pannelloDestra.add(recensioni);
		pannelloDestra.add(menuInfoAccount);
		pannelloDestra.add(noClick);

		pannelloDestra.setLayout(null);
		pannelloBase.add(pannelloDestra);
		
		
		lblLayout = new JLabel("");
		lblLayout.setBounds(50, 0, 1093, 642);
		lblLayout.setHorizontalAlignment(SwingConstants.CENTER);
		lblLayout.setIcon(new ImageIcon(img.sfondo()));
		pannelloBase.add(lblLayout);

		controllerDashboard.centramentoJFrame(this);

		startVisibili();

	}

	// METODI DI START

	private void startVisibili() {
		home.setVisible(true);
		accesso.setVisible(false);
		registrazione.setVisible(false);
		profilo.setVisible(false);
		impostazioni.setVisible(false);
		gestioneUtenti.setVisible(false);
		gestioneCompagnieAeree.setVisible(false);
		gestioneGate.setVisible(false);
		gateCodeImbarco.setVisible(false);
		utilizzoGate.setVisible(false);
		gestioneTratte.setVisible(false);
		gestioneVoliPartenze.setVisible(false);
		gestioneVoliArrivi.setVisible(false);
		cambioPassword.setVisible(false);
		menuInfoAccount.setVisible(false);
		recensioni.setVisible(false);
		panelHome.setBackground(controllerDashboard.pannelloSceltoTemaScuro);

	}
}
