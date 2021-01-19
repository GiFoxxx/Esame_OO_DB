package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.util.ArrayList;
import java.util.List;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Amministrazione.*;
import Controller.Controller;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.awt.Font;
import java.awt.Image;

public class GestioneUtenti extends JFrame {

	String colonne[] = {"Nome", "Cognome", "Email", "Password"};
	final Object[] row = new Object[4];
	DefaultTableModel modello = new DefaultTableModel(colonne, 0);
	ArrayList<Object[]> ListaUtenti = new ArrayList<>();
	
	private Image imgfrecciaIndietro1 = new ImageIcon(Registrazione.class.getResource("immaginiRegistrazione/imgfrecciaIndietro1.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image imgfrecciaIndietro2 = new ImageIcon(Registrazione.class.getResource("immaginiRegistrazione/imgfrecciaIndietro2.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image imgCasa1 = new ImageIcon(Registrazione.class.getResource("immaginiRegistrazione/imgCasa1.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image imgCasa2 = new ImageIcon(Registrazione.class.getResource("immaginiRegistrazione/imgCasa2.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);

	private JPanel contentPane;
	private final JLabel lblCognome = new JLabel("cognome");
	private JLabel lblEmail;
	private JLabel lblPassword;
	private final JTextField txtCognome = new JTextField();
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtPassword;
	private JButton btnModifica;
	private JButton btnElimina;
	private JButton btnAggiungi;

	Controller controllerGestioneUtenti;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnNewButton;

	//GETTER E SETTER
	public DefaultTableModel getModello() {
		return modello;
	}

	public void setModello(DefaultTableModel modello) {
		this.modello = modello;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public Object[] getRow() {
		return row;
	}
	public JTextField getTxtNome() {
		return txtNome;
	}

	public void setTxtNome(JTextField txtNome) {
		this.txtNome = txtNome;
	}

	public JTextField getTxtEmail() {
		return txtEmail;
	}

	public void setTxtEmail(JTextField txtEmail) {
		this.txtEmail = txtEmail;
	}

	public JTextField getTxtPassword() {
		return txtPassword;
	}

	public void setTxtPassword(JTextField txtPassword) {
		this.txtPassword = txtPassword;
	}

	public JTextField getTxtCognome() {
		return txtCognome;
	}
	
	//CREAZIONE GUI
	public GestioneUtenti(Controller controller) {
			
		controllerGestioneUtenti=controller;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblimgfrecciaIndietro = new JLabel("");
		lblimgfrecciaIndietro.addMouseListener(new MouseAdapter() {
			// Click sulla freccia in alto a sinistra
			@Override // chiusura finestra diretta se campi vuoti - chiusura finestra a richiesta se
						// campi pieni
			public void mouseClicked(MouseEvent e) {
				controllerGestioneUtenti.tornaAdAccessoDaGestioneUtenti();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblimgfrecciaIndietro.setIcon(new ImageIcon(imgfrecciaIndietro2));

			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblimgfrecciaIndietro.setIcon(new ImageIcon(imgfrecciaIndietro1));

			}
		});
		lblimgfrecciaIndietro.setBorder(null);
		lblimgfrecciaIndietro.setBackground(new Color(70, 130, 180));
		lblimgfrecciaIndietro.setIcon(new ImageIcon(imgfrecciaIndietro1));
		lblimgfrecciaIndietro.setForeground(new Color(0, 0, 0));
		lblimgfrecciaIndietro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblimgfrecciaIndietro.setFont(new Font("Arial", Font.BOLD, 11));
		lblimgfrecciaIndietro.setHorizontalAlignment(SwingConstants.CENTER);
		lblimgfrecciaIndietro.setBounds(10, 11, 37, 14);
		contentPane.add(lblimgfrecciaIndietro);
		
		JLabel lblNome = new JLabel("nome");
		lblNome.setBounds(131, 231, 46, 14);
		contentPane.add(lblNome);
		lblCognome.setBounds(127, 256, 60, 27);
		contentPane.add(lblCognome);
		
		lblEmail = new JLabel("email");
		lblEmail.setBounds(131, 294, 46, 14);
		contentPane.add(lblEmail);
		
		lblPassword = new JLabel("password");
		lblPassword.setBounds(127, 326, 46, 14);
		contentPane.add(lblPassword);
		
		txtNome = new JTextField();
		txtNome.setBounds(221, 217, 133, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		txtCognome.setBounds(221, 248, 157, 20);
		contentPane.add(txtCognome);
		txtCognome.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(210, 291, 144, 20);
		txtEmail.setColumns(10);
		contentPane.add(txtEmail);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(221, 320, 133, 20);
		txtPassword.setColumns(10);
		contentPane.add(txtPassword);
		
		btnModifica = new JButton("modifica");
		btnModifica.setBounds(32, 124, 89, 23);
		btnModifica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneUtenti.modificaUtente();
			}
		});
		contentPane.add(btnModifica);
		
		btnElimina = new JButton("elimina");
		btnElimina.setBounds(44, 80, 89, 23);
		btnElimina.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneUtenti.eliminaUtente();
			}
		});
		contentPane.add(btnElimina);
		
		btnAggiungi = new JButton("aggiungi");
		btnAggiungi.setBounds(156, 80, 89, 23);
		btnAggiungi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneUtenti.aggiungiUtente();
			}
		});
		contentPane.add(btnAggiungi);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(486, 61, 362, 382);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int t = table.getSelectedRow();
				txtNome.setText(modello.getValueAt(t, 0).toString());
				txtCognome.setText(modello.getValueAt(t, 1).toString());
				txtEmail.setText(modello.getValueAt(t, 2).toString());
				txtPassword.setText(modello.getValueAt(t, 3).toString());			
			}
		});
		
		modello.setColumnIdentifiers(colonne);
		table.setModel(modello);

		scrollPane.setViewportView(table);
		
		btnNewButton = new JButton("svuota");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneUtenti.svuotaCampiGestioneUtenti();
			}
		});
		btnNewButton.setBounds(181, 116, 78, 39);
		contentPane.add(btnNewButton);
		
		caricamento();
		
	}
	
	public void  caricamento() {
		this.ListaUtenti = controllerGestioneUtenti.implementazioneUtenteDAO().stampaUtenti();
		modello.setNumRows(0);
		for(Object [] dato : this.ListaUtenti) {
			this.modello.addRow(dato);
		}
		table.setModel(modello);
	}
}
