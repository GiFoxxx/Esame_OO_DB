package GUI;

import javax.swing.JPanel;

import Controller.Controller;
import Immagini.Immagini;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Color;

public class Accesso extends JPanel {

	private Immagini img = new Immagini();

	private JTextField txtEmail;
	private JPasswordField txtPassword;
	private JLabel lblMessaggioCredenziali;
	private boolean sbloccaHome = false;

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

	public JLabel getLblMessaggioCredenziali() {
		return lblMessaggioCredenziali;
	}

	public void setLblMessaggioCredenziali(JLabel lblMessaggioCredenziali) {
		this.lblMessaggioCredenziali = lblMessaggioCredenziali;
	}

	public boolean isSbloccaHome() {
		return sbloccaHome;
	}

	public void setSbloccaHome(boolean sbloccaHome) {
		this.sbloccaHome = sbloccaHome;
	}

	Controller controllerAccesso;

	public Accesso(Controller controller) {
		controllerAccesso = controller;

		setBounds(0, 0, 1090, 642);
		setBackground(controllerAccesso.sfondo);
		setLayout(null);

		txtEmail = new JTextField();
		txtEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent EventoInvio) {
				if (EventoInvio.getKeyCode() == KeyEvent.VK_ENTER) {
					controllerAccesso.accedi();
				}
			}
		});
		txtEmail.setBackground(controllerAccesso.sfondo);
		txtEmail.setForeground(controllerAccesso.coloreScritte);
		txtEmail.setFont(controllerAccesso.fontScritteJDialog);
		txtEmail.setHorizontalAlignment(SwingConstants.LEFT);
		txtEmail.setBounds(478, 251, 320, 22);
		txtEmail.setColumns(10);
		txtEmail.setBorder(null);
		add(txtEmail);

		txtPassword = new JPasswordField();
		txtPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent EventoInvio) {
				if (EventoInvio.getKeyCode() == KeyEvent.VK_ENTER) {
					controllerAccesso.accedi();
				}
			}
		});

		txtPassword.setBackground(controllerAccesso.sfondo);
		txtPassword.setHorizontalAlignment(SwingConstants.LEFT);
		txtPassword.setFont(controllerAccesso.fontScritteJDialog);
		txtPassword.setForeground(controllerAccesso.coloreScritte);
		txtPassword.setBounds(478, 355, 320, 22);
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
		lblmostraPassword.setBounds(802, 356, 20, 20);
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
		lblcensuraPassword.setBounds(802, 356, 20, 20);
		add(lblcensuraPassword);

		JLabel lblCredenziali = new JLabel("");
		lblCredenziali.setHorizontalAlignment(SwingConstants.CENTER);
		lblCredenziali.setIcon(new ImageIcon(Accesso.class.getResource("/GUI/immaginiAccesso/credenziali.png")));
		lblCredenziali.setBounds(478, 221, 344, 159);
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
				controllerAccesso.accedi();
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
		lblAvanti.setBackground(controllerAccesso.trasparente);
		lblAvanti.setBounds(563, 479, 174, 47);
		add(lblAvanti);

		lblMessaggioCredenziali = new JLabel("");
		lblMessaggioCredenziali.setHorizontalAlignment(SwingConstants.LEFT);
		lblMessaggioCredenziali.setFont(controllerAccesso.fontLabel);
		lblMessaggioCredenziali.setForeground(controllerAccesso.coloreScritturaAllerta);
		lblMessaggioCredenziali.setBounds(478, 412, 344, 14);
		add(lblMessaggioCredenziali);
		
		JLabel lblPasswordDimenticata = new JLabel("Password dimenticata?");
		lblPasswordDimenticata.setForeground(Color.LIGHT_GRAY);
		lblPasswordDimenticata.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerAccesso.mostraPasswordDimenticata();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblPasswordDimenticata.setForeground(controllerAccesso.coloreLabelEntrata);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblPasswordDimenticata.setForeground(controllerAccesso.coloreLabel);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				lblPasswordDimenticata.setForeground(controllerAccesso.coloreLabelPressed);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lblPasswordDimenticata.setForeground(controllerAccesso.coloreLabel);				
			}
		});
		lblPasswordDimenticata.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblPasswordDimenticata.setForeground(controllerAccesso.coloreLabel);
		lblPasswordDimenticata.setFont(controllerAccesso.fontLabel);
		lblPasswordDimenticata.setHorizontalAlignment(SwingConstants.CENTER);
		lblPasswordDimenticata.setBounds(681, 388, 141, 14);
		add(lblPasswordDimenticata);

	}

	// METODI
	
	public void mostraInserimentoCredenziali() {
		lblMessaggioCredenziali.setText("Perfavore, inserisci le credenziali");
	}

	public void mostraErroreAccesso() {
		lblMessaggioCredenziali.setText("Nome utente o password errati. Riprova");
	}
}