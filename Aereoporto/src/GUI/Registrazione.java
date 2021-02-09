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

	// GETTER E SETTER

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

	Controller controllerRegistrazione;

	public Registrazione(Controller controller) {
		controllerRegistrazione = controller;

		setBounds(0, 0, 1090, 642);
		setBackground(controllerRegistrazione.sfondo);
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
		txtNome.setFont(controllerRegistrazione.fontScritteJDialog);
		txtNome.setColumns(10);
		txtNome.setBorder(null);
		txtNome.setBackground(controllerRegistrazione.sfondo);
		txtNome.setForeground(controllerRegistrazione.coloreScritte);
		txtNome.setBounds(638, 65, 340, 23);
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
		txtCognome.setFont(controllerRegistrazione.fontScritteJDialog);
		txtCognome.setColumns(10);
		txtCognome.setBorder(null);
		txtCognome.setBackground(controllerRegistrazione.sfondo);
		txtCognome.setForeground(controllerRegistrazione.coloreScritte);
		txtCognome.setBounds(638, 169, 340, 23);
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
		txtEmail.setFont(controllerRegistrazione.fontScritteJDialog);
		txtEmail.setColumns(10);
		txtEmail.setBorder(null);
		txtEmail.setBackground(controllerRegistrazione.sfondo);
		txtEmail.setForeground(controllerRegistrazione.coloreScritte);
		txtEmail.setBounds(638, 273, 340, 23);
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
		txtPassword.setFont(controllerRegistrazione.fontScritteJDialog);
		txtPassword.setBorder(null);
		txtPassword.setBackground(controllerRegistrazione.sfondo);
		txtPassword.setForeground(controllerRegistrazione.coloreScritte);
		txtPassword.setBounds(638, 377, 340, 23);
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
		txtRipetiPassword.setFont(controllerRegistrazione.fontScritteJDialog);
		txtRipetiPassword.setBorder(null);
		txtRipetiPassword.setBackground(controllerRegistrazione.sfondo);
		txtRipetiPassword.setForeground(controllerRegistrazione.coloreScritte);
		txtRipetiPassword.setBounds(638, 482, 340, 23);
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
		lblmostraPassword.setIcon(new ImageIcon(img.censuraPassword()));
		lblmostraPassword.setBounds(988, 380, 20, 20);
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
		lblcensuraPassword.setBounds(988, 380, 20, 20);
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
		lblmostraRipetiPassword.setIcon(new ImageIcon(img.censuraPassword()));
		lblmostraRipetiPassword.setBounds(988, 485, 20, 20);
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
		lblcensuraRipetiPassword.setIcon(new ImageIcon(img.mostraPassword()));
		lblcensuraRipetiPassword.setBounds(988, 485, 20, 20);
		add(lblcensuraRipetiPassword);

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
				controllerRegistrazione.registrati();
			}
			@Override
			public void mousePressed(MouseEvent e) {
				lblAvanti.setIcon(new ImageIcon(img.avanti3()));

			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lblAvanti.setIcon(new ImageIcon(img.avanti1()));

			}
		});
		lblAvanti.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAvanti.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvanti.setIcon(new ImageIcon(img.avanti1()));
		lblAvanti.setBackground(controllerRegistrazione.trasparente);
		lblAvanti.setBounds(736, 548, 174, 47);
		add(lblAvanti);

		JLabel lblInserimentoCredenziali = new JLabel("");
		lblInserimentoCredenziali.setHorizontalAlignment(SwingConstants.CENTER);
		lblInserimentoCredenziali.setIcon(new ImageIcon(img.inserimentoCredenzialiRegistrazione()));
		lblInserimentoCredenziali.setBounds(638, 37, 370, 470);
		add(lblInserimentoCredenziali);

		lblMessaggioCredenziali = new JLabel("");
		lblMessaggioCredenziali.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessaggioCredenziali.setFont(controllerRegistrazione.fontScritte);
		lblMessaggioCredenziali.setForeground(controllerRegistrazione.coloreScritturaAllerta);
		lblMessaggioCredenziali.setBounds(638, 516, 370, 28);
		add(lblMessaggioCredenziali);
	}

	// METODI

	

	
}
