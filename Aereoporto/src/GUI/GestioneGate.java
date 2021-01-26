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


	Color sfondo = new Color(54, 57, 63);
	Color scritte = new Color(141, 142, 146);

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
	private JTextField txtfldBarraRicerca;

	public GestioneGate(Controller controller) {
		controllerGestioneGate = controller;

		setBounds(0, 0, 894, 625);
		setBackground(sfondo);
		setLayout(null);
		
		JLabel lblRicerca = new JLabel("");
		lblRicerca.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblRicerca.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblRicerca.setIcon(new ImageIcon(img.ricerca2()));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblRicerca.setIcon(new ImageIcon(img.ricerca1()));
			}
		});
		lblRicerca.setHorizontalAlignment(SwingConstants.CENTER);
		lblRicerca.setIcon(new ImageIcon(img.ricerca1()));
		lblRicerca.setBounds(835, 38, 20, 20);
		add(lblRicerca);
		
		txtfldBarraRicerca = new JTextField();
		txtfldBarraRicerca.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				DefaultTableModel table = (DefaultTableModel)tabella.getModel();
				String ricerca = txtfldBarraRicerca.getText();
				TableRowSorter<DefaultTableModel> trm = new TableRowSorter<DefaultTableModel>(table);
				tabella.setRowSorter(trm);
				trm.setRowFilter(RowFilter.regexFilter(ricerca));
			}
		});
		txtfldBarraRicerca.setForeground(new Color(141, 142, 146));
		txtfldBarraRicerca.setFont(new Font("Arial", Font.BOLD, 12));
		txtfldBarraRicerca.setBorder(null);
		txtfldBarraRicerca.setBounds(665, 31, 169, 32);
		add(txtfldBarraRicerca);
		txtfldBarraRicerca.setColumns(10);
		
		JLabel lblBarraRicerca = new JLabel("");
		lblBarraRicerca.setHorizontalAlignment(SwingConstants.CENTER);
		lblBarraRicerca.setIcon(new ImageIcon(img.barraRicerca()));
		lblBarraRicerca.setBounds(647, 21, 226, 52);
		add(lblBarraRicerca);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 84, 850, 330);
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

		JLabel lblimgfrecciaIndietro = new JLabel("");
		lblimgfrecciaIndietro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneGate.mostraPannelli(controllerGestioneGate.getDashboard().getHome());
			}

		});
		lblimgfrecciaIndietro.setHorizontalAlignment(SwingConstants.CENTER);
		lblimgfrecciaIndietro.setForeground(Color.BLACK);
		lblimgfrecciaIndietro.setFont(new Font("Arial", Font.BOLD, 11));
		lblimgfrecciaIndietro.setBorder(null);
		lblimgfrecciaIndietro.setBackground(new Color(70, 130, 180));
		lblimgfrecciaIndietro.setBounds(21, 21, 37, 14);
		add(lblimgfrecciaIndietro);

		JButton btnElimina = new JButton("elimina");
		btnElimina.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneGate.eliminaGate();
			}
		});
		btnElimina.setBounds(763, 493, 89, 23);
		add(btnElimina);

		JButton btnAggiungi = new JButton("aggiungi");
		btnAggiungi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneGate.aggiungiGate();
			}
		});
		btnAggiungi.setBounds(763, 425, 89, 23);
		add(btnAggiungi);

		JButton btnModifica = new JButton("modifica");
		btnModifica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneGate.modificaGate();
			}
		});
		btnModifica.setBounds(763, 459, 89, 23);
		add(btnModifica);

		JButton btnSvuota = new JButton("svuota");
		btnSvuota.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneGate.svuotaCampiGate();
			}
		});
		btnSvuota.setBounds(763, 527, 89, 23);
		add(btnSvuota);

		JLabel lblNumeroPorta = new JLabel("Numero Porta");
		lblNumeroPorta.setFont(new Font("Arial", Font.BOLD, 12));
		lblNumeroPorta.setForeground(scritte);
		lblNumeroPorta.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumeroPorta.setBounds(20, 494, 114, 20);
		add(lblNumeroPorta);

		txtNumeroPorta = new JTextField();
		txtNumeroPorta.setFont(new Font("Arial", Font.BOLD, 12));
		txtNumeroPorta.setColumns(10);
		txtNumeroPorta.setBounds(168, 494, 133, 20);
		add(txtNumeroPorta);

		JLabel lblInizioImbarco = new JLabel("Inizio Imbarco");
		lblInizioImbarco.setFont(new Font("Arial", Font.BOLD, 12));
		lblInizioImbarco.setForeground(scritte);
		lblInizioImbarco.setHorizontalAlignment(SwingConstants.RIGHT);
		lblInizioImbarco.setBounds(20, 527, 114, 20);
		add(lblInizioImbarco);

		txtInizioImbarco = new JTextField();
		txtInizioImbarco.setFont(new Font("Arial", Font.BOLD, 12));
		txtInizioImbarco.setColumns(10);
		txtInizioImbarco.setBounds(168, 527, 133, 20);
		add(txtInizioImbarco);

		JLabel lblFineImbarco = new JLabel("Fine Imbarco");
		lblFineImbarco.setFont(new Font("Arial", Font.BOLD, 12));
		lblFineImbarco.setForeground(scritte);
		lblFineImbarco.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFineImbarco.setBounds(20, 561, 114, 20);
		add(lblFineImbarco);

		txtFineImbarco = new JTextField();
		txtFineImbarco.setFont(new Font("Arial", Font.BOLD, 12));
		txtFineImbarco.setColumns(10);
		txtFineImbarco.setBounds(168, 561, 133, 20);
		add(txtFineImbarco);

		JLabel lblCodiceGate = new JLabel("Codice Gate");
		lblCodiceGate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodiceGate.setForeground(new Color(141, 142, 146));
		lblCodiceGate.setFont(new Font("Arial", Font.BOLD, 12));
		lblCodiceGate.setBounds(20, 462, 114, 20);
		add(lblCodiceGate);

		txtCodiceGate = new JTextField();
		txtCodiceGate.setFont(new Font("Arial", Font.BOLD, 12));
		txtCodiceGate.setColumns(10);
		txtCodiceGate.setBounds(168, 462, 133, 20);
		add(txtCodiceGate);

		caricamento();

	}

	// METODI
	public void caricamento() {
		this.ListaGate = controllerGestioneGate.implementazioneGateDAO().stampaGate();
		modello.setNumRows(0);
		for (Object[] dato : this.ListaGate) {
			this.modello.addRow(dato);
		}
		tabella.setModel(modello);
	}
		
}
