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
	
	
	Controller controllerPasswordDimenticata;

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
								lblX.setIcon(new ImageIcon(img.X2()));
							}

							@Override
							public void mouseExited(MouseEvent e) {
								lblX.setIcon(new ImageIcon(img.X1()));
							}

							@Override
							public void mousePressed(MouseEvent e) {
								lblX.setIcon(new ImageIcon(img.X3()));
							}

							@Override
							public void mouseReleased(MouseEvent e) {
								lblX.setIcon(new ImageIcon(img.X1()));
							}
						});
						lblX.setHorizontalAlignment(SwingConstants.CENTER);
						lblX.setIcon(new ImageIcon(img.X1()));
						lblX.setBounds(448, 1, 51, 34);
						getContentPane().add(lblX);
			lblSpostaPasswordDimenticata.setHorizontalAlignment(SwingConstants.CENTER);
			lblSpostaPasswordDimenticata.setIcon(new ImageIcon(img.spostaUscita()));
			lblSpostaPasswordDimenticata.setBounds(1, 0, 498, 37);
			getContentPane().add(lblSpostaPasswordDimenticata);

			txtEmail = new JTextField();
			txtEmail.setBorder(null);
			txtEmail.setForeground(controllerPasswordDimenticata.coloreScritteTemaScuro);
			txtEmail.setFont(controllerPasswordDimenticata.fontScritte);
			txtEmail.setBackground(controllerPasswordDimenticata.sfondoTemaScuro);
			txtEmail.setColumns(10);
			txtEmail.setBounds(78, 102, 314, 20);
			getContentPane().add(txtEmail);

			txtNuovaPassword = new JPasswordField();
			txtNuovaPassword.setBorder(null);
			txtNuovaPassword.setForeground(controllerPasswordDimenticata.coloreScritteTemaScuro);
			txtNuovaPassword.setFont(controllerPasswordDimenticata.fontScritte);
			txtNuovaPassword.setBackground(controllerPasswordDimenticata.sfondoTemaScuro);
			txtNuovaPassword.setBounds(78, 196, 314, 20);
			getContentPane().add(txtNuovaPassword);

			txtRipetiNuovaPassword = new JPasswordField();
			txtRipetiNuovaPassword.setBorder(null);
			txtRipetiNuovaPassword.setBackground(controllerPasswordDimenticata.sfondoTemaScuro);
			txtRipetiNuovaPassword.setFont(controllerPasswordDimenticata.fontScritte);
			txtRipetiNuovaPassword.setForeground(controllerPasswordDimenticata.coloreScritteTemaScuro);
			txtRipetiNuovaPassword.setBounds(78, 290, 314, 20);
			getContentPane().add(txtRipetiNuovaPassword);

			lblMostraNuovaPassword = new JLabel("");
			lblMostraNuovaPassword.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lblMostraNuovaPassword.setVisible(false);
					txtNuovaPassword.setEchoChar((char) 0);
				}
			});

			lblMostraNuovaPassword.setToolTipText("Mostra password");
			lblMostraNuovaPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lblMostraNuovaPassword.setHorizontalAlignment(SwingConstants.CENTER);
			lblMostraNuovaPassword.setIcon(new ImageIcon(img.censuraPassword()));
			lblMostraNuovaPassword.setBounds(402, 192, 20, 20);
			getContentPane().add(lblMostraNuovaPassword);

			lblCensuraNuovaPassword = new JLabel("");
			lblCensuraNuovaPassword.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lblMostraNuovaPassword.setVisible(true);
					txtNuovaPassword.setEchoChar('●');
				}
			});
			lblCensuraNuovaPassword.setToolTipText("Nascondi password");
			lblCensuraNuovaPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lblCensuraNuovaPassword.setHorizontalAlignment(SwingConstants.CENTER);
			lblCensuraNuovaPassword.setIcon(new ImageIcon(img.mostraPassword()));
			lblCensuraNuovaPassword.setBounds(402, 192, 20, 20);
			getContentPane().add(lblCensuraNuovaPassword);

			lblMostraRipetiNuovaPassword = new JLabel("");
			lblMostraRipetiNuovaPassword.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lblMostraRipetiNuovaPassword.setVisible(false);
					txtRipetiNuovaPassword.setEchoChar((char) 0);
				}
			});
			lblMostraRipetiNuovaPassword.setToolTipText("Mostra password");
			lblMostraRipetiNuovaPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lblMostraRipetiNuovaPassword.setHorizontalAlignment(SwingConstants.CENTER);
			lblMostraRipetiNuovaPassword.setIcon(new ImageIcon(img.censuraPassword()));
			lblMostraRipetiNuovaPassword.setBounds(402, 287, 20, 20);
			getContentPane().add(lblMostraRipetiNuovaPassword);

			lblCensuraRipetiNuovaPassword = new JLabel("");
			lblCensuraRipetiNuovaPassword.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lblMostraRipetiNuovaPassword.setVisible(true);
					txtRipetiNuovaPassword.setEchoChar('●');
				}
			});
			lblCensuraRipetiNuovaPassword.setToolTipText("Nascondi password");
			lblCensuraRipetiNuovaPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lblCensuraRipetiNuovaPassword.setHorizontalAlignment(SwingConstants.CENTER);
			lblCensuraRipetiNuovaPassword.setIcon(new ImageIcon(img.mostraPassword()));
			lblCensuraRipetiNuovaPassword.setBounds(402, 287, 20, 20);
			getContentPane().add(lblCensuraRipetiNuovaPassword);

			lblSalva = new JLabel("");
			lblSalva.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lblSalva.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					controllerPasswordDimenticata.accessoPasswordDimenticata();
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lblSalva.setIcon(new ImageIcon(img.salva2()));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lblSalva.setIcon(new ImageIcon(img.salva1()));
				}

				@Override
				public void mousePressed(MouseEvent e) {
					lblSalva.setIcon(new ImageIcon(img.salva3()));
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					lblSalva.setIcon(new ImageIcon(img.salva1()));
				}
			});
			lblSalva.setForeground(Color.LIGHT_GRAY);
			lblSalva.setFont(new Font("Arial", Font.BOLD, 15));
			lblSalva.setHorizontalAlignment(SwingConstants.CENTER);
			lblSalva.setIcon(new ImageIcon(img.salva1()));
			lblSalva.setBounds(78, 374, 135, 41);
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
					lblAnnulla.setIcon(new ImageIcon(img.annulla2()));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lblAnnulla.setIcon(new ImageIcon(img.annulla1()));
				}

				@Override
				public void mousePressed(MouseEvent e) {
					lblAnnulla.setIcon(new ImageIcon(img.annulla3()));
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					lblAnnulla.setIcon(new ImageIcon(img.annulla1()));
				}
			});
			lblAnnulla.setHorizontalAlignment(SwingConstants.CENTER);
			lblAnnulla.setIcon(new ImageIcon(img.annulla1()));
			lblAnnulla.setBounds(287, 374, 135, 41);
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
