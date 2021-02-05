package GUI;

import javax.swing.JPanel;

import Controller.Controller;
import Immagini.Immagini;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Profilo extends JPanel {

	private Immagini img = new Immagini();
	
	private JLabel lblPerNome;
	private JLabel lblPerCognome;
	private JLabel lblPerEmail;
	private JLabel lblPerPassword;
	private JLabel lblNome;
	private JLabel lblCognome;
	private JLabel lblEmail;
	private JLabel lblPassword;
	
	
	Controller controllerProfilo;
	private JLabel lblLogout;
	
	
	public Profilo(Controller controller) {
		controllerProfilo = controller;

		setBounds(0, 0, 894, 625);
		setBackground(controllerProfilo.sfondo);
		setLayout(null);
		
		lblPerNome = new JLabel("Nome:");
		lblPerNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPerNome.setForeground(controllerProfilo.coloreScritte);
		lblPerNome.setFont(controllerProfilo.fontScritte);
		lblPerNome.setBounds(131, 140, 100, 22);
		add(lblPerNome);
		
		lblPerCognome = new JLabel("Cognome:");
		lblPerCognome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPerCognome.setForeground(controllerProfilo.coloreScritte);
		lblPerCognome.setFont(controllerProfilo.fontScritte);
		lblPerCognome.setBounds(131, 210, 100, 22);
		add(lblPerCognome);
		
		lblPerEmail = new JLabel("Email:");
		lblPerEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPerEmail.setForeground(controllerProfilo.coloreScritte);
		lblPerEmail.setFont(controllerProfilo.fontScritte);
		lblPerEmail.setBounds(131, 280, 100, 22);
		add(lblPerEmail);
		
		lblPerPassword = new JLabel("Password:");
		lblPerPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPerPassword.setForeground(controllerProfilo.coloreScritte);
		lblPerPassword.setFont(controllerProfilo.fontScritte);
		lblPerPassword.setBounds(131, 350, 100, 22);
		add(lblPerPassword);
		
		lblNome = new JLabel("");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setForeground(controllerProfilo.coloreScritte);
		lblNome.setFont(controllerProfilo.fontScritte);
		lblNome.setBounds(289, 140, 242, 22);
		add(lblNome);
		
		lblCognome = new JLabel("");
		lblCognome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCognome.setForeground(controllerProfilo.coloreScritte);
		lblCognome.setFont(controllerProfilo.fontScritte);
		lblCognome.setBounds(289, 210, 242, 22);
		add(lblCognome);
		
		lblEmail = new JLabel("");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setForeground(controllerProfilo.coloreScritte);
		lblEmail.setFont(controllerProfilo.fontScritte);
		lblEmail.setBounds(289, 280, 242, 22);
		add(lblEmail);
		
		lblPassword = new JLabel("");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setForeground(controllerProfilo.coloreScritte);
		lblPassword.setFont(controllerProfilo.fontScritte);
		lblPassword.setBounds(289, 350, 242, 22);
		add(lblPassword);
		
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
		lblLogout.setBounds(66, 536, 100, 22);
		add(lblLogout);
	
	}
}
