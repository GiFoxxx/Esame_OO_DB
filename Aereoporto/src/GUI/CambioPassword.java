package GUI;

import javax.swing.JPanel;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
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
	
	Controller controllerCambioPassword;
	private JTextField txtVecchiaPassword;
	private JPasswordField txtNuovaPassword;
	private JPasswordField txtRipetiNuovaPassword;

	
	public CambioPassword(Controller controller) {
		controllerCambioPassword = controller;

		setBounds(0, 0, 1090, 634);
		setBackground(controllerCambioPassword.sfondo);
		setLayout(null);
		
		JLabel lblmostraNuovaPassword = new JLabel("");
		lblmostraNuovaPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblmostraNuovaPassword.setVisible(false);
				txtNuovaPassword.setEchoChar((char) 0);
			}
		});
		lblmostraNuovaPassword.setToolTipText("Mostra password");
		lblmostraNuovaPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblmostraNuovaPassword.setIcon(new ImageIcon(img.mostraPassword()));
		lblmostraNuovaPassword.setBounds(403, 198, 20, 20);
		add(lblmostraNuovaPassword);
		
		txtVecchiaPassword = new JTextField();
		txtVecchiaPassword.setBorder(null);
		txtVecchiaPassword.setFont(new Font("Arial", Font.PLAIN, 11));
		txtVecchiaPassword.setBounds(89, 94, 304, 23);
		txtVecchiaPassword.setColumns(10);
		add(txtVecchiaPassword);
		
		JButton btnNewButton = new JButton("salva");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String vecchiaPassword, nuovaPassword, ripetiNuovaPassword;
				vecchiaPassword = txtVecchiaPassword.getText();
				nuovaPassword = txtNuovaPassword.getText();
				ripetiNuovaPassword = txtRipetiNuovaPassword.getText();
//				controllerCambioPassword.modificaPassword();
				
				
				
//				controllerCambioPassword.annulla();
			}
		});
		btnNewButton.setBounds(647, 550, 89, 31);
		add(btnNewButton);
		
		JButton btnAnnulla = new JButton("annulla");
		btnAnnulla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				controllerCambioPassword.annulla();
			}
		});
		btnAnnulla.setBounds(775, 550, 89, 31);
		add(btnAnnulla);
		
		txtNuovaPassword = new JPasswordField();
		txtNuovaPassword.setBorder(null);
		txtNuovaPassword.setFont(new Font("Arial", Font.PLAIN, 11));
		txtNuovaPassword.setBounds(89, 198, 304, 23);
		add(txtNuovaPassword);
		
		txtRipetiNuovaPassword = new JPasswordField();
		txtRipetiNuovaPassword.setBorder(null);
		txtRipetiNuovaPassword.setFont(new Font("Arial", Font.PLAIN, 11));
		txtRipetiNuovaPassword.setBounds(89, 303, 304, 23);
		add(txtRipetiNuovaPassword);
		
		JLabel lblCambioPassword = new JLabel("");
		lblCambioPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblCambioPassword.setIcon(new ImageIcon(img.cambioPassword()));
		lblCambioPassword.setBounds(89, 65, 344, 263);
		add(lblCambioPassword);
		
		JLabel lblcensuraNuovaPassword = new JLabel("");
		lblcensuraNuovaPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblmostraNuovaPassword.setVisible(true);
				txtNuovaPassword.setEchoChar('●');
			}
		});
		lblcensuraNuovaPassword.setToolTipText("Nascondi password");
		lblcensuraNuovaPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblcensuraNuovaPassword.setIcon(new ImageIcon(img.censuraPassword()));
		lblcensuraNuovaPassword.setBounds(403, 198, 20, 20);
		add(lblcensuraNuovaPassword);
		lblmostraNuovaPassword.setIcon(new ImageIcon(img.mostraPassword()));
		
		JLabel lblmostraRipetiNuovaPassword = new JLabel("");
		lblmostraRipetiNuovaPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblmostraNuovaPassword.setVisible(false);
				txtRipetiNuovaPassword.setEchoChar((char) 0);
			}
		});
		lblmostraRipetiNuovaPassword.setToolTipText("Mostra password");
		lblmostraRipetiNuovaPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblmostraRipetiNuovaPassword.setIcon(new ImageIcon(img.cambioPassword()));
		lblmostraRipetiNuovaPassword.setBounds(403, 307, 20, 20);
		add(lblmostraRipetiNuovaPassword);
		
		JLabel lblcensuraRipetiNuovaPassword = new JLabel("");
		lblcensuraRipetiNuovaPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblmostraNuovaPassword.setVisible(true);
				txtRipetiNuovaPassword.setEchoChar('●');
			}
		});
		lblcensuraRipetiNuovaPassword.setToolTipText("Nascondi password");
		lblcensuraRipetiNuovaPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblcensuraRipetiNuovaPassword.setIcon(new ImageIcon(img.censuraPassword()));
		lblcensuraRipetiNuovaPassword.setBounds(403, 307, 20, 20);
		add(lblcensuraRipetiNuovaPassword);

	}
	
	//METODI
	
	public void controlloCambioPassword() {
		
	}
}
