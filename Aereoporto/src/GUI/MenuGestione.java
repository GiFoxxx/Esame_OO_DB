package GUI;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import Controller.Controller;
import Controller.Controller;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Classi.ClienteBusiness;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;



public class MenuGestione extends JFrame {

	private JPanel contentPane;

	Controller controllerAccesso;	
	private JTextField txtMenGestione;

	
	public MenuGestione(Controller controller) {
		controllerAccesso = controller;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 686, 446);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Voli");
		btnNewButton.setBounds(253, 170, 145, 52);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Prenotazioni");
		btnNewButton_1.setBounds(45, 170, 145, 52);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Modifica informazioni voli");
		btnNewButton_2.setBounds(456, 170, 168, 52);
		contentPane.add(btnNewButton_2);
		
		txtMenGestione = new JTextField();
		txtMenGestione.setText("MEN\u00D9 GESTIONE");
		txtMenGestione.setHorizontalAlignment(SwingConstants.CENTER);
		txtMenGestione.setFont(new Font("Arial", Font.BOLD, 30));
		txtMenGestione.setBounds(0, 0, 670, 52);
		contentPane.add(txtMenGestione);
		txtMenGestione.setColumns(10);
		
		
	}
}
