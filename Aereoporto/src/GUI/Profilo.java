package GUI;

import javax.swing.JPanel;

import Controller.Controller;
import Immagini.Immagini;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTextField;

public class Profilo extends JPanel {

	private Immagini img = new Immagini();

	private JLabel lblLogout;
	private JLabel lblDatiAccount;
	private JTextField txtNome;
	private JTextField txtCognome;
	private JTextField txtEmail;

	private JLabel lblCambiaPassword;

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

	Controller controllerProfilo;

	public Profilo(Controller controller) {
		controllerProfilo = controller;

		setBounds(0, 0, 1090, 642);
		setBackground(controllerProfilo.sfondo);
		setLayout(null);

		lblLogout = new JLabel("Logout");
		lblLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerProfilo.logout();
			}
		});
		lblLogout.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblLogout.setForeground(controllerProfilo.coloreScritte);
		lblLogout.setFont(controllerProfilo.fontScritte);
		lblLogout.setBounds(968, 30, 100, 22);
		add(lblLogout);

		txtNome = new JTextField();
		txtNome.setEditable(false);
		txtNome.setForeground(controllerProfilo.coloreScritte);
		txtNome.setFont(controllerProfilo.fontScritte);
		txtNome.setColumns(10);
		txtNome.setBorder(null);
		txtNome.setBackground(controllerProfilo.trasparente);
		txtNome.setBounds(657, 136, 340, 23);
		add(txtNome);

		txtCognome = new JTextField();
		txtCognome.setEditable(false);
		txtCognome.setForeground(controllerProfilo.coloreScritte);
		txtCognome.setFont(controllerProfilo.fontScritte);
		txtCognome.setColumns(10);
		txtCognome.setBorder(null);
		txtCognome.setBackground(controllerProfilo.trasparente);
		txtCognome.setBounds(657, 241, 340, 23);
		add(txtCognome);

		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setForeground(controllerProfilo.coloreScritte);
		txtEmail.setFont(controllerProfilo.fontScritte);
		txtEmail.setColumns(10);
		txtEmail.setBorder(null);
		txtEmail.setBackground(controllerProfilo.trasparente);
		txtEmail.setBounds(657, 345, 340, 23);
		add(txtEmail);

		lblDatiAccount = new JLabel("");
		lblDatiAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatiAccount.setIcon(new ImageIcon(img.datiAccount()));
		lblDatiAccount.setBounds(657, 108, 344, 263);
		add(lblDatiAccount);

		lblCambiaPassword = new JLabel("Cambia password");
		lblCambiaPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerProfilo.mostraPannelli(controllerProfilo.getDashboard().getCambioPassword());
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblCambiaPassword.setForeground(controllerProfilo.coloreLabelEntrata);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblCambiaPassword.setForeground(controllerProfilo.coloreLabel);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				lblCambiaPassword.setForeground(controllerProfilo.coloreLabelPressed);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				lblCambiaPassword.setForeground(controllerProfilo.coloreLabel);
			}
		});
		lblCambiaPassword.setForeground(controllerProfilo.coloreLabel);
		lblCambiaPassword.setFont(controllerProfilo.fontLabel);
		lblCambiaPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblCambiaPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblCambiaPassword.setBounds(655, 390, 129, 14);
		add(lblCambiaPassword);

	}
}
