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

	private Image layout = new ImageIcon(Accesso.class.getResource("immaginiDashboard/layout.png")).getImage()
			.getScaledInstance(1143, 677, Image.SCALE_SMOOTH);
	private Image tendina = new ImageIcon(Accesso.class.getResource("immaginiDashboard/tendina.png")).getImage()
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
	private Image home = new ImageIcon(Accesso.class.getResource("immaginiDashboard/home.png")).getImage()
			.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image accesso = new ImageIcon(Accesso.class.getResource("immaginiDashboard/accesso.png")).getImage()
			.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image registrazione = new ImageIcon(Accesso.class.getResource("immaginiDashboard/registrazione.png"))
			.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image profilo = new ImageIcon(Accesso.class.getResource("immaginiDashboard/profilo.png")).getImage()
			.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image impostazioni = new ImageIcon(Accesso.class.getResource("immaginiDashboard/impostazioni.png"))
			.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image esci = new ImageIcon(Accesso.class.getResource("immaginiDashboard/esci.png")).getImage()
			.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image pannello = new ImageIcon(Accesso.class.getResource("immaginiDashboard/pannello.png")).getImage()
			.getScaledInstance(238, 71, Image.SCALE_SMOOTH);
	private Image volo1 = new ImageIcon(Accesso.class.getResource("immaginiDashboard/volo1.png")).getImage()
			.getScaledInstance(272, 152, Image.SCALE_SMOOTH);
	private Image volo2 = new ImageIcon(Accesso.class.getResource("immaginiDashboard/volo2.png")).getImage()
			.getScaledInstance(272, 152, Image.SCALE_SMOOTH);
	private Image gate1 = new ImageIcon(Accesso.class.getResource("immaginiDashboard/gate1.png")).getImage()
			.getScaledInstance(272, 152, Image.SCALE_SMOOTH);
	private Image gate2 = new ImageIcon(Accesso.class.getResource("immaginiDashboard/gate2.png")).getImage()
			.getScaledInstance(272, 152, Image.SCALE_SMOOTH);
	private Image prenotazioni1 = new ImageIcon(Accesso.class.getResource("immaginiDashboard/prenotazioni1.png"))
			.getImage().getScaledInstance(272, 152, Image.SCALE_SMOOTH);
	private Image prenotazioni2 = new ImageIcon(Accesso.class.getResource("immaginiDashboard/prenotazioni2.png"))
			.getImage().getScaledInstance(272, 152, Image.SCALE_SMOOTH);
	private Image tratte1 = new ImageIcon(Accesso.class.getResource("immaginiDashboard/tratte1.png")).getImage()
			.getScaledInstance(272, 152, Image.SCALE_SMOOTH);
	private Image tratte2 = new ImageIcon(Accesso.class.getResource("immaginiDashboard/tratte2.png")).getImage()
			.getScaledInstance(272, 152, Image.SCALE_SMOOTH);
	private Image gestioneAccount1 = new ImageIcon(Accesso.class.getResource("immaginiDashboard/gestioneAccount1.png"))
			.getImage().getScaledInstance(272, 152, Image.SCALE_SMOOTH);
	private Image gestioneAccount2 = new ImageIcon(Accesso.class.getResource("immaginiDashboard/gestioneAccount2.png"))
			.getImage().getScaledInstance(272, 152, Image.SCALE_SMOOTH);
	private Image uscita1 = new ImageIcon(Accesso.class.getResource("immaginiDashboard/uscita1.png")).getImage()
			.getScaledInstance(272, 152, Image.SCALE_SMOOTH);
	private Image uscita2 = new ImageIcon(Accesso.class.getResource("immaginiDashboard/uscita2.png")).getImage()
			.getScaledInstance(272, 152, Image.SCALE_SMOOTH);
	private Image titolo = new ImageIcon(Accesso.class.getResource("immaginiDashboard/titolo.png")).getImage()
			.getScaledInstance(217, 18, Image.SCALE_SMOOTH);

	
	
	
	private JPanel contentPane;

	Controller controllerDashboard;
	

	public Dashboard(Controller controller) {
		controllerDashboard = controller;
				
		JPanel prova = controllerDashboard.prova();
		
		
		
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

		JPanel pannelloDestra = new JPanel();
		pannelloDestra.setBounds(239, 42, 904, 635);
		pannelloBase.add(pannelloDestra);
		

		
		pannelloDestra.add(prova);
		pannelloDestra.setLayout(null);
//		pannelloDestra.add(controllerDashboard.pannelloRegistrazione());
//		pannelloDestra.add(Profilo);
//		pannelloDestra.add(Impostazioni);
		
		
		JLabel lblTitolo = new JLabel("");
		lblTitolo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitolo.setIcon(new ImageIcon(titolo));
		lblTitolo.setBounds(239, 1, 277, 49);
		pannelloBase.add(lblTitolo);
		lblMinimizza.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinimizza.setIcon(new ImageIcon(minimizza1));
		lblMinimizza.setBounds(1069, 17, 37, 14);
		pannelloBase.add(lblMinimizza);
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setIcon(new ImageIcon(X1));
		lblX.setBounds(1096, 11, 37, 23);
		pannelloBase.add(lblX);

		JPanel pannelloTendina = new JPanel();
		pannelloTendina.setBackground(new Color(0, 0, 0, 0));
		pannelloTendina.setBounds(0, 0, 238, 677);
		pannelloBase.add(pannelloTendina);
		pannelloTendina.setLayout(null);

		JLabel lblScrittaHome = new JLabel("HOME");
		lblScrittaHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerDashboard.pannelli(prova);
				
			}
		});
		lblScrittaHome.setFont(new Font("Arial", Font.BOLD, 15));
		lblScrittaHome.setForeground(Color.WHITE);
		lblScrittaHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblScrittaHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblScrittaHome.setBounds(51, 136, 187, 53);
		pannelloTendina.add(lblScrittaHome);

		JLabel lblHome = new JLabel("");
		lblHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblHome.setIcon(new ImageIcon(home));
		lblHome.setBounds(10, 136, 46, 39);
		pannelloTendina.add(lblHome);

		JLabel lblPannello = new JLabel("");
		lblPannello.setBounds(10, 72, 238, 53);
		pannelloTendina.add(lblPannello);
		lblPannello.setHorizontalAlignment(SwingConstants.CENTER);
		lblPannello.setIcon(new ImageIcon(Dashboard.class.getResource("/GUI/immaginiDashboard/pannello.png")));
		lblPannello.setInheritsPopupMenu(false);

		JLabel lblImpostazioni = new JLabel("IMPOSTAZIONI");
		lblImpostazioni.setFont(new Font("Arial", Font.BOLD, 15));
		lblImpostazioni.setForeground(Color.WHITE);
		lblImpostazioni.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblImpostazioni.setHorizontalAlignment(SwingConstants.CENTER);
		lblImpostazioni.setBounds(66, 446, 107, 14);
		pannelloTendina.add(lblImpostazioni);

		JLabel lblScrittaEsci = new JLabel("ESCI");
		lblScrittaEsci.setFont(new Font("Arial", Font.BOLD, 15));
		lblScrittaEsci.setForeground(Color.WHITE);
		lblScrittaEsci.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblScrittaEsci.setHorizontalAlignment(SwingConstants.CENTER);
		lblScrittaEsci.setBounds(66, 536, 46, 14);
		pannelloTendina.add(lblScrittaEsci);

		JLabel lblScrittaAccesso = new JLabel("ACCEDI");
		lblScrittaAccesso.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		lblScrittaAccesso.setFont(new Font("Arial", Font.BOLD, 15));
		lblScrittaAccesso.setForeground(Color.WHITE);
		lblScrittaAccesso.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblScrittaAccesso.setHorizontalAlignment(SwingConstants.CENTER);
		lblScrittaAccesso.setBounds(66, 200, 172, 45);
		pannelloTendina.add(lblScrittaAccesso);

		JLabel lblScrittaRegistrazione = new JLabel("REGISTRATI");
		lblScrittaRegistrazione.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		lblScrittaRegistrazione.setFont(new Font("Arial", Font.BOLD, 15));
		lblScrittaRegistrazione.setForeground(Color.WHITE);
		lblScrittaRegistrazione.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblScrittaRegistrazione.setHorizontalAlignment(SwingConstants.CENTER);
		lblScrittaRegistrazione.setBounds(66, 270, 172, 39);
		pannelloTendina.add(lblScrittaRegistrazione);

		JLabel lblScrittaProfilo = new JLabel("PROFILO");
		lblScrittaProfilo.setFont(new Font("Arial", Font.BOLD, 15));
		lblScrittaProfilo.setForeground(Color.WHITE);
		lblScrittaProfilo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblScrittaProfilo.setHorizontalAlignment(SwingConstants.CENTER);
		lblScrittaProfilo.setBounds(66, 366, 78, 14);
		pannelloTendina.add(lblScrittaProfilo);

		JLabel lblAccesso = new JLabel("");
		lblAccesso.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccesso.setIcon(new ImageIcon(accesso));
		lblAccesso.setBounds(7, 206, 46, 39);
		pannelloTendina.add(lblAccesso);

		JLabel lblEsci = new JLabel("");
		lblEsci.setHorizontalAlignment(SwingConstants.CENTER);
		lblEsci.setIcon(new ImageIcon(esci));
		lblEsci.setBounds(7, 524, 46, 39);
		pannelloTendina.add(lblEsci);

		JLabel lblProfilo = new JLabel("");
		lblProfilo.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfilo.setIcon(new ImageIcon(profilo));
		lblProfilo.setBounds(2, 347, 56, 53);
		pannelloTendina.add(lblProfilo);

		JLabel lbllblImpostazioni = new JLabel("");
		lbllblImpostazioni.setHorizontalAlignment(SwingConstants.CENTER);
		lbllblImpostazioni.setIcon(new ImageIcon(impostazioni));
		lbllblImpostazioni.setBounds(7, 434, 46, 39);
		pannelloTendina.add(lbllblImpostazioni);

		JLabel lblRegistrazione = new JLabel("");
		lblRegistrazione.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrazione.setIcon(new ImageIcon(registrazione));
		lblRegistrazione.setBounds(7, 270, 46, 39);
		pannelloTendina.add(lblRegistrazione);
		JLabel lblLinee2 = new JLabel("");
		lblLinee2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblLinee2.setBounds(13, 49, 40, 26);
		pannelloTendina.add(lblLinee2);
		lblLinee2.setHorizontalAlignment(SwingConstants.CENTER);
		lblLinee2.setIcon(new ImageIcon(linee));
		JLabel lblLinee1 = new JLabel("");
		lblLinee1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblLinee1.setBounds(174, 49, 40, 26);

		lblLinee2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblLinee2.setVisible(false);
				if (posizioneTendina == 55) {
					pannelloTendina.show();
					pannelloTendina.setSize(posizioneTendina, 667);
					Thread th = new Thread() {
						@Override
						public void run() {
							try {
								for (int i = 55; i <= posizioneTendina; i++) {
									Thread.sleep(0, 1);
									pannelloTendina.setSize(i, 667);
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
		pannelloTendina.add(lblLinee1);
		lblLinee1.setHorizontalAlignment(SwingConstants.CENTER);
		lblLinee1.setIcon(new ImageIcon(linee));
		lblLinee1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblLinee1.setVisible(false);
				if (posizioneTendina == 238) {
					pannelloTendina.setSize(55, 667);
					Thread th = new Thread() {
						@Override
						public void run() {
							try {
								for (int i = 238; i >= 55; i--) {
									Thread.sleep(0, 1);
									pannelloTendina.setSize(i, 667);
								}
							} catch (Exception e) {
								JOptionPane.showMessageDialog(null, e);
							}
							lblLinee2.setVisible(true);
						}
					};
					th.start();
					posizioneTendina = 55;
				}
			}
		});

		JLabel lblTendina = new JLabel("");
		lblTendina.setBounds(0, 0, 238, 677);

		lblTendina.setHorizontalAlignment(SwingConstants.CENTER);
		lblTendina.setIcon(new ImageIcon(tendina));
		pannelloTendina.add(lblTendina);

		JLabel lblLayout = new JLabel("");
		lblLayout.setBounds(0, 0, 1143, 677);
		lblLayout.setHorizontalAlignment(SwingConstants.CENTER);
		lblLayout.setIcon(new ImageIcon(layout));
		pannelloBase.add(lblLayout);

		
		
		
		// rimozione background java e adattamento al centro dello schermo
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		this.setBackground(new Color(0, 0, 0, 0));
	
	}
	
	
	

}
