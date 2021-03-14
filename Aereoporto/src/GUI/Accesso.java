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
	private JLabel lblCredenziali;
	private JLabel lblAvanti;
	private JLabel lblMessaggioCredenziali;
	private JLabel lblPasswordDimenticata;
	private JLabel lblMostraPassword;
	private JLabel lblCensuraPassword;
	private JLabel lblMostraPasswordTT;
	private JLabel lblCensuraPasswordTT;
	private boolean sbloccaHome = false;
	
	// GETTER E SETTER

	public JLabel getLblCredenziali() {
		return lblCredenziali;
	}

	public void setLblCredenziali(JLabel lblCredenziali) {
		this.lblCredenziali = lblCredenziali;
	}

	public JLabel getLblAvanti() {
		return lblAvanti;
	}

	public void setLblAvanti(JLabel lblAvanti) {
		this.lblAvanti = lblAvanti;
	}

	public JLabel getLblPasswordDimenticata() {
		return lblPasswordDimenticata;
	}

	public void setLblPasswordDimenticata(JLabel lblPasswordDimenticata) {
		this.lblPasswordDimenticata = lblPasswordDimenticata;
	}

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

	public JLabel getLblMostraPasswordTT() {
		return lblMostraPasswordTT;
	}

	public void setLblMostraPasswordTT(JLabel lblMostraPasswordAccessoTT) {
		this.lblMostraPasswordTT = lblMostraPasswordAccessoTT;
	}

	public JLabel getLblCensuraPasswordTT() {
		return lblCensuraPasswordTT;
	}

	public void setLblCensuraPasswordTT(JLabel lblCensuraPasswordAccessoTT) {
		this.lblCensuraPasswordTT = lblCensuraPasswordAccessoTT;
	}

	Controller controllerAccesso;
	
	public Accesso(Controller controller) {
		controllerAccesso = controller;

		setBounds(0, 0, 1093, 642);
		setBackground(controllerAccesso.sfondoTemaScuro);
		setLayout(null);

		txtEmail = new JTextField();
		txtEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent EventoInvio) {
				if (EventoInvio.getKeyCode() == KeyEvent.VK_ENTER) {
					controllerAccesso.controlloAccessoGiaEseguito();
				}
			}
		});
		txtEmail.setBackground(controllerAccesso.sfondoTemaScuro);
		txtEmail.setForeground(controllerAccesso.coloreScritteTemaScuro);
		txtEmail.setFont(controllerAccesso.fontScritte);
		txtEmail.setHorizontalAlignment(SwingConstants.LEFT);
		txtEmail.setBounds(375, 253, 320, 22);
		txtEmail.setColumns(10);
		txtEmail.setBorder(null);
		add(txtEmail);

		txtPassword = new JPasswordField();
		txtPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent EventoInvio) {
				if (EventoInvio.getKeyCode() == KeyEvent.VK_ENTER) {
					controllerAccesso.controlloAccessoGiaEseguito();
				}
			}
		});

		txtPassword.setBackground(controllerAccesso.sfondoTemaScuro);
		txtPassword.setHorizontalAlignment(SwingConstants.LEFT);
		txtPassword.setFont(controllerAccesso.fontScritte);
		txtPassword.setForeground(controllerAccesso.coloreScritteTemaScuro);
		txtPassword.setBounds(375, 357, 320, 22);
		txtPassword.setBorder(null);
		add(txtPassword);

		lblMostraPassword = new JLabel("");
		lblMostraPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerAccesso.chiudiMostraPasswordTT(lblMostraPasswordTT);
				lblMostraPassword.setVisible(false);
				txtPassword.setEchoChar((char) 0);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				controllerAccesso.setStopMostraPasswordTT(false);
				controllerAccesso.mostraMostraPasswordTT(lblMostraPasswordTT);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				controllerAccesso.setStopMostraPasswordTT(true);
				controllerAccesso.chiudiMostraPasswordTT(lblMostraPasswordTT);

			}
		});
		lblMostraPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblMostraPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblMostraPassword.setIcon(new ImageIcon(img.censuraPassword()));
		lblMostraPassword.setBounds(697, 356, 20, 20);
		add(lblMostraPassword);

		lblCensuraPassword = new JLabel("");
		lblCensuraPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerAccesso.chiudiCensuraPasswordTT(lblMostraPasswordTT);
				lblMostraPassword.setVisible(true);
				txtPassword.setEchoChar('●');
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				controllerAccesso.setStopCensuraPasswordTT(false);
				controllerAccesso.mostraCensuraPasswordTT(lblCensuraPasswordTT);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				controllerAccesso.setStopCensuraPasswordTT(true);
				controllerAccesso.chiudiCensuraPasswordTT(lblCensuraPasswordTT);
			}
		});
		lblCensuraPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblCensuraPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblCensuraPassword.setIcon(new ImageIcon(img.mostraPassword()));
		lblCensuraPassword.setBounds(697, 356, 20, 20);
		add(lblCensuraPassword);

		lblCredenziali = new JLabel("");
		lblCredenziali.setHorizontalAlignment(SwingConstants.CENTER);
		lblCredenziali.setIcon(new ImageIcon(img.credenzialiAccesso()));
		lblCredenziali.setBounds(374, 226, 344, 159);
		add(lblCredenziali);

		lblAvanti = new JLabel("");
		lblAvanti.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerAccesso.controlloAccessoGiaEseguito();
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				controllerAccesso.cambioImmagineTema(lblAvanti, img.avanti2TemaChiaro(), img.avanti2());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerAccesso.cambioImmagineTema(lblAvanti, img.avanti1TemaChiaro(), img.avanti1());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				controllerAccesso.cambioImmagineTema(lblAvanti, img.avanti3TemaChiaro(), img.avanti3());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				controllerAccesso.cambioImmagineTema(lblAvanti, img.avanti1TemaChiaro(), img.avanti1());
			}
		});
		lblAvanti.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAvanti.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvanti.setIcon(new ImageIcon(img.avanti1()));
		lblAvanti.setBackground(controllerAccesso.trasparente);
		lblAvanti.setBounds(387, 472, 319, 36);
		add(lblAvanti);

		lblMessaggioCredenziali = new JLabel("");
		lblMessaggioCredenziali.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessaggioCredenziali.setFont(controllerAccesso.fontLabel);
		lblMessaggioCredenziali.setForeground(controllerAccesso.coloreScritturaAllertaTemaScuro);
		lblMessaggioCredenziali.setBounds(356, 420, 380, 14);
		add(lblMessaggioCredenziali);

		lblPasswordDimenticata = new JLabel("Password dimenticata?");

		lblPasswordDimenticata.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerAccesso.mostraPasswordDimenticata();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				controllerAccesso.cambioLabelTema(lblPasswordDimenticata, controllerAccesso.coloreLabelEntrataTemaChiaro, controllerAccesso.coloreLabelEntrataTemaScuro);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerAccesso.cambioLabelTema(lblPasswordDimenticata, controllerAccesso.coloreLabelTemaChiaro, controllerAccesso.coloreLabelTemaScuro);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				controllerAccesso.cambioLabelTema(lblPasswordDimenticata, controllerAccesso.coloreLabelPressedTemaChiaro, controllerAccesso.coloreLabelPressedTemaScuro);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				controllerAccesso.cambioLabelTema(lblPasswordDimenticata, controllerAccesso.coloreLabelTemaChiaro, controllerAccesso.coloreLabelTemaScuro);
			}
		});
		lblPasswordDimenticata.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblPasswordDimenticata.setForeground(controllerAccesso.coloreLabelTemaScuro);
		lblPasswordDimenticata.setFont(controllerAccesso.fontLabel);
		lblPasswordDimenticata.setHorizontalAlignment(SwingConstants.CENTER);
		lblPasswordDimenticata.setBounds(577, 396, 141, 14);
		add(lblPasswordDimenticata);
		
		lblMostraPasswordTT = new JLabel("");
		lblMostraPasswordTT.setHorizontalAlignment(SwingConstants.CENTER);
		lblMostraPasswordTT.setBounds(741, 348, 123, 31);
		add(lblMostraPasswordTT);
		
		lblCensuraPasswordTT = new JLabel("");
		lblCensuraPasswordTT.setHorizontalAlignment(SwingConstants.CENTER);
		lblCensuraPasswordTT.setBounds(741, 348, 123, 31);
		add(lblCensuraPasswordTT);

	}

	// METODI
	public void mostraInserimentoCredenziali() {
		lblMessaggioCredenziali.setText("Perfavore, inserisci le credenziali");
	}

	public void mostraErroreAccesso() {
		lblMessaggioCredenziali.setText("Nome utente o password errati. Riprova");
	}

	public void mostraEseguirePrimaLogout() {
		lblMessaggioCredenziali.setText("Devi effettuare il logout se vuoi accedere con altre credenziali.");
	}

	public void mostraGiaUtilizziAccount() {
		lblMessaggioCredenziali.setText("Stai già utilizzando questo account.");
	}
}