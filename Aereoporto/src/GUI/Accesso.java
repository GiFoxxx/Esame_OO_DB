package GUI;

import Controller.Controller;

import Database.ConnessioneDatabase;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;
import java.sql.*;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Cursor;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import javax.swing.UIManager;
import javax.swing.DebugGraphics;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import java.awt.Rectangle;
import java.awt.Window.Type;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.border.MatteBorder;

public class Accesso extends JFrame {

	// ridimensionamento immagine
	private Image imgUtente = new ImageIcon(Accesso.class.getResource("immaginiAccesso/imgUtente.png")).getImage()
			.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
	private Image imgPassword = new ImageIcon(Accesso.class.getResource("immaginiAccesso/imgPassword.png")).getImage()
			.getScaledInstance(16, 19, Image.SCALE_SMOOTH);
	private Image imgfrecciaIndietro1 = new ImageIcon(
			Accesso.class.getResource("immaginiAccesso/imgfrecciaIndietro1.png")).getImage().getScaledInstance(30, 30,
					Image.SCALE_SMOOTH);
	private Image imgfrecciaIndietro2 = new ImageIcon(
			Accesso.class.getResource("immaginiAccesso/imgfrecciaIndietro2.png")).getImage().getScaledInstance(30, 30,
					Image.SCALE_SMOOTH);
	private Image imgsfondoAccesso = new ImageIcon(Accesso.class.getResource("immaginiAccesso/imgsfondoAccesso.jpg"))
			.getImage().getScaledInstance(423, 275, Image.SCALE_SMOOTH);
	private Image imgCasa1 = new ImageIcon(Accesso.class.getResource("immaginiAccesso/imgCasa1.png")).getImage()
			.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image imgCasa2 = new ImageIcon(Accesso.class.getResource("immaginiAccesso/imgCasa2.png")).getImage()
			.getScaledInstance(30, 30, Image.SCALE_SMOOTH);

	private JPanel contentPane;

	public JTextField getTxtUtente() {
		return txtfldEmail;
	}

	public void setTxtUtente(JTextField txtUtente) {
		this.txtfldEmail = txtUtente;
	}

	public JTextField getTxtPassword() {
		return txtfldPassword;
	}

	public void setTxtPassword(JTextField txtPassword) {
		this.txtfldPassword = (JPasswordField) txtPassword;
	}

	private JTextField txtfldEmail;
	private JPasswordField txtfldPassword;
	private JLabel lblMessaggioCredenziali = new JLabel("");
	private JTextField txtAccedi;

	Controller controllerAccesso;

