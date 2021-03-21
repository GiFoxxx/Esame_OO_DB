package GUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import Controller.Controller;

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
		
		setBackground(controllerNoClick.temaNC);
		setLayout(null);
	}
}
