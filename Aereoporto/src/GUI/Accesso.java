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

public class Accesso extends JPanel {
	Immagini img = new Immagini();

	private JTextField txtEmail;
	private JPasswordField txtPassword;
	private JLabel lblCredenziali;
	private JLabel lblAvanti;
	private JLabel lblPasswordDimenticata;
	private JLabel lblMostraPassword;
	private JLabel lblCensuraPassword;
	private JLabel lblMostraPasswordTT;
	private JLabel lblCensuraPasswordTT;
	private JLabel lblIconaErrore;
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

	public JLabel getLblIconaErrore() {
		return lblIconaErrore;
	}

	public void setLblIconaErrore(JLabel lblIconaErrore) {
		this.lblIconaErrore = lblIconaErrore;
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

			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() != KeyEvent.VK_ENTER) {
					lblIconaErrore.setVisible(false);
				}
			}
		});

		lblIconaErrore = new JLabel("");
		lblIconaErrore.setVisible(false);
		lblIconaErrore.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconaErrore.setIcon(new ImageIcon(img.errore()));
		lblIconaErrore.setBounds(697, 254, 20, 20);
		add(lblIconaErrore);

		txtEmail.setBackground(controllerAccesso.sfondoTemaScuro);
		txtEmail.setForeground(controllerAccesso.coloreScritteTemaScuro);
		txtEmail.setFont(controllerAccesso.fontScritte);
		txtEmail.setHorizontalAlignment(SwingConstants.LEFT);
		txtEmail.setBounds(377, 253, 318, 22);
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
		txtPassword.setBounds(377, 357, 318, 22);
		txtPassword.setBorder(null);
		add(txtPassword);

		lblMostraPassword = new JLabel("");
		lblMostraPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerAccesso.chiudiTT(lblMostraPasswordTT, controllerAccesso.isStopMostraPasswordTT());
				lblMostraPassword.setVisible(false);
				txtPassword.setEchoChar((char) 0);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				controllerAccesso.setStopMostraPasswordTT(false);
				controllerAccesso.mostraTT(lblMostraPasswordTT, controllerAccesso.isStopMostraPasswordTT(), img.mostraPasswordTTChiaro(), img.mostraPasswordTT());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerAccesso.setStopMostraPasswordTT(true);
				controllerAccesso.chiudiTT(lblMostraPasswordTT, controllerAccesso.isStopMostraPasswordTT());

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
				controllerAccesso.chiudiTT(lblCensuraPasswordTT, controllerAccesso.isStopCensuraPasswordTT());
				lblMostraPassword.setVisible(true);
				txtPassword.setEchoChar('●');
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				controllerAccesso.setStopCensuraPasswordTT(false);
				controllerAccesso.mostraTT(lblCensuraPasswordTT, controllerAccesso.isStopCensuraPasswordTT(), img.nascondiPasswordTTChiaro(), img.nascondiPasswordTT());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerAccesso.setStopCensuraPasswordTT(true);
				controllerAccesso.chiudiTT(lblCensuraPasswordTT, controllerAccesso.isStopCensuraPasswordTT());
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

		lblPasswordDimenticata = new JLabel("Password dimenticata?");
		lblPasswordDimenticata.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerAccesso.mostraPasswordDimenticata();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				controllerAccesso.cambioLabelTema(lblPasswordDimenticata,
						controllerAccesso.coloreLabelEntrataTemaChiaro, controllerAccesso.coloreLabelEntrataTemaScuro);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerAccesso.cambioLabelTema(lblPasswordDimenticata, controllerAccesso.coloreLabelTemaChiaro,
						controllerAccesso.coloreLabelTemaScuro);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				controllerAccesso.cambioLabelTema(lblPasswordDimenticata,
						controllerAccesso.coloreLabelPressedTemaChiaro, controllerAccesso.coloreLabelPressedTemaScuro);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				controllerAccesso.cambioLabelTema(lblPasswordDimenticata, controllerAccesso.coloreLabelTemaChiaro,
						controllerAccesso.coloreLabelTemaScuro);
			}
		});
		lblPasswordDimenticata.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblPasswordDimenticata.setForeground(controllerAccesso.coloreLabelTemaScuro);
		lblPasswordDimenticata.setFont(controllerAccesso.fontLabel);
		lblPasswordDimenticata.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPasswordDimenticata.setBounds(577, 396, 141, 14);
		add(lblPasswordDimenticata);

		lblMostraPasswordTT = new JLabel("");
		lblMostraPasswordTT.setHorizontalAlignment(SwingConstants.CENTER);
		lblMostraPasswordTT.setBounds(741, 348, 123, 31);
		add(lblMostraPasswordTT);

		lblCensuraPasswordTT = new JLabel("");
		lblCensuraPasswordTT.setHorizontalAlignment(SwingConstants.CENTER);
		lblCensuraPasswordTT.setBounds(741, 348, 130, 31);
		add(lblCensuraPasswordTT);

	}


}