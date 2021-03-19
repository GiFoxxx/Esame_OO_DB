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

import Classi.CodaDiImbarco;
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
import javax.swing.border.LineBorder;

public class GateCodeImbarco extends JPanel {

	String colonneTabellaAssociazione[] = { "Codice Gate", "Coda D'Imbarco" };
	String colonneTabellaCodaDiImbarco[] = { "Codice Coda D'Imbarco", "Nome Coda D'Imbarco",
			"Tempo di Imbarco Stimato" };

	Gate[] rigaAssociazione = new Gate[4];
	CodaDiImbarco[] rigaCodaDiImbarco = new CodaDiImbarco[4];

	DefaultTableModel modelloTabellaAssociazione = new DefaultTableModel(colonneTabellaAssociazione, 0);
	DefaultTableModel modelloTabellaCodaDiImbarco = new DefaultTableModel(colonneTabellaCodaDiImbarco, 0);

	List<Gate> ListaGate = new ArrayList<Gate>();
	List<CodaDiImbarco> ListaCodaDiImbarco = new ArrayList<CodaDiImbarco>();

	private Immagini img = new Immagini();

	private JTextField txtCodiceGate;
	private JTextField txtCodaDiImbarco;
	private JTextField txtCodiceCodaDiImbarco;
	private JTextField txtTempoDiImbarcoStimato;
	private JTextField txtNomeCodaDiImbarco;
	private JTextField txtBarraRicerca;

	private JScrollPane scrollPaneTabellaAssociazioni;
	private JScrollPane scrollPaneTabellaCodaDiImbarco;

	private JComboBox<String> comboBoxCodaDiImbarco;
	private JComboBox<String> comboBoxNumeroPorta;

	private JTable tabellaAssociazioni;
	private JTable tabellaCodaDiImbarco;

	private JLabel lblimgfrecciaIndietro;
	private JLabel lblBarraRicerca;
	private JLabel lblCodiceGate;
	private JLabel lblCodaImbarco;
	private JLabel lblNomeCodaDiImbarco;
	private JLabel lblCodiceCodaDiImbarco;
	private JLabel lblTempoDiImbarcoStimato;
	private JLabel lblAggiungiAssociazione;
	private JLabel lblEliminaAssociazione;
	private JLabel lblSvuotaAssociazione;
	private JLabel lblAggiungiCodaImbarco;
	private JLabel lblEliminaCodaImbarco;
	private JLabel lblModificaCodaImbarco;
	private JLabel lblSvuotaCodaImbarco;
	private JLabel lblRicaricaTabelle;

	// GETTER E SETTER

	public CodaDiImbarco[] getRigaCodaDiImbarco() {
		return rigaCodaDiImbarco;
	}

	public void setRigaCodaDiImbarco(CodaDiImbarco[] rigaCodaDiImbarco) {
		this.rigaCodaDiImbarco = rigaCodaDiImbarco;
	}

	public DefaultTableModel getModelloTabellaAssociazione() {
		return modelloTabellaAssociazione;
	}

	public void setModelloTabellaAssociazione(DefaultTableModel modelloTabellaAssociazione) {
		this.modelloTabellaAssociazione = modelloTabellaAssociazione;
	}

	public DefaultTableModel getModelloTabellaCodaDiImbarco() {
		return modelloTabellaCodaDiImbarco;
	}

	public void setModelloTabellaCodaDiImbarco(DefaultTableModel modelloTabellaCodaDiImbarco) {
		this.modelloTabellaCodaDiImbarco = modelloTabellaCodaDiImbarco;
	}

	public List<Gate> getListaGate() {
		return ListaGate;
	}

	public void setListaGate(List<Gate> listaGate) {
		ListaGate = listaGate;
	}

	public List<CodaDiImbarco> getListaCodaDiImbarco() {
		return ListaCodaDiImbarco;
	}

	public void setListaCodaDiImbarco(List<CodaDiImbarco> listaCodaDiImbarco) {
		ListaCodaDiImbarco = listaCodaDiImbarco;
	}

	public JComboBox<String> getComboBoxNumeroPorta() {
		return comboBoxNumeroPorta;
	}

	public void setComboBoxNumeroPorta(JComboBox<String> comboBoxNumeroPorta) {
		this.comboBoxNumeroPorta = comboBoxNumeroPorta;
	}

