package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.util.ArrayList;
import java.util.List;

import java.awt.EventQueue;
import java.util.List;
import java.sql.Time;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Classi.Gate;
import Controller.Controller;
import ImplementazioniPostrgresDAO.GateImplementazionePostgresDAO;

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

public class GestioneGate extends JFrame {

	String colonne[] = {"Numero Porta", "Tempo Inizio Imbarco", "Tempo Fine Imbarco"};
	final Object[] row = new Object[4];
	DefaultTableModel modello = new DefaultTableModel(colonne, 0);
	ArrayList<Object[]> ListaGate = new ArrayList<>();
	
	private Image imgfrecciaIndietro1 = new ImageIcon(Registrazione.class.getResource("immaginiRegistrazione/imgfrecciaIndietro1.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image imgfrecciaIndietro2 = new ImageIcon(Registrazione.class.getResource("immaginiRegistrazione/imgfrecciaIndietro2.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image imgCasa1 = new ImageIcon(Registrazione.class.getResource("immaginiRegistrazione/imgCasa1.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image imgCasa2 = new ImageIcon(Registrazione.class.getResource("immaginiRegistrazione/imgCasa2.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);

	private JPanel contentPane;
	private JLabel lblNumeroPorta = new JLabel("Numero Porta");
	private JTextField txtNumeroPorta = new JTextField();
	private JButton btnModifica;
	private JButton btnElimina;
	private JButton btnAggiungi;
	private JButton btnNewButton;
	private JButton btnSvuota;
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel lblInizioImbarco;
	private JTextField txtInizioImbarco;
	private JLabel lblFineImbarco;
	private JTextField txtFineImbarco;
	
	Controller controllerGestioneGate;
	
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

	public JTextField getTxtNumeroPorta() {
		return txtNumeroPorta;
	}

	public void setTxtNumeroPorta(JTextField txtNumeroPorta) {
		this.txtNumeroPorta = txtNumeroPorta;
	}

	public JTextField getTxtInizioImbarco() {
		return txtInizioImbarco;
	}

	public void setTxtInizioImbarco(JTextField txtInizioImbarco) {
		this.txtInizioImbarco = txtInizioImbarco;
	}

	public JTextField getTxtFineImbarco() {
		return txtFineImbarco;
	}

	public void setTxtFineImbarco(JTextField txtFineImbarco) {
		this.txtFineImbarco = txtFineImbarco;
	}

	
	//CREAZIONE GUI
	public GestioneGate(Controller controller) {
			
		controllerGestioneGate=controller;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1008, 398);
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
//				controllerGestioneGate.tornaAMenuGestioneDaGestioneGate();
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
		lblNumeroPorta.setBounds(32, 185, 114, 20);
		contentPane.add(lblNumeroPorta);
		txtNumeroPorta.setBounds(180, 186, 133, 20);
		contentPane.add(txtNumeroPorta);
		txtNumeroPorta.setColumns(10);
		
		btnModifica = new JButton("modifica");
		btnModifica.setBounds(32, 122, 89, 23);
		btnModifica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneGate.modificaGate();
			}
		});
		contentPane.add(btnModifica);
		
		btnElimina = new JButton("elimina");
		btnElimina.setBounds(44, 78, 89, 23);
		btnElimina.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneGate.eliminaGate();
			}
		});
		contentPane.add(btnElimina);
		
		btnAggiungi = new JButton("aggiungi");
		btnAggiungi.setBounds(156, 78, 89, 23);
		btnAggiungi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneGate.aggiungiGate();
			}
		});
		contentPane.add(btnAggiungi);
		
		modello.setColumnIdentifiers(colonne);
		
		btnSvuota = new JButton("svuota");
		btnSvuota.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneGate.svuotaCampiGate();
			}
		});
		btnSvuota.setBounds(181, 114, 78, 39);
		contentPane.add(btnSvuota);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(323, 35, 632, 297);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int t = table.getSelectedRow();
				txtNumeroPorta.setText(modello.getValueAt(t, 0).toString());
				txtInizioImbarco.setText(modello.getValueAt(t, 1).toString());
				txtFineImbarco.setText(modello.getValueAt(t, 2).toString());
			}
		});
		
		modello.setColumnIdentifiers(colonne);
		table.setModel(modello);

		scrollPane.setViewportView(table);
		
		
		lblInizioImbarco = new JLabel("Inizio Imbarco");
		lblInizioImbarco.setBounds(32, 223, 114, 20);
		contentPane.add(lblInizioImbarco);
		
		txtInizioImbarco = new JTextField();
		txtInizioImbarco.setColumns(10);
		txtInizioImbarco.setBounds(180, 223, 133, 20);
		contentPane.add(txtInizioImbarco);
		
		lblFineImbarco = new JLabel("Fine Imbarco");
		lblFineImbarco.setBounds(32, 265, 114, 20);
		contentPane.add(lblFineImbarco);
		
		txtFineImbarco = new JTextField();
		txtFineImbarco.setColumns(10);
		txtFineImbarco.setBounds(180, 265, 133, 20);
		contentPane.add(txtFineImbarco);
		
		caricamento();
		
	}
	
	public void  caricamento() {
		this.ListaGate = controllerGestioneGate.implementazioneGateDAO().stampaGate();
		modello.setNumRows(0);
		for(Object [] dato : this.ListaGate) {
			this.modello.addRow(dato);
		}
		table.setModel(modello);
	}
}