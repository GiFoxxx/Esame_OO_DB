package GUI;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import Controller.Controller;
import Immagini.Immagini;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PasswordDimenticata extends JDialog {

	Immagini img = new Immagini();

	int xMouse;
	int yMouse;
	int xMouseSuSchermo;
	int yMouseSuSchermo;
	int x;
	int y;

	private JTextField txtEmail;
	private JPasswordField txtRipetiNuovaPassword;
	private JPasswordField txtNuovaPassword;

	private JLabel lblLayout;
	private JLabel lblSpostaPasswordDimenticata;
	private JLabel lblX;
	private JLabel lblAnnulla;
	private JLabel lblSalva;
	private JLabel lblCampi;
	private JLabel lblMostraNuovaPassword;
	private JLabel lblCensuraNuovaPassword;
	private JLabel lblMostraRipetiNuovaPassword;
	private JLabel lblCensuraRipetiNuovaPassword;
	private JLabel lblIconaErroreEmail;
	private JLabel lblMostraNuovaPasswordTT;
	private JLabel lblCensuraNuovaPasswordTT;
	private JLabel lblMostraRipetiNuovaPasswordTT;
	private JLabel lblCensuraRipetiNuovaPasswordTT;

	// GETTER E SETTER
	public JLabel getLblLayout() {
		return lblLayout;
	}

	public void setLblLayout(JLabel lblLayout) {
		this.lblLayout = lblLayout;
	}

	public JLabel getLblSpostaPasswordDimenticata() {
		return lblSpostaPasswordDimenticata;
	}

	public void setLblSpostaPasswordDimenticata(JLabel lblSpostaPasswordDimenticata) {
		this.lblSpostaPasswordDimenticata = lblSpostaPasswordDimenticata;
	}

	public JLabel getLblX() {
		return lblX;
	}

	public void setLblX(JLabel lblX) {
		this.lblX = lblX;
	}

	public JLabel getLblAnnulla() {
		return lblAnnulla;
	}

	public void setLblAnnulla(JLabel lblAnnulla) {
		this.lblAnnulla = lblAnnulla;
	}

	public JLabel getLblSalva() {
		return lblSalva;
	}

	public void setLblSalva(JLabel lblSalva) {
		this.lblSalva = lblSalva;
	}

	public JLabel getLblCampi() {
		return lblCampi;
	}

	public void setLblCampi(JLabel lblCampi) {
		this.lblCampi = lblCampi;
	}

	public JLabel getLblMostraNuovaPassword() {
		return lblMostraNuovaPassword;
	}

	public void setLblMostraNuovaPassword(JLabel lblmostraNuovaPassword) {
		this.lblMostraNuovaPassword = lblmostraNuovaPassword;
	}

	public JLabel getLblCensuraNuovaPassword() {
		return lblCensuraNuovaPassword;
	}

	public void setLblCensuraNuovaPassword(JLabel lblcensuraNuovaPassword) {
		this.lblCensuraNuovaPassword = lblcensuraNuovaPassword;
	}

	public JLabel getLblMostraRipetiNuovaPassword() {
		return lblMostraRipetiNuovaPassword;
	}

	public void setLblMostraRipetiNuovaPassword(JLabel lblmostraRipetiNuovaPassword) {
		this.lblMostraRipetiNuovaPassword = lblmostraRipetiNuovaPassword;
	}

	public JLabel getLblCensuraRipetiNuovaPassword() {
		return lblCensuraRipetiNuovaPassword;
	}

	public void setLblCensuraRipetiNuovaPassword(JLabel lblcensuraRipetiNuovaPassword) {
		this.lblCensuraRipetiNuovaPassword = lblcensuraRipetiNuovaPassword;
	}

	public JTextField getTxtNuovaPassword() {
		return txtNuovaPassword;
	}

	public void setTxtNuovaPassword(JPasswordField txtNuovaPassword) {
		this.txtNuovaPassword = txtNuovaPassword;
	}

	public JTextField getTxtRipetiNuovaPassword() {
		return txtRipetiNuovaPassword;
	}

	public void setTxtRipetiNuovaPassword(JPasswordField txtRipetiNuovaPassword) {
		this.txtRipetiNuovaPassword = txtRipetiNuovaPassword;
	}

	public JTextField getTxtEmail() {
		return txtEmail;
	}

	public void setTxtEmail(JTextField txtEmail) {
		this.txtEmail = txtEmail;
	}

	public JLabel getLblIconaErroreEmail() {
		return lblIconaErroreEmail;
	}

	public void setLblIconaErroreEmail(JLabel lblIconaErroreEmail) {
		this.lblIconaErroreEmail = lblIconaErroreEmail;
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

	Controller controllerPasswordDimenticata;

	public PasswordDimenticata(Controller controller) {
		controllerPasswordDimenticata = controller;

		setModal(true);

		setBounds(100, 100, 500, 469);
		setFocusable(true);
		setUndecorated(true);

		getContentPane().setLayout(null);
		{

			lblSpostaPasswordDimenticata = new JLabel("");
			lblSpostaPasswordDimenticata.addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseDragged(MouseEvent spostaDashboard) {
					x = spostaDashboard.getXOnScreen();
					y = spostaDashboard.getYOnScreen();
					xMouseSuSchermo = spostaDashboard.getXOnScreen();
					yMouseSuSchermo = spostaDashboard.getYOnScreen();
					setLocation(x - xMouse, y - yMouse);

				}
			});
			lblSpostaPasswordDimenticata.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent prendiPosizioneMouse) {

					xMouse = prendiPosizioneMouse.getX();
					yMouse = prendiPosizioneMouse.getY();

				}
			});

			lblX = new JLabel("");
			lblX.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					controllerPasswordDimenticata.annullaPasswordDimenticata();
					controllerPasswordDimenticata.svuotaCampiAccesso();
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					controllerPasswordDimenticata.cambioImmagineTema(lblX, img.X2TemaChiaro(), img.X2());
				}

				@Override
				public void mouseExited(MouseEvent e) {
					controllerPasswordDimenticata.cambioImmagineTema(lblX, img.X1TemaChiaro(), img.X1());
				}

				@Override
				public void mousePressed(MouseEvent e) {
					controllerPasswordDimenticata.cambioImmagineTema(lblX, img.X3TemaChiaro(), img.X3());
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					controllerPasswordDimenticata.cambioImmagineTema(lblX, img.X1TemaChiaro(), img.X1());
				}
			});

			lblIconaErroreEmail = new JLabel("");
			lblIconaErroreEmail.setVisible(false);
			lblIconaErroreEmail.setHorizontalAlignment(SwingConstants.CENTER);
			lblIconaErroreEmail.setIcon(new ImageIcon(img.errore()));
			lblIconaErroreEmail.setBounds(401, 93, 20, 20);
			getContentPane().add(lblIconaErroreEmail);
			
			lblX.setHorizontalAlignment(SwingConstants.CENTER);
			lblX.setIcon(new ImageIcon(img.X1()));
			lblX.setBounds(448, 2, 51, 34);
			getContentPane().add(lblX);
			lblSpostaPasswordDimenticata.setHorizontalAlignment(SwingConstants.CENTER);
			lblSpostaPasswordDimenticata.setIcon(new ImageIcon(img.spostaUscita()));
			lblSpostaPasswordDimenticata.setBounds(1, 0, 498, 37);
			getContentPane().add(lblSpostaPasswordDimenticata);

			txtEmail = new JTextField();
			txtEmail.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent EventoInvio) {
					if (EventoInvio.getKeyCode() == KeyEvent.VK_ENTER) {
						controllerPasswordDimenticata.accessoPasswordDimenticata();
					}
				}

				@Override
				public void keyReleased(KeyEvent e) {
					if (e.getKeyCode() != KeyEvent.VK_ENTER) {
						lblIconaErroreEmail.setVisible(false);
					}
				}
			});
			txtEmail.setBorder(null);
			txtEmail.setForeground(controllerPasswordDimenticata.coloreScritteTemaScuro);
			txtEmail.setFont(controllerPasswordDimenticata.fontScritte);
			txtEmail.setBackground(controllerPasswordDimenticata.sfondoTemaScuro);
			txtEmail.setColumns(10);
			txtEmail.setBounds(79, 93, 314, 20);
			getContentPane().add(txtEmail);

			txtNuovaPassword = new JPasswordField();
			txtNuovaPassword.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent EventoInvio) {
					if (EventoInvio.getKeyCode() == KeyEvent.VK_ENTER) {
						controllerPasswordDimenticata.accessoPasswordDimenticata();
					}
				}
			});
			txtNuovaPassword.setBorder(null);
			txtNuovaPassword.setForeground(controllerPasswordDimenticata.coloreScritteTemaScuro);
			txtNuovaPassword.setFont(controllerPasswordDimenticata.fontScritte);
			txtNuovaPassword.setBackground(controllerPasswordDimenticata.sfondoTemaScuro);
			txtNuovaPassword.setBounds(79, 198, 314, 20);
			getContentPane().add(txtNuovaPassword);

			txtRipetiNuovaPassword = new JPasswordField();
			txtRipetiNuovaPassword.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent EventoInvio) {
					if (EventoInvio.getKeyCode() == KeyEvent.VK_ENTER) {
						controllerPasswordDimenticata.accessoPasswordDimenticata();
					}
				}
			});
			txtRipetiNuovaPassword.setBorder(null);
			txtRipetiNuovaPassword.setBackground(controllerPasswordDimenticata.sfondoTemaScuro);
			txtRipetiNuovaPassword.setFont(controllerPasswordDimenticata.fontScritte);
			txtRipetiNuovaPassword.setForeground(controllerPasswordDimenticata.coloreScritteTemaScuro);
			txtRipetiNuovaPassword.setBounds(79, 303, 314, 20);
			getContentPane().add(txtRipetiNuovaPassword);

			lblMostraNuovaPassword = new JLabel("");
			lblMostraNuovaPassword.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lblMostraNuovaPassword.setVisible(false);
					txtNuovaPassword.setEchoChar((char) 0);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					controllerPasswordDimenticata.setStopMostraPasswordTT(false);
					controllerPasswordDimenticata.mostraMostraPasswordTT(lblMostraNuovaPasswordTT);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					controllerPasswordDimenticata.setStopMostraPasswordTT(true);
					controllerPasswordDimenticata.chiudiMostraPasswordTT(lblMostraNuovaPasswordTT);
				}
			});
			lblMostraNuovaPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lblMostraNuovaPassword.setHorizontalAlignment(SwingConstants.CENTER);
			lblMostraNuovaPassword.setIcon(new ImageIcon(img.censuraPassword()));
			lblMostraNuovaPassword.setBounds(401, 198, 20, 20);
			getContentPane().add(lblMostraNuovaPassword);

			lblCensuraNuovaPassword = new JLabel("");
			lblCensuraNuovaPassword.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lblMostraNuovaPassword.setVisible(true);
					txtNuovaPassword.setEchoChar('●');
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					controllerPasswordDimenticata.setStopCensuraPasswordTT(false);
					controllerPasswordDimenticata.mostraCensuraPasswordTT(lblCensuraNuovaPasswordTT);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					controllerPasswordDimenticata.setStopCensuraPasswordTT(true);
					controllerPasswordDimenticata.chiudiCensuraPasswordTT(lblCensuraNuovaPasswordTT);
				}
			});
			lblCensuraNuovaPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lblCensuraNuovaPassword.setHorizontalAlignment(SwingConstants.CENTER);
			lblCensuraNuovaPassword.setIcon(new ImageIcon(img.mostraPassword()));
			lblCensuraNuovaPassword.setBounds(401, 198, 20, 20);
			getContentPane().add(lblCensuraNuovaPassword);

			lblMostraRipetiNuovaPassword = new JLabel("");
			lblMostraRipetiNuovaPassword.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lblMostraRipetiNuovaPassword.setVisible(false);
					txtRipetiNuovaPassword.setEchoChar((char) 0);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					controllerPasswordDimenticata.setStopMostraPasswordTT(false);
					controllerPasswordDimenticata.mostraMostraPasswordTT(lblMostraRipetiNuovaPasswordTT);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					controllerPasswordDimenticata.setStopMostraPasswordTT(true);
					controllerPasswordDimenticata.chiudiMostraPasswordTT(lblMostraRipetiNuovaPasswordTT);
				}
			});
			lblMostraRipetiNuovaPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lblMostraRipetiNuovaPassword.setHorizontalAlignment(SwingConstants.CENTER);
			lblMostraRipetiNuovaPassword.setIcon(new ImageIcon(img.censuraPassword()));
			lblMostraRipetiNuovaPassword.setBounds(401, 302, 20, 20);
			getContentPane().add(lblMostraRipetiNuovaPassword);

			lblCensuraRipetiNuovaPassword = new JLabel("");
			lblCensuraRipetiNuovaPassword.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lblMostraRipetiNuovaPassword.setVisible(true);
					txtRipetiNuovaPassword.setEchoChar('●');
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					controllerPasswordDimenticata.setStopCensuraPasswordTT(false);
					controllerPasswordDimenticata.mostraCensuraPasswordTT(lblCensuraRipetiNuovaPasswordTT);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					controllerPasswordDimenticata.setStopCensuraPasswordTT(true);
					controllerPasswordDimenticata.chiudiCensuraPasswordTT(lblCensuraRipetiNuovaPasswordTT);
				}
			});
			lblCensuraRipetiNuovaPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lblCensuraRipetiNuovaPassword.setHorizontalAlignment(SwingConstants.CENTER);
			lblCensuraRipetiNuovaPassword.setIcon(new ImageIcon(img.mostraPassword()));
			lblCensuraRipetiNuovaPassword.setBounds(401, 302, 20, 20);
			getContentPane().add(lblCensuraRipetiNuovaPassword);

			lblMostraNuovaPasswordTT = new JLabel("");
			lblMostraNuovaPasswordTT.setHorizontalAlignment(SwingConstants.CENTER);
			lblMostraNuovaPasswordTT.setBounds(350, 158, 123, 31);
			getContentPane().add(lblMostraNuovaPasswordTT);

			lblCensuraNuovaPasswordTT = new JLabel("");
			lblCensuraNuovaPasswordTT.setHorizontalAlignment(SwingConstants.CENTER);
			lblCensuraNuovaPasswordTT.setBounds(350, 158, 123, 31);
			getContentPane().add(lblCensuraNuovaPasswordTT);

			lblMostraRipetiNuovaPasswordTT = new JLabel("");
			lblMostraRipetiNuovaPasswordTT.setHorizontalAlignment(SwingConstants.CENTER);
			lblMostraRipetiNuovaPasswordTT.setBounds(350, 262, 123, 31);
			getContentPane().add(lblMostraRipetiNuovaPasswordTT);

			lblCensuraRipetiNuovaPasswordTT = new JLabel("");
			lblCensuraRipetiNuovaPasswordTT.setHorizontalAlignment(SwingConstants.CENTER);
			lblCensuraRipetiNuovaPasswordTT.setBounds(350, 262, 123, 31);
			getContentPane().add(lblCensuraRipetiNuovaPasswordTT);

			lblSalva = new JLabel("");
			lblSalva.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lblSalva.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					controllerPasswordDimenticata.accessoPasswordDimenticata();
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					controllerPasswordDimenticata.cambioImmagineTema(lblSalva, img.salva2TemaChiaro(), img.salva2());

				}

				@Override
				public void mouseExited(MouseEvent e) {
					controllerPasswordDimenticata.cambioImmagineTema(lblSalva, img.salva1TemaChiaro(), img.salva1());

				}

				@Override
				public void mousePressed(MouseEvent e) {
					controllerPasswordDimenticata.cambioImmagineTema(lblSalva, img.salva3TemaChiaro(), img.salva3());

				}

				@Override
				public void mouseReleased(MouseEvent e) {
					controllerPasswordDimenticata.cambioImmagineTema(lblSalva, img.salva1TemaChiaro(), img.salva1());

				}
			});
			lblSalva.setForeground(Color.LIGHT_GRAY);
			lblSalva.setFont(new Font("Arial", Font.BOLD, 15));
			lblSalva.setHorizontalAlignment(SwingConstants.CENTER);
			lblSalva.setIcon(new ImageIcon(img.salva1()));
			lblSalva.setBounds(80, 374, 130, 41);
			getContentPane().add(lblSalva);

			lblAnnulla = new JLabel("");
			lblAnnulla.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lblAnnulla.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					controllerPasswordDimenticata.annullaPasswordDimenticata();
					controllerPasswordDimenticata.svuotaCampiAccesso();
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					controllerPasswordDimenticata.cambioImmagineTema(lblAnnulla, img.annullaUscita2TemaChiaro(),
							img.annullaUscita2());
				}

				@Override
				public void mouseExited(MouseEvent e) {
					controllerPasswordDimenticata.cambioImmagineTema(lblAnnulla, img.annullaUscita1TemaChiaro(),
							img.annullaUscita1());
				}

				@Override
				public void mousePressed(MouseEvent e) {
					controllerPasswordDimenticata.cambioImmagineTema(lblAnnulla, img.annullaUscita3TemaChiaro(),
							img.annullaUscita3());
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					controllerPasswordDimenticata.cambioImmagineTema(lblAnnulla, img.annullaUscita1TemaChiaro(),
							img.annullaUscita1());
				}
			});
			lblAnnulla.setHorizontalAlignment(SwingConstants.CENTER);
			lblAnnulla.setIcon(new ImageIcon(img.annullaUscita1()));
			lblAnnulla.setBounds(290, 374, 130, 41);
			getContentPane().add(lblAnnulla);

			lblCampi = new JLabel("");
			lblCampi.setHorizontalAlignment(SwingConstants.CENTER);
			lblCampi.setIcon(new ImageIcon(img.credenzialiPasswordDimenticata()));
			lblCampi.setBounds(78, 63, 344, 263);
			getContentPane().add(lblCampi);

		}

		lblLayout = new JLabel("");
		lblLayout.setBorder(null);
		lblLayout.setBounds(0, 0, 500, 469);
		lblLayout.setHorizontalAlignment(SwingConstants.CENTER);
		lblLayout.setIcon(new ImageIcon(img.sfondoPasswordDimenticata()));
		getContentPane().add(lblLayout);

		controllerPasswordDimenticata.centramentoJDialog(this);

	}
}
