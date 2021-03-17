package GUI;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import Classi.Gate;
import Controller.Controller;
import Immagini.Immagini;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.RowFilter;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import java.awt.Cursor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import com.toedter.calendar.JDateChooser;

public class UtilizzoGate extends JPanel {

	String colonneTabellaGate[] = { "Codice Gate", "Numero Porta" };
	String colonneTabellaUtilizzi[] = { "Gate Selezionato", "Utilizzo Effettivo", "Utilizzo Stimato",
			"Periodo scelto" };

	Gate[] riga = new Gate[4];
	Gate[] rigaUtilizzo = new Gate[4];

	DefaultTableModel modelloTabellaGate = new DefaultTableModel(colonneTabellaGate, 0);
	DefaultTableModel modelloTabellaUtilizzi = new DefaultTableModel(colonneTabellaUtilizzi, 0);

	List<Gate> ListaGate = new ArrayList<Gate>();
	List<Gate> ListaUtilizzoGate = new ArrayList<Gate>();
	
	private Immagini img = new Immagini();

	private JTextField txtCodiceGate;
	private JTextField txtNumeroPorta;
	private JDateChooser dataUtilizzo;

	private JTextField txtBarraRicerca;

	private JLabel lblimgfrecciaIndietro;
	private JLabel lblBarraRicerca;
	private JLabel lblNumeroPorta;
	private JLabel lblCodiceGate;
	private JLabel lblSelezionaData;
	private JLabel lblCalcolaUtilizzo;
	private JLabel lblGiorno;
	private JLabel lblSettimana;
	private JLabel lblMese;
	private JLabel lblSvuota;
	private JLabel lblRicaricaTabella;

	private JScrollPane scrollPaneTabellaGate;
	private JTable tabellaGate;
	private JScrollPane scrollPaneTabellaUtilizzi;
	private JTable tabellaUtilizzi;

	// GETTER E SETTER

	public Gate[] getRigaUtilizzo() {
		return rigaUtilizzo;
	}

	public void setRigaUtilizzo(Gate[] rigaUtilizzo) {
		this.rigaUtilizzo = rigaUtilizzo;
	}

	public DefaultTableModel getModelloTabellaUtilizzi() {
		return modelloTabellaUtilizzi;
	}

	public void setModelloTabellaUtilizzi(DefaultTableModel modelloTabellaUtilizzi) {
		this.modelloTabellaUtilizzi = modelloTabellaUtilizzi;
	}

	public List<Gate> getListaGate() {
		return ListaGate;
	}

	public void setListaGate(List<Gate> listaGate) {
		ListaGate = listaGate;
	}

	public List<Gate> getListaUtilizzoGate() {
		return ListaUtilizzoGate;
	}

	public void setListaUtilizzoGate(List<Gate> listaUtilizzoGate) {
		ListaUtilizzoGate = listaUtilizzoGate;
	}

	public void setRiga(Gate[] riga) {
		this.riga = riga;
	}

	public DefaultTableModel getModelloTabellaGate() {
		return modelloTabellaGate;
	}

	public void setModelloTabellaGate(DefaultTableModel modello) {
		this.modelloTabellaGate = modello;
	}