	public JLabel getLblRicaricaTabelle() {
		return lblRicaricaTabelle;
	}

	public void setLblRicaricaTabelle(JLabel lblRicaricaTabella) {
		this.lblRicaricaTabelle = lblRicaricaTabella;
	}

	public void setRigaAssociazione(Gate[] rigaAssociazione) {
		this.rigaAssociazione = rigaAssociazione;
	}

	public Object[] getRigaAssociazione() {
		return rigaAssociazione;
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

	public JTable getTabellaAssociazioni() {
		return tabellaAssociazioni;
	}

	public void setTabellaAssociazioni(JTable table) {
		this.tabellaAssociazioni = table;
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

	public JLabel getLblAggiungiAssociazione() {
		return lblAggiungiAssociazione;
	}

	public void setLblAggiungiAssociazione(JLabel lblAggiungi) {
		this.lblAggiungiAssociazione = lblAggiungi;
	}

	public JLabel getLblEliminaAssociazione() {
		return lblEliminaAssociazione;
	}

	public void setLblEliminaAssociazione(JLabel lblElimina) {
		this.lblEliminaAssociazione = lblElimina;
	}

	public JLabel getLblSvuotaAssociazione() {
		return lblSvuotaAssociazione;
	}

	public void setLblSvuotaAssociazione(JLabel lblSvuota) {
		this.lblSvuotaAssociazione = lblSvuota;
	}

	public JTextField getTxtCodiceCodaDiImbarco() {
		return txtCodiceCodaDiImbarco;
	}

	public void setTxtCodiceCodaDiImbarco(JTextField txtCodiceCodaDiImbarco) {
		this.txtCodiceCodaDiImbarco = txtCodiceCodaDiImbarco;
	}

	public JTextField getTxtTempoDiImbarcoStimato() {
		return txtTempoDiImbarcoStimato;
	}

	public void setTxtTempoDiImbarcoStimato(JTextField txtTempoDiImbarcoStimato) {
		this.txtTempoDiImbarcoStimato = txtTempoDiImbarcoStimato;
	}

	public JTextField getTxtNomeCodaDiImbarco() {
		return txtNomeCodaDiImbarco;
	}

	public void setTxtNomeCodaDiImbarco(JTextField txtNomeCodaDiImbarco) {
		this.txtNomeCodaDiImbarco = txtNomeCodaDiImbarco;
	}

	public JTable getTabellaCodaDiImbarco() {
		return tabellaCodaDiImbarco;
	}

	public void setTabellaCodaDiImbarco(JTable tabellaCodaDiImbarco) {
		this.tabellaCodaDiImbarco = tabellaCodaDiImbarco;
	}

	public JLabel getLblNomeCodaDiImbarco() {
		return lblNomeCodaDiImbarco;
	}

	public void setLblNomeCodaDiImbarco(JLabel lblNomeCodaDiImbarco) {
		this.lblNomeCodaDiImbarco = lblNomeCodaDiImbarco;
	}

	public JLabel getLblCodiceCodaDiImbarco() {
		return lblCodiceCodaDiImbarco;
	}

	public void setLblCodiceCodaDiImbarco(JLabel lblCodiceCodaDiImbarco) {
		this.lblCodiceCodaDiImbarco = lblCodiceCodaDiImbarco;
	}

	public JLabel getLblTempoDiImbarcoStimato() {
		return lblTempoDiImbarcoStimato;
	}

	public void setLblTempoDiImbarcoStimato(JLabel lblTempoDiImbarcoStimato) {
		this.lblTempoDiImbarcoStimato = lblTempoDiImbarcoStimato;
	}

	public JLabel getLblAggiungiCodaImbarco() {
		return lblAggiungiCodaImbarco;
	}

	public void setLblAggiungiCodaImbarco(JLabel lblAggiungiCodaImbarco) {
		this.lblAggiungiCodaImbarco = lblAggiungiCodaImbarco;
	}

	public JLabel getLblEliminaCodaImbarco() {
		return lblEliminaCodaImbarco;
	}

	public void setLblEliminaCodaImbarco(JLabel lblEliminaCodaImbarco) {
		this.lblEliminaCodaImbarco = lblEliminaCodaImbarco;
	}

	public JLabel getLblModificaCodaImbarco() {
		return lblModificaCodaImbarco;
	}

	public void setLblModificaCodaImbarco(JLabel lblModificaCodaImbarco) {
		this.lblModificaCodaImbarco = lblModificaCodaImbarco;
	}

	public JLabel getLblSvuotaCodaImbarco() {
		return lblSvuotaCodaImbarco;
	}

	public void setLblSvuotaCodaImbarco(JLabel lblSvuotaCodaImbarco) {
		this.lblSvuotaCodaImbarco = lblSvuotaCodaImbarco;
	}

	Controller controllerGateCodeImbarco;

	public GateCodeImbarco(Controller controller) {
		controllerGateCodeImbarco = controller;

		setBounds(0, 0, 1090, 642);
		setBackground(controllerGateCodeImbarco.sfondoTemaScuro);
		setLayout(null);

		lblimgfrecciaIndietro = new JLabel("");
		lblimgfrecciaIndietro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblimgfrecciaIndietro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGateCodeImbarco.setPannelloPrecedente(1);
				controllerGateCodeImbarco.mostraPannelli(controllerGateCodeImbarco.getDashboard().getHome());
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				controllerGateCodeImbarco.cambioImmagineTema(lblimgfrecciaIndietro, img.frecciaIndietro2TemaChiaro(),
						img.frecciaIndietro2());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerGateCodeImbarco.cambioImmagineTema(lblimgfrecciaIndietro, img.frecciaIndietro1TemaChiaro(),
						img.frecciaIndietro1());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				controllerGateCodeImbarco.cambioImmagineTema(lblimgfrecciaIndietro, img.frecciaIndietro3TemaChiaro(),
						img.frecciaIndietro3());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				controllerGateCodeImbarco.cambioImmagineTema(lblimgfrecciaIndietro, img.frecciaIndietro1TemaChiaro(),
						img.frecciaIndietro1());
			}
		});
		lblimgfrecciaIndietro.setHorizontalAlignment(SwingConstants.CENTER);
		lblimgfrecciaIndietro.setForeground(Color.BLACK);
		lblimgfrecciaIndietro.setIcon(new ImageIcon(img.frecciaIndietro1()));
		lblimgfrecciaIndietro.setBounds(30, 44, 30, 30);
		add(lblimgfrecciaIndietro);

