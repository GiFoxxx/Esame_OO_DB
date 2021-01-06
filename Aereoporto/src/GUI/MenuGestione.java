package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
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
	
	private Image imgCasa1 = new ImageIcon(Accesso.class.getResource("immaginiMenuGestione/imgCasa1.png")).getImage().getScaledInstance(30, 30,Image.SCALE_SMOOTH);
	private Image imgCasa2 = new ImageIcon(Accesso.class.getResource("immaginiMenuGestione/imgCasa2.png")).getImage().getScaledInstance(30, 30,Image.SCALE_SMOOTH);
	private Image imgsfondoMenuGestione = new ImageIcon(Accesso.class.getResource("immaginiMenuGestione/imgsfondoMenuGestione.jpg")).getImage().getScaledInstance(590, 317,Image.SCALE_SMOOTH);



	private JPanel contentPane;

	Controller controllerMenuGestione;	
	private JTextField txtGestione;

	
	public MenuGestione(Controller controller) {
		controllerMenuGestione = controller;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setUndecorated(true);

		
		JLabel lblimgCasa = new JLabel("");
		lblimgCasa.setBounds(10, 335, 30, 23);
		lblimgCasa.addMouseListener(new MouseAdapter() {
			@Override // clicco sulla casa e torno ad avvio
			public void mouseClicked(MouseEvent e) {
				controllerMenuGestione.tornaAdAvvioDaMenuGestione();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblimgCasa.setIcon(new ImageIcon(imgCasa2));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblimgCasa.setIcon(new ImageIcon(imgCasa1));
			}
		});
		contentPane.setLayout(null);
		
		JLabel lblTornaARegistrazione = new JLabel("Torna alla registrazione");
		lblTornaARegistrazione.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerMenuGestione.tornaARegistrazioneDaMenuGestione();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblTornaARegistrazione.setForeground(new Color(70, 130, 180));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblTornaARegistrazione.setForeground(Color.WHITE);
			}
		});
		
		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override // sulla x per chiudere il programma passo sopra e metto il rosso
			public void mouseEntered(MouseEvent e) {
				lblX.setForeground(Color.RED);
			}
			@Override // dalla x per chiudere il programma tolgo da sopra e rimetto il bianco
			public void mouseExited(MouseEvent e) {
				lblX.setForeground(Color.WHITE);
			}

			@Override // clicco sulla X e chiudo il programma
			public void mouseClicked(MouseEvent e) {
				MenuGestione.this.dispose();
			}
		});
		
		txtGestione = new JTextField();
		txtGestione.setBackground(Color.DARK_GRAY);
		txtGestione.setForeground(Color.WHITE);
		txtGestione.setText("GESTIONE");
		txtGestione.setHorizontalAlignment(SwingConstants.CENTER);
		txtGestione.setFont(new Font("Arial", Font.BOLD, 15));
		txtGestione.setEditable(false);
		txtGestione.setBounds(0, 0, 590, 52);
		contentPane.add(txtGestione);
		txtGestione.setColumns(10);
		lblX.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setForeground(Color.WHITE);
		lblX.setFont(new Font("Arial", Font.BOLD, 15));
		lblX.setBounds(560, 3, 30, 28);
		contentPane.add(lblX);
		lblTornaARegistrazione.setForeground(Color.WHITE);
		lblTornaARegistrazione.setFont(new Font("Arial", Font.BOLD, 12));
		lblTornaARegistrazione.setHorizontalAlignment(SwingConstants.CENTER);
		lblTornaARegistrazione.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblTornaARegistrazione.setBounds(446, 344, 134, 14);
		contentPane.add(lblTornaARegistrazione);
		
		JLabel lblTornaAdAccesso = new JLabel("Torna all'accesso");
		lblTornaAdAccesso.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerMenuGestione.tornaAdAccessoDaMenuGestione();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblTornaAdAccesso.setForeground(new Color(70, 130, 180));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblTornaAdAccesso.setForeground(Color.WHITE);
			}
		});
		lblTornaAdAccesso.setForeground(Color.WHITE);
		lblTornaAdAccesso.setFont(new Font("Arial", Font.BOLD, 12));
		lblTornaAdAccesso.setHorizontalAlignment(SwingConstants.CENTER);
		lblTornaAdAccesso.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblTornaAdAccesso.setBounds(479, 319, 101, 14);
		contentPane.add(lblTornaAdAccesso);
		lblimgCasa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblimgCasa.setHorizontalAlignment(SwingConstants.CENTER);
		lblimgCasa.setIcon(new ImageIcon(imgCasa1));
		contentPane.add(lblimgCasa);
		
		JButton btnVoli = new JButton("Voli");
		btnVoli.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVoli.setForeground(Color.WHITE);
		btnVoli.setBackground(Color.DARK_GRAY);
		btnVoli.setBorder(null);
		btnVoli.setFont(new Font("Arial", Font.BOLD, 12));
		btnVoli.setBounds(220, 159, 145, 52);
		contentPane.add(btnVoli);
		
		JButton btnPrenotazioni = new JButton("Prenotazioni");
		btnPrenotazioni.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPrenotazioni.setForeground(Color.WHITE);
		btnPrenotazioni.setBackground(Color.DARK_GRAY);
		btnPrenotazioni.addMouseListener(new MouseAdapter() {
			@Override // passo su avanti e cambio colore
			public void mouseEntered(MouseEvent e) {
				btnPrenotazioni.setBackground(new Color(51, 102, 153));
			}

			@Override // tolgo da avanti e ritorno al colore
			public void mouseExited(MouseEvent e) {
				btnPrenotazioni.setBackground(new Color(70, 130, 180));
			}
		});
		btnPrenotazioni.setBorder(null);
		btnPrenotazioni.setFont(new Font("Arial", Font.BOLD, 12));
		btnPrenotazioni.setBounds(25, 159, 145, 52);
		contentPane.add(btnPrenotazioni);
		
		JButton btnModificaVoli = new JButton("Modifica informazioni voli");
		btnModificaVoli.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnModificaVoli.setForeground(Color.WHITE);
		btnModificaVoli.setBackground(Color.DARK_GRAY);
		btnModificaVoli.setBorder(null);
		btnModificaVoli.setFont(new Font("Arial", Font.BOLD, 12));
		btnModificaVoli.setBounds(412, 159, 168, 52);
		contentPane.add(btnModificaVoli);
		
		JLabel lblimasfondoMenuGestione = new JLabel("");
		lblimasfondoMenuGestione.setBounds(0, 52, 590, 317);
		lblimasfondoMenuGestione.setHorizontalAlignment(SwingConstants.CENTER);
		lblimasfondoMenuGestione.setIcon(new ImageIcon(imgsfondoMenuGestione));
		contentPane.add(lblimasfondoMenuGestione);
		
		
	}
}
