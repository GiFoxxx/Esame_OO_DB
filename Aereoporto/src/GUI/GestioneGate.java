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
import javax.swing.JComboBox;

public class GestioneGate extends JPanel {

	String colonne[] = { "Codice Gate", "Numero Porta", "Coda D'Imbarco 1", "Coda D'Imbarco 2"};
	final Object[] row = new Object[4];
	DefaultTableModel modello = new DefaultTableModel(colonne, 0);
	ArrayList<Object[]> ListaGate = new ArrayList<>();
	ArrayList<String> ListaCodaDiImbarco = new ArrayList<>();
	private Immagini img = new Immagini();

	private JTextField txtCodiceGate;
	private JTextField txtNumeroPorta;
	
	private JComboBox<String> comboBoxCodaImbarco1;
	private JComboBox<String> comboBoxCodaImbarco2;

	private JTable tabella;
	private JTextField txtBarraRicerca;
	
	private JLabel lblimgfrecciaIndietro;
	private JLabel lblBarraRicerca;
	private JLabel lblNumeroPorta;
	private JLabel lblCodiceGate;
	private JLabel lblCodaImbarco1;
	private JLabel lblCodaDimbarco2;
	
	// GETTER E SETTER
	public DefaultTableModel getModello() {
		return modello;
	}

	public void setModello(DefaultTableModel modello) {
		this.modello = modello;
	}
	
	public Object[] getRow() {
		return row;
	}

	public JTextField getTxtBarraRicerca() {
		return txtBarraRicerca;
	}

	public void setTxtBarraRicerca(JTextField txtBarraRicerca) {
		this.txtBarraRicerca = txtBarraRicerca;
	}

	public JLabel getLblimgfrecciaIndietro() {
		return lblimgfrecciaIndietro;
	}

	public void setLblimgfrecciaIndietro(JLabel lblimgfrecciaIndietro) {
		this.lblimgfrecciaIndietro = lblimgfrecciaIndietro;
	}

	public JLabel getLblBarraRicerca() {
		return lblBarraRicerca;
	}

	public void setLblBarraRicerca(JLabel lblBarraRicerca) {
		this.lblBarraRicerca = lblBarraRicerca;
	}

	public JLabel getLblNumeroPorta() {
		return lblNumeroPorta;
	}

	public void setLblNumeroPorta(JLabel lblNumeroPorta) {
		this.lblNumeroPorta = lblNumeroPorta;
	}

	public JLabel getLblCodiceGate() {
		return lblCodiceGate;
	}

	public void setLblCodiceGate(JLabel lblCodiceGate) {
		this.lblCodiceGate = lblCodiceGate;
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

	public JLabel getLblCodaImbarco1() {
		return lblCodaImbarco1;
	}

	public void setLblCodaImbarco1(JLabel lblCodaImbarco1) {
		this.lblCodaImbarco1 = lblCodaImbarco1;
	}

	public JLabel getLblCodaDimbarco2() {
		return lblCodaDimbarco2;
	}

	public void setLblCodaDimbarco2(JLabel lblCodaDimbarco2) {
		this.lblCodaDimbarco2 = lblCodaDimbarco2;
	}

	public JComboBox<String> getComboBoxCodaImbarco1() {
		return comboBoxCodaImbarco1;
	}

	public void setComboBoxCodaImbarco1(JComboBox<String> comboBoxCodaImbarco1) {
		this.comboBoxCodaImbarco1 = comboBoxCodaImbarco1;
	}

	public JComboBox<String> getComboBoxCodaImbarco2() {
		return comboBoxCodaImbarco2;
	}

	public void setComboBoxCodaImbarco2(JComboBox<String> comboBoxCodaImbarco2) {
		this.comboBoxCodaImbarco2 = comboBoxCodaImbarco2;
	}

	public JTable getTabella() {
		return tabella;
	}

	public void setTabella(JTable table) {
		this.tabella = table;
	}

	Controller controllerGestioneGate;
	

	public GestioneGate(Controller controller) {
		controllerGestioneGate = controller;

		setBounds(0, 0, 1090, 642);
		setBackground(controllerGestioneGate.sfondoTemaScuro);
		setLayout(null);

		lblimgfrecciaIndietro = new JLabel("");
		lblimgfrecciaIndietro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblimgfrecciaIndietro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneGate.setPannelloPrecedente(1);
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
			@Override
			public void mousePressed(MouseEvent e) {
				lblimgfrecciaIndietro.setIcon(new ImageIcon(img.frecciaIndietro3()));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lblimgfrecciaIndietro.setIcon(new ImageIcon(img.frecciaIndietro2()));
			}
		});
		lblimgfrecciaIndietro.setHorizontalAlignment(SwingConstants.CENTER);
		lblimgfrecciaIndietro.setForeground(Color.BLACK);
		lblimgfrecciaIndietro.setIcon(new ImageIcon(img.frecciaIndietro1()));
		lblimgfrecciaIndietro.setBounds(30, 35, 47, 30);
		add(lblimgfrecciaIndietro);