	public Object[] getRiga() {
		return riga;
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

	public JTable getTabellaGate() {
		return tabellaGate;
	}

	public void setTabellaGate(JTable table) {
		this.tabellaGate = table;
	}

	public JTable getTabellaUtilizzi() {
		return tabellaUtilizzi;
	}

	public void setTabellaUtilizzi(JTable tabellaUtilizzi) {
		this.tabellaUtilizzi = tabellaUtilizzi;
	}

	public JLabel getLblSvuota() {
		return lblSvuota;
	}

	public void setLblSvuota(JLabel lblSvuota) {
		this.lblSvuota = lblSvuota;
	}

	public JDateChooser getDataUtilizzo() {
		return dataUtilizzo;
	}

	public void setDataUtilizzo(JDateChooser dataUtilizzo) {
		this.dataUtilizzo = dataUtilizzo;
	}

	public JLabel getLblSelezionaData() {
		return lblSelezionaData;
	}

	public void setLblSelezionaData(JLabel lblSelezionaData) {
		this.lblSelezionaData = lblSelezionaData;
	}

	public JLabel getLblCalcolaUtilizzo() {
		return lblCalcolaUtilizzo;
	}

	public void setLblCalcolaUtilizzo(JLabel lblCalcolaUtilizzo) {
		this.lblCalcolaUtilizzo = lblCalcolaUtilizzo;
	}

	public JLabel getLblGiorno() {
		return lblGiorno;
	}

	public void setLblGiorno(JLabel lblGiorno) {
		this.lblGiorno = lblGiorno;
	}

	public JLabel getLblSettimana() {
		return lblSettimana;
	}

	public void setLblSettimana(JLabel lblSettimana) {
		this.lblSettimana = lblSettimana;
	}

	public JLabel getLblMese() {
		return lblMese;
	}

	public void setLblMese(JLabel lblMese) {
		this.lblMese = lblMese;
	}

	Controller controllerUtilizzoGate;

	public UtilizzoGate(Controller controller) {
		controllerUtilizzoGate = controller;

		setBounds(0, 0, 1090, 642);
		setBackground(controllerUtilizzoGate.sfondoTemaScuro);
		setLayout(null);

		lblimgfrecciaIndietro = new JLabel("");
		lblimgfrecciaIndietro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblimgfrecciaIndietro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerUtilizzoGate.setPannelloPrecedente(1);
				controllerUtilizzoGate.mostraPannelli(controllerUtilizzoGate.getDashboard().getHome());
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				controllerUtilizzoGate.cambioImmagineTema(lblimgfrecciaIndietro, img.frecciaIndietro2TemaChiaro(),
						img.frecciaIndietro2());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerUtilizzoGate.cambioImmagineTema(lblimgfrecciaIndietro, img.frecciaIndietro1TemaChiaro(),
						img.frecciaIndietro1());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				controllerUtilizzoGate.cambioImmagineTema(lblimgfrecciaIndietro, img.frecciaIndietro3TemaChiaro(),
						img.frecciaIndietro3());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				controllerUtilizzoGate.cambioImmagineTema(lblimgfrecciaIndietro, img.frecciaIndietro1TemaChiaro(),
						img.frecciaIndietro1());
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
		txtBarraRicerca.setBackground(controllerUtilizzoGate.escoPannelloTemaScuro);
		txtBarraRicerca.setForeground(controllerUtilizzoGate.coloreScritteTemaScuro);
		txtBarraRicerca.setFont(controllerUtilizzoGate.fontScritteGestioni);
		txtBarraRicerca.setBorder(null);
		txtBarraRicerca.setBounds(888, 41, 141, 20);
		add(txtBarraRicerca);
		txtBarraRicerca.setColumns(10);

		lblBarraRicerca = new JLabel("");
		lblBarraRicerca.setHorizontalAlignment(SwingConstants.CENTER);
		lblBarraRicerca.setIcon(new ImageIcon(img.barraRicerca()));
		lblBarraRicerca.setBounds(876, 38, 184, 25);
		add(lblBarraRicerca);

		scrollPaneTabellaGate = new JScrollPane();
		scrollPaneTabellaGate.setFont(controllerUtilizzoGate.fontLabel);
		scrollPaneTabellaGate.setEnabled(false);
		scrollPaneTabellaGate.setBounds(30, 85, 318, 330);
		add(scrollPaneTabellaGate);

		tabellaGate = new JTable();
		tabellaGate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int t = tabellaGate.getSelectedRow();
				txtCodiceGate.setText(modelloTabellaGate.getValueAt(t, 0).toString());
				txtNumeroPorta.setText(modelloTabellaGate.getValueAt(t, 1).toString());
			}
		});
		modelloTabellaGate.setColumnIdentifiers(colonneTabellaGate);
		tabellaGate.setModel(modelloTabellaGate);
		scrollPaneTabellaGate.setViewportView(tabellaGate);

		scrollPaneTabellaUtilizzi = new JScrollPane();
		scrollPaneTabellaUtilizzi.setFont(controllerUtilizzoGate.fontLabel);
		scrollPaneTabellaUtilizzi.setEnabled(false);
		scrollPaneTabellaUtilizzi.setBounds(358, 85, 702, 330);
		add(scrollPaneTabellaUtilizzi);

		tabellaUtilizzi = new JTable();
		modelloTabellaUtilizzi.setColumnIdentifiers(colonneTabellaUtilizzi);
		tabellaUtilizzi.setModel(modelloTabellaUtilizzi);
		scrollPaneTabellaUtilizzi.setViewportView(tabellaUtilizzi);

		lblNumeroPorta = new JLabel("Numero Porta");
		lblNumeroPorta.setFont(controllerUtilizzoGate.fontLabel);
		lblNumeroPorta.setForeground(controllerUtilizzoGate.coloreScritteTemaScuro);
		lblNumeroPorta.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumeroPorta.setBounds(30, 493, 130, 20);
		add(lblNumeroPorta);

		txtNumeroPorta = new JTextField();
		txtNumeroPorta.setFont(controllerUtilizzoGate.fontScritteGestioni);
		txtNumeroPorta.setForeground(controllerUtilizzoGate.coloreScritteSuBiancoTemaScuro);
		txtNumeroPorta.setColumns(10);
		txtNumeroPorta.setBounds(170, 493, 178, 20);
		add(txtNumeroPorta);

		lblCodiceGate = new JLabel("Codice Gate");
		lblCodiceGate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodiceGate.setFont(controllerUtilizzoGate.fontLabel);
		lblCodiceGate.setForeground(controllerUtilizzoGate.coloreScritteTemaScuro);
		lblCodiceGate.setBounds(30, 461, 130, 20);
		add(lblCodiceGate);

		txtCodiceGate = new JTextField();
		txtCodiceGate.setFont(controllerUtilizzoGate.fontScritteGestioni);
		txtCodiceGate.setForeground(controllerUtilizzoGate.coloreScritteSuBiancoTemaScuro);
		txtCodiceGate.setColumns(10);
		txtCodiceGate.setBounds(170, 462, 178, 20);
		add(txtCodiceGate);

		lblSvuota = new JLabel("");
		lblSvuota.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblSvuota.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerUtilizzoGate.svuotaCampiUtilizzoGate();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				controllerUtilizzoGate.cambioImmagineTema(lblSvuota, img.svuota2TemaChiaro(), img.svuota2());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerUtilizzoGate.cambioImmagineTema(lblSvuota, img.svuota1TemaChiaro(), img.svuota1());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				controllerUtilizzoGate.cambioImmagineTema(lblSvuota, img.svuota3TemaChiaro(), img.svuota3());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				controllerUtilizzoGate.cambioImmagineTema(lblSvuota, img.svuota1TemaChiaro(), img.svuota1());
			}
		});
		lblSvuota.setHorizontalAlignment(SwingConstants.CENTER);
		lblSvuota.setIcon(new ImageIcon(img.svuota1()));
		lblSvuota.setBounds(194, 556, 130, 36);
		add(lblSvuota);

		lblRicaricaTabella = new JLabel("");
		lblRicaricaTabella.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblRicaricaTabella.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				caricaTabella();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				controllerUtilizzoGate.cambioImmagineTema(lblRicaricaTabella, img.aggiorna2TemaChiaro(),
						img.aggiorna2());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerUtilizzoGate.cambioImmagineTema(lblRicaricaTabella, img.aggiorna1TemaChiaro(),
						img.aggiorna1());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				controllerUtilizzoGate.cambioImmagineTema(lblRicaricaTabella, img.aggiorna3TemaChiaro(),
						img.aggiorna3());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				controllerUtilizzoGate.cambioImmagineTema(lblRicaricaTabella, img.aggiorna1TemaChiaro(),
						img.aggiorna1());
			}
		});
		lblRicaricaTabella.setHorizontalAlignment(SwingConstants.CENTER);
		lblRicaricaTabella.setIcon(new ImageIcon(img.aggiorna1()));
		lblRicaricaTabella.setBounds(836, 35, 30, 30);
		add(lblRicaricaTabella);

		lblGiorno = new JLabel("");
		lblGiorno.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblGiorno.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerUtilizzoGate.caricaTabellaUtilizzoGiornaliero();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				controllerUtilizzoGate.cambioImmagineTema(lblGiorno, img.giorno2TemaChiaro(), img.giorno2());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerUtilizzoGate.cambioImmagineTema(lblGiorno, img.giorno1TemaChiaro(), img.giorno1());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				controllerUtilizzoGate.cambioImmagineTema(lblGiorno, img.giorno3TemaChiaro(), img.giorno3());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				controllerUtilizzoGate.cambioImmagineTema(lblGiorno, img.giorno1TemaChiaro(), img.giorno1());
			}
		});
		lblGiorno.setIcon(new ImageIcon(img.giorno1()));
		lblGiorno.setBounds(868, 464, 130, 36);
		add(lblGiorno);

		lblSettimana = new JLabel("");
		lblSettimana.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblSettimana.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerUtilizzoGate.caricaTabellaUtilizzoSettimanale();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				controllerUtilizzoGate.cambioImmagineTema(lblSettimana, img.settimana2TemaChiaro(), img.settimana2());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerUtilizzoGate.cambioImmagineTema(lblSettimana, img.settimana1TemaChiaro(), img.settimana1());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				controllerUtilizzoGate.cambioImmagineTema(lblSettimana, img.settimana3TemaChiaro(), img.settimana3());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				controllerUtilizzoGate.cambioImmagineTema(lblSettimana, img.settimana1TemaChiaro(), img.settimana1());
			}
		});
		lblSettimana.setIcon(new ImageIcon(img.settimana1()));
		lblSettimana.setBounds(868, 510, 130, 36);
		add(lblSettimana);

		lblMese = new JLabel("");
		lblMese.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblMese.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerUtilizzoGate.caricaTabellaUtilizzoMensile();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				controllerUtilizzoGate.cambioImmagineTema(lblMese, img.mese2TemaChiaro(), img.mese2());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerUtilizzoGate.cambioImmagineTema(lblMese, img.mese1TemaChiaro(), img.mese1());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				controllerUtilizzoGate.cambioImmagineTema(lblMese, img.mese3TemaChiaro(), img.mese3());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				controllerUtilizzoGate.cambioImmagineTema(lblMese, img.mese1TemaChiaro(), img.mese1());
			}
		});
		lblMese.setIcon(new ImageIcon(img.mese1()));
		lblMese.setBounds(868, 556, 130, 36);
		add(lblMese);

		dataUtilizzo = new JDateChooser();
		dataUtilizzo.setDateFormatString("dd/MM/yyyy");
		dataUtilizzo.setForeground(controllerUtilizzoGate.coloreScritteSuBiancoTemaScuro);
		dataUtilizzo.setFont(controllerUtilizzoGate.fontScritteGestioni);
		dataUtilizzo.setBounds(500, 461, 121, 20);
		add(dataUtilizzo);

		lblSelezionaData = new JLabel("Seleziona una data per stimare l'utilizzo del gate");
		lblSelezionaData.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelezionaData.setBounds(368, 426, 372, 24);
		lblSelezionaData.setForeground(controllerUtilizzoGate.coloreScritteTemaScuro);
		lblSelezionaData.setFont(controllerUtilizzoGate.fontLabel);
		add(lblSelezionaData);

		lblCalcolaUtilizzo = new JLabel("Calcola utilizzo per:");
		lblCalcolaUtilizzo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCalcolaUtilizzo.setForeground(controllerUtilizzoGate.coloreScritteTemaScuro);
		lblCalcolaUtilizzo.setFont(controllerUtilizzoGate.fontLabel);
		lblCalcolaUtilizzo.setBounds(807, 426, 253, 24);
		add(lblCalcolaUtilizzo);

		caricaTabella();

	}

	// METODI
	public void caricaTabella() {
		try {
			this.ListaGate = controllerUtilizzoGate.implementazioneGateDAO().stampaGate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		modelloTabellaGate.setNumRows(0);
		for (Gate dato : this.ListaGate) {
			this.modelloTabellaGate.addRow(
					new Object[] { dato.getCodiceGate(), dato.getNumeroPorta(), dato.getTempoImbarcoStimato() });
		}
		tabellaGate.setModel(modelloTabellaGate);
	}

	private void ricerca() {
		DefaultTableModel table = (DefaultTableModel) tabellaGate.getModel();
		String ricerca = txtBarraRicerca.getText();
		TableRowSorter<DefaultTableModel> trm = new TableRowSorter<DefaultTableModel>(table);
		tabellaGate.setRowSorter(trm);
		trm.setRowFilter(RowFilter.regexFilter(ricerca));
	}
}
