package GUI;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import Immagini.Immagini;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;

public class Home extends JPanel {

	private Immagini img = new Immagini();
	
	Color trasparente = new Color(0, 0, 0, 0);
	Color sfondo = new Color(54, 57, 63);
	Color scritte = new Color(141, 142, 146);

	Controller controllerHome;

	public Home(Controller controller) {
		controllerHome = controller;

		setBounds(0, 0, 1194, 1125);
		setBackground(sfondo);
		setLayout(null);

		JLabel lblTratte = new JLabel("");
		lblTratte.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblTratte.setIcon(new ImageIcon(img.tratte2()));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblTratte.setIcon(new ImageIcon(img.tratte1()));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				controllerHome.mostraPannelli(controllerHome.getDashboard().getGestioneTratte());
			}
		});
		lblTratte.setHorizontalAlignment(SwingConstants.CENTER);
		lblTratte.setIcon(new ImageIcon(img.tratte1()));
		lblTratte.setBounds(20, 110, 276, 162);
		add(lblTratte);

		JLabel lblCompagniaAerea = new JLabel("");
		lblCompagniaAerea.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblCompagniaAerea.setIcon(new ImageIcon(img.compagnieAeree2()));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblCompagniaAerea.setIcon(new ImageIcon(img.compagnieAeree1()));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				controllerHome.mostraPannelli(controllerHome.getDashboard().getGestioneCompagnieAeree());
			}
		});
		lblCompagniaAerea.setHorizontalAlignment(SwingConstants.CENTER);
		lblCompagniaAerea.setIcon(new ImageIcon(img.compagnieAeree1()));
		lblCompagniaAerea.setBounds(312, 110, 276, 162);
		add(lblCompagniaAerea);

		JLabel lblGestioneAccount = new JLabel("");
		lblGestioneAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblGestioneAccount.setIcon(new ImageIcon(img.gestioneAccount2()));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblGestioneAccount.setIcon(new ImageIcon(img.gestioneAccount1()));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				controllerHome.mostraPannelli(controllerHome.getDashboard().getGestioneUtenti());
			}
		});
		lblGestioneAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestioneAccount.setIcon(new ImageIcon(img.gestioneAccount1()));
		lblGestioneAccount.setBounds(605, 110, 276, 162);
		add(lblGestioneAccount);

		JLabel lblPrenotazioni = new JLabel("");
		lblPrenotazioni.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblPrenotazioni.setIcon(new ImageIcon(img.prenotazioni2()));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblPrenotazioni.setIcon(new ImageIcon(img.prenotazioni1()));
			}
		});
		lblPrenotazioni.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrenotazioni.setIcon(new ImageIcon(img.prenotazioni1()));
		lblPrenotazioni.setBounds(20, 320, 276, 162);
		add(lblPrenotazioni);

		JLabel lblGate = new JLabel("");
		lblGate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblGate.setIcon(new ImageIcon(img.gate2()));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblGate.setIcon(new ImageIcon(img.gate1()));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				controllerHome.mostraPannelli(controllerHome.getDashboard().getGestioneGate());
			}
		});
		lblGate.setHorizontalAlignment(SwingConstants.CENTER);
		lblGate.setIcon(new ImageIcon(img.gate1()));
		lblGate.setBounds(605, 320, 276, 162);
		add(lblGate);

		JLabel lblVolo = new JLabel("");
		lblVolo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblVolo.setIcon(new ImageIcon(img.voli2()));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblVolo.setIcon(new ImageIcon(img.voli1()));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				controllerHome.mostraPannelli(controllerHome.getDashboard().getGestioneVoli());
			}
		});
		lblVolo.setHorizontalAlignment(SwingConstants.CENTER);
		lblVolo.setIcon(new ImageIcon(img.voli1()));
		lblVolo.setBounds(312, 320, 276, 162);
		add(lblVolo);
	}
}
