package GUI;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import Classi.Gate;
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
	Gate[] row = new Gate[4];
	DefaultTableModel modello = new DefaultTableModel(colonne, 0);
	List<Gate> ListaGate = new ArrayList<Gate>();
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

	private JLabel lblAggiungi;
	private JLabel lblModifica;
	private JLabel lblElimina;
	private JLabel lblSvuota;

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

	public JLabel getLblAggiungi() {
		return lblAggiungi;
	}

	public void setLblAggiungi(JLabel lblAggiungi) {
		this.lblAggiungi = lblAggiungi;
	}

	public JLabel getLblModifica() {
		return lblModifica;
	}

	public void setLblModifica(JLabel lblModifica) {
		this.lblModifica = lblModifica;
	}

	public JLabel getLblElimina() {
		return lblElimina;
	}

	public void setLblElimina(JLabel lblElimina) {
		this.lblElimina = lblElimina;
	}

	public JLabel getLblSvuota() {
		return lblSvuota;
	}

	public void setLblSvuota(JLabel lblSvuota) {
		this.lblSvuota = lblSvuota;
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
				if (controllerGestioneGate.cambioTema()) {
					lblimgfrecciaIndietro.setIcon(new ImageIcon(img.frecciaIndietro2TemaChiaro()));
				} else {
					lblimgfrecciaIndietro.setIcon(new ImageIcon(img.frecciaIndietro2()));
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (controllerGestioneGate.cambioTema()) {
					lblimgfrecciaIndietro.setIcon(new ImageIcon(img.frecciaIndietro1TemaChiaro()));
				} else {
					lblimgfrecciaIndietro.setIcon(new ImageIcon(img.frecciaIndietro1()));
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (controllerGestioneGate.cambioTema()) {
					lblimgfrecciaIndietro.setIcon(new ImageIcon(img.frecciaIndietro3TemaChiaro()));
				} else {
					lblimgfrecciaIndietro.setIcon(new ImageIcon(img.frecciaIndietro3()));
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (controllerGestioneGate.cambioTema()) {
					lblimgfrecciaIndietro.setIcon(new ImageIcon(img.frecciaIndietro2TemaChiaro()));
				} else {
					lblimgfrecciaIndietro.setIcon(new ImageIcon(img.frecciaIndietro2()));
				}
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
		txtCodiceGate.setBounds(244, 461, 0, 20);
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
				HashMap<String, String> map = null;
				try {
					map = controllerGestioneGate.implementazioneCodaDiImbarcoDAO().stampaCodaDiImbarcoInComboBox();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				txtCodaDiImbarco.setText(map.get(comboBoxCodaDiImbarco.getSelectedItem().toString()));
			}
		});
		comboBoxCodaDiImbarco.setBounds(244, 493, 95, 20);
		add(comboBoxCodaDiImbarco);

		txtCodaDiImbarco = new JTextField();
		txtCodaDiImbarco.setHorizontalAlignment(SwingConstants.LEFT);
		txtCodaDiImbarco.setForeground(controllerGestioneGate.coloreScritteSuBiancoTemaScuro);
		txtCodaDiImbarco.setFont(controllerGestioneGate.fontScritteGestioni);
		txtCodaDiImbarco.setEditable(false);
		txtCodaDiImbarco.setColumns(10);
		txtCodaDiImbarco.setBounds(244, 493, 0, 20);
		add(txtCodaDiImbarco);

		comboBoxNumeroPorta = new JComboBox<String>();
		comboBoxNumeroPorta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HashMap<String, String> map = null;
				try {
					map = controllerGestioneGate.implementazioneGateDAO().stampaNumeroPortaInComboBox();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				txtCodiceGate.setText(map.get(comboBoxNumeroPorta.getSelectedItem().toString()));
			}
		});
		comboBoxNumeroPorta.setBounds(244, 461, 47, 20);
		add(comboBoxNumeroPorta);

		lblAggiungi = new JLabel("");
		lblAggiungi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAggiungi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneGate.aggiungiGateCodeImbarco();

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				if (controllerGestioneGate.cambioTema()) {
					lblAggiungi.setIcon(new ImageIcon(img.aggiungi2TemaChiaro()));
				} else {
					lblAggiungi.setIcon(new ImageIcon(img.aggiungi2()));
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (controllerGestioneGate.cambioTema()) {
					lblAggiungi.setIcon(new ImageIcon(img.aggiungi1TemaChiaro()));
				} else {
					lblAggiungi.setIcon(new ImageIcon(img.aggiungi1()));
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (controllerGestioneGate.cambioTema()) {
					lblAggiungi.setIcon(new ImageIcon(img.aggiungi3TemaChiaro()));
				} else {
					lblAggiungi.setIcon(new ImageIcon(img.aggiungi3()));
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (controllerGestioneGate.cambioTema()) {
					lblAggiungi.setIcon(new ImageIcon(img.aggiungi2TemaChiaro()));
				} else {
					lblAggiungi.setIcon(new ImageIcon(img.aggiungi2()));
				}
			}

		});
		lblAggiungi.setHorizontalAlignment(SwingConstants.CENTER);
		lblAggiungi.setIcon(new ImageIcon(img.aggiungi1()));
		lblAggiungi.setBounds(358, 569, 130, 36);
		add(lblAggiungi);

		lblModifica = new JLabel("");
		lblModifica.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblModifica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneGate.modificaGateCodeImbarco();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				if (controllerGestioneGate.cambioTema()) {
					lblModifica.setIcon(new ImageIcon(img.modifica2TemaChiaro()));
				} else {
					lblModifica.setIcon(new ImageIcon(img.modifica2()));
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (controllerGestioneGate.cambioTema()) {
					lblModifica.setIcon(new ImageIcon(img.modifica1TemaChiaro()));
				} else {
					lblModifica.setIcon(new ImageIcon(img.modifica1()));
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (controllerGestioneGate.cambioTema()) {
					lblModifica.setIcon(new ImageIcon(img.modifica3TemaChiaro()));
				} else {
					lblModifica.setIcon(new ImageIcon(img.modifica3()));
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (controllerGestioneGate.cambioTema()) {
					lblModifica.setIcon(new ImageIcon(img.modifica2TemaChiaro()));
				} else {
					lblModifica.setIcon(new ImageIcon(img.modifica2()));
				}
			}
		});
		lblModifica.setHorizontalAlignment(SwingConstants.CENTER);
		lblModifica.setIcon(new ImageIcon(img.modifica1()));
		lblModifica.setBounds(114, 569, 130, 36);
		add(lblModifica);

		lblElimina = new JLabel("");
		lblElimina.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblElimina.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneGate.eliminaGateCodeImbarco();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				if (controllerGestioneGate.cambioTema()) {
					lblElimina.setIcon(new ImageIcon(img.elimina2TemaChiaro()));
				} else {
					lblElimina.setIcon(new ImageIcon(img.elimina2()));
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (controllerGestioneGate.cambioTema()) {
					lblElimina.setIcon(new ImageIcon(img.elimina1TemaChiaro()));
				} else {
					lblElimina.setIcon(new ImageIcon(img.elimina1()));
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (controllerGestioneGate.cambioTema()) {
					lblElimina.setIcon(new ImageIcon(img.elimina3TemaChiaro()));
				} else {
					lblElimina.setIcon(new ImageIcon(img.elimina3()));
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (controllerGestioneGate.cambioTema()) {
					lblElimina.setIcon(new ImageIcon(img.elimina2TemaChiaro()));
				} else {
					lblElimina.setIcon(new ImageIcon(img.elimina2()));
				}
			}
		});
		lblElimina.setHorizontalAlignment(SwingConstants.CENTER);
		lblElimina.setIcon(new ImageIcon(img.elimina1()));
		lblElimina.setBounds(837, 569, 130, 36);
		add(lblElimina);

		lblSvuota = new JLabel("");
		lblSvuota.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblSvuota.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneGate.svuotaCampiGateCodeImbarco();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				if (controllerGestioneGate.cambioTema()) {
					lblSvuota.setIcon(new ImageIcon(img.svuota2TemaChiaro()));
				} else {
					lblSvuota.setIcon(new ImageIcon(img.svuota2()));
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (controllerGestioneGate.cambioTema()) {
					lblSvuota.setIcon(new ImageIcon(img.svuota1TemaChiaro()));
				} else {
					lblSvuota.setIcon(new ImageIcon(img.svuota1()));
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (controllerGestioneGate.cambioTema()) {
					lblSvuota.setIcon(new ImageIcon(img.svuota3TemaChiaro()));
				} else {
					lblSvuota.setIcon(new ImageIcon(img.svuota3()));
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (controllerGestioneGate.cambioTema()) {
					lblSvuota.setIcon(new ImageIcon(img.svuota2TemaChiaro()));
				} else {
					lblSvuota.setIcon(new ImageIcon(img.svuota2()));
				}
			}
		});
		lblSvuota.setHorizontalAlignment(SwingConstants.CENTER);
		lblSvuota.setIcon(new ImageIcon(img.svuota1()));
		lblSvuota.setBounds(602, 569, 130, 36);
		add(lblSvuota);

		stampaComboBoxNumeroPorta();
		stampaComboBoxCodaDiImbarco();
		caricaTabella();

	}

	// METODI

	public void stampaComboBoxNumeroPorta() {
		HashMap<String, String> map = null;
		try {
			map = controllerGestioneGate.implementazioneGateDAO().stampaNumeroPortaInComboBox();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (String s : map.keySet()) {
			comboBoxNumeroPorta.addItem(s);
		}
	}

	public void stampaComboBoxCodaDiImbarco() {
		HashMap<String, String> map = null;
		try {
			map = controllerGestioneGate.implementazioneCodaDiImbarcoDAO().stampaCodaDiImbarcoInComboBox();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (String s : map.keySet()) {
			comboBoxCodaDiImbarco.addItem(s);
		}
	}

	public void caricaTabella() {
		try {
			this.ListaGate = controllerGestioneGate.implementazioneGateDAO().stampaGateCodeImbarco();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		modello.setNumRows(0);
		for (Gate dato : this.ListaGate) {
			this.modello.addRow(new Object[] { dato.getCodiceGate(), dato.getNumeroPorta(), dato.getCodeDiImbarco().getNomeCoda() });
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
