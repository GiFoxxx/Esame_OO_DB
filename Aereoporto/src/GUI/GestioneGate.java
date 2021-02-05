package GUI;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import Controller.Controller;
import Immagini.Immagini;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.RowFilter;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import java.awt.Cursor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GestioneGate extends JPanel {

	String colonne[] = { "Codice Gate", "Numero Porta", "Tempo Inizio Imbarco", "Tempo Fine Imbarco" };
	final Object[] row = new Object[4];
	DefaultTableModel modello = new DefaultTableModel(colonne, 0);
	ArrayList<Object[]> ListaGate = new ArrayList<>();
	private Immagini img = new Immagini();

	private JTextField txtCodiceGate;
	private JTextField txtNumeroPorta;
	private JTextField txtInizioImbarco;
	private JTextField txtFineImbarco;
	private JTable tabella;
	private JTextField txtBarraRicerca;

	// GETTER E SETTER
	public DefaultTableModel getModello() {
		return modello;
	}

	public void setModello(DefaultTableModel modello) {
		this.modello = modello;
	}

	public JTextField getTxtCodiceGate() {
		return txtCodiceGate;
	}

	public void setTxtCodiceGate(JTextField txtCodiceGate) {
		this.txtCodiceGate = txtCodiceGate;
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

	public JTable getTabella() {
		return tabella;
	}

	public void setTabella(JTable table) {
		this.tabella = table;
	}

	public Object[] getRow() {
		return row;
	}

	Controller controllerGestioneGate;

	public GestioneGate(Controller controller) {
		controllerGestioneGate = controller;

		setBounds(0, 0, 894, 625);
		setBackground(controllerGestioneGate.sfondo);
		setLayout(null);

		JLabel lblimgfrecciaIndietro = new JLabel("");
		lblimgfrecciaIndietro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblimgfrecciaIndietro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneGate.mostraPannelli(controllerGestioneGate.getDashboard().getHome());
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
		lblimgfrecciaIndietro.setForeground(Color.BLACK);
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
		txtBarraRicerca.setForeground(controllerGestioneGate.coloreScritteSuBianco);
		txtBarraRicerca.setFont(controllerGestioneGate.fontScritte);
		txtBarraRicerca.setBorder(null);
		txtBarraRicerca.setBounds(704, 42, 135, 20);
		add(txtBarraRicerca);
		txtBarraRicerca.setColumns(10);

		JLabel lblBarraRicerca = new JLabel("");
		lblBarraRicerca.setHorizontalAlignment(SwingConstants.CENTER);
		lblBarraRicerca.setIcon(new ImageIcon(img.barraRicerca()));
		lblBarraRicerca.setBounds(693, 35, 180, 30);
		add(lblBarraRicerca);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Arial", Font.PLAIN, 12));
		scrollPane.setEnabled(false);
		scrollPane.setBounds(25, 85, 850, 330);
		add(scrollPane);

		tabella = new JTable();
		tabella.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int t = tabella.getSelectedRow();
				txtCodiceGate.setText(modello.getValueAt(t, 0).toString());
				txtNumeroPorta.setText(modello.getValueAt(t, 1).toString());
				txtInizioImbarco.setText(modello.getValueAt(t, 2).toString());
				txtFineImbarco.setText(modello.getValueAt(t, 3).toString());
			}
		});
		modello.setColumnIdentifiers(colonne);
		tabella.setModel(modello);
		scrollPane.setViewportView(tabella);

		

		JButton btnElimina = new JButton("elimina");
		btnElimina.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnElimina.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneGate.eliminaGate();
			}
		});
		btnElimina.setBounds(750, 526, 89, 23);
		add(btnElimina);

		JButton btnAggiungi = new JButton("aggiungi");
		btnAggiungi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAggiungi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneGate.aggiungiGate();
			}
		});
		btnAggiungi.setBounds(750, 461, 89, 23);
		add(btnAggiungi);

		JButton btnModifica = new JButton("modifica");
		btnModifica.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnModifica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneGate.modificaGate();
			}
		});
		btnModifica.setBounds(750, 493, 89, 23);
		add(btnModifica);

		JButton btnSvuota = new JButton("svuota");
		btnSvuota.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSvuota.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneGate.svuotaCampiGate();
			}
		});
		btnSvuota.setBounds(750, 560, 89, 23);
		add(btnSvuota);

		JLabel lblNumeroPorta = new JLabel("Numero Porta");
		lblNumeroPorta.setFont(controllerGestioneGate.fontScritte);
		lblNumeroPorta.setForeground(controllerGestioneGate.coloreScritte);
		lblNumeroPorta.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumeroPorta.setBounds(20, 494, 114, 20);
		add(lblNumeroPorta);

		txtNumeroPorta = new JTextField();
		txtNumeroPorta.setFont(controllerGestioneGate.fontScritte);
		txtNumeroPorta.setForeground(controllerGestioneGate.coloreScritteSuBianco);
		txtNumeroPorta.setColumns(10);
		txtNumeroPorta.setBounds(168, 494, 133, 20);
		add(txtNumeroPorta);

		JLabel lblInizioImbarco = new JLabel("Inizio Imbarco");
		lblInizioImbarco.setFont(controllerGestioneGate.fontScritte);
		lblInizioImbarco.setForeground(controllerGestioneGate.coloreScritte);
		lblInizioImbarco.setHorizontalAlignment(SwingConstants.RIGHT);
		lblInizioImbarco.setBounds(20, 527, 114, 20);
		add(lblInizioImbarco);

		txtInizioImbarco = new JTextField();
		txtInizioImbarco.setFont(controllerGestioneGate.fontScritte);
		txtInizioImbarco.setForeground(controllerGestioneGate.coloreScritteSuBianco);
		txtInizioImbarco.setColumns(10);
		txtInizioImbarco.setBounds(168, 527, 133, 20);
		add(txtInizioImbarco);

		JLabel lblFineImbarco = new JLabel("Fine Imbarco");
		lblFineImbarco.setFont(controllerGestioneGate.fontScritte);
		lblFineImbarco.setForeground(controllerGestioneGate.coloreScritte);
		lblFineImbarco.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFineImbarco.setBounds(20, 561, 114, 20);
		add(lblFineImbarco);

		txtFineImbarco = new JTextField();
		txtFineImbarco.setFont(controllerGestioneGate.fontScritte);
		txtFineImbarco.setForeground(controllerGestioneGate.coloreScritteSuBianco);
		txtFineImbarco.setColumns(10);
		txtFineImbarco.setBounds(168, 561, 133, 20);
		add(txtFineImbarco);

		JLabel lblCodiceGate = new JLabel("Codice Gate");
		lblCodiceGate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodiceGate.setFont(controllerGestioneGate.fontScritte);
		lblCodiceGate.setForeground(controllerGestioneGate.coloreScritte);
		lblCodiceGate.setBounds(20, 462, 114, 20);
		add(lblCodiceGate);

		txtCodiceGate = new JTextField();
		txtCodiceGate.setFont(controllerGestioneGate.fontScritte);
		txtCodiceGate.setForeground(controllerGestioneGate.coloreScritteSuBianco);
		txtCodiceGate.setColumns(10);
		txtCodiceGate.setBounds(168, 462, 133, 20);
		add(txtCodiceGate);

		caricaTabella();

	}

	// METODI
	public void caricaTabella() {
		this.ListaGate = controllerGestioneGate.implementazioneGateDAO().stampaGate();
		modello.setNumRows(0);
		for (Object[] dato : this.ListaGate) {
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
