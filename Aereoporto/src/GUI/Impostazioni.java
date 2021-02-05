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

		setBounds(0, 0, 894, 625);
		setBackground(controllerImpostazioni.sfondo);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Impostazioni");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 96));
		lblNewLabel.setBounds(154, 147, 656, 277);
		add(lblNewLabel);
	}

}
