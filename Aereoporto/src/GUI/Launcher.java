package GUI;

import Controller.Controller;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JSeparator;
import java.awt.event.MouseMotionAdapter;
import java.awt.Cursor;

public class Launcher extends JFrame {

	private Image avvio1 = new ImageIcon(Accesso.class.getResource("immaginiLauncher/avvio1.png")).getImage().getScaledInstance(160, 56, Image.SCALE_SMOOTH);
	private Image avvio2 = new ImageIcon(Accesso.class.getResource("immaginiLauncher/avvio2.png")).getImage().getScaledInstance(160, 56, Image.SCALE_SMOOTH);
	private Image impostazioni1 = new ImageIcon(Accesso.class.getResource("immaginiLauncher/impostazioni1.png")).getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);
	private Image impostazioni2 = new ImageIcon(Accesso.class.getResource("immaginiLauncher/impostazioni2.png")).getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);
	private Image layout = new ImageIcon(Accesso.class.getResource("immaginiLauncher/layout.png")).getImage().getScaledInstance(496, 628, Image.SCALE_SMOOTH);
	private Image pannelloAvvio = new ImageIcon(Accesso.class.getResource("immaginiLauncher/pannelloAvvio.png")).getImage().getScaledInstance(243, 383, Image.SCALE_SMOOTH);
	private Image pannelloImpostazioni = new ImageIcon(Accesso.class.getResource("immaginiLauncher/pannelloImpostazioni.png")).getImage().getScaledInstance(243, 572, Image.SCALE_SMOOTH);
	private Image frecciaImpostazioni1 = new ImageIcon(Accesso.class.getResource("immaginiLauncher/frecciaImpostazioni1.png")).getImage().getScaledInstance(35, 35,Image.SCALE_SMOOTH);
	private Image frecciaImpostazioni2 = new ImageIcon(Accesso.class.getResource("immaginiLauncher/frecciaImpostazioni2.png")).getImage().getScaledInstance(35, 35,Image.SCALE_SMOOTH);
	private Image X1 = new ImageIcon(Accesso.class.getResource("immaginiLauncher/X1.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	private Image X2 = new ImageIcon(Accesso.class.getResource("immaginiLauncher/X2.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	private Image minimizza1 = new ImageIcon(Accesso.class.getResource("immaginiLauncher/minimizza1.png")).getImage().getScaledInstance(16, 5, Image.SCALE_SMOOTH);
	private Image minimizza2 = new ImageIcon(Accesso.class.getResource("immaginiLauncher/minimizza2.png")).getImage().getScaledInstance(16, 5, Image.SCALE_SMOOTH);

	private JPanel contentPane;

	Controller controllerLauncher;

	public Launcher(Controller controller) {

		controllerLauncher = controller;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setUndecorated(true);
		contentPane.setLayout(null);

		JLabel lblPannelloImpostazioni = new JLabel("");
		JLabel lblImpostazioni = new JLabel("");
		JLabel lblEsci = new JLabel("Esci");
		lblEsci.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Object[] options = { "SI", "ANNULLA" };
				if (JOptionPane.showOptionDialog(null, "Sei sicuro di voler uscire dal progrmamma?", "ATTENZIONE!",
						JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]) == 0) {
					Launcher.this.dispose();
				}
			}
		});
		lblEsci.setFont(new Font("Arial", Font.BOLD, 15));
		lblEsci.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		JLabel lblRiconoscimenti = new JLabel("Riconoscimenti");
		lblRiconoscimenti.setFont(new Font("Arial", Font.BOLD, 15));
		lblRiconoscimenti.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		JLabel lblTemaChiaro = new JLabel("Tema chiaro");
		lblTemaChiaro.setFont(new Font("Arial", Font.BOLD, 15));
		lblTemaChiaro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		JLabel lblTemaScuro = new JLabel("Tema scuro");
		lblTemaScuro.setFont(new Font("Arial", Font.BOLD, 15));
		lblTemaScuro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		JLabel lblAvvio = new JLabel("");
		JLabel lblRegistrati = new JLabel("REGISTRATI");
		lblRegistrati.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				controllerLauncher.Registrazione();
			}
		});
		JLabel lblAccedi = new JLabel("ACCEDI");
		lblAccedi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				controllerLauncher.Accesso();
				
			}
		});
		JLabel lblLayout = new JLabel("");
		JLabel lblPannelloAvvio = new JLabel("");
		JLabel lblFreccia = new JLabel("");
		lblFreccia.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		JLabel lblX = new JLabel("");

		lblX.setVisible(true);
		lblPannelloAvvio.setVisible(false);
		lblAccedi.setVisible(false);
		lblRegistrati.setVisible(false);
		lblPannelloImpostazioni.setVisible(false);
		lblTemaChiaro.setVisible(false);
		lblTemaScuro.setVisible(false);
		lblRiconoscimenti.setVisible(false);
		lblEsci.setVisible(false);
		lblFreccia.setVisible(false);

		lblImpostazioni.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblImpostazioni.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblImpostazioni.setIcon(new ImageIcon(impostazioni2));

			}

			public void mouseExited(MouseEvent e) {
				lblImpostazioni.setIcon(new ImageIcon(impostazioni1));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				lblPannelloImpostazioni.setVisible(true);
				lblFreccia.setVisible(true);
				lblTemaChiaro.setVisible(true);
				lblTemaScuro.setVisible(true);
				lblRiconoscimenti.setVisible(true);
				lblEsci.setVisible(true);
			}
		});

		lblAvvio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		lblAvvio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblAvvio.setIcon(new ImageIcon(avvio2));

			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblAvvio.setIcon(new ImageIcon(avvio1));

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				lblLayout.setIcon(new ImageIcon(layout));
				lblPannelloAvvio.setVisible(true);
				lblAccedi.setVisible(true);
				lblRegistrati.setVisible(true);

			}
		});

		lblFreccia.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblFreccia.setIcon(new ImageIcon(frecciaImpostazioni2));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblFreccia.setIcon(new ImageIcon(frecciaImpostazioni1));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				lblTemaChiaro.setVisible(false);
				lblTemaScuro.setVisible(false);
				lblRiconoscimenti.setVisible(false);
				lblEsci.setVisible(false);
				lblPannelloImpostazioni.setVisible(false);
				lblFreccia.setVisible(false);
			}
		});

		lblX.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblX.setBounds(776, 43, 24, 23);
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblX.setIcon(new ImageIcon(X2));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblX.setIcon(new ImageIcon(X1));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				Launcher.this.dispose();
			}
		});

		JLabel lblMinimizza = new JLabel("");
		lblMinimizza.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(Launcher.ICONIFIED);
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

		JLabel lblTerminiECondizioni = new JLabel("Termini e condizioni");
		lblTerminiECondizioni.setHorizontalAlignment(SwingConstants.CENTER);
		lblTerminiECondizioni.setBounds(257, 596, 92, 14);
		contentPane.add(lblTerminiECondizioni);
		lblMinimizza.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinimizza.setIcon(new ImageIcon(minimizza1));
		lblMinimizza.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblMinimizza.setBounds(743, 52, 37, 14);
		contentPane.add(lblMinimizza);

		lblX.setForeground(Color.WHITE);
		lblX.setFont(new Font("Arial", Font.BOLD, 15));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setIcon(new ImageIcon(X1));
		contentPane.add(lblX);

		lblFreccia.setHorizontalAlignment(SwingConstants.CENTER);
		lblFreccia.setIcon(new ImageIcon(frecciaImpostazioni1));
		lblFreccia.setBounds(220, 97, 35, 35);
		contentPane.add(lblFreccia);

		lblTemaScuro.setHorizontalAlignment(SwingConstants.CENTER);
		lblTemaScuro.setBounds(185, 265, 105, 23);
		contentPane.add(lblTemaScuro);

		lblTemaChiaro.setHorizontalAlignment(SwingConstants.CENTER);
		lblTemaChiaro.setBounds(183, 189, 109, 23);
		contentPane.add(lblTemaChiaro);

		lblRiconoscimenti.setHorizontalAlignment(SwingConstants.CENTER);
		lblRiconoscimenti.setBounds(179, 345, 116, 23);
		contentPane.add(lblRiconoscimenti);

		lblEsci.setHorizontalAlignment(SwingConstants.CENTER);
		lblEsci.setBounds(220, 531, 51, 14);
		contentPane.add(lblEsci);
		lblAvvio.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvvio.setIcon(new ImageIcon(avvio1));
		lblAvvio.setBounds(514, 472, 170, 85);
		contentPane.add(lblAvvio);

		lblRegistrati.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblRegistrati.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrati.setFont(new Font("Arial", Font.BOLD, 14));
		lblRegistrati.setBounds(984, 298, 92, 23);
		contentPane.add(lblRegistrati);
		lblRegistrati.setVisible(false);

		lblAccedi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAccedi.setFont(new Font("Arial", Font.BOLD, 15));
		lblAccedi.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccedi.setBounds(1013, 265, 63, 23);
		contentPane.add(lblAccedi);

		lblAccedi.setVisible(false);
		lblImpostazioni.setHorizontalAlignment(SwingConstants.CENTER);
		lblImpostazioni.setIcon(new ImageIcon(impostazioni1));
		lblImpostazioni.setBounds(383, 33, 35, 35);
		contentPane.add(lblImpostazioni);

		JLabel lblTitolo = new JLabel("AIRPORT MANAGEMENT");
		lblTitolo.setForeground(Color.WHITE);
		lblTitolo.setFont(new Font("Arial", Font.BOLD, 31));
		lblTitolo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitolo.setBounds(406, 67, 380, 98);
		contentPane.add(lblTitolo);
		lblLayout.setHorizontalAlignment(SwingConstants.CENTER);
		lblLayout.setIcon(new ImageIcon(layout));

		lblLayout.setBounds(340, 11, 520, 636);
		contentPane.add(lblLayout);

		lblPannelloImpostazioni.setHorizontalAlignment(SwingConstants.CENTER);
		lblPannelloImpostazioni.setIcon(new ImageIcon(pannelloImpostazioni));

		lblPannelloImpostazioni.setBounds(114, 33, 259, 597);
		contentPane.add(lblPannelloImpostazioni);

		lblPannelloAvvio.setHorizontalAlignment(SwingConstants.CENTER);
		lblPannelloAvvio.setIcon(new ImageIcon(pannelloAvvio));
		lblPannelloAvvio.setBounds(840, 134, 250, 390);
		contentPane.add(lblPannelloAvvio);

		// rimozione background java e adattamento al centro dello schermo
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		this.setBackground(new Color(0, 0, 0, 0));
	}
}
