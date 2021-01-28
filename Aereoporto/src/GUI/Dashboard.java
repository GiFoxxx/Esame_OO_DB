package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;

import Controller.Controller;
import Immagini.Immagini;

import javax.swing.border.EmptyBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseMotionAdapter;

public class Dashboard extends JFrame {

	private Immagini img = new Immagini();

	int posizioneTendina = 238;
	int xMouse;
	int yMouse;
	int xMouseSuSchermo;
	int yMouseSuSchermo;
	int x;
	int y;
	
	private JPanel contentPane;

	private JLabel lblLinee1;
	private JLabel lblLinee2;
	private JPanel pannelloTendina;
	
	private JPanel home;
	private JPanel accesso;
	private JPanel registrazione;
	private JPanel gestioneUtenti;
	private JPanel gestioneCompagnieAeree;
	private JPanel gestioneVoli;
	private JPanel gestioneGate;
	private JPanel gestioneTratte;
	private JDialog uscita;

	// GETTER E SETTER
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

	public JPanel getGestioneVoli() {
		return gestioneVoli;
	}

	public void setGestioneVoli(JPanel gestioneVoli) {
		this.gestioneVoli = gestioneVoli;
	}

	public JPanel getGestioneTratte() {
		return gestioneTratte;
	}

	public void setGestioneTratte(JPanel gestioneTratte1) {
		this.gestioneTratte = gestioneTratte1;
	}

	public JDialog getUscita() {
		return uscita;
	}

	public void setUscita(JDialog uscita) {
		this.uscita = uscita;
	}

	Controller controllerDashboard;

	public Dashboard(Controller controller) {
		controllerDashboard = controller;

		home = controllerDashboard.home();
		accesso = controllerDashboard.accesso();
		registrazione = controllerDashboard.registrazione();
		gestioneUtenti = controllerDashboard.gestioneUtenti();
		gestioneCompagnieAeree = controllerDashboard.gestioneCompagnieAeree();
		gestioneGate = controllerDashboard.gestioneGate();
		gestioneTratte = controllerDashboard.gestioneTratte();
		gestioneVoli = controllerDashboard.gestioneVoli();
		uscita = controllerDashboard.uscita();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1143, 677);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setUndecorated(true);
		contentPane.setLayout(null);

		JPanel pannelloBase = new JPanel();
		pannelloBase.setBackground(new Color(0, 0, 0, 0));
		pannelloBase.setBounds(0, 0, 1143, 677);
		contentPane.add(pannelloBase);
		pannelloBase.setLayout(null);