		txtBarraRicerca = new JTextField();
		txtBarraRicerca.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				ricerca();
			}
		});
		txtBarraRicerca.setBackground(controllerGestioneGate.escoPannelloTemaScuro);
		txtBarraRicerca.setForeground(controllerGestioneGate.coloreScritteTemaScuro);
		txtBarraRicerca.setFont(controllerGestioneGate.fontScritteGestioni);
		txtBarraRicerca.setBorder(null);
		txtBarraRicerca.setBounds(888, 41, 141, 20);
		add(txtBarraRicerca);
		txtBarraRicerca.setColumns(10);

		lblBarraRicerca = new JLabel("");
		lblBarraRicerca.setHorizontalAlignment(SwingConstants.CENTER);
		lblBarraRicerca.setIcon(new ImageIcon(img.barraRicerca()));
		lblBarraRicerca.setBounds(876, 38, 184, 25);
		add(lblBarraRicerca);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(controllerGestioneGate.fontLabel);
		scrollPane.setEnabled(false);
		scrollPane.setBounds(30, 85, 1030, 330);
		add(scrollPane);

		tabella = new JTable();
		tabella.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent EventoDelete) {
				if (EventoDelete.getKeyCode() == KeyEvent.VK_DELETE) {
					controllerGestioneGate.eliminaGate();
				}
			}
		});
		tabella.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int t = tabella.getSelectedRow();
				txtCodiceGate.setText(modello.getValueAt(t, 0).toString());
				txtNumeroPorta.setText(modello.getValueAt(t, 1).toString());
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
				controllerGestioneGate.svuotaCampiGestioneGate();
			}
		});
		btnSvuota.setBounds(750, 560, 89, 23);
		add(btnSvuota);

		lblNumeroPorta = new JLabel("Numero Porta");
		lblNumeroPorta.setFont(controllerGestioneGate.fontLabel);
		lblNumeroPorta.setForeground(controllerGestioneGate.coloreScritteTemaScuro);
		lblNumeroPorta.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumeroPorta.setBounds(30, 493, 114, 20);
		add(lblNumeroPorta);

		txtNumeroPorta = new JTextField();
		txtNumeroPorta.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent EventoInvio) {
				if (EventoInvio.getKeyCode() == KeyEvent.VK_ENTER) {
					controllerGestioneGate.aggiungiGate();
				}
			}
		});
		txtNumeroPorta.setFont(controllerGestioneGate.fontScritteGestioni);
		txtNumeroPorta.setForeground(controllerGestioneGate.coloreScritteSuBiancoTemaScuro);
		txtNumeroPorta.setColumns(10);
		txtNumeroPorta.setBounds(178, 493, 180, 20);
		add(txtNumeroPorta);

		lblCodiceGate = new JLabel("Codice Gate");
		lblCodiceGate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodiceGate.setFont(controllerGestioneGate.fontLabel);
		lblCodiceGate.setForeground(controllerGestioneGate.coloreScritteTemaScuro);
		lblCodiceGate.setBounds(30, 461, 114, 20);
		add(lblCodiceGate);

		txtCodiceGate = new JTextField();
		txtCodiceGate.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent EventoInvio) {
				if (EventoInvio.getKeyCode() == KeyEvent.VK_ENTER) {
					controllerGestioneGate.aggiungiGate();
				}
			}
		});
		txtCodiceGate.setFont(controllerGestioneGate.fontScritteGestioni);
		txtCodiceGate.setForeground(controllerGestioneGate.coloreScritteSuBiancoTemaScuro);
		txtCodiceGate.setColumns(10);
		txtCodiceGate.setBounds(178, 461, 180, 20);
		add(txtCodiceGate);
		
		lblCodaImbarco1 = new JLabel("Coda d'Imbarco1");
		lblCodaImbarco1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodaImbarco1.setForeground(controllerGestioneGate.coloreScritteSuBiancoTemaScuro);
		lblCodaImbarco1.setFont(controllerGestioneGate.fontScritteGestioni);
		lblCodaImbarco1.setBounds(30, 525, 114, 20);
		add(lblCodaImbarco1);
		
		lblCodaDimbarco2 = new JLabel("Coda d'Imbarco 2");
		lblCodaDimbarco2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodaDimbarco2.setForeground(controllerGestioneGate.coloreScritteSuBiancoTemaScuro);
		lblCodaDimbarco2.setFont(controllerGestioneGate.fontScritteGestioni);
		lblCodaDimbarco2.setBounds(30, 560, 114, 20);
		add(lblCodaDimbarco2);
		
		comboBoxCodaImbarco1 = new JComboBox();
		comboBoxCodaImbarco1.addItem("Business");
		comboBoxCodaImbarco1.addItem("Diversamente Abili");
		comboBoxCodaImbarco1.addItem("Priority");
		comboBoxCodaImbarco1.addItem("Famiglia");
		comboBoxCodaImbarco1.addItem("Economy");
		comboBoxCodaImbarco1.setBounds(178, 525, 180, 20);
		add(comboBoxCodaImbarco1);
		
		comboBoxCodaImbarco2 = new JComboBox();
		comboBoxCodaImbarco2.addItem("Business");
		comboBoxCodaImbarco2.addItem("Diversamente Abili");
		comboBoxCodaImbarco2.addItem("Priority");
		comboBoxCodaImbarco2.addItem("Famiglia");
		comboBoxCodaImbarco2.addItem("Economy");
		comboBoxCodaImbarco2.setBounds(178, 560, 180, 20);
		add(comboBoxCodaImbarco2);

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