		txtBarraRicerca = new JTextField();
		txtBarraRicerca.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				ricerca();
			}
		});
		txtBarraRicerca.setBackground(controllerGateCodeImbarco.escoPannelloTemaScuro);
		txtBarraRicerca.setForeground(controllerGateCodeImbarco.coloreScritteTemaScuro);
		txtBarraRicerca.setFont(controllerGateCodeImbarco.fontScritteGestioni);
		txtBarraRicerca.setBorder(null);
		txtBarraRicerca.setBounds(888, 49, 141, 21);
		add(txtBarraRicerca);
		txtBarraRicerca.setColumns(10);

		lblBarraRicerca = new JLabel("");
		lblBarraRicerca.setHorizontalAlignment(SwingConstants.CENTER);
		lblBarraRicerca.setIcon(new ImageIcon(img.barraRicerca()));
		lblBarraRicerca.setBounds(876, 47, 184, 25);
		add(lblBarraRicerca);

		scrollPaneTabellaAssociazioni = new JScrollPane();
		scrollPaneTabellaAssociazioni.setBorder(new LineBorder(controllerGateCodeImbarco.bordi));
		scrollPaneTabellaAssociazioni.setFont(controllerGateCodeImbarco.fontLabel);
		scrollPaneTabellaAssociazioni.setEnabled(false);
		scrollPaneTabellaAssociazioni.setBounds(30, 85, 300, 330);
		add(scrollPaneTabellaAssociazioni);

		tabellaAssociazioni = new JTable();
		tabellaAssociazioni.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent EventoDelete) {
				if (EventoDelete.getKeyCode() == KeyEvent.VK_DELETE) {
					controllerGateCodeImbarco.eliminaGateCodeImbarco();
				}
			}
		});
		modelloTabellaAssociazione.setColumnIdentifiers(colonneTabellaAssociazione);
		tabellaAssociazioni.setModel(modelloTabellaAssociazione);
		scrollPaneTabellaAssociazioni.setViewportView(tabellaAssociazioni);

		lblCodiceGate = new JLabel("Codice Gate");
		lblCodiceGate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodiceGate.setFont(controllerGateCodeImbarco.fontLabel);
		lblCodiceGate.setForeground(controllerGateCodeImbarco.coloreScritteTemaScuro);
		lblCodiceGate.setBounds(30, 442, 105, 20);
		add(lblCodiceGate);

		txtCodiceGate = new JTextField();
		txtCodiceGate.setEditable(false);
		txtCodiceGate.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent EventoInvio) {
				if (EventoInvio.getKeyCode() == KeyEvent.VK_ENTER) {
					controllerGateCodeImbarco.aggiungiGateCodeImbarco();
				}
			}
		});
		txtCodiceGate.setFont(controllerGateCodeImbarco.fontScritteGestioni);
		txtCodiceGate.setForeground(controllerGateCodeImbarco.coloreScritteSuBiancoTemaScuro);
		txtCodiceGate.setColumns(10);
		txtCodiceGate.setBounds(170, 426, 0, 20);
		add(txtCodiceGate);

		comboBoxNumeroPorta = new JComboBox<String>();
		comboBoxNumeroPorta.setBorder(new LineBorder(controllerGateCodeImbarco.bordi));
		comboBoxNumeroPorta.setFont(new Font("Arial", Font.PLAIN, 11));
		comboBoxNumeroPorta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HashMap<String, String> map = null;
				try {
					map = controllerGateCodeImbarco.implementazioneGateDAO().stampaNumeroPortaInComboBox();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				txtCodiceGate.setText(map.get(comboBoxNumeroPorta.getSelectedItem().toString()));
			}
		});
		comboBoxNumeroPorta.setForeground(controllerGateCodeImbarco.coloreScritteSuBiancoTemaScuro);
		comboBoxNumeroPorta.setFont(controllerGateCodeImbarco.fontScritteGestioni);
		comboBoxNumeroPorta.setBounds(145, 442, 45, 20);
		add(comboBoxNumeroPorta);

		lblCodaImbarco = new JLabel("Coda d'Imbarco");
		lblCodaImbarco.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodaImbarco.setForeground(controllerGateCodeImbarco.coloreScritteTemaScuro);
		lblCodaImbarco.setFont(controllerGateCodeImbarco.fontLabel);
		lblCodaImbarco.setBounds(30, 473, 105, 20);
		add(lblCodaImbarco);

		comboBoxCodaDiImbarco = new JComboBox<String>();
		comboBoxCodaDiImbarco.setBorder(new LineBorder(controllerGateCodeImbarco.bordi));
		comboBoxCodaDiImbarco.setFont(new Font("Arial", Font.PLAIN, 11));
		comboBoxCodaDiImbarco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HashMap<String, String> map = null;
				try {
					map = controllerGateCodeImbarco.implementazioneCodaDiImbarcoDAO().stampaCodaDiImbarcoInComboBox();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				txtCodaDiImbarco.setText(map.get(comboBoxCodaDiImbarco.getSelectedItem().toString()));
			}
		});
		comboBoxCodaDiImbarco.setForeground(controllerGateCodeImbarco.coloreScritteSuBiancoTemaScuro);
		comboBoxCodaDiImbarco.setFont(controllerGateCodeImbarco.fontScritteGestioni);
		comboBoxCodaDiImbarco.setBounds(145, 473, 133, 20);
		add(comboBoxCodaDiImbarco);

		txtCodaDiImbarco = new JTextField();
		txtCodaDiImbarco.setHorizontalAlignment(SwingConstants.LEFT);
		txtCodaDiImbarco.setForeground(controllerGateCodeImbarco.coloreScritteSuBiancoTemaScuro);
		txtCodaDiImbarco.setFont(controllerGateCodeImbarco.fontScritteGestioni);
		txtCodaDiImbarco.setEditable(false);
		txtCodaDiImbarco.setColumns(10);
		txtCodaDiImbarco.setBounds(170, 473, 0, 20);
		add(txtCodaDiImbarco);

		lblAggiungiAssociazione = new JLabel("");
		lblAggiungiAssociazione.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAggiungiAssociazione.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGateCodeImbarco.aggiungiGateCodeImbarco();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				controllerGateCodeImbarco.cambioImmagineTema(lblAggiungiAssociazione, img.aggiungi2TemaChiaro(),
						img.aggiungi2());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerGateCodeImbarco.cambioImmagineTema(lblAggiungiAssociazione, img.aggiungi1TemaChiaro(),
						img.aggiungi1());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				controllerGateCodeImbarco.cambioImmagineTema(lblAggiungiAssociazione, img.aggiungi3TemaChiaro(),
						img.aggiungi3());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				controllerGateCodeImbarco.cambioImmagineTema(lblAggiungiAssociazione, img.aggiungi1TemaChiaro(),
						img.aggiungi1());
			}

		});
		lblAggiungiAssociazione.setHorizontalAlignment(SwingConstants.CENTER);
		lblAggiungiAssociazione.setIcon(new ImageIcon(img.aggiungi1()));
		lblAggiungiAssociazione.setBounds(30, 520, 130, 36);
		add(lblAggiungiAssociazione);

		lblEliminaAssociazione = new JLabel("");
		lblEliminaAssociazione.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblEliminaAssociazione.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGateCodeImbarco.eliminaGateCodeImbarco();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				controllerGateCodeImbarco.cambioImmagineTema(lblEliminaAssociazione, img.elimina2TemaChiaro(),
						img.elimina2());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerGateCodeImbarco.cambioImmagineTema(lblEliminaAssociazione, img.elimina1TemaChiaro(),
						img.elimina1());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				controllerGateCodeImbarco.cambioImmagineTema(lblEliminaAssociazione, img.elimina3TemaChiaro(),
						img.elimina3());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				controllerGateCodeImbarco.cambioImmagineTema(lblEliminaAssociazione, img.elimina1TemaChiaro(),
						img.elimina1());
			}
		});
		lblEliminaAssociazione.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminaAssociazione.setIcon(new ImageIcon(img.elimina1()));
		lblEliminaAssociazione.setBounds(200, 520, 130, 36);
		add(lblEliminaAssociazione);

		lblSvuotaAssociazione = new JLabel("");
		lblSvuotaAssociazione.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblSvuotaAssociazione.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGateCodeImbarco.svuotaCampiGateCodeImbarco();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				controllerGateCodeImbarco.cambioImmagineTema(lblSvuotaAssociazione, img.svuota2TemaChiaro(),
						img.svuota2());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerGateCodeImbarco.cambioImmagineTema(lblSvuotaAssociazione, img.svuota1TemaChiaro(),
						img.svuota1());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				controllerGateCodeImbarco.cambioImmagineTema(lblSvuotaAssociazione, img.svuota3TemaChiaro(),
						img.svuota3());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				controllerGateCodeImbarco.cambioImmagineTema(lblSvuotaAssociazione, img.svuota1TemaChiaro(),
						img.svuota1());
			}
		});
		lblSvuotaAssociazione.setHorizontalAlignment(SwingConstants.CENTER);
		lblSvuotaAssociazione.setIcon(new ImageIcon(img.svuota1()));
		lblSvuotaAssociazione.setBounds(115, 578, 130, 36);
		add(lblSvuotaAssociazione);

		scrollPaneTabellaCodaDiImbarco = new JScrollPane();
		scrollPaneTabellaCodaDiImbarco.setBorder(new LineBorder(controllerGateCodeImbarco.bordi));
		scrollPaneTabellaCodaDiImbarco.setFont(controllerGateCodeImbarco.fontLabel);
		scrollPaneTabellaCodaDiImbarco.setEnabled(false);
		scrollPaneTabellaCodaDiImbarco.setBounds(350, 86, 710, 330);
		add(scrollPaneTabellaCodaDiImbarco);

		tabellaCodaDiImbarco = new JTable();
		tabellaCodaDiImbarco.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent EventoDelete) {
				if (EventoDelete.getKeyCode() == KeyEvent.VK_DELETE) {

				}
			}
		});
		tabellaCodaDiImbarco.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int t = tabellaCodaDiImbarco.getSelectedRow();
				txtCodiceCodaDiImbarco.setText(modelloTabellaCodaDiImbarco.getValueAt(t, 0).toString());
				txtNomeCodaDiImbarco.setText(modelloTabellaCodaDiImbarco.getValueAt(t, 1).toString());
			}
		});
		modelloTabellaCodaDiImbarco.setColumnIdentifiers(colonneTabellaCodaDiImbarco);
		tabellaCodaDiImbarco.setModel(modelloTabellaCodaDiImbarco);
		scrollPaneTabellaCodaDiImbarco.setViewportView(tabellaCodaDiImbarco);

		lblNomeCodaDiImbarco = new JLabel("Nome Coda di Imbarco");
		lblNomeCodaDiImbarco.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNomeCodaDiImbarco.setFont(controllerGateCodeImbarco.fontLabel);
		lblNomeCodaDiImbarco.setForeground(controllerGateCodeImbarco.coloreScritteTemaScuro);
		lblNomeCodaDiImbarco.setBounds(477, 473, 175, 20);
		add(lblNomeCodaDiImbarco);

		lblCodiceCodaDiImbarco = new JLabel("Codice Coda di Imbarco");
		lblCodiceCodaDiImbarco.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodiceCodaDiImbarco.setFont(controllerGateCodeImbarco.fontLabel);
		lblCodiceCodaDiImbarco.setForeground(controllerGateCodeImbarco.coloreScritteTemaScuro);
		lblCodiceCodaDiImbarco.setBounds(477, 442, 175, 20);
		add(lblCodiceCodaDiImbarco);

		lblTempoDiImbarcoStimato = new JLabel("Tempo di Imbarco Stimato");
		lblTempoDiImbarcoStimato.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTempoDiImbarcoStimato.setFont(controllerGateCodeImbarco.fontLabel);
		lblTempoDiImbarcoStimato.setForeground(controllerGateCodeImbarco.coloreScritteTemaScuro);
		lblTempoDiImbarcoStimato.setBounds(477, 504, 175, 20);
		add(lblTempoDiImbarcoStimato);

		txtCodiceCodaDiImbarco = new JTextField();
		txtCodiceCodaDiImbarco.setBorder(new LineBorder(controllerGateCodeImbarco.bordi));
		txtCodiceCodaDiImbarco.setFont(controllerGateCodeImbarco.fontScritteGestioni);
		txtCodiceCodaDiImbarco.setForeground(controllerGateCodeImbarco.coloreScritteSuBiancoTemaScuro);
		txtCodiceCodaDiImbarco.setBounds(660, 442, 75, 20);
		add(txtCodiceCodaDiImbarco);
		txtCodiceCodaDiImbarco.setColumns(10);

		txtTempoDiImbarcoStimato = new JTextField();
		txtTempoDiImbarcoStimato.setBorder(new LineBorder(controllerGateCodeImbarco.bordi));
		txtTempoDiImbarcoStimato.setFont(controllerGateCodeImbarco.fontScritteGestioni);
		txtTempoDiImbarcoStimato.setForeground(controllerGateCodeImbarco.coloreScritteSuBiancoTemaScuro);
		txtTempoDiImbarcoStimato.setBounds(660, 504, 45, 20);
		add(txtTempoDiImbarcoStimato);
		txtTempoDiImbarcoStimato.setColumns(10);

		txtNomeCodaDiImbarco = new JTextField();
		txtNomeCodaDiImbarco.setBorder(new LineBorder(controllerGateCodeImbarco.bordi));
		txtNomeCodaDiImbarco.setFont(controllerGateCodeImbarco.fontScritteGestioni);
		txtNomeCodaDiImbarco.setForeground(controllerGateCodeImbarco.coloreScritteSuBiancoTemaScuro);
		txtNomeCodaDiImbarco.setBounds(660, 473, 133, 20);
		add(txtNomeCodaDiImbarco);
		txtNomeCodaDiImbarco.setColumns(10);

		lblAggiungiCodaImbarco = new JLabel("");
		lblAggiungiCodaImbarco.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAggiungiCodaImbarco.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGateCodeImbarco.aggiungiCodaDiImbarco();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				controllerGateCodeImbarco.cambioImmagineTema(lblAggiungiCodaImbarco, img.aggiungi2TemaChiaro(),
						img.aggiungi2());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerGateCodeImbarco.cambioImmagineTema(lblAggiungiCodaImbarco, img.aggiungi1TemaChiaro(),
						img.aggiungi1());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				controllerGateCodeImbarco.cambioImmagineTema(lblAggiungiCodaImbarco, img.aggiungi3TemaChiaro(),
						img.aggiungi3());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				controllerGateCodeImbarco.cambioImmagineTema(lblAggiungiCodaImbarco, img.aggiungi1TemaChiaro(),
						img.aggiungi1());
			}

		});
		lblAggiungiCodaImbarco.setHorizontalAlignment(SwingConstants.CENTER);
		lblAggiungiCodaImbarco.setIcon(new ImageIcon(img.aggiungi1()));
		lblAggiungiCodaImbarco.setBounds(876, 437, 130, 36);
		add(lblAggiungiCodaImbarco);

		lblEliminaCodaImbarco = new JLabel("");
		lblEliminaCodaImbarco.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblEliminaCodaImbarco.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGateCodeImbarco.eliminaCodaDiImbarco();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				controllerGateCodeImbarco.cambioImmagineTema(lblEliminaCodaImbarco, img.elimina2TemaChiaro(),
						img.elimina2());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerGateCodeImbarco.cambioImmagineTema(lblEliminaCodaImbarco, img.elimina1TemaChiaro(),
						img.elimina1());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				controllerGateCodeImbarco.cambioImmagineTema(lblEliminaCodaImbarco, img.elimina3TemaChiaro(),
						img.elimina3());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				controllerGateCodeImbarco.cambioImmagineTema(lblEliminaCodaImbarco, img.elimina1TemaChiaro(),
						img.elimina1());
			}
		});
		lblEliminaCodaImbarco.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminaCodaImbarco.setIcon(new ImageIcon(img.elimina1()));
		lblEliminaCodaImbarco.setBounds(876, 531, 130, 36);
		add(lblEliminaCodaImbarco);

		lblModificaCodaImbarco = new JLabel("");
		lblModificaCodaImbarco.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblModificaCodaImbarco.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGateCodeImbarco.modificaCodaDiImbarco();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				controllerGateCodeImbarco.cambioImmagineTema(lblModificaCodaImbarco, img.modifica2TemaChiaro(),
						img.modifica2());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerGateCodeImbarco.cambioImmagineTema(lblModificaCodaImbarco, img.modifica1TemaChiaro(),
						img.modifica1());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				controllerGateCodeImbarco.cambioImmagineTema(lblModificaCodaImbarco, img.modifica3TemaChiaro(),
						img.modifica3());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				controllerGateCodeImbarco.cambioImmagineTema(lblModificaCodaImbarco, img.modifica1TemaChiaro(),
						img.modifica1());
			}
		});
		lblModificaCodaImbarco.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificaCodaImbarco.setIcon(new ImageIcon(img.modifica1()));
		lblModificaCodaImbarco.setBounds(876, 484, 130, 36);
		add(lblModificaCodaImbarco);

		lblSvuotaCodaImbarco = new JLabel("");
		lblSvuotaCodaImbarco.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblSvuotaCodaImbarco.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGateCodeImbarco.svuotaCampiCodaDiImbarco();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				controllerGateCodeImbarco.cambioImmagineTema(lblSvuotaCodaImbarco, img.svuota2TemaChiaro(),
						img.svuota2());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerGateCodeImbarco.cambioImmagineTema(lblSvuotaCodaImbarco, img.svuota1TemaChiaro(),
						img.svuota1());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				controllerGateCodeImbarco.cambioImmagineTema(lblSvuotaCodaImbarco, img.svuota3TemaChiaro(),
						img.svuota3());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				controllerGateCodeImbarco.cambioImmagineTema(lblSvuotaCodaImbarco, img.svuota1TemaChiaro(),
						img.svuota1());
			}
		});
		lblSvuotaCodaImbarco.setHorizontalAlignment(SwingConstants.CENTER);
		lblSvuotaCodaImbarco.setIcon(new ImageIcon(img.svuota1()));
		lblSvuotaCodaImbarco.setBounds(876, 578, 130, 36);
		add(lblSvuotaCodaImbarco);

		lblRicaricaTabelle = new JLabel("");
		lblRicaricaTabelle.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblRicaricaTabelle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				aggiorna();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				controllerGateCodeImbarco.cambioImmagineTema(lblRicaricaTabelle, img.aggiorna2TemaChiaro(),
						img.aggiorna2());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerGateCodeImbarco.cambioImmagineTema(lblRicaricaTabelle, img.aggiorna1TemaChiaro(),
						img.aggiorna1());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				controllerGateCodeImbarco.cambioImmagineTema(lblRicaricaTabelle, img.aggiorna3TemaChiaro(),
						img.aggiorna3());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				controllerGateCodeImbarco.cambioImmagineTema(lblRicaricaTabelle, img.aggiorna1TemaChiaro(),
						img.aggiorna1());
			}
		});
		lblRicaricaTabelle.setHorizontalAlignment(SwingConstants.CENTER);
		lblRicaricaTabelle.setIcon(new ImageIcon(img.aggiorna1()));
		lblRicaricaTabelle.setBounds(836, 44, 30, 30);
		add(lblRicaricaTabelle);

		stampaComboBoxNumeroPorta();
		stampaComboBoxCodaDiImbarco();
		caricaTabellaAssociazione();
		caricaTabellaCodaDiImbarco();
	}

	// METODI

	public void stampaComboBoxNumeroPorta() {
		HashMap<String, String> map = null;
		try {
			map = controllerGateCodeImbarco.implementazioneGateDAO().stampaNumeroPortaInComboBox();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		comboBoxNumeroPorta.addItem("---");
		for (String s : map.keySet()) {
			comboBoxNumeroPorta.addItem(s);
		}
	}

	public void stampaComboBoxCodaDiImbarco() {
		HashMap<String, String> map = null;
		try {
			map = controllerGateCodeImbarco.implementazioneCodaDiImbarcoDAO().stampaCodaDiImbarcoInComboBox();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		comboBoxCodaDiImbarco.addItem("----------");
		for (String s : map.keySet()) {
			comboBoxCodaDiImbarco.addItem(s);
		}
	}

	public void caricaTabellaAssociazione() {
		try {
			this.ListaGate = controllerGateCodeImbarco.implementazioneGateDAO().stampaGateCodeImbarco();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		modelloTabellaAssociazione.setNumRows(0);
		for (Gate dato : this.ListaGate) {
			this.modelloTabellaAssociazione
					.addRow(new Object[] { dato.getCodiceGate(), dato.getCodeDiImbarco().getNomeCoda() });
		}
		tabellaAssociazioni.setModel(modelloTabellaAssociazione);
	}

	public void caricaTabellaCodaDiImbarco() {
		try {
			this.ListaCodaDiImbarco = controllerGateCodeImbarco.implementazioneCodaDiImbarcoDAO().stampaCodaDiImbarco();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		modelloTabellaCodaDiImbarco.setNumRows(0);
		for (CodaDiImbarco dato : this.ListaCodaDiImbarco) {
			this.modelloTabellaCodaDiImbarco.addRow(
					new Object[] { dato.getCodiceCodaDiImbarco(), dato.getNomeCoda(), dato.getTempoImbarcoStimato() });
		}
		tabellaCodaDiImbarco.setModel(modelloTabellaCodaDiImbarco);
	}

	private void ricerca() {
		DefaultTableModel table = (DefaultTableModel) tabellaAssociazioni.getModel();
		String ricerca = txtBarraRicerca.getText();
		TableRowSorter<DefaultTableModel> trm = new TableRowSorter<DefaultTableModel>(table);
		tabellaAssociazioni.setRowSorter(trm);
		trm.setRowFilter(RowFilter.regexFilter(ricerca));
	}

	private void aggiorna() {
		caricaTabellaAssociazione();
		caricaTabellaCodaDiImbarco();
		controllerGateCodeImbarco.rimuoviElementiComboBox(comboBoxNumeroPorta);
		stampaComboBoxNumeroPorta();
		comboBoxNumeroPorta.removeItemAt(0);
		controllerGateCodeImbarco.rimuoviElementiComboBox(comboBoxCodaDiImbarco);
		stampaComboBoxCodaDiImbarco();
		comboBoxCodaDiImbarco.removeItemAt(0);
	}
}
