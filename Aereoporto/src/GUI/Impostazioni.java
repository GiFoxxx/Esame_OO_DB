package GUI;

import javax.swing.JPanel;

import Controller.Controller;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class Impostazioni extends JPanel {
	private JLabel lblInformazioni;
	private JLabel lblTerminiECondizioni;
	private JLabel lblRecensione;

	// GETTER E SETTER

	public JLabel getLblInformazioni() {
		return lblInformazioni;
	}

	public void setLblInformazioni(JLabel lblInformazioni) {
		this.lblInformazioni = lblInformazioni;
	}

	public JLabel getLblTerminiECondizioni() {
		return lblTerminiECondizioni;
	}

	public void setLblTerminiECondizioni(JLabel lblTerminiECondizioni) {
		this.lblTerminiECondizioni = lblTerminiECondizioni;
	}

	public JLabel getLblRecensione() {
		return lblRecensione;
	}

	public void setLblRecensione(JLabel lblRecensione) {
		this.lblRecensione = lblRecensione;
	}

	Controller controllerImpostazioni;

	public Impostazioni(Controller controller) {
		controllerImpostazioni = controller;

		setBounds(0, 0, 1090, 642);
		setBackground(controllerImpostazioni.sfondoTemaScuro);
		setLayout(null);

		lblInformazioni = new JLabel("Informazioni");
		lblInformazioni.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblInformazioni.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformazioni.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerImpostazioni.mostraInformazioni();
				
			}
		});
		lblInformazioni.setFont(controllerImpostazioni.fontLabel);
		lblInformazioni.setForeground(controllerImpostazioni.coloreScritteTemaScuro);
		lblInformazioni.setBounds(485, 251, 120, 22);
		add(lblInformazioni);

		lblTerminiECondizioni = new JLabel("Termini e condizioni");
		lblTerminiECondizioni.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblTerminiECondizioni.setHorizontalAlignment(SwingConstants.CENTER);
		lblTerminiECondizioni.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerImpostazioni.mostraTerminiECondizioni();
			}
		});
		lblTerminiECondizioni.setFont(controllerImpostazioni.fontLabel);
		lblTerminiECondizioni.setForeground(controllerImpostazioni.coloreScritteTemaScuro);
		lblTerminiECondizioni.setBounds(485, 310, 120, 22);
		add(lblTerminiECondizioni);

		lblRecensione = new JLabel("Lascia una recensione");
		lblRecensione.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerImpostazioni.mostraPannelli(controllerImpostazioni.getDashboard().getRecensioni());
				controllerImpostazioni.setPannelloPrecedente(12);
			}
		});
		lblRecensione.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblRecensione.setFont(controllerImpostazioni.fontLabel);
		lblRecensione.setForeground(controllerImpostazioni.coloreScritteTemaScuro);
		lblRecensione.setBounds(485, 381, 180, 22);
		add(lblRecensione);
	}
}
