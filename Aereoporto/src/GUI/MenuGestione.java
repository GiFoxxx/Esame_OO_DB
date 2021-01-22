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
import java.awt.SystemColor;



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
		contentPane.setLayout(null);
		
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
		
		
		
		JButton btnGate = new JButton("Gate");
		btnGate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnGate.setBackground(SystemColor.controlDkShadow);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnGate.setBackground(Color.DARK_GRAY);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerMenuGestione.vaiAGateDaMenuGestione();
			}
		});
		
		JButton btnTratte = new JButton("Tratte");
		btnTratte.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnTratte.setBackground(SystemColor.controlDkShadow);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnTratte.setBackground(Color.DARK_GRAY);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
//				controllerMenuGestione.vaiAGestioneTrattaDaMenuGestione();
			}
		});
		btnTratte.setForeground(Color.WHITE);
		btnTratte.setFont(new Font("Arial", Font.BOLD, 12));
		btnTratte.setBorder(null);
		btnTratte.setBackground(Color.DARK_GRAY);
		btnTratte.setBounds(25, 305, 145, 52);
		contentPane.add(btnTratte);
		btnGate.setForeground(Color.WHITE);
		btnGate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGate.setFont(new Font("Arial", Font.BOLD, 12));
		btnGate.setBorder(null);
		btnGate.setBackground(Color.DARK_GRAY);
		btnGate.setBounds(401, 305, 175, 52);
		contentPane.add(btnGate);
		
		JButton btnCompagnieAereeAffiliate = new JButton("Compagnie aeree affiliate");
		btnCompagnieAereeAffiliate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCompagnieAereeAffiliate.setBackground(SystemColor.controlDkShadow);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnCompagnieAereeAffiliate.setBackground(Color.DARK_GRAY);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
//				controllerMenuGestione.vaiAGestioneCompagniaAereaDaMenuGestione();
			}
		});
		btnCompagnieAereeAffiliate.setForeground(Color.WHITE);
		btnCompagnieAereeAffiliate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCompagnieAereeAffiliate.setFont(new Font("Arial", Font.BOLD, 12));
		btnCompagnieAereeAffiliate.setBorder(null);
		btnCompagnieAereeAffiliate.setBackground(Color.DARK_GRAY);
		btnCompagnieAereeAffiliate.setBounds(205, 306, 175, 52);
		contentPane.add(btnCompagnieAereeAffiliate);
		lblX.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setForeground(Color.WHITE);
		lblX.setFont(new Font("Arial", Font.BOLD, 15));
		lblX.setBounds(560, 3, 30, 28);
		contentPane.add(lblX);
		
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
		
		JLabel lblTornaAdAccesso = new JLabel("Torna all'accesso");
		lblTornaAdAccesso.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				controllerMenuGestione.tornaAdAccessoDaMenuGestione();
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
		lblTornaAdAccesso.setBounds(10, 63, 101, 14);
		contentPane.add(lblTornaAdAccesso);
		
		JButton btnVoli = new JButton("Voli");
		btnVoli.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnVoli.setBackground(SystemColor.controlDkShadow);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnVoli.setBackground(Color.DARK_GRAY);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
//				controllerMenuGestione.vaiAGestioneVoliDaMenuGestione();
			}
		});
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
				btnPrenotazioni.setBackground(SystemColor.controlDkShadow);
			}

			@Override // tolgo da avanti e ritorno al colore
			public void mouseExited(MouseEvent e) {
				btnPrenotazioni.setBackground(Color.DARK_GRAY);
			}
		});
		btnPrenotazioni.setBorder(null);
		btnPrenotazioni.setFont(new Font("Arial", Font.BOLD, 12));
		btnPrenotazioni.setBounds(25, 159, 145, 52);
		contentPane.add(btnPrenotazioni);
		
		JButton btnModificaVoli = new JButton("Modifica informazioni voli");
		btnModificaVoli.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnModificaVoli.setBackground(SystemColor.controlDkShadow);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnModificaVoli.setBackground(Color.DARK_GRAY);
			}
		});
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
