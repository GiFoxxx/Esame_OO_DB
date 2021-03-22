package GUI;

import javax.swing.JPanel;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.SwingConstants;

import Controller.Controller;
import Immagini.Immagini;

import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CambioPassword extends JPanel {
	Immagini img = new Immagini();

	private JTextField txtVecchiaPassword;
	private JPasswordField txtNuovaPassword;
	private JPasswordField txtRipetiNuovaPassword;

	private JLabel lblMostraNuovaPassword;
	private JLabel lblCensuraNuovaPassword;
	private JLabel lblMostraRipetiNuovaPassword;
	private JLabel lblCensuraRipetiNuovaPassword;
	private JLabel lblCambioPassword;
	private JLabel lblPasswordDimenticata;
	private JLabel lblSalva;
	private JLabel lblAnnulla;
	private JLabel lblMostraNuovaPasswordTT;
	private JLabel lblCensuraNuovaPasswordTT;
	private JLabel lblMostraRipetiNuovaPasswordTT;
	private JLabel lblCensuraRipetiNuovaPasswordTT;
	private JLabel lblIconaErroreVecchiaPassword;

	// GETTER E SETTER

	public JLabel getLblSalva() {
		return lblSalva;
	}

	public void setLblSalva(JLabel lblSalva) {
		this.lblSalva = lblSalva;
	}

	public JLabel getLblAnnulla() {
		return lblAnnulla;
	}

	public void setLblAnnulla(JLabel lblAnnulla) {
		this.lblAnnulla = lblAnnulla;
	}

	public JLabel getLblMostraNuovaPassword() {
		return lblMostraNuovaPassword;
	}

	public void setLblMostraNuovaPassword(JLabel lblMostraNuovaPassword) {
		this.lblMostraNuovaPassword = lblMostraNuovaPassword;
	}

	public JLabel getLblCensuraNuovaPassword() {
		return lblCensuraNuovaPassword;
	}

	public void setLblCensuraNuovaPassword(JLabel lblCensuraNuovaPassword) {
		this.lblCensuraNuovaPassword = lblCensuraNuovaPassword;
	}

	public JLabel getLblMostraRipetiNuovaPassword() {
		return lblMostraRipetiNuovaPassword;
	}

	public void setLblMostraRipetiNuovaPassword(JLabel lblMostraRipetiNuovaPassword) {
		this.lblMostraRipetiNuovaPassword = lblMostraRipetiNuovaPassword;
	}

	public JLabel getLblCensuraRipetiNuovaPassword() {
		return lblCensuraRipetiNuovaPassword;
	}

	public void setLblCensuraRipetiNuovaPassword(JLabel lblCensuraRipetiNuovaPassword) {
		this.lblCensuraRipetiNuovaPassword = lblCensuraRipetiNuovaPassword;
	}

	public JLabel getLblCambioPassword() {
		return lblCambioPassword;
	}

	public void setLblCambioPassword(JLabel lblCambioPassword) {
		this.lblCambioPassword = lblCambioPassword;
	}

	public JTextField getTxtVecchiaPassword() {
		return txtVecchiaPassword;
	}

	public void setTxtVecchiaPassword(JTextField txtVecchiaPassword) {
		this.txtVecchiaPassword = txtVecchiaPassword;
	}

	public JPasswordField getTxtNuovaPassword() {
		return txtNuovaPassword;
	}

	public void setTxtNuovaPassword(JPasswordField txtNuovaPassword) {
		this.txtNuovaPassword = txtNuovaPassword;
	}

	public JPasswordField getTxtRipetiNuovaPassword() {
		return txtRipetiNuovaPassword;
	}

	public void setTxtRipetiNuovaPassword(JPasswordField txtRipetiNuovaPassword) {
		this.txtRipetiNuovaPassword = txtRipetiNuovaPassword;
	}

	public JLabel getLblPasswordDimenticata() {
		return lblPasswordDimenticata;
	}

	public void setLblPasswordDimenticata(JLabel lblPasswordDimenticata) {
		this.lblPasswordDimenticata = lblPasswordDimenticata;
	}

	public JLabel getLblMostraNuovaPasswordTT() {
		return lblMostraNuovaPasswordTT;
	}

	public void setLblMostraNuovaPasswordTT(JLabel lblMostraPasswordTT) {
		this.lblMostraNuovaPasswordTT = lblMostraPasswordTT;
	}

	public JLabel getLblCensuraNuovaPasswordTT() {
		return lblCensuraNuovaPasswordTT;
	}

	public void setLblCensuraNuovaPasswordTT(JLabel lblCensuraPasswordTT) {
		this.lblCensuraNuovaPasswordTT = lblCensuraPasswordTT;
	}

	public JLabel getLblMostraRipetiNuovaPasswordTT() {
		return lblMostraRipetiNuovaPasswordTT;
	}

	public void setLblMostraRipetiNuovaPasswordTT(JLabel lblMostraRipetiPasswordTT) {
		this.lblMostraRipetiNuovaPasswordTT = lblMostraRipetiPasswordTT;
	}

	public JLabel getLblCensuraRipetiNuovaPasswordTT() {
		return lblCensuraRipetiNuovaPasswordTT;
	}

	public void setLblCensuraRipetiNuovaPasswordTT(JLabel lblCensuraRipetiPasswordTT) {
		this.lblCensuraRipetiNuovaPasswordTT = lblCensuraRipetiPasswordTT;
	}

	public JLabel getLblIconaErroreVecchiaPassword() {
		return lblIconaErroreVecchiaPassword;
	}

	public void setLblIconaErroreVecchiaPassword(JLabel lblIconaErroreVecchiaPassword) {
		this.lblIconaErroreVecchiaPassword = lblIconaErroreVecchiaPassword;
	}

	Controller controllerCambioPassword;

	public CambioPassword(Controller controller) {
		controllerCambioPassword = controller;

		setBounds(0, 0, 1090, 634);
		setBackground(controllerCambioPassword.sfondoTemaScuro);
		setLayout(null);

		txtVecchiaPassword = new JTextField();
		txtVecchiaPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent EventoInvio) {
				if (EventoInvio.getKeyCode() == KeyEvent.VK_ENTER) {
					controllerCambioPassword.cambioPasswordDaProfilo();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() != KeyEvent.VK_ENTER) {
					lblIconaErroreVecchiaPassword.setVisible(false);
				}
			}
		});

		lblIconaErroreVecchiaPassword = new JLabel("");
		lblIconaErroreVecchiaPassword.setVisible(false);
		lblIconaErroreVecchiaPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconaErroreVecchiaPassword.setIcon(new ImageIcon(img.errore()));
		lblIconaErroreVecchiaPassword.setBounds(684, 176, 20, 20);
		add(lblIconaErroreVecchiaPassword);
		txtVecchiaPassword.setBorder(null);
		txtVecchiaPassword.setFont(controllerCambioPassword.fontScritte);
		txtVecchiaPassword.setBackground(controllerCambioPassword.sfondoTemaScuro);
		txtVecchiaPassword.setForeground(controllerCambioPassword.coloreScritteTemaScuro);
		txtVecchiaPassword.setBounds(361, 175, 304, 23);
		txtVecchiaPassword.setColumns(10);
		add(txtVecchiaPassword);

		txtNuovaPassword = new JPasswordField();
		txtNuovaPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent EventoInvio) {
				if (EventoInvio.getKeyCode() == KeyEvent.VK_ENTER) {
					controllerCambioPassword.cambioPasswordDaProfilo();
				}
			}
		});
		txtNuovaPassword.setBorder(null);
		txtNuovaPassword.setFont(controllerCambioPassword.fontScritte);
		txtNuovaPassword.setBackground(controllerCambioPassword.sfondoTemaScuro);
		txtNuovaPassword.setForeground(controllerCambioPassword.coloreScritteTemaScuro);
		txtNuovaPassword.setBounds(361, 279, 304, 23);
		add(txtNuovaPassword);

		txtRipetiNuovaPassword = new JPasswordField();
		txtRipetiNuovaPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent EventoInvio) {
				if (EventoInvio.getKeyCode() == KeyEvent.VK_ENTER) {
					controllerCambioPassword.cambioPasswordDaProfilo();
				}
			}
		});
		txtRipetiNuovaPassword.setBorder(null);
		txtRipetiNuovaPassword.setFont(controllerCambioPassword.fontScritte);
		txtRipetiNuovaPassword.setBackground(controllerCambioPassword.sfondoTemaScuro);
		txtRipetiNuovaPassword.setForeground(controllerCambioPassword.coloreScritteTemaScuro);
		txtRipetiNuovaPassword.setBounds(361, 384, 314, 23);
		add(txtRipetiNuovaPassword);

		lblMostraNuovaPassword = new JLabel("");
		lblMostraNuovaPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblMostraNuovaPassword.setVisible(false);
				txtNuovaPassword.setEchoChar((char) 0);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				controllerCambioPassword.setStopMostraPasswordTT(false);
				controllerCambioPassword.mostraTT(lblMostraNuovaPasswordTT,
						controllerCambioPassword.isStopMostraPasswordTT(), img.mostraPasswordTTChiaro(),
						img.mostraPasswordTT());

			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerCambioPassword.setStopMostraPasswordTT(true);
				controllerCambioPassword.chiudiTT(lblMostraNuovaPasswordTT,
						controllerCambioPassword.isStopMostraPasswordTT());
			}
		});
		lblMostraNuovaPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblMostraNuovaPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblMostraNuovaPassword.setIcon(new ImageIcon(img.censuraPassword()));
		lblMostraNuovaPassword.setBounds(684, 282, 20, 20);
		add(lblMostraNuovaPassword);

		lblCensuraNuovaPassword = new JLabel("");
		lblCensuraNuovaPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblMostraNuovaPassword.setVisible(true);
				txtNuovaPassword.setEchoChar('●');
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				controllerCambioPassword.setStopCensuraPasswordTT(false);
				controllerCambioPassword.mostraTT(lblCensuraNuovaPasswordTT,
						controllerCambioPassword.isStopCensuraPasswordTT(), img.nascondiPasswordTTChiaro(),
						img.nascondiPasswordTT());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerCambioPassword.setStopCensuraPasswordTT(true);
				controllerCambioPassword.chiudiTT(lblCensuraNuovaPasswordTT,
						controllerCambioPassword.isStopCensuraPasswordTT());
			}
		});
		lblCensuraNuovaPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblCensuraNuovaPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblCensuraNuovaPassword.setIcon(new ImageIcon(img.mostraPassword()));
		lblCensuraNuovaPassword.setBounds(684, 282, 20, 20);
		add(lblCensuraNuovaPassword);

		lblMostraRipetiNuovaPassword = new JLabel("");
		lblMostraRipetiNuovaPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblMostraRipetiNuovaPassword.setVisible(false);
				txtRipetiNuovaPassword.setEchoChar((char) 0);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				controllerCambioPassword.setStopMostraPasswordTT(false);
				controllerCambioPassword.mostraTT(lblMostraRipetiNuovaPasswordTT,
						controllerCambioPassword.isStopMostraPasswordTT(), img.mostraPasswordTTChiaro(),
						img.mostraPasswordTT());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerCambioPassword.setStopMostraPasswordTT(true);
				controllerCambioPassword.chiudiTT(lblMostraRipetiNuovaPasswordTT,
						controllerCambioPassword.isStopMostraPasswordTT());
			}
		});
		lblMostraRipetiNuovaPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblMostraRipetiNuovaPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblMostraRipetiNuovaPassword.setIcon(new ImageIcon(img.censuraPassword()));
		lblMostraRipetiNuovaPassword.setBounds(684, 387, 20, 20);
		add(lblMostraRipetiNuovaPassword);

		lblCensuraRipetiNuovaPassword = new JLabel("");
		lblCensuraRipetiNuovaPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblMostraRipetiNuovaPassword.setVisible(true);
				txtRipetiNuovaPassword.setEchoChar('●');
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				controllerCambioPassword.setStopCensuraPasswordTT(false);
				controllerCambioPassword.mostraTT(lblCensuraRipetiNuovaPasswordTT,
						controllerCambioPassword.isStopCensuraPasswordTT(), img.nascondiPasswordTTChiaro(),
						img.nascondiPasswordTT());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerCambioPassword.setStopCensuraPasswordTT(true);
				controllerCambioPassword.chiudiTT(lblCensuraRipetiNuovaPasswordTT,
						controllerCambioPassword.isStopCensuraPasswordTT());
			}
		});
		lblCensuraRipetiNuovaPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblCensuraRipetiNuovaPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblCensuraRipetiNuovaPassword.setIcon(new ImageIcon(img.mostraPassword()));
		lblCensuraRipetiNuovaPassword.setBounds(684, 387, 20, 20);
		add(lblCensuraRipetiNuovaPassword);

		lblMostraNuovaPasswordTT = new JLabel("");
		lblMostraNuovaPasswordTT.setHorizontalAlignment(SwingConstants.CENTER);
		lblMostraNuovaPasswordTT.setBounds(734, 272, 123, 31);
		add(lblMostraNuovaPasswordTT);

		lblCensuraNuovaPasswordTT = new JLabel("");
		lblCensuraNuovaPasswordTT.setHorizontalAlignment(SwingConstants.CENTER);
		lblCensuraNuovaPasswordTT.setBounds(734, 272, 130, 31);
		add(lblCensuraNuovaPasswordTT);

		lblMostraRipetiNuovaPasswordTT = new JLabel("");
		lblMostraRipetiNuovaPasswordTT.setHorizontalAlignment(SwingConstants.CENTER);
		lblMostraRipetiNuovaPasswordTT.setBounds(734, 379, 123, 31);
		add(lblMostraRipetiNuovaPasswordTT);

		lblCensuraRipetiNuovaPasswordTT = new JLabel("");
		lblCensuraRipetiNuovaPasswordTT.setHorizontalAlignment(SwingConstants.CENTER);
		lblCensuraRipetiNuovaPasswordTT.setBounds(734, 379, 130, 31);
		add(lblCensuraRipetiNuovaPasswordTT);

		lblCambioPassword = new JLabel("");
		lblCambioPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblCambioPassword.setIcon(new ImageIcon(img.cambioPassword()));
		lblCambioPassword.setBounds(360, 146, 344, 263);
		add(lblCambioPassword);

		lblPasswordDimenticata = new JLabel("Password dimenticata?");
		lblPasswordDimenticata.setForeground(Color.LIGHT_GRAY);
		lblPasswordDimenticata.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerCambioPassword.mostraPasswordDimenticata();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				controllerCambioPassword.cambioLabelTema(lblPasswordDimenticata,
						controllerCambioPassword.coloreLabelEntrataTemaChiaro,
						controllerCambioPassword.coloreLabelEntrataTemaScuro);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerCambioPassword.cambioLabelTema(lblPasswordDimenticata,
						controllerCambioPassword.coloreLabelTemaChiaro, controllerCambioPassword.coloreLabelTemaScuro);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				controllerCambioPassword.cambioLabelTema(lblPasswordDimenticata,
						controllerCambioPassword.coloreLabelPressedTemaChiaro,
						controllerCambioPassword.coloreLabelPressedTemaScuro);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				controllerCambioPassword.cambioLabelTema(lblPasswordDimenticata,
						controllerCambioPassword.coloreLabelTemaChiaro, controllerCambioPassword.coloreLabelTemaScuro);
			}
		});
		lblPasswordDimenticata.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblPasswordDimenticata.setForeground(controllerCambioPassword.coloreLabelTemaScuro);
		lblPasswordDimenticata.setFont(controllerCambioPassword.fontLabel);
		lblPasswordDimenticata.setHorizontalAlignment(SwingConstants.CENTER);
		lblPasswordDimenticata.setBounds(563, 418, 141, 14);
		add(lblPasswordDimenticata);

		lblSalva = new JLabel("");
		lblSalva.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblSalva.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalva.setIcon(new ImageIcon(img.salvaModifiche1()));
		lblSalva.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerCambioPassword.cambioPasswordDaProfilo();

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				controllerCambioPassword.cambioImmagineTema(lblSalva, img.salvaModifiche2TemaChiaro(),
						img.salvaModifiche2());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerCambioPassword.cambioImmagineTema(lblSalva, img.salvaModifiche1TemaChiaro(),
						img.salvaModifiche1());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				controllerCambioPassword.cambioImmagineTema(lblSalva, img.salvaModifiche3TemaChiaro(),
						img.salvaModifiche3());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				controllerCambioPassword.cambioImmagineTema(lblSalva, img.salvaModifiche1TemaChiaro(),
						img.salvaModifiche1());
			}
		});
		lblSalva.setBounds(373, 494, 319, 36);
		add(lblSalva);

		lblAnnulla = new JLabel("");
		lblAnnulla.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAnnulla.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnnulla.setIcon(new ImageIcon(img.frecciaIndietro1()));
		lblAnnulla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerCambioPassword.mostraPannelli(controllerCambioPassword.getDashboard().getProfilo());
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				controllerCambioPassword.cambioImmagineTema(lblAnnulla, img.frecciaIndietro2TemaChiaro(),
						img.frecciaIndietro2());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerCambioPassword.cambioImmagineTema(lblAnnulla, img.frecciaIndietro1TemaChiaro(),
						img.frecciaIndietro1());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				controllerCambioPassword.cambioImmagineTema(lblAnnulla, img.frecciaIndietro3TemaChiaro(),
						img.frecciaIndietro3());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				controllerCambioPassword.cambioImmagineTema(lblAnnulla, img.frecciaIndietro1TemaChiaro(),
						img.frecciaIndietro1());
			}
		});
		lblAnnulla.setBounds(277, 79, 41, 41);
		add(lblAnnulla);

	}

}
