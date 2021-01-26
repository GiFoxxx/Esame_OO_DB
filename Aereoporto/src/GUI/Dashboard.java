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

	Color sfondo = new Color(54, 57, 63);
	Color scritte = new Color(141, 142, 146);
	Color clickPannello = new Color(40, 40, 40);
	Color entroPannello = new Color(30, 30, 30);
	Color escoPannelloLaterale = new Color(35, 39, 42);
	Color trasparente = new Color(0, 0, 0, 0);

	int posizioneTendina = 238;
	int xMouse;
	int yMouse;
	int xMouseSuSchermo;
	int yMouseSuSchermo;
	int x;
	int y;

	private JPanel contentPane;

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
		lblX.setBounds(1096, 0, 37, 43);
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
		pannelloDestra.setBounds(239, 54, 903, 635);
		pannelloDestra.setBackground(trasparente);

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

		JPanel pannelloTendina = new JPanel();
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
				panelHome.setBackground(entroPannello);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelHome.setBackground(escoPannelloLaterale);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				panelHome.setBackground(clickPannello);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				panelHome.setBackground(entroPannello);
			}
		});
		panelHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelHome.setBounds(1, 135, 236, 70);
		panelHome.setBackground(new Color(0, 0, 0, 0));
		panelHome.setLayout(null);
		pannelloTendina.add(panelHome);

		JLabel lblScrittaHome = new JLabel("HOME");
		lblScrittaHome.setBounds(56, 0, 180, 70);
		lblScrittaHome.setFont(new Font("Arial", Font.BOLD, 15));
		lblScrittaHome.setForeground(Color.WHITE);
		lblScrittaHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblScrittaHome.setHorizontalAlignment(SwingConstants.CENTER);
		panelHome.add(lblScrittaHome);

		JLabel lblHome = new JLabel("");
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
				panelAccedi.setBackground(entroPannello);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelAccedi.setBackground(escoPannelloLaterale);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				panelAccedi.setBackground(clickPannello);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				panelAccedi.setBackground(entroPannello);
			}
		});
		panelAccedi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelAccedi.setBounds(1, 205, 236, 70);
		panelAccedi.setBackground(new Color(0, 0, 0, 0));
		pannelloTendina.add(panelAccedi);
		panelAccedi.setLayout(null);

		JLabel lblScrittaAccesso = new JLabel("ACCEDI");
		lblScrittaAccesso.setBounds(56, 0, 180, 70);
		lblScrittaAccesso.setFont(new Font("Arial", Font.BOLD, 15));
		lblScrittaAccesso.setForeground(Color.WHITE);
		lblScrittaAccesso.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblScrittaAccesso.setHorizontalAlignment(SwingConstants.CENTER);
		panelAccedi.add(lblScrittaAccesso);

		JLabel lblAccesso = new JLabel("");
		lblAccesso.setBounds(0, 0, 46, 70);
		panelAccedi.add(lblAccesso);
		lblAccesso.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccesso.setIcon(new ImageIcon(img.accedi()));

		JPanel panelRegistrati = new JPanel();
		panelRegistrati.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerDashboard.mostraPannelli(registrazione);
				controllerDashboard.svuotaCampiRegistrazione();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				panelRegistrati.setBackground(entroPannello);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelRegistrati.setBackground(escoPannelloLaterale);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				panelRegistrati.setBackground(clickPannello);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				panelRegistrati.setBackground(entroPannello);
			}
		});
		panelRegistrati.setBounds(1, 275, 236, 70);
		panelRegistrati.setBackground(new Color(0, 0, 0, 0));
		pannelloTendina.add(panelRegistrati);
		panelRegistrati.setLayout(null);

		JLabel lblScrittaRegistrazione = new JLabel("REGISTRATI");
		lblScrittaRegistrazione.setBounds(56, 0, 180, 70);
		lblScrittaRegistrazione.setFont(new Font("Arial", Font.BOLD, 15));
		lblScrittaRegistrazione.setForeground(Color.WHITE);
		lblScrittaRegistrazione.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblScrittaRegistrazione.setHorizontalAlignment(SwingConstants.CENTER);
		panelRegistrati.add(lblScrittaRegistrazione);

		JLabel lblRegistrazione = new JLabel("");
		lblRegistrazione.setBounds(0, 0, 46, 70);
		panelRegistrati.add(lblRegistrazione);
		lblRegistrazione.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrazione.setIcon(new ImageIcon(img.registrati()));

		JPanel panelProfilo = new JPanel();
		panelProfilo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				panelProfilo.setBackground(entroPannello);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelProfilo.setBackground(escoPannelloLaterale);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				panelProfilo.setBackground(clickPannello);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				panelProfilo.setBackground(entroPannello);
			}
		});
		panelProfilo.setBounds(1, 345, 236, 70);
		panelProfilo.setBackground(new Color(0, 0, 0, 0));
		panelProfilo.setLayout(null);
		pannelloTendina.add(panelProfilo);

		JLabel lblScrittaProfilo = new JLabel("PROFILO");
		lblScrittaProfilo.setBounds(56, 0, 180, 70);
		panelProfilo.add(lblScrittaProfilo);
		lblScrittaProfilo.setFont(new Font("Arial", Font.BOLD, 15));
		lblScrittaProfilo.setForeground(Color.WHITE);
		lblScrittaProfilo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblScrittaProfilo.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblProfilo = new JLabel("");
		lblProfilo.setBounds(0, 0, 46, 70);
		panelProfilo.add(lblProfilo);
		lblProfilo.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfilo.setIcon(new ImageIcon(img.profilo()));

		JPanel panelImpostazioni = new JPanel();
		panelImpostazioni.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				panelImpostazioni.setBackground(entroPannello);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelImpostazioni.setBackground(escoPannelloLaterale);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				panelImpostazioni.setBackground(clickPannello);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				panelImpostazioni.setBackground(entroPannello);
			}
		});
		panelImpostazioni.setBounds(1, 415, 236, 70);
		panelImpostazioni.setBackground(new Color(0, 0, 0, 0));
		pannelloTendina.add(panelImpostazioni);
		panelImpostazioni.setLayout(null);

		JLabel lblImpostazioni = new JLabel("IMPOSTAZIONI");
		lblImpostazioni.setBounds(56, 0, 180, 70);
		lblImpostazioni.setFont(new Font("Arial", Font.BOLD, 15));
		lblImpostazioni.setForeground(Color.WHITE);
		lblImpostazioni.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblImpostazioni.setHorizontalAlignment(SwingConstants.CENTER);
		panelImpostazioni.add(lblImpostazioni);

		JLabel lbllblImpostazioni = new JLabel("");
		lbllblImpostazioni.setBounds(0, 0, 46, 70);
		panelImpostazioni.add(lbllblImpostazioni);
		lbllblImpostazioni.setHorizontalAlignment(SwingConstants.CENTER);
		lbllblImpostazioni.setIcon(new ImageIcon(img.impostazioni()));

		JPanel panelUscita = new JPanel();
		panelUscita.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerDashboard.mostraUscita();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				panelUscita.setBackground(entroPannello);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelUscita.setBackground(escoPannelloLaterale);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				panelUscita.setBackground(clickPannello);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				panelUscita.setBackground(entroPannello);
			}
		});
		panelUscita.setBounds(1, 485, 236, 70);
		panelUscita.setBackground(new Color(0, 0, 0, 0));
		pannelloTendina.add(panelUscita);
		panelUscita.setLayout(null);

		JLabel lblScrittaEsci = new JLabel("ESCI");
		lblScrittaEsci.setBounds(56, 0, 180, 70);
		lblScrittaEsci.setFont(new Font("Arial", Font.BOLD, 15));
		lblScrittaEsci.setForeground(Color.WHITE);
		lblScrittaEsci.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblScrittaEsci.setHorizontalAlignment(SwingConstants.CENTER);
		panelUscita.add(lblScrittaEsci);

		JLabel lblEsci = new JLabel("");
		lblEsci.setBounds(0, 0, 46, 70);
		lblEsci.setHorizontalAlignment(SwingConstants.CENTER);
		lblEsci.setIcon(new ImageIcon(img.esci()));
		panelUscita.add(lblEsci);

		JLabel lblLinee1 = new JLabel("");
		JLabel lblLinee2 = new JLabel("");
		lblLinee2.setVisible(false);
		lblLinee1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
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
		});
		lblLinee1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblLinee1.setHorizontalAlignment(SwingConstants.CENTER);
		lblLinee1.setIcon(new ImageIcon(img.linee1()));
		lblLinee1.setBounds(188, 49, 46, 70);
		pannelloTendina.add(lblLinee1);

		lblLinee2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
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

				if (yMouseSuSchermo > 2) {
					setBounds(0, 0, 1143, 677);
					pannelloBase.setBounds(0, 0, 1143, 677);
					pannelloDestra.setBounds(238, 42, 903, 635);
					lblLayout.setIcon(new ImageIcon(img.imgSfondoFull()));

				}

			}
		});
		lblSpostaDaashboard.setEnabled(false);
		lblSpostaDaashboard.setBounds(0, 0, 1070, 37);
		pannelloBase.add(lblSpostaDaashboard);

		dimensione();

	}

	// rimozione background java e adattamento al centro dello schermo
	public Dimension dimensione() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		this.setBackground(new Color(0, 0, 0, 0));

		return dim;
	}

}
