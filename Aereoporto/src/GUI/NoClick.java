package GUI;

import javax.swing.JPanel;

import Controller.Controller;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NoClick extends JPanel {
	
	Controller controllerNoClick;
	
	public NoClick(Controller controller) {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerNoClick.chiudiTendinaIstantanea();
				controllerNoClick.getDashboard().getMenuInfoAccount().setVisible(false);
				controllerNoClick.pannelloPrecedentementeSelezionato(controllerNoClick.getPannelloPrecedente());
			}
		});

		controllerNoClick = controller;
		
		setBackground(new Color(0, 0, 0, 50));
		setLayout(null);
	}
}
