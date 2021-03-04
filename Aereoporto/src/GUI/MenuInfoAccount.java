package GUI;

import javax.swing.JPanel;

import Controller.Controller;
import Immagini.Immagini;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;

public class MenuInfoAccount extends JPanel {

	private Immagini img = new Immagini();
	
	JLabel lblGestioneUtenti;
	JLabel lblLayout;
	JLabel lblErrore;
	JLabel lblLogout;
	JLabel lblBoh;
	
	JPanel pannello2;
	JPanel pannello3;
	JPanel pannello1;
	
	public JLabel getLblGestioneUtenti() {
		return lblGestioneUtenti;
	}


	public void setLblGestioneUtenti(JLabel lblGestioneUtenti) {
		this.lblGestioneUtenti = lblGestioneUtenti;
	}


	public JLabel getLblLayout() {
		return lblLayout;
	}


	public void setLblLayout(JLabel lblLayout) {
		this.lblLayout = lblLayout;
	}


	public JLabel getLblErrore() {
		return lblErrore;
	}


	public void setLblErrore(JLabel lblErrore) {
		this.lblErrore = lblErrore;
	}


	public JLabel getLblLogout() {
		return lblLogout;
	}


	public void setLblLogout(JLabel lblLogout) {
		this.lblLogout = lblLogout;
	}


	public JLabel getLblBoh() {
		return lblBoh;
	}


	public void setLblBoh(JLabel lblBoh) {
		this.lblBoh = lblBoh;
	}


	public JPanel getPannello2() {
		return pannello2;
	}


	public void setPannello2(JPanel pannello2) {
		this.pannello2 = pannello2;
	}


	public JPanel getPannello3() {
		return pannello3;
	}


	public void setPannello3(JPanel pannello3) {
		this.pannello3 = pannello3;
	}


	public JPanel getPannello1() {
		return pannello1;
	}


	public void setPannello1(JPanel pannello1) {
		this.pannello1 = pannello1;
	}


	Controller controllerMenuInfoAccount;

	public MenuInfoAccount(Controller controller) {
		controllerMenuInfoAccount = controller;

		setBounds(717, 5, 266, 148);
		setBackground(controllerMenuInfoAccount.escoPannelloTemaScuro);
		setLayout(null);

		pannello1 = new JPanel();
		pannello1.setBackground(controllerMenuInfoAccount.escoPannelloTemaScuro);
		pannello1.setBounds(0, 10, 266, 46);
		add(pannello1);
		pannello1.setLayout(null);

		 lblGestioneUtenti = new JLabel("Gestione Utenti");
		 lblGestioneUtenti.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblGestioneUtenti.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (controllerMenuInfoAccount.isEntraGestioneUtenti()) {
					controllerMenuInfoAccount.entraInGestioneUtenti();
				}
			}
		});
		lblGestioneUtenti.setHorizontalAlignment(SwingConstants.LEFT);
		lblGestioneUtenti.setForeground(controllerMenuInfoAccount.coloreLabelPressedTemaScuro);
		lblGestioneUtenti.setFont(controllerMenuInfoAccount.fontLabel);
		lblGestioneUtenti.setBounds(10, 16, 95, 14);
		pannello1.add(lblGestioneUtenti);

		lblErrore = new JLabel("");
		lblErrore.setFont(controllerMenuInfoAccount.fontScritte);
		lblErrore.setForeground(controllerMenuInfoAccount.coloreScritturaAllertaTemaScuro);
		lblErrore.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrore.setBounds(125, 16, 141, 14);
		pannello1.add(lblErrore);

		pannello2 = new JPanel();
		pannello2.setBackground(controllerMenuInfoAccount.escoPannelloTemaScuro);
		pannello2.setBounds(0, 56, 266, 46);
		add(pannello2);
		pannello2.setLayout(null);
		
		lblBoh = new JLabel("Coming soon");
		lblBoh.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblBoh.setHorizontalAlignment(SwingConstants.LEFT);
		lblBoh.setForeground(controllerMenuInfoAccount.coloreLabelPressedTemaScuro);
		lblBoh.setFont(controllerMenuInfoAccount.fontLabel);
		lblBoh.setBounds(10, 16, 74, 14);
		pannello2.add(lblBoh);

		pannello3 = new JPanel();
		pannello3.setBackground(controllerMenuInfoAccount.escoPannelloTemaScuro);
		pannello3.setBounds(0, 102, 266, 46);
		add(pannello3);
		pannello3.setLayout(null);

		lblLogout = new JLabel("Logout");
		lblLogout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerMenuInfoAccount.logout();
			}
		});
		lblLogout.setHorizontalAlignment(SwingConstants.LEFT);
		lblLogout.setForeground(controllerMenuInfoAccount.coloreLabelPressedTemaScuro);
		lblLogout.setFont(controllerMenuInfoAccount.fontLabel);
		lblLogout.setBounds(10, 16, 40, 14);
		pannello3.add(lblLogout);

		lblLayout = new JLabel("");
		lblLayout.setHorizontalAlignment(SwingConstants.CENTER);
		lblLayout.setIcon(new ImageIcon(img.menu()));

		lblLayout.setBounds(0, 0, 266, 148);
		add(lblLayout);

	}
}