		JLabel lblX = new JLabel("");
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
		});
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setIcon(new ImageIcon(img.X1()));
		lblX.setBounds(1105, 0, 37, 43);
		pannelloBase.add(lblX);

		JLabel lblMinimizza = new JLabel("");
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
		});
		lblMinimizza.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinimizza.setIcon(new ImageIcon(img.minimizza1()));
		lblMinimizza.setBounds(1069, 0, 37, 43);
		pannelloBase.add(lblMinimizza);

		JPanel pannelloDestra = new JPanel();
		pannelloDestra.setBounds(239, 43, 903, 646);
		pannelloDestra.setBackground(controllerDashboard.trasparente);

		pannelloBase.add(pannelloDestra);
		pannelloDestra.add(home);
		pannelloDestra.add(accesso);
		pannelloDestra.add(registrazione);
		pannelloDestra.add(gestioneUtenti);
		pannelloDestra.add(gestioneGate);
		pannelloDestra.add(gestioneCompagnieAeree);
		pannelloDestra.add(gestioneTratte);
		pannelloDestra.add(gestioneVoli);
		home.setVisible(true);
		accesso.setVisible(false);
		registrazione.setVisible(false);
		gestioneUtenti.setVisible(false);
		gestioneCompagnieAeree.setVisible(false);
		gestioneGate.setVisible(false);
		gestioneTratte.setVisible(false);
		gestioneVoli.setVisible(false);
		pannelloDestra.setLayout(null);

		JLabel lblTitolo = new JLabel("");
		lblTitolo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitolo.setIcon(new ImageIcon(img.titolo()));
		lblTitolo.setBounds(239, 1, 277, 49);
		pannelloBase.add(lblTitolo);

		pannelloTendina = new JPanel();
		pannelloTendina.setBackground(new Color(0, 0, 0, 0));
		pannelloTendina.setBounds(0, 0, 238, 677);
		pannelloTendina.setLayout(null);
		pannelloBase.add(pannelloTendina);

		JPanel panelHome = new JPanel();
		panelHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				controllerDashboard.mostraPannelli(home);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				panelHome.setBackground(controllerDashboard.entroPannello);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelHome.setBackground(controllerDashboard.escoPannelloLaterale);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				panelHome.setBackground(controllerDashboard.clickPannello);
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

		JLabel lblScrittaHome = new JLabel("HOME");
		lblScrittaHome.setBounds(56, 0, 180, 70);
		lblScrittaHome.setFont(controllerDashboard.fontScritte);
		lblScrittaHome.setForeground(Color.WHITE);
		lblScrittaHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblScrittaHome.setHorizontalAlignment(SwingConstants.CENTER);
		panelHome.add(lblScrittaHome);

		JLabel lblHome = new JLabel("");
		lblHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblHome.setBounds(0, 0, 46, 70);
		lblHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblHome.setIcon(new ImageIcon(img.casa()));
		panelHome.add(lblHome);

		JPanel panelAccedi = new JPanel();
		panelAccedi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerDashboard.mostraPannelli(accesso);
				controllerDashboard.svuotaCampiAccesso();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				panelAccedi.setBackground(controllerDashboard.entroPannello);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelAccedi.setBackground(controllerDashboard.escoPannelloLaterale);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				panelAccedi.setBackground(controllerDashboard.clickPannello);
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

		JLabel lblScrittaAccesso = new JLabel("ACCEDI");
		lblScrittaAccesso.setBounds(56, 0, 180, 70);
		lblScrittaAccesso.setFont(controllerDashboard.fontScritte);
		lblScrittaAccesso.setForeground(Color.WHITE);
		lblScrittaAccesso.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblScrittaAccesso.setHorizontalAlignment(SwingConstants.CENTER);
		panelAccedi.add(lblScrittaAccesso);

		JLabel lblAccesso = new JLabel("");
		lblAccesso.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAccesso.setBounds(0, 0, 46, 70);
		panelAccedi.add(lblAccesso);
		lblAccesso.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccesso.setIcon(new ImageIcon(img.accedi()));

		JPanel panelRegistrati = new JPanel();
		panelRegistrati.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelRegistrati.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerDashboard.mostraPannelli(registrazione);
				controllerDashboard.svuotaCampiRegistrazione();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				panelRegistrati.setBackground(controllerDashboard.entroPannello);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelRegistrati.setBackground(controllerDashboard.escoPannelloLaterale);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				panelRegistrati.setBackground(controllerDashboard.clickPannello);
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

		JLabel lblScrittaRegistrazione = new JLabel("REGISTRATI");
		lblScrittaRegistrazione.setBounds(56, 0, 180, 70);
		lblScrittaRegistrazione.setFont(controllerDashboard.fontScritte);
		lblScrittaRegistrazione.setForeground(Color.WHITE);
		lblScrittaRegistrazione.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblScrittaRegistrazione.setHorizontalAlignment(SwingConstants.CENTER);
		panelRegistrati.add(lblScrittaRegistrazione);

		JLabel lblRegistrazione = new JLabel("");
		lblRegistrazione.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblRegistrazione.setBounds(0, 0, 46, 70);
		panelRegistrati.add(lblRegistrazione);
		lblRegistrazione.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrazione.setIcon(new ImageIcon(img.registrati()));

		JPanel panelProfilo = new JPanel();
		panelProfilo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelProfilo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				panelProfilo.setBackground(controllerDashboard.entroPannello);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelProfilo.setBackground(controllerDashboard.escoPannelloLaterale);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				panelProfilo.setBackground(controllerDashboard.clickPannello);
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

		JLabel lblScrittaProfilo = new JLabel("PROFILO");
		lblScrittaProfilo.setBounds(56, 0, 180, 70);
		panelProfilo.add(lblScrittaProfilo);
		lblScrittaProfilo.setFont(controllerDashboard.fontScritte);
		lblScrittaProfilo.setForeground(Color.WHITE);
		lblScrittaProfilo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblScrittaProfilo.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblProfilo = new JLabel("");
		lblProfilo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblProfilo.setBounds(0, 0, 46, 70);
		panelProfilo.add(lblProfilo);
		lblProfilo.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfilo.setIcon(new ImageIcon(img.profilo()));

		JPanel panelImpostazioni = new JPanel();
		panelImpostazioni.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelImpostazioni.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				panelImpostazioni.setBackground(controllerDashboard.entroPannello);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelImpostazioni.setBackground(controllerDashboard.escoPannelloLaterale);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				panelImpostazioni.setBackground(controllerDashboard.clickPannello);
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

		JLabel lblImpostazioni = new JLabel("IMPOSTAZIONI");
		lblImpostazioni.setBounds(56, 0, 180, 70);
		lblImpostazioni.setFont(controllerDashboard.fontScritte);
		lblImpostazioni.setForeground(Color.WHITE);
		lblImpostazioni.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblImpostazioni.setHorizontalAlignment(SwingConstants.CENTER);
		panelImpostazioni.add(lblImpostazioni);

		JLabel lbllblImpostazioni = new JLabel("");
		lbllblImpostazioni.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbllblImpostazioni.setBounds(0, 0, 46, 70);
		panelImpostazioni.add(lbllblImpostazioni);
		lbllblImpostazioni.setHorizontalAlignment(SwingConstants.CENTER);
		lbllblImpostazioni.setIcon(new ImageIcon(img.impostazioni()));

		JPanel panelUscita = new JPanel();
		panelUscita.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelUscita.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerDashboard.mostraUscita();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				panelUscita.setBackground(controllerDashboard.entroPannello);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelUscita.setBackground(controllerDashboard.escoPannelloLaterale);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				panelUscita.setBackground(controllerDashboard.clickPannello);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				panelUscita.setBackground(controllerDashboard.entroPannello);
			}
		});
		panelUscita.setBounds(1, 485, 236, 70);
		panelUscita.setBackground(new Color(0, 0, 0, 0));
		pannelloTendina.add(panelUscita);
		panelUscita.setLayout(null);

		JLabel lblScrittaEsci = new JLabel("ESCI");
		lblScrittaEsci.setBounds(56, 0, 180, 70);
		lblScrittaEsci.setFont(controllerDashboard.fontScritte);
		lblScrittaEsci.setForeground(Color.WHITE);
		lblScrittaEsci.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblScrittaEsci.setHorizontalAlignment(SwingConstants.CENTER);
		panelUscita.add(lblScrittaEsci);

		JLabel lblEsci = new JLabel("");
		lblEsci.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblEsci.setBounds(0, 0, 46, 70);
		lblEsci.setHorizontalAlignment(SwingConstants.CENTER);
		lblEsci.setIcon(new ImageIcon(img.esci()));
		panelUscita.add(lblEsci);

		lblLinee1 = new JLabel("");
		lblLinee2 = new JLabel("");
		lblLinee2.setVisible(false);
		lblLinee1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				chiudiTendina();
			}
		});
		lblLinee1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblLinee1.setHorizontalAlignment(SwingConstants.CENTER);
		lblLinee1.setIcon(new ImageIcon(img.linee1()));
		lblLinee1.setBounds(188, 49, 46, 70);
		pannelloTendina.add(lblLinee1);

		lblLinee2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				apriTendina();
			}
		});
		lblLinee2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblLinee2.setBounds(1, 49, 46, 70);
		pannelloTendina.add(lblLinee2);
		lblLinee2.setHorizontalAlignment(SwingConstants.CENTER);
		lblLinee2.setIcon(new ImageIcon(img.linee2()));

		JLabel lblTendina = new JLabel("");
		lblTendina.setBounds(0, 0, 238, 677);
		lblTendina.setHorizontalAlignment(SwingConstants.CENTER);
		lblTendina.setIcon(new ImageIcon(img.tendina()));
		pannelloTendina.add(lblTendina);

		JLabel lblLayout = new JLabel("");
		lblLayout.setBounds(0, 0, 1143, 677);
		lblLayout.setHorizontalAlignment(SwingConstants.CENTER);
		lblLayout.setIcon(new ImageIcon(img.sfondo()));
		pannelloBase.add(lblLayout);

		JLabel lblSpostaDaashboard = new JLabel("");
		lblSpostaDaashboard.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent spostaDashboard) {
				x = spostaDashboard.getXOnScreen();
				y = spostaDashboard.getYOnScreen();
				xMouseSuSchermo = spostaDashboard.getXOnScreen();
				yMouseSuSchermo = spostaDashboard.getYOnScreen();
				setLocation(x - xMouse, y - yMouse);

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

				if (yMouseSuSchermo < 2) {
					contentPane.setSize(controllerDashboard.dimensioneSchermoX(),
							controllerDashboard.dimensioneSchermoY());
					pannelloBase.setSize(controllerDashboard.dimensioneSchermoX(),
							controllerDashboard.dimensioneSchermoY());
					pannelloDestra.setSize(controllerDashboard.dimensioneSchermoX(),
							controllerDashboard.dimensioneSchermoY());
					lblLayout.setIcon(new ImageIcon(img.imgSfondoFull()));

					setExtendedState(Dashboard.MAXIMIZED_BOTH);
				}
			}
		});
		lblSpostaDaashboard.setEnabled(false);
		lblSpostaDaashboard.setBounds(0, 0, 1142, 43);
		pannelloBase.add(lblSpostaDaashboard);

		
		controllerDashboard.centramentoJFrame(this);

	}

	//METODI
	
	

	
	public void apriTendina() {
		lblLinee2.setVisible(false);
		if (posizioneTendina == 50) {
			pannelloTendina.show();
			pannelloTendina.setSize(posizioneTendina, 677);
			Thread th = new Thread() {
				@Override
				public void run() {
					try {
						for (int i = 50; i <= posizioneTendina; i++) {
							Thread.sleep(0, 1);
							pannelloTendina.setSize(i, 677);
						}
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, e);
					}
					lblLinee1.setVisible(true);
				}
			};
			th.start();
			posizioneTendina = 238;
		}
	}
	
	public void chiudiTendina() {
		lblLinee1.setVisible(false);
		if (posizioneTendina == 238) {
			pannelloTendina.setSize(50, 677);
			Thread th = new Thread() {
				@Override
				public void run() {
					try {
						for (int i = 238; i >= 50; i--) {
							Thread.sleep(0, 1);
							pannelloTendina.setSize(i, 677);
						}
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, e);
					}
					lblLinee2.setVisible(true);
				}
			};
			th.start();
			posizioneTendina = 50;
		}
	}

}
