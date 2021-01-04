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


import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Prova extends JFrame {

	String colonne[] = {"Nome", "Cognome", "Email", "Password"};
	DefaultTableModel modello = new DefaultTableModel(colonne, 0);
	UtenteImplementazionePostgresDAO dao = new UtenteImplementazionePostgresDAO();
	ArrayList<Object[]> ListaUtenti = new ArrayList<>();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	private JPanel contentPane;
	private JTable table;
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
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prova frame = new Prova();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	
	

	
	public Prova() {
			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 14, 223, 196);
		contentPane.add(scrollPane);
		
		table = new JTable();
//		table.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				this.txtNome.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
//				this.txtCognome.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
//				this.txtEmail.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
//				this.txtPassword.setText(table.getValueAt(table.getSelectedRow(), 0).toString());			
//			}
//		});
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Nome", "Cognome", "Email", "Password"
			}
		));
		
		JLabel lblNome = new JLabel("nome");
		lblNome.setBounds(266, 21, 46, 14);
		contentPane.add(lblNome);
		lblCognome.setBounds(262, 46, 60, 27);
		contentPane.add(lblCognome);
		
		lblEmail = new JLabel("email");
		lblEmail.setBounds(266, 84, 46, 14);
		contentPane.add(lblEmail);
		
		lblPassword = new JLabel("password");
		lblPassword.setBounds(262, 116, 46, 14);
		contentPane.add(lblPassword);
		
		txtNome = new JTextField();
		txtNome.setBounds(346, 18, 78, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		txtCognome.setBounds(332, 46, 92, 20);
		contentPane.add(txtCognome);
		txtCognome.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(342, 72, 78, 20);
		contentPane.add(txtEmail);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(346, 116, 78, 20);
		contentPane.add(txtPassword);
		
		btnModifica = new JButton("modifica");
		btnModifica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Utente utn = new Utente(txtNome.getText(), txtCognome.getText(), txtEmail.getText(), txtPassword.getText());
				dao.modificaUtente(utn);

				BOH();
			}
		});
		btnModifica.setBounds(253, 172, 89, 23);
		contentPane.add(btnModifica);
		
		btnElimina = new JButton("elimina");
		btnElimina.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Utente utn = new Utente(txtNome.getText(), txtCognome.getText(), txtEmail.getText(), txtPassword.getText());
				dao.cancellaUtente(utn);

				BOH();
			}
		});
		btnElimina.setBounds(253, 194, 89, 23);
		contentPane.add(btnElimina);
		
		btnAggiungi = new JButton("aggiungi");
		btnAggiungi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Utente utn = new Utente(txtNome.getText(), txtCognome.getText(), txtEmail.getText(), txtPassword.getText());
				dao.aggiungiUtente(utn);

				BOH();
			
			}
		});
		btnAggiungi.setBounds(253, 227, 89, 23);
		contentPane.add(btnAggiungi);
		
		BOH();
		
	}
	
	private void  BOH() {
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
