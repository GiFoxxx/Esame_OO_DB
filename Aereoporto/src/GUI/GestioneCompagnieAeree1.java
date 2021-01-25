package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Controller.Controller;
import javax.swing.JButton;

public class GestioneCompagnieAeree1 extends JPanel {


	Color sfondo = new Color(54, 57, 63);
	Color scritte = new Color(141, 142, 146);
	
	String colonne[] = {"Codice Compagnia aerea", "Nome" };
	final Object[] row = new Object[4];
	DefaultTableModel modello = new DefaultTableModel(colonne, 0);
	ArrayList<Object[]> ListaCompagnieAeree = new ArrayList<>();
	
	private JTextField txtCodiceCompagniaAerea;
	private JTextField txtNome;
	private JScrollPane scrollPane;
	private JTable table;
	
	//GETTER E SETTER
	public DefaultTableModel getModello() {
		return modello;
	}

	public void setModello(DefaultTableModel modello) {
		this.modello = modello;
	}

	public JTextField getTxtCodiceCompagniaAerea() {
		return txtCodiceCompagniaAerea;
	}

	public void setTxtCodiceCompagniaAerea(JTextField txtCodiceCompagniaAerea) {
		this.txtCodiceCompagniaAerea = txtCodiceCompagniaAerea;
	}

	public JTextField getTxtNome() {
		return txtNome;
	}

	public void setTxtNome(JTextField txtNome) {
		this.txtNome = txtNome;
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
	
	Controller controllerGestioneCompagnieAeree;
	
	public GestioneCompagnieAeree1(Controller controller) {
		controllerGestioneCompagnieAeree=controller;
		
		setBounds(0, 0, 894, 625);
		setBackground(sfondo);
		setLayout(null);
		
		JLabel lblimgfrecciaIndietro = new JLabel("");
		lblimgfrecciaIndietro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneCompagnieAeree.mostraPannelli(controllerGestioneCompagnieAeree.getDashboard().getHome());
			}
		});
		lblimgfrecciaIndietro.setHorizontalAlignment(SwingConstants.CENTER);
		lblimgfrecciaIndietro.setForeground(Color.BLACK);
		lblimgfrecciaIndietro.setFont(new Font("Arial", Font.BOLD, 11));
		lblimgfrecciaIndietro.setBorder(null);
		lblimgfrecciaIndietro.setBackground(new Color(70, 130, 180));
		lblimgfrecciaIndietro.setBounds(21, 21, 37, 14);
		add(lblimgfrecciaIndietro);
		
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 46, 850, 330);
		add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int t = table.getSelectedRow();
				txtCodiceCompagniaAerea.setText(modello.getValueAt(t, 0).toString());
				txtNome.setText(modello.getValueAt(t, 1).toString());
			}
		});
		
		modello.setColumnIdentifiers(colonne);
		table.setModel(modello);

		scrollPane.setViewportView(table);
		
		txtCodiceCompagniaAerea = new JTextField();
		txtCodiceCompagniaAerea.setColumns(10);
		txtCodiceCompagniaAerea.setBounds(304, 416, 133, 20);
		add(txtCodiceCompagniaAerea);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setFont(new Font("Arial", Font.BOLD, 14));
		lblNome.setBounds(53, 447, 221, 20);
		add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(304, 447, 133, 20);
		add(txtNome);
		
		JLabel lblCodiceCompagniaAerea = new JLabel("Codice Compagnia Aerea");
		lblCodiceCompagniaAerea.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodiceCompagniaAerea.setFont(new Font("Arial", Font.BOLD, 14));
		lblCodiceCompagniaAerea.setBounds(53, 416, 221, 20);
		add(lblCodiceCompagniaAerea);
		
		JButton btnAggiungi = new JButton("aggiungi");
		btnAggiungi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneCompagnieAeree.aggiungiCompagniaAerea();
			}
		});
		btnAggiungi.setBounds(705, 416, 113, 20);
		add(btnAggiungi);
		
		JButton btnModifica = new JButton("modifica");
		btnModifica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneCompagnieAeree.modificaCompagniaAerea();
			}
		});
		btnModifica.setBounds(705, 447, 113, 20);
		add(btnModifica);
		
		JButton btnElimina = new JButton("elimina");
		btnElimina.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneCompagnieAeree.eliminaCompagniaAerea();
			}
		});
		btnElimina.setBounds(705, 479, 113, 20);
		add(btnElimina);
		
		JButton btnSvuota = new JButton("svuota");
		btnSvuota.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneCompagnieAeree.svuotaCampiCompagniaAerea();
			}
		});
		btnSvuota.setBounds(705, 511, 113, 20);
		add(btnSvuota);
		
		caricamento();
	}
	
	public void  caricamento() {
		this.ListaCompagnieAeree = controllerGestioneCompagnieAeree.implementazioneCompagniaAereaDAO().stampaCompagnieAeree();
		modello.setNumRows(0);
		for(Object [] dato : this.ListaCompagnieAeree) {
			this.modello.addRow(dato);
		}
		table.setModel(modello);
	}

}
