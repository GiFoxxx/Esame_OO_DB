package GUI;

import javax.swing.JPanel;

import Controller.Controller;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Accesso extends JPanel {

	private Image aggiungiUtente = new ImageIcon(Accesso.class.getResource("immaginiAccesso/aggiungiUtente.png"))
			.getImage().getScaledInstance(47, 47, Image.SCALE_SMOOTH);
	private Image avanti1 = new ImageIcon(Accesso.class.getResource("immaginiAccesso/avanti1.png")).getImage()
			.getScaledInstance(160, 53, Image.SCALE_SMOOTH);
	private Image avanti2 = new ImageIcon(Accesso.class.getResource("immaginiAccesso/avanti2.png")).getImage()
			.getScaledInstance(160, 53, Image.SCALE_SMOOTH);
	private Image mostraPassword = new ImageIcon(Accesso.class.getResource("immaginiAccesso/mostraPassword.png"))
			.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	private Image censuraPassword = new ImageIcon(Accesso.class.getResource("immaginiAccesso/censuraPassword.png"))
			.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);

	Color sfondo = new Color(54, 57, 63);
	Color scritte = new Color(141, 142, 146);
	
	
	Controller controllerAccesso;
	private JTextField txtEmail;
	private JPasswordField txtPassword;
	private JLabel lblMessaggioCredenziali = new JLabel("");

	// GETTER E SETTER

	public JTextField getTxtEmail() {
		return txtEmail;
	}

	public void setTxtEmail(JTextField txtFieldEmail) {
		this.txtEmail = txtFieldEmail;
	}

	public JPasswordField getTxtPassword() {
		return txtPassword;
	}

	public void setTxtPassword(JPasswordField txtFieldPassword) {
		this.txtPassword = txtFieldPassword;
	}

	public Accesso(Controller controller) {
		controllerAccesso = controller;

		
		
		setBounds(0, 0, 894, 625);
		setBackground(sfondo);
		setLayout(null);

		txtEmail = new JTextField();
		txtEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent EventoInvio) {
				if (EventoInvio.getKeyCode() == KeyEvent.VK_ENTER) {
					controllerAccesso.mostraPannelli(controllerAccesso.home());
				}
			}
		});
		txtEmail.setBackground(sfondo);
		txtEmail.setForeground(scritte);
		txtEmail.setFont(new Font("Arial", Font.BOLD, 18));
		txtEmail.setHorizontalAlignment(SwingConstants.LEFT);
		txtEmail.setBounds(250, 230, 320, 22);
		txtEmail.setColumns(10);
		txtEmail.setBorder(null);
		add(txtEmail);

		txtPassword = new JPasswordField();
		txtPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent EventoInvio) {
				if (EventoInvio.getKeyCode() == KeyEvent.VK_ENTER) {
//					controllerAccesso.mostraPannelli(controllerAccesso.getHome());
					controllerAccesso.vaiAMenuGestioneDaAccesso();
				}
			}
		});

		txtPassword.setBackground(sfondo);
		txtPassword.setHorizontalAlignment(SwingConstants.LEFT);
		txtPassword.setFont(new Font("Arial", Font.BOLD, 18));
		txtPassword.setForeground(scritte);
		txtPassword.setBounds(250, 334, 320, 22);
		txtPassword.setBorder(null);
		add(txtPassword);

		JLabel lblmostraPassword = new JLabel("");
		lblmostraPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblmostraPassword.setVisible(false);
				txtPassword.setEchoChar((char) 0);
			}
		});
		lblmostraPassword.setToolTipText("Mostra password");
		lblmostraPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblmostraPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblmostraPassword.setIcon(new ImageIcon(censuraPassword));
		lblmostraPassword.setBounds(574, 335, 20, 20);
		add(lblmostraPassword);

		JLabel lblcensuraPassword = new JLabel("");
		lblcensuraPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblmostraPassword.setVisible(true);
				txtPassword.setEchoChar('●');
			}
		});
		lblcensuraPassword.setToolTipText("Nascondi password");
		lblcensuraPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblcensuraPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblcensuraPassword.setIcon(new ImageIcon(mostraPassword));
		lblcensuraPassword.setBounds(574, 335, 20, 20);
		add(lblcensuraPassword);

		JLabel lblCredenziali = new JLabel("");
		lblCredenziali.setHorizontalAlignment(SwingConstants.CENTER);
		lblCredenziali.setIcon(new ImageIcon(Accesso.class.getResource("/GUI/immaginiAccesso/credenziali.png")));
		lblCredenziali.setBounds(250, 200, 344, 159);
		add(lblCredenziali);

		JLabel lblAccedi = new JLabel("ACCEDI");
		lblAccedi.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccedi.setForeground(scritte);
		lblAccedi.setFont(new Font("Arial", Font.BOLD, 27));
		lblAccedi.setBounds(80, 30, 110, 30);
		add(lblAccedi);

		JLabel lblcreaAccount = new JLabel("");
		lblcreaAccount.addMouseListener(new MouseAdapter() {
			@Override // vado a registrazione da crea un nuovo account da accedi
			public void mouseClicked(MouseEvent e) {
				controllerAccesso.mostraPannelli(controllerAccesso.getRegistrazione());
			}
		});
		lblcreaAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblcreaAccount.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblcreaAccount.setIcon(new ImageIcon(aggiungiUtente));
		lblcreaAccount.setBounds(80, 503, 47, 47);
		add(lblcreaAccount);

		JLabel lblgestioneUtenti = new JLabel("Gestione utenti");
		lblgestioneUtenti.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerAccesso.mostraPannelli(controllerAccesso.getHome());
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
		lblgestioneUtenti.setHorizontalAlignment(SwingConstants.CENTER);
		lblgestioneUtenti.setForeground(new Color(112, 112, 112));
		lblgestioneUtenti.setFont(new Font("Arial", Font.BOLD, 17));
		lblgestioneUtenti.setBounds(137, 516, 120, 21);
		add(lblgestioneUtenti);

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

				String email = getTxtEmail().getText();
				String password = getTxtPassword().getText();

				if (controllerAccesso.implementazioneUtenteDAO().accessoUtente(email, password)) {
					controllerAccesso.mostraPannelli(controllerAccesso.getHome());
				}
			}
		});
		lblAvanti.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAvanti.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvanti.setIcon(new ImageIcon(avanti1));
		lblAvanti.setBackground(new Color(0, 0, 0, 0));
		lblAvanti.setBounds(620, 500, 160, 53);
		add(lblAvanti);

	}

	// METODI

	public void MostraInserimentoCredenziali() {
		lblMessaggioCredenziali.setText("Perfavore, inserisci le credenziali!");
	}

	public void MostraErroreAccesso() {
		lblMessaggioCredenziali.setText("Nome utente o password errati. Riprova");
	}

	public void immaginiDashboard() {

	}

}
