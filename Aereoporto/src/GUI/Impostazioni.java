package GUI;

import javax.swing.JPanel;

import Controller.Controller;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class Impostazioni extends JPanel {

	Controller controllerImpostazioni;
	
	
	public Impostazioni(Controller controller) {
		controllerImpostazioni = controller;

		setBounds(0, 0, 1090, 634);
		setBackground(controllerImpostazioni.sfondo);
		setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Tema");
		lblNewLabel_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1.setBounds(69, 180, 88, 22);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Informazioni");
		lblNewLabel_1_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1_1.setBounds(69, 230, 88, 22);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Riconoscimenti");
		lblNewLabel_1_2.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1_2.setBounds(69, 271, 88, 22);
		add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Termini e condizioni");
		lblNewLabel_1_1_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1_1_1.setBounds(69, 314, 101, 22);
		add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel = new JLabel("Lascia una recensione");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setBounds(69, 363, 117, 14);
		add(lblNewLabel);
	}

}
