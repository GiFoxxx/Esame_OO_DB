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

	int xMouse;
	int yMouse;
	int xMouseSuSchermo;
	int yMouseSuSchermo;
	int x;
	int y;

	JLabel lblLayout;
	JLabel lblSpostaUscita;
	JLabel lblX;
	JLabel lblAnnulla;

	Immagini img = new Immagini();
	Controller controllerPasswordDimenticata;
	private JLabel lblSalva;
	private JTextField txtEmail;
	private JPasswordField txtRipetiNuovaPassword;
	private JPasswordField txtNuovaPassword;
	private JLabel lblNewLabel;
	private JLabel lblCampi;

	// GETTER E SETTER
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

			lblSpostaUscita = new JLabel("");
			lblSpostaUscita.addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseDragged(MouseEvent spostaDashboard) {
					x = spostaDashboard.getXOnScreen();
					y = spostaDashboard.getYOnScreen();
					xMouseSuSchermo = spostaDashboard.getXOnScreen();
					yMouseSuSchermo = spostaDashboard.getYOnScreen();
					setLocation(x - xMouse, y - yMouse);

				}
			});
			lblSpostaUscita.addMouseListener(new MouseAdapter() {
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
//					controllerPasswordDimenticata.annullaPasswordDimenticata();
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

			JLabel lblmostraRipetiNuovaPassword = new JLabel("");
			lblmostraRipetiNuovaPassword.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lblmostraRipetiNuovaPassword.setVisible(false);
					txtRipetiNuovaPassword.setEchoChar((char) 0);
				}
			});
			lblmostraRipetiNuovaPassword.setToolTipText("Mostra password");
			lblmostraRipetiNuovaPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lblmostraRipetiNuovaPassword.setHorizontalAlignment(SwingConstants.CENTER);
			lblmostraRipetiNuovaPassword.setIcon(new ImageIcon(img.censuraPassword()));
			lblmostraRipetiNuovaPassword.setBounds(402, 287, 20, 20);
			getContentPane().add(lblmostraRipetiNuovaPassword);

			txtRipetiNuovaPassword = new JPasswordField();
			txtRipetiNuovaPassword.setBorder(null);
			txtRipetiNuovaPassword.setBackground(controllerPasswordDimenticata.sfondo);
			txtRipetiNuovaPassword.setForeground(controllerPasswordDimenticata.coloreScritte);
			txtRipetiNuovaPassword.setBounds(78, 287, 314, 20);
			getContentPane().add(txtRipetiNuovaPassword);

			JLabel lblcensuraRipetiNuovaPassword = new JLabel("");
			lblcensuraRipetiNuovaPassword.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lblmostraRipetiNuovaPassword.setVisible(true);
					txtRipetiNuovaPassword.setEchoChar('●');
				}
			});
			lblcensuraRipetiNuovaPassword.setToolTipText("Nascondi password");
			lblcensuraRipetiNuovaPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lblcensuraRipetiNuovaPassword.setHorizontalAlignment(SwingConstants.CENTER);
			lblcensuraRipetiNuovaPassword.setIcon(new ImageIcon(img.mostraPassword()));
			lblcensuraRipetiNuovaPassword.setBounds(402, 287, 20, 20);
			getContentPane().add(lblcensuraRipetiNuovaPassword);

			txtNuovaPassword = new JPasswordField();
			txtNuovaPassword.setBorder(null);
			txtNuovaPassword.setForeground(controllerPasswordDimenticata.coloreScritte);
			txtNuovaPassword.setBackground(controllerPasswordDimenticata.sfondo);
			txtNuovaPassword.setBounds(78, 192, 314, 20);
			getContentPane().add(txtNuovaPassword);

			JLabel lblmostraNuovaPassword = new JLabel("");
			lblmostraNuovaPassword.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lblmostraNuovaPassword.setVisible(false);
					txtNuovaPassword.setEchoChar((char) 0);
				}
			});

			lblmostraNuovaPassword.setToolTipText("Mostra password");
			lblmostraNuovaPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lblmostraNuovaPassword.setHorizontalAlignment(SwingConstants.CENTER);
			lblmostraNuovaPassword.setIcon(new ImageIcon(img.censuraPassword()));
			lblmostraNuovaPassword.setBounds(402, 192, 20, 20);
			getContentPane().add(lblmostraNuovaPassword);

			txtEmail = new JTextField();
			txtEmail.setBorder(null);
			txtEmail.setForeground(controllerPasswordDimenticata.coloreScritte);
			txtEmail.setBackground(controllerPasswordDimenticata.sfondo);
			txtEmail.setColumns(10);
			txtEmail.setBounds(78, 97, 314, 20);
			getContentPane().add(txtEmail);

			JLabel lblcensuraNuovaPassword = new JLabel("");
			lblcensuraNuovaPassword.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lblmostraNuovaPassword.setVisible(true);
					txtNuovaPassword.setEchoChar('●');
				}
			});
			lblcensuraNuovaPassword.setToolTipText("Nascondi password");
			lblcensuraNuovaPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lblcensuraNuovaPassword.setHorizontalAlignment(SwingConstants.CENTER);
			lblcensuraNuovaPassword.setIcon(new ImageIcon(img.mostraPassword()));
			lblcensuraNuovaPassword.setBounds(402, 192, 20, 20);
			getContentPane().add(lblcensuraNuovaPassword);

			lblCampi = new JLabel("");
			lblCampi.setHorizontalAlignment(SwingConstants.CENTER);
			lblCampi.setIcon(new ImageIcon(img.campiPasswordDimenticata()));
			lblCampi.setBounds(78, 63, 344, 263);
			getContentPane().add(lblCampi);

			lblSalva = new JLabel("");
			lblSalva.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lblSalva.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
//					controllerPasswordDimenticata.accessoPasswordDimenticata();
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
			lblSalva.setBounds(56, 402, 181, 56);
			getContentPane().add(lblSalva);
			lblX.setHorizontalAlignment(SwingConstants.CENTER);
			lblX.setIcon(new ImageIcon(img.X1()));
			lblX.setBounds(448, 1, 51, 34);
			getContentPane().add(lblX);
			lblSpostaUscita.setHorizontalAlignment(SwingConstants.CENTER);
			lblSpostaUscita.setIcon(new ImageIcon(img.spostaUscita()));
			lblSpostaUscita.setBounds(1, 0, 498, 37);
			getContentPane().add(lblSpostaUscita);

			lblAnnulla = new JLabel("");
			lblAnnulla.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lblAnnulla.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
//					controllerPasswordDimenticata.annullaPasswordDimenticata();
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
			lblAnnulla.setBounds(276, 411, 174, 47);
			getContentPane().add(lblAnnulla);

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
