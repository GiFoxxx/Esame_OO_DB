package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import java.awt.Font;

public class Dashboard extends JFrame {

	int posizioneTendina = 238;

	private Image imgSfondo = new ImageIcon(Accesso.class.getResource("immaginiDashboard/SfondoDashboard.png")).getImage()
			.getScaledInstance(1143, 677, Image.SCALE_SMOOTH);
	private Image tendina = new ImageIcon(Accesso.class.getResource("immaginiDashboard/TendinaDashboard.png")).getImage()
			.getScaledInstance(238, 677, Image.SCALE_SMOOTH);
	private Image linee = new ImageIcon(Accesso.class.getResource("immaginiDashboard/linee.png")).getImage()
			.getScaledInstance(31, 12, Image.SCALE_SMOOTH);
	private Image X1 = new ImageIcon(Accesso.class.getResource("immaginiDashboard/X1.png")).getImage()
			.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	private Image X2 = new ImageIcon(Accesso.class.getResource("immaginiDashboard/X2.png")).getImage()
			.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	private Image minimizza1 = new ImageIcon(Accesso.class.getResource("immaginiDashboard/minimizza1.png")).getImage()
			.getScaledInstance(16, 5, Image.SCALE_SMOOTH);
	private Image minimizza2 = new ImageIcon(Accesso.class.getResource("immaginiDashboard/minimizza2.png")).getImage()
			.getScaledInstance(16, 5, Image.SCALE_SMOOTH);
	private Image casa = new ImageIcon(Accesso.class.getResource("immaginiDashboard/home.png")).getImage()
			.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image accedi = new ImageIcon(Accesso.class.getResource("immaginiDashboard/accesso.png")).getImage()
			.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image registrati = new ImageIcon(Accesso.class.getResource("immaginiDashboard/registrazione.png"))
			.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image profilo = new ImageIcon(Accesso.class.getResource("immaginiDashboard/profilo.png")).getImage()
			.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image impostazioni = new ImageIcon(Accesso.class.getResource("immaginiDashboard/impostazioni.png"))
			.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image esci = new ImageIcon(Accesso.class.getResource("immaginiDashboard/esci.png")).getImage()
			.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image titolo = new ImageIcon(Accesso.class.getResource("immaginiDashboard/titolo.png")).getImage()
			.getScaledInstance(217, 18, Image.SCALE_SMOOTH);

	Color sfondo = new Color(54, 57, 63);
	Color clickPannello = new Color(40, 40, 40);
	Color entroPannello = new Color(30, 30, 30);
	Color escoPannelloLaterale = new Color(35,39,42);
	Color trasparente = new Color(0, 0, 0, 0);
	
	
	private JPanel contentPane;

	private JPanel home;
	private JPanel accesso;
	private JPanel registrazione;
	private JPanel gestioneGate1;

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

	public JPanel getGestioneGate1() {
		return gestioneGate1;
	}

	public void setGestioneGate1(JPanel gestioneGate) {
		this.gestioneGate1 = gestioneGate;
	}

	Controller controllerDashboard;

	public Dashboard(Controller controller) {
		controllerDashboard = controller;

		home = controllerDashboard.home();
		accesso = controllerDashboard.accesso();
		registrazione = controllerDashboard.registrazione();
		gestioneGate1 = controllerDashboard.gestioneGate();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1143, 677);
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
				lblX.setIcon(new ImageIcon(X2));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblX.setIcon(new ImageIcon(X1));
			}
		});
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setIcon(new ImageIcon(X1));
		lblX.setBounds(1096, 11, 37, 23);
		pannelloBase.add(lblX);

		JLabel lblMinimizza = new JLabel("");
		lblMinimizza.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(Dashboard.ICONIFIED);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblMinimizza.setIcon(new ImageIcon(minimizza2));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblMinimizza.setIcon(new ImageIcon(minimizza1));
			}
		});
		lblMinimizza.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinimizza.setIcon(new ImageIcon(minimizza1));
		lblMinimizza.setBounds(1069, 17, 37, 14);
		pannelloBase.add(lblMinimizza);

		JPanel pannelloDestra = new JPanel();
		pannelloDestra.setBounds(238, 42, 903, 635);
		pannelloDestra.setBackground(trasparente);
		
		pannelloBase.add(pannelloDestra);
		pannelloDestra.add(home);
		pannelloDestra.add(accesso);
		pannelloDestra.add(registrazione);
		pannelloDestra.add(gestioneGate1);
		home.setVisible(true);
		accesso.setVisible(false);
		registrazione.setVisible(false);
		gestioneGate1.setVisible(false);

		pannelloDestra.setLayout(null);


		JLabel lblTitolo = new JLabel("");
		lblTitolo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitolo.setIcon(new ImageIcon(titolo));
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
		lblHome.setIcon(new ImageIcon(casa));
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
		lblAccesso.setIcon(new ImageIcon(accedi));

		JPanel panelRegistrati = new JPanel();
		panelRegistrati.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {				
				controllerDashboard.mostraPannelli(registrazione);
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
		lblRegistrazione.setIcon(new ImageIcon(registrati));

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
		lblProfilo.setIcon(new ImageIcon(profilo));
		
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
		lbllblImpostazioni.setIcon(new ImageIcon(impostazioni));

		JPanel panelUscita = new JPanel();
		panelUscita.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {				
				uscita();
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
		lblEsci.setIcon(new ImageIcon(esci));
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
		lblLinee1.setIcon(new ImageIcon(linee));
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
		lblLinee2.setIcon(new ImageIcon(linee));

		JLabel lblTendina = new JLabel("");
		lblTendina.setBounds(0, 0, 238, 677);
		lblTendina.setHorizontalAlignment(SwingConstants.CENTER);
		lblTendina.setIcon(new ImageIcon(tendina));
		pannelloTendina.add(lblTendina);

		JLabel lblLayout = new JLabel("");
		lblLayout.setBounds(0, 0, 1143, 677);
		lblLayout.setHorizontalAlignment(SwingConstants.CENTER);
		lblLayout.setIcon(new ImageIcon(imgSfondo));
		pannelloBase.add(lblLayout);

		// rimozione background java e adattamento al centro dello schermo
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		this.setBackground(new Color(0, 0, 0, 0));

	}

	// METODI
	public void uscita() {
		Object[] options = { "SI", "ANNULLA" };
		if (JOptionPane.showOptionDialog(null, "Sei sicuro di voler uscire dal progrmamma?", "ATTENZIONE!",
				JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]) == 0) {
			Dashboard.this.dispose();
		}
	}

}
