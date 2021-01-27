package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Cursor;

public class Uscita extends JDialog {

	private Image imgSfondo = new ImageIcon(Accesso.class.getResource("immaginiDashboard/SfondoDashboard.png"))
			.getImage().getScaledInstance(500, 300, Image.SCALE_SMOOTH);

	Color sfondo = new Color(54, 57, 63);
	Color scritte = new Color(141, 142, 146);
	
	
	
	Controller controllerUscita;

	public Uscita(Controller controller) {
		controllerUscita = controller;

		setUndecorated(true);
		setBounds(100, 100, 500, 300);
		getContentPane().setLayout(null);
		{
			JButton btnAnnulla = new JButton("Annulla");
			btnAnnulla.setBorder(null);
			btnAnnulla.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnAnnulla.setFont(new Font("Arial", Font.BOLD, 14));
			btnAnnulla.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Uscita.this.dispose();
				}
			});
			{
				JLabel lblUscire = new JLabel("Sei sicuro di voler uscire dal programma?");
				lblUscire.setHorizontalAlignment(SwingConstants.CENTER);
				lblUscire.setFont(new Font("Arial", Font.BOLD, 20));
				lblUscire.setForeground(scritte);
				lblUscire.setBounds(0, 81, 498, 52);
				getContentPane().add(lblUscire);
			}
			btnAnnulla.setBounds(322, 220, 100, 30);
			getContentPane().add(btnAnnulla);
			btnAnnulla.setActionCommand("Annulla");
		}
		{
			JButton btnOk = new JButton("OK");
			btnOk.setBorder(null);
			btnOk.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnOk.setFont(new Font("Arial", Font.BOLD, 14));
			btnOk.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Uscita.this.dispose();
					controllerUscita.getDashboard().dispose();
				}
			});
			btnOk.setBounds(75, 220, 100, 30);
			getContentPane().add(btnOk);
			btnOk.setActionCommand("OK");
			getRootPane().setDefaultButton(btnOk);
		}

		JLabel lblLayout = new JLabel("");
		lblLayout.setBounds(0, 0, 500, 300);
		lblLayout.setHorizontalAlignment(SwingConstants.CENTER);
		lblLayout.setIcon(new ImageIcon(imgSfondo));
		getContentPane().add(lblLayout);

		// rimozione background java e adattamento al centro dello schermo
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		this.setBackground(new Color(0, 0, 0, 0));
	}

}
