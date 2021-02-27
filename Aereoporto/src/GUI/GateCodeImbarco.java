package GUI;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;

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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;

public class GateCodeImbarco extends JPanel {

	String colonne[] = { "Codice Gate", "Numero Porta", "Coda D'Imbarco" };
	final Object[] row = new Object[4];
	DefaultTableModel modello = new DefaultTableModel(colonne, 0);
	ArrayList<Object[]> ListaGate = new ArrayList<>();
	ArrayList<String> ListaCodaDiImbarco = new ArrayList<>();
	private Immagini img = new Immagini();

	private JTextField txtCodiceGate;
	private JTextField txtCodaDiImbarco;

	private JComboBox<String> comboBoxCodaDiImbarco;
	private JComboBox<String> comboBoxNumeroPorta;

	private JTable tabella;
	private JTextField txtBarraRicerca;

	private JLabel lblimgfrecciaIndietro;
	private JLabel lblBarraRicerca;
	private JLabel lblCodiceGate;
	private JLabel lblCodaImbarco;

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

	public JLabel getLblCodaImbarco1() {
		return lblCodaImbarco;
	}

	public void setLblCodaImbarco1(JLabel lblCodaImbarco1) {
		this.lblCodaImbarco = lblCodaImbarco1;
	}

	public JComboBox<String> getComboBoxCodaDiImbarco() {
		return comboBoxCodaDiImbarco;
	}

	public void setComboBoxCodaDiImbarco(JComboBox<String> comboBoxCodaDiImbarco1) {
		this.comboBoxCodaDiImbarco = comboBoxCodaDiImbarco1;
	}

	public JTable getTabella() {
		return tabella;
	}

	public void setTabella(JTable table) {
		this.tabella = table;
	}

	public JTextField getTxtCodaDiImbarco() {
		return txtCodaDiImbarco;
	}

	public void setTxtCodaDiImbarco(JTextField txtCodaDiImbarco1) {
		this.txtCodaDiImbarco = txtCodaDiImbarco1;
	}

	public JLabel getLblCodaImbarco() {
		return lblCodaImbarco;
	}

	public void setLblCodaImbarco(JLabel lblCodaImbarco) {
		this.lblCodaImbarco = lblCodaImbarco;
	}

	Controller controllerGestioneGate;

	public GateCodeImbarco(Controller controller) {
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
					controllerGestioneGate.eliminaGateCodeImbarco();
				}
			}
		});
		tabella.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int t = tabella.getSelectedRow();
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
				controllerGestioneGate.eliminaGateCodeImbarco();
			}
		});
		btnElimina.setBounds(750, 526, 89, 23);
		add(btnElimina);

		JButton btnAggiungi = new JButton("aggiungi");
		btnAggiungi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAggiungi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneGate.aggiungiGateCodeImbarco();
			}
		});
		btnAggiungi.setBounds(750, 461, 89, 23);
		add(btnAggiungi);

		JButton btnModifica = new JButton("modifica");
		btnModifica.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnModifica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneGate.modificaGateCodeImbarco();
			}
		});
		btnModifica.setBounds(750, 493, 89, 23);
		add(btnModifica);

		JButton btnSvuota = new JButton("svuota");
		btnSvuota.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSvuota.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneGate.svuotaCampiGateCodeImbarco();
			}
		});
		btnSvuota.setBounds(750, 560, 89, 23);
		add(btnSvuota);

		lblCodiceGate = new JLabel("Codice Gate");
		lblCodiceGate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodiceGate.setFont(controllerGestioneGate.fontLabel);
		lblCodiceGate.setForeground(controllerGestioneGate.coloreScritteTemaScuro);
		lblCodiceGate.setBounds(30, 461, 204, 20);
		add(lblCodiceGate);

		txtCodiceGate = new JTextField();
		txtCodiceGate.setEditable(false);
		txtCodiceGate.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent EventoInvio) {
				if (EventoInvio.getKeyCode() == KeyEvent.VK_ENTER) {
					controllerGestioneGate.aggiungiGateCodeImbarco();
				}
			}
		});
		txtCodiceGate.setFont(controllerGestioneGate.fontScritteGestioni);
		txtCodiceGate.setForeground(controllerGestioneGate.coloreScritteSuBiancoTemaScuro);
		txtCodiceGate.setColumns(10);
		txtCodiceGate.setBounds(244, 461, 82, 20);
		add(txtCodiceGate);

		lblCodaImbarco = new JLabel("Coda d'Imbarco");
		lblCodaImbarco.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodaImbarco.setForeground(controllerGestioneGate.coloreScritteTemaScuro);
		lblCodaImbarco.setFont(controllerGestioneGate.fontLabel);
		lblCodaImbarco.setBounds(30, 493, 204, 20);
		add(lblCodaImbarco);

		comboBoxCodaDiImbarco = new JComboBox<String>();
		comboBoxCodaDiImbarco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HashMap<String, String> map = controllerGestioneGate.implementazioneCodaDiImbarcoDAO()
						.stampaCodaDiImbarcoInComboBox();
				txtCodaDiImbarco.setText(map.get(comboBoxCodaDiImbarco.getSelectedItem().toString()));
			}
		});
		comboBoxCodaDiImbarco.setBounds(326, 493, 95, 20);
		add(comboBoxCodaDiImbarco);

		txtCodaDiImbarco = new JTextField();
		txtCodaDiImbarco.setHorizontalAlignment(SwingConstants.LEFT);
		txtCodaDiImbarco.setForeground(controllerGestioneGate.coloreScritteSuBiancoTemaScuro);
		txtCodaDiImbarco.setFont(controllerGestioneGate.fontScritteGestioni);
		txtCodaDiImbarco.setEditable(false);
		txtCodaDiImbarco.setColumns(10);
		txtCodaDiImbarco.setBounds(244, 493, 82, 20);
		add(txtCodaDiImbarco);

		comboBoxNumeroPorta = new JComboBox<String>();
		comboBoxNumeroPorta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HashMap<String, String> map = controllerGestioneGate.implementazioneGateDAO().stampaNumeroPortaInComboBox();
				txtCodiceGate.setText(map.get(comboBoxNumeroPorta.getSelectedItem().toString()));
			}
		});
		comboBoxNumeroPorta.setBounds(326, 461, 47, 20);
		add(comboBoxNumeroPorta);
		
		stampaComboBoxNumeroPorta();
		stampaComboBoxCodaDiImbarco();
		caricaTabella();

	}

	// METODI

	public void stampaComboBoxNumeroPorta() {
		HashMap<String, String> map = controllerGestioneGate.implementazioneGateDAO().stampaNumeroPortaInComboBox();
		for(String s : map.keySet()) {
			comboBoxNumeroPorta.addItem(s);
		}
	}
	
	public void stampaComboBoxCodaDiImbarco() {
		HashMap<String, String> map = controllerGestioneGate.implementazioneCodaDiImbarcoDAO()
				.stampaCodaDiImbarcoInComboBox();
		for (String s : map.keySet()) {
			comboBoxCodaDiImbarco.addItem(s);
		}
	}

	public void caricaTabella() {
		this.ListaGate = controllerGestioneGate.implementazioneGateDAO().stampaGateCodeImbarco();
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
