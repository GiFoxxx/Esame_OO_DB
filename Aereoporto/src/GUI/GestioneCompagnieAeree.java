package GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import Controller.Controller;
import Immagini.Immagini;

import javax.swing.JButton;

public class GestioneCompagnieAeree extends JPanel {

	String colonne[] = { "Codice Compagnia aerea", "Nome" };
	final Object[] row = new Object[4];
	DefaultTableModel modello = new DefaultTableModel(colonne, 0);
	ArrayList<Object[]> ListaCompagnieAeree = new ArrayList<>();
	private Immagini img = new Immagini();

	private JTextField txtCodiceCompagniaAerea;
	private JTextField txtNome;
	private JScrollPane scrollPane;
	private JTable tabella;
	private JTextField txtBarraRicerca;

	// GETTER E SETTER
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

	public JTable getTabella() {
		return tabella;
	}

	public void setTabella(JTable table) {
		this.tabella = table;
	}

	public Object[] getRow() {
		return row;
	}

	Controller controllerGestioneCompagnieAeree;
	

	public GestioneCompagnieAeree(Controller controller) {
		controllerGestioneCompagnieAeree = controller;

		setBounds(0, 0, 1090, 634);
		setBackground(controllerGestioneCompagnieAeree.sfondo);
		setLayout(null);

		JLabel lblimgfrecciaIndietro = new JLabel("");
		lblimgfrecciaIndietro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblimgfrecciaIndietro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneCompagnieAeree.mostraPannelli(controllerGestioneCompagnieAeree.getDashboard().getHome());
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblimgfrecciaIndietro.setIcon(new ImageIcon(img.frecciaIndietro2()));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblimgfrecciaIndietro.setIcon(new ImageIcon(img.frecciaIndietro1()));
			}
		});
		lblimgfrecciaIndietro.setHorizontalAlignment(SwingConstants.CENTER);
		lblimgfrecciaIndietro.setIcon(new ImageIcon(img.frecciaIndietro1()));
		lblimgfrecciaIndietro.setBounds(25, 35, 47, 30);
		add(lblimgfrecciaIndietro);
		
		JLabel lblRicerca = new JLabel("");
		lblRicerca.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		lblRicerca.setHorizontalAlignment(SwingConstants.CENTER);
		lblRicerca.setIcon(new ImageIcon(img.ricerca()));
		lblRicerca.setBounds(840, 36, 27, 27);
		add(lblRicerca);

		txtBarraRicerca = new JTextField();
		txtBarraRicerca.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				ricerca();
			}
		});
		txtBarraRicerca.setForeground(controllerGestioneCompagnieAeree.coloreScritteSuBianco);
		txtBarraRicerca.setFont(controllerGestioneCompagnieAeree.fontScritte);
		txtBarraRicerca.setBorder(null);
		txtBarraRicerca.setBounds(704, 42, 135, 20);
		add(txtBarraRicerca);
		txtBarraRicerca.setColumns(10);

		JLabel lblBarraRicerca = new JLabel("");
		lblBarraRicerca.setHorizontalAlignment(SwingConstants.CENTER);
		lblBarraRicerca.setIcon(new ImageIcon(img.barraRicerca()));
		lblBarraRicerca.setBounds(693, 35, 180, 30);
		add(lblBarraRicerca);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 85, 850, 330);
		add(scrollPane);

		tabella = new JTable();
		tabella.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int t = tabella.getSelectedRow();
				txtCodiceCompagniaAerea.setText(modello.getValueAt(t, 0).toString());
				txtNome.setText(modello.getValueAt(t, 1).toString());
			}
		});

		modello.setColumnIdentifiers(colonne);
		tabella.setModel(modello);

		scrollPane.setViewportView(tabella);

		txtCodiceCompagniaAerea = new JTextField();
		txtCodiceCompagniaAerea.setForeground(controllerGestioneCompagnieAeree.coloreScritteSuBianco);
		txtCodiceCompagniaAerea.setFont(controllerGestioneCompagnieAeree.fontScritte);
		txtCodiceCompagniaAerea.setColumns(10);
		txtCodiceCompagniaAerea.setBounds(304, 459, 133, 20);
		add(txtCodiceCompagniaAerea);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setForeground(controllerGestioneCompagnieAeree.coloreScritte);
		lblNome.setFont(controllerGestioneCompagnieAeree.fontScritte);
		lblNome.setBounds(53, 490, 221, 20);
		add(lblNome);

		txtNome = new JTextField();
		txtNome.setForeground(controllerGestioneCompagnieAeree.coloreScritteSuBianco);
		txtNome.setFont(controllerGestioneCompagnieAeree.fontScritte);
		txtNome.setColumns(10);
		txtNome.setBounds(304, 490, 133, 20);
		add(txtNome);

		JLabel lblCodiceCompagniaAerea = new JLabel("Codice Compagnia Aerea");
		lblCodiceCompagniaAerea.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodiceCompagniaAerea.setForeground(controllerGestioneCompagnieAeree.coloreScritte);
		lblCodiceCompagniaAerea.setFont(controllerGestioneCompagnieAeree.fontScritte);
		lblCodiceCompagniaAerea.setBounds(53, 459, 221, 20);
		add(lblCodiceCompagniaAerea);

		JButton btnAggiungi = new JButton("aggiungi");
		btnAggiungi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneCompagnieAeree.aggiungiCompagniaAerea();
			}
		});
		btnAggiungi.setBounds(705, 459, 113, 20);
		add(btnAggiungi);

		JButton btnModifica = new JButton("modifica");
		btnModifica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneCompagnieAeree.modificaCompagniaAerea();
			}
		});
		btnModifica.setBounds(705, 490, 113, 20);
		add(btnModifica);

		JButton btnElimina = new JButton("elimina");
		btnElimina.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneCompagnieAeree.eliminaCompagniaAerea();
			}
		});
		btnElimina.setBounds(705, 522, 113, 20);
		add(btnElimina);

		JButton btnSvuota = new JButton("svuota");
		btnSvuota.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneCompagnieAeree.svuotaCampiCompagniaAerea();
			}
		});
		btnSvuota.setBounds(705, 554, 113, 20);
		add(btnSvuota);

		caricaTabella();
	}

	public void caricaTabella() {
		this.ListaCompagnieAeree = controllerGestioneCompagnieAeree.implementazioneCompagniaAereaDAO()
				.stampaCompagnieAeree();
		modello.setNumRows(0);
		for (Object[] dato : this.ListaCompagnieAeree) {
			this.modello.addRow(dato);
		}
		tabella.setModel(modello);
	}

	private void ricerca() {
		DefaultTableModel table = (DefaultTableModel) tabella.getModel();
		String ricerca = txtBarraRicerca.getText();
		TableRowSorter<DefaultTableModel> trm = new TableRowSorter<DefaultTableModel>(table);
		tabella.setRowSorter(trm);
		trm.setRowFilter(RowFilter.regexFilter(ricerca));
	}
}
