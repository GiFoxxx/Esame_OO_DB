package GUI;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.SwingConstants;

import Amministrazione.Utente;
import Controller.Controller;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Registrazione extends JPanel {

	private Image inserimentoCredenziali = new ImageIcon(Accesso.class.getResource("immaginiRegistrazione/inserimentoCredenziali.png")).getImage().getScaledInstance(370, 470, Image.SCALE_SMOOTH);
	private Image mostraPassword = new ImageIcon(Accesso.class.getResource("immaginiRegistrazione/mostraPassword.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	private Image censuraPassword = new ImageIcon(Accesso.class.getResource("immaginiRegistrazione/censuraPassword.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	private Image avanti1 = new ImageIcon(Accesso.class.getResource("immaginiRegistrazione/avanti1.png")).getImage().getScaledInstance(196, 50, Image.SCALE_SMOOTH);
	private Image avanti2 = new ImageIcon(Accesso.class.getResource("immaginiRegistrazione/avanti2.png")).getImage().getScaledInstance(196, 50, Image.SCALE_SMOOTH);

	Color sfondo = new Color(54, 57, 63);
	Color scritte = new Color(141, 142, 146);
	
	
	private JTextField txtNome;
	private JTextField txtCognome;
	private JTextField txtEmail;
	private JPasswordField txtPassword;
	private JPasswordField txtRipetiPassword;
	
	//GETTER E SETTER
	
	public JTextField getTxtNome() {
		return txtNome;
	}

	public void setTxtNome(JTextField txtNome) {
		this.txtNome = txtNome;
	}

	public JTextField getTxtCognome() {
		return txtCognome;
	}

	public void setTxtCognome(JTextField txtCognome) {
		this.txtCognome = txtCognome;
	}

	public JTextField getTxtEmail() {
		return txtEmail;
	}

	public void setTxtEmail(JTextField txtEmail) {
		this.txtEmail = txtEmail;
	}

	public JPasswordField getTxtPassword() {
		return txtPassword;
	}

	public void setTxtPassword(JPasswordField txtPassword) {
		this.txtPassword = txtPassword;
	}

	public JPasswordField getTxtRipetiPassword() {
		return txtRipetiPassword;
	}

	public void setTxtRipetiPassword(JPasswordField txtRipetiPassword) {
		this.txtRipetiPassword = txtRipetiPassword;
	}
	
	Controller controllerRegistrazione;
	
	public Registrazione(Controller controller) {
		controllerRegistrazione = controller;

		setBounds(0, 0, 894, 625);
		setBackground(sfondo);
		setLayout(null);

		txtNome = new JTextField();
		txtNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent EventoInvio) {
				if (EventoInvio.getKeyCode() == KeyEvent.VK_ENTER) {
					if (formatoEmailInseritaErrato()) {
						Utente utn = new Utente(getTxtNome().getText(), getTxtCognome().getText(), getTxtEmail().getText(), getTxtPassword().getText());
						controllerRegistrazione.implementazioneUtenteDAO().registrazioneUtente(utn);
					}
				}
			}
		});
		txtNome.setFont(new Font("Arial", Font.PLAIN, 12));
		txtNome.setColumns(10);
		txtNome.setBorder(null);
		txtNome.setBackground(sfondo);
		txtNome.setForeground(scritte);
		txtNome.setBounds(80, 113, 340, 23);
		add(txtNome);

		txtCognome = new JTextField();
		txtCognome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent EventoInvio) {
				if (EventoInvio.getKeyCode() == KeyEvent.VK_ENTER) {
					if (formatoEmailInseritaErrato()) {
						Utente utn = new Utente(getTxtNome().getText(), getTxtCognome().getText(), getTxtEmail().getText(), getTxtPassword().getText());
						controllerRegistrazione.implementazioneUtenteDAO().registrazioneUtente(utn);
					}
				}
			}
		});
		txtCognome.setFont(new Font("Arial", Font.PLAIN, 12));
		txtCognome.setColumns(10);
		txtCognome.setBorder(null);
		txtCognome.setBackground(sfondo);
		txtCognome.setForeground(scritte);
		txtCognome.setBounds(80, 217, 340, 23);
		add(txtCognome);

		txtEmail = new JTextField();
		txtEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent EventoInvio) {
				if (EventoInvio.getKeyCode() == KeyEvent.VK_ENTER) {
					if (formatoEmailInseritaErrato()) {
						Utente utn = new Utente(getTxtNome().getText(), getTxtCognome().getText(), getTxtEmail().getText(), getTxtPassword().getText());
						controllerRegistrazione.implementazioneUtenteDAO().registrazioneUtente(utn);
					}
				}
			}
		});
		txtEmail.setFont(new Font("Arial", Font.PLAIN, 12));
		txtEmail.setColumns(10);
		txtEmail.setBorder(null);
		txtEmail.setBackground(sfondo);
		txtEmail.setForeground(scritte);
		txtEmail.setBounds(80, 321, 340, 23);
		add(txtEmail);

		txtPassword = new JPasswordField();
		txtPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent EventoInvio) {
				if (EventoInvio.getKeyCode() == KeyEvent.VK_ENTER) {
					if (formatoEmailInseritaErrato()) {
						Utente utn = new Utente(getTxtNome().getText(), getTxtCognome().getText(), getTxtEmail().getText(), getTxtPassword().getText());
						controllerRegistrazione.implementazioneUtenteDAO().registrazioneUtente(utn);
					}
				}
			}
		});
		txtPassword.setFont(new Font("Arial", Font.PLAIN, 12));
		txtPassword.setBorder(null);
		txtPassword.setBackground(sfondo);
		txtPassword.setForeground(scritte);
		txtPassword.setBounds(80, 425, 340, 23);
		add(txtPassword);

		txtRipetiPassword = new JPasswordField();
		txtRipetiPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent EventoInvio) {
				if (EventoInvio.getKeyCode() == KeyEvent.VK_ENTER) {
					if (formatoEmailInseritaErrato()) {
						Utente utn = new Utente(getTxtNome().getText(), getTxtCognome().getText(), getTxtEmail().getText(), getTxtPassword().getText());
						controllerRegistrazione.implementazioneUtenteDAO().registrazioneUtente(utn);
					}
				}
			}
		});
		txtRipetiPassword.setFont(new Font("Arial", Font.PLAIN, 12));
		txtRipetiPassword.setBorder(null);
		txtRipetiPassword.setBackground(sfondo);
		txtRipetiPassword.setForeground(scritte);
		txtRipetiPassword.setBounds(80, 530, 340, 23);
		add(txtRipetiPassword);

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
		lblmostraPassword.setBounds(430, 428, 20, 20);
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
		lblcensuraPassword.setBounds(430, 428, 20, 20);
		add(lblcensuraPassword);

		JLabel lblmostraRipetiPassword = new JLabel("");
		lblmostraRipetiPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblmostraRipetiPassword.setVisible(false);
				txtRipetiPassword.setEchoChar((char) 0);
			}
		});
		lblmostraRipetiPassword.setToolTipText("Mostra password");
		lblmostraRipetiPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblmostraRipetiPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblmostraRipetiPassword.setIcon(new ImageIcon(censuraPassword));
		lblmostraRipetiPassword.setBounds(430, 533, 20, 20);
		add(lblmostraRipetiPassword);

		JLabel lblcensuraRipetiPassword = new JLabel("");
		lblcensuraRipetiPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblmostraRipetiPassword.setVisible(true);
				txtRipetiPassword.setEchoChar('●');
			}
		});
		lblcensuraRipetiPassword.setToolTipText("Nascondi password");
		lblcensuraRipetiPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblcensuraRipetiPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblcensuraRipetiPassword.setIcon(new ImageIcon(mostraPassword));
		lblcensuraRipetiPassword.setBounds(430, 533, 20, 20);
		add(lblcensuraRipetiPassword);
		
		JLabel lblRegistrati = new JLabel("");
		lblRegistrati.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblRegistrati.setIcon(new ImageIcon(avanti2));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblRegistrati.setIcon(new ImageIcon(avanti1));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (formatoEmailInseritaErrato()) {
					Utente utn = new Utente(getTxtNome().getText(), getTxtCognome().getText(), getTxtEmail().getText(), getTxtPassword().getText());
					controllerRegistrazione.implementazioneUtenteDAO().registrazioneUtente(utn);
					controller.vaiAdAccessoDopoRegistrazione();
				}
			}
		});
		lblRegistrati.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblRegistrati.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrati.setIcon(new ImageIcon(avanti1));
		lblRegistrati.setBackground(new Color(0, 0, 0, 0));
		lblRegistrati.setBounds(620, 500, 196, 50);
		add(lblRegistrati);
		

		JLabel lblInserimentoCredenziali = new JLabel("");
		lblInserimentoCredenziali.setHorizontalAlignment(SwingConstants.CENTER);
		lblInserimentoCredenziali.setIcon(new ImageIcon(inserimentoCredenziali));
		lblInserimentoCredenziali.setBounds(80, 85, 370, 470);
		add(lblInserimentoCredenziali);

		JLabel lblRegistrazione = new JLabel("REGISTRAZIONE");
		lblRegistrazione.setFont(new Font("Arial", Font.BOLD, 27));
		lblRegistrazione.setForeground(scritte);
		lblRegistrazione.setBounds(80, 30, 233, 30);
		add(lblRegistrazione);

	}
	
	// METODI

	public boolean formatoEmailInseritaErrato() {
		boolean emailCorretta = controllerRegistrazione.controlloInserimentoEmailCorrettamenteRegistrazione(getTxtEmail().getText());

		if (emailCorretta) {
			controllerRegistrazione.vaiAdAccessoDopoRegistrazione();
			return true;
		} else {
			JOptionPane.showMessageDialog(null,
					"Formato email inserito non valido!\n" + "Inserire l'email dal formato tipo: example@example.com");
			return false;
		}
	}
}
