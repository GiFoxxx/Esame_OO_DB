package GUI;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import Amministrazione.UtenteImplementazionePostgresDAO;
import Controller.Controller;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Cursor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JMenuBar;

public class Accesso extends JFrame {

	UtenteImplementazionePostgresDAO dao = new UtenteImplementazionePostgresDAO();
	ArrayList<Object[]> ListaUtenti = new ArrayList<>();

	private Image aggiungiUtente = new ImageIcon(Accesso.class.getResource("immaginiAccesso/aggiungiUtente.png"))
			.getImage().getScaledInstance(47, 47, Image.SCALE_SMOOTH);
	private Image impostazioni1 = new ImageIcon(Accesso.class.getResource("immaginiAccesso/Impostazioni1.png"))
			.getImage().getScaledInstance(47, 47, Image.SCALE_SMOOTH);
	private Image impostazioni2 = new ImageIcon(Accesso.class.getResource("immaginiAccesso/Impostazioni2.png"))
			.getImage().getScaledInstance(47, 47, Image.SCALE_SMOOTH);
	private Image avanti1 = new ImageIcon(Accesso.class.getResource("immaginiAccesso/avanti1.png")).getImage()
			.getScaledInstance(160, 53, Image.SCALE_SMOOTH);
	private Image layout = new ImageIcon(Accesso.class.getResource("immaginiAccesso/layout.png")).getImage()
			.getScaledInstance(971, 639, Image.SCALE_SMOOTH);
	private Image avanti2 = new ImageIcon(Accesso.class.getResource("immaginiAccesso/avanti2.png")).getImage()
			.getScaledInstance(160, 53, Image.SCALE_SMOOTH);
	private Image mostraPassword = new ImageIcon(Accesso.class.getResource("immaginiAccesso/mostraPassword.png"))
			.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	private Image censuraPassword = new ImageIcon(Accesso.class.getResource("immaginiAccesso/censuraPassword.png"))
			.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	private Image pannelloImpostazioni = new ImageIcon(
			Accesso.class.getResource("immaginiLauncher/pannelloImpostazioni.png")).getImage().getScaledInstance(243,
					572, Image.SCALE_SMOOTH);
	private Image frecciaImpostazioni1 = new ImageIcon(
			Accesso.class.getResource("immaginiLauncher/frecciaImpostazioni1.png")).getImage().getScaledInstance(35, 35,
					Image.SCALE_SMOOTH);
	private Image frecciaImpostazioni2 = new ImageIcon(
			Accesso.class.getResource("immaginiLauncher/frecciaImpostazioni2.png")).getImage().getScaledInstance(35, 35,
					Image.SCALE_SMOOTH);
	private Image X1 = new ImageIcon(Accesso.class.getResource("immaginiLauncher/X1.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	private Image X2 = new ImageIcon(Accesso.class.getResource("immaginiLauncher/X2.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	private Image minimizza1 = new ImageIcon(Accesso.class.getResource("immaginiLauncher/minimizza1.png")).getImage().getScaledInstance(16, 5, Image.SCALE_SMOOTH);
	private Image minimizza2 = new ImageIcon(Accesso.class.getResource("immaginiLauncher/minimizza2.png")).getImage().getScaledInstance(16, 5, Image.SCALE_SMOOTH);

	private JPanel contentPane;

	public JTextField getTxtEmail() {
		return txtfldEmail;
	}

	public void setTxtEmail(JTextField txtEmail) {
		this.txtfldEmail = txtEmail;
	}

	public JTextField getTxtPassword() {
		return txtfldPassword;
	}

	public void setTxtPassword(JTextField txtPassword) {
		this.txtfldPassword = (JPasswordField) txtPassword;
	}

	private JTextField txtfldEmail;
	private JLabel lblMessaggioCredenziali = new JLabel("");

	Controller controllerAccesso;
	private JTextField txtEmail;
	private JTextField txtPassword;
	private JPasswordField txtfldPassword;

	public Accesso(Controller controller) {
		controllerAccesso = controller;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);

		JLabel lblgestioneUtenti = new JLabel("Gestione utenti");
		JLabel lblEsci = new JLabel("Esci");
		JLabel lblTemaScuro = new JLabel("Tema scuro");
		JLabel lblTemaChiaro = new JLabel("Tema chiaro");
		JLabel lblRiconoscimenti = new JLabel("Riconoscimenti");
		JLabel lblFrecciaImpostazioni = new JLabel("");
		lblEsci.setVisible(false);
		lblFrecciaImpostazioni.setVisible(false);

		lblFrecciaImpostazioni.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblFrecciaImpostazioni.setIcon(new ImageIcon(frecciaImpostazioni2));

			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblFrecciaImpostazioni.setIcon(new ImageIcon(frecciaImpostazioni1));

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				lblFrecciaImpostazioni.setVisible(false);
				lblTemaScuro.setVisible(false);
				lblTemaChiaro.setVisible(false);
				lblRiconoscimenti.setVisible(false);
				lblEsci.setVisible(false);

			}
		});

		JLabel lblX = new JLabel("");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Accesso.this.dispose();

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
		lblX.setBounds(470, 51, 37, 23);
		contentPane.add(lblX);

		lblFrecciaImpostazioni.setHorizontalAlignment(SwingConstants.CENTER);
		lblFrecciaImpostazioni.setIcon(new ImageIcon(frecciaImpostazioni1));
		lblFrecciaImpostazioni.setBounds(251, 108, 57, 68);
		contentPane.add(lblFrecciaImpostazioni);

		lblFrecciaImpostazioni.setHorizontalAlignment(SwingConstants.CENTER);
		lblFrecciaImpostazioni.setIcon(new ImageIcon(frecciaImpostazioni1));
		lblFrecciaImpostazioni.setBounds(220, 97, 35, 35);
		contentPane.add(lblFrecciaImpostazioni);
		JLabel lblMinimizza = new JLabel("");
		lblMinimizza.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblMinimizza.setIcon(new ImageIcon(minimizza2));

			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblMinimizza.setIcon(new ImageIcon(minimizza1));

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				setState(Accesso.ICONIFIED);

			}
		});
		lblMinimizza.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinimizza.setIcon(new ImageIcon(minimizza1));
		lblMinimizza.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblMinimizza.setBounds(413, 49, 37, 14);
		contentPane.add(lblMinimizza);

		JLabel lblTerminiECondizioni = new JLabel("Termini e condizioni");
		lblTerminiECondizioni.setHorizontalAlignment(SwingConstants.CENTER);
		lblTerminiECondizioni.setBounds(117, 405, 92, 14);
		contentPane.add(lblTerminiECondizioni);

		lblRiconoscimenti.setFont(new Font("Arial", Font.BOLD, 15));
		lblRiconoscimenti.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblRiconoscimenti.setVisible(false);

		lblRiconoscimenti.setHorizontalAlignment(SwingConstants.CENTER);
		lblRiconoscimenti.setBounds(93, 333, 116, 23);
		contentPane.add(lblRiconoscimenti);
		lblTemaChiaro.setFont(new Font("Arial", Font.BOLD, 15));
		lblTemaChiaro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblTemaChiaro.setVisible(false);

		lblTemaChiaro.setHorizontalAlignment(SwingConstants.CENTER);
		lblTemaChiaro.setBounds(97, 177, 109, 23);
		contentPane.add(lblTemaChiaro);
		lblTemaScuro.setFont(new Font("Arial", Font.BOLD, 15));
		lblTemaScuro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblTemaScuro.setVisible(false);

		lblTemaScuro.setHorizontalAlignment(SwingConstants.CENTER);
		lblTemaScuro.setBounds(99, 253, 105, 23);
		contentPane.add(lblTemaScuro);

		lblEsci.setBounds(117, 367, 50, 32);
		contentPane.add(lblEsci);
		lblEsci.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblEsci.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblEsci.setForeground(Color.RED);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblEsci.setForeground(Color.WHITE);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				Object[] options = { "SI", "ANNULLA" };
				if (JOptionPane.showOptionDialog(null, "Sei sicuro di voler uscire dal progrmamma?", "ATTENZIONE!",
						JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]) == 0) {
					Accesso.this.dispose();
				}
			}
		});
		lblEsci.setForeground(Color.DARK_GRAY);
		lblEsci.setFont(new Font("Arial", Font.BOLD, 17));
		lblEsci.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblImpostazioni = new JLabel("");
		lblImpostazioni.setBounds(72, 49, 50, 50);
		contentPane.add(lblImpostazioni);
		lblImpostazioni.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblImpostazioni.setIcon(new ImageIcon(impostazioni2));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblImpostazioni.setIcon(new ImageIcon(impostazioni1));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				lblFrecciaImpostazioni.setVisible(true);
				lblTemaScuro.setVisible(true);
				lblTemaChiaro.setVisible(true);
				lblRiconoscimenti.setVisible(true);
				lblEsci.setVisible(true);

			}
		});
		lblImpostazioni.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblImpostazioni.setHorizontalAlignment(SwingConstants.CENTER);
		lblImpostazioni.setIcon(new ImageIcon(impostazioni1));

		lblgestioneUtenti.setBounds(577, 561, 120, 32);
		contentPane.add(lblgestioneUtenti);
		lblgestioneUtenti.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerAccesso.gestioneUtentiDaAccesso();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblgestioneUtenti.setForeground(new Color(20, 136, 180));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblgestioneUtenti.setForeground(new Color(112, 112, 112));
			}
		});
		lblgestioneUtenti.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblgestioneUtenti.setForeground(new Color(112, 112, 112));
		lblgestioneUtenti.setFont(new Font("Arial", Font.BOLD, 17));
		lblgestioneUtenti.setHorizontalAlignment(SwingConstants.CENTER);

		txtfldPassword = new JPasswordField();
		txtfldPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent EventoInvio) {
				if (EventoInvio.getKeyCode() == KeyEvent.VK_ENTER) {
					controllerAccesso.vaiAMenuGestione();
				}
			}
		});

		JLabel lblcensuraPassword = new JLabel("");
		lblcensuraPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblcensuraPassword.setVisible(false);
				txtfldPassword.setEchoChar((char) 0);
			}

		});

		lblcensuraPassword.setToolTipText("Mostra password");

		lblcensuraPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblcensuraPassword.setIcon(new ImageIcon(censuraPassword));
		lblcensuraPassword.setBounds(890, 379, 20, 14);
		contentPane.add(lblcensuraPassword);

		JLabel lblmostraPassword = new JLabel("");
		lblmostraPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				lblcensuraPassword.setVisible(true);
				txtfldPassword.setEchoChar('●');

			}
		});

		lblmostraPassword.setToolTipText("Mostra password");
		lblmostraPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblmostraPassword.setIcon(new ImageIcon(mostraPassword));
		lblmostraPassword.setBounds(890, 379, 20, 14);
		contentPane.add(lblmostraPassword);

		txtfldPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent EventoInvio) {
				if (EventoInvio.getKeyCode() == KeyEvent.VK_ENTER) {
					controllerAccesso.vaiAMenuGestione();
				}
			}
		});

		JLabel lblCredenziali = new JLabel("");
		lblCredenziali.setHorizontalAlignment(SwingConstants.CENTER);
		lblCredenziali.setIcon(new ImageIcon(Accesso.class.getResource("/GUI/immaginiAccesso/credenziali.png")));
		lblCredenziali.setBounds(553, 234, 373, 169);
		contentPane.add(lblCredenziali);
		txtfldPassword.setBackground(new Color(249, 249, 249));
		txtfldPassword.setBorder(null);
		txtfldPassword.setHorizontalAlignment(SwingConstants.LEFT);
		txtfldPassword.setFont(new Font("Arial", Font.PLAIN, 18));
		txtfldPassword.setForeground(Color.LIGHT_GRAY);
		txtfldPassword.setBounds(569, 376, 321, 20);
		contentPane.add(txtfldPassword);

		txtfldEmail = new JTextField();
		txtfldEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent EventoInvio) {
				if (EventoInvio.getKeyCode() == KeyEvent.VK_ENTER) {
					controllerAccesso.vaiAMenuGestione();
				}
			}
		});

		txtfldEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent EventoInvio) {
				if (EventoInvio.getKeyCode() == KeyEvent.VK_ENTER) {
					controllerAccesso.vaiAMenuGestione();
				}
			}
		});
		txtfldEmail.setForeground(Color.LIGHT_GRAY);
		txtfldEmail.setBorder(null);
		txtfldEmail.setBackground(new Color(249, 249, 249));
		txtfldEmail.setFont(new Font("Arial", Font.PLAIN, 18));
		txtfldEmail.setHorizontalAlignment(SwingConstants.LEFT);
		txtfldEmail.setColumns(10);
		txtfldEmail.setBounds(569, 271, 343, 20);
		contentPane.add(txtfldEmail);

		JLabel lblAvanti = new JLabel("");
		lblAvanti.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblAvanti.setIcon(new ImageIcon(avanti2));

			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblAvanti.setIcon(new ImageIcon(avanti1));
			}

			@Override
			public void mouseClicked(MouseEvent e) {

				String email = txtfldEmail.getText();
				String password = txtfldPassword.getText();

				if (dao.accessoUtente(email, password)) {
					controllerAccesso.vaiAMenuGestione();
				}
			}
		});
		lblAvanti.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAvanti.setBackground(new Color(0, 0, 0, 0));
		lblAvanti.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvanti.setIcon(new ImageIcon(avanti1));
		lblAvanti.setBounds(612, 459, 234, 68);
		contentPane.add(lblAvanti);

		JLabel lblcreaAccount = new JLabel("");
		lblcreaAccount.addMouseListener(new MouseAdapter() {
			@Override // vado a registrazione da crea un nuovo account da accedi
			public void mouseClicked(MouseEvent e) {
				controllerAccesso.vaiARegistrazioneDaAccesso();
			}
		});
		lblcreaAccount.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblcreaAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblcreaAccount.setIcon(new ImageIcon(aggiungiUtente));
		lblcreaAccount.setBounds(876, 532, 50, 50);
		contentPane.add(lblcreaAccount);

		JLabel lblAccedi = new JLabel("ACCEDI");
		lblAccedi.setForeground(Color.WHITE);
		lblAccedi.setFont(new Font("Arial", Font.BOLD, 27));
		lblAccedi.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccedi.setBounds(293, 428, 192, 68);
		contentPane.add(lblAccedi);

		JLabel lblLayout = new JLabel("");
		lblLayout.setHorizontalAlignment(SwingConstants.CENTER);
		lblLayout.setIcon(new ImageIcon(layout));
		lblLayout.setBounds(0, 0, 1043, 683);
		contentPane.add(lblLayout);

		JLabel lblMessaggioCredenziali = new JLabel("");
		lblMessaggioCredenziali.setForeground(new Color(139, 69, 19));
		lblMessaggioCredenziali.setFont(new Font("Arial", Font.PLAIN, 10));
		lblMessaggioCredenziali.setBounds(568, 405, 343, 14);
		contentPane.add(lblMessaggioCredenziali);

		// rimozione background java e adattamento al centro dello schermo
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		this.setBackground(new Color(0, 0, 0, 0));

	}

	// METODI

	public void MostraInserimentoCredenziali() {
		lblMessaggioCredenziali.setText("Perfavore, inserisci le credenziali!");
	}

	public void MostraErroreAccesso() {
		lblMessaggioCredenziali.setText("Nome utente o password errati. Riprova");
	}


	public void svuotaCampi() {
		getTxtEmail().setText("");
		getTxtPassword().setText("");
	}
}
