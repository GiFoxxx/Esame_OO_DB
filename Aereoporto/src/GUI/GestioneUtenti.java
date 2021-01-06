package GUI;

import java.awt.BorderLayout;
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
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.awt.Font;

public class GestioneUtenti extends JFrame {

	String colonne[] = {"Nome", "Cognome", "Email", "Password"};
	final Object[] row = new Object[4];
	DefaultTableModel modello = new DefaultTableModel(colonne, 0);
	UtenteImplementazionePostgresDAO dao = new UtenteImplementazionePostgresDAO();
	ArrayList<Object[]> ListaUtenti = new ArrayList<>();
	
	
	

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
	
	public GestioneUtenti(Controller controller) {
			
		controllerGestioneUtenti=controller;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
				Utente utn = new Utente(txtNome.getText(), txtCognome.getText(), txtEmail.getText(), txtPassword.getText());
				int t = table.getSelectedRow();
				
				modello.setValueAt(txtNome.getText(), t, 0);
				modello.setValueAt(txtCognome.getText(), t, 1);
				modello.setValueAt(txtEmail.getText(), t, 2);
				modello.setValueAt(txtPassword.getText(), t, 3);

				dao.modificaUtente(utn);
				caricamento();
			}
		});
		contentPane.add(btnModifica);
		
		btnElimina = new JButton("elimina");
		btnElimina.setBounds(44, 80, 89, 23);
		btnElimina.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Utente utn = new Utente(txtNome.getText(), txtCognome.getText(), txtEmail.getText(), txtPassword.getText());
				int t = table.getSelectedRow();
				modello.removeRow(t);
				dao.cancellaUtente(utn);
				caricamento();
			}
		});
		contentPane.add(btnElimina);
		
		btnAggiungi = new JButton("aggiungi");
		btnAggiungi.setBounds(156, 80, 89, 23);
		btnAggiungi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Utente utn = new Utente(txtNome.getText(), txtCognome.getText(), txtEmail.getText(), txtPassword.getText());
				dao.registrazioneUtente(utn);
				modello.addRow(row);
				caricamento();
			
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
				txtNome.setText("");
				txtCognome.setText("");
				txtEmail.setText("");
				txtPassword.setText("");

			}
		});
		btnNewButton.setBounds(181, 116, 78, 39);
		contentPane.add(btnNewButton);
		
		caricamento();
		
	}
	
	private void  caricamento() {
		this.ListaUtenti = dao.stampaUtenti();
		modello.setNumRows(0);
		for(Object [] dato : this.ListaUtenti) {
			this.modello.addRow(dato);
		}
		table.setModel(modello);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}