	public Accesso(Controller controller) {
		controllerAccesso = controller;

		setTitle("Schermata di accesso");
		setForeground(new Color(240, 240, 240));
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 423, 313);
		contentPane = new JPanel();
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(70, 130, 180)));
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		contentPane.setFocusCycleRoot(true);
		contentPane.setBackground(new Color(0, 52, 75));
		contentPane.setForeground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true); // togliamo l'interfaccia prefedefinita di java

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
				Accesso.this.dispose();
			}
		});

		JLabel lblimgCasa = new JLabel("");
		lblimgCasa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblimgCasa.addMouseListener(new MouseAdapter() {
			@Override // clicco sulla casa e torno ad avvio
			public void mouseClicked(MouseEvent e) {
				controllerAccesso.tornaAdAvvioDaAccesso();
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

		JLabel lblGestisciUtenti = new JLabel("Gestione utenti");
		lblGestisciUtenti.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestisciUtenti.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerAccesso.gestioneUtentiDaAccesso();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblGestisciUtenti.setForeground(new Color(70, 130, 180));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblGestisciUtenti.setForeground(Color.WHITE);
			}
		});
		lblGestisciUtenti.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblGestisciUtenti.setForeground(Color.WHITE);
		lblGestisciUtenti.setFont(new Font("Arial", Font.BOLD, 12));
		lblGestisciUtenti.setBounds(10, 271, 85, 32);
		contentPane.add(lblGestisciUtenti);

		lblimgCasa.setHorizontalAlignment(SwingConstants.CENTER);
		lblimgCasa.setIcon(new ImageIcon(imgCasa1));
		lblimgCasa.setBounds(383, 46, 30, 23);
		contentPane.add(lblimgCasa);
		lblX.setForeground(Color.WHITE);
		lblX.setFont(new Font("Arial", Font.BOLD, 15));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setBounds(399, 0, 24, 23);
		contentPane.add(lblX);

		JButton btnAvanti = new JButton("Avanti");

		btnAvanti.addMouseListener(new MouseAdapter() {
			@Override // clicco su avanti
			public void mouseClicked(MouseEvent e) {
//				controllerAccesso.Accedi();
			}

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
		btnAvanti.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAvanti.setForeground(new Color(255, 255, 255));
		btnAvanti.setFont(new Font("Arial", Font.BOLD, 12));

		btnAvanti.setBounds(238, 201, 78, 32);
		contentPane.add(btnAvanti);

		JPanel pnlUtente = new JPanel();
		pnlUtente.setBackground(new Color(211, 211, 211));
		pnlUtente.setForeground(new Color(0, 0, 0));
		pnlUtente.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		pnlUtente.setBounds(107, 83, 209, 32);
		contentPane.add(pnlUtente);
		pnlUtente.setLayout(null);

		JLabel lblimgUtente = new JLabel("");
		lblimgUtente.setBounds(0, 0, 30, 32);
		pnlUtente.add(lblimgUtente);
		lblimgUtente.setHorizontalAlignment(SwingConstants.CENTER);
		lblimgUtente.setIcon(new ImageIcon(imgUtente));

		txtfldEmail = new JTextField();
//		txtNomeUtente.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyPressed(KeyEvent EventoInvio) {
//				if (EventoInvio.getKeyCode() == KeyEvent.VK_ENTER) {
//					controllerAccesso.Accedi();
//				}
//			}
//		});

		txtfldEmail.setToolTipText("");
		txtfldEmail.setHorizontalAlignment(SwingConstants.LEFT);
		txtfldEmail.setFont(new Font("Arial", Font.PLAIN, 11));
		txtfldEmail.setBackground(new Color(211, 211, 211));
		txtfldEmail.setForeground(new Color(169, 169, 169));
		txtfldEmail.setCaretColor(new Color(0, 0, 0));
		txtfldEmail.setBorder(null);
		txtfldEmail.setBounds(31, 0, 178, 32);
		txtfldEmail.setText("");
		pnlUtente.add(txtfldEmail);
		txtfldEmail.setColumns(10);

		JPanel pnlPassword = new JPanel();
		pnlPassword.setBackground(new Color(211, 211, 211));
		pnlPassword.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		pnlPassword.setBounds(107, 123, 209, 32);
		contentPane.add(pnlPassword);
		pnlPassword.setLayout(null);

		JLabel lblimgPassword = new JLabel("");
		lblimgPassword.setBounds(0, 0, 33, 32);
		pnlPassword.add(lblimgPassword);
		lblimgPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblimgPassword.setIcon(new ImageIcon(imgPassword));

		txtfldPassword = new JPasswordField();
//		txtPassword.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyPressed(KeyEvent EventoInvio) {
//				if (EventoInvio.getKeyCode() == KeyEvent.VK_ENTER) {
//					controllerAccesso.Accedi();
//				}
//			}
//		});

		txtfldPassword.setForeground(new Color(169, 169, 169));
		txtfldPassword.setHorizontalAlignment(SwingConstants.LEFT);
		txtfldPassword.setBorder(null);
		txtfldPassword.setText("");
		txtfldPassword.setBackground(new Color(211, 211, 211));
		txtfldPassword.setBounds(31, 0, 178, 32);
		pnlPassword.add(txtfldPassword);

		JButton btnCreaAccount = new JButton("Crea account");

		btnCreaAccount.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCreaAccount.setForeground(new Color(255, 255, 255));
		btnCreaAccount.addMouseListener(new MouseAdapter() {

			@Override // vado a registrazione da crea un nuovo account da accedi
			public void mouseClicked(MouseEvent e) {
				controllerAccesso.registrazioneDaAccesso();
			}

			@Override // su "crea nuovo account" passo sopra e metto il blu scuro
			public void mouseEntered(MouseEvent e) {
				btnCreaAccount.setBackground(new Color(51, 102, 153));
			}

			@Override // da "crea nuovo account" tolgo da sopra e rimetto il bianco
			public void mouseExited(MouseEvent e) {
				btnCreaAccount.setBackground(new Color(70, 130, 180));
			}
		});

		btnCreaAccount.setBackground(new Color(70, 130, 180));
		btnCreaAccount.setBorder(null);
		btnCreaAccount.setFont(new Font("Arial", Font.BOLD, 12));
		btnCreaAccount.setBounds(107, 201, 121, 32);
		contentPane.add(btnCreaAccount);

		lblMessaggioCredenziali.setForeground(new Color(139, 69, 19));
		lblMessaggioCredenziali.setFont(new Font("Arial", Font.PLAIN, 10));
		lblMessaggioCredenziali.setBounds(99, 166, 209, 14);
		contentPane.add(lblMessaggioCredenziali);

		txtAccedi = new JTextField();
		txtAccedi.setEditable(false);
		txtAccedi.setForeground(Color.WHITE);
		txtAccedi.setText("ACCEDI");
		txtAccedi.setHorizontalAlignment(SwingConstants.CENTER);
		txtAccedi.setFont(new Font("Arial", Font.BOLD, 14));
		txtAccedi.setBackground(new Color(70, 130, 180));
		txtAccedi.setBounds(0, 0, 423, 39);
		contentPane.add(txtAccedi);
		txtAccedi.setColumns(10);

		JLabel lblimgsfondoAccesso = new JLabel("");
		lblimgsfondoAccesso.setHorizontalAlignment(SwingConstants.CENTER);
		lblimgsfondoAccesso.setIcon(new ImageIcon(imgsfondoAccesso));
		lblimgsfondoAccesso.setBounds(0, 38, 423, 275);
		contentPane.add(lblimgsfondoAccesso);

	}

	// METODI
	public void MostraInserimentoCredenziali() {
		lblMessaggioCredenziali.setText("Perfavore, inserisci le credenziali!");
	}

	public void MostraErroreAccesso() {
		lblMessaggioCredenziali.setText("Nome utente o password errati. Riprova");
	}

	public void SicuroTornareIndietro() {
		Object[] options = { "SI", "ANNULLA" };
		if (JOptionPane.showOptionDialog(null,
				"Sei sicuro di voler tornare indietro? Hai lasciato delle cose in sospeso!", "ATTENZIONE",
				JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]) == 0) {
			controllerAccesso.tornaAdAvvioDaAccesso();
		}
	}
}