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

	String colonne[] = {"Codice Gate", "Numero Porta", "Tempo Inizio Imbarco", "Tempo Fine Imbarco"};
	final Object[] row = new Object[4];
	DefaultTableModel modello = new DefaultTableModel(colonne, 0);
	GateImplementazionePostgresDAO dao = new GateImplementazionePostgresDAO();
	ArrayList<Object[]> ListaGate = new ArrayList<>();
	
	private Image imgfrecciaIndietro1 = new ImageIcon(Registrazione.class.getResource("immaginiRegistrazione/imgfrecciaIndietro1.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image imgfrecciaIndietro2 = new ImageIcon(Registrazione.class.getResource("immaginiRegistrazione/imgfrecciaIndietro2.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image imgCasa1 = new ImageIcon(Registrazione.class.getResource("immaginiRegistrazione/imgCasa1.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image imgCasa2 = new ImageIcon(Registrazione.class.getResource("immaginiRegistrazione/imgCasa2.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);

	private JPanel contentPane;
	private JLabel lblNumeroPorta = new JLabel("Numero Porta");
	private JTextField txtNumeroPorta = new JTextField();
	private JTextField txtCodiceGate;
	private JButton btnModifica;
	private JButton btnElimina;
	private JButton btnAggiungi;
	private JButton btnNewButton;
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel lblInizioImbarco;
	private JTextField txtInizioImbarco;
	private JLabel lblFineImbarco;
	private JTextField txtFineImbarco;
	
	Controller controllerGestioneGate;
	
	//GETTER E SETTER
	
	public JTextField getTxtNumeroPorta() {
		return txtNumeroPorta;
	}

	public void setTxtNumeroPorta(JTextField txtNumeroPorta) {
		this.txtNumeroPorta = txtNumeroPorta;
	}

	public JTextField getTxtCodiceGate() {
		return txtCodiceGate;
	}

	public void setTxtCodiceGate(JTextField txtCodiceGate) {
		this.txtCodiceGate = txtCodiceGate;
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
				controllerGestioneGate.tornaAMenuGestioneDaGestioneGate();
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
		
		JLabel lblimgCasa = new JLabel("");
		lblimgCasa.addMouseListener(new MouseAdapter() {
			@Override // clicco sulla casa e torno ad avvio
			public void mouseClicked(MouseEvent e) {
				controllerGestioneGate.tornaAdAvvioDaGestioneGate();
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
		lblimgCasa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblimgCasa.setHorizontalAlignment(SwingConstants.CENTER);
		lblimgCasa.setIcon(new ImageIcon(imgCasa1));
		lblimgCasa.setBounds(818, 11, 30, 23);
		contentPane.add(lblimgCasa);
		
		JLabel lblCodiceGate = new JLabel("Codice Gate");
		lblCodiceGate.setBounds(32, 209, 114, 20);
		contentPane.add(lblCodiceGate);
		lblNumeroPorta.setBounds(32, 239, 114, 20);
		contentPane.add(lblNumeroPorta);
		
		txtCodiceGate = new JTextField();
		txtCodiceGate.setBounds(180, 209, 133, 20);
		contentPane.add(txtCodiceGate);
		txtCodiceGate.setColumns(10);
		txtNumeroPorta.setBounds(180, 240, 133, 20);
		contentPane.add(txtNumeroPorta);
		txtNumeroPorta.setColumns(10);
		
		btnModifica = new JButton("modifica");
		btnModifica.setBounds(32, 124, 89, 23);
		btnModifica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Gate gt = new Gate(txtCodiceGate.getText(), txtNumeroPorta.getText(), txtInizioImbarco.getText(), txtFineImbarco.getText());
				int t = table.getSelectedRow();
				
				modello.setValueAt(txtCodiceGate.getText(), t, 0);
				modello.setValueAt(txtNumeroPorta.getText(), t, 1);
				modello.setValueAt(txtInizioImbarco.getText(), t, 2);
				modello.setValueAt(txtFineImbarco.getText(), t, 3);
				
				dao.modificaGate(gt);
				controllerGestioneGate.svuotaCampiGate();
				caricamento();
			}
		});
		contentPane.add(btnModifica);
		
		btnElimina = new JButton("elimina");
		btnElimina.setBounds(44, 80, 89, 23);
		btnElimina.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Gate gt = new Gate(txtCodiceGate.getText(), txtNumeroPorta.getText(), txtInizioImbarco.getText(), txtFineImbarco.getText());
				int t = table.getSelectedRow();
				dao.cancellaGate(gt);
				modello.removeRow(t);
				controllerGestioneGate.svuotaCampiGate();
				caricamento();
			}
		});
		contentPane.add(btnElimina);
		
		btnAggiungi = new JButton("aggiungi");
		btnAggiungi.setBounds(156, 80, 89, 23);
		btnAggiungi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Gate gt = new Gate(txtCodiceGate.getText(), txtNumeroPorta.getText(), txtInizioImbarco.getText(), txtFineImbarco.getText());
				dao.aggiugniGate(gt);
				modello.addRow(row);
				controllerGestioneGate.svuotaCampiGate();
				caricamento();
			}
		});
		contentPane.add(btnAggiungi);
		
		modello.setColumnIdentifiers(colonne);
		
		btnNewButton = new JButton("svuota");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneGate.svuotaCampiGate();
			}
		});
		btnNewButton.setBounds(181, 116, 78, 39);
		contentPane.add(btnNewButton);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(323, 35, 632, 297);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int t = table.getSelectedRow();
				txtCodiceGate.setText(modello.getValueAt(t, 0).toString());
				txtNumeroPorta.setText(modello.getValueAt(t, 1).toString());
				txtInizioImbarco.setText(modello.getValueAt(t, 2).toString());
				txtFineImbarco.setText(modello.getValueAt(t, 3).toString());
			}
		});
		
		modello.setColumnIdentifiers(colonne);
		table.setModel(modello);

		scrollPane.setViewportView(table);
		
		btnNewButton = new JButton("svuota");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneGate.svuotaCampiGate();
			}
		});
		scrollPane.setViewportView(table);
		
		lblInizioImbarco = new JLabel("Inizio Imbarco");
		lblInizioImbarco.setBounds(32, 277, 114, 20);
		contentPane.add(lblInizioImbarco);
		
		txtInizioImbarco = new JTextField();
		txtInizioImbarco.setColumns(10);
		txtInizioImbarco.setBounds(180, 277, 133, 20);
		contentPane.add(txtInizioImbarco);
		
		lblFineImbarco = new JLabel("Fine Imbarco");
		lblFineImbarco.setBounds(32, 319, 114, 20);
		contentPane.add(lblFineImbarco);
		
		txtFineImbarco = new JTextField();
		txtFineImbarco.setColumns(10);
		txtFineImbarco.setBounds(180, 319, 133, 20);
		contentPane.add(txtFineImbarco);
		
		caricamento();
		
	}
	
	
	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
	
	private void  caricamento() {
		this.ListaGate = dao.stampaGate();
		modello.setNumRows(0);
		for(Object [] dato : this.ListaGate) {
			this.modello.addRow(dato);
		}
		table.setModel(modello);
	}
}