package GUI;

import javax.swing.JPanel;

import Controller.Controller;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Impostazioni extends JPanel {

	Controller controllerImpostazioni;
	
	
	public Impostazioni(Controller controller) {
		controllerImpostazioni = controller;

		setBounds(0, 0, 1090, 642);
		setBackground(controllerImpostazioni.sfondo);
		setLayout(null);
		
		JLabel lblTema = new JLabel("Tema");
		lblTema.setForeground(Color.LIGHT_GRAY);
		lblTema.setBounds(69, 180, 120, 22);
		add(lblTema);
		
		JLabel lblInformazioni = new JLabel("Informazioni");
		lblInformazioni.setForeground(Color.LIGHT_GRAY);
		lblInformazioni.setBounds(69, 230, 120, 22);
		add(lblInformazioni);
		
		JLabel lblRiconoscimenti = new JLabel("Riconoscimenti");
		lblRiconoscimenti.setForeground(Color.LIGHT_GRAY);
		lblRiconoscimenti.setBounds(69, 271, 120, 22);
		add(lblRiconoscimenti);
		
		JLabel lblTermECondiz = new JLabel("Termini e condizioni");
		lblTermECondiz.setForeground(Color.LIGHT_GRAY);
		lblTermECondiz.setBounds(69, 314, 120, 22);
		add(lblTermECondiz);
		
		JLabel lblRecensione = new JLabel("Lascia una recensione");
		lblRecensione.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerImpostazioni.mostraPannelli(controllerImpostazioni.getDashboard().getRecensione());
			}
		});
		lblRecensione.setForeground(Color.LIGHT_GRAY);
		lblRecensione.setBounds(69, 363, 120, 22);
		add(lblRecensione);
	}

}
