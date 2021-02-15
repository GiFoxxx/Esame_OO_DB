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
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Amministrazione.*;
import java.awt.Font;

public class CambioPassword extends JPanel {

	private Immagini img = new Immagini();

	private JTextField txtVecchiaPassword;
	private JPasswordField txtNuovaPassword;
	private JPasswordField txtRipetiNuovaPassword;

	// GETTER E SETTER

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

	Controller controllerCambioPassword;

	public CambioPassword(Controller controller) {
		controllerCambioPassword = controller;

		setBounds(0, 0, 1090, 634);
		setBackground(controllerCambioPassword.sfondo);
		setLayout(null);

		txtVecchiaPassword = new JTextField();
		txtVecchiaPassword.setBorder(null);
		txtVecchiaPassword.setFont(controllerCambioPassword.fontScritte);
		txtVecchiaPassword.setBackground(controllerCambioPassword.sfondo);
		txtVecchiaPassword.setForeground(controllerCambioPassword.coloreScritte);
		txtVecchiaPassword.setBounds(641, 80, 304, 23);
		txtVecchiaPassword.setColumns(10);
		add(txtVecchiaPassword);

		txtNuovaPassword = new JPasswordField();
		txtNuovaPassword.setBorder(null);
		txtNuovaPassword.setFont(controllerCambioPassword.fontScritte);
		txtNuovaPassword.setBackground(controllerCambioPassword.sfondo);
		txtNuovaPassword.setForeground(controllerCambioPassword.coloreScritte);
		txtNuovaPassword.setBounds(641, 184, 304, 23);
		add(txtNuovaPassword);

		txtRipetiNuovaPassword = new JPasswordField();
		txtRipetiNuovaPassword.setBorder(null);
		txtRipetiNuovaPassword.setFont(controllerCambioPassword.fontScritte);
		txtRipetiNuovaPassword.setBackground(controllerCambioPassword.sfondo);
		txtRipetiNuovaPassword.setForeground(controllerCambioPassword.coloreScritte);
		txtRipetiNuovaPassword.setBounds(641, 289, 314, 23);
		add(txtRipetiNuovaPassword);

		JLabel lblmostraNuovaPassword = new JLabel("");
		lblmostraNuovaPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblmostraNuovaPassword.setVisible(false);
				txtNuovaPassword.setEchoChar((char)0);
			}
		});
		lblmostraNuovaPassword.setToolTipText("Mostra password");
		lblmostraNuovaPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblmostraNuovaPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblmostraNuovaPassword.setIcon(new ImageIcon(img.censuraPassword()));
		lblmostraNuovaPassword.setBounds(965, 187, 20, 20);
		add(lblmostraNuovaPassword);

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
		lblcensuraNuovaPassword.setBounds(965, 187, 20, 20);
		add(lblcensuraNuovaPassword);

		JLabel lblmostraRipetiNuovaPassword = new JLabel("");
		lblmostraRipetiNuovaPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblmostraRipetiNuovaPassword.setVisible(false);
				txtRipetiNuovaPassword.setEchoChar((char)0);
			}
		});
		lblmostraRipetiNuovaPassword.setToolTipText("Mostra password");
		lblmostraRipetiNuovaPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblmostraRipetiNuovaPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblmostraRipetiNuovaPassword.setIcon(new ImageIcon(img.censuraPassword()));
		lblmostraRipetiNuovaPassword.setBounds(965, 292, 20, 20);
		add(lblmostraRipetiNuovaPassword);

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
		lblcensuraRipetiNuovaPassword.setBounds(965, 292, 20, 20);
		add(lblcensuraRipetiNuovaPassword);

		JLabel lblCambioPassword = new JLabel("");
		lblCambioPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblCambioPassword.setIcon(new ImageIcon(img.cambioPassword()));
		lblCambioPassword.setBounds(641, 51, 344, 263);
		add(lblCambioPassword);

		JButton btnSalva = new JButton("Salva");
		btnSalva.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerCambioPassword.cambioPasswordDaProfilo();
			}
		});
		btnSalva.setBounds(641, 469, 89, 31);
		add(btnSalva);

		JButton btnAnnulla = new JButton("Annulla");
		btnAnnulla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerCambioPassword.mostraPannelli(controllerCambioPassword.getDashboard().getProfilo());
			}
		});
		btnAnnulla.setBounds(836, 469, 89, 31);
		add(btnAnnulla);

	}

	// METODI

	public void controlloCambioPassword() {

	}
}
