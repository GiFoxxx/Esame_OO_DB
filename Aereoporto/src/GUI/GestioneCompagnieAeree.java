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

import Classi.CompagniaAerea;
import Controller.Controller;
import ImplementazioniPostrgresDAO.CompagniaAereaImplementazionePostgresDAO;

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

public class GestioneCompagnieAeree extends JFrame {

	String colonne[] = {"Nome", "Codice Compagnia aerea"};
	final Object[] row = new Object[4];
	DefaultTableModel modello = new DefaultTableModel(colonne, 0);
	CompagniaAereaImplementazionePostgresDAO dao = new CompagniaAereaImplementazionePostgresDAO();
	ArrayList<Object[]> ListaCompagnieAeree = new ArrayList<>();
	
	private Image imgfrecciaIndietro1 = new ImageIcon(Registrazione.class.getResource("immaginiRegistrazione/imgfrecciaIndietro1.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image imgfrecciaIndietro2 = new ImageIcon(Registrazione.class.getResource("immaginiRegistrazione/imgfrecciaIndietro2.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image imgCasa1 = new ImageIcon(Registrazione.class.getResource("immaginiRegistrazione/imgCasa1.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image imgCasa2 = new ImageIcon(Registrazione.class.getResource("immaginiRegistrazione/imgCasa2.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);

	private JPanel contentPane;
	private final JLabel lblCodiceCompagniaAerea = new JLabel("Codice Compagnia aerea");
	private final JTextField txtCodiceCompagniaAerea = new JTextField();
	private JTextField txtNome;
	private JButton btnModifica;
	private JButton btnElimina;
	private JButton btnAggiungi;

	Controller controllerGestioneCompagnieAeree;
	private JButton btnNewButton;
	private JTable table;
	private JScrollPane scrollPane;
	
	//GETTER E SETTER
	public JTextField getTxtNome() {
		return txtNome;
	}

	public void setTxtNome(JTextField txtNome) {
		this.txtNome = txtNome;
	}

	public JTextField getTxtCodiceCompagniaAerea() {
		return txtCodiceCompagniaAerea;
	}
	
	//CREAZIONE GUI
	public GestioneCompagnieAeree(Controller controller) {
			
		controllerGestioneCompagnieAeree=controller;
		
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
				controllerGestioneCompagnieAeree.tornaAMenuGestioneDaGestioneCompagniaAeree();
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
		lblNome.setBounds(127, 220, 46, 14);
		contentPane.add(lblNome);
		lblCodiceCompagniaAerea.setBounds(54, 245, 133, 27);
		contentPane.add(lblCodiceCompagniaAerea);
		
		txtNome = new JTextField();
		txtNome.setBounds(221, 217, 133, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		txtCodiceCompagniaAerea.setBounds(221, 248, 157, 20);
		contentPane.add(txtCodiceCompagniaAerea);
		txtCodiceCompagniaAerea.setColumns(10);
		
		btnModifica = new JButton("modifica");
		btnModifica.setBounds(32, 124, 89, 23);
		btnModifica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CompagniaAerea compAerea = new CompagniaAerea(txtNome.getText(), txtCodiceCompagniaAerea.getText());
				int t = table.getSelectedRow();
				
				modello.setValueAt(txtNome.getText(), t, 0);
				modello.setValueAt(txtCodiceCompagniaAerea.getText(), t, 1);
				
				dao.modificaCompagniaAerea(compAerea);
				controllerGestioneCompagnieAeree.svuotaCampiCompagniaAerea();
				caricamento();
			}
		});
		contentPane.add(btnModifica);
		
		btnElimina = new JButton("elimina");
		btnElimina.setBounds(44, 80, 89, 23);
		btnElimina.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CompagniaAerea compAerea = new CompagniaAerea(txtNome.getText(), txtCodiceCompagniaAerea.getText());
				int t = table.getSelectedRow();
				dao.cancellaCompagniaAerea(compAerea);
				modello.removeRow(t);
				controllerGestioneCompagnieAeree.svuotaCampiCompagniaAerea();
				caricamento();
			}
		});
		contentPane.add(btnElimina);
		
		btnAggiungi = new JButton("aggiungi");
		btnAggiungi.setBounds(156, 80, 89, 23);
		btnAggiungi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CompagniaAerea compAerea = new CompagniaAerea(txtNome.getText(), txtCodiceCompagniaAerea.getText());
				dao.aggiungiCompagniaAerea(compAerea);
				modello.addRow(row);
				controllerGestioneCompagnieAeree.svuotaCampiCompagniaAerea();
				caricamento();
			}
		});
		contentPane.add(btnAggiungi);
		
		modello.setColumnIdentifiers(colonne);
		
		btnNewButton = new JButton("svuota");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneCompagnieAeree.svuotaCampiCompagniaAerea();
			}
		});
		btnNewButton.setBounds(181, 116, 78, 39);
		contentPane.add(btnNewButton);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(445, 53, 429, 366);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int t = table.getSelectedRow();
				txtNome.setText(modello.getValueAt(t, 0).toString());
				txtCodiceCompagniaAerea.setText(modello.getValueAt(t, 1).toString());
			}
		});
		
		modello.setColumnIdentifiers(colonne);
		table.setModel(modello);

		scrollPane.setViewportView(table);
		
		btnNewButton = new JButton("svuota");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneCompagnieAeree.svuotaCampiCompagniaAerea();
			}
		});
		scrollPane.setViewportView(table);
		
		caricamento();
		
	}
	

	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
	
	private void  caricamento() {
		this.ListaCompagnieAeree = dao.stampaCompagnieAeree();
		modello.setNumRows(0);
		for(Object [] dato : this.ListaCompagnieAeree) {
			this.modello.addRow(dato);
		}
		table.setModel(modello);
	}
}

