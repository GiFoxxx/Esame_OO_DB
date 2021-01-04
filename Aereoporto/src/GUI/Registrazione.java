package GUI;
import java.awt.BorderLayout;

import Amministrazione.Utente;
import Amministrazione.UtenteImplementazionePostgresDAO;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.Point;
import Database.ConnessioneDatabase;

import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Amministrazione.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import javax.swing.border.BevelBorder;
import Amministrazione.*;

public class Registrazione extends JFrame {
	
	

	private Image imgfrecciaIndietro = new ImageIcon(Registrazione.class.getResource("immaginiRegistrazione/imgfrecciaIndietro.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image imgsfondoRegistrazione = new ImageIcon(Registrazione.class.getResource("immaginiRegistrazione/imgsfondoRegistrazione.jpg")).getImage().getScaledInstance(500, 340, Image.SCALE_SMOOTH);
	private Image imgCasa = new ImageIcon(Accesso.class.getResource("immaginiRegistrazione/imgCasa.png")).getImage().getScaledInstance(30, 30,Image.SCALE_SMOOTH);

	
	private JPanel contentPane;
	private JTextField txtfldNome;
	private JTextField txtRegistrati;

	private JTextField txtfldCognome;
	private JTextField txtfldEmail;
	private JPasswordField txtfldPassword;

	Controller controllerRegistrazione;


	public Registrazione(Controller controller) {
		controllerRegistrazione = controller;

		setTitle("Schermata di registrazione");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(0, 52, 75));
		setUndecorated(true);

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
				Registrazione.this.dispose();
			}
		});
		
		JLabel lblimgCasa = new JLabel("");
		lblimgCasa.addMouseListener(new MouseAdapter() {
			@Override // clicco sulla casa e torno ad avvio
			public void mouseClicked(MouseEvent e) {
				controllerRegistrazione.tornaAdAvvioDaRegistrazione();
			}
		});
		lblimgCasa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblimgCasa.setHorizontalAlignment(SwingConstants.CENTER);
		lblimgCasa.setIcon(new ImageIcon(imgCasa));
		lblimgCasa.setBounds(460, 58, 30, 23);
		contentPane.add(lblimgCasa);
		lblX.setForeground(Color.WHITE);
		lblX.setFont(new Font("Arial", Font.BOLD, 15));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setBounds(476, -1, 24, 23);
		contentPane.add(lblX);

		txtfldNome = new JTextField();
		txtfldNome.setFont(new Font("Arial", Font.PLAIN, 12));
		txtfldNome.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		txtfldNome.setBorder(null);
		txtfldNome.setBackground(new Color(211, 211, 211));
		txtfldNome.setBounds(161, 105, 178, 23);
		contentPane.add(txtfldNome);
		txtfldNome.setColumns(10);

		txtRegistrati = new JTextField();
		txtRegistrati.setForeground(Color.WHITE);
		txtRegistrati.setEditable(false);
		txtRegistrati.setHorizontalAlignment(SwingConstants.CENTER);
		txtRegistrati.setFont(new Font("Arial", Font.BOLD, 16));
		txtRegistrati.setText("REGISTRATI");
		txtRegistrati.setBounds(0, -1, 500, 52);
		txtRegistrati.setBackground(new Color(70, 130, 180));
		contentPane.add(txtRegistrati);
		txtRegistrati.setColumns(10);

		JButton btnAvanti = new JButton("Avanti");
		btnAvanti.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		btnAvanti.addMouseListener(new MouseAdapter() {
//			@Override // clicco su avanti
//			public void mouseClicked(MouseEvent e) {
//				controllerRegistrazione.menuGestioneDaRegistrazione();
//			}

			@Override // passo su avanti e cambio colore
			public void mouseEntered(MouseEvent e) {
				btnAvanti.setBackground(new Color(51, 102, 153));
			}

			@Override // tolgo da avanti e ritorno al colore
			public void mouseExited(MouseEvent e) {
				btnAvanti.setBackground(new Color(70, 130, 180));
			}
		});

		btnAvanti.setBorder(null);
		btnAvanti.setBackground(new Color(70, 130, 180));
		btnAvanti.setForeground(Color.WHITE);
		btnAvanti.setFont(new Font("Arial", Font.BOLD, 14));
		btnAvanti.setBounds(257, 257, 82, 32);
		contentPane.add(btnAvanti);

		txtfldCognome = new JTextField();
		txtfldCognome.setFont(new Font("Arial", Font.PLAIN, 12));
		txtfldCognome.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		txtfldCognome.setBackground(new Color(211, 211, 211));
		txtfldCognome.setBorder(null);
		txtfldCognome.setBounds(161, 139, 178, 23);
		contentPane.add(txtfldCognome);
		txtfldCognome.setColumns(10);

		txtfldEmail = new JTextField();
		txtfldEmail.setFont(new Font("Arial", Font.PLAIN, 12));
		txtfldEmail.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		txtfldEmail.setBackground(new Color(211, 211, 211));
		txtfldEmail.setBorder(null);
		txtfldEmail.setBounds(161, 173, 178, 23);
		contentPane.add(txtfldEmail);
		txtfldEmail.setColumns(10);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Arial", Font.BOLD, 12));
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setForeground(new Color(70, 130, 180));
		lblNome.setBounds(97, 105, 53, 23);
		contentPane.add(lblNome);

		JLabel lblCognome = new JLabel("Cognome");
		lblCognome.setFont(new Font("Arial", Font.BOLD, 12));
		lblCognome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCognome.setForeground(new Color(70, 130, 180));
		lblCognome.setBounds(84, 139, 67, 23);
		contentPane.add(lblCognome);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Arial", Font.BOLD, 12));
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setForeground(new Color(70, 130, 180));
		lblEmail.setBounds(94, 173, 57, 23);
		contentPane.add(lblEmail);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Arial", Font.BOLD, 12));
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setForeground(new Color(70, 130, 180));
		lblPassword.setBounds(84, 208, 67, 23);
		contentPane.add(lblPassword);

		JButton btnTornaAllaHome = new JButton("Annulla");
		btnTornaAllaHome.setBorder(null);
		btnTornaAllaHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnTornaAllaHome.addMouseListener(new MouseAdapter() {
			@Override // torno da registrazione ad accesso
			public void mouseClicked(MouseEvent e) {
				controllerRegistrazione.tornaAdAvvioDaRegistrazione();
			}

			@Override // passo su indietro e cambio colore
			public void mouseEntered(MouseEvent e) {
				btnTornaAllaHome.setBackground(new Color(51, 102, 153));
			}

			@Override // tolgo da indietro e ritorno al colore
			public void mouseExited(MouseEvent e) {
				btnTornaAllaHome.setBackground(new Color(70, 130, 180));
			}
		});
		btnTornaAllaHome.setBackground(new Color(70, 130, 180));
		btnTornaAllaHome.setForeground(Color.WHITE);
		btnTornaAllaHome.setFont(new Font("Arial", Font.BOLD, 12));

		btnTornaAllaHome.setBounds(161, 257, 82, 32);
		contentPane.add(btnTornaAllaHome);

		JLabel lblimgfrecciaIndietro = new JLabel("");
		lblimgfrecciaIndietro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblimgfrecciaIndietro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerRegistrazione.tornaAdAccessoDaRegistrazione();
			}
		});
		lblimgfrecciaIndietro.setHorizontalAlignment(SwingConstants.CENTER);
		lblimgfrecciaIndietro.setBounds(10, 62, 46, 14);
		lblimgfrecciaIndietro.setIcon(new ImageIcon(imgfrecciaIndietro));

		contentPane.add(lblimgfrecciaIndietro);

		txtfldPassword = new JPasswordField();
		txtfldPassword.setFont(new Font("Arial", Font.PLAIN, 12));
		txtfldPassword.setBackground(new Color(211, 211, 211));
		txtfldPassword.setBounds(161, 208, 178, 23);
		contentPane.add(txtfldPassword);
		
		JLabel lblimgsfondoRegistrazione = new JLabel("");
		lblimgsfondoRegistrazione.setHorizontalAlignment(SwingConstants.CENTER);
		lblimgsfondoRegistrazione.setIcon(new ImageIcon(imgsfondoRegistrazione));
		lblimgsfondoRegistrazione.setBounds(0, 52, 500, 288);
		contentPane.add(lblimgsfondoRegistrazione);

	}
}