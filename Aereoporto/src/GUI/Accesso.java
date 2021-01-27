package GUI;

import javax.swing.JPanel;

import Controller.Controller;
import Immagini.Immagini;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;

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

	private Immagini img = new Immagini();
	
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
		txtEmail.setFont(new Font("Arial", Font.BOLD, 20));
		txtEmail.setHorizontalAlignment(SwingConstants.LEFT);
		txtEmail.setBounds(437, 244, 320, 22);
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
		txtPassword.setFont(new Font("Arial", Font.BOLD, 20));
		txtPassword.setForeground(scritte);
		txtPassword.setBounds(437, 348, 320, 22);
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
		lblmostraPassword.setIcon(new ImageIcon(img.censuraPassword()));
		lblmostraPassword.setBounds(761, 349, 20, 20);
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
		lblcensuraPassword.setIcon(new ImageIcon(img.mostraPassword()));
		lblcensuraPassword.setBounds(761, 349, 20, 20);
		add(lblcensuraPassword);

		JLabel lblCredenziali = new JLabel("");
		lblCredenziali.setHorizontalAlignment(SwingConstants.CENTER);
		lblCredenziali.setIcon(new ImageIcon(Accesso.class.getResource("/GUI/immaginiAccesso/credenziali.png")));
		lblCredenziali.setBounds(437, 214, 344, 159);
		add(lblCredenziali);

		JLabel lblAvanti = new JLabel("");
		lblAvanti.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblAvanti.setIcon(new ImageIcon(img.avanti2()));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblAvanti.setIcon(new ImageIcon(img.avanti1()));
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
		lblAvanti.setIcon(new ImageIcon(img.avanti1()));
		lblAvanti.setBackground(new Color(0, 0, 0, 0));
		lblAvanti.setBounds(506, 479, 206, 60);
		add(lblAvanti);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(img.icona()));
		lblNewLabel.setBounds(55, 128, 320, 361);
		add(lblNewLabel);

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
