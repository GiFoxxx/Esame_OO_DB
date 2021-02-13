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
	int xMouse;
	int yMouse;
	int xMouseSuSchermo;
	int yMouseSuSchermo;
	int x;
	int y;

	private JPanel contentPane;

	private JLabel lblX;
	private JLabel lineeChiusura;
	private JLabel lineeApertura;
	private JLabel lblMinimizza;
	private JLabel lblSpostaDaashboard;
	private JLabel lblTitolo;
	private JLabel lblScrittaHome;
	private JLabel lblHome;
	private JLabel lblScrittaAccesso;
	private JLabel lblAccesso;
	private JLabel lblScrittaRegistrazione;
	private JLabel lblRegistrazione;
	private JLabel lblScrittaProfilo;
	private JLabel lblProfilo;
	private JLabel lblImpostazioni;
	private JLabel lbllblImpostazioni;
	private JLabel lblScrittaEsci;
	private JLabel lblEsci;
	private JLabel lblTendina;
	private JLabel lblLayout;

	private JPanel pannelloTendina;
	private JPanel pannelloBase;
	private JPanel pannelloDestra;
	private JPanel noClickDestra;
	private JPanel panelHome;
	private JPanel panelAccedi;
	private JPanel panelRegistrati;
	private JPanel panelProfilo;
	private JPanel panelImpostazioni;
	private JPanel panelUscita;

	private JPanel prenotazioniFalsa;

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
	private JPanel gestioneTratte;
	private JPanel recensioni;
	private JPanel cambioPassword;

	private JDialog jDialogProfilo;
	private JDialog PasswordDimenticata;
	private JDialog sceltaVolo;
	private JDialog uscita;

	// GETTER E SETTER
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

	public JPanel getRecensione() {
		return recensioni;
	}

	public void setRecensione(JPanel recensioni) {
		this.recensioni = recensioni;
	}

	public JDialog getUscita() {
		return uscita;
	}

	public void setUscita(JDialog uscita) {
		this.uscita = uscita;
	}

	public JDialog getJDialogProfilo() {
		return jDialogProfilo;
	}

	public void setJDialogProfilo(JDialog jDialogProfilo) {
		this.jDialogProfilo = jDialogProfilo;
	}

	public JDialog getPasswordDimenticata() {
		return PasswordDimenticata;
	}

	public void setPasswordDimenticata(JDialog passwordDimenticata) {
		PasswordDimenticata = passwordDimenticata;
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

	public JPanel getNoClickDestra() {
		return noClickDestra;
	}

	public void setNoClickDestra(JPanel noClickDestra) {
		this.noClickDestra = noClickDestra;
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

	public JPanel getPrenotazioniFalsa() {
		return prenotazioniFalsa;
	}

	public void setPrenotazioniFalsa(JPanel prenotazioniFalsa) {
		this.prenotazioniFalsa = prenotazioniFalsa;
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
		gestioneTratte = controllerDashboard.gestioneTratte();
		gestioneVoliPartenze = controllerDashboard.gestioneVoliPartenze();
		gestioneVoliArrivi = controllerDashboard.gestioneVoliArrivi();
		jDialogProfilo = controllerDashboard.jdialogProfilo();
		PasswordDimenticata = controllerDashboard.passwordDimenticata();
		sceltaVolo = controllerDashboard.sceltaVolo();
		recensioni = controllerDashboard.recensione();
		uscita = controllerDashboard.uscita();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1143, 677);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setUndecorated(true);
		contentPane.setLayout(null);

		lblTitolo = new JLabel("AIRPORT MANAGEMENT");
		lblTitolo.setBounds(0, 0, 238, 37);
		lblTitolo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitolo.setForeground(controllerDashboard.coloreScritte);
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
				lblX.setIcon(new ImageIcon(img.X2()));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblX.setIcon(new ImageIcon(img.X1()));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				lblX.setIcon(new ImageIcon(img.X3()));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				lblX.setIcon(new ImageIcon(img.X1()));
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
				lblMinimizza.setIcon(new ImageIcon(img.minimizza2()));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblMinimizza.setIcon(new ImageIcon(img.minimizza1()));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				lblMinimizza.setIcon(new ImageIcon(img.minimizza3()));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				lblMinimizza.setIcon(new ImageIcon(img.minimizza1()));
			}
		});

		lblMinimizza.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinimizza.setIcon(new ImageIcon(img.minimizza1()));
		lblMinimizza.setBounds(1040, 0, 51, 35);
		contentPane.add(lblMinimizza);

		lblSpostaDaashboard = new JLabel("");
		lblSpostaDaashboard.addMouseMotionListener(new MouseMotionAdapter() {
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
		lblSpostaDaashboard.addMouseListener(new MouseAdapter() {
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
		lblSpostaDaashboard.setIcon(new ImageIcon(img.spostaDashboard()));
		lblSpostaDaashboard.setBounds(0, 0, 1143, 35);
		contentPane.add(lblSpostaDaashboard);

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
				pannelloLateraleSelezionato();
				controllerDashboard.mostraPannelli(home);
				if (home.isVisible()) {
					panelHome.setBackground(controllerDashboard.pannelloScelto);
				}
				controllerDashboard.chiudiTendinaIstantanea();

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				panelHome.setBackground(controllerDashboard.entroPannello);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (home.isVisible()) {
					panelHome.setBackground(controllerDashboard.pannelloScelto);
				} else {
					panelHome.setBackground(controllerDashboard.escoPannello);
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (home.isVisible()) {
					panelHome.setBackground(controllerDashboard.pannelloScelto);
				} else {
					panelHome.setBackground(controllerDashboard.clickPannello);
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				panelHome.setBackground(controllerDashboard.entroPannello);
			}
		});
		panelHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelHome.setBounds(1, 135, 236, 70);
		panelHome.setBackground(new Color(0, 0, 0, 0));
		panelHome.setLayout(null);
		pannelloTendina.add(panelHome);

		lblScrittaHome = new JLabel("HOME");
		lblScrittaHome.setBounds(56, 0, 180, 70);
		lblScrittaHome.setFont(controllerDashboard.fontScritte);
		lblScrittaHome.setForeground(Color.WHITE);
		lblScrittaHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblScrittaHome.setHorizontalAlignment(SwingConstants.CENTER);
		panelHome.add(lblScrittaHome);

		lblHome = new JLabel("");
		lblHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblHome.setBounds(0, 0, 50, 70);
		lblHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblHome.setIcon(new ImageIcon(img.casa()));
		panelHome.add(lblHome);

		panelAccedi = new JPanel();
		panelAccedi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pannelloLateraleSelezionato();
				controllerDashboard.mostraPannelli(accesso);
				if (accesso.isVisible()) {
					panelAccedi.setBackground(controllerDashboard.pannelloScelto);
				} else {
					controllerDashboard.chiudiTendinaIstantanea();
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				if (accesso.isVisible()) {
					panelAccedi.setBackground(controllerDashboard.pannelloScelto);
				} else {
					panelAccedi.setBackground(controllerDashboard.entroPannello);
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (accesso.isVisible()) {
					panelAccedi.setBackground(controllerDashboard.pannelloScelto);
				} else {
					panelAccedi.setBackground(controllerDashboard.escoPannello);
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (accesso.isVisible()) {
					panelAccedi.setBackground(controllerDashboard.pannelloScelto);
				} else {
					panelAccedi.setBackground(controllerDashboard.clickPannello);
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				panelAccedi.setBackground(controllerDashboard.entroPannello);
			}
		});
		panelAccedi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelAccedi.setBounds(1, 205, 236, 70);
		panelAccedi.setBackground(new Color(0, 0, 0, 0));
		pannelloTendina.add(panelAccedi);
		panelAccedi.setLayout(null);

		lblScrittaAccesso = new JLabel("ACCEDI");
		lblScrittaAccesso.setBounds(56, 0, 180, 70);
		lblScrittaAccesso.setFont(controllerDashboard.fontScritte);
		lblScrittaAccesso.setForeground(Color.WHITE);
		lblScrittaAccesso.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblScrittaAccesso.setHorizontalAlignment(SwingConstants.CENTER);
		panelAccedi.add(lblScrittaAccesso);

		lblAccesso = new JLabel("");
		lblAccesso.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAccesso.setBounds(0, 0, 50, 70);
		panelAccedi.add(lblAccesso);
		lblAccesso.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccesso.setIcon(new ImageIcon(img.accedi()));

		panelRegistrati = new JPanel();
		panelRegistrati.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelRegistrati.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pannelloLateraleSelezionato();
				controllerDashboard.mostraPannelli(registrazione);
				if (registrazione.isVisible()) {
					panelRegistrati.setBackground(controllerDashboard.pannelloScelto);
				}
				controllerDashboard.chiudiTendinaIstantanea();

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				panelRegistrati.setBackground(controllerDashboard.entroPannello);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (registrazione.isVisible()) {
					panelRegistrati.setBackground(controllerDashboard.pannelloScelto);
				} else {
					panelRegistrati.setBackground(controllerDashboard.escoPannello);
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (registrazione.isVisible()) {
					panelRegistrati.setBackground(controllerDashboard.pannelloScelto);
				} else {
					panelRegistrati.setBackground(controllerDashboard.clickPannello);
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				panelRegistrati.setBackground(controllerDashboard.entroPannello);
			}
		});
		panelRegistrati.setBounds(1, 275, 236, 70);
		panelRegistrati.setBackground(controllerDashboard.trasparente);
		pannelloTendina.add(panelRegistrati);
		panelRegistrati.setLayout(null);

		lblScrittaRegistrazione = new JLabel("REGISTRATI");
		lblScrittaRegistrazione.setBounds(56, 0, 180, 70);
		lblScrittaRegistrazione.setFont(controllerDashboard.fontScritte);
		lblScrittaRegistrazione.setForeground(Color.WHITE);
		lblScrittaRegistrazione.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblScrittaRegistrazione.setHorizontalAlignment(SwingConstants.CENTER);
		panelRegistrati.add(lblScrittaRegistrazione);

		lblRegistrazione = new JLabel("");
		lblRegistrazione.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblRegistrazione.setBounds(0, 0, 50, 70);
		panelRegistrati.add(lblRegistrazione);
		lblRegistrazione.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrazione.setIcon(new ImageIcon(img.registrati()));

		panelProfilo = new JPanel();
		panelProfilo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelProfilo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pannelloLateraleSelezionato();
				if (controllerDashboard.sbloccaGestione()) {
					controllerDashboard.mostraPannelli(profilo);
					if (profilo.isVisible() || jDialogProfilo.isVisible()) {
						panelProfilo.setBackground(controllerDashboard.pannelloScelto);
					}
					controllerDashboard.chiudiTendinaIstantanea();
				} else {
					controllerDashboard.mostraJDialogProfilo();
				}
				if (profilo.isVisible() || jDialogProfilo.isVisible()) {
					panelProfilo.setBackground(controllerDashboard.pannelloScelto);
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				panelProfilo.setBackground(controllerDashboard.entroPannello);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (profilo.isVisible() || jDialogProfilo.isVisible()) {
					panelProfilo.setBackground(controllerDashboard.pannelloScelto);
				} else {
					panelProfilo.setBackground(controllerDashboard.escoPannello);
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (profilo.isVisible()) {
					panelProfilo.setBackground(controllerDashboard.pannelloScelto);
				} else {
					panelProfilo.setBackground(controllerDashboard.clickPannello);
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				panelProfilo.setBackground(controllerDashboard.entroPannello);
			}
		});
		panelProfilo.setBounds(1, 345, 236, 70);
		panelProfilo.setBackground(controllerDashboard.trasparente);
		panelProfilo.setLayout(null);
		pannelloTendina.add(panelProfilo);

		lblScrittaProfilo = new JLabel("PROFILO");
		lblScrittaProfilo.setBounds(56, 0, 180, 70);
		panelProfilo.add(lblScrittaProfilo);
		lblScrittaProfilo.setFont(controllerDashboard.fontScritte);
		lblScrittaProfilo.setForeground(Color.WHITE);
		lblScrittaProfilo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblScrittaProfilo.setHorizontalAlignment(SwingConstants.CENTER);

		lblProfilo = new JLabel("");
		lblProfilo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblProfilo.setBounds(0, 0, 50, 70);
		panelProfilo.add(lblProfilo);
		lblProfilo.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfilo.setIcon(new ImageIcon(img.profilo()));

		panelImpostazioni = new JPanel();
		panelImpostazioni.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelImpostazioni.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pannelloLateraleSelezionato();
				controllerDashboard.mostraPannelli(impostazioni);
				if (impostazioni.isVisible()) {
					panelImpostazioni.setBackground(controllerDashboard.pannelloScelto);
				}
				controllerDashboard.chiudiTendinaIstantanea();

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				panelImpostazioni.setBackground(controllerDashboard.entroPannello);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (impostazioni.isVisible()) {
					panelImpostazioni.setBackground(controllerDashboard.pannelloScelto);
				} else {
					panelImpostazioni.setBackground(controllerDashboard.escoPannello);
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (impostazioni.isVisible()) {
					panelImpostazioni.setBackground(controllerDashboard.pannelloScelto);
				} else {
					panelImpostazioni.setBackground(controllerDashboard.clickPannello);
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				panelImpostazioni.setBackground(controllerDashboard.entroPannello);
			}
		});
		panelImpostazioni.setBounds(1, 415, 236, 70);
		panelImpostazioni.setBackground(new Color(0, 0, 0, 0));
		pannelloTendina.add(panelImpostazioni);
		panelImpostazioni.setLayout(null);

		lblImpostazioni = new JLabel("IMPOSTAZIONI");
		lblImpostazioni.setBounds(56, 0, 180, 70);
		lblImpostazioni.setFont(controllerDashboard.fontScritte);
		lblImpostazioni.setForeground(Color.WHITE);
		lblImpostazioni.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblImpostazioni.setHorizontalAlignment(SwingConstants.CENTER);
		panelImpostazioni.add(lblImpostazioni);

		lbllblImpostazioni = new JLabel("");
		lbllblImpostazioni.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbllblImpostazioni.setBounds(0, 0, 50, 70);
		panelImpostazioni.add(lbllblImpostazioni);
		lbllblImpostazioni.setHorizontalAlignment(SwingConstants.CENTER);
		lbllblImpostazioni.setIcon(new ImageIcon(img.impostazioni()));

		panelUscita = new JPanel();
		panelUscita.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelUscita.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pannelloLateraleSelezionato();
				controllerDashboard.mostraUscita();
				if (uscita.isVisible()) {
					panelUscita.setBackground(controllerDashboard.pannelloScelto);
				}
				controllerDashboard.chiudiTendinaIstantanea();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				panelUscita.setBackground(controllerDashboard.entroPannello);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (uscita.isVisible()) {
					panelUscita.setBackground(controllerDashboard.pannelloScelto);
				} else {
					panelUscita.setBackground(controllerDashboard.escoPannello);
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (uscita.isVisible()) {
					panelUscita.setBackground(controllerDashboard.pannelloScelto);
				} else {
					panelUscita.setBackground(controllerDashboard.clickPannello);
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				panelUscita.setBackground(controllerDashboard.entroPannello);
			}
		});
		panelUscita.setBounds(1, 485, 236, 70);
		panelUscita.setBackground(controllerDashboard.trasparente);
		pannelloTendina.add(panelUscita);
		panelUscita.setLayout(null);

		lblScrittaEsci = new JLabel("ESCI");
		lblScrittaEsci.setBounds(56, 0, 180, 70);
		lblScrittaEsci.setFont(controllerDashboard.fontScritte);
		lblScrittaEsci.setForeground(Color.WHITE);
		lblScrittaEsci.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblScrittaEsci.setHorizontalAlignment(SwingConstants.CENTER);
		panelUscita.add(lblScrittaEsci);

		lblEsci = new JLabel("");
		lblEsci.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
		});
		lineeChiusura.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lineeChiusura.setHorizontalAlignment(SwingConstants.CENTER);
		lineeChiusura.setIcon(new ImageIcon(img.lineeChiusura()));
		lineeChiusura.setBounds(182, 20, 50, 70);
		pannelloTendina.add(lineeChiusura);

		lineeApertura.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerDashboard.apriTendina();

				controllerDashboard.mostraPannelloNoClick();
			}
		});
		lineeApertura.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lineeApertura.setBounds(1, 20, 50, 70);
		pannelloTendina.add(lineeApertura);
		lineeApertura.setHorizontalAlignment(SwingConstants.CENTER);
		lineeApertura.setIcon(new ImageIcon(img.lineeApertura()));

		lblTendina = new JLabel("");
		lblTendina.setBounds(0, 0, 237, 642);
		lblTendina.setHorizontalAlignment(SwingConstants.CENTER);
		lblTendina.setIcon(new ImageIcon(img.tendina()));
		pannelloTendina.add(lblTendina);

		pannelloDestra = new JPanel();
		pannelloDestra.setBounds(51, 0, 1090, 642);
		pannelloDestra.setBackground(controllerDashboard.trasparente);

		pannelloDestra.add(home);
		pannelloDestra.add(accesso);
		pannelloDestra.add(cambioPassword);
		pannelloDestra.add(registrazione);
		pannelloDestra.add(profilo);
		pannelloDestra.add(impostazioni);
		pannelloDestra.add(gestioneUtenti);
		pannelloDestra.add(gestioneGate);
		pannelloDestra.add(gestioneCompagnieAeree);
		pannelloDestra.add(gestioneTratte);
		pannelloDestra.add(gestioneVoliPartenze);
		pannelloDestra.add(gestioneVoliArrivi);
		pannelloDestra.add(recensioni);
		startVisibili();

		pannelloDestra.setLayout(null);
		pannelloBase.add(pannelloDestra);

		noClickDestra = new JPanel();
		noClickDestra.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerDashboard.chiudiTendinaIstantanea();
				controllerDashboard.mostraNoClick();
			}
		});
		noClickDestra.setBounds(238, 0, 852, 642);
		noClickDestra.setBackground(controllerDashboard.trasparente);
		pannelloDestra.add(noClickDestra);

		lblLayout = new JLabel("");
		lblLayout.setBounds(50, 0, 1093, 642);
		lblLayout.setHorizontalAlignment(SwingConstants.CENTER);
		lblLayout.setIcon(new ImageIcon(img.sfondo()));
		pannelloBase.add(lblLayout);

		controllerDashboard.centramentoJFrame(this);

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
		gestioneTratte.setVisible(false);
		gestioneVoliPartenze.setVisible(false);
		gestioneVoliArrivi.setVisible(false);
		cambioPassword.setVisible(false);
		recensioni.setVisible(false);
		panelHome.setBackground(controllerDashboard.pannelloScelto);
	}

	private void pannelloLateraleSelezionato() {
		panelHome.setBackground(controllerDashboard.escoPannello);
		panelAccedi.setBackground(controllerDashboard.escoPannello);
		panelRegistrati.setBackground(controllerDashboard.escoPannello);
		panelProfilo.setBackground(controllerDashboard.escoPannello);
		panelImpostazioni.setBackground(controllerDashboard.escoPannello);
		panelUscita.setBackground(controllerDashboard.escoPannello);
	}
}
