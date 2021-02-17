package GUI;

import javax.swing.JPanel;

import Controller.Controller;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Impostazioni extends JPanel {

	private JLabel lblTema;
	private JLabel lblInformazioni;
	private JLabel lblRiconoscimenti;
	private JLabel lblTerminiECondizioni;
	private JLabel lblRecensione;

	// GETTER E SETTER

	public JLabel getLblTema() {
		return lblTema;
	}

	public void setLblTema(JLabel lblTema) {
		this.lblTema = lblTema;
	}

	public JLabel getLblInformazioni() {
		return lblInformazioni;
	}

	public void setLblInformazioni(JLabel lblInformazioni) {
		this.lblInformazioni = lblInformazioni;
	}

	public JLabel getLblRiconoscimenti() {
		return lblRiconoscimenti;
	}

	public void setLblRiconoscimenti(JLabel lblRiconoscimenti) {
		this.lblRiconoscimenti = lblRiconoscimenti;
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

		lblTema = new JLabel("Tema");
		lblTema.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (controllerImpostazioni.cambioTema()) {
					controllerImpostazioni.temaChiaro();
				} else {
					controllerImpostazioni.temaScuro();
				}
			}
		});
		lblTema.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblTema.setForeground(Color.LIGHT_GRAY);
		lblTema.setBounds(69, 180, 120, 22);
		add(lblTema);

		lblInformazioni = new JLabel("Informazioni");
		lblInformazioni.setForeground(Color.LIGHT_GRAY);
		lblInformazioni.setBounds(69, 230, 120, 22);
		add(lblInformazioni);

		lblRiconoscimenti = new JLabel("Riconoscimenti");
		lblRiconoscimenti.setForeground(Color.LIGHT_GRAY);
		lblRiconoscimenti.setBounds(69, 271, 120, 22);
		add(lblRiconoscimenti);

		lblTerminiECondizioni = new JLabel("Termini e condizioni");
		lblTerminiECondizioni.setForeground(Color.LIGHT_GRAY);
		lblTerminiECondizioni.setBounds(69, 314, 120, 22);
		add(lblTerminiECondizioni);

		lblRecensione = new JLabel("Lascia una recensione");
		lblRecensione.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerImpostazioni.mostraPannelli(controllerImpostazioni.getDashboard().getRecensioni());
			}
		});
		lblRecensione.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblRecensione.setForeground(Color.LIGHT_GRAY);
		lblRecensione.setBounds(69, 363, 120, 22);
		add(lblRecensione);
	}

}
