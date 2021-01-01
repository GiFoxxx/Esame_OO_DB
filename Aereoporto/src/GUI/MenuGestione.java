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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class MenuGestione extends JFrame {
	
	private Image imgCasa = new ImageIcon(Accesso.class.getResource("immaginiMenuGestione/imgCasa.png")).getImage().getScaledInstance(30, 30,Image.SCALE_SMOOTH);


	private JPanel contentPane;

	Controller controllerMenuGestione;	
	private JTextField txtMenGestione;

	
	public MenuGestione(Controller controller) {
		controllerMenuGestione = controller;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 686, 446);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblimgCasa = new JLabel("");
		lblimgCasa.addMouseListener(new MouseAdapter() {
			@Override // clicco sulla casa e torno ad avvio
			public void mouseClicked(MouseEvent e) {
				controllerMenuGestione.tornaAdAvvioDaMenuGestione();
			}
		});
		lblimgCasa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblimgCasa.setHorizontalAlignment(SwingConstants.CENTER);
		lblimgCasa.setIcon(new ImageIcon(imgCasa));
		lblimgCasa.setBounds(630, 63, 30, 23);
		contentPane.add(lblimgCasa);
		
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
