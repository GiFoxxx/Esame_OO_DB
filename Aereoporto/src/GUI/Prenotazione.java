package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;

import javax.swing.JList;
import javax.swing.JScrollPane;
import java.awt.ScrollPane;
import java.awt.Choice;
import javax.swing.JComboBox;

public class Prenotazione extends JFrame {

	private JPanel contentPane;
	
	Controller controllerPrenotazioni;

	public Prenotazione(Controller controller) {
		
		controllerPrenotazioni=controller;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 970, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
