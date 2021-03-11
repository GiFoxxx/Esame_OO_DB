package GUI;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.SwingConstants;

import Controller.Controller;
import Immagini.Immagini;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Registrazione extends JPanel {

	private Immagini img = new Immagini();

	private JTextField txtNome;
	private JTextField txtCognome;
	private JTextField txtEmail;
	private JPasswordField txtPassword;
	private JPasswordField txtRipetiPassword;
	private JLabel lblMessaggioCredenziali;
	private JLabel lblAvanti;
	private JLabel lblInserimentoCredenziali;
	private JLabel lblMostraPassword;
	private JLabel lblCensuraPassword;
	private JLabel lblMostraRipetiPassword;
	private JLabel lblCensuraRipetiPassword;
	
	// GETTER E SETTER

	public JLabel getLblAvanti() {
		return lblAvanti;
	}

	public void setLblAvanti(JLabel lblAvanti) {
		this.lblAvanti = lblAvanti;
	}

	public JLabel getLblInserimentoCredenziali() {
		return lblInserimentoCredenziali;
	}

	public void setLblInserimentoCredenziali(JLabel lblInserimentoCredenziali) {
		this.lblInserimentoCredenziali = lblInserimentoCredenziali;
	}

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

	public JLabel getLblMessaggioCredenziali() {
		return lblMessaggioCredenziali;
	}

	public void setLblMessaggioCredenziali(JLabel lblMessaggioCredenziali) {
		this.lblMessaggioCredenziali = lblMessaggioCredenziali;
	}

	public JLabel getLblMostraPassword() {
		return lblMostraPassword;
	}

	public void setLblMostraPassword(JLabel lblmostraPassword) {
		this.lblMostraPassword = lblmostraPassword;
	}

	public JLabel getLblCensuraPassword() {
		return lblCensuraPassword;
	}

	public void setLblCensuraPassword(JLabel lblcensuraPassword) {
		this.lblCensuraPassword = lblcensuraPassword;
	}

	public JLabel getLblMostraRipetiPassword() {
		return lblMostraRipetiPassword;
	}

	public void setLblMostraRipetiPassword(JLabel lblmostraRipetiPassword) {
		this.lblMostraRipetiPassword = lblmostraRipetiPassword;
	}

	public JLabel getLblCensuraRipetiPassword() {
		return lblCensuraRipetiPassword;
	}

	public void setLblCensuraRipetiPassword(JLabel lblcensuraRipetiPassword) {
		this.lblCensuraRipetiPassword = lblcensuraRipetiPassword;
	}

	Controller controllerRegistrazione;

	public Registrazione(Controller controller) {
		controllerRegistrazione = controller;

		setBounds(0, 0, 1090, 642);
		setBackground(controllerRegistrazione.sfondoTemaScuro);
		setLayout(null);

		txtNome = new JTextField();
		txtNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent EventoInvio) {
				if (EventoInvio.getKeyCode() == KeyEvent.VK_ENTER) {
					controllerRegistrazione.registrati();
				}
			}
		});
		txtNome.setFont(controllerRegistrazione.fontScritte);
		txtNome.setColumns(10);
		txtNome.setBorder(null);
		txtNome.setBackground(controllerRegistrazione.sfondoTemaScuro);
		txtNome.setForeground(controllerRegistrazione.coloreScritteTemaScuro);
		txtNome.setBounds(374, 65, 340, 23);
		add(txtNome);

		txtCognome = new JTextField();
		txtCognome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent EventoInvio) {
				if (EventoInvio.getKeyCode() == KeyEvent.VK_ENTER) {
					controllerRegistrazione.registrati();
				}
			}
		});
		txtCognome.setFont(controllerRegistrazione.fontScritte);
		txtCognome.setColumns(10);
		txtCognome.setBorder(null);
		txtCognome.setBackground(controllerRegistrazione.sfondoTemaScuro);
		txtCognome.setForeground(controllerRegistrazione.coloreScritteTemaScuro);
		txtCognome.setBounds(374, 170, 340, 23);
		add(txtCognome);

		txtEmail = new JTextField();
		txtEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent EventoInvio) {
				if (EventoInvio.getKeyCode() == KeyEvent.VK_ENTER) {
					controllerRegistrazione.registrati();
				}
			}
		});
		txtEmail.setFont(controllerRegistrazione.fontScritte);
		txtEmail.setColumns(10);
		txtEmail.setBorder(null);
		txtEmail.setBackground(controllerRegistrazione.sfondoTemaScuro);
		txtEmail.setForeground(controllerRegistrazione.coloreScritteTemaScuro);
		txtEmail.setBounds(374, 275, 340, 23);
		add(txtEmail);

		txtPassword = new JPasswordField();
		txtPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent EventoInvio) {
				if (EventoInvio.getKeyCode() == KeyEvent.VK_ENTER) {
					controllerRegistrazione.registrati();
				}
			}
		});
		txtPassword.setFont(controllerRegistrazione.fontScritte);
		txtPassword.setBorder(null);
		txtPassword.setBackground(controllerRegistrazione.sfondoTemaScuro);
		txtPassword.setForeground(controllerRegistrazione.coloreScritteTemaScuro);
		txtPassword.setBounds(374, 380, 310, 23);
		add(txtPassword);

		txtRipetiPassword = new JPasswordField();
		txtRipetiPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent EventoInvio) {
				if (EventoInvio.getKeyCode() == KeyEvent.VK_ENTER) {
					controllerRegistrazione.registrati();
				}
			}
		});
		txtRipetiPassword.setFont(controllerRegistrazione.fontScritte);
		txtRipetiPassword.setBorder(null);
		txtRipetiPassword.setBackground(controllerRegistrazione.sfondoTemaScuro);
		txtRipetiPassword.setForeground(controllerRegistrazione.coloreScritteTemaScuro);
		txtRipetiPassword.setBounds(374, 485, 310, 23);
		add(txtRipetiPassword);

		lblMostraPassword = new JLabel("");
		lblMostraPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblMostraPassword.setVisible(false);
				txtPassword.setEchoChar((char) 0);
			}
		});
		lblMostraPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblMostraPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblMostraPassword.setIcon(new ImageIcon(img.censuraPassword()));
		lblMostraPassword.setBounds(693, 380, 20, 20);
		add(lblMostraPassword);

		lblCensuraPassword = new JLabel("");
		lblCensuraPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblMostraPassword.setVisible(true);
				txtPassword.setEchoChar('●');
			}
		});
		lblCensuraPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblCensuraPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblCensuraPassword.setIcon(new ImageIcon(img.mostraPassword()));
		lblCensuraPassword.setBounds(693, 380, 20, 20);
		add(lblCensuraPassword);

		lblMostraRipetiPassword = new JLabel("");
		lblMostraRipetiPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblMostraRipetiPassword.setVisible(false);
				txtRipetiPassword.setEchoChar((char) 0);
			}
		});
		lblMostraRipetiPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblMostraRipetiPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblMostraRipetiPassword.setIcon(new ImageIcon(img.censuraPassword()));
		lblMostraRipetiPassword.setBounds(693, 485, 20, 20);
		add(lblMostraRipetiPassword);

		lblCensuraRipetiPassword = new JLabel("");
		lblCensuraRipetiPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblMostraRipetiPassword.setVisible(true);
				txtRipetiPassword.setEchoChar('●');
			}
		});
		lblCensuraRipetiPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblCensuraRipetiPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblCensuraRipetiPassword.setIcon(new ImageIcon(img.mostraPassword()));
		lblCensuraRipetiPassword.setBounds(693, 485, 20, 20);
		add(lblCensuraRipetiPassword);

		lblAvanti = new JLabel("");
		lblAvanti.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				controllerRegistrazione.cambioImmagineTema(lblAvanti, img.avanti2TemaChiaro(), img.avanti2());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerRegistrazione.cambioImmagineTema(lblAvanti, img.avanti1TemaChiaro(), img.avanti1());
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				controllerRegistrazione.registrati();
			}
			@Override
			public void mousePressed(MouseEvent e) {
				controllerRegistrazione.cambioImmagineTema(lblAvanti, img.avanti3TemaChiaro(), img.avanti3());
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				controllerRegistrazione.cambioImmagineTema(lblAvanti, img.avanti2TemaChiaro(), img.avanti2());
			}
		});
		lblAvanti.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAvanti.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvanti.setIcon(new ImageIcon(img.avanti1()));
		lblAvanti.setBackground(controllerRegistrazione.trasparente);
		lblAvanti.setBounds(386, 568, 319, 36);
		add(lblAvanti);

		lblInserimentoCredenziali = new JLabel("");
		lblInserimentoCredenziali.setHorizontalAlignment(SwingConstants.CENTER);
		lblInserimentoCredenziali.setIcon(new ImageIcon(img.credenzialiRegistrazione()));
		lblInserimentoCredenziali.setBounds(373, 37, 344, 473);
		add(lblInserimentoCredenziali);

		lblMessaggioCredenziali = new JLabel("");
		lblMessaggioCredenziali.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessaggioCredenziali.setFont(controllerRegistrazione.fontLabel);
		lblMessaggioCredenziali.setForeground(controllerRegistrazione.coloreScritturaAllertaTemaScuro);
		lblMessaggioCredenziali.setBounds(269, 526, 553, 14);
		add(lblMessaggioCredenziali);
	}
	
}
